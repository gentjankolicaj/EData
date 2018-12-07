package edata.web.controller;


import edata.common.command.CountryCommand;
import edata.common.command.UserCommand;
import edata.service.CountryService;
import edata.service.InformationService;
import edata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(SignController.BASE_URL)
public class SignController {

    public static final String BASE_URL="/sign";

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
    public String showSignIn(Model model){

        UserCommand userCommand=new UserCommand();

        model.addAttribute("user",userCommand);

        return "core/signIn";
    }

    @RequestMapping("/")
    public String showSign1(Model model){
        UserCommand userCommand=new UserCommand();

        model.addAttribute("user",userCommand);

        return "core/signIn";
    }


    @RequestMapping("/in")
    public String showSignIn2(Model model,UserCommand userCommand){
        String typedEmail=userCommand.getEmail();
        String typedPassword=userCommand.getPassword();

        UserCommand userFound=userService.getByEmailAndPasswordCommand(typedEmail,typedPassword);

        if(userFound==null) {
            return "redirect:/signIn/";
        }else{

            model.addAttribute("authentificatedUser",userFound);
            return "redirect:/user/";    // e ridrejton kerkesen tek ajo uri,ne kete rast kjo uri eshte e mappuar ne userController.
        }

    }

    @RequestMapping("/up")
    public String showSignUp(Model model){
        List<CountryCommand> countries=countryService.getAllCommand();

        model.addAttribute("countries",countries);

        return "core/signUp";
    }


}
