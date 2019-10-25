package cn.bunz.htd.controller;

import cn.bunz.htd.entity.Recruit;
import cn.bunz.htd.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/zhaopin")
public class PositionController {
    @Autowired
    private RecruitService recruitService;


    @GetMapping("/list")
    public String position(@PageableDefault(size = 7) Pageable pageable, Model model) {
        List<Recruit> recruitList = recruitService.findAll();
        model.addAttribute("recruitPage", recruitList);
        return "recruit";
    }

    @GetMapping("/listrecruit")
    @ResponseBody
    public Map<String, Object> listRecruit() {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        List<Recruit> recruitList = recruitService.findAll();
        modelMap.put("recruitlist", recruitList);

        return modelMap;
    }

}
