package com.v1n1c1u.demo.web.controller;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.v1n1c1u.demo.domain.Department;
import com.v1n1c1u.demo.domain.Role;
import com.v1n1c1u.demo.service.DepartmentService;
import com.v1n1c1u.demo.service.RoleService;

@Controller
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private DepartmentService departmentService;
    
    @GetMapping("/register")
    public String register(ModelMap model){
        model.addAttribute("role",new Role());
        return "role/register";
    }

    @GetMapping("/list")
    public String list(ModelMap model){
        model.addAttribute("roles", roleService.findAll());
        return "role/list";
    }
    @PostMapping("/save")
    public String save(@Valid Role role, BindingResult result, RedirectAttributes attributes){
        if(result.hasErrors()){
            return "/role/register";
        }
        roleService.save(role);
        attributes.addFlashAttribute("success","Role registered successfully!");
        return "redirect:/roles/register";
    }
    @ModelAttribute("departments")
    public List<Department> getDepartmentList(){
        return departmentService.findAll();
    }
    @GetMapping("/edit/{id}")
    public String getObjectToEdit(@PathVariable("id") Long id, ModelMap model){
        model.addAttribute("role",roleService.findByID(id));
        return "/role/register";
    }
    @PostMapping("/edit")
    public String edit(@Valid Role role, BindingResult result,RedirectAttributes attributes){
        if(result.hasErrors()){
            return "/role/register";
        }
        roleService.edit(role);
        attributes.addFlashAttribute("success","Role updated successfully!");
        return "redirect:/roles/register";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes attributes){
        if(roleService.roleHasEmployeesAssociated(id)){
            attributes.addFlashAttribute("fail", "Can't delete roles that have employees associated!");
        }else{
            roleService.delete(id);
            attributes.addFlashAttribute("success", "Role deleted successfully!");
        }
        roleService.delete(id);
        return "redirect:/roles/list";
    }

    public DepartmentService getDepartmentService() {
        return departmentService;
    }
    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    public RoleService getRoleService() {
        return roleService;
    }
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }
}
