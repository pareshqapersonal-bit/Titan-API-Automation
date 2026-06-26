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
			{"Accessories"}
		};
	}
}
