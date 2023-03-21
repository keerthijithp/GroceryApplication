package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	public void Stalenesswait(WebDriver driver,WebElement element) {
		WebDriverWait obj=new WebDriverWait(driver,Duration.ofMillis(5000));
		obj.until(ExpectedConditions.stalenessOf(element));
	}
	public void elementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait obj=new WebDriverWait(driver,Duration.ofMillis(5000));
		obj.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void presenceOfElement(WebDriver driver,WebElement element,String s) {
		WebDriverWait obj=new WebDriverWait(driver,Duration.ofMillis(5000));
		obj.until(ExpectedConditions.presenceOfElementLocated(By.xpath(s)));

}
}
