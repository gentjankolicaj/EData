package edata.web.controller;


import edata.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(HomeController.BASE_URL)
public class HomeController {

    public static final String BASE_URL="/home";

    private final InformationService informationService;

    @Autowired
    public HomeController(InformationService informationService) {
        this.informationService = informationService;
    }

}
