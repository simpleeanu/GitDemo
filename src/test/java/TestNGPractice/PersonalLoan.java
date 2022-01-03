package TestNGPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PersonalLoan {
	/*
	 * @Test(dataProvider = "TestData") public void PersonalLoan1(Object obj[][]) {
	 * System.out.println("Inside personalloan1");
	 * 
	 * System.out.println(obj[0][0]); System.out.println(obj[0][1]);
	 * System.out.println(obj[1][0]); System.out.println(obj[1][1]);
	 * 
	 * }
	 */

	@Test(dataProvider = "TestData")
	public void PersonalLoan2(String username, String password) {
		System.out.println("Inside personalloan2");
		System.out.println(username);
		System.out.println(password);

	}

	@DataProvider
	public Object[][] TestData() {

		Object[][] obj = new Object[3][2];
		obj[0][0] = "username1";

		obj[0][1] = "password1";

		obj[1][0] = "username2";
		obj[1][1] = "password2";

		return obj;
	}

}
