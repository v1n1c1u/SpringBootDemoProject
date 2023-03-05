package com.v1n1c1u.demo.web.controller;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.v1n1c1u.demo.web.validator.EmployeeValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
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

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(new EmployeeValidator());
    }
    @GetMapping("/register")
    public String register(ModelMap model){
        model.addAttribute("employee",new Employee());
        return "employee/register";
    }

    @GetMapping("/list")
    public  String list(ModelMap model){
        //System.out.println(Arrays.toString(employeeService.findAll().toArray()));
        model.addAttribute("employees", employeeService.findAll());
        model.addAttribute("roles", roleService.findAll());
        return "employee/list";
    }

    @PostMapping("/save")
    public String save(@Valid Employee employee, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "/employee/register";
        }
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
    public String edit(@Valid Employee employee, BindingResult result,RedirectAttributes attributes){
        if(result.hasErrors()){
            return "/employee/register";
        }
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
    @GetMapping("/search/name")
    public String getByName(@RequestParam("name") String name, ModelMap model){
        model.addAttribute("employees", employeeService.findByName(name));
        return "/employee/list";
    }
    @GetMapping("/search/role")
    public String getByRole(@RequestParam("role") Long roleID, ModelMap model){
        model.addAttribute("employees", employeeService.findByRoleID(roleID));
        return "/employee/list";
    }
    @GetMapping("/search/date")
    public String getByDates(@RequestParam(value = "start", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                             @RequestParam(value = "finish", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate finishDate,
                             ModelMap model){
        model.addAttribute("employees", employeeService.findByDates(startDate,finishDate));
        return "/employee/list";
    }

    @GetMapping("/get/{id}")
    public String getById(@PathVariable("id") Long id, ModelMap model){
        System.out.println(employeeService.findByID(id));
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