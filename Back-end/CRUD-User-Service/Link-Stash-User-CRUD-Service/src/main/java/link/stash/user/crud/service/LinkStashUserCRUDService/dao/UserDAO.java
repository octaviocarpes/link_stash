package link.stash.user.crud.service.LinkStashUserCRUDService.dao;

import link.stash.user.crud.service.LinkStashUserCRUDService.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.*;

public class UserDAO {


    PasswordEncoder encoder = new BCryptPasswordEncoder();

    public boolean verify(User user) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/link_stash", "root", "senha");
            String sql = "SELECT * from user where 'email' = '"+ user.getEmail()+"'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()){
                if(rs.getString("email").equals(user.getEmail())){
                    connection.close();
                    return true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void register(User user) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/link_stash","root","senha");
            String sql = "insert into user(name,last_name,email, password,active)" +
                         "values('"+user.getName()+"','"+user.getLastName()+"','"+user.getEmail()+"','"+ encoder.encode(user.getPassword())+"',"+user.isActive()+")";

            Statement statement = connection.createStatement();
            statement.execute(sql);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
