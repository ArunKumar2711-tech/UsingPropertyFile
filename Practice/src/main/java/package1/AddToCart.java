package package1;

import java.util.Arrays;
import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddToCart {
	static WebDriver driver ;

	public static void main(String[] args) throws InterruptedException {
		int j=0;
		String[] itemsNeeded = {"Carrot","Beans","Cucumber","Beetroot","Cauliflower"};
		driver = WebDriverManager.chromedriver().create();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		List<WebElement> Vegetables = driver.findElements(By.cssSelector("h4.product-name"));
		
		for(int i=0;i<Vegetables.size();i++) {
			//carrot - 1 kg, Beans - 1 kg etc, so we are splitting
			String[] name = Vegetables.get(i).getText().split("-");
			//name[0] = carrot
			//name[1] = 1 kg
			String formattedName = name[0].trim();
			
			List itemsPick = Arrays.asList(itemsNeeded);
			
			if(itemsPick.contains(formattedName)) {
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']")).get(i).click();
				if(j==itemsNeeded.length) {
					break;
				}
			}
		}
	
		Thread.sleep(5000);
		
		
	}

}
