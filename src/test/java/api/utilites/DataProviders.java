package api.utilites;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
    @DataProvider(name = "Data")
    public String[][] getAllData() throws IOException {
        String path = System.getProperty("user.dir") + "//testData//Userdata.xlsx";
        XLUtilityTMP xl = new XLUtilityTMP(path);

        int rownum = xl.getRowCount("Лист1");
        int colcount = xl.getCellCount("Лист1", 1);

        String apidata[][] = new String[rownum][colcount];

        for (int i = 1; i < rownum; i++) {
            for (int j = 0; j < colcount; j++) {
                apidata[i-1][j] = xl.getCellData("Лист1", i, j);
            }
        }
        return apidata;
    }

    @DataProvider(name = "UserNames")
    public String[] getUserNames() throws IOException {
        String path = System.getProperty("user.dir") + "//testData//Userdata.xlsx";
        XLUtilityTMP xl = new XLUtilityTMP(path);

        int rownum = xl.getRowCount("Лист1");

        String apidata[] = new String[rownum];

        for (int i = 1; i < rownum; i++) {

            apidata[i-1] = xl.getCellData("Лист1", i, 1);

        }
        return apidata;
    }

}
