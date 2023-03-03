package com.v1n1c1u.demo.web.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.v1n1c1u.demo.domain.Employee;
import com.v1n1c1u.demo.domain.Role;
import com.v1n1c1u.demo.domain.State;
import com.v1n1c1u.demo.service.EmployeeService;
import com.v1n1c1u.demo.service.RoleService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/register")
    public String register(ModelMap model){
        model.addAttribute("employee",new Employee());
        return "employee/register";
    }


    @GetMapping("/list")
    public  String list(){
        return "employee/list";
    }

    @PostMapping("/save")
    public String save(Employee employee, RedirectAttributes attributes){
        employeeService.save(employee);
        attributes.addFlashAttribute("success", "Employee registered successfully!");
        return "redirect:/employees/register";
    }
    @GetMapping("/edit/{id}")
    public String getObjectToEdit(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("employee",employeeService.findByID(id));
        return "/employee/register";
    }
    @PostMapping("/edit")
    public String edit(Employee employee, RedirectAttributes attributes){
        employeeService.edit(employee);
        attributes.addFlashAttribute("success","Employee updated successfully!");
        return "redirect:/employees/register";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, ModelMap model){
        employeeService.delete(id);
        model.addAttribute("success", "Department deleted successfully!");
        return "redirect:/employees/list";
    }
    @ModelAttribute("roles")
    public List<Role> getRoles(){
        return roleService.findAll();
    }

    @ModelAttribute("states")
    public State[] getStates(){
        return State.values();
    }
    public RoleService getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

}