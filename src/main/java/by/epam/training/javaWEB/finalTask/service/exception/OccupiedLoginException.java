package by.epam.training.javaWEB.finalTask.service.exception;

import by.epam.training.javaWEB.finalTask.service.exception.ServiceException;

public class OccupiedLoginException extends ServiceException  {
    private static final long serialVersionUID = 5579627996438039831L;

    public OccupiedLoginException() {
        super();
    }

    public OccupiedLoginException(String message) {
        super(message);
    }

    public OccupiedLoginException(Exception e) {
        super(e);
    }

    public OccupiedLoginException(String message, Exception e) {
        super(message, e);
    }
}
