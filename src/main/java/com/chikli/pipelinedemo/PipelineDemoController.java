package com.chikli.pipelinedemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cd")
public class PipelineDemoController {
	
	@Autowired
	private ResourceLoader resourceLoader;

    @RequestMapping(method=RequestMethod.GET, produces="application/json")
    public @ResponseBody Resource cd() {
        return resourceLoader.getResource("classpath:data.json");
    }

}
