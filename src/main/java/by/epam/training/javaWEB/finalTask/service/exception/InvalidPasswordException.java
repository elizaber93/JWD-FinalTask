package by.epam.training.javaWEB.finalTask.service.exception;


public class InvalidPasswordException extends ServiceException {
    private static final long serialVersionUID = 5579627996438039830L;

    public InvalidPasswordException() {
        super();
    }

    public InvalidPasswordException(String message) {
        super(message);
    }

    public InvalidPasswordException(Exception e) {
        super(e);
    }

    public InvalidPasswordException(String message, Exception e) {
        super(message, e);
    }
}
