package myApp;

import org.odftoolkit.simple.table.Table;

import java.io.File;
import java.util.HashMap;

public class App {

    public static void main(String[] args) {

        DataLoad dataLoad = new DataLoad();
        File file = dataLoad.createFile("/home/ola/Pobrane/fakt2017.ods");
        try {
            Table table = dataLoad.loadFile(file);
            HashMap<String,String> testMap = dataLoad.loadCellsIntoMap(table);
            System.out.println(testMap);

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
