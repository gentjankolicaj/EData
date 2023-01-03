package io.gentjankolicaj.data.load.controller;

import io.gentjankolicaj.data.load.service.InformationService;
import io.gentjankolicaj.data.load.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/user";

    private final UserService userService;
    private final InformationService informationService;

    @Autowired
    public UserController(UserService userService, InformationService informationService) {
        this.userService = userService;
        this.informationService = informationService;
    }

    @RequestMapping("")
    public String showDashboard(Model model) {

        return "core/dashboard/dashboard";
    }


}
