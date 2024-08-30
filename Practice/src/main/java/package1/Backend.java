package package1;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import io.github.bonigarcia.wdm.WebDriverManager;
import util.Config_Reader;

public class Backend  {

	static WebDriver driver;
	static ReadProperties reads;	
	public static void main(String[] args)throws InterruptedException, ClientProtocolException, IOException  {
			reads=new ReadProperties();
			reads.read();
			
		
		
		WebDriverManager.chromedriver().create();
		driver = new ChromeDriver();
		//ChromeOptions opt=new ChromeOptions();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        
		
		
		
		
		// GitLab
		driver.get("https://rappit-gitlab.vanenburg.com/");
		driver.manage().window().maximize();

		
		
		driver.findElement(By.id("user_login")).sendKeys(reads.getUsername());
		driver.findElement(By.id("user_password")).sendKeys(reads.getPassword());
		driver.findElement(By.xpath("//span[@class='gl-button-text']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@data-testid='verify-code-button']\r\n" + "")).click();

		// WebElement dynamicLink =
		// driver.findElement(By.xpath("//a[@class='gl-text-default
		// hover:gl-text-default gl-mr-3 js-prefetch-document']"));

		By closeIconLocator = By.cssSelector("svg[data-testid='close-icon']");
		boolean isCloseIconPresent = driver.findElements(closeIconLocator).size() > 0;
		if (isCloseIconPresent) {
			driver.findElement(By.cssSelector("svg[data-testid='close-icon']")).click();
		} else {
			System.out.println("Close icon is not present.");
		}

		// Find the <span> with class 'project-name' inside the <a> element
		WebElement projectNameSpan = driver.findElement(By.xpath("(//span[@class='project-name'])[6]"));

		// Extract the text of the <span> element
		String projectName = projectNameSpan.getText();

		// Output the extracted text
		System.out.println("Extracted project name: " + projectName);

		// Google Console
		driver.get("https://console.cloud.google.com/artifacts?referrer=search&project=vb-eva-gen");

		driver.findElement(By.name("identifier")).sendKeys("darunkumar@vanenburg.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@aria-label='Enter your password']\r\n" + ""))
				.sendKeys("Aadhansaiarun@0720!");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		Thread.sleep(80000);
		driver.findElement(By.xpath("//span[contains(text(),'Create repository')]")).click();
		driver.findElement(By.xpath(
				"//body[1]/pan-shell[1]/pcc-shell[1]/cfc-panel-container[1]/div[1]/div[1]/cfc-panel[1]/div[1]/div[1]/div[3]/cfc-panel-container[1]/div[1]/div[1]/cfc-panel[1]/div[1]/div[1]/cfc-panel-container[1]/div[1]/div[1]/cfc-panel[1]/div[1]/div[1]/cfc-panel-container[1]/div[1]/div[1]/cfc-panel[2]/div[1]/div[1]/central-page-area[1]/div[1]/div[1]/pcc-content-viewport[1]/div[1]/div[1]/pangolin-home-wrapper[1]/pangolin-home[1]/cfc-router-outlet[1]/div[1]/ng-component[1]/cfc-single-panel-layout[1]/cfc-panel-container[1]/div[1]/div[1]/cfc-panel[1]/div[1]/div[1]/cfc-panel-body[1]/cfc-virtual-viewport[1]/div[1]/div[1]/ar-repository-form[1]/form[1]/mat-form-field[1]/div[1]/div[1]/div[2]/input[1]"))
				.sendKeys(projectName + "-repository");
		Thread.sleep(4000);
		driver.findElement(By.xpath("//div[contains(@class,'cfc-select-value ng-star-inserted')]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//span[contains(text(),'europe-west1 (Belgium)')]")).click();
		driver.findElement(By.xpath("//span[@class='mdc-button__label'][contains(.,'Create')]")).click();

//        
//              
		// driver.findElement(By.cssSelector(".tanuki-logo")).click();
		driver.get("https://rappit-gitlab.vanenburg.com/");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[@class='namespace-name gl-font-normal'])[1]")).click();

		driver.get("https://rappit-gitlab.vanenburg.com/rappit-dev/acceptance/eva-applications/" + projectName
				+ "/-/settings/ci_cd");
