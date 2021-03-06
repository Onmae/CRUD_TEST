package co_0.main.controller;

import co_0.main.domain.Basic;
import co_0.main.service.BasicService;
import co_0.main.service.ProfileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {

    private BasicService basicService;
    private ProfileService profileService;

    public BoardController(BasicService basicService, ProfileService profileService) {
        this.basicService = basicService;
        this.profileService = profileService;
    }

    @GetMapping({ "/" })
    public String list(Model model) {
        model.addAttribute("basicList", basicService.findBasicList());
        model.addAttribute("profileList", profileService.findProfileList());
        return "index";
    }

    @GetMapping("/basic/{idx}")
    public String basicItem(@PathVariable Long idx, Model model) {
        model.addAttribute("basic", basicService.findBasicByIdx(idx));
        return "/basic/item";
    }

    @GetMapping("/profile")
    public String profileItem(@RequestParam(value = "idx", defaultValue = "0") Long idx, Model model) {
        model.addAttribute("profile", profileService.findProfileByIdx(idx));
        return "/profile/new";
    }

    @GetMapping("/basic/new")
    public String basicForm(Basic basic) {
        return "/basic/new";
    }

    @PostMapping("/basic/add")
    public String basicAdd(Basic basic, Model model) {
        Basic savedBasic = basicService.newBasic(basic);
        model.addAttribute("basic", basicService.findBasicByIdx(savedBasic.getIdx()));
        return "/basic/item";
    }

}
