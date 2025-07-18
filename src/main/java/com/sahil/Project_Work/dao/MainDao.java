package com.sahil.Project_Work.dao;

import com.sahil.Project_Work.entity.Country;

import com.sahil.Project_Work.entity.Employee;
import com.sahil.Project_Work.entity.Registration;
import com.sahil.Project_Work.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MainDao {

    @Autowired
    private SessionFactory factory;

    public String addCountry(Country c) {
        Session session = null;
        Transaction tx = null;
        String msg = null;

        try {
            session = factory.openSession();
            tx = session.beginTransaction();
            session.persist(c);
            tx.commit();
            msg="Data Added Successfully...";
        }
        catch(Exception e){
            if(tx!=null){
                tx.rollback();
            }
            e.printStackTrace();
        }
        finally{
            if(session!=null){
                session.close();
            }
        }
        return msg;
    }

    public String updateCountry(Country c) {

        Session session=null;
        Transaction tx=null;
        String msg=null;
        try {
            session= factory.openSession();
            tx=session.beginTransaction();

            Country country= session.get(Country.class,c.getCid() );

            country.setCname(c.getCname());

            session.merge(country);
            tx.commit();
            msg="Data is Updatated Successfully...";


        }catch (Exception e) {
            if(tx!=null) {
                tx.rollback();
            }

            e.printStackTrace();
        }finally {
            if(session!=null) {
                session.close();
            }
        }

        return msg;
    }

    public String addEmployee(Employee e) {

        Session session=null;
        Transaction tx=null;
        String msg=null;
        try {
            session= factory.openSession();
            tx=session.beginTransaction();

            session.persist(e);
            tx.commit();
            msg="Record is Addedd Successfully";


        }catch (Exception e1) {
            if(tx!=null) {
                tx.rollback();
            }

            e1.printStackTrace();
        }finally {
            if(session!=null) {
                session.close();
            }
        }

        return msg;


    }

    public String updateEmployee(Employee emp) {
        Session session=null;
        Transaction tx=null;
        String msg=null;
        try {
            session= factory.openSession();
            tx=session.beginTransaction();
            Employee employee= session.get(Employee.class, emp.getId());

            employee.setName(emp.getName());
            employee.setPhoneno(emp.getPhoneno());
            employee.setCountry(emp.getCountry());
            employee.setCreatedby(emp.getCreatedby());
            employee.setCreateddtm(emp.getCreateddtm());
            employee.setDepartment(emp.getDepartment());
            employee.setStatus(emp.getStatus());
            employee.setUpdatedby(emp.getUpdatedby());
            employee.setUpdateddtm(emp.getUpdateddtm());

            session.merge(employee);


            tx.commit();
            msg="Record is updatated";

        }catch (Exception e1) {
            if(tx!=null) {
                tx.rollback();
            }

            e1.printStackTrace();
        }finally {
            if(session!=null) {
                session.close();
            }
        }

        return msg;
    }

    public String deleteEmployee(int id) {

        Session session=null;
        Transaction tx=null;
        String msg=null;
        try {
            session= factory.openSession();
            tx=session.beginTransaction();
            Employee employee= session.get(Employee.class, id);

            session.remove(employee);
            tx.commit();

            msg="Record is Deleted";
        }catch (Exception e1) {
            if(tx!=null) {
                tx.rollback();
            }

            e1.printStackTrace();
        }finally {
            if(session!=null) {
                session.close();
            }
        }

        return msg;
    }

    public Employee getParticularEmpByID(int id) {

        Session session=null;
        Transaction tx=null;
        Employee employee=null;
        try {
            session= factory.openSession();
            tx=session.beginTransaction();
            employee= session.get(Employee.class, id);
            tx.commit();

        }catch (Exception e1) {
            if(tx!=null) {
                tx.rollback();
            }

            e1.printStackTrace();
        }finally {
            if(session!=null) {
                session.close();
            }
        }



        return employee;
    }


    public Employee getEmpByID(int id) {

        Session session=null;
        Transaction tx=null;
        Employee emp=null;
        String strquery="from Employee where id=:myid";
        try {
            session= factory.openSession();
            tx=session.beginTransaction();

            Query<Employee> query= session.createQuery(strquery,Employee.class);
            query.setParameter("myid", id);
            emp= query.uniqueResult();
            tx.commit();


        }catch (Exception e1) {
            if(tx!=null) {
                tx.rollback();
            }

            e1.printStackTrace();
        }finally {
            if(session!=null) {
                session.close();
            }
        }

        return emp;


    }

    public List<Employee> getAllEmp() {
        Session session=null;
        Transaction tx=null;
        String strQuery="from Employee";
        List<Employee> list=null;
        try {
            session= factory.openSession();
            tx=session.beginTransaction();

            Query<Employee> query= session.createQuery(strQuery,Employee.class);

            list=query.list();
            tx.commit();


        }catch (Exception e1) {
            if(tx!=null) {
                tx.rollback();
            }

            e1.printStackTrace();
        }finally {
            if(session!=null) {
                session.close();
            }
        }


        return list;
    }

    public List<Employee> getAllEmpByStatus(String status) {
        Session session=null;
        Transaction tx=null;
        String strQuery="from Employee where status=:mystatus";
        List<Employee> list=null;

        try {
            session= factory.openSession();
            tx=session.beginTransaction();

            Query<Employee> query= session.createQuery(strQuery,Employee.class);
            query.setParameter("mystatus", status);

            list=query.list();

            tx.commit();

        }catch (Exception e1) {
            if(tx!=null) {
                tx.rollback();
            }

            e1.printStackTrace();
        }finally {
            if(session!=null) {
                session.close();
            }
        }

        return list;


    }

    public Employee checkUser(Employee emp) {

        Session session=null;
        Transaction tx=null;
        String strQuery="from Employee where name=:name and phoneno=:phoneno";
        Employee employee=null;
        try {
            session= factory.openSession();
            tx=session.beginTransaction();

            Query<Employee> query= session.createQuery(strQuery,Employee.class);

            query.setParameter("name",emp.getName() );
            query.setParameter("phoneno", emp.getPhoneno());

            employee= query.uniqueResult();

            tx.commit();

        }catch (Exception e1) {
            if(tx!=null) {
                tx.rollback();
            }

            e1.printStackTrace();
        }finally {
            if(session!=null) {
                session.close();
            }
        }

        return employee;


    }

    public User loginUser(User user) {

        Session session=null;
        Transaction tx=null;
        String strQuery="from User where username=:username and password=:password";
        User u=null;
        try {
            session= factory.openSession();
            tx=session.beginTransaction();

            Query<User> query= session.createQuery(strQuery,User.class);

            query.setParameter("username",user.getUsername() );
            query.setParameter("password", user.getPassword());

            u= query.uniqueResult();

            tx.commit();

        }catch (Exception e1) {
            if(tx!=null) {
                tx.rollback();
            }

            e1.printStackTrace();
        }finally {
            if(session!=null) {
                session.close();
            }
        }

        return u;

    }

    public Registration login(Registration reg) {
        Session session=null;
        Transaction tx=null;
        String strQuery="from Registration where emailid =:emailid and password=:password";
        Registration reguser = null;
        try {
            session= factory.openSession();
            tx=session.beginTransaction();

            Query<Registration> query= session.createQuery(strQuery,Registration.class);

            query.setParameter("emailid",reg.getEmailid() );
            query.setParameter("password", reg.getPassword());

            reguser= query.uniqueResult();

            tx.commit();
        }catch (Exception e) {
            if(tx!=null) {
                tx.rollback();
            }


            e.printStackTrace();
        }finally {
            if(session!=null) {
                session.close();
            }
        }
        return reguser;


    }

    public List<Country> getAllCountry() {
        Session session=null;
        Transaction tx=null;
        String strQuery="from Country";
        List<Country> list=null;
        try {
            session= factory.openSession();
            tx=session.beginTransaction();

            Query<Country> query= session.createQuery(strQuery,Country.class);

            list=query.list();
            tx.commit();


        }catch (Exception e1) {
            if(tx!=null) {
                tx.rollback();
            }

            e1.printStackTrace();
        }finally {
            if(session!=null) {
                session.close();
            }
        }


        return list;
    }
}



