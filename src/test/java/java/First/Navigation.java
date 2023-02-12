package First;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigation {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		/*
		//get() method
		driver.get("https://www.snapdeal.com");
		driver.get("https://www.amazon.com");
		*/
		
		driver.navigate().to("https://www.snapdeal.com");
		driver.navigate().to("https://www.amazon.com");
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
	}

}
