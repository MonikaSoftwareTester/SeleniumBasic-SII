package homework;

import ch3_TestBase.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DatePicker extends TestBase {

    @Test
    public void shouldPick31August2022OnDatePicker(){

        //to zadanie zrobiłam bazując na tym, co znalazłam w internecie

        String target_date= "08/31/2022";
        String target_year = "2022";
        String target_month = "August";
        String space = " ";

        driver.get("https://seleniumui.moderntester.pl/datepicker.php");

        driver.findElement(By.cssSelector("#datepicker")).click();

        String year = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
        String month = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();

        String targetMonthAndYear = target_month+space+target_year;
        String selectedMonthAndYear = month+space+year;

        while (!selectedMonthAndYear.equals(targetMonthAndYear)){
            if (Integer.parseInt(target_year)<Integer.parseInt(year)){
                driver.findElement(By.cssSelector(".ui-datepicker-prev")).click();
            } else {
                driver.findElement(By.cssSelector(".ui-datepicker-next")).click();
            }

            month = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
            year = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();

            selectedMonthAndYear = month+space+year;
        }

        List<WebElement> days = driver.findElements(By.xpath("//a[contains(text(),'31')]"));
        if (days.size()>1){
            days.get(1).click();
        } else {
            days.get(0).click();
        }

        String final_date = driver.findElement(By.cssSelector("#datepicker")).getAttribute("value");

        Assert.assertEquals(final_date,target_date);
    }
}
