package chapter29;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingCookies {

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com");
		
		//how to capture cookies from the browser?
		Set<Cookie> cookies=driver.manage().getCookies();
		System.out.println("Size of Cookies:"+cookies.size());
		
		//How to print cookies from browser?
		for (Cookie cookie:cookies) 
		{
			System.out.println(cookie.getName()+":"+cookie.getValue());
			
		}
		
		//How to add Cookie to the browser?
		Cookie cookieobj=new Cookie("MyCookies123", "123456");
		driver.manage().addCookie(cookieobj);
		
		cookies=driver.manage().getCookies();
		System.out.println("Size of cookies after adding:"+cookies.size());//4
		
		//How to delete specific cookies from the browser?
		driver.manage().deleteCookie(cookieobj);
		driver.manage().deleteCookieNamed("MyCookies123");
		cookies=driver.manage().getCookies();
		System.out.println("Size of cookies after deletion::"+cookies.size());//3
		
		//How to delete all cookies from the browser?
		driver.manage().deleteAllCookies();
		
		cookies=driver.manage().getCookies();
		System.out.println("Size of cookies after delertion:"+cookies.size());//0
		
		driver.quit();
	
	}

}
