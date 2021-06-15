package com.employees.app.service;

import com.employees.app.bean.EmployeeBean;
import com.employees.app.exception.UserNotFoundException;

import java.util.List;

public interface EmployeeService {
    EmployeeBean saveEmployee(EmployeeBean employeeBean);
    EmployeeBean updateEmployee(EmployeeBean employeeBean);
    void deleteEmployeeById(Long id);
    List<EmployeeBean> findAllEmployees();
    EmployeeBean findEmployeeById(Long id) throws UserNotFoundException;
}
