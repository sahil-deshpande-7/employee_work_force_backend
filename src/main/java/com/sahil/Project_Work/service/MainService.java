package com.sahil.Project_Work.service;

import com.sahil.Project_Work.dao.MainDao;
import com.sahil.Project_Work.entity.Country;
import com.sahil.Project_Work.entity.Employee;
import com.sahil.Project_Work.entity.Registration;
import com.sahil.Project_Work.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Service
public class MainService {

    @Autowired
    private MainDao dao;

    public String addCountry(Country c){
        String msg = dao.addCountry(c);

        if(Objects.isNull(msg)){
            msg="Data is not added successfully";
        }
        return msg;
    }

    public String updateCountry(Country c) {
        String msg= dao.updateCountry(c);

        if(Objects.isNull(msg)) {
            msg="Data is Not Updatated...";
        }

        return msg;

    }

    public String addEmployee(Employee e) {
        String msg= dao.addEmployee(e);

        if(Objects.isNull(msg)) {
            msg="Record is not be Added...";
        }

        return msg;
    }

    public String updateEmployee(Employee e) {

        String msg= dao.updateEmployee(e);

        if(Objects.isNull(msg)) {
            msg="Record Is not be updatated";
        }

        return msg;
    }

    public String deleteEmployee(int id) {
        String msg= dao.deleteEmployee(id);

        if(Objects.isNull(msg)) {
            msg="Record is not be Deleted...";
        }

        return msg;
    }

    public Employee getParticularEmpByID(int id) {

//		Employee e=dao.getParticularEmpByID(id);

        Employee e=dao.getEmpByID(id);

        if(Objects.isNull(e)) {
            e=null;
        }

        return e;
    }

    public List<Employee> getAllEmp() {

        List<Employee> list= dao.getAllEmp();

        return list;
    }

    public List<Employee> getAllEmpByStatus(String status) {
        List<Employee> list= dao.getAllEmpByStatus(status);
        if(Objects.isNull(list)) {
            list=null;
        }
        return list;

    }

    public HashMap checkUser(Employee emp) {

        Employee e= dao.checkUser(emp);
        HashMap map=new HashMap();
        if(Objects.isNull(e)) {
            map.put("msg","Invalid User");
            map.put("user", e);
        }else {
            map.put("msg","Valid User");
            map.put("user", e);
        }


        return map;


    }

    public HashMap loginUser(User user) {

        User  e = dao.loginUser(user);

        HashMap map=new HashMap();
        if(Objects.isNull(e)) {
            map.put("msg","Invalid User");
            map.put("user", e);
        }else {
            e.setPassword("*****");
            map.put("msg","Valid User");
            map.put("user",e);
        }


        return map;
    }

    public HashMap login(Registration reg) {
        Registration regUser = dao.login(reg);

        HashMap map=new HashMap();
        if(Objects.isNull(regUser)) {
            map.put("msg","Invalid User");
            map.put("user", regUser);
        }else {
            map.put("msg","Valid User");
            regUser.setPassword("********");
            map.put("user",regUser);
        }


        return map;
    }

    public List<Country> getAllCountry(){
        List<Country> list = dao.getAllCountry();
        if(Objects.isNull(list)) {
            list=null;
        }
        return list;
    }
}








