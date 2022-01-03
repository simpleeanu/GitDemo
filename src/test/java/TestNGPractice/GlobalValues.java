package TestNGPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class GlobalValues {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\anu98\\eclipse-workspace\\SeleniumProject\\TestData.properties");
		prop.load(fis);
		System.out.println(prop.getProperty("browser"));
		prop.setProperty("browser", "edge");
		System.out.println(prop.getProperty("browser"));
		FileOutputStream fos = new FileOutputStream(
				"C:\\Users\\anu98\\eclipse-workspace\\SeleniumProject\\TestData.properties");
		prop.store(fos, null);

	}

}
