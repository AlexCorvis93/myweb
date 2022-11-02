package crud.myweb.controller;

import crud.myweb.models.User;
import crud.myweb.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAll(ModelMap m) {
        m.addAttribute("users", userService.users());
        return "user/index";
    }



    @GetMapping("/new")
    public String newUser(ModelMap m) {
        m.addAttribute("user", new User());
        return "user/new";
    }

    @PostMapping(value = "/")
    public String createUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "user/new";
        }
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(ModelMap m,  @PathVariable("id") int id ) {
        m.addAttribute("user", userService.showUser(id));
        return "user/edit";

    }

    @PatchMapping(value = "/{id}")
    public String update(@ModelAttribute("user") @Valid User user, BindingResult bindingResult, @PathVariable("id") int id) {
        if (bindingResult.hasErrors()) {
            return "user/edit";
        }
        userService.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping(value = "/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.remove(id);
        return "redirect:/";
    }


}
