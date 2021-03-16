package by.epam.training.javaWEB.finalTask;

import by.epam.training.javaWEB.finalTask.bean.RegistrationInfo;
import by.epam.training.javaWEB.finalTask.connection.ConnectionPool;
import by.epam.training.javaWEB.finalTask.connection.ConnectionPoolException;
import by.epam.training.javaWEB.finalTask.dao.DAOException;
import by.epam.training.javaWEB.finalTask.dao.impl.SQLUserDAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws ConnectionPoolException, SQLException, IOException {
        //ConnectionPool connectionPool = new ConnectionPool();
        //connectionPool.initPoolData();
        /*Connection connection = ConnectionPool.getInstance().takeConnection();

        Statement statement = connection.createStatement();

        String query = "select * from suppliers";
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            System.out.printf("%d. %s \n", id, name);
        }

         */

        RegistrationInfo regInfo = new RegistrationInfo();
        regInfo.setLogin("eliz");
        regInfo.setPassword("12345");
        SQLUserDAO sqlUserDAO = new SQLUserDAO();
        try {
            sqlUserDAO.registration(regInfo);
        } catch (DAOException e) {
            System.out.println("регистрация не удалась");
        }
    }
}
