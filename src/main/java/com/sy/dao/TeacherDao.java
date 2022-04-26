package com.sy.dao;

import com.sy.entity.Teacher;

public interface TeacherDao {

    Teacher findByName(String tname);

}
