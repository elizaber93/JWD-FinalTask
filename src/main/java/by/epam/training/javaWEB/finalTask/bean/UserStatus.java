package by.epam.training.javaWEB.finalTask.bean;

public enum UserStatus {
    ACTIVE(1),
    LOCKED(2),
    DELETED(3);

    int id;
    UserStatus(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
}
