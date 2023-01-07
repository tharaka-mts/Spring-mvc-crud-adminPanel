package com.adminPanel.controllers;

import com.adminPanel.beans.petOwner;
import com.adminPanel.dao.petOwnerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class petOwnerController {

    @Autowired
    petOwnerDao petownerdao;
    @RequestMapping("addOwner")
    public String addOwner(){
        return "addPetowner";
    }

    @RequestMapping("petowners")
    public String view(Model model){
        List<petOwner> list = petownerdao.getOwner();
        model.addAttribute("list", list);
        return "viewPetowners";
    }

//    add petowner
    @RequestMapping(value = "add-owner" , method = RequestMethod.POST)
    public String add(@ModelAttribute("owner") petOwner owner){
        if(petownerdao.addOwner(owner) == true){
            return "redirect:addOwner?success=true";
        } return "redirect:addOwner?success=false";

    }

//    edit pet owner

    @RequestMapping(value = "edit-pet-owner/{id}")
    public String editPage(@PathVariable int id, Model m){
        petOwner owner = petownerdao.getOwnerById(id);
        m.addAttribute("command", owner);
        return "editPetowner";

    }
    @RequestMapping(value = "edit-save-owner")
    public String editSubmit(@ModelAttribute("owner") petOwner owner ){
        petownerdao.update(owner);
        return "redirect:home";
    }

    @RequestMapping(value = "/delete-pet-owner/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        if(petownerdao.deleteOwner(id) == true){
            return "redirect:/petowners?success=true";
        } else
            return "redirect:/petowners?success=false";
    }
}
