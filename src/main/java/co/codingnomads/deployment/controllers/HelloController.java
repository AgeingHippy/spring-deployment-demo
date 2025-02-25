package co.codingnomads.deployment.controllers;

import co.codingnomads.deployment.services.HelloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

@Controller
@Slf4j
public class HelloController {
    @Autowired
    HelloService helloService;

    @GetMapping("/")
    public String sayHello(Model model) {
        model.addAttribute("hello", helloService.getHello());
        return "hello";
    }

    @GetMapping("/health")
    @ResponseBody
    public String checkHealth(@RequestParam(required = false) String id) {
        log.info(MessageFormat.format("******* HealthCheck ({0}) *******", id));
        return "ok";
    }
}