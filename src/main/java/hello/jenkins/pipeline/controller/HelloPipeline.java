package hello.jenkins.pipeline.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pp")
public class HelloPipeline {

    @GetMapping("/greeting")
    @CrossOrigin(origins = "*")
    public String greetingPipeline() {
        return "Hello Jenkins Pipeline";
    }
}
