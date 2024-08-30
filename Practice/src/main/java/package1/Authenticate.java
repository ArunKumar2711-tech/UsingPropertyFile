package package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Authenticate {
    
    public static void main(String[] args) {
        // Setup ChromeDriver with WebDriverManager
        WebDriverManager.chromedriver().setup();
        
        // Set up ChromeOptions
        ChromeOptions options = new ChromeOptions();
        
        // If you want to use a remote debugging port, ensure Chrome is started with this port externally.
        // options.setExperimentalOption("debuggerAddress", "localhost:57430");
        
        // Initialize ChromeDriver with options
        WebDriver driver = new ChromeDriver(options);

        // Navigate to the Google Cloud Console
        driver.get("https://console.cloud.google.com");
        
        // Your additional automation code goes here

        // Close the browser
       // driver.quit();
    }
}
