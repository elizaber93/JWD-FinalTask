package by.epam.training.javaWEB.finalTask.controller.listener;

import by.epam.training.javaWEB.finalTask.dao.connection.ConnectionPool;
import by.epam.training.javaWEB.finalTask.dao.connection.ConnectionPoolException;
import org.apache.log4j.Logger;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            ConnectionPool.getInstance().initPoolData();
        } catch (ConnectionPoolException e){
            Logger.getLogger(ContextListener.class).info(e.getMessage());
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            ConnectionPool.getInstance().dispose();
        } catch (ConnectionPoolException e) {
            Logger.getLogger(ContextListener.class).info(e.getMessage());
            throw new RuntimeException("Failed to destroy context",e);
        }
    }
}
