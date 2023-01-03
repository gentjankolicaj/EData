package io.gentjankolicaj.data.load.api.v1.controller;

import io.gentjankolicaj.data.load.common.dto.UserDTO;
import io.gentjankolicaj.data.load.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UserRestController.BASE_URI)
public class UserRestController {

    public static final String BASE_URI = "/api/v1/users/";

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @PreAuthorize("hasAnyRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("")
    public List<UserDTO> getAllUsers() {
        return userService.getAllDTO();
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("{id}")
    private UserDTO getUserById(@PathVariable("id") Long id) {
        return userService.getByIdDTO(id);
    }


    @RequestMapping("*")
    public ResponseEntity<Object> otherNotMappedRequests() {
        return new ResponseEntity<>("Wrong uri", new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

}
