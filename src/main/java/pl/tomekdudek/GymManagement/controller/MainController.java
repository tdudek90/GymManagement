package pl.tomekdudek.GymManagement.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/rest/test")
@RestController
public class MainController {

    @GetMapping("/index")
    public String index() {
        return "Index";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/secure/index")
    public String securedHello() {
        return "index secure";
    }


}