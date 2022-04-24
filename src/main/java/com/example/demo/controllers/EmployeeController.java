package com.example.demo.controllers;

import com.example.demo.models.Employee;
import com.example.demo.repositories.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

    EmployeeRepository employeeRepository = new EmployeeRepository();
    @GetMapping("/employ")
    public String employ(Model model){
        List<Employee> list = employeeRepository.getAllEntities();
        model.addAttribute("employees", list);
        return "Employee";
    }
    @GetMapping("/findemploy")
    public String findemploy(Model m, @RequestParam int id){
        Object OneEmployee = employeeRepository.getSingleEntityById(id);
        m.addAttribute("oneEmploy", OneEmployee);
        return "OneEmployee";

    }

    @PostMapping("/addEmploy")
    public String test(@RequestParam Int Idnumber, @RequestParam String name, @RequestParam String job, @RequestParam int manager, @RequestParam int salary, @RequestParam int commision, @RequestParam int department, Model model){
        employeeRepository.

        return "redirect:/addEmploy";
    }

}
