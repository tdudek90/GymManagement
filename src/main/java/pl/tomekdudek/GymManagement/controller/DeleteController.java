package pl.tomekdudek.GymManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.tomekdudek.GymManagement.model.User;
import pl.tomekdudek.GymManagement.model.form.DeleteForm;
import pl.tomekdudek.GymManagement.repository.UserRepository;

import javax.validation.Valid;

@Controller
public class DeleteController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/delete")
    public String deleteUser(Model model) {
        model.addAttribute("deleteObject", new DeleteForm());
        return "delete";
    }

    @PostMapping("/delete")
    public String deleteUser(@ModelAttribute("deleteObject") @Valid DeleteForm deleteForm, BindingResult result) {
        if (result.hasErrors()) {
            return "delete";
        } else {
            if (!(isUserExist(deleteForm.getUserId()))) {
                User userObject = new User(deleteForm);
                userRepository.findAllById(deleteForm.getUserId());
                userRepository.delete(userObject);
                return "deleteSuccess";
            } else {
                return "delete";
            }
        }
    }

    private boolean isUserExist(int id) {
        return userRepository.findAllById(id) == null;
    }
}
