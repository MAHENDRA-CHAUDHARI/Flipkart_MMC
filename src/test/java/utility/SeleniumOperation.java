package utility;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;



public class SeleniumOperation
{
	public static Hashtable<String,Object> outputParameters=new Hashtable<String,Object>();
    public  static WebDriver driver=null;
     
  	//open browser
  	public static Hashtable<String,Object> browserLaunch(Object[] inputParameters)
  	{		
  		try
  		{          
  		  String strBroserName=(String)inputParameters[0];
  		  String webDriverExePath=(String)inputParameters[1]; 
  		                 
  	  if(strBroserName.equalsIgnoreCase("Chrome"))
  			  {		       
  				  System.setProperty("webdriver.chrome.driver",webDriverExePath);			
  				  driver=new ChromeDriver();
  				  driver.manage().window().maximize();
  				  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  			  }
  	  else if(strBroserName.equalsIgnoreCase("FF"))
  			  {
  				  System.setProperty("webdriver.gecko.driver",webDriverExePath);			
  				  driver=new FirefoxDriver();
  				  driver.manage().window().maximize();
  				  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  			  }	
  	      outputParameters.put("STATUS", "PASS");
  	      outputParameters.put("MESSAGE", "ACTION :Open Browser, Input Given :"+inputParameters[0].toString());
  		}
  		catch(Exception e)
  		{
  		  outputParameters.put("STATUS", "FAIL");
  		  outputParameters.put("MESSAGE", "ACTION :Open Browser, Input Givem :"+inputParameters[0].toString());
  		}
  		return outputParameters;
  	}
  	
  	//openApplication
  	public static Hashtable<String,Object> openApplication(Object[] inputParameters)
  	{
  		try{
  		  		
  		String url=(String)inputParameters[0];
  		driver.get(url);
  		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  		
  		outputParameters.put("STATUS", "PASS");
    	outputParameters.put("MESSAGE", "ACTION :Open Application, Input Given :"+inputParameters[0].toString());
	
  	
  		}catch(Exception e)
  		{
  		outputParameters.put("STATUS", "FAIL");
  	    outputParameters.put("MESSAGE", "ACTION :Open Application, Input Given :"+inputParameters[0].toString());
  		}	
  		return outputParameters;
  	}
  	
  	//sendKey 
  	public static Hashtable<String,Object> sendKey(Object[] inputParameters)
  	{
  		try
  		{
  		String xpath1=(String)inputParameters[0];
  		String value1=(String)inputParameters[1];
  		
  		driver.findElement(By.xpath(xpath1)).sendKeys(value1);
  		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  		
  		outputParameters.put("STATUS", "PASS");
    	outputParameters.put("MESSAGE", "ACTION :SendKey, Input Given :"+inputParameters[1].toString());
  	
  		}catch(Exception e)
  		{
  		outputParameters.put("STATUS", "FAIL");
  	    outputParameters.put("MESSAGE", "ACTION :SendKey, Input Given :"+inputParameters[1].toString());
  		} 	
  		return outputParameters;
  	}
  	
  	//drop down
  	public static Hashtable<String,Object> dropdown(Object[] inputParameters)
  	{
  		try{
  		String xpath1=(String)inputParameters[0];
  		String value=(String)inputParameters[1];
  		
  		Select sel=new Select(driver.findElement(By.xpath(xpath1)));
  		sel.selectByVisibleText(value);
  		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  		
  		outputParameters.put("STATUS", "PASS");
    	outputParameters.put("MESSAGE", "ACTION :DropDown, Input Given :"+inputParameters[1].toString());
  		
  		}catch(Exception e)
  		{
  		outputParameters.put("STATUS", "FAIL");
  	    outputParameters.put("MESSAGE", "ACTION :DropDown, Input Given :"+inputParameters[1].toString());
  		}
  		return outputParameters;
  		 		
  	}
  	
  	//click
  	public static Hashtable<String,Object> Click(Object[] inputParameters)
  	{
  		try{
  		String xpath=(String)inputParameters[0];	
  		driver.findElement(By.xpath(xpath)).click();
  		
  		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  		 
  		outputParameters.put("STATUS", "PASS");
    	outputParameters.put("MESSAGE", "ACTION :Click, Input Given :"+inputParameters[0].toString());
    	
  		}catch(Exception e)
  		{
  		outputParameters.put("STATUS", "FAIL");
  	    outputParameters.put("MESSAGE", "ACTION :Click, Input Given :"+inputParameters[0].toString());
  		}
  		return outputParameters;
  	}
	
	//Mouse Hover
	public static Hashtable<String,Object> mouseOver(Object[]inputParameters)
	{
		try
		{
		String elexpath=(String)inputParameters[0];
		Actions act=new Actions(driver);
		WebElement ele=driver.findElement(By.xpath(elexpath));
		act.moveToElement(ele).build().perform();
		System.out.println("Successfully moved to given element");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		outputParameters.put("STATUS", "PASS");
    	outputParameters.put("MESSAGE", "ACTION :MouseHover, Input Given :"+inputParameters[0].toString());
	
		}
		catch(Exception e)
		{
		outputParameters.put("STATUS", "FAIL");
	    outputParameters.put("MESSAGE", "ACTION :MouseHover, Input Given :"+inputParameters[0].toString());
		}
		return outputParameters;
	}
	
	
	//Validation
	public static Hashtable<String,Object> validation(Object[] inputParameters)
  	{
  		try{
  		String given=(String)inputParameters[0];
  		String xpath=(String)inputParameters[1];
  		
  		String text=driver.findElement(By.xpath(xpath)).getText();
  		
  		if(text.equalsIgnoreCase(given))
  		{
  			System.out.println("Test Case pass");
  			
  		}else
  		{
  			System.out.println("Test Case Fail");
  			outputParameters.put("STATUS", "FAIL");
  	    	outputParameters.put("MESSAGE", "ACTION :Validation, Input Given :"+inputParameters[0].toString());
  		}
  		
  		}catch(Exception e)
  		{
  		outputParameters.put("STATUS", "FAIL");
  	    outputParameters.put("MESSAGE", "ACTION :Validation, Input Given :"+inputParameters[0].toString());
  		}
  		 return outputParameters;	
  	}
	

	public static void closeBrowserWindow() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.close();
	}
	
}