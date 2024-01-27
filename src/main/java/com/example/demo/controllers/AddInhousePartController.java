package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.service.InhousePartService;
import com.example.demo.service.InhousePartServiceImpl;
import com.example.demo.service.PartService;
import com.example.demo.service.PartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 *
 *
 *
 */
@Controller
public class AddInhousePartController{
    @Autowired
    private ApplicationContext context;


    @GetMapping("/showFormAddInPart")
    public String showFormAddInhousePart(Model theModel){
        InhousePart inhousepart=new InhousePart();
        theModel.addAttribute("inhousepart",inhousepart);
        return "InhousePartForm";
    }

    @PostMapping("/showFormAddInPart")
    public String submitForm(@Valid @ModelAttribute("inhousepart") InhousePart part, BindingResult bindingResult, Model theModel){
        theModel.addAttribute("inhousepart",part);

        if (!part.isInventoryValid()) {
            bindingResult.rejectValue(
                    "inventory",
                    "inventory.out.of.range",
                    "Inventory must be between " + part.getMinInv() + " and " + part.getMaxInv()
            );
        }

        if(bindingResult.hasErrors()){
            return "InhousePartForm";
        }
        else{
            InhousePartService repo=context.getBean(InhousePartServiceImpl.class);
            InhousePart ip=repo.findById((int)part.getId());
            if(ip!=null)part.setProducts(ip.getProducts());
            repo.save(part);

            return "confirmationaddpart";}
    }

}