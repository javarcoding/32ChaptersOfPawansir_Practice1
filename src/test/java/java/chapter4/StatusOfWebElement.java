package chapter4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StatusOfWebElement {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/Register");
		driver.manage().window().maximize();
		
		WebElement searchContent=driver.findElement(By.id("small-searchterms"));
		
		//isDisplay //isEnable
		System.out.println("Status of Displayed::"+searchContent.isDisplayed());//true
		System.out.println("Status of Enabled ::"+ searchContent.isEnabled());//true
		
		
		//isSelected
		WebElement male=driver.findElement(By.id("gender-male"));
		WebElement female=driver.findElement(By.id("gender-female"));
		
		System.out.println("No Radio button selected");
	
		System.out.println("Status of selected=="+male.isSelected());//false
		System.out.println("Status of selected=="+female.isSelected());//false
		
		
		System.out.println("Click on male radio button");
		male.click();
		
		System.out.println("Status of selected=="+male.isSelected());//true
		System.out.println("Status of selected=="+female.isSelected());//false
		
		System.out.println("Click on female radio button");
		female.click();
		
		System.out.println("Status of selected=="+male.isSelected());
		System.out.println("Status of selected=="+female.isSelected());
		
	}
	

}
