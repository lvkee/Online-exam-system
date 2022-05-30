package com.sy.dao;

import com.sy.entity.other.KeyValue;
import com.sy.entity.Question;
import com.sy.viewmodel.admin.question.QuestionPageRequestVM;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

//@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

    List<Question> page(QuestionPageRequestVM requestVM);

    List<Question> selectByIds(@Param("ids") List<Integer> ids);

    Integer selectAllCount();

    List<KeyValue> selectCountByDate(@Param("startTime") Date startTime, @Param("endTime") Date endTime);
}
