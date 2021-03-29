package by.epam.training.javaWEB.finalTask.bean;

public enum Role {
    ADMIN(1),
    CLIENT(2),
    COURIER(3),
    SERVICE_STAFF(4);

    int idRole;

    private Role(int id) {
        this.idRole = id;
    }
    public int getIdRole() {
        return this.idRole;
    }
}
