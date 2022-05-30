package com.sy.dao;


import com.sy.entity.Subject;
import com.sy.viewmodel.admin.education.SubjectPageRequestVM;

import java.util.List;

//@Mapper
public interface SubjectMapper  extends BaseMapper<Subject> {

    List<Subject> getSubjectByLevel(Integer level);

    List<Subject> allSubject();

    List<Subject> page(SubjectPageRequestVM requestVM);
}
