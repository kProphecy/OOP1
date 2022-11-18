package cs.vsu.ru.ismagilova;


/**
 * Класс Ячейка
 * (Обычная ячейка таблицы)
 */

public class Cell {

    private String value;  //Ячейка хранит значение

    //Конструктор(Входной параметр стринговое значение
    protected Cell(String value) {
        this.value = value;
    }

    //Обычный сеттер
    protected void setValue(String value) {
        this.value = value;
    }

    //Cell в toString (получаем value) (Тк при return объекта параметра Cell
    // мы не получаем его value, для этого необходим метод toString)
    @Override
    public String toString() {
        return value;
    }
}
