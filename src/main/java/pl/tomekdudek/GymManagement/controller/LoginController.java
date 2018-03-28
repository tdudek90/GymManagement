package pl.tomekdudek.GymManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.tomekdudek.GymManagement.model.LoginInfo;

@Controller
public class LoginController {

    @Autowired
    LoginInfo loginInfo;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/check", method = RequestMethod.GET)
    @ResponseBody
    public String checkLoginStatus() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Is user logged?:" + loginInfo.isUserLogged() + "Authentication:" + authentication.getPrincipal().toString();

    }

}
