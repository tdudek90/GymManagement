package pl.tomekdudek.GymManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.tomekdudek.GymManagement.model.LoginInfo;

@Controller
public class LoginController {

    @Autowired
    LoginInfo loginInfo;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/check")
    @ResponseBody
    public String checkLoginStatus() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Is user logged?:" + loginInfo.isUserLogged() + "Authentication:" + authentication.getPrincipal();

    }

}
