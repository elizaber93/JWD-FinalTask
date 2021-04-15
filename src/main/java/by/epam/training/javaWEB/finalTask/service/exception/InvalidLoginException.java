package by.epam.training.javaWEB.finalTask.service.exception;

public class InvalidLoginException extends ServiceException {
    private static final long serialVersionUID = 5579627996438039830L;

    public InvalidLoginException() {
        super();
    }

    public InvalidLoginException(String message) {
        super(message);
    }

    public InvalidLoginException(Exception e) {
        super(e);
    }

    public InvalidLoginException(String message, Exception e) {
        super(message, e);
    }
}
