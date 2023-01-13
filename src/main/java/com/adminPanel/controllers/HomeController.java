package com.adminPanel.controllers;

import com.adminPanel.dao.DoctorDao;
import com.adminPanel.dao.HospitalDao;
import com.adminPanel.dao.petOwnerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    HospitalDao hospitalDao;
    @Autowired
    DoctorDao dao;

    @Autowired
    petOwnerDao petownerdao;

    @RequestMapping("/home")
    public String home(Model m){
        String hospitalCount = String.valueOf(hospitalDao.count());
        m.addAttribute("hospitalCount",hospitalCount);

        String doctorCount = String.valueOf(dao.count());
        m.addAttribute("doctorCount",doctorCount);

        String petOwnerCount = String.valueOf(petownerdao.count());
        m.addAttribute("petOwnerCount",petOwnerCount);

        return "home";
    }

    @RequestMapping("/")
    public String index(Model m){
        String hospitalCount = String.valueOf(hospitalDao.count());
        m.addAttribute("hospitalCount",hospitalCount);

        String doctorCount = String.valueOf(dao.count());
        m.addAttribute("doctorCount",doctorCount);

        String petOwnerCount = String.valueOf(petownerdao.count());
        m.addAttribute("petOwnerCount",petOwnerCount);

        return "home";
    }

}
