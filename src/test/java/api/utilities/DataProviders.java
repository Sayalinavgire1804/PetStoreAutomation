package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;
public class DataProviders
{
	@DataProvider(name="Data")
public String[][] getAllData() throws IOException
{
        String path="C:\\Users\\Sayali\\eclipse-workspace\\PetStoreAutomation\\testData\\UserData.xlsx";
                                       	XLUtility x1=new XLUtility(path);
	int rownum=x1.getRowCount("Data");
	int colcount=x1.getcellCount("Data", 1);
	String apidata[][]=new String[rownum][colcount];
	for(int i=1;i<=rownum;i++)
	{
		for(int j=0;j<colcount;j++)
		{
			apidata[i-1][j]=x1.getCellData("Data", i, j);
		}
	}
	return apidata;
	
}
	@DataProvider(name="UserNames")
	public String[] getUserNames() throws IOException
	{
		 String path="C:\\Users\\Sayali\\eclipse-workspace\\PetStoreAutomation\\testData\\UserData.xlsx";

		XLUtility x1=new XLUtility(path);
		int rownum=x1.getRowCount("Data");
		String apidata[]=new String[rownum];
		for(int i=1;i<=rownum;i++)
		{
			apidata[i-1]=x1.getCellData("Data", i, 1);
		}
		return apidata;
		
	}
}
