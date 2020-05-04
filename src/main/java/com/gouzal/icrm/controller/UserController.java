package com.gouzal.icrm.controller;

import com.gouzal.icrm.entity.User;
import com.gouzal.icrm.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.gouzal.icrm.config.Constant.userEntityName;
import static com.gouzal.icrm.config.Constant.userIconClass;

@Controller
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public String index(Model model,
                        @RequestParam(name = "size", defaultValue = "5", required = false) int pageSize,
                        @RequestParam(name = "page", defaultValue = "0", required = false) int pageNumber) {
        model.addAttribute("entityName", userEntityName);
        model.addAttribute("iconClass", userIconClass);
        model.addAttribute("list", userService.findAll(PageRequest.of((pageNumber > 0) ? (pageNumber - 1) : 0, pageSize)));
        return "users/index";
    }

    @GetMapping("/ajax/users/{id}")
    @ResponseBody
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        User user = userService.findById(id).orElseThrow(() -> new RuntimeException(User.class + " with Id:" + id + " does not existe!"));
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


}
