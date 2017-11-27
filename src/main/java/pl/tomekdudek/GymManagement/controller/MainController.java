package pl.tomekdudek.GymManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.tomekdudek.GymManagement.model.form.ContactForm;
import pl.tomekdudek.GymManagement.repository.UserRepository;
import pl.tomekdudek.GymManagement.service.MailService;


@Controller
public class MainController {

    @Autowired
    UserRepository userRepository;


    @Autowired
    MailService mailService;

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

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("mailObject", new ContactForm());
        return "contact";
    }

    @PostMapping("/contact")
    public String contact(ContactForm contactForm, Model model) {
        model.addAttribute("mailObject", new ContactForm());

        mailService.sendEmail("ttomekk0@gmail.com", new ContactForm(contactForm.getName(), contactForm.getEmail(), contactForm.getPhoneNumber(), contactForm.getMessage()));
        return "contactSuccess";
    }


}