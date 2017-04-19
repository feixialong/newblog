package szu.bigdata.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import szu.bigdata.service.ServiceInterface.AdminInfoService;

/**
 * Created by longhao on 2017/4/14.
 */
@Controller
public class AdminController {

    @Autowired
    private AdminInfoService adminInfoService;
    @GetMapping("/admin")
    public String adminHome(Model model){
        model.addAttribute("AdminInfo",adminInfoService.getAdminInfo());
        return "/admin/home";
    }
}
