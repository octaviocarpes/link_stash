package link.stash.user.crud.service.LinkStashUserCRUDService.controller;

import link.stash.user.crud.service.LinkStashUserCRUDService.model.Account;
import link.stash.user.crud.service.LinkStashUserCRUDService.model.User;
import link.stash.user.crud.service.LinkStashUserCRUDService.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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
    public ResponseEntity<User> login(@RequestBody Account account){
        String email = account.getUserEmail();
        String encodedPassword = account.getUserPassword();
        if (email != null && encodedPassword != null){
            User loggedUser = userService.loginUser(email, encodedPassword);
            if (loggedUser == null){
                return new ResponseEntity<>(loggedUser, HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(loggedUser,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
