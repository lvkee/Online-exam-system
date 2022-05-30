package com.sy.dao;


import com.sy.entity.Message;
import com.sy.viewmodel.admin.message.MessagePageRequestVM;

import java.util.List;

//@Mapper
public interface MessageMapper extends BaseMapper<Message> {

    List<Message> page(MessagePageRequestVM requestVM);

    List<Message> selectByIds(List<Integer> ids);

    int readAdd(Integer id);
}
