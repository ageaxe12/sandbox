package sample.json;

import java.io.InputStream;
import java.util.List;

import io.restassured.path.json.JsonPath;

public class TestJSonPath {

	public static void main(String[] args) {
		InputStream fileIO = TestJSonPath.class.getClassLoader().getResourceAsStream("rules-response.json");

		// jsonPath.param("className","com.pingidentity.pa.policy.GroovyPolicyInterceptor").get("items.findAll
		// {items --> items.className == className}.name");

		List<String> list = JsonPath.with(fileIO).get("items.findAll { items -> items.className == 'com.pingidentity.pa.policy.GroovyPolicyInterceptor'}.name");

		System.out.println(list);
	}

}
