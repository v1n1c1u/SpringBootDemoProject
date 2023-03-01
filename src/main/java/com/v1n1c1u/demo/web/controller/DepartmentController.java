package com.v1n1c1u.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.v1n1c1u.demo.domain.Department;
import com.v1n1c1u.demo.service.DepartmentService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping("/register")
    public String register(Department department){
        return "/department/register";
    }

    @GetMapping("/list")
    public String list(ModelMap model){
        model.addAttribute("department", service.findAll());
        return "department/list";
    }

    @PostMapping("/save")
    public String save(Department department){
        service.save(department);
        return "redirect:/departments/register";
    }
    @GetMapping("/edit/{id}")
    public String getObjectToEdit(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("department",service.findByID(id));
        return "/department/register";
    }
    @PostMapping("/edit")
    public String edit(Department department){
        service.edit(department);
        return "redirect:/departments/register";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, ModelMap model){
        if(!service.departmentHasARolesAssociated(id)){
            service.delete(id);
        }
        return list(model);
    }
    public DepartmentService getService() {
        return service;
    }

    public void setService(DepartmentService service) {
        this.service = service;
    }

}
