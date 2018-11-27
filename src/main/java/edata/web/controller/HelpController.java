package edata.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(HelpController.BASE_URL)
public class HelpController {

    public static final String BASE_URL="/help";
}
