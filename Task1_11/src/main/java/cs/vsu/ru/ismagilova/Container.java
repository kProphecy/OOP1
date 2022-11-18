package cs.vsu.ru.ismagilova;

import java.util.ArrayList;
import java.util.List;

public class Container {

    private List<List<Cell>> dataList;

    protected Container() {
        dataList = new ArrayList<>();
    }

    protected List<Cell> getListOfCell(int index) {
        return dataList.get(index);
    }

    protected void outputTable() {
        for (List<Cell> list : dataList) {
            for (Cell cell : list) {
                System.out.print(cell.toString() + " ");
            }
            System.out.println();
        }
    }

    protected String getValueByIndexes(int indexRow, int indexColumn) {
        return dataList.get(indexRow).get(indexColumn).toString();
    }

    protected void clearValue(int indexRow, int indexColumn) {
        dataList.get(indexRow).get(indexColumn).setValue("");
    }

    protected void clearRow(int indexRow) {
        for (int i = 0; i < getNumberOfElementsInRow(indexRow); i++) {
            clearValue(indexRow, i);
        }
    }

    protected void clearColumn(int indexColumn) {
        for (int i = 0; i < getSize(); i++) {
            clearValue(i, indexColumn);
        }
    }

    protected void setValueByIndexes(int rowIndex, int columnIndex, String value) {
        dataList.get(rowIndex).get(columnIndex).setValue(value);
    }

    protected void clearTable() {
        dataList.clear();
    }

    protected int getSize() {
        return dataList.size();
    }

    protected List<Cell> addVector(int index) {
        List<Cell> vector = new ArrayList<>();
        dataList.add(index, vector);
        return vector;
    }

    protected void extendVector(int index, List<Cell> string) {
        if (string.size() - 1 < index) {
            for (int i = string.size(); i <= index; i++) {
                string.add(i, new Cell(""));
            }
        }
    }

    private int getNumberOfElementsInRow(int indexRow) {
        return dataList.get(indexRow).size() - 1;
    }
}
