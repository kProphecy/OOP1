package cs.vsu.ru.ismagilova;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Таблица
 * Представляет из себя основную логику таска
 * Класс имеет 2 глобавльные переменные (tableOfRows, tableOfColumns), сделано для оптимизации времени
 * (Сами переменные являются контейнерами(вся инфа о нем в соответствующем классе)
 * Если мы хотим получить строку, то обращаемся к таблице строк, если хотим получить колонку, то обращаемся
 * к таблице колонок
 * Ну и была выполнена небольшая оптимизация таска, чтобы время выполнения в некоторых случаях было чуть меньше
 * (например, при получении элемента по индексам, в зависимости от индекса шел выбор, по какому контейнеру идти)
 * Вся остальная информация ниже
 */

public class Table {

    private Container tableOfRows; //контейнер строк

    private Container tableOfColumns;  //контейнер столбцов

    //Конструктор таблицы
    public Table() {
        tableOfRows = new Container();
        tableOfColumns = new Container();
    }

    //Вставка значения в ячейку по двум координатам
    public void insertValue(int indexRow, int indexColumn, String value) {
        extendTables(indexRow, indexColumn);
        tableOfRows.setValueByIndexes(indexRow, indexColumn, value);
        tableOfColumns.setValueByIndexes(indexColumn, indexRow, value);
    }

    //Очистка значения в ячейке по двум индексам
    public void clearValue(int indexRow, int indexColumn) {
        tableOfRows.clearValue(indexRow, indexColumn);
        tableOfColumns.clearValue(indexColumn, indexRow);
    }

    //Очистка строки
    public void clearRow(int indexRow) {
        tableOfRows.clearRow(indexRow);
        tableOfColumns.clearColumn(indexRow);
    }

    //Очистка колонки
    public void clearColumn(int indexColumn) {
        tableOfRows.clearColumn(indexColumn);
        tableOfColumns.clearRow(indexColumn);
    }

    //Метод вывода значения ячейки, которую мы хотим получить по координатам строки и столбца
    public void outputValue(int indexRow, int indC) {
        System.out.println(getValue(indexRow, indC));
    }

    //Вывод таблицы строк
    public void outputTableOfRows() {
        tableOfRows.outputTable();
    }

    //Вывод таблицы колонок
    public void outputTableOfColumns() {
        tableOfColumns.outputTable();
    }

    //Вывод строки
    public void outputRow(int indexRow) {
        List<Cell> row = getRow(indexRow);
        List<String> string = listCellToListString(row);
        System.out.print(String.join(", ", string));
    }

    //Вывод колонки
    public void outputColumn(int indexColumn) {
        List<Cell> column = getColumn(indexColumn);
        List<String> string = listCellToListString(column);
        System.out.print(String.join(", ", string));
    }

    //Очистка таблицы
    public void clear() {
        tableOfRows.clearTable();
        tableOfColumns.clearTable();
    }

    //Метод расширения таблицы (передаются индексы)
    //Необходим для листов, тк лист из себя представляет массив,
    //то есть, если у нас нет ячейки под нужным индексом  - вылетит ошибка
    //Чтобы этого не было, сделан этот метод, для создания пустых ячеек в листе
    private void extendTables(int firstIndex, int secondIndex) {
        extendTableOfRows(firstIndex, secondIndex);
        extendTableOfColumns(secondIndex, firstIndex);
    }

    //Метод, реализующий логику расширения контейнера строк
    private void extendTableOfRows(int indexRow, int indexColumn) {
        extendTemplate(indexRow, indexColumn, tableOfRows);
    }

    //Метод, реал. логику расширения контейнера столбцов
    private void extendTableOfColumns(int indexRow, int indexColumn) {
        extendTemplate(indexRow, indexColumn, tableOfColumns);
    }

    //Самый основной метод расширения, который является универсальным)
    //В него мы передаем индекс строк, столбца и необходимый контейнер для расширения
    private void extendTemplate(int indexRow, int indexColumn, Container container) {
        if (container.getSize() - 1 < indexRow) {
            while (container.getSize() != indexRow + 1) {
                container.addVector(container.getSize());
            }
        }
        List<Cell> string = container.getListOfCell(indexRow);
        container.extendVector(indexColumn,string);
    }

    //Метод получения значения ячейки (Как я говорил, с небольшой оптимизацией)
    //В зависимости от индексов, будет выбираться более оптимальный контейнер
    private String getValue(int indexRow, int indexColumn) {
        if (indexRow > indexColumn) {
            return tableOfRows.getValueByIndexes(indexRow, indexColumn);
        } else return tableOfColumns.getValueByIndexes(indexColumn, indexRow);
    }

    //Метод получения строки (стоит обратить внимание на возвращаемый тип строки)
    private List<Cell> getRow(int indexRow) {
        return tableOfRows.getListOfCell(indexRow);
    }

    //Преобразование List ячеек в лист с элементами параметра String (Нужен просто для методов Output)
    private List<String> listCellToListString(List<Cell> list) {
        List<String> newList = new ArrayList<>();
        for (Cell cell: list) {
            newList.add(cell.toString());
        }
        return newList;
    }

    //Метод получения строки
    private List<Cell> getColumn(int indexColumn) {
        return tableOfColumns.getListOfCell(indexColumn);
    }

}
