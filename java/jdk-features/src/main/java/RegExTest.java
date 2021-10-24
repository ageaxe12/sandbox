import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExTest {
    public static void main(String [] a ){
        String str1 = "CN=wam-team,OU=Cisco Groups,O=cco.cisco.com";
        String str2 = "CN=web-security-team,OU=Mailer,OU=Groups,O=cco.cisco.com";

        final String[] strings = {
                "CN=wam-team,OU=Cisco Groups,O=cco.cisco.com",
                "CN=web-security-team,OU=Mailer,OU=Groups,O=cco.cisco.com",};
        final Pattern pattern = Pattern.compile("^CN=([^,]++)");
        for (final String string : strings) {
            final Matcher matcher = pattern.matcher(string);
            if(matcher.find()) {
                System.out.println(matcher.group(1));
            }
        }
    }
}
