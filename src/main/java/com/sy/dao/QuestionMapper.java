package com.sy.dao;

import com.sy.entity.Question;
import com.sy.entity.Student;
import com.sy.viewmodel.admin.question.QuestionPageRequestVM;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author chris
 */
//@Mapper
public interface QuestionMapper extends BaseMapper<Question> {

    /**
     * 使用注释方法传入多个参数，题目分页
     * @param startPos 起始位置
     * @param pageSize 每页容量
     * @return 题目集合
     */
    public List<Question> selectQuestions(@Param(value="startPos") Integer startPos, @Param(value="pageSize") Integer pageSize);

    List<Question> page(QuestionPageRequestVM requestVM);

    List<Question> selectByIds(@Param("ids") List<Integer> ids);

    /**
     *
     * @return
     */
    Integer selectAllCount();

//    List<KeyValue> selectCountByDate(@Param("startTime") Date startTime,@Param("endTime") Date endTime);
}
