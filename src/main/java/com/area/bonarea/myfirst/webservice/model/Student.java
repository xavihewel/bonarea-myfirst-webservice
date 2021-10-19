/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.bonarea.myfirst.webservice.model;
import java.io.Serializable;
//import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author xavier.verges
 */
//@XmlRootElement(name = "Student")
public class Student implements Serializable {

    private long studentId;
    private String name;
    private String surname;
    private String email;

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

//    @XmlElement(name="email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
