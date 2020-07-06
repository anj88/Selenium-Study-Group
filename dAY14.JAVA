package StudyGroup;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Day14 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Joe\\eclipse-workspace\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://demo.automationtesting.in/Register.html");
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		

		Actions action = new Actions(driver);
		//getting Title
		System.out.println(driver.getTitle());

		//Getting Current URL
		System.out.println(driver.getCurrentUrl());

		//Getting PageSource
		String pagesource= driver.getPageSource();
		Assert.assertTrue(pagesource.contains("dropdown"));


		//WebElements
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement FirstName =driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		WebElement LastName =driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		WebElement Address =driver.findElement(By.cssSelector("textarea"));
		WebElement EmailLabel=driver.findElement(By.xpath("//label[contains(text(),'Email address*')]"));
		WebElement phone = driver.findElement(By.xpath("//input[@type='tel']"));
		WebElement radio =driver.findElement(By.xpath("//input[@value='Male']"));
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
		List<WebElement>Languages = driver.findElements(By.xpath("//a[@class='ui-corner-all']"));
		WebElement year =driver.findElement(By.id("yearbox"));
		WebElement month =driver.findElement(By.xpath("//select[@placeholder='Month']"));
		WebElement date =driver.findElement(By.id("daybox"));
		WebElement skills =driver.findElement(By.id("Skills"));
		WebElement selectcountry=driver.findElement(By.xpath("//span[@class='select2-selection__arrow']//b"));
		WebElement SubmitButton =driver.findElement(By.id("submitbtn"));
		




		//WebElement tooltip =driver.findElement(By.cssSelector(".col-sm-4 col-xs-4 tooltptext"));
		//#basicBootstrapForm .form-group:nth-of-type(2) 
		//FirstName
		FirstName.clear();
		LastName.clear();
		if(FirstName.isEnabled()) {
			FirstName.sendKeys("Anjali");
		}
		//LastName
		if(LastName.isEnabled()) {
			LastName.sendKeys("Nair");
		}
		//Address
		if(Address.isDisplayed()) {
			Address.sendKeys("Abcdefghi");

		}
		//Email Address
		String emailpresent =EmailLabel.getText();
		if(emailpresent.equals("Email address*")) {
			driver.findElement(By.xpath("//input[@type='email']")).sendKeys("abc@gmail.com");
		}

		//Phone
		phone.sendKeys("6474103926");
		radio.click();

		//Checkbox , first we will check if any checkbox is checked
		//System.out.println(checkbox.getSize());
		//driver.findElement(By.id("checkbox1")).clear();
		//driver.findElement(By.id("checkbox2")).clear();
		//driver.findElement(By.id("checkbox3")).clear();
		//if(!checkbox.isSelected()) {
		//	checkbox.click();
		//}
		//System.out.println(checkboxes.s ize());


		for(int i=0;i<checkboxes.size();i++){
			if(!checkboxes.get(i).isSelected()) // validate Checked property, otherwise you'll uncheck!
				checkboxes.get(i).click();
			if(checkboxes.get(i).isSelected()) {
				System.out.println("Checkbox"+(i+1)+"is selected");
			}
		}

		//count of language dropdown elements
		int CountLanguages = Languages.size();
		System.out.println("number of languages present in the dropbox is "+CountLanguages);
		//selecting arabic and English
		//Thread.sleep(1000);
		driver.findElement(By.id("msdd")).click();
		WebElement L=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Filipino')]")));
		WebElement A=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Croatian')]")));
		WebElement N=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Dutch')]")));
		WebElement G=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'French')]")));
		L.click();
		A.click();
		N.click();
		G.click();
		//click anywhere on the screen
		action.moveByOffset(913, 477).click().build().perform();

		//Skills
		skills.click();
		Select s1 = new Select(skills);
		s1.selectByValue("Android");


		Select s2 = new Select(driver.findElement(By.id("countries")));
		s2.selectByValue("Afghanistan");
		//Auto suggestive dropbox
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		
		selectcountry.click();
		//selectcountry.sendKeys("aus");
		WebElement value=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//input[@type='search']"))));
		value.sendKeys("aus");
		
		value.sendKeys(Keys.ARROW_DOWN);
		value.sendKeys(Keys.ENTER);
		String text =selectcountry.getText();
		System.out.println("Text in the dropdown is"+text);

		//DOB
		Select s3 = new Select(year);
		Select s4= new Select(month);
		Select s5=new Select(date);
		s3.selectByVisibleText("1923");
		s4.selectByValue("January");
		s5.selectByValue("7");

		//Password
		driver.findElement(By.id("firstpassword")).sendKeys("Anjali16*");
		driver.findElement(By.id("secondpassword")).sendKeys("Anjali16*");
		
		SubmitButton.click();
		

		//driver.close();			
	}

}
