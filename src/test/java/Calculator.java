import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Calculator {
    private WebDriver driver;
    private WebElement firstField;
    private WebElement secondField;
    private WebElement operation;
    private WebElement calculateButton;
    private WebElement answer;
    private WebElement clearBtn;

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "/Users/macbook/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

    }

    @BeforeMethod
    public void restart() {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        firstField = driver.findElement(By.id("number1Field"));
        secondField = driver.findElement(By.id("number2Field"));
        operation = driver.findElement(By.id("selectOperationDropdown"));
        calculateButton = driver.findElement(By.id("calculateButton"));
        answer = driver.findElement(By.id("numberAnswerField"));
        clearBtn = driver.findElement(By.id("clearButton"));

    }

    @Test
    public void test1() throws InterruptedException {

        firstField.sendKeys("3");
        secondField.sendKeys("0");

        Select select = new Select(operation);
        select.selectByVisibleText("Add");

        calculateButton.click();

        String actualResult1 = answer.getAttribute("value");
        String expectedResult1 = "3";

        Assert.assertEquals(actualResult1, expectedResult1);
        clearBtn.click();

        Thread.sleep(3000);
        select.selectByVisibleText("Subtract");
        calculateButton.click();

        String actualResult2 = answer.getAttribute("value");
        String expectedResult2 = "3";

        Assert.assertEquals(actualResult2, expectedResult2);
        clearBtn.click();

        Thread.sleep(3000);
        select.selectByVisibleText("Multiply");
        calculateButton.click();

        String actualResult3 = answer.getAttribute("value");
        String expectedResult3 = "0";

        Assert.assertEquals(actualResult3, expectedResult3);
        clearBtn.click();

        Thread.sleep(3000);
        select.selectByVisibleText("Divide");
        calculateButton.click();

        String actualResult4 = answer.getAttribute("value");
        String expectedResult4 = "0";

        Assert.assertEquals(actualResult4, expectedResult4);
        clearBtn.click();

        Thread.sleep(3000);
    }

    @Test
    public void test2() throws InterruptedException {

        firstField.sendKeys("99000000");
        secondField.sendKeys("100000000");

        Select select = new Select(operation);
        select.selectByVisibleText("Add");

        calculateButton.click();

        String actualResult1 = answer.getAttribute("value");
        String expectedResult1 = "199000000";

        Assert.assertEquals(actualResult1, expectedResult1);
        clearBtn.click();

        Thread.sleep(3000);
        select.selectByVisibleText("Subtract");
        calculateButton.click();

        String actualResult2 = answer.getAttribute("value");
        String expectedResult2 = "-1000000";

        Assert.assertEquals(actualResult2, expectedResult2);
        clearBtn.click();

        Thread.sleep(3000);
        select.selectByVisibleText("Multiply");
        calculateButton.click();

        String actualResult3 = answer.getAttribute("value");
        String expectedResult3 = "9900000000000000";

        Assert.assertEquals(actualResult3, expectedResult3);
        clearBtn.click();

        Thread.sleep(3000);
        select.selectByVisibleText("Divide");
        calculateButton.click();

        String actualResult4 = answer.getAttribute("value");
        String expectedResult4 = "0.99";

        Assert.assertEquals(actualResult4, expectedResult4);
        clearBtn.click();

        Thread.sleep(3000);
    }

    @Test
    public void test3() throws InterruptedException {

        firstField.sendKeys("13");
        secondField.sendKeys("-54");

        Select select = new Select(operation);
        select.selectByVisibleText("Add");

        calculateButton.click();

        String actualResult1 = answer.getAttribute("value");
        String expectedResult1 = "-41";

        Assert.assertEquals(actualResult1, expectedResult1);
        clearBtn.click();

        Thread.sleep(3000);
        select.selectByVisibleText("Subtract");
        calculateButton.click();

        String actualResult2 = answer.getAttribute("value");
        String expectedResult2 = "67";

        Assert.assertEquals(actualResult2, expectedResult2);
        clearBtn.click();

        Thread.sleep(3000);
        select.selectByVisibleText("Multiply");
        calculateButton.click();

        String actualResult3 = answer.getAttribute("value");
        String expectedResult3 = "-702";

        Assert.assertEquals(actualResult3, expectedResult3);
        clearBtn.click();

        Thread.sleep(3000);
        select.selectByVisibleText("Divide");
        calculateButton.click();

        String actualResult4 = answer.getAttribute("value");
        String expectedResult4 = "-0.24074074074074073";

        Assert.assertEquals(actualResult4, expectedResult4);
        clearBtn.click();

        Thread.sleep(3000);
    }

    @Test
    public void test4() throws InterruptedException {

        firstField.sendKeys("4.6");
        secondField.sendKeys("-7.1");

        Select select = new Select(operation);
        select.selectByVisibleText("Add");

        calculateButton.click();

        String actualResult1 = answer.getAttribute("value");
        String expectedResult1 = "-2.5";

        Assert.assertEquals(actualResult1, expectedResult1);
        clearBtn.click();

        Thread.sleep(3000);
        select.selectByVisibleText("Subtract");
        calculateButton.click();

        String actualResult2 = answer.getAttribute("value");
        String expectedResult2 = "11.7";

        Assert.assertEquals(actualResult2, expectedResult2);
        clearBtn.click();

        Thread.sleep(3000);
        select.selectByVisibleText("Multiply");
        calculateButton.click();

        String actualResult3 = answer.getAttribute("value");
        String expectedResult3 = "-32.66";

        Assert.assertEquals(actualResult3, expectedResult3);
        clearBtn.click();

        Thread.sleep(3000);
        select.selectByVisibleText("Divide");
        calculateButton.click();

        String actualResult4 = answer.getAttribute("value");
        String expectedResult4 = "-0.647887323943662";

        Assert.assertEquals(actualResult4, expectedResult4);
        clearBtn.click();

        Thread.sleep(3000);
    }

    @AfterClass
    public void afterClass(){
        driver.quit();
    }
}

