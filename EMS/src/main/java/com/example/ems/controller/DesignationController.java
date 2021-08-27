package com.example.ems.controller;

import com.example.ems.dto.DesignationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/")
public class DesignationController {

    @RequestMapping(method= RequestMethod.GET)
    public String mainPage(Model model){
        model.addAttribute("designationDto", new DesignationDto("dname", "dshort", "dstatus"));
        return "index";
    }

    @PostMapping("/submit")
    public String submitForm(HttpServletRequest request)
    {
        String dname =request.getParameter("dname");
        String dshort =request.getParameter("dshort");
        String dstatus =request.getParameter("dstatus");
        System.out.println(dname);
        System.out.println(dshort);
        System.out.println(dstatus);
        return "redirect:/";
    }


    @PostMapping("/submit1")
    public String submitForm(@RequestParam("dname") String dname,
                             @RequestParam("dshortcode") String dshortcode,
                             @RequestParam("dstatus") String dstatus,
                             Model model, DesignationDto designationDto) {

        System.out.println(designationDto.getDname());
        System.out.println(designationDto.getDstatus());
        System.out.println(designationDto.getDshortcode());
        model.addAttribute("d3", designationDto.getDname());
        model.addAttribute("d4", designationDto.getDshortcode());
        model.addAttribute("d5",designationDto.getDstatus());
        return "redirect:/";
    }
}
