package com.harry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @program: harry
 * @description:
 * @author: Harry
 **/
@Controller
public class SelectController {
    @RequestMapping("/selectTrain")
    @ResponseBody
    public String selectTrain(@RequestParam String locationStart, @RequestParam String locationFinal) {
        System.out.println(locationFinal+locationStart);
        return locationFinal;
    }

    @RequestMapping("/trainPage")
    public String trainPage() {
        return "train";
    }
}
