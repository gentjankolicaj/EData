package edata.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL="/user";

}
