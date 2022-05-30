package com.sy.service;

import com.github.pagehelper.PageInfo;
import com.sy.entity.Subject;
import com.sy.viewmodel.admin.education.SubjectPageRequestVM;

import java.util.List;

public interface SubjectService extends BaseService<Subject> {

    List<Subject> getSubjectByLevel(Integer level);

    List<Subject> allSubject();

    Integer levelBySubjectId(Integer id);

    PageInfo<Subject> page(SubjectPageRequestVM requestVM);
}
