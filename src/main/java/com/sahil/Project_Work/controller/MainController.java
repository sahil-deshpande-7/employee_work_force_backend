package com.sahil.Project_Work.controller;

import com.sahil.Project_Work.entity.Country;
import com.sahil.Project_Work.entity.Employee;
import com.sahil.Project_Work.entity.Registration;
import com.sahil.Project_Work.entity.User;
import com.sahil.Project_Work.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private MainService service;

    @PostMapping("/addcountry")
    public String addCountry(@RequestBody Country c) {
        String msg = service.addCountry(c);
        return msg;
    }


    @GetMapping("/getAllCountry")
    public List<Country> getAllCountry(){
        List<Country> list = service.getAllCountry();
        return list;
    }

    // API 2
    @PutMapping("/updateCountry")
    public String updateCountry(@RequestBody Country c) {
        String msg = service.updateCountry(c);
        return msg;
    }

    @PostMapping("/addEmp")
    public String addEmployee(@RequestBody Employee e) {
        String msg = service.addEmployee(e);
        return msg;
    }

    @PutMapping("/updateEmp")
    public String updateEmployee(@RequestBody Employee e) {

        String msg = service.updateEmployee(e);

        return msg;

    }

    @DeleteMapping("/deleteEmp/{id}")
    public String deleteEmployee(@PathVariable int id) {

        String msg = service.deleteEmployee(id);
        return msg;

    }

    @GetMapping("/getbyId/{id}")
    public Employee getParticularEmployeeById(@PathVariable int id) {

        Employee emp = service.getParticularEmpByID(id);
        return emp;

    }

    @GetMapping("/getAllEmp")
    public List<Employee> getAllEmployee() {

        List<Employee> empList = service.getAllEmp();

        return empList;

    }

    @GetMapping("/getByStatus/{status}")
    public List<Employee> getAllEmpByStatus(@PathVariable String status) {

        List<Employee> list = service.getAllEmpByStatus(status);
        return list;

    }

    @PostMapping("/loginApi")
    public HashMap checkUser(@RequestBody Employee emp) {

        HashMap map = service.checkUser(emp);
        return map;

    }

    @PostMapping("/loginuser")
    public HashMap loginUser(@RequestBody User user) {

        HashMap map = service.loginUser(user);
        return map;

    }

    @PostMapping("/login")
    public HashMap loginUser(@RequestBody Registration reg) {
        System.out.println(reg);
        HashMap map = service.login(reg);
        return map;
    }

}





