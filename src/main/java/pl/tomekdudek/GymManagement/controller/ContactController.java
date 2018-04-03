package pl.tomekdudek.GymManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tomekdudek.GymManagement.model.form.ContactForm;
import pl.tomekdudek.GymManagement.service.MailService;

import javax.validation.Valid;

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
    public String contact(@ModelAttribute("mailObject") @Valid ContactForm contactForm, BindingResult result) {
        if (result.hasErrors()) {
            return "contact";
        } else {
            String message  = "Name: " + contactForm.getName() + "Mail: " + contactForm.getEmail() + "Phone number: " + contactForm.getPhoneNumber() + "Message: " + contactForm.getMessage();
            mailService.sendEmail("ttomekk0@gmail.com",message);
            return "contactSuccess";
        }
    }
}
