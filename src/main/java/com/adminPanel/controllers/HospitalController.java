package com.adminPanel.controllers;

import com.adminPanel.beans.Doctor;
import com.adminPanel.beans.Hospital;
import com.adminPanel.dao.HospitalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class HospitalController {
    @Autowired
    HospitalDao hospitalDao;

//    View Add Hospital
    @RequestMapping("/add-hospital")
    public String viewAddHospital(){
        return "addHospital";
    }

//    View Hospitals
    @RequestMapping("/hospitals")
    public String view(Model model){
        List<Hospital> list = hospitalDao.getHospital();
        model.addAttribute("list",list);
        return "viewHospitals";
    }

//    Add a hospital
@RequestMapping(value = "/addHospital", method = RequestMethod.POST)
    public String addHospital(@ModelAttribute("hospital") Hospital hospital){
        if(hospitalDao.addHospital(hospital) == true){
            return "redirect:/add-hospital?success=true";
        } return "redirect:/add-hospital?success=false";
    }

//    Delete a hospital
    @RequestMapping(value = "/delete-hospital/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        if(hospitalDao.deleteHospital(id) == true){
            return "redirect:/hospitals?success=true";
        } else
            return "redirect:/hospitals?success=false";
    }
}
