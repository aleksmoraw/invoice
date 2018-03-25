package myApp;

import org.odftoolkit.simple.table.Table;

import java.io.File;
import java.util.List;

public class App {

    public static void main(String[] args) {

        DataLoad dataLoad = new DataLoad();
        DataSave dataSave = new DataSave();
        File file = dataLoad.createFile("/Users/aleksandramorawska/Downloads/fakt2017.ods");
        try {
            Table table = dataLoad.loadFile(file);
            List<String> testList = dataLoad.loadCellsIntoArray(table);
            dataSave.saveFile("/Users/aleksandramorawska/Downloads/fakt2017Nowa.ods", testList);

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
