package utilities;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import pages.HomePage;


public class ExelReader {
    private final String filePath;

    public ExelReader(String filePath) {
        this.filePath = filePath;
    }

    public Object[][] readTestData() {
        Object[][] testData = null;
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = WorkbookFactory.create(fis)) {
            Sheet sheet = workbook.getSheetAt(0); // Assuming test data is in the first sheet
            int rows = sheet.getPhysicalNumberOfRows();
            testData = new Object[rows][2]; // Assuming two columns: URL and search query

            for (int i = 0; i < rows; i++) {
                Row row = sheet.getRow(i);
                Cell urlCell = row.getCell(0);
                Cell queryCell = row.getCell(1);
                testData[i][0] = urlCell.getStringCellValue();
                testData[i][1] = queryCell.getStringCellValue();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return testData;
    }
}