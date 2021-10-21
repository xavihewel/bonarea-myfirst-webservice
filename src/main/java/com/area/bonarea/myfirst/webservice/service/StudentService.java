/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.bonarea.myfirst.webservice.service;

import com.area.bonarea.myfirst.webservice.model.Student;
import java.sql.SQLException;

/**
 *
 * @author xavier.verges
 */
public interface StudentService {

    Student create(Student student) throws SQLException;
}
