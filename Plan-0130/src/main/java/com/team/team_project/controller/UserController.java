package com.team.team_project.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequestMapping("/checkplan/forUser/")
public class UserController {
    @GetMapping("editUserInfo")
    public void editUserInfo(){
    }
}
