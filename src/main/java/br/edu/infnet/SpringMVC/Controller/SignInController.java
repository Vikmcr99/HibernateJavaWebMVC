package br.edu.infnet.SpringMVC.Controller;


import br.edu.infnet.SpringMVC.Model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SignInController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/")
    public String LoginScreen() {
        return "login";
    }
}
