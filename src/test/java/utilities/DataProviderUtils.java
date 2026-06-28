package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

	
	@DataProvider(name="getProducts")
	public Object[][] getCategoryData()
	{
		return new Object[][] {
			
			{"Eyeglasses"},
			{"Sunglasses"},
			{"Computer glasses"},
			{"Powered Sunglasses"},
			{"Contact Lenses"},
			{"Ready reader"},
			{"Smart glasses"},
			{"accessories"}
		};
	}
	
	@DataProvider(name="getPincode")
	public Object[][] getPincodeData()
	{
		return new Object[][] {
			
			{"400001"},
			{"421203"},
			{"110005"},
			{"600040"},
			{"282001"},
			{"411005"},
			{"500002"},
			{"560008"}
		};
	}
	
	
	
}
