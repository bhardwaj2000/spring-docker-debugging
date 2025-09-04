package com.mks.docker.debugging.repo;

import com.mks.docker.debugging.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeRepo {

    public List<Employee> getAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Amit Sharma", "amit.sharma@company.com", "IT"));
        employees.add(new Employee(102, "Neha Verma", "neha.verma@company.com", "HR"));
        employees.add(new Employee(103, "Rohit Singh", "rohit.singh@company.com", "Finance"));
        employees.add(new Employee(104, "Priya Mehta", "priya.mehta@company.com", "Marketing"));
        employees.add(new Employee(105, "Suresh Kumar", "suresh.kumar@company.com", "Sales"));
        employees.add(new Employee(106, "Anita Desai", "anita.desai@company.com", "Operations"));

        return employees;
    }

    public List<String> getAllEmails(String dept) {
        return getAllEmployee().stream().filter(employee -> dept.equals(employee.dept()))
                .map(Employee::email)
                .toList();
    }

}