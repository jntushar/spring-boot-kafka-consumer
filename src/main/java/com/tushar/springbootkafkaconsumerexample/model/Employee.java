package com.tushar.springbootkafkaconsumerexample.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String contactNo;
    private String department;
    private Double salary;

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contactNo='" + contactNo + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
