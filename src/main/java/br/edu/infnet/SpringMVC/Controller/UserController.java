package br.edu.infnet.SpringMVC.Controller;


import br.edu.infnet.SpringMVC.Model.Domain.User;
import br.edu.infnet.SpringMVC.Model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public String login(ModelMap model, @RequestParam String mail, @RequestParam String password) {

        User user = userService.auth(mail, password);
        if (user != null) {
            model.put("user", user);
            return "redirect:/friend";
            
        } else {
            model.addAttribute("error", "User not found.");
            return "login";
        }
    }

    @GetMapping(value = "/user")
    public String showUser(Model model) {

        model.addAttribute("return", "/");

        return "user/signup";
    }


    @PostMapping(value = "/user/adduser")
    public String addUser(User user) {

        userService.addUser(user);

        return "user/message";
    }
}


