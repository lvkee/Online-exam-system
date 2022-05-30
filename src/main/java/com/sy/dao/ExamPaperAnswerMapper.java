package com.sy.dao;


import com.sy.entity.ExamPaperAnswer;
import com.sy.entity.other.KeyValue;
import com.sy.viewmodel.admin.paper.ExamPaperAnswerPageRequestVM;
import com.sy.viewmodel.student.exampaper.ExamPaperAnswerPageVM;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

//@Mapper
public interface ExamPaperAnswerMapper extends BaseMapper<ExamPaperAnswer> {

    List<ExamPaperAnswer> studentPage(ExamPaperAnswerPageVM requestVM);

    Integer selectAllCount();

    List<KeyValue> selectCountByDate(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    ExamPaperAnswer getByPidUid(@Param("pid") Integer paperId, @Param("uid") Integer uid);

    List<ExamPaperAnswer> adminPage(ExamPaperAnswerPageRequestVM requestVM);
}
