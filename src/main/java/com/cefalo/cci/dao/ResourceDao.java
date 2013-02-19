package com.cefalo.cci.dao;

import com.cefalo.cci.domain.Employee;
import com.cefalo.cci.domain.User;

import java.util.List;

public interface ResourceDao {
    public void saveUserInfo(User user);
    void saveEmployee(Employee employee);
    List getAllEmployee();
    Employee getEmployeeByUserName(String userName);
    void deleteEmployee(Employee employee);
}
