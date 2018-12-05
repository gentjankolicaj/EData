package edata.web.controller;


import edata.service.InformationService;
import edata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(SignController.BASE_URL)
public class SignController {

    public static final String BASE_URL="/sign";

    private final UserService userService;
    private final InformationService informationService;

    @Autowired
    public SignController(UserService userService, InformationService informationService) {
        this.userService = userService;
        this.informationService = informationService;
    }

    @RequestMapping("")
    public String showSignIn(){

        return "core/signIn";
    }

    @RequestMapping("/")
    public String showSign1(){

        return "core/signIn";
    }

    @RequestMapping("/in")
    public String showSignIn2(){

        return "core/signIn";
    }

    @RequestMapping("/up")
    public String showSignUp(){

        return "core/signUp";
    }
}
