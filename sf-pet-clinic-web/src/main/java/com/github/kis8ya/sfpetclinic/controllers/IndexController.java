package com.github.kis8ya.sfpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping({"", "/", "index.html"})
    public String index() {
        return "index";
    }

    @RequestMapping({"oups"})
    public String error() {
        return "not-implemented";
    }


}
