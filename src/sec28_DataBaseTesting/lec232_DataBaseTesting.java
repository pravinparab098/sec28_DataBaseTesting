package sec28_DataBaseTesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class lec232_DataBaseTesting {

	public static void main(String[] args) throws SQLException {

		String host = "localhost";
		String port = "3306";
		// create a connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/Qadbt", "root",
				"pravin@root");
		// with that connection create a path

		Statement s = conn.createStatement();
		ResultSet rs = s.executeQuery("select * from Employeeinfo where name = 'Pravin'");

		while (rs.next()) {
			System.out.println("Name :- " + rs.getString("name"));
			System.out.println("Id :- " + rs.getInt("id"));
			System.out.println("Location :- " + rs.getString("location"));
			System.out.println("Age :- " + rs.getInt("age"));
			
		System.setProperty("webdriver.chrome.driver", "D:\\Grid\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/?locale=in");
		driver.findElement(By.id("username")).sendKeys(rs.getString("name"));
		driver.findElement(By.id("password")).sendKeys(rs.getString("location"));		
		}
	}
}
