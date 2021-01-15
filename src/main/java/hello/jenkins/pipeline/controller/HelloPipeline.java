package hello.jenkins.pipeline.controller;

import hello.jenkins.pipeline.entity.PPResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pp")
public class HelloPipeline {

    @GetMapping(path="/greeting", produces = "application/json;charset=UTF-8")
    @CrossOrigin(origins = "*")
    public PPResponseEntity greetingPipeline() {
        return new PPResponseEntity("Hello Jenkins Pipeline.");
    }
}
