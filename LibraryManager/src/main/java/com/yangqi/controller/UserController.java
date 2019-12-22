package com.yangqi.controller;

import com.yangqi.dao.UserDAO;
import com.yangqi.model.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

/**
 * Created by Administrator on 2017/4/3.
 * 控制层
 */
@Controller
@RequestMapping("/user")
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserController {
    private UserDAO userDAO;

    @Resource
    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    private static void addCookie(String name, String value, int maxAge, HttpServletResponse response) throws Exception {
        //添加cookie操作
        Cookie cookie = new Cookie(name, URLEncoder.encode(value.trim(), "UTF-8"));
        cookie.setMaxAge(maxAge);// 设置为10天
        cookie.setPath("/");
        System.out.println("已添加" + name);
        response.addCookie(cookie);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "login";
    }

    @RequestMapping(value = "/validate", method = RequestMethod.POST)
    public String validate(UserEntity userEntity, HttpServletResponse response) throws Exception {
        System.out.println("================================================================");
        System.out.println(userEntity);
        UserEntity user = userDAO.findById(userEntity.getStuId());
        //登录成功返回user，失败返回null
        if (user == null || !user.getStuId().equals(userEntity.getStuId())) {
            return "redirect:/login.jsp";
        } else if (!user.getPassword().equals(userEntity.getPassword())) {
            return "redirect:/login.jsp";
        } else {
            addCookie("stuId", user.getStuId(), 10 * 24 * 60 * 60, response);
            addCookie("password", user.getPassword(), 10 * 24 * 60 * 60, response);
            return "index";
        }
    }

    // @RequestMapping(value = "/register", method = RequestMethod.POST)
    // @ResponseBody
    // public Map<String, String> register(@RequestBody User user, HttpServletResponse response) throws Exception {
    //     Map<String, String> result = new HashMap<>();
    //     bookTypeDAO.save(user);
    //     addCookie("uid", user.getUid().toString(), 10 * 24 * 60 * 60, response);
    //     addCookie("username", user.getUsername(), 10 * 24 * 60 * 60, response);
    //     result.put("result", "SUCCESS");
    //     return result;
    // }
    //
    // @RequestMapping(value = "/account/{uid}")
    // public String account(@PathVariable("uid") Integer uid, ModelMap modelMap) {
    //     User user = bookTypeDAO.findByID(uid);
    //     modelMap.addAttribute("user", user);
    //     return "account";
    // }
    //
    // @RequestMapping(value = "/changePasswd/{uid}", method = RequestMethod.POST)
    // public String changePasswd(@PathVariable("uid") Integer uid, String newPassword) {
    //     User user = bookTypeDAO.findByID(uid);
    //     user.setPassword(newPassword);
    //     bookTypeDAO.save(user);
    //     return "homePage";
    // }
    //
    // @RequestMapping(value = "/logout/{uid}")
    // public String logout(@PathVariable("uid") Integer uid, HttpServletResponse response) throws Exception {
    //     User user = bookTypeDAO.findByID(uid);
    //     addCookie("uid", user.getUid().toString(), 0, response);
    //     addCookie("username", user.getUsername(), 0, response);
    //     return "redirect:/";
    // }
}