package myApp;

import org.odftoolkit.simple.SpreadsheetDocument;
import org.odftoolkit.simple.table.Cell;
import org.odftoolkit.simple.table.Table;

import java.io.File;
import java.util.List;

public class DataSave {

    private static final String[] FILE_HEADER = {"Nazwa firmy", "Adres1", "Adres2", "NIP", "Numer faktury", "Data wystawienia", "Data płatności", "Kwota brutto"};

    public void saveFile(String filePath, List<String> invoiceDetailsList) {

        File file = new File(filePath);
        SpreadsheetDocument spreadsheetDocument;

        try {
            if(file.exists()) {
                spreadsheetDocument = SpreadsheetDocument.loadDocument(filePath);
                Table table = spreadsheetDocument.getSheetByIndex(0);
                loadInvoiceDetails(table, invoiceDetailsList);
            } else {
                spreadsheetDocument = SpreadsheetDocument.newSpreadsheetDocument();
                Table table = spreadsheetDocument.getSheetByIndex(0);
                loadHeaders(table);
                loadInvoiceDetails(table, invoiceDetailsList);
            }

            spreadsheetDocument.save(filePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void loadHeaders(Table table) {
        int rowCount = 0;
        int columnCount = 0;

        for (String header : FILE_HEADER) {
            Cell cell = table.getCellByPosition(columnCount++, rowCount);
            cell.setStringValue(header);
            cell.setCellBackgroundColor("#A9A9A9");
        }
    }

    protected void loadInvoiceDetails(Table table, List<String> invoiceDetailsList) {

        int rowCount = table.getRowCount();
        int columnCount = 0;

        for (String detail : invoiceDetailsList) {
            table.getCellByPosition(columnCount++, rowCount).setStringValue(detail);
        }
    }
}


