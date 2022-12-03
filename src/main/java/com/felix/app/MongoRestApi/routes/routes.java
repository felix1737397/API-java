package com.felix.app.MongoRestApi.routes;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class routes {
    @GetMapping("/")
    public String getPage(){
        return "allo les amis";
    }
}
