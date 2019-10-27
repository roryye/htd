package cn.bunz.htd.controller;

import cn.bunz.htd.entity.Recruit;
import cn.bunz.htd.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/zhaopin")
public class PositionController {
    @Autowired
    private RecruitService recruitService;


    @GetMapping("/list")
    public String position(@RequestParam(defaultValue = "1") String userId,
                           @PageableDefault(size = 6) Pageable pageable, Model model) {
        Page<Recruit> recruitPage = recruitService.findAll(pageable);
        model.addAttribute("recruitPage", recruitPage);
        model.addAttribute("current", pageable.getPageNumber());
        model.addAttribute("size", pageable.getPageSize());
        return "recruit";
    }

    @GetMapping("/detail")
    public String detail(@RequestParam(value = "recruitId") Integer recruitId, Model model){
        Recruit recruit = recruitService.findByRecruitId(recruitId);
        model.addAttribute("recruit", recruit);
        return "/detail";
    }

/*
@GetMapping("/listrecruit")
@ResponseBody
public Map<String, Object> listRecruit() {
Map<String, Object> modelMap = new HashMap<String, Object>();
List<Recruit> recruitList = recruitService.findAll();
modelMap.put("recruitlist", recruitList);

return modelMap;
}
*/

}
