package link.stash.user.crud.service.LinkStashUserCRUDService.controller;

import link.stash.user.crud.service.LinkStashUserCRUDService.model.User;
import link.stash.user.crud.service.LinkStashUserCRUDService.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {

    UserService userService = new UserService();

    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<User> register(@RequestBody User user) {

        if (user != null) {
            userService.registerUser(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }


    //TODO refactor login!
    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody User user){
        if (user != null){
            User loggedUser = userService.loginUser(user);
            return new ResponseEntity<>(loggedUser,HttpStatus.OK);
        }
        return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
    }

}
