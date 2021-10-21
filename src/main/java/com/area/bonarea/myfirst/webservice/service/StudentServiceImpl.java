/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.bonarea.myfirst.webservice.service;

import com.area.bonarea.myfirst.webservice.dao.StudentDao;
import com.area.bonarea.myfirst.webservice.model.Student;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;

/**
 *
 * @author xavier.verges
 */
@Dependent
public class StudentServiceImpl implements StudentService {

    private static final Logger LOG = Logger.getLogger(StudentServiceImpl.class.getName());

    @Inject
    private StudentDao studentDao;

    @Override
    public Student create(Student student) throws SQLException {
        LOG.info("StudentServiceImpl create method is called");
        Student obj = this.studentDao.create(student);
        LOG.info("StudentServiceImpl create method is finishied");
        return obj;
    }
}
