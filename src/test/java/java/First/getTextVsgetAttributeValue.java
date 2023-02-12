package First;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getTextVsgetAttributeValue {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		
		WebElement emailInputBox=driver.findElement(By.xpath("//input[@class=\"email\"]"));
		
		//clear text from input box
		//emailInputBox.clear();
		emailInputBox.sendKeys("adm123@gmail.com");
		
		//capture text from input Box
		
		System.out.println("Input Box");
		System.out.println("Result from getAttribute() method ::"+emailInputBox.getAttribute("value"));
		System.out.println("Result from getText() Method::"+ emailInputBox.getText());
		
		//login Button
		System.out.println("Login Button");
		WebElement button=driver.findElement(By.xpath("//button[@class=\"button-1 login-button\"]"));
		
		System.out.println("Result from getAttribute() Method::"+button.getAttribute("type"));
		System.out.println("Result from getAttribute() Method::"+button.getAttribute("class"));
		
		System.out.println("Result from getText() Method::"+button.getText());
		
		WebElement e=driver.findElement(By.xpath("//*[@class=\"page-title\"]//h1"));
		System.out.println("Result from getText() Method::"+e.getText());
		
		
	}

}
