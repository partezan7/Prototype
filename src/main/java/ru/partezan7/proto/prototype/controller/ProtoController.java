package ru.partezan7.proto.prototype.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ProtoController {
    @GetMapping("/start")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="User") String name, Model model) {
        model.addAttribute("name", name);
        return "start-page";
    }

    @GetMapping("/")
    public String mainPage(Map<String, Object> model){
        model.put("info", "This is the main page");
        return "main-page";
    }

}
