package com.adminPanel.controllers;

import com.adminPanel.beans.petOwner;
import com.adminPanel.dao.petOwnerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class petOwnerController {

    @Autowired
    petOwnerDao petownerdao;

    @RequestMapping("petowners")
    public String view(Model model){
        List<petOwner> list = petownerdao.getOwner();
        model.addAttribute("list", list);
        return "viewPetowners";
    }

    @RequestMapping(value = "/delete-pet-owner/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        if(petownerdao.deleteOwner(id) == true){
            return "redirect:/petowners?success=true";
        } else
            return "redirect:/petowners?success=false";
    }
}
