package cn.bunz.htd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Test {

    @RequestMapping("/index")
    public String test(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login/login";
    }
}
