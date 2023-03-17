package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class setProperties {
    @Test(dataProvider = "credentials")
    public void testng(String scenario , String username , String password) {
        WebDriver driver = new ChromeDriver();
        System.setProperty("WebDriver.chrome.driver", "C:\\Users\\Rohit.Chavda\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println(e);
        }

        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        if (scenario.equals("Both_Correct"))
        {
//            WebElement login = driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']"));
//            Assert.assertTrue(login.isDisplayed(), "login success");
        }
//        else if (scenario.equals("Both_Wrong") && scenario.equals("Correct_Username") && scenario.equals("Correct_Password")) {
//            String errorMessage = driver.findElement(By.xpath("//p[text()='Invalid credentials']")).getText();
//            Assert.assertEquals(errorMessage, "login not success");
//        }
        else if (scenario.equals("Both_null")) {
            String errorMessage = driver.findElement(By.xpath("//span")).getText();
            Assert.assertEquals(errorMessage, "login not success");
        }
    }

    @DataProvider(name = "credentials")
    public Object[][] getData() {
        return new Object[][] {
//                {"Both_Correct","Admin","admin123"},
//                {"Both_Wrong","xyz","passwordadmin"},
//                {"Correct_Username","Admin","admin@123"},
//                {"Correct_Password","username1","admin123"}
                {"Both_null","",""}
        };
    }
}
