package com.sy.dao;


import com.sy.entity.TaskExam;
import com.sy.viewmodel.admin.task.TaskPageRequestVM;

import java.util.List;

//@Mapper
public interface TaskExamMapper extends BaseMapper<TaskExam> {

    List<TaskExam> page(TaskPageRequestVM requestVM);

    List<TaskExam> getByGradeLevel(Integer gradeLevel);
}
