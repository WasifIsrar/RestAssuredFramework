package api.utilities;

import java.io.File;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws Exception{
		String path=System.getProperty("user.dir")+File.separator+"testData"+File.separator+"UserData.xlsx";
		XLUtility xl=new XLUtility(path);
		int rowCount=xl.getRowCount("Sheet1");
		int colCount=xl.getCellCount("Sheet1",1);
		String apidata[][]=new String[rowCount][colCount];
		for(int i=1;i<=rowCount;i++) {
			for(int j=0;j<colCount;j++) {
				apidata[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
		}
		return apidata;
	}
	
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws Exception {
		String path=System.getProperty("user.dir")+File.separator+"testData"+File.separator+"UserData.xlsx";
		XLUtility xl=new XLUtility(path);
		int rowNum=xl.getRowCount("Sheet1");
		String apiData[]=new String[rowNum];
		for(int i=1;i<=rowNum;i++) {
			apiData[i-1]=xl.getCellData("Sheet1", i, 1);
		}
		return apiData;
	}
}
