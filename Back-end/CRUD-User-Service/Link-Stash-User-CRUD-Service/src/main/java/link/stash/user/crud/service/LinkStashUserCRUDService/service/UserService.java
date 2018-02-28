package link.stash.user.crud.service.LinkStashUserCRUDService.service;

import link.stash.user.crud.service.LinkStashUserCRUDService.dao.UserDAO;
import link.stash.user.crud.service.LinkStashUserCRUDService.model.User;

public class UserService {

    public UserService() {
    }

    public void registerUser(User user) {
        if(verifyUser(user) == false){
            UserDAO userDAO = new UserDAO();
            user.setActive(true);
            userDAO.register(user);
        }
    }

    public boolean verifyUser(User user){
        UserDAO userDAO = new UserDAO();
        userDAO.verify(user);
        return false;
    }
}
