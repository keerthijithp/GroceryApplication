package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

public class GeneralUtilities {
	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;

	}

	public String selectValueFromDropDown(WebElement element, String value) {
		Select obj = new Select(element);
		obj.selectByValue(value);
		WebElement selectedValue = obj.getFirstSelectedOption();
		String text = selectedValue.getText();
		return text;
	}

	public Boolean selectCheckBox(WebElement element) {
		element.click();
		Boolean result = element.isSelected();
		System.out.println(result);
		return result;
	}
	public String getTextOfWebElement(WebElement element) {
		String text=element.getText();
		return text;
	}
	public String getBackgroundColourOfaButton(WebElement element) {
		String bgColor=element.getCssValue("background-color");
		//return bgColor;
		String actual=Color.fromString(bgColor).asHex();
		return actual;
		
	}
	public void uploadFile(WebDriver driver,WebElement element, String filePath) throws AWTException {
		Robot r=new Robot();
		Actions act=new Actions(driver);
		act.moveToElement(element).click().perform();
		StringSelection ss = new StringSelection(filePath);
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	    r.delay(500);;
	    r.keyPress(KeyEvent.VK_CONTROL);
	    r.keyPress(KeyEvent.VK_V);
	    r.delay(250);
	    r.keyRelease(KeyEvent.VK_CONTROL);
	    r.keyRelease(KeyEvent.VK_V);
	    r.delay(250);
	    r.keyPress(KeyEvent.VK_ENTER);//After pasting press enter key or open tab
	    r.keyRelease(KeyEvent.VK_ENTER);
		
	}
	public int getTableLocatorValue(List<WebElement> element, String text) {
		int index=0;
		for(int i=0;i<element.size();i++) {
			if(element.get(i).getText().equals(text)) {
				index=i;
				break;
			}
			
		}
		return index;

	}
	
	

}
