/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.bonarea.myfirst.webservice.service;

import com.area.bonarea.myfirst.webservice.dao.StudentDao;
import com.area.bonarea.myfirst.webservice.model.Student;
import java.sql.SQLException;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author xavier.verges
 */
@Dependent
public class StudentServiceImpl implements StudentService {

    @Inject
    private StudentDao studentDao;

    @Override
    public Student create(Student student) throws SQLException {
        return this.studentDao.create(student);
    }
}
