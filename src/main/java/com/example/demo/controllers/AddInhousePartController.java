package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.Part;
import com.example.demo.service.InhousePartService;
import com.example.demo.service.InhousePartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
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
public class AddInhousePartController extends Part{
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

        // Check if inventory is below the minimum
        if (part.getInv() < part.getMinInv()) {
            bindingResult.rejectValue("inv", "invalid.min", "Solution: Fix your Inventory Value, Inventory must be greater than the minimum value.");
            return "InhousePartForm";
        }

        // Check if inventory is above the maximum
        if (part.getInv() > part.getMaxInv()) {
            bindingResult.rejectValue("inv", "invalid.max", "Solution: Fix your Inventory Value, Inventory cannot exceed the maximum value.");
            return "InhousePartForm";
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