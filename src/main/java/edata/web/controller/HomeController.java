package edata.web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(HomeController.BASE_URL)
public class HomeController {

    public static final String BASE_URL="/home";

}
