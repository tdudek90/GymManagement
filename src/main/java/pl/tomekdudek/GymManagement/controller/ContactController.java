package pl.tomekdudek.GymManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tomekdudek.GymManagement.model.form.ContactForm;
import pl.tomekdudek.GymManagement.service.MailService;

@Controller
public class ContactController {

    @Autowired
    MailService mailService;

    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contact(Model model) {
        model.addAttribute("mailObject", new ContactForm());
        return "contact";
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public String contact(ContactForm contactForm, Model model) {
        model.addAttribute("mailObject", new ContactForm());

        mailService.sendEmail("ttomekk0@gmail.com", new ContactForm(contactForm.getName(), contactForm.getEmail(), contactForm.getPhoneNumber(), contactForm.getMessage()));
        return "contactSuccess";
    }
}
