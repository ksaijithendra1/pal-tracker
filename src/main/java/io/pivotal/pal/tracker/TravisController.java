package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TravisController {


    @GetMapping("/travis")
    public String getTravisStatus() {
        return "Travis build successful";
    }
}
