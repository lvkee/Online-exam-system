package com.sy.service;



import com.github.pagehelper.PageInfo;
import com.sy.entity.Question;
import com.sy.viewmodel.admin.question.QuestionPageRequestVM;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 试题服务接口
 * @author chris
 */
public interface QuestionService extends BaseService<Question> {

    /**
     * 分页显示题目
     * @param request request
     * @param model model
     */
    void showQuestionsByPage(HttpServletRequest request, Model model);

    PageInfo<Question> page(QuestionPageRequestVM requestVM);

    /*Question insertFullQuestion(QuestionEditRequestVM model, Integer userId);

    Question updateFullQuestion(QuestionEditRequestVM model);

    QuestionEditRequestVM getQuestionEditRequestVM(Integer questionId);

    QuestionEditRequestVM getQuestionEditRequestVM(Question question);*/

//    Integer selectAllCount();
//
//    List<Integer> selectMothCount();
}
