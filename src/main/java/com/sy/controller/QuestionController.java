package com.sy.controller;

import com.google.gson.Gson;
import com.sy.base.BaseApiController;
import com.github.pagehelper.PageInfo;
import com.sy.entity.TextContent;
import com.sy.entity.question.QuestionObject;
import com.sy.entity.Question;
import com.sy.service.QuestionService;
import com.sy.service.TextContentService;
import com.sy.util.*;
import com.sy.viewmodel.admin.question.QuestionPageRequestVM;
import com.sy.viewmodel.admin.question.QuestionResponseVM;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 题目操作
 *
 * @author chris
 * @date 2022/05/28
 */
@Controller
@RequestMapping(value = "/admin/questions")
public class QuestionController extends BaseApiController {

    private Session session;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private TextContentService textContentService;

    /**
     * 获取题目分页数据
     * 1. ajax 的 contentType 设置为 application/json , method 设置为 POST
     *
     * @param model ajax 中定义的分页请求内容
     * @return 题目分页的 JSON 数据
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    @ResponseBody
    public String pageList(@RequestBody QuestionPageRequestVM model) {
        PageInfo<Question> pageInfo = questionService.page(model);
        PageInfo<QuestionResponseVM> page = PageInfoHelper.copyMap(pageInfo, q -> {
            QuestionResponseVM vm = modelMapper.map(q, QuestionResponseVM.class);
            vm.setCreateTime(DateTimeUtil.dateFormat(q.getCreateTime()));
            vm.setScore(ExamUtil.scoreToVM(q.getScore()));
            TextContent textContent = textContentService.selectById(q.getInfoTextContentId());
            QuestionObject questionObject = JsonUtil.toJsonObject(textContent.getContent(), QuestionObject.class);
            String clearHtml = HtmlUtil.clear(questionObject.getTitleContent());
            vm.setShortTitle(clearHtml);
            return vm;
        });
        return JsonUtil.toJsonStr(page);
    }

    /**
     * 题目分页，将 JSON 反序列化为对象并添加至 model
     *
     * @param page  隐藏域 form 中 input 的内容
     * @param model
     * @return 题目分页视图
     */
    @RequestMapping(value = "/show", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
    public String toPage(@ModelAttribute("questionFormJson") String page, Model model) {
        Gson gson = new Gson();
//        泛型对象解析
        PageInfo pageInfo = gson.fromJson(page, new TypeToken<PageInfo<QuestionResponseVM>>() {
        }.getType());
        model.addAttribute("page", pageInfo);
        return "/admin/html/table-questions";
    }
}
