package com.v1n1c1u.demo.web.controller;

import com.v1n1c1u.demo.domain.Employee;
import com.v1n1c1u.demo.util.PaginationUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.v1n1c1u.demo.domain.Department;
import com.v1n1c1u.demo.service.DepartmentService;

import java.util.Optional;

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
    public String list(ModelMap model,
                       @RequestParam("page") Optional<Integer> page,
                       @RequestParam("order") Optional<String> order){
        int currentPage = page.orElse(1);
        String orderDirection = order.orElse("ASC");
        PaginationUtil<Department> pageDepartments = service.getPagination(currentPage, orderDirection);
        model.addAttribute("pageDepartments", service.getPagination(currentPage, orderDirection));
        return "department/list";
    }
    @PostMapping("/save")
    public String save(@Valid Department department, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "/department/register";
        }
        service.save(department);
        attributes.addFlashAttribute("success","Department saved successfully!");
        return "redirect:/departments/register";
    }
    @GetMapping("/edit/{id}")
    public String getObjectToEdit(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("department",service.findByID(id));
        return "/department/register";
    }
    @PostMapping("/edit")
    public String edit(@Valid Department department,BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "/department/register";
        }
        service.edit(department);
        attributes.addFlashAttribute("success","Department updated successfully!");
        return "redirect:/departments/register";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, ModelMap model){
        if(service.departmentHasARolesAssociated(id)){
            model.addAttribute("fail", "Can't delete department that has roles associated!");
        }else{
            service.delete(id);
            model.addAttribute("success", "Department deleted successfully!");
        }
        model.addAttribute("departments", service.findAll());
        return "department/list";
    }
    public DepartmentService getService() {
        return service;
    }

    public void setService(DepartmentService service) {
        this.service = service;
    }

}
