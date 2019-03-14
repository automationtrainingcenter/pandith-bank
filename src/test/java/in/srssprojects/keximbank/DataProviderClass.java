package in.srssprojects.keximbank;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
	ExcelHelper excel;

	@DataProvider(name = "role_data")
	public Object[][] getRoleData() {
		excel = new ExcelHelper();
		return excel.getExcelData("testdata.xls", "roledata");
	}

}
