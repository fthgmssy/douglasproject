package testcases;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class RandomCase extends BaseTest {

    String product[][]= new  String[3][4];
    Random random= new Random();
    int r;
    int position ;
    String count[][]= new  String[3][4];

    //Count eklenmiş random

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
        WebElement element = driver.findElement(By.xpath("//a[contains(text(),'PARFUM')]"));
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click()", element);
        Thread.sleep(14000);
        try{
            WebElement element2 = driver.findElement(By.xpath("//*[@class='survey-modal__close']"));
            JavascriptExecutor ex2 = (JavascriptExecutor) driver;
            ex2.executeScript("arguments[0].click()", element2);
        }catch (Exception e){
            System.out.println("Popup displayed");
        }

    }
    @Test(priority = 4)
    public void filterproduct() throws InterruptedException {

        for (int i = 0; i < 3; i++) {
            if (i < 3) {
                try {
                    driver.findElement(By.xpath("(//a[normalize-space()='Alle Filter löschen'])[1]")).click();
                    driver.navigate().refresh();
                    Thread.sleep(3000);
                    try{
                        WebElement element2 = driver.findElement(By.xpath("//*[@class='survey-modal__close']"));
                        JavascriptExecutor ex2 = (JavascriptExecutor) driver;
                        ex2.executeScript("arguments[0].click()", element2);
                    }catch (Exception e){
                        System.out.println("Popup displayed");
                    }
                    scrollDown();
                } catch (Exception e) {
                }
                driver.findElement(By.xpath("//div[normalize-space()='Highlights']//*[name()='svg']")).click();
                driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[" + (i + 1) + "]")).click();
                driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();
            }

            for (int j = 0; j < 4; j++) {
                if (j == 0) {
                    try {
                        driver.findElement(By.xpath("//div[normalize-space()='Marke']//*[name()='svg']")).click();
                        r = random.nextInt(8) + 3;
                        try {
                            driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[" + r + "]")).click();
                            product[i][j] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[" + r + "]")).getText();
                            System.out.println( product[i][j]);
                            driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();
                            position=product[i][j].indexOf("(");
                            count[i][j]=product[i][j].substring(position, product[i][j].length());
                        } catch (Exception e) {
                            product[i][j] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[1]")).getText();
                            position=product[i][j].indexOf("(");
                            count[i][j]=product[i][j].substring(position, product[i][j].length());
                            driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[1]")).click();
                            driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();
                        }
                    } catch (Exception ex) {
                        product[i][j] = " - ";
                        count[i][j]=" - ";
                    }
                } else if (j == 1) {
                    try {
                        driver.findElement(By.xpath("//div[normalize-space()='Produktart']//*[name()='svg']")).click();
                        r = random.nextInt(8) + 3;
                        try {
                            product[i][j] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[" + r + "]")).getText();
                            driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[" + r + "]")).click();
                            driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();
                            position=product[i][j].indexOf("(");
                            count[i][j]=product[i][j].substring(position, product[i][j].length());
                        } catch (Exception e) {
                            product[i][j] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[1]")).getText();
                            driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[1]")).click();
                            driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();
                            position=product[i][j].indexOf("(");
                            count[i][j]=product[i][j].substring(position, product[i][j].length());
                        }
                    } catch (Exception ex) {
                        product[i][j] = " - ";
                        count[i][j]=" - ";
                    }

                } else if (j == 2) {
                    try {
                        driver.findElement(By.xpath("//div[normalize-space()='Geschenk für']//*[name()='svg']")).click();
                        r = random.nextInt(8) + 3;
                        try {
                            product[i][j] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[" + r + "]")).getText();
                            driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[" + r + "]")).click();
                            driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();
                            position=product[i][j].indexOf("(");
                            count[i][j]=product[i][j].substring(position, product[i][j].length());
                        } catch (Exception e) {
                            product[i][j] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[1]")).getText();
                            driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[1]")).click();
                            driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();
                            position=product[i][j].indexOf("(");
                            count[i][j]=product[i][j].substring(position, product[i][j].length());
                        }
                    } catch (Exception ex) {
                        product[i][j] = " - ";
                        count[i][j]=" - ";
                    }
                } else {
                    try {

                        driver.findElement(By.xpath("//div[normalize-space()='Für Wen']//*[name()='svg']")).click();
                        r = random.nextInt(8) + 3;
                        try {
                            product[i][j] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[" + r + "]")).getText();
                            driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[" + r + "]")).click();
                            driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();
                            position=product[i][j].indexOf("(");
                            count[i][j]=product[i][j].substring(position, product[i][j].length());
                        } catch (Exception e) {
                            product[i][j] = driver.findElement(By.xpath("(//*[@class='facet-option__checkbox--rating-stars'])[1]")).getText();
                            driver.findElement(By.xpath("(//*[@class='facet-option__checkbox'])[1]")).click();
                            driver.findElement(By.xpath("(//button[normalize-space()='Schliessen'])[1]")).click();
                            position=product[i][j].indexOf("(");
                            count[i][j]=product[i][j].substring(position, product[i][j].length());
                        }
                    } catch (Exception ex) {
                        product[i][j] = " - ";
                        count[i][j]=" - ";
                    }
                }
            }
        }
    }


    @Test(priority = 5)
    public void excel() {
        writeExcelFile(product,"src/test/java/output/test2.xls");
        writeExcelFile(count,"src/test/java/output/test4.xls");
    }

    @Test(priority = 6)
    public void quit() {
        driver.quit();
    }
}