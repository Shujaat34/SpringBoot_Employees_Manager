package com.employees.app.controller;

import com.employees.app.bean.EmployeeBean;
import com.employees.app.exception.UserNotFoundException;
import com.employees.app.service.EmployeeService;
import com.employees.app.uri.URIs;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @GetMapping(URIs.ALL)
    public ResponseEntity<List<EmployeeBean>> getAllEmployees(){
        List<EmployeeBean> list = employeeService.findAllEmployees();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeBean>getEmployee(@PathVariable("id") Long id) throws UserNotFoundException {
        EmployeeBean employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping(URIs.ADD)
    public ResponseEntity<EmployeeBean> saveEmployee(@RequestBody EmployeeBean employeeBean) {
        EmployeeBean empbean = employeeService.saveEmployee(employeeBean);
        return new ResponseEntity<>(empbean, HttpStatus.CREATED);
    }

    @PutMapping(URIs.UPDATE)
    public ResponseEntity<EmployeeBean> updateEmployee(@RequestBody EmployeeBean employeeBean) {
        EmployeeBean empbean = employeeService.updateEmployee(employeeBean);
        return new ResponseEntity<>(empbean, HttpStatus.OK);
    }

    @PutMapping(URIs.DELETE+"/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}
