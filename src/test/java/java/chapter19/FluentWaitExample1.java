package chapter19;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitExample1 {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//fluent wait declaration
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))

				.ignoring(NoSuchElementException.class);
		
		driver.get("https://www.google.com");
		
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		driver.findElement(By.name("q")).sendKeys(Keys.RETURN);
		
		
		//usage of Fluent wait
		WebElement element=wait.until(new Function<WebDriver, WebElement>(){
			public WebElement apply(WebDriver driver) {
			return driver.findElement(By.xpath("//h3[text()='Selenium Tutorial - javatpoint']"));
			}	
		});
	
		element.click();
		
		
	}

}
