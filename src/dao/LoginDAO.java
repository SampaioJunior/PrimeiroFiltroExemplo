package dao;

import connection.ConnectionFactory;
import model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO {

    public LoginDAO() {

    }

    public static Login adiciona(String user, String pass){
        Connection connection = new ConnectionFactory().getConnection();

        try {
        String sql = "INSERT INTO usuario" + "(user, pass)" + "VALUES (?,?)";

            PreparedStatement stm =  connection.prepareStatement(sql);

            Login log = new Login();
            ResultSet res = stm.getResultSet();
            res.next();

            log.setUser(res.getString("user"));
            log.setPass(res.getString("pass"));

            stm.execute();
            stm.close();
            return log;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
