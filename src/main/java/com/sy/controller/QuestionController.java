package com.sy.controller;

import com.sy.base.BaseApiController;
import com.github.pagehelper.PageInfo;
import com.sy.base.RestResponse;
import com.sy.domain.TextContent;
import com.sy.domain.question.QuestionObject;
import com.sy.entity.Question;
import com.sy.entity.Student;
import com.sy.service.QuestionService;
import com.sy.service.StudentService;
import com.sy.service.TextContentService;
import com.sy.util.*;
import com.sy.viewmodel.admin.question.QuestionPageRequestVM;
import com.sy.viewmodel.admin.question.QuestionResponseVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.xml.ws.Response;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @author chris
 */
@Controller
@RequestMapping(value = "/api/admin/questions")
public class QuestionController extends BaseController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private TextContentService textContentService;

    @Autowired
    public QuestionController(QuestionService questionService, TextContentService textContentService) {
        this.questionService = questionService;
        this.textContentService = textContentService;
    }

    /*@RequestMapping(value = "/toIndex")
    public String toIndex() {
        return "admin/html/index";
    }

    @RequestMapping(value = "/toTable")
    public String toTable() {
        return "admin/html/table-student";
    }

    @RequestMapping(value = "/loginCheck")
    public String loginCheck(@Valid Student student, Model model) {
        System.out.println("ִ执行 loginCheck");
        System.out.println(student.toString());
        model.addAttribute("student", student);
        return studentService.loginCheck(student.getsName(), student.getsPwd(), student.getsBirth());
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public ModelAndView addStudent(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getFieldError().getField());
            return new ModelAndView("redirect:/student/toIndex");
        }
        boolean result = studentService.addStudent(student.getsName(), student.getsNickname(), student.getsPwd(), student.getsEmail(), student.getsBirth());
        if (result) {
            return new ModelAndView("redirect:/student/students");
        } else {
            return new ModelAndView("redirect:/student/toIndex");
        }
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.POST)
    public ModelAndView updateStudent(@Valid @ModelAttribute("student") Student student) {
        boolean result = studentService.updateStudent(student.getsId(), student.getsName(), student.getsNickname(), student.getsPwd(), student.getsEmail(), student.getsUpdateDate(), student.getsBirth());
        if (result) {
            return new ModelAndView("redirect:/student/students");
        } else {
            return new ModelAndView("redirect:/student/toIndex");
        }
    }

    @RequestMapping(value = "queryStudent/{sId}", method = RequestMethod.GET)
    public void queryStudent(@Valid @PathVariable int sId, Model model, HttpServletResponse response) throws IOException {
        String student = studentService.queryStudent(sId);
        if (student != null) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter wirte = response.getWriter();
            wirte.print(student);
            wirte.flush();
            wirte.close();
        }
    }

    @RequestMapping(value = "deleteStudent/{sId}", method = RequestMethod.GET)
    public ModelAndView deleteStudent(@PathVariable int sId) {
        boolean result = studentService.deleteStudent(sId);
        if (result) {
            return new ModelAndView("redirect:/student/students");
        } else {
            return new ModelAndView("redirect:/student/toIndex");
        }
    }*/

    /*@RequestMapping(value = "/page", method = RequestMethod.GET)
    public String showMyProduct(HttpServletRequest request, Model model) {
        this.questionService.showQuestionsByPage(request, model);
        return "/admin/html/table-student";
    }*/

    @RequestMapping(value = "/page", method = RequestMethod.POST)
    public RestResponse<PageInfo<QuestionResponseVM>> pageList(@RequestBody QuestionPageRequestVM model) {
        System.out.println("model : " + model.toString());
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
        System.out.println("page.toString()" + page.toString());
        return RestResponse.ok(page);
    }
}
