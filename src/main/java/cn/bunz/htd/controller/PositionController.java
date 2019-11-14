package cn.bunz.htd.controller;

import cn.bunz.htd.entity.Recruit;
import cn.bunz.htd.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
    public String detail(@RequestParam(value = "recruitId") Integer recruitId, Model model) {
        Recruit recruit = recruitService.findByRecruitId(recruitId);
        model.addAttribute("recruit", recruit);
        return "detail";
    }

    @GetMapping("/recruit")
    public String recruit(@RequestParam(defaultValue = "1") String userId,
                          @PageableDefault(size = 6) Pageable pageable, Model model,
                          @RequestParam(defaultValue = "0") Integer lowSalary,
                          @RequestParam(defaultValue = "0") Integer highSalary) {

        Page<Recruit> recruitPage = recruitService.findBySalary(pageable, lowSalary, highSalary);
        model.addAttribute("recruitPage", recruitPage);
        model.addAttribute("current", pageable.getPageNumber());
        model.addAttribute("size", pageable.getPageSize());
        return "recruit::recruitlist";
    }

    @GetMapping("/education")
    public String Education(@RequestParam(defaultValue = "1") String userId,
                            @PageableDefault(size = 6) Pageable pageable, Model model,
                            @RequestParam(defaultValue = "不限") String education) {

        Page<Recruit> recruitPage;
        if (education.indexOf("不限") != -1) {
            recruitPage = recruitService.findAll(pageable);
        } else {
            recruitPage = recruitService.findByEducation(pageable, education);
        }
        model.addAttribute("recruitPage", recruitPage);
        model.addAttribute("current", pageable.getPageNumber());
        model.addAttribute("size", pageable.getPageSize());

        return "recruit::recruitlist";
    }

    @GetMapping("/experience")
    public String Experience(@RequestParam(defaultValue = "1") String userId,
                             @PageableDefault(size = 6) Pageable pageable, Model model,
                             @RequestParam(defaultValue = "不限") String experience) {

        Page<Recruit> recruitPage;
        if (experience.indexOf("不限") != -1) {
            recruitPage = recruitService.findAll(pageable);
        } else {
            recruitPage = recruitService.findByExperience(pageable, experience);
        }
        model.addAttribute("recruitPage", recruitPage);
        model.addAttribute("current", pageable.getPageNumber());
        model.addAttribute("size", pageable.getPageSize());

        return "recruit::recruitlist";
    }

    @GetMapping("/searchtext")
    public String SearchText(@RequestParam(defaultValue = "1") String userId,
                             @PageableDefault(size = 6) Pageable pageable, Model model,
                             @RequestParam(defaultValue = "") String searchtext) {

        Page<Recruit> recruitPage;
        if (searchtext == null || "".equals(searchtext)) {
            recruitPage = recruitService.findAll(pageable);
        } else {
            recruitPage = recruitService.findBySearchText(pageable, searchtext);
        }
        model.addAttribute("recruitPage", recruitPage);
        model.addAttribute("current", pageable.getPageNumber());
        model.addAttribute("size", pageable.getPageSize());

        return "recruit::recruitlist";
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
