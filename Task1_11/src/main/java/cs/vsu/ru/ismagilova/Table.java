package cs.vsu.ru.ismagilova;

import java.util.ArrayList;
import java.util.List;

public class Table {

    private Container tableOfRows;

    private Container tableOfColumns;

    public Table() {
        tableOfRows = new Container();
        tableOfColumns = new Container();
    }

    public void insertValue(int indexRow, int indexColumn, String value) {
        extendTables(indexRow, indexColumn);
        tableOfRows.setValueByIndexes(indexRow, indexColumn, value);
        tableOfColumns.setValueByIndexes(indexColumn, indexRow, value);
    }

    public void clearValue(int indexRow, int indexColumn) {
        tableOfRows.clearValue(indexRow, indexColumn);
        tableOfColumns.clearValue(indexColumn, indexRow);
    }

    public void clearRow(int indexRow) {
        tableOfRows.clearRow(indexRow);
        tableOfColumns.clearColumn(indexRow);
    }

    public void clearColumn(int indexColumn) {
        tableOfRows.clearColumn(indexColumn);
        tableOfColumns.clearRow(indexColumn);
    }

    public void printValue(int indexRow, int indColumn) {
        System.out.println(getValue(indexRow, indColumn));
    }

    public void printTable() {
        tableOfRows.outputTable();
    }

    public void printTableOfColumns() {
        tableOfColumns.outputTable();
    }

    public void printRow(int indexRow) {
        List<Cell> row = getRow(indexRow);
        List<String> string = listCellToListString(row);
        System.out.println(String.join(", ", string));
    }

    public void printColumn(int indexColumn) {
        List<Cell> column = getColumn(indexColumn);
        List<String> string = listCellToListString(column);
        System.out.println(String.join(", ", string));
    }

    public void clear() {
        tableOfRows.clearTable();
        tableOfColumns.clearTable();
    }

    private void extendTables(int firstIndex, int secondIndex) {
        extendTableOfRows(firstIndex, secondIndex);
        extendTableOfColumns(secondIndex, firstIndex);
    }

    private void extendTableOfRows(int indexRow, int indexColumn) {
        extendTemplate(indexRow, indexColumn, tableOfRows);
    }

    private void extendTableOfColumns(int indexRow, int indexColumn) {
        extendTemplate(indexRow, indexColumn, tableOfColumns);
    }

    private void extendTemplate(int indexRow, int indexColumn, Container container) {
        if (container.getSize() - 1 < indexRow) {
            while (container.getSize() != indexRow + 1) {
                container.addVector(container.getSize());
            }
        }
        List<Cell> string = container.getListOfCell(indexRow);
        container.extendVector(indexColumn,string);
    }

    private String getValue(int indexRow, int indexColumn) {
        if (indexRow > indexColumn) {
            return tableOfRows.getValueByIndexes(indexRow, indexColumn);
        } else return tableOfColumns.getValueByIndexes(indexColumn, indexRow);
    }

    private List<Cell> getRow(int indexRow) {
        return tableOfRows.getListOfCell(indexRow);
    }

    private List<String> listCellToListString(List<Cell> list) {
        List<String> newList = new ArrayList<>();
        for (Cell cell: list) {
            newList.add(cell.toString());
        }
        return newList;
    }

    private List<Cell> getColumn(int indexColumn) {
        return tableOfColumns.getListOfCell(indexColumn);
    }

}
