package pl.tomekdudek.GymManagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.tomekdudek.GymManagement.model.User;
import pl.tomekdudek.GymManagement.model.form.DeleteForm;
import pl.tomekdudek.GymManagement.model.form.UserForm;
import pl.tomekdudek.GymManagement.repository.UserRepository;
import pl.tomekdudek.GymManagement.service.UserServiceImpl;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerUser(Model model) {

        model.addAttribute("userObject", new UserForm());
        return "userForm";

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("userObject") @Valid UserForm userForm, BindingResult result) {

        if (result.hasErrors()) {
            return "userForm";
        } else {
            if (isUserExist(userForm.getName())) {
                User userObject = new User(userForm);
                userService.addUser(userObject);
                return "registerSuccess";
            } else
                return "userForm";

        }
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.GET)
    @ResponseBody
    public User getUser(@PathVariable int userId) {
        return userService.getUser(userId);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateUser(ModelMap model) {
        model.put("editObject", new User());
        return "edit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateUser(@ModelAttribute("editObject") User user) {
        userService.updateUser(user.getId(),user);
        return "editSuccess";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(Model model) {
        model.addAttribute("deleteObject", new DeleteForm());
        return "delete";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteUser(@ModelAttribute("deleteObject") @Valid DeleteForm deleteForm, BindingResult result) {
        if (result.hasErrors()) {
            return "delete";
        } else {
            if (!(isUserExist(deleteForm.getUserId()))) {
                User userObject = new User(deleteForm);
                userService.deleteUser(userObject);
                return "deleteSuccess";
            } else {
                return "delete";
            }
        }
    }

    private boolean isUserExist(int id) {
        return userRepository.findAllById(id) == null;
    }


    private boolean isUserExist(String username) {
        return userRepository.findAllByName(username) == null;
    }

}
