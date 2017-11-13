package pl.tomekdudek.GymManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tomekdudek.GymManagement.model.User;
import pl.tomekdudek.GymManagement.model.form.UserForm;
import pl.tomekdudek.GymManagement.model.repository.UserRepository;

import javax.validation.Valid;

@Controller
public class RegisterController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/register")
    public String register(Model model) {

        model.addAttribute("userObject", new UserForm());
        return "userForm";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("userObject") @Valid UserForm userForm, BindingResult result) {

        if (result.hasErrors()) {
            return "userForm";
        } else {
            if (isUserExist(userForm.getName())) {
                User userObject = new User(userForm);
                userRepository.save(userObject);
                return "registerSuccess";
            } else
                return "userForm";

        }
    }

    private boolean isUserExist(String username) {
        return userRepository.findAllByName(username) == null;
    }


}
