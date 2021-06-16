package com.employees.app.controller;

import com.employees.app.bean.EmployeeBean;
import com.employees.app.exception.UserNotFoundException;
import com.employees.app.service.EmployeeService;
import com.employees.app.uri.URIs;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(URIs.EMPLOYEE)
@Api(tags = "Employee Api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @ApiOperation(value = "Get All Employees", response = ResponseEntity.class)
    @GetMapping(value = URIs.ALL , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeBean>> getAllEmployees(){
        List<EmployeeBean> list = employeeService.findAllEmployees();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @ApiOperation(value = "Get Employee by ID", response = ResponseEntity.class)
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeBean>getEmployee(@PathVariable("id") Long id) throws UserNotFoundException {
        EmployeeBean employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @ApiOperation(value = "Add An Employee", response = ResponseEntity.class)
    @PostMapping(value = URIs.ADD, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeBean> saveEmployee(@RequestBody EmployeeBean employeeBean) {
        EmployeeBean empbean = employeeService.saveEmployee(employeeBean);
        return new ResponseEntity<>(empbean, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Update An Employee", response = ResponseEntity.class)
    @PutMapping(value = URIs.UPDATE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeBean> updateEmployee(@RequestBody EmployeeBean employeeBean) {
        EmployeeBean empbean = employeeService.updateEmployee(employeeBean);
        return new ResponseEntity<>(empbean, HttpStatus.OK);
    }


    @ApiOperation(value = "Delete An Employee", response = ResponseEntity.class)
    @DeleteMapping(URIs.DELETE+"/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
