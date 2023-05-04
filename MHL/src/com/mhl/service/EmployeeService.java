package com.mhl.service;

import com.mhl.dao.EmployeeDAO;
import com.mhl.daomain.Employee;

public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    public Employee getEmployeeByAndPwd(String empId, String pwd){
        Employee employee = employeeDAO.querySingle("select * from employee WHERE empId=? and pwd=MD5(?)", Employee.class, empId, pwd);
        return employee;
    }
}
