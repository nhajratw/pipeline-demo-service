package com.chikli.pipelinedemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cd")
public class PipelineDemoController {

    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public @ResponseBody String cd() {
        return "{\"topic\": \"Building a Continuous Deployment Pipeline from Scratch\", \"presenter\": \"Nayan Hajratwala\"}";
    }

}
