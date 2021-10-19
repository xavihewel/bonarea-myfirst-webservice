/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.bonarea.myfirst.webservice.dao;

import com.area.bonarea.myfirst.webservice.model.Student;
import java.sql.SQLException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author xavier.verges
 */
public class StudentDaoUnitTest {
    
    Student student;
    Student insertedStudent;
    
    @Mock
    StudentDao studentDao;
    
    @Before
    public void setUp() throws SQLException {
        student = new Student();
        student.setName("Pepe");
        student.setSurname("Soto");
        student.setEmail("pepe@gmail.com");
        studentDao = mock(StudentDao.class);
        
        insertedStudent = new Student();
        insertedStudent.setName("Pepe");
        insertedStudent.setSurname("Soto");
        insertedStudent.setEmail("pepe@gmail.com");
        insertedStudent.setStudentId(1L);

        //Stubbing
        when(studentDao.create(student)).thenReturn(insertedStudent);
    }

    /**
     * Test of create method, of class StudentDao.
     */
    @Test
    public void testCreate() throws SQLException {
        Student expectedStudent = studentDao.create(student);
        verify(studentDao).create(student);
        Assert.assertTrue(expectedStudent.getStudentId() > 0);
    }
}