//https://rappit-gitlab.vanenburg.com/rappit-dev/development/eva-applications/tblr/-/settings/ci_cd		

		driver.findElement(By.xpath("(//button/span[@class='gl-button-text'])[11]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//button[@title='Edit'])[3]")).click();
		driver.findElement(By.id("ci-variable-value")).clear();
		driver.findElement(By.id("ci-variable-value")).sendKeys("1");
		driver.findElement(By.xpath("(//span[@class='gl-button-text'][contains(.,'Save changes')])[3]")).click();
		driver.findElement(By.xpath("//span[@class='gl-button-text' and normalize-space(text()) = 'Cancel']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@title='Edit'])[7]")).click();
		driver.findElement(By.id("ci-variable-value")).clear();
		driver.findElement(By.id("ci-variable-value"))
				.sendKeys("firebase-adminsdk-bv2c8@vb-eva-gen.iam.gserviceaccount.com");
		driver.findElement(By.xpath("(//span[@class='gl-button-text'][contains(.,'Save changes')])[3]")).click();
		driver.findElement(By.xpath("//span[@class='gl-button-text' and normalize-space(text()) = 'Cancel']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@title='Edit'])[11]")).click();
		driver.findElement(By.id("ci-variable-value")).clear();
		driver.findElement(By.id("ci-variable-value")).sendKeys("1");
		driver.findElement(By.xpath("(//span[@class='gl-button-text'][contains(.,'Save changes')])[3]")).click();
		driver.findElement(By.xpath("//span[@class='gl-button-text' and normalize-space(text()) = 'Cancel']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@title='Edit'])[23]")).click();
		driver.findElement(By.id("ci-variable-value")).clear();
		driver.findElement(By.id("ci-variable-value")).sendKeys("{\r\n" + "    \"type\": \"service_account\",\r\n"
				+ "    \"project_id\": \"vb-eva-gen\",\r\n"
				+ "    \"private_key_id\": \"a94c9fed35649955865a5d0b53ab135d774841e5\",\r\n"
				+ "    \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDEQF+PtAKdBj1v\\nDYaiKac7vQ3/r7fixvJTM3SlVRPYUCXItLVZCyxkp1l4kmbvCAntLRJFihAdKKLt\\n6kzXW+3WfVgRd+RXftWIl5HpnA/G0zATshNmsyALTfeYjQR/P9Eb0+wLVIz42rXy\\nwM5U5umIYh5RVPC28zz13NBgSaZqsQVJePFCRVb/F3jjKicxCa6mAqWUgeUvFHlX\\nK14SYRw6k6zt0lqAU7+sX71/C/x9gk0+LxthUuCGtnq6fycCe2Y/VmCY8gp+yQps\\nH3MUmw/a9vLbarmFGUOLFpin7vLcKeNWUgCXB2KtK3gMt7xTqxpXQqkp4hF6uMZW\\nuJ3PYzHXAgMBAAECggEABVeizqERptXxdS7N9mdw35GNvgp08hBTh2mZI2kL1SLS\\n8Wl8sidq0+p2yaCUycDrxJA0MD6nogal+RkI1QDA1XIdhpW/bh7HRiluHTo77Wd4\\nuiYRa6zcPuASvUhVdG3LV7uMUsRUHLUNT+1fLhJDSW8xa4yuRoclumkMTgcFsa5R\\nrWI6U9y+iAy+0U/kCEbVQ7k7TBkHgiUb8/wEg3YkImq5O11BgtSSlsordcv51I0J\\nESbjvCvzEUaseTZVh7tE82q7gk/wPwkQfVlfd1o2U5Eu7y+Ah0b89ImGaiX30mJ7\\nYO7kn6/P99k6vyJx0b+YRMhLXoqI1YchSvCOP4ERRQKBgQDinXGZdsGGXcYzyIvP\\nDkgeXY0oQPwQ+C2vVYuTNHjkgf6ejfhemyRVe0JFbJXVcM5QrLr4xYK+aIkiwUij\\nrt5ufmAo4mMZTCG7FY8jjvpbRaa+oP5nnMQLYJ5n3oaBXmGyEGNOdbD0BAzuIyGO\\nAy6ZOJ0rl+jNDlHhHPTFUoq8pQKBgQDdswB1P4UgjwJ/1bBp8C1PpxPh8i5WUSkl\\nli8a82z4NfY2u8XKivQlgsJyTz2eln5oU+8Mj/hmHO8Qc8YiBx7hrbOhUwTszvfv\\nCyY+sfx0o2yOF1vdWCKLH88/wzivm2XM1WTC/YzmPYZuh63ls1KEyRCdd1d2Oq4/\\nwVhXWbc/ywKBgGeKeHUeBZ5XClBuuTKJ2/nD1NMnngRC4NzTwUopF3OQ0b2wMGNJ\\nj3hfMRB3ZJ55REsoIOW5mNtW+BGhLodbRtZFd7o2dgEBAAhy+UvN8CXz1RQUiyjc\\nP9bS9o2O5vYFIa4yPq2CqK9VinLkKliwq4HmlClu5zeJ629nw47FAA7hAoGBAJ0I\\njrl+HbkbMyUDYqsXUbEK4n13wrSnVmLmR0VqyXPjHRxV0tsNo7PyM/MuB7KOXMlf\\nMoMOc184/WkE6IHv00L9e7A4ktN+IoYyuotMHUss+taG2y4koIs1I+LBUCSrCOeW\\n+4FWgXgQemlON7HtW/TsSpWPE+eN1yEXvZBZ3wATAoGAclpT9Esvh/+qsnSoP3aH\\nIbuXerd1pq2dY2jvNpBylESAxLAsD1e4xCYC7fw3u9vAn0NF3j2Gt+cxMbg2ruVm\\n8LAbiZEOAOPZbEtYsXV5lo9dBr6kRhjqedG8FlFbnEF3CPc6FHuejNe4Vb+uH6AZ\\neJddRW+PeaGy2U2dKqmlXjk=\\n-----END PRIVATE KEY-----\\n\",\r\n"
				+ "    \"client_email\": \"sa-cloud-run-deployer@vb-eva-gen.iam.gserviceaccount.com\",\r\n"
				+ "    \"client_id\": \"108644958708504972122\",\r\n"
				+ "    \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\r\n"
				+ "    \"token_uri\": \"https://oauth2.googleapis.com/token\",\r\n"
				+ "    \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\r\n"
				+ "    \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/sa-cloud-run-deployer%40vb-eva-gen.iam.gserviceaccount.com\",\r\n"
				+ "    \"universe_domain\": \"googleapis.com\"\r\n" + "}");
		driver.findElement(By.xpath("(//span[@class='gl-button-text'][contains(.,'Save changes')])[3]")).click();
		driver.findElement(By.xpath("//span[@class='gl-button-text' and normalize-space(text()) = 'Cancel']")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@title='Edit'])[26]")).click();
		driver.findElement(By.id("ci-variable-value")).clear();
		driver.findElement(By.id("ci-variable-value")).sendKeys("1");
		driver.findElement(By.xpath("(//span[@class='gl-button-text'][contains(.,'Save changes')])[3]")).click();
		driver.findElement(By.xpath("//span[@class='gl-button-text' and normalize-space(text()) = 'Cancel']")).click();

		driver.get("https://rappit-gitlab.vanenburg.com/rappit-dev/acceptance/eva-applications/" + projectName
				+ "/-/tree/master");

		driver.findElement(By.xpath("//span[@class='gl-new-dropdown-button-text'][contains(.,'master')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='gl-new-dropdown-item-text-wrapper'][contains(.,'development')]"))
				.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@title,'.m2')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(@class,'tree-item-link str-truncated')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span/span[@class='gl-new-dropdown-button-text'])[4]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Edit single file')]")).click();

		Thread.sleep(5000);
//driver.findElement(By.xpath("//body/div[1]/div[2]/div[2]/main[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]")).clear();

//WebElement inputField = driver.findElement(By.xpath("//body/div[1]/div[2]/div[2]/main[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]")); // Replace with the actual locator
//boolean elementFound = false;

		WebElement element = driver.findElement(By.xpath(
				"//body/div[1]/div[2]/div[2]/main[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]"));

// Perform click using JavaScript
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
// Create an Actions instance
		Actions actions = new Actions(driver);

		/*
		 * String emoji="Name"; StringSelection stringSelection = new
		 * StringSelection(emoji); Clipboard clipboard =
		 * Toolkit.getDefaultToolkit().getSystemClipboard();
		 * clipboard.setContents(stringSelection, null); element =
		 * driver.findElement(By.xpath(
		 * "//body/div[1]/div[2]/div[2]/main[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]"
		 * )); element.click(); actions.keyDown(Keys.CONTROL); actions.sendKeys("v");
		 * actions.keyUp(Keys.CONTROL); actions.build().perform();
		 */

// Perform CTRL+A to select all text
		actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.DELETE).perform();

//element = driver.findElement(By.xpath("//body/div[1]/div[2]/div[2]/main[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]"));

		String emoji = "<settings xmlns=\"http://maven.apache.org/SETTINGS/1.0.0\"\r\n"
				+ "                    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\r\n"
				+ "                    xsi:schemaLocation=\"http://maven.apache.org/SETTINGS/1.0.0\r\n"
				+ "                      http://maven.apache.org/xsd/settings-1.0.0.xsd\">\r\n" + "	<servers>\r\n"
				+ "		<server>\r\n" + "			<id>vb-central</id>\r\n"
				+ "			<username>${env.ARTIFACTORY_USER}</username>\r\n"
				+ "			<password>${env.ARTIFACTORY_PASS}</password>\r\n" + "		</server>\r\n"
				+ "	</servers>\r\n" + "	<pluginGroups>\r\n"
				+ "        <pluginGroup>org.sonarsource.scanner.maven</pluginGroup>\r\n" + "    </pluginGroups>\r\n"
				+ "	<profiles>\r\n" + "		<profile>\r\n" + "		  <repositories>\r\n"
				+ "			<repository>\r\n" + "			  <snapshots>\r\n"
				+ "				<enabled>false</enabled>\r\n" + "			  </snapshots>\r\n"
				+ "			  <id>vb-central</id>\r\n" + "			  <name>rappit-maven-repo</name>\r\n"
				+ "              <url>https://artifactory.vanenburg.com:443/artifactory/acc-rappit-maven-repo/</url>\r\n"
				+ "			</repository>\r\n" + "		  </repositories>\r\n" + "		  <pluginRepositories>\r\n"
				+ "			<pluginRepository>\r\n" + "			  <snapshots>\r\n"
				+ "				<enabled>false</enabled>\r\n" + "			  </snapshots>\r\n"
				+ "			  <id>vb-central</id>\r\n" + "			  <name>rappit-maven-repo</name>\r\n"
				+ "           	  <url>https://artifactory.vanenburg.com:443/artifactory/acc-rappit-maven-repo/</url>\r\n"
				+ "			</pluginRepository>\r\n" + "		  </pluginRepositories>\r\n"
				+ "		  <properties>\r\n" + "			<sonar.host.url>${env.SONAR_HOST_URL}</sonar.host.url>\r\n"
				+ "			<sonar.login>${env.SONAR_AUTH_TOKEN}</sonar.login>\r\n" + "		  </properties>\r\n"
				+ "		  <id>artifactory</id>\r\n" + "		</profile>\r\n" + "	</profiles>\r\n"
				+ "	<activeProfiles>\r\n" + "		<activeProfile>artifactory</activeProfile>\r\n"
				+ "	</activeProfiles>\r\n" + "</settings>\r\n" + "";
		StringSelection stringSelection = new StringSelection(emoji);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);
		// element =
		// driver.findElement(By.xpath("//body/div[1]/div[2]/div[2]/main[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]"));
		Thread.sleep(2000);
		// driver.findElement(By.id("branch_name")).click();
		WebElement element2 = driver
				.findElement(By.xpath("//textarea[@class='inputarea monaco-mouse-cursor-text']\r\n" + ""));
		element2.click();
		actions.keyDown(Keys.CONTROL);
		actions.sendKeys("v");
		actions.keyUp(Keys.CONTROL);
		actions.build().perform();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div/button[@id='commit-changes']")).click();

		driver.get("https://rappit-gitlab.vanenburg.com/rappit-dev/acceptance/eva-applications/" + projectName
				+ "/-/pipelines");

		Thread.sleep(5000);
		driver.get("https://console.cloud.google.com/apis/credentials?referrer=search&project=vb-eva-gen");

		Thread.sleep(10000);

		driver.findElement(
				By.xpath("//a[@track-type='api'][contains(.,'Web client  (auto created by Google Service)')]")).click();

		Thread.sleep(15000);

		driver.findElement(By.xpath("//span[@class='cfc-form-stack-add-text']")).click();

		List<WebElement> firstList = driver.findElements(By.xpath("//input[@formcontrolname='uri']"));

		for (int i = 0; i < firstList.size(); i++) {
			String Authorised_JavaScript_origins = firstList.get(i).getAttribute("value");
			// System.out.println(Authorised_JavaScript_origins);
			if (Authorised_JavaScript_origins.isEmpty()) {
				driver.findElements(By.xpath("//input[@formcontrolname='uri']")).get(i)
						.sendKeys("https://" + projectName + "-542250723797.europe-west1.run.app");
				actions.sendKeys(Keys.TAB).perform();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='cfc-form-stack-add-text'])[2]")).click();
			}

		}

		List<WebElement> firstList1 = driver.findElements(By.xpath("//input[@formcontrolname='uri']"));

		for (int i = 0; i < firstList1.size(); i++) {
			String Authorised_JavaScript_origins1 = firstList1.get(i).getAttribute("value");
			// System.out.println(Authorised_JavaScript_origins1);
			if (Authorised_JavaScript_origins1.isEmpty()) {
				driver.findElements(By.xpath("//input[@formcontrolname='uri']")).get(i).sendKeys(
						"http://" + projectName + "-542250723797.europe-west1.run.app/login/oauth2/code/google");
				actions.sendKeys(Keys.TAB).perform();
				Thread.sleep(3000);
				driver.findElement(By.xpath("(//span[@class='cfc-form-stack-add-text'])[2]")).click();
			}

		}

		List<WebElement> firstList2 = driver.findElements(By.xpath("//input[@formcontrolname='uri']"));

		for (int i = 0; i < firstList2.size(); i++) {
			String Authorised_JavaScript_origins2 = firstList2.get(i).getAttribute("value");
			// System.out.println(Authorised_JavaScript_origins2);
			if (Authorised_JavaScript_origins2.isEmpty()) {
				driver.findElements(By.xpath("//input[@formcontrolname='uri']")).get(i).sendKeys(
						"http://" + projectName + "-542250723797.europe-west1.run.app/oauth2/authorization/google");
				actions.sendKeys(Keys.TAB).perform();
				Thread.sleep(3000);

				// driver.findElement(By.xpath("(//span[@class='cfc-form-stack-add-text'])[2]")).click();
			}

		}

		driver.findElement(By.xpath("//span[@class='mdc-button__label'][contains(.,'Save')]")).click();

//Secret Manager

		Thread.sleep(3000);
		driver.get("https://console.cloud.google.com/security/secret-manager?project=vb-eva-gen");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[contains(.,'Create')])[3]")).click();
		Thread.sleep(4000);
		driver.findElement(By.cssSelector("#_0rif_mat-input-0")).sendKeys(projectName + "_configuration_json");
		Thread.sleep(3000);
//String emoji1="[\r\n"
//		+ "	{\r\n"
//		+ "		\"value\": \"/rest/task/submit/{id}\",\r\n"
//		+ "		\"key\": \"task_base_url\"\r\n"
//		+ "	},\r\n"
//		+ "	{\r\n"
//		+ "		\"value\": \"!@#$%$&pass!@##$\",\r\n"
//		+ "		\"key\": \"jwt_secret\"\r\n"
//		+ "	},\r\n"
//		+ "	{\r\n"
//		+ "		\"value\": \"vb-eva-gen-attachments\",\r\n"
//		+ "		\"key\": \"attachment_bucket_name\"\r\n"
//		+ "	},\r\n"
//		+ "	{\r\n"
//		+ "		\"value\": \"{\\\"db_url\\\": \\\"jdbc:mysql://10.46.1.3:3306/schema4\\\",\\\"db_user\\\": \\\"devuser\\\",\\\"db_password\\\": \\\"kGqxF04S9'4z89>T\\\"}\",\r\n"
//		+ "		\"key\": \"db_connection_info\"\r\n"
//		+ "	},\r\n"
//		+ "	{\r\n"
//		+ "		\"value\": \"{\\\"host\\\" : \\\"10.132.0.2\\\",\\\"port\\\" : 9200,\\\"user\\\" : \\\"evagenusr\\\",\\\"pwd\\\" : \\\"New@123\\\"}\",\r\n"
//		+ "		\"key\": \"elasticsearch_config\"\r\n"
//		+ "	},\r\n"
//		+ "	{\r\n"
//		+ "		\"key\": \"client-id\",\r\n"
//		+ "		\"value\": \"542250723797-6udeop4covmrjn4t14f35p8j0qmh8g8j.apps.googleusercontent.com\"\r\n"
//		+ "	},\r\n"
//		+ "	{\r\n"
//		+ "		\"key\": \"client-secret\",\r\n"
//		+ "		\"value\": \"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\"\r\n"
//		+ "	}\r\n"
//		+ "]";
//StringSelection stringSelection1 = new StringSelection(emoji1); 
//Clipboard clipboard1 =Toolkit.getDefaultToolkit().getSystemClipboard();
// clipboard1.setContents(stringSelection1, null); 
// //element = driver.findElement(By.xpath("//body/div[1]/div[2]/div[2]/main[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]")); 
		Thread.sleep(2000);
		// driver.findElement(By.id("branch_name")).click();
