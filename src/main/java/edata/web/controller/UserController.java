package edata.web.controller;

import edata.service.InformationService;
import edata.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL="/user";

    private final UserService userService;
    private final InformationService informationService;

    @Autowired
    public UserController(UserService userService, InformationService informationService) {
        this.userService = userService;
        this.informationService = informationService;
    }
}
