package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.HashMap;

public class DataFrame {
    private ArrayList<Column> columns;
    private ArrayList<String> columnNames;
    private HashMap<String, Integer> columnIndexes;
    private int columnCount;

    public DataFrame() {
        columns = new ArrayList<Column>();
        columnNames = new ArrayList<String>();
        columnIndexes = new HashMap<String, Integer>();
        columnCount = 0;
    }

    public void addColumn(Column column) {
        columns.add(column);
        String columnName = column.getName();
        columnNames.add(columnName);
        columnIndexes.put(columnName, columnCount);
        columnCount++;
    }

    public ArrayList<String> getColumnNames() {
        return columnNames;
    }

    public int getRowCount() {
        return columns.get(0).getSize();
    }

    private Integer getColumnIndex(String columnName) {
        return columnIndexes.get(columnName);
    }

    public int getColumnCount() {
        return columnCount;
    }

    public String getValue(String columnName, int row) {
        if (getColumnIndex(columnName) == null)
            return null;
        return columns.get(getColumnIndex(columnName)).getRowValue(row);
    }

    public void putValue(String columnName, int row, String value) {
        if (getColumnIndex(columnName) == null)
            return;
        columns.get(getColumnIndex(columnName)).setRowValue(row, value);
    }

    public void addValue(String columnName, String value) {
        if (getColumnIndex(columnName) == null)
            return;
        columns.get(getColumnIndex(columnName)).addRowValue(value);
    }

}
