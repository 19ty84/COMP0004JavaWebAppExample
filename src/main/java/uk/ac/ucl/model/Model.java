package uk.ac.ucl.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private DataLoader dataLoader;
    private DataFrame dataFrame;
    private ArrayList<String> patientNames;

    public Model() {
        dataLoader = new DataLoader();
        dataFrame = new DataFrame();
        patientNames = new ArrayList<String>();
    }

    public ArrayList<String> getPatientNames() {
        return patientNames;
    }

    // This method illustrates how to read csv data from a file.
    // The data files are stored in the root directory of the project (the directory
    // your project is in),
    // in the directory named data.
    public void readFile(String fileName) {
        dataLoader.readFile(fileName);
        dataFrame = dataLoader.getDataFrame();
        for (int i = 0; i < dataFrame.getRowCount(); i++) {
            patientNames.add(getPatientName(i));
        }
    }

    private String getPatientName(int rowIndex) {
        String first = dataFrame.getValue("FIRST", rowIndex);
        String last = dataFrame.getValue("LAST", rowIndex);
        return first + " " + last;
    }

    // This also returns dummy data. The real version should use the keyword
    // parameter to search
    // the data and return a list of matching items.
    public List<String> searchFor(String keyword) {
        return List.of("Search keyword is: " + keyword, "result1", "result2", "result3");
    }
}
