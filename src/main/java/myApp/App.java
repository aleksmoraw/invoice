package myApp;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Table;

public class App {

    public static void main(String[] args) {
        try {
            Table table = SpreadsheetDocument.loadDocument("/home/ola/Pobrane/fakt2017.ods").getSheetByIndex(1);

            String companyName = table.getCellByPosition(6, 1).getStringValue();
            String address1 = table.getCellByPosition(6, 3).getStringValue();
            String address2 = table.getCellByPosition(6, 4).getStringValue();
            String nip = table.getCellByPosition(6, 5).getStringValue();
            String invoiceNumber = table.getCellByPosition(5, 10).getStringValue();
            String setDate = table.getCellByPosition(9, 12).getStringValue();
            String payDate = table.getCellByPosition(3, 14).getStringValue();
            Double amount = table.getCellByPosition(11, 58).getDoubleValue();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
