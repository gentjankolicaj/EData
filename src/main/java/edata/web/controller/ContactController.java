package edata.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(ContactController.BASE_URL)
public class ContactController {

    public static final String BASE_URL="/contact";
}
