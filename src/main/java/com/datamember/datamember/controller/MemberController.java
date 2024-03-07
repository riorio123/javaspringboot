package com.datamember.datamember.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.datamember.datamember.model.Member;
import com.datamember.datamember.service.MemberService;


@Controller
public class MemberController {
    private MemberService memberService;

    public MemberController(MemberService initialMember){
        this.memberService = initialMember;
    }  
    
    @GetMapping("/member")
    public String showAllMembers(Model model) {
        model.addAttribute("listofmembers", memberService.showAllMembers());
        return "index";
    }

    @GetMapping("/editmember/{id}")
    public String viewAMemberByID(@PathVariable("id") Integer id, Model model) {
        Member aMember = memberService.getByIdMember(id);
        model.addAttribute("aSingleMemberObject", aMember);
        return "editMember";
    }

    @PostMapping("/edit/{id}")
    public String editMember(@PathVariable("id") Integer id, @Validated @ModelAttribute("aSingleMemberObject") Member updateCurrentUser, BindingResult result) {
        if(result.hasErrors()) {
            return "editMember";
        }
        memberService.updateMember(updateCurrentUser);
        return "redirect:/member";

    }

    @PostMapping("delete/{id}")
    public String removeAMember(@PathVariable("id") Integer id) {
        memberService.deleteByID(id);
        return "redirect:/member";
    }
}
