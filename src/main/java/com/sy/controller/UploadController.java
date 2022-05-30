package com.sy.controller;

import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import com.sy.entity.FileEntity;
import com.sy.entity.Question;
import com.sy.entity.TextContent;
import com.sy.entity.question.QuestionObject;
import com.sy.service.FileService;
import com.sy.util.*;
import com.sy.viewmodel.admin.file.FilePageRequestVM;
import com.sy.viewmodel.admin.file.FileResponseVM;
import com.sy.viewmodel.admin.question.QuestionPageRequestVM;
import com.sy.viewmodel.admin.question.QuestionResponseVM;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.sy.base.BaseApiController;


import java.util.List;

/**
 * 文件上传
 */
@Controller
@RequestMapping(value = "/file/fileUtil")
public class UploadController extends BaseApiController {

    @Autowired
    private FileService fileService;

    /**
     *  文件上传，ajax 方式
     * @param file
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/FileUpload", method = RequestMethod.POST)
    public List<FileEntity> FileUpload(@RequestParam(value = "file", required = false) MultipartFile[] file) {
        List<FileEntity> fileList = FileUpload.uploadFiles(file);
        for (FileEntity fileEntities : fileList) {
            fileService.insert(fileEntities);
        }
        return fileList;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable Integer id) {
        fileService.deleteById(id);
        return "/admin/html/table-files";
    }

    /**
     * 获取题目分页数据
     * 1. ajax 的 contentType 设置为 application/json , method 设置为 POST
     *
     * @param model ajax 中定义的分页请求内容
     * @return 文件分页的 JSON 数据
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String pageList(@RequestBody FilePageRequestVM model) {
        PageInfo<FileEntity> pageInfo = fileService.page(model);
        PageInfo<FileResponseVM> page = PageInfoHelper.copyMap(pageInfo, q -> {
            FileResponseVM vm = modelMapper.map(q, FileResponseVM.class);
            vm.setCreateTime(DateTimeUtil.dateShortFormat(q.getCreateTime()));
            return vm;
        });
        String s = JsonUtil.toJsonStr(page);
        System.out.println("s : " + s);
        return s;
    }

    /**
     * 文件分页，将 JSON 反序列化为对象并添加至 model
     *
     * @param page  隐藏域 form 中 input 的内容
     * @param model
     * @return 文件分页视图
     */
    @RequestMapping(value = "/show", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String toPage(@ModelAttribute("FormJson") String page, Model model) {
        System.out.println("str page : " + page);
        Gson gson = new Gson();
//        泛型对象解析
        PageInfo pageInfo = gson.fromJson(page, new TypeToken<PageInfo<FileResponseVM>>() {
        }.getType());
        System.out.println("page : " + pageInfo);
        model.addAttribute("page", pageInfo);
        return "/admin/html/table-files";
    }
}