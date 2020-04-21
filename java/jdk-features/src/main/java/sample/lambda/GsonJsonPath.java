package sample.lambda;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

public class GsonJsonPath {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		FileInputStream fis = new FileInputStream("C:\\Users\\apal2\\OneDrive - Cisco\\workspace\\infra\\samesight\\webSessions.json");
		ReadContext ctx = JsonPath.parse(fis);
		
		
		
		List<String> authorsOfBooksWithISBN = ctx.read("$..items[?(@.secureCookie == false)].name");

		//List<String> authorsOfBooksWithISBN = ctx.read("$..items[-2:].name");

		
		for (String s :authorsOfBooksWithISBN ) {
			System.out.println(s);
		}
		
	}

}
