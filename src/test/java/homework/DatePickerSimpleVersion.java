package homework;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DatePickerSimpleVersion extends TestBase {

    @Test
    public void chooseCorrectDate(){

        driver.get("https://seleniumui.moderntester.pl/datepicker.php");

        WebElement datePicker = driver.findElement(By.xpath("//input[@type='text']"));

        datePicker.sendKeys("31/08/2022");

        Assert.assertEquals(datePicker.getAttribute("value"), "31/08/2022");

    }
}