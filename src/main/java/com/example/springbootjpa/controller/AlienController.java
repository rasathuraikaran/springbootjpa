package com.example.springbootjpa.controller;

import com.example.springbootjpa.AlienRepo;
import com.example.springbootjpa.model.Alien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
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
    public ModelAndView getAlien(int aid){
        ModelAndView mv =new ModelAndView("showAlien.jsp");

        Alien alien=alienRepo.findById(aid).orElse(new Alien());
        mv.addObject(alien);

        System.out.println("Hi thus srk");
        System.out.println(alienRepo.findByAlang("java"));
        System.out.println(alienRepo.findByAidGreaterThan(101));
        System.out.println(alienRepo.findByAlangSorted("java"));


        return mv;
    }

    @RequestMapping("/deleteAlien")
    public String deleteAlien(int aid){


   alienRepo.deleteById(aid);


        return "home.jsp";
    }

@GetMapping(path = "/aliens",produces = "application/json")
    public List<Alien> getAliens(){
    System.out.println("nfdejn");
        return  alienRepo.findAll();

    }
    @PostMapping("/aliens")
    public Alien addAliens( Alien alien){
        System.out.println("Hi this srkdmsmdkms");
        System.out.println(alien.getAid());
        alienRepo.save(alien);
        return  alien ;

    }


    @RequestMapping("/aliens/{aid}")

    public Optional<Alien> getOneAlien(@PathVariable int aid){
        return  alienRepo.findById(aid);

    }


    @DeleteMapping ("/aliens/{aid}")

    public String deleteOneAlien(@PathVariable int aid){

        alienRepo.deleteById(aid);


        return "home";

    }

}
