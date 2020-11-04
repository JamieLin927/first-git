package com.org.Controller;

import com.org.dao.DepartmentDao;
import com.org.dao.EmployeeDao;
import com.org.pojo.Department;
import com.org.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @GetMapping("/emps")
    public String list(Model model){
      Collection<Employee> employees= employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }
    @GetMapping("/emp")
    public String toAdd( Model model){
        Collection<Department> depts= departmentDao.getDepartments();
        model.addAttribute("depts",depts);
        return "emp/add";
    }
    @PostMapping("/emp")
    public String AddEmp(Employee employee ){
        employeeDao.save(employee);

        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditemp(@PathVariable("id") Integer id,Model model){
       Employee employee= employeeDao.get(id);
       model.addAttribute("emp",employee);
       Collection<Department> depts= departmentDao.getDepartments();
        model.addAttribute("depts",depts);

        return "emp/add";
    }
    @PutMapping("/emp")
    public  String Editemp(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String DelEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
