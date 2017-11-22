package pl.tomekdudek.GymManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.tomekdudek.GymManagement.model.User;
import pl.tomekdudek.GymManagement.repository.UserRepository;

@Controller
public class EditController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/edit")
    public String edit(ModelMap model) {
        model.put("editObject", new User());
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("editObject") User user) {
        User currentUser = userRepository.findAllById(user.getId());
        if (user.getName().isEmpty()) {
            user.setName(currentUser.getName());
        }
        if (user.getLastname().isEmpty()) {
            user.setLastname(currentUser.getLastname());
        }
        if (user.getMail().isEmpty()) {
            user.setMail(currentUser.getMail());
        }
        if (user.getPassword().isEmpty()) {
            user.setPassword(currentUser.getPassword());
        }
        userRepository.save(user);
        return "editSuccess";
    }

}