// WebElement element3 = driver.findElement(By.cssSelector("#_0rif_mat-input-1"));
// element3.click(); 
// actions.keyDown(Keys.CONTROL); actions.sendKeys("v");
// actions.keyUp(Keys.CONTROL); actions.build().perform();

		driver.findElement(By.cssSelector("#_0rif_mat-input-1")).sendKeys("[\r\n" + "  {\r\n"
				+ "    \"value\": \"/rest/task/submit/{id}\",\r\n" + "    \"key\": \"task_base_url\"\r\n" + "  },\r\n"
				+ "  {\r\n" + "    \"value\": \"!@#$%$&pass!@##$\",\r\n" + "    \"key\": \"jwt_secret\"\r\n"
				+ "  },\r\n" + "  {\r\n" + "    \"value\": \"vb-eva-gen-attachments\",\r\n"
				+ "    \"key\": \"attachment_bucket_name\"\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"value\": \"{\\\"db_url\\\": \\\"jdbc:mysql://10.46.1.3:3306/schema3\\\",\\\"db_user\\\": \\\"devuser\\\",\\\"db_password\\\": \\\"kGqxF04S9'4z89>T\\\"}\",\r\n"
				+ "    \"key\": \"db_connection_info\"\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"value\": \"{\\\"host\\\" : \\\"10.132.0.2\\\",\\\"port\\\" : 9200,\\\"user\\\" : \\\"evagenusr\\\",\\\"pwd\\\" : \\\"New@123\\\"}\",\r\n"
				+ "    \"key\": \"elasticsearch_config\"\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"key\": \"client-id\",\r\n"
				+ "    \"value\": \"542250723797-6udeop4covmrjn4t14f35p8j0qmh8g8j.apps.googleusercontent.com\"\r\n"
				+ "  },\r\n" + "  {\r\n" + "    \"key\": \"client-secret\",\r\n"
				+ "    \"value\": \"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\"\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"key\": \"from.name\",\r\n" + "    \"value\": \"rappit-minato\"\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"value\": \"yogiyogesh518@gmail.com\",\r\n" + "    \"key\": \"from.email\"\r\n" + "  }\r\n"
				+ "]\r\n" + "");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[@class='mdc-button__label'][contains(.,'Create secret')]")).click();
		Thread.sleep(10000);
		driver.get("https://console.cloud.google.com/security/secret-manager?project=vb-eva-gen");
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//span[contains(.,'Create')])[3]")).click();
		driver.findElement(By.cssSelector("#_0rif_mat-input-0")).sendKeys(projectName + "-sa-fs-connection-json");
		Thread.sleep(3000);
