package com.employees.app.model;

import javax.persistence.Entity;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;
    private String employeeCode;

}
