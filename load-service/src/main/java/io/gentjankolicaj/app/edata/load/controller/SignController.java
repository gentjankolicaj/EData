package io.gentjankolicaj.app.edata.load.controller;


import io.gentjankolicaj.app.edata.load.command.CountryCmd;
import io.gentjankolicaj.app.edata.load.command.UserCmd;
import io.gentjankolicaj.app.edata.load.service.CountryService;
import io.gentjankolicaj.app.edata.load.service.InformationService;
import io.gentjankolicaj.app.edata.load.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static java.util.Objects.isNull;

@Controller
@RequestMapping(SignController.BASE_URL)
public class SignController {

    public static final String BASE_URL = "/sign";

    private final UserService userService;
    private final InformationService informationService;
    private final CountryService countryService;

    @Autowired
    public SignController(UserService userService, InformationService informationService, CountryService countryService) {
        this.userService = userService;
        this.informationService = informationService;
        this.countryService = countryService;
    }

    @RequestMapping("")
    public String showSignIn(Model model) {
        UserCmd userCmd = new UserCmd();
        model.addAttribute("user", userCmd);
        return "core/signIn";
    }

    @RequestMapping("/")
    public String showSign1(Model model) {
        UserCmd userCmd = new UserCmd();
        model.addAttribute("user", userCmd);
        return "core/signIn";
    }


    @RequestMapping("/in")
    public String showSignIn2(Model model, UserCmd userCmd) {
        String typedEmail = userCmd.getEmail();
        String typedPassword = userCmd.getPassword();

        UserCmd userCmdFound = userService.getByEmailAndPasswordCommand(typedEmail, typedPassword);

        if (isNull(userCmdFound)) {
            return "redirect:/signIn/";
        } else {
            model.addAttribute("authentificatedUser", userCmdFound);
            return "redirect:/user/";    // e ridrejton kerkesen tek ajo uri,ne kete rast kjo uri eshte e mapuar ne userController.
        }

    }

    @RequestMapping("/up")
    public String showSignUp(Model model) {
        List<CountryCmd> countries = countryService.getAllCommand();
        model.addAttribute("countries", countries);
        return "core/signup";
    }


}
