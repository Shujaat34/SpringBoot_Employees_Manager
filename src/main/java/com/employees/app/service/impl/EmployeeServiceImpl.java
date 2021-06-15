package com.employees.app.service.impl;

import com.employees.app.bean.EmployeeBean;
import com.employees.app.exception.UserNotFoundException;
import com.employees.app.model.Employee;
import com.employees.app.repository.EmployeeRepository;
import com.employees.app.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeBean saveEmployee(EmployeeBean employeeBean) {
        employeeBean.setEmployeeCode(UUID.randomUUID().toString());
        Employee employee = mapper.map(employeeBean, Employee.class);
        employee = employeeRepository.save(employee);
        return mapper.map(employee, EmployeeBean.class);
    }

    @Override
    public EmployeeBean updateEmployee(EmployeeBean employeeBean) {
        Employee employee = mapper.map(employeeBean, Employee.class);
        employee = employeeRepository.save(employee);
        return mapper.map(employee, EmployeeBean.class);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeBean> findAllEmployees() {
        return employeeRepository.findAll().stream().map(employee -> mapper.map(employee,EmployeeBean.class)).collect(Collectors.toList());
    }

    @Override
    public EmployeeBean findEmployeeById(Long id) throws UserNotFoundException {
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isPresent()){
            Employee employee = optional.get();
            return mapper.map(employee,EmployeeBean.class);
        }else{
            throw new UserNotFoundException("Employee not Found with Id "+id);
        }
    }


}
