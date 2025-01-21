package org.devin.calendar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class CalenderController {

    @GetMapping("/")
    public String index() {
        return "weekly-calendar";
    }

}
