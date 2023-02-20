package com.example.springbootjpa.controller;

import com.example.springbootjpa.AlienRepo;
import com.example.springbootjpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlienController {
    @Autowired
    AlienRepo alienRepo;
    @RequestMapping("/")
    public String home(){
        System.out.println("Hi thus srk");
        return "home.jsp";
    }

    @RequestMapping("/addAlien")
    public String addAlien(Alien alien){
        alienRepo.save(alien);
        System.out.println("Hi thus srk");
        return "home.jsp";
    }


    @RequestMapping("/getAlien")
    public ModelAndView addAlien(int aid){
        ModelAndView mv =new ModelAndView("showAlien.jsp");

        Alien alien=alienRepo.findById(aid).orElse(new Alien());
        mv.addObject(alien);

        System.out.println("Hi thus srk");
        return mv;
    }

}