//String emoji2 = "{\r\n"
//		+ "  \"type\": \"service_account\",\r\n"
//		+ "  \"project_id\": \"vb-eva-gen\",\r\n"
//		+ "  \"private_key_id\": \"b27e15f4f8c0a8420574be728737b96cbf514820\",\r\n"
//		+ "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgyqcbTKzBq3vV\\nBe67fqUxFtYgxmiLIpvjmDqLrpoJmTQcuv0aj6QpHMb5wPhEV2rODhCbs98g3+H1\\naPxJbjJUhib6d+HHdtehi/J5EN0smr73Xzb1m6DW8D9zQCATleU7HcEfLWPSdisv\\nP92vV5lzEN6GGgnZYKotVDilAXEKZmNEkfX727wP0enHQufhUvC35p10M3mz1L22\\nClBc/29xUcPzcY1cw3XTUZ9BkKFtJP5H+ZqYDnp4XsFF0/ckNIa1lCHnC3AVzKEy\\n5HvR/hGKbnbLoWD9ZlkClGxO8dPVGPYa34KxcJVlOBsy05Arj61H1Yd7j3zReSYP\\nHvGdVcZlAgMBAAECggEAGSwgxTFXymoiVNM88LV+/xRoKXFmZIHijdsDL2MCUoZd\\nljHf9gyO0rDipa8ELw7QdbnV98pNIERsh5MMDCLoVjs6VvP1sNh2IaBbMYDmX1lK\\nlEefvwvCPmQWSuC7JNXOsVaTKWJdwlElqZwCBLVeHJmDfNMOv61Wdwo8Y/i5zbrC\\nQIO99W5BPyEMbsrPpGe17r6LRPjAE31lb9I1IM0LgO+8wQr/rXm/6sCGuJMhp6hj\\nm1XJXu5kNG59wrkawQTaRBdXg3W4+1/s7ehjJQV76LM7/nGxs67VZl7tILJDHUkf\\nIDYWTN36/f4GnCNwAY6sNG4RJ7YJxDh8P8GCxKyH8QKBgQDMrf6bNMbOLB+HHgod\\nLxAsgtjmNuIqin2dvEnx19CScOlBhseqPaKlOJKrMTFB+b1+hKGRHdzEGdAQQaX8\\nyAD1v78Zz82/eVkS9A4CAys3N8UmcWyozPRCRXMj61SDfBovn1JzFmxfd7Cr6w6f\\nHgv6Ika12N5j17h+JPPcC8kLGwKBgQDJG5DlxuB2/LDMqHE4gF/Z50slPJ5VJM/3\\nOYknQMMqgC17hLkKIi/AOVM6GYImMWHUGvAfURSXQnHkldLRr7+Cw7Cc1IpUQ5os\\nMO6aNZtwE2gGJ8MjPuduvJ9y6l3XsdDaz0HYVvFATunT1HGAP4y88zMO+KTibPii\\nhOwLVXwMfwKBgGElzIzaNeoxox08ssw7RE/8IvrR3fMXHJw7fFVfe82l7fB+ClLR\\nQlttSKAcjyajZL+iMBVyuRASuGCe6CvcuifqRMf5i8xvyklmsSdfXamtvNOMTmio\\nLt8tm4LW9Zwa0Ur9MeMSJ4oAg0h2HtCDMGge0LULJDL7dsPYwi4VIe01AoGARPhb\\nPTJzkNsgl0+9ZK9CMC0OrHqZooG5gQQOcZPYWx8SeiYOf9cxoS8HyAkvhYGyF1gV\\nuefItAdpoAdyAc/QUjxiuaZ6umNk4Hr3mZOA93LwXgwM9G2CWYv+8x5FiM/G3QPv\\nhQ5sNq3Zq3hUZLNmxPZzMFM92RmeO75yZYCvxmkCgYB6eoZiV3XKYO+1GTo05UCy\\n6fZzwMTvX04LI1y00dt0QvvZG42ZiOGNX+/WY9uGqQnlQ17PO34gDGsxnpKopeJT\\nMwnpnByt+6LjZjFfzNf4KFXAWej5FkwSWuh8HNweTMKQVrC6qQ8SQX+o9RqKp8PQ\\nPlpSLmM/2zRjJ/xncWGB8g==\\n-----END PRIVATE KEY-----\\n\",\r\n"
//		+ "  \"client_email\": \"firebase-adminsdk-bv2c8@vb-eva-gen.iam.gserviceaccount.com\",\r\n"
//		+ "  \"client_id\": \"113398304591968615991\",\r\n"
//		+ "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\r\n"
//		+ "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\r\n"
//		+ "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\r\n"
//		+ "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-bv2c8%40vb-eva-gen.iam.gserviceaccount.com\",\r\n"
//		+ "  \"universe_domain\": \"googleapis.com\"\r\n"
//		+ "}";
//StringSelection stringSelection2 = new StringSelection(emoji2); 
//Clipboard clipboard2 =Toolkit.getDefaultToolkit().getSystemClipboard();
// clipboard2.setContents(stringSelection2, null); 
// //element = driver.findElement(By.xpath("//body/div[1]/div[2]/div[2]/main[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]")); 
// Thread.sleep(2000);
// //driver.findElement(By.id("branch_name")).click();
// WebElement element4 = driver.findElement(By.cssSelector("#_0rif_mat-input-1"));
// element4.click(); 
// actions.keyDown(Keys.CONTROL); actions.sendKeys("v");
// actions.keyUp(Keys.CONTROL); actions.build().perform();

		driver.findElement(By.cssSelector("#_0rif_mat-input-1")).sendKeys("{\r\n"
				+ "  \"type\": \"service_account\",\r\n" + "  \"project_id\": \"vb-eva-gen\",\r\n"
				+ "  \"private_key_id\": \"b27e15f4f8c0a8420574be728737b96cbf514820\",\r\n"
				+ "  \"private_key\": \"-----BEGIN PRIVATE KEY-----\\nMIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCgyqcbTKzBq3vV\\nBe67fqUxFtYgxmiLIpvjmDqLrpoJmTQcuv0aj6QpHMb5wPhEV2rODhCbs98g3+H1\\naPxJbjJUhib6d+HHdtehi/J5EN0smr73Xzb1m6DW8D9zQCATleU7HcEfLWPSdisv\\nP92vV5lzEN6GGgnZYKotVDilAXEKZmNEkfX727wP0enHQufhUvC35p10M3mz1L22\\nClBc/29xUcPzcY1cw3XTUZ9BkKFtJP5H+ZqYDnp4XsFF0/ckNIa1lCHnC3AVzKEy\\n5HvR/hGKbnbLoWD9ZlkClGxO8dPVGPYa34KxcJVlOBsy05Arj61H1Yd7j3zReSYP\\nHvGdVcZlAgMBAAECggEAGSwgxTFXymoiVNM88LV+/xRoKXFmZIHijdsDL2MCUoZd\\nljHf9gyO0rDipa8ELw7QdbnV98pNIERsh5MMDCLoVjs6VvP1sNh2IaBbMYDmX1lK\\nlEefvwvCPmQWSuC7JNXOsVaTKWJdwlElqZwCBLVeHJmDfNMOv61Wdwo8Y/i5zbrC\\nQIO99W5BPyEMbsrPpGe17r6LRPjAE31lb9I1IM0LgO+8wQr/rXm/6sCGuJMhp6hj\\nm1XJXu5kNG59wrkawQTaRBdXg3W4+1/s7ehjJQV76LM7/nGxs67VZl7tILJDHUkf\\nIDYWTN36/f4GnCNwAY6sNG4RJ7YJxDh8P8GCxKyH8QKBgQDMrf6bNMbOLB+HHgod\\nLxAsgtjmNuIqin2dvEnx19CScOlBhseqPaKlOJKrMTFB+b1+hKGRHdzEGdAQQaX8\\nyAD1v78Zz82/eVkS9A4CAys3N8UmcWyozPRCRXMj61SDfBovn1JzFmxfd7Cr6w6f\\nHgv6Ika12N5j17h+JPPcC8kLGwKBgQDJG5DlxuB2/LDMqHE4gF/Z50slPJ5VJM/3\\nOYknQMMqgC17hLkKIi/AOVM6GYImMWHUGvAfURSXQnHkldLRr7+Cw7Cc1IpUQ5os\\nMO6aNZtwE2gGJ8MjPuduvJ9y6l3XsdDaz0HYVvFATunT1HGAP4y88zMO+KTibPii\\nhOwLVXwMfwKBgGElzIzaNeoxox08ssw7RE/8IvrR3fMXHJw7fFVfe82l7fB+ClLR\\nQlttSKAcjyajZL+iMBVyuRASuGCe6CvcuifqRMf5i8xvyklmsSdfXamtvNOMTmio\\nLt8tm4LW9Zwa0Ur9MeMSJ4oAg0h2HtCDMGge0LULJDL7dsPYwi4VIe01AoGARPhb\\nPTJzkNsgl0+9ZK9CMC0OrHqZooG5gQQOcZPYWx8SeiYOf9cxoS8HyAkvhYGyF1gV\\nuefItAdpoAdyAc/QUjxiuaZ6umNk4Hr3mZOA93LwXgwM9G2CWYv+8x5FiM/G3QPv\\nhQ5sNq3Zq3hUZLNmxPZzMFM92RmeO75yZYCvxmkCgYB6eoZiV3XKYO+1GTo05UCy\\n6fZzwMTvX04LI1y00dt0QvvZG42ZiOGNX+/WY9uGqQnlQ17PO34gDGsxnpKopeJT\\nMwnpnByt+6LjZjFfzNf4KFXAWej5FkwSWuh8HNweTMKQVrC6qQ8SQX+o9RqKp8PQ\\nPlpSLmM/2zRjJ/xncWGB8g==\\n-----END PRIVATE KEY-----\\n\",\r\n"
				+ "  \"client_email\": \"firebase-adminsdk-bv2c8@vb-eva-gen.iam.gserviceaccount.com\",\r\n"
				+ "  \"client_id\": \"113398304591968615991\",\r\n"
				+ "  \"auth_uri\": \"https://accounts.google.com/o/oauth2/auth\",\r\n"
				+ "  \"token_uri\": \"https://oauth2.googleapis.com/token\",\r\n"
				+ "  \"auth_provider_x509_cert_url\": \"https://www.googleapis.com/oauth2/v1/certs\",\r\n"
				+ "  \"client_x509_cert_url\": \"https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-bv2c8%40vb-eva-gen.iam.gserviceaccount.com\",\r\n"
				+ "  \"universe_domain\": \"googleapis.com\"\r\n" + "}\r\n" + "");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='mdc-button__label'][contains(.,'Create secret')]")).click();

		CloseableHttpClient httpClient = HttpClients.createDefault();
// Create a POST request
		HttpPost post = new HttpPost(
				"https://" + projectName + "-542250723797.europe-west1.run.app/rest/rdbms/generatesqlscript");

// Execute the request
		CloseableHttpResponse response = httpClient.execute(post);
		// Get the response code
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println("Response Code: " + statusCode);

		// Get the response body
		String responseBody = EntityUtils.toString(response.getEntity());
		System.out.println("Response Body: " + responseBody);

	}

	private static CharSequence getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	private static CharSequence getUserName() {
		// TODO Auto-generated method stub
		return null;
	}
}// remove these once above uncomment