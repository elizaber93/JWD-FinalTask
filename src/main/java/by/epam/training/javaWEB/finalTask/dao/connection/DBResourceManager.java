package by.epam.training.javaWEB.finalTask.dao.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBResourceManager {
    private final static DBResourceManager instance = new DBResourceManager();

    public static DBResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key) throws IOException {

        Properties property = new Properties();
        property.load(new FileInputStream("src/main/resources/db.properties"));
        return property.getProperty(key);


    }
}
