package by.epam.training.javaWEB.finalTask.dao.connection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBResourceManager {
    private final static DBResourceManager instance = new DBResourceManager();

    public static DBResourceManager getInstance() {
        return instance;
    }

    public String getValue(String key) throws IOException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("db.properties");
// ...
        Properties properties = new Properties();
        properties.load(input);

        return properties.getProperty(key);


    }
}
