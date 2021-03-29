package by.epam.training.javaWEB.finalTask.bean;

public enum Rating {
    R1(1),
    R2(2),
    R3(3),
    R4(4),
    R5(5);

    int value;
    private Rating(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
