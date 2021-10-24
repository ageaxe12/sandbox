package sample.json;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVWriter;

import io.restassured.path.json.JsonPath;

public class TestJSonPath {

	final static String RULE_FILE_LOCATION = "agents-nprd.json"; 

	final static String CSV_FILE_LOCATION = "rules-groovy-prodrules-response-prod-05.26.cvs"; 

	public static void main(String[] args) {

		findRootCertForAppsNprd();
		

	}

	public static void findRootCertForAppsNprd(){
		InputStream fileIO = TestJSonPath.class.getClassLoader().getResourceAsStream(RULE_FILE_LOCATION);
	
		List<String> nameList = JsonPath.with(fileIO).get(
				"items.findAll { item -> item.certificateHash.hexValue != '89108703f34f55b3c510c12860e12c64580960c1' && item.certificateHash.hexValue != '7c86f4d9347e0fbfd2f7410eedeb5482b0ef35ba'}.name");
	
		System.out.println(nameList);
		
	}

	
	
	public static void findRootCertForApps(){
		InputStream fileIO = TestJSonPath.class.getClassLoader().getResourceAsStream(RULE_FILE_LOCATION);
	
		List<String> nameList = JsonPath.with(fileIO).get(
				"items.findAll { item -> item.certificateHash.hexValue != '89108703f34f55b3c510c12860e12c64580960c1' && item.certificateHash.hexValue != '7c86f4d9347e0fbfd2f7410eedeb5482b0ef35ba'}.name");
	
		System.out.println(nameList);
		
	}

	public static void findNonSeCureWebSession(){
		InputStream fileIO = TestJSonPath.class.getClassLoader().getResourceAsStream("web-session-prod.json");
		
		List<String> groovyScriptList = JsonPath.with(fileIO).get(
				"items.findAll { items -> items.secureCookie == false}.name");
		
		System.out.println(groovyScriptList);

	}
	
	public static void findGroovyRulesWithResponseBuilder(){
		InputStream fileIO = TestJSonPath.class.getClassLoader().getResourceAsStream(RULE_FILE_LOCATION);
		InputStream fileIO2 = TestJSonPath.class.getClassLoader().getResourceAsStream(RULE_FILE_LOCATION);

		List<String> groovyScriptList = JsonPath.with(fileIO).get(
				"items.findAll { items -> items.className == 'com.pingidentity.pa.policy.GroovyPolicyInterceptor'}.configuration.groovyScript");

		List<String> nameList = JsonPath.with(fileIO2).get(
				"items.findAll { items -> items.className == 'com.pingidentity.pa.policy.GroovyPolicyInterceptor'}.name");

		System.out.println(nameList);

		System.out.println(groovyScriptList);

		Map<String,String> map = new HashMap<>();
		
		for (int i = 0 ; i < nameList.size(); i++) {
			map.put(nameList.get(i), groovyScriptList.get(i));
		}
		
		writeDataLineByLine(map);
	}
	public static void writeDataLineByLine(Map<String,String> map) {
		// first create file object for file placed at location
		// specified by filepath
		
		
		File file = new File(CSV_FILE_LOCATION);
		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(file);

			// create CSVWriter object filewriter object as parameter
			CSVWriter writer = new CSVWriter(outputfile);

			for(Map.Entry<String,String> entry : map.entrySet())	
				writer.writeNext(new String[]{entry.getKey(),entry.getValue()});

			// closing writer connection
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
