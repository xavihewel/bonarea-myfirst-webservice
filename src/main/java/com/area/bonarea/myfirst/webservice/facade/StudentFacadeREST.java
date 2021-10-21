/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.area.bonarea.myfirst.webservice.facade;

import com.area.bonarea.myfirst.webservice.model.Student;
import com.area.bonarea.myfirst.webservice.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author xavier.verges
 */
@Stateless
@Path("StudentFacadeREST")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Api(value = "Example StudentFacadeREST", protocols = "http")
public class StudentFacadeREST {

    private static final Logger LOG = Logger.getLogger(StudentFacadeREST.class.getName());

    @Inject
    private StudentService studentService;

    @POST
    @ApiOperation(value = "Insert a new Student",
            notes = "This mothod will insert a new Student to database and "
            + "return the Student inserted in json format",
            response = Student.class)
    @ApiResponses({
        @ApiResponse(code = 200, message = "Inserted"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public Student create(@ApiParam(required = true) Student entity) {
        LOG.info("StudentFacadeRest create method is called");
        Student insertedStudent = null;
        try {
            insertedStudent = this.studentService.create(entity);
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, ex.getMessage(), ex);
            LOG.log(Level.INFO, "Student: {0}", entity);
            throw new InternalServerErrorException(ex.getMessage());
        }
        LOG.info("StudentFacadeRest create method is finished");
        return insertedStudent;
    }

    @PUT
    @Path("{id}")
    @ApiOperation(value = "Updates an existeing Student",
            response = Student.class)
    @ApiResponses({
        @ApiResponse(code = 200, message = "Updated"),
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public void edit(@ApiParam(required = true) @PathParam("id") Integer id,
            @ApiParam(required = true) Student entity) {

    }

    @DELETE
    @Path("{id}")
    @ApiOperation(value = "Remove an existeing Student")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Removed"),
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public void remove(@ApiParam(required = true) @PathParam("id") Integer id) {

    }

    @GET
    @Path("{id}")
    @ApiOperation(value = "Find a Student in the database by Id",
            notes = "This will return Student json to the client",
            response = Student.class)
    @ApiResponses({
        @ApiResponse(code = 200, message = "Found"),
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public Student find(@ApiParam(required = true) @PathParam("id") Integer id) {
        Student student = null;
        try {
            if (student == null) {
                throw new NotFoundException();
            }
        } catch (Exception ex) {
            throw new InternalServerErrorException(ex.getMessage());
        }
        return student;
    }
    
    
    @GET
    @ApiOperation(value = "Fetch all the students",
            response = Student.class, responseContainer = "List")
    @ApiResponses({
        @ApiResponse(code = 200, message = "Success"),
        @ApiResponse(code = 404, message = "Not found"),
        @ApiResponse(code = 500, message = "Internal Server Error")
    })
    public List<Student> findAll(){
        LOG.info("StudentFacadeREST findAll method is called");
        List<Student> studentList = new ArrayList<>();
        Student student1 = new Student();
        try{
            student1.setName("Pepe");
            student1.setSurname("Soto");
        }catch (Exception ex) {
            
        }
        LOG.info("StudentFacadeREST findAll method is finished");
        return studentList;
    }
}
