package base;

import java.awt.Container;

import org.testng.annotations.BeforeClass;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import utilities.ConfigReader;

public class BaseTest {

	
	protected ConfigReader config;
	protected RequestSpecification reqspec;
	
	@BeforeClass
	public void setUP()
	{
		config = new ConfigReader();
		reqspec = new RequestSpecBuilder()
				.setBaseUri(config.getProperty("baseUrl"))
				.setContentType(ContentType.JSON)
				.build();
	}
}
