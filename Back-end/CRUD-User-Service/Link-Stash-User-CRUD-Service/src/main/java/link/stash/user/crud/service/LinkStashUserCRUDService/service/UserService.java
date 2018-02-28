package link.stash.user.crud.service.LinkStashUserCRUDService.service;

import link.stash.user.crud.service.LinkStashUserCRUDService.dao.UserDAO;
import link.stash.user.crud.service.LinkStashUserCRUDService.model.User;

public class UserService {

    private UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    public void registerUser(User user) {
        if(verifyUser(user) == false){
            user.setActive(true);
            userDAO.register(user);
        }
    }

    public boolean verifyUser(User user){
        userDAO.verify(user);
        return false;
    }

    public User loginUser(User user) {
        if (verifyUser(user) == false){
            return userDAO.login(user);
        }
        return null;
    }
}
