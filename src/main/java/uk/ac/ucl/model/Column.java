package uk.ac.ucl.model;

import java.util.ArrayList;

public class Column {
    private String name;
    private ArrayList<String> rows;

    public Column(String columnName) {
        name = columnName;
        rows = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return rows.size();
    }

    public String getRowValue(int rowIndex) {
        return rows.get(rowIndex);
    }

    public void setRowValue(int rowIndex, String rowValue) {
        rows.set(rowIndex, rowValue);
    }

    public void addRowValue(String rowValue) {
        rows.add(rowValue);
    }

}
