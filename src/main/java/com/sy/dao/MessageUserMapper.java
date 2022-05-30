package com.sy.dao;


import com.sy.entity.MessageUser;
import com.sy.viewmodel.student.user.MessageRequestVM;

import java.util.List;

//@Mapper
public interface MessageUserMapper extends BaseMapper<MessageUser> {

    List<MessageUser> selectByMessageIds(List<Integer> ids);

    int inserts(List<MessageUser> list);

    List<MessageUser> studentPage(MessageRequestVM requestVM);

    Integer unReadCount(Integer userId);
}
