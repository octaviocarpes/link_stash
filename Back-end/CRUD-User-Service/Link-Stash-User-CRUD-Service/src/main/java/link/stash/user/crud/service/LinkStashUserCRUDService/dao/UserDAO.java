package link.stash.user.crud.service.LinkStashUserCRUDService.dao;

import link.stash.user.crud.service.LinkStashUserCRUDService.model.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.misc.BASE64Decoder;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.sql.*;
import java.util.Base64;

public class UserDAO {

    private PasswordEncoder encoder;
    private BASE64Decoder decoder;

    public UserDAO() {
        this.encoder = new BCryptPasswordEncoder();
        this.decoder = new BASE64Decoder();
    }



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

    public User login(String email, String password) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/link_stash","root","senha");
            String sql = "SELECT * FROM user " +
                         "WHERE email = '" + email + "'";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()){
                String name = rs.getString("name");
                String lastName = rs.getString("last_name");
                String emailDB = rs.getString("email");
                String passwordDB = rs.getString("password");
                User loggedUser = new User();

                loggedUser.setActive(true);
                loggedUser.setName(name);
                loggedUser.setLastName(lastName);
                loggedUser.setEmail(emailDB);
                loggedUser.setPassword(passwordDB);

                try {
                    if (encoder.matches(new String (decoder.decodeBuffer(password)), passwordDB)){
                        return loggedUser;
                    }else{
                        return null;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
