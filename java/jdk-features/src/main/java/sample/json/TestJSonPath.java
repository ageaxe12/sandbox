package sample.json;

import java.io.InputStream;
import java.text.MessageFormat;
import java.util.List;

import io.restassured.path.json.JsonPath;

public class TestJSonPath {


	public static void main(String[] args) {
		
		System.out.println(MessageFormat.format("https://{0}/portal.html", "xxx","yyyy"));
	}
	
	public static void main1(String[] args) {
		InputStream fileIO = TestJSonPath.class.getClassLoader().getResourceAsStream("rules-response.json");

		// jsonPath.param("className","com.pingidentity.pa.policy.GroovyPolicyInterceptor").get("items.findAll
		// {items --> items.className == className}.name");

		List<String> list = JsonPath.with(fileIO).get("items.findAll { items -> items.className == 'com.pingidentity.pa.policy.GroovyPolicyInterceptor'}.name");

		System.out.println(list);
	}

}
