package com.example.vaulttest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class WebController {
    @RequestMapping(value="/")
    public String   Home() {
        return  "index.html";
    }
}
