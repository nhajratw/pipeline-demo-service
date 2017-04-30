package com.chikli.pipelinedemo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cd")
public class PipelineDemoController {

    @RequestMapping(method=RequestMethod.GET)
    public @ResponseBody String cd() {
        return "<h1><marquee>Continuous Delivery is Awesome!</marquee></h1>";
    }

}
