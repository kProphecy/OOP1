package cs.vsu.ru.ismagilova;

public class Main {

    /**
     * Здесь мы просто проводим тест вставки значений, вывода таблицы и тд
     * Сначала создается таблица в 11 строке, потом происходит проверка методов
     */

    public static void main(String[] args) {
        Table table = new Table();
        table.insertValue(5, 5,"224");
        table.insertValue(3, 5,"2");
        table.insertValue(1, 2,"234");
        table.insertValue(1, 3,"23");
        table.outputTableOfRows();
        System.out.println("---------------------------------------------------------------\n");
        table.outputValue(5, 5);
        System.out.println("---------------------------------------------------------------\n");
        table.outputRow(1);
        table.outputTableOfColumns();
        table.outputTableOfRows();

    }
}