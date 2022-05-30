package com.sy.dao;

import com.sy.entity.UserEventLog;
import com.sy.entity.other.KeyValue;
import com.sy.viewmodel.admin.user.UserEventPageRequestVM;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

//@Mapper
public interface UserEventLogMapper extends BaseMapper<UserEventLog> {

    List<UserEventLog> getUserEventLogByUserId(Integer id);

    List<UserEventLog> page(UserEventPageRequestVM requestVM);

    List<KeyValue> selectCountByDate(@Param("startTime") Date startTime, @Param("endTime") Date endTime);
}
