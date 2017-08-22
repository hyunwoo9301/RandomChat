package com.prisoncrush.api.user;

import com.prisoncrush.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    UserBO userBO;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void create(@RequestParam(required = true) String accountId) {
        userBO.insertUser(accountId);
        return;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User select(@RequestParam(required = true) String accountId) {
        return userBO.selectUser(accountId);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public void update(@Valid User user, BindingResult bindingResult) throws Exception {
        if(bindingResult.hasErrors()) {
            throw new Exception();
        }

        userBO.updateUser(user);
        return;
    }

    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    public void delete(@RequestParam(required = true) String userId) {
        userBO.deleteUser(userId);
        return;
    }

    //TODO: GlobalExceptionHandler 적용
    @ExceptionHandler(Exception.class)
    public void globalExceptionHandler(Exception e){

    }
}
