package cs.vsu.ru.ismagilova;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс Container
 * Имеет глобал. переменную List<List<Cell>> dataList (Т.е является Листом Листов ячеек)
 * Это по сути реализация двумерного массива <List<Cell> представляет из себя лист ячеек
 * А List<List<Cell>> является листом листов(как уже говорил выше, надеюсь что то из этого понятно)
 *
 * P.S. В методе clearValue происходит setValue("") - это сделано по аналогии с экселем, что мы не удаляем ячейку,
 * а просто ее делаем пустой
 */

public class Container {

    private List<List<Cell>> dataList;  //Просто Лист в листе

    //Очередной конструктор
    protected Container() {
        dataList = new ArrayList<>();
    }

    //получение List<Cell> - обычный геттер
    protected List<Cell> getListOfCell(int index) {
        return dataList.get(index);
    }

    //Метод вывода контейнера
    protected void outputTable() {
        for (List<Cell> list : dataList) {
            for (Cell cell : list) {
                System.out.print(cell.toString() + " ");
            }
            System.out.println();
        }
    }

    //Получение значения по индексам в контейнере
    protected String getValueByIndexes(int indexRow, int indexColumn) {
        return dataList.get(indexRow).get(indexColumn).toString();
    }

    //Очистка значения в ячейке(Делаем ячейку пустой, но не удаляем)
    protected void clearValue(int indexRow, int indexColumn) {
        dataList.get(indexRow).get(indexColumn).setValue("");
    }

    //метод очистки всей строки
    protected void clearRow(int indexRow) {
        for (int i = 0; i < getNumberOfElementsInRow(indexRow); i++) {
            clearValue(indexRow, i);
        }
    }

    //метод очистки столбца
    protected void clearColumn(int indexColumn) {
        for (int i = 0; i < getSize(); i++) {
            clearValue(i, indexColumn);
        }
    }

    //Сеттер значения по индексам
    protected void setValueByIndexes(int rowIndex, int columnIndex, String value) {
        dataList.get(rowIndex).get(columnIndex).setValue(value);
    }

    //Очистка контейнера
    protected void clearTable() {
        dataList.clear();
    }

    //Получение количества List<Cell> (Т.к List внешний может хранить множество
    //List<Cell>, поэтому вы возвращаем количество этих внутренних листов
    protected int getSize() {
        return dataList.size();
    }

    //Метод добавления List<Cell> в List<List<Cell>>
    protected List<Cell> addVector(int index) {
        List<Cell> vector = new ArrayList<>();
        dataList.add(index, vector);
        return vector;
    }

    //Метод расширения List<Cell> (Как я уже писал в одном из классов,
    //что лист представляет из себя массив и чтобы не вылетала ошибка, его нужно расширять
    //если у нас нет нужного иднекста
    protected void extendVector(int index, List<Cell> string) {
        if (string.size() - 1 < index) {
            for (int i = string.size(); i <= index; i++) {
                string.add(i, new Cell(""));
            }
        }
    }

    //Метод получения максимального индекса элемента в List<Cell>
    private int getNumberOfElementsInRow(int indexRow) {
        return dataList.get(indexRow).size() - 1;
    }
}
