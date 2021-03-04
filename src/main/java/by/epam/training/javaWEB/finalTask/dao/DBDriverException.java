package by.epam.training.javaWEB.finalTask.dao;

public class DBDriverException extends RuntimeException {
    public DBDriverException(Exception e) {
        super(e);
    }
}
