package First;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowser {

	public static void main(String[] args) {
		/*
		//using webDriverManager
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.google.com");
		*/
		//using System.setProperty() - ChromeDriver()
		System.setProperty("webdriver.chrome.driver", "C://chromedriver//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.com");
		
		System.out.println("Title of webPage"+driver.getTitle());
		System.out.println("URL of the webpage"+driver.getCurrentUrl());
		
		
	}

}
