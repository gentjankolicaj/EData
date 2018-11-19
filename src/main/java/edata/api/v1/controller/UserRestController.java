package edata.api.v1.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(UserRestController.BASE_URI)
public class UserRestController {

    public static final String BASE_URI="/api/v1/users/";

}
