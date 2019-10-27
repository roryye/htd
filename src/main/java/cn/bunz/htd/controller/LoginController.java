package cn.bunz.htd.controller;

import cn.bunz.htd.entity.Recruit;
import cn.bunz.htd.service.RecruitService;
import cn.bunz.htd.service.UserService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private RecruitService recruitService;

    @GetMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("loginerror")
    public String loginError(){
        return "common/error";
    }

    @PostMapping("dologin")
    public String dologin(@RequestParam(value = "username") String userName,
                          @RequestParam(value = "password") String password,
                          @RequestParam(defaultValue = "1") String userId,
                          @PageableDefault(size = 6) Pageable pageable, Model model){
        String userPassword = userService.equalNameAndPassword(userName);
        if(password.equals(userPassword)){
            Page<Recruit> recruitPage = recruitService.findAll(pageable);
            model.addAttribute("recruitPage", recruitPage);
            model.addAttribute("current", pageable.getPageNumber());
            model.addAttribute("size", pageable.getPageSize());
            return "recruit";
        }else{
            model.addAttribute("msg", "登陆失败");
            return "common/error";
        }
    }


}
