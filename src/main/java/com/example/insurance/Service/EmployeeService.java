package com.example.insurance.Service;

import com.example.insurance.ModelClass.Employee;
import com.example.insurance.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {

    public EmployeeRepository employeeRepository;


    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }


    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee update(Employee PostManEntity, Integer id) {
       Employee DBentity = employeeRepository.findById(id).get();
       if(DBentity != null){

           if(PostManEntity.getEmployeeName() != null) DBentity.setEmployeeName(PostManEntity.getEmployeeName());
           if(PostManEntity.getEmployeeSalary() != null) DBentity.setEmployeeSalary(PostManEntity.getEmployeeSalary());
           if(PostManEntity.getAddress().getCity() != null) DBentity.getAddress().setCity(PostManEntity.getAddress().getCity());
           if(PostManEntity.getAddress().getCity() != null) DBentity.getAddress().setState(PostManEntity.getAddress().getState());
           if(PostManEntity.getAddress().getCity() != null) DBentity.getAddress().setCountry(PostManEntity.getAddress().getCountry());
           return employeeRepository.save (DBentity);
       } return DBentity;
    }

    public void delete(Integer id) {
        Employee emp = employeeRepository.findById(id).get();
        employeeRepository.delete(emp);
    }

    public Employee findById(Integer id) {
       return employeeRepository.findById(id).get();
    }
}
