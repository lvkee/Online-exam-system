package com.sy.dao;

import com.sy.entity.ExamPaper;
import com.sy.entity.other.KeyValue;
import com.sy.viewmodel.admin.exam.ExamPaperPageRequestVM;
import com.sy.viewmodel.student.dashboard.PaperFilter;
import com.sy.viewmodel.student.dashboard.PaperInfo;
import com.sy.viewmodel.student.exam.ExamPaperPageVM;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

//@Mapper
public interface ExamPaperMapper extends BaseMapper<ExamPaper> {

    List<ExamPaper> page(ExamPaperPageRequestVM requestVM);

    List<ExamPaper> taskExamPage(ExamPaperPageRequestVM requestVM);

    List<ExamPaper> studentPage(ExamPaperPageVM requestVM);

    List<PaperInfo> indexPaper(PaperFilter paperFilter);

    Integer selectAllCount();

    List<KeyValue> selectCountByDate(@Param("startTime") Date startTime, @Param("endTime") Date endTime);

    int updateTaskPaper(@Param("taskId") Integer taskId,@Param("paperIds") List<Integer> paperIds);

    int clearTaskPaper(@Param("paperIds") List<Integer> paperIds);
}
