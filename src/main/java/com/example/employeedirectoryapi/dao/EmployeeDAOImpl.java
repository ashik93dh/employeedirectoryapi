package com.example.employeedirectoryapi.dao;

import com.example.employeedirectoryapi.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    private EntityManager entityManager;
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> q=entityManager.createQuery("FROM Employee",Employee.class);
        List<Employee> employees=q.getResultList();
        return  employees;
    }

    @Override
    public Employee findById(int id) {
        Employee employee =entityManager.find(Employee.class,id);
        return employee;
    }

    @Override
    public Employee save(Employee employee) {
        Employee dbEmployee=entityManager.merge(employee);
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee employee =entityManager.find(Employee.class,id);
        entityManager.remove(employee);

    }
}
