/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.bonarea.myfirst.webservice.dao;

import com.area.bonarea.myfirst.webservice.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;
import javax.enterprise.context.Dependent;
import javax.sql.DataSource;

/**
 *
 * @author xavier.verges
 */
@Dependent
public class StudentDaoImpl implements StudentDao {

    private static final Logger LOG = Logger.getLogger(StudentDaoImpl.class.getName());

    private DataSource dataSource;

    public StudentDaoImpl(@DefaultDataSource DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Student create(Student student) throws SQLException {
        LOG.info("StudentDaoImpl add method is called");

        Student insertedStudent = new Student();
        try ( Connection conn = dataSource.getConnection();  PreparedStatement ps = conn.prepareStatement("Insert into Student "
                + "(firstname, lastname, email) values (?,?,?", Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getSurname());
            ps.setString(3, student.getEmail());
            ps.executeUpdate();

            try ( ResultSet keys = ps.getGeneratedKeys()) {
                keys.next();
                Long returnedKey = keys.getLong(1);
                insertedStudent.setStudentId(returnedKey);
                insertedStudent.setSurname(student.getSurname());
                insertedStudent.setName(student.getName());
                insertedStudent.setEmail(student.getEmail());
            }
        }
        LOG.info("StudentDaoImpl add method is finished");
        return insertedStudent;
    }

}
