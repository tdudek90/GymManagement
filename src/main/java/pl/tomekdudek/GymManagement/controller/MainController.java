package pl.tomekdudek.GymManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tomekdudek.GymManagement.model.User;
import pl.tomekdudek.GymManagement.model.form.UserForm;
import pl.tomekdudek.GymManagement.model.repository.UserRepository;

import javax.validation.Valid;


@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/secure/index")
    public String securedHello() {
        return "index secure";
    }

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("userObject", new UserForm());
        return "userForm";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String register(@ModelAttribute("userObject") @Valid UserForm userForm, BindingResult result) {
        if (result.hasErrors()) {
            return "index";
        }

        User userObject = new User(userForm);
        userRepository.save(userObject);
        return "Register succesful!";
    }


}