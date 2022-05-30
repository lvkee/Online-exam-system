package com.sy.dao;

import com.sy.entity.ExamPaperQuestionCustomerAnswer;
import com.sy.entity.other.ExamPaperAnswerUpdate;
import com.sy.entity.other.KeyValue;
import com.sy.viewmodel.student.question.answer.QuestionPageStudentRequestVM;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

//@Mapper
public interface ExamPaperQuestionCustomerAnswerMapper extends BaseMapper<ExamPaperQuestionCustomerAnswer> {

    List<ExamPaperQuestionCustomerAnswer> selectListByPaperAnswerId(Integer id);

    List<ExamPaperQuestionCustomerAnswer> studentPage(QuestionPageStudentRequestVM requestVM);

    int insertList(List<ExamPaperQuestionCustomerAnswer> list);

    Integer selectAllCount();

    List<KeyValue> selectCountByDate(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    int updateScore(List<ExamPaperAnswerUpdate> examPaperAnswerUpdates);
}
