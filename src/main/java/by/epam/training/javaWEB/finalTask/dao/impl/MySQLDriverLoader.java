package by.epam.training.javaWEB.finalTask.dao.impl;

import by.epam.training.javaWEB.finalTask.dao.DBDriverException;

public class MySQLDriverLoader {
    private static final MySQLDriverLoader instance = new MySQLDriverLoader();

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new DBDriverException(e);
        }
    }

    private MySQLDriverLoader() {}

    public static MySQLDriverLoader getInstance() {
        return instance;
    }
}
