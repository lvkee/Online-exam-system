package com.sy.dao;

import com.sy.entity.TaskExamCustomerAnswer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//@Mapper
public interface TaskExamCustomerAnswerMapper extends BaseMapper<TaskExamCustomerAnswer> {

    TaskExamCustomerAnswer getByTUid(@Param("tid") Integer tid, @Param("uid") Integer uid);

    List<TaskExamCustomerAnswer> selectByTUid(@Param("taskIds") List<Integer> taskIds, @Param("uid") Integer uid);
}
