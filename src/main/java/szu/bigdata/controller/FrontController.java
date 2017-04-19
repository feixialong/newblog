package szu.bigdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import szu.bigdata.domain.AdminInfo;
import szu.bigdata.service.ServiceInterface.AdminInfoService;
import szu.bigdata.service.ServiceInterface.BlogService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Created by longhao on 2017/4/7.
 */
@Controller
public class FrontController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private AdminInfoService adminInfoService;

    @GetMapping("/")
    public String welcome(Model model){
        model.addAttribute("AdminInfo",adminInfoService.getAdminInfo());//显示管理员信息
        model.addAttribute("Blogs",blogService.getFirstPage());
        return "index";
    }

    @GetMapping("/blog/{id}")
    public String blog(@PathVariable int id, Model model){
        model.addAttribute("AdminInfo",adminInfoService.getAdminInfo());//显示管理员信息
        model.addAttribute("blog",blogService.getBlog(id));//依据id获取博客信息
        return "blogpage";
    }

    @GetMapping("/about")
    public String about(Model model){
        model.addAttribute("AdminInfo",adminInfoService.getAdminInfo());//显示管理员信息
        return "about";
    }

    @GetMapping("/archive")
    public String archive(Model model){
        model.addAttribute("AdminInfo",adminInfoService.getAdminInfo());//显示管理员信息
        model.addAttribute("Blogs",blogService.getBlogByPage(1));
        return "archive";
    }

    @GetMapping("/archive/{page}")
    public String page(@PathVariable int page, Model model){
        model.addAttribute("AdminInfo",adminInfoService.getAdminInfo());//显示管理员信息
        model.addAttribute("Blogs",blogService.getBlogByPage(page));
        return "archive";
    }

//    @GetMapping("/image")
//    public String image(Model model){
//        model.addAttribute("AdminInfo",adminInfoService.getAdminInfo());//显示管理员信息
//        return "image";
//    }

    @GetMapping("/tags")
    public String stags(Model model){
        model.addAttribute("AdminInfo",adminInfoService.getAdminInfo());//显示管理员信息
        model.addAttribute("TagList",blogService.getTagList());//获取stag列表信息
        return "tags";
    }

    @GetMapping("/tags/{tagName}")
    public String stags_list(@PathVariable String tagName,Model model){
        model.addAttribute("AdminInfo",adminInfoService.getAdminInfo());//显示管理员信息
        model.addAttribute("BlogList",blogService.getBlogByTag(tagName));
        return "blog-list";
    }
    @GetMapping("/categories")
    public String categories(Model model){
        model.addAttribute("AdminInfo",adminInfoService.getAdminInfo());//显示管理员信息
        model.addAttribute("CategoriesList",blogService.getCategoriesList());//获取分类列表信息
        return "categories";
    }

    @GetMapping("/categories/{categoriesName}")
    public String categories_list(@PathVariable String categoriesName,Model model){
        model.addAttribute("AdminInfo",adminInfoService.getAdminInfo());//显示管理员信息
        model.addAttribute("BlogList",blogService.getBlogByCategories(categoriesName));
        return "blog-list";
    }

    @GetMapping("/login")
    public String login(HttpServletRequest request,Model model){
        //如果已登录则略过登录，跳转至admin
        HttpSession session=request.getSession(true);
        Object obj=session.getAttribute("current_user");

        if(obj != null  && obj instanceof AdminInfo){
            return "redirect:/admin";
        }
        //否则进入登录界面
        String result=request.getParameter("result");
        if(result != null && result.equals("fail")){
            model.addAttribute("success",0);
        }
        return "login";
    }

    @PostMapping("/login.action")
    public String doLogin(AdminInfo adminInfo, HttpServletRequest request){
        boolean result=adminInfoService.login(adminInfo);
        if(result){
            adminInfoService.addSession(request,adminInfo);
            return "redirect:/admin";
        }
        else{
            return "redirect:/login?result=fail";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        adminInfoService.destroySession(request);
        return "redirect:/login";
    }

}
