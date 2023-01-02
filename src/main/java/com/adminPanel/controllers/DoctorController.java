package com.adminPanel.controllers;

import com.adminPanel.beans.Doctor;
import com.adminPanel.dao.DoctorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class DoctorController {
    @Autowired
    DoctorDao dao;
    @RequestMapping("/home")
    public String home(){
        return "home";
    }
    @RequestMapping("addDoctor")
    public String addDocPage(){
        return "addDoctor";
    }

    @RequestMapping(value = "/add-doctor", method = RequestMethod.POST)
    public String add(@ModelAttribute("doctor") Doctor doctor) {
        if(dao.addDoctor(doctor) == true){
            return "redirect:/addDoctor?success=true";
        }
        return "redirect:/addDoctor?success=false";
    }

    @RequestMapping("/doctors")
    public String view(Model model){
        List<Doctor> list = dao.getDoctors();
        model.addAttribute("list",list);
        return "viewDoctors";
    }

//    Edit Doctors



    @RequestMapping(value = "/delete-doctor/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        if(dao.deleteDoctor(id) == true){
            return "redirect:/doctors?success=true";
        } else
        return "redirect:/doctors?success=false";
    }
}
