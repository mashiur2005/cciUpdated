package com.cefalo.cci.dao;

import com.cefalo.cci.domain.Employee;
import com.cefalo.cci.domain.User;
import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class ResourceDaoImpl implements ResourceDao {
    @Inject
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveUserInfo(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        entityManager.persist(employee);
    }

    @Override
    @Transactional
    public List<Employee> getAllEmployee() {
        return (List<Employee>) entityManager.createQuery("from Employee").getResultList();
    }

    @Override
    @Transactional
    public Employee getEmployeeByUserName(String userName) {
        List<Employee> employeeList = (List<Employee>) entityManager.createQuery("select e from Employee e where e.userName like :user").setParameter("user", userName).getResultList();
        return employeeList.get(0);
    }

    @Override
    @Transactional
    public void deleteEmployee(Employee employee) {
        entityManager.remove(employee);
    }
}
