package com.adminPanel.controllers;

import com.adminPanel.beans.Doctor;
import com.adminPanel.dao.DoctorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;

@Controller
public class DoctorController {
    @Autowired
    DoctorDao dao;

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

//    Edit Doctors view page
    @RequestMapping(value = "/edit-doctor/{id}")
    public String editPage(@PathVariable int id, Model m){
        Doctor doctor = dao.getDoctorById(id);
        m.addAttribute("command",doctor);
        return "editDoctor";
    }

//    Edit a doctor

    @RequestMapping(value = "/edit-save-doctor")
    public String ediSubmit(@ModelAttribute("doctor") Doctor doctor){
        dao.update(doctor);
        return "redirect:/home";
    }

    @RequestMapping(value = "/delete-doctor/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        if(dao.deleteDoctor(id) == true){
            return "redirect:/doctors?success=true";
        } else
        return "redirect:/doctors?success=false";
    }
}
