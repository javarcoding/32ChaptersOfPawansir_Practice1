package chapter18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleIFrame {

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		
		
		//1 st frame 
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath("//a[@href=\"org/openqa/selenium/package-frame.html\"]"));
		driver.switchTo().defaultContent();
		
		//2 nd frame
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.xpath("//*[@class=\"interfaceName\"]"));
		driver.switchTo().defaultContent();
		
		Thread.sleep(3000);
		
		//3 rd frame
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//a[@href=\"index-all.html\"]"));
		driver.switchTo().defaultContent();
		
		driver.close();
		
		
	
		
		
		
	}

}
