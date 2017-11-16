package pl.tomekdudek.GymManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tomekdudek.GymManagement.repository.UserRepository;


@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/")
    public String homePage() {
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/secure/index")
    public String securedHello() {
        return "index secure";
    }


}