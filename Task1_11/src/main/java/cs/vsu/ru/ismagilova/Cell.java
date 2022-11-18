package cs.vsu.ru.ismagilova;

public class Cell {

    private String value;

    protected Cell(String value) {
        this.value = value;
    }

    protected void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return value;
    }
}
