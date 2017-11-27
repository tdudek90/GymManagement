package pl.tomekdudek.GymManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.tomekdudek.GymManagement.model.form.ContactForm;

import javax.mail.internet.MimeMessage;

@Service
public class MailService {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendEmail(String addressee, ContactForm contactForm) {
        MimeMessage mail = javaMailSender.createMimeMessage();
        contactForm = new ContactForm(contactForm.getName(), contactForm.getEmail(), contactForm.getPhoneNumber(), contactForm.getMessage());
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(addressee);
            String message = "Name: " + contactForm.getName() + "Mail: " + contactForm.getEmail() + "Phone number: " + contactForm.getPhoneNumber() + "Message: " + contactForm.getMessage();
            helper.setText(message, true);

        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mail);
    }
}
