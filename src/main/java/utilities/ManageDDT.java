package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOps {
    static protected int rowNumber;
    /*
    #########################################################################
    Method Name: readCSV
    Method Description: This Method read the data from csv file
    Method Parameters: String
    Method Return: List<String>
    #########################################################################
    */
    public static List<String> readCSV(String csvFile) {
        List<String> lines = null;
        File file = new File(csvFile);
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
            rowNumber = lines.size();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    /*
    #########################################################################
    Method Name: gerDataFromCSV
    Method Description: This Method get the data from return readCSV
    Method Parameters: String
    Method Return: Object[][]
    #########################################################################
    */
    public static Object[][] gerDataFromCSV(String filePath) {
        List<String> csvData = readCSV(filePath);
        Object[][] data = new Object[rowNumber][2];
        for (int i = 0; i < csvData.size(); i++) {
            data[i][0] = csvData.get(i).split(",")[0];
            data[i][1] = csvData.get(i).split(",")[1];
        }
        return data;
    }

    @DataProvider(name = "data-provider-users")
    public Object[][] getDataObject() {
        return gerDataFromCSV(getData("ddtUsers"));
    }
}
