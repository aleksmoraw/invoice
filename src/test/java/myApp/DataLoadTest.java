package myApp;


import org.junit.Test;
import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Table;

import java.io.File;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DataLoadTest {

    private final static String pathToFile = "/Users/aleksandramorawska/Downloads/fakt2017.ods";
    private final static File file = new File (pathToFile);

    private DataLoad dataLoad = new DataLoad();

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
            List<String> sut = dataLoad.loadCellsIntoArray(table);
            assertTrue(sut.get(5).equals("2017-04-11"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
