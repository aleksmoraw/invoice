package myApp;


import org.junit.Test;
import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Table;

import java.io.File;
import java.util.HashMap;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DataLoadTest {

    private static String pathToFile = "/home/ola/Pobrane/fakt2017.ods";
    private static File file = new File (pathToFile);

    DataLoad dataLoad = new DataLoad();

    @Test
    public void isFileIsCorrectFind () {
        File sut = dataLoad.createFile(pathToFile);
        assertTrue(sut.getName().equals("fakt2017.ods"));
    }

    @Test
    public void isTableIsCorrectLoad () {
        try {
            Table sut = dataLoad.loadFile(file);
            assertThat(sut.getRowCount(), is(63));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void isCellsAreCorrectLoad () {
        try {
            Table table = SpreadsheetDocument.loadDocument(file).getSheetByIndex(1);
            HashMap<String,String> sut = dataLoad.loadCellsIntoMap(table);
            assertTrue(sut.containsValue("1/2017"));
            assertTrue(sut.containsKey("NIP"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
