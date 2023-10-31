package base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class BaseTest {

    public static WebDriver driver;

    Random random= new Random();
    public static int r;
    public static String product[][]= new  String[3][4];
    public static String count[][]= new  String[3][4];
    public static int position ;

    public static void setUp(String url) throws MalformedURLException {
        //driver = new ChromeDriver();
        System.setProperty("webdriver.gecko.driver",
                System.getProperty("user.dir") + "//src//test//resources//executables//geckodriver");
        driver = new FirefoxDriver();
        //driver = new RemoteWebDriver(new URL("http://localhost:4445/wd/hub"), DesiredCapabilities.chrome());
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(25000, TimeUnit.MILLISECONDS);

    }

    public static void setUpChrome(String url) throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "//src//test//resources//executables//chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(25000, TimeUnit.MILLISECONDS);

    }

    public void scrollDown(){

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,450)");
    }

    public void writeExcelFile(String product[][], String excelname)
    {
        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFSheet sheet = workbook.createSheet("Product Sheet");


        Map<String, Object[]> data = new HashMap<String, Object[]>();

        data.put("1", new Object[] {"Criteria","Marke", "Produktart", "Geschenk für","Für Wen"});

        data.put("2", new Object[] {"Sale",product[0][0], product[0][1], product[0][2],product[0][3]});

        data.put("3", new Object[] {"Neu",product[1][0], product[1][1], product[1][2],product[1][3]});

        data.put("4", new Object[] {"Limitiert",product[2][0], product[2][1], product[2][2],product[2][3]});


        Set<String> keyset = data.keySet();

        int rownum = 0;

        for (String key : keyset) {

            Row row = sheet.createRow(rownum++);

            Object [] objArr = data.get(key);

            int cellnum = 0;

            for (Object obj : objArr) {

                Cell cell = row.createCell(cellnum++);

                if(obj instanceof Date)

                    cell.setCellValue((Date)obj);

                else if(obj instanceof Boolean)

                    cell.setCellValue((Boolean)obj);

                else if(obj instanceof String)

                    cell.setCellValue((String)obj);

                else if(obj instanceof Double)

                    cell.setCellValue((Double)obj);

            }

        }
        try {

            FileOutputStream out = new FileOutputStream(new File(excelname));

            workbook.write(out);

            out.close();

            System.out.println("Excel writed..");

        } catch (FileNotFoundException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }

}