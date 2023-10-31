package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.*;

public class TestCase extends BaseTest {

    Random random= new Random();
    int r;
    String product[][]= new  String[3][4];
    String count[][]= new  String[3][4];
    int position ;

    @Test(priority = 1)
    public void navigatetoUrl() throws MalformedURLException {

        setUp("https://douglas.de/de");
    }

    @Test(priority = 2)
    public void acceptcookie() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable((By.xpath("//button[contains(text(),'Alle erlauben')]"))));
        driver.findElement(By.xpath("//button[contains(text(),'Alle erlauben')]")).click();

    }

    @Test(priority = 3)
    public void clickparfum() throws InterruptedException
    {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'PARFUM')]"));
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click()", element);
        Thread.sleep(4000);
        try{
            WebElement element2 = driver.findElement(By.xpath("//*[@class='survey-modal__close']"));
            JavascriptExecutor ex2 = (JavascriptExecutor) driver;
            ex2.executeScript("arguments[0].click()", element2);
        }catch (Exception e){

        }

    }
    @Test(priority = 4)
    public void filtersale() throws InterruptedException
    {
        scrollDown();

        driver.findElement(By.xpath("//div[normalize-space()='Highlights']//*[name()='svg']")).click();
        driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[normalize-space()='Marke']//*[name()='svg']")).click();
        product[0][0] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[2]")).getText();
        driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[2]")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();

        driver.findElement(By.xpath("//div[normalize-space()='Produktart']//*[name()='svg']")).click();
        product[0][1] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[1]")).getText();
        driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();

        driver.findElement(By.xpath("//div[normalize-space()='Geschenk für']//*[name()='svg']")).click();
        product[0][2] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[1]")).getText();
        driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();

        driver.findElement(By.xpath("//div[normalize-space()='Für Wen']//*[name()='svg']")).click();
        product[0][3] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[1]")).getText();
        driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();


    }
    @Test(priority = 5)
    public void filterneu() throws InterruptedException
    {
        driver.findElement(By.xpath("(//a[normalize-space()='Alle Filter löschen'])[1]")).click();
        driver.navigate().refresh();
        Thread.sleep(6000);

        try{
            WebElement element2 = driver.findElement(By.xpath("//*[@class='survey-modal__close']"));
            JavascriptExecutor ex2 = (JavascriptExecutor) driver;
            ex2.executeScript("arguments[0].click()", element2);
        }catch (Exception e){

        }

        scrollDown();

        driver.findElement(By.xpath("//div[normalize-space()='Highlights']//*[name()='svg']")).click();
        driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[2]")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();

        driver.findElement(By.xpath("//div[normalize-space()='Marke']//*[name()='svg']")).click();
        Thread.sleep(3000);
        product[1][0] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[1]")).getText();
        driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();

        driver.findElement(By.xpath("//div[normalize-space()='Produktart']//*[name()='svg']")).click();
        product[1][1] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[1]")).getText();
        driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();

        try{
            driver.findElement(By.xpath("//div[normalize-space()='Geschenk für']//*[name()='svg']"));
            driver.findElement(By.xpath("//div[normalize-space()='Geschenk für']//*[name()='svg']")).click();
            product[1][2] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[" + r + "]")).getText();
            driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[" + r + "]")).click();
            driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();
        }
        catch (Exception ex){
            product[1][2] ="-";
        }

        driver.findElement(By.xpath("//div[normalize-space()='Für Wen']//*[name()='svg']")).click();
        product[1][3] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[1]")).getText();
        driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();


    }
    @Test(priority = 6)
    public void filterlimitiert() throws InterruptedException
    {
        driver.findElement(By.xpath("(//a[normalize-space()='Alle Filter löschen'])[1]")).click();
        driver.navigate().refresh();
        Thread.sleep(6000);

        try{
            WebElement element2 = driver.findElement(By.xpath("//*[@class='survey-modal__close']"));
            JavascriptExecutor ex2 = (JavascriptExecutor) driver;
            ex2.executeScript("arguments[0].click()", element2);
        }catch (Exception e){

        }

        scrollDown();

        driver.findElement(By.xpath("//div[normalize-space()='Highlights']//*[name()='svg']")).click();
        driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[3]")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//div[normalize-space()='Marke']//*[name()='svg']")).click();
        driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[4]")).click();
        product[2][0] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[4]")).getText();
        driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();

        driver.findElement(By.xpath("//div[normalize-space()='Produktart']//*[name()='svg']")).click();
        product[2][1] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[1]")).getText();
        driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();

        driver.findElement(By.xpath("//div[normalize-space()='Geschenk für']//*[name()='svg']")).click();
        product[2][2] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[1]")).getText();
        driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[1]")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();

        driver.findElement(By.xpath("//div[normalize-space()='Für Wen']//*[name()='svg']")).click();
        product[2][3] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[2]")).getText();
        driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[2]")).click();
        driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();
    }

    @Test(priority = 7)
    public void excel() {
        writeExcelFile(product,"src/test/java/output/test3.xls");
    }
    @Test(priority = 8)
    public void quit() {
        driver.quit();
    }
}









