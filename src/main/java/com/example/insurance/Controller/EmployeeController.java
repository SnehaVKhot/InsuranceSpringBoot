package com.example.insurance.Controller;

import com.example.insurance.ModelClass.Employee;
import com.example.insurance.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/EmployeeController")
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/getAll")
    public List<Employee> getEmployees(){
        return employeeService.findAll();

    }

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee){

        return employeeService.save(employee);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@RequestBody Employee employee , @PathVariable("id") Integer id){
        return employeeService.update(employee , id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable("id")  Integer id) {
        employeeService.delete(id);
    }
    @GetMapping("/getById/{id}")
    public Employee getById(@PathVariable("id")  Integer id){
        return employeeService.findById(id);
    }

}
