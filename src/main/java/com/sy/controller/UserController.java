package com.sy.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.sy.base.BaseApiController;
import com.sy.base.RestResponse;
import com.sy.entity.User;
import com.sy.entity.enums.UserStatusEnum;
import com.sy.service.AuthenticationService;
import com.sy.service.UserService;
import com.sy.util.JsonUtil;
import com.sy.util.PageInfoHelper;
import com.sy.viewmodel.admin.file.FileResponseVM;
import com.sy.viewmodel.admin.user.UserCreateVM;
import com.sy.viewmodel.admin.user.UserPageRequestVM;
import com.sy.viewmodel.admin.user.UserResponseVM;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/admin/user")
public class UserController extends BaseApiController {

    private final UserService userService;
//    private final UserEventLogService userEventLogService;
    private final AuthenticationService authenticationService;

    /*@Autowired
    public UserController(UserService userService, UserEventLogService userEventLogService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.userEventLogService = userEventLogService;
        this.authenticationService = authenticationService;
    }*/

    @Autowired
    public UserController(UserService userService, AuthenticationService authenticationService) {
        this.userService = userService;
        this.authenticationService = authenticationService;
    }


    @RequestMapping(value = "/page/list", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String pageList(@RequestBody UserPageRequestVM model) {
        System.out.println("model : " + model);
        PageInfo<User> pageInfo = userService.userPage(model);
        PageInfo<UserResponseVM> page = PageInfoHelper.copyMap(pageInfo, d -> UserResponseVM.from(d));
        return JsonUtil.toJsonStr(page);
    }

    /**
     * 用户分页，将 JSON 反序列化为对象并添加至 model
     *
     * @param page  隐藏域 form 中 input 的内容
     * @param model
     * @return 用户分页视图
     */
    @RequestMapping(value = "/show", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String toPage(@ModelAttribute("FormJson") String page, Model model) {
        System.out.println("str page : " + page);
        Gson gson = new Gson();
//        泛型对象解析
        PageInfo pageInfo = gson.fromJson(page, new TypeToken<PageInfo<UserResponseVM>>() {
        }.getType());
        model.addAttribute("page", pageInfo);
        System.out.println("page : " + pageInfo);
        return "/admin/html/table-users";
    }


    /*@RequestMapping(value = "/event/page/list", method = RequestMethod.POST)
    public RestResponse<PageInfo<UserEventLogVM>> eventPageList(@RequestBody UserEventPageRequestVM model) {
        PageInfo<UserEventLog> pageInfo = userEventLogService.page(model);
        PageInfo<UserEventLogVM> page = PageInfoHelper.copyMap(pageInfo, d -> {
            UserEventLogVM vm = modelMapper.map(d, UserEventLogVM.class);
            vm.setCreateTime(DateTimeUtil.dateFormat(d.getCreateTime()));
            return vm;
        });
        return RestResponse.ok(page);
    }*/

    @RequestMapping(value = "/select/{id}", method = RequestMethod.POST)
    public RestResponse<UserResponseVM> select(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        UserResponseVM userVm = UserResponseVM.from(user);
        return RestResponse.ok(userVm);
    }

    /*@RequestMapping(value = "/current", method = RequestMethod.POST)
    public RestResponse<UserResponseVM> current() {
        User user = getCurrentUser();
        UserResponseVM userVm = UserResponseVM.from(user);
        return RestResponse.ok(userVm);
    }*/


    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public RestResponse<User> add(@RequestBody @Valid UserCreateVM model) {
        System.out.println("model : " + model.toString());
        if (model.getId() == null) {
            User existUser = userService.getUserByUserName(model.getUserName());
            if (null != existUser) {
                return new RestResponse<>(2, "用户已存在");
            }

            if (StringUtils.isBlank(model.getPassword())) {
                return new RestResponse<>(3, "密码不能为空");
            }
        }
        if (StringUtils.isBlank(model.getBirthDay())) {
            model.setBirthDay(null);
        }
        User user = modelMapper.map(model, User.class);
        System.out.println("user : " + user.toString());
        if (model.getId() == null) {
            String encodePwd = authenticationService.pwdEncode(model.getPassword());
            user.setPassword(encodePwd);
            user.setUserUuid(UUID.randomUUID().toString());
            user.setCreateTime(new Date());
            user.setLastActiveTime(new Date());
            user.setDeleted(false);
            user.setStatus(1);
            userService.insertByFilter(user);
        } else {
            if (!StringUtils.isBlank(model.getPassword())) {
                String encodePwd = authenticationService.pwdEncode(model.getPassword());
                user.setPassword(encodePwd);
            }
            user.setModifyTime(new Date());
            userService.updateByIdFilter(user);
        }
        System.out.println("user 3: " + user.toString());
        return RestResponse.ok(user);
    }


    /*@RequestMapping(value = "/update", method = RequestMethod.POST)
    public RestResponse update(@RequestBody @Valid UserUpdateVM model) {
        User user = userService.selectById(getCurrentUser().getId());
        modelMapper.map(model, user);
        user.setModifyTime(new Date());
        userService.updateByIdFilter(user);
        return RestResponse.ok();
    }*/


    @RequestMapping(value = "/changeStatus/{id}", method = RequestMethod.POST)
    public RestResponse<Integer> changeStatus(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        UserStatusEnum userStatusEnum = UserStatusEnum.fromCode(user.getStatus());
        Integer newStatus = userStatusEnum == UserStatusEnum.Enable ? UserStatusEnum.Disable.getCode() : UserStatusEnum.Enable.getCode();
        user.setStatus(newStatus);
        user.setModifyTime(new Date());
        userService.updateByIdFilter(user);
        return RestResponse.ok(newStatus);
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public RestResponse delete(@PathVariable Integer id) {
        User user = userService.getUserById(id);
        user.setDeleted(true);
        userService.updateByIdFilter(user);
        return RestResponse.ok();
    }


    /*@RequestMapping(value = "/selectByUserName", method = RequestMethod.POST)
    public RestResponse<List<KeyValue>> selectByUserName(@RequestBody String userName) {
        List<KeyValue> keyValues = userService.selectByUserName(userName);
        return RestResponse.ok(keyValues);
    }*/

}
