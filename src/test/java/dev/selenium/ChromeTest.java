package dev.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class ChromeTest {

    static ChromeDriver driver;

    @BeforeAll
    public static void start (){

        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.get("https://www.backmarket.es/es-es");

    }


    @Test
    public void CPF1() throws Exception{

        WebElement cookies = driver.findElement(By.xpath("// button [@type = \"button\" ]"));
        cookies.click();

        Thread.sleep(2000);
        
        WebElement searchInput = driver.findElement(By.id("forceQueryPersistanceID"));
        searchInput.sendKeys("watch");

        Thread.sleep(2000);

        WebElement searchButton = driver.findElement(By.xpath("//button[@aria-label = \"Search\"]"));
        searchButton.click();

        Thread.sleep(2000);



    }

    @Test
    public void CPF2() throws Exception{
        
        CPF1();
        
        WebElement item = driver.findElement(By.xpath("// a [@href= \"/es-es/p/apple-watch-series-se-gps-40-mm-aluminio-blanco-estrella-correa-deportiva-blanco-estrella/78fb1d27-1e8b-4a8c-b917-fe54b3f6820c#l=10\"]"));
        item.click();

        Thread.sleep(2000);

        WebElement buyButton = driver.findElement(By.xpath("// button [@data-id]"));
        buyButton.click();

        Thread.sleep(2000);

        WebElement noButton = driver.findElement(By.xpath("// button [@data-qa=\"user-no\"]"));
        noButton.click();

        Thread.sleep(2000);

        WebElement goToCart = driver.findElement(By.xpath("// button [@data-qa=\"continue-shopping\"]"));
        goToCart.click();



    }
    

    @Test
    public void CPF3() throws Exception{
        
        CPF1();
        
        WebElement item = driver.findElement(By.xpath("// a [@href= \"/es-es/p/apple-watch-series-se-gps-40-mm-aluminio-blanco-estrella-correa-deportiva-blanco-estrella/78fb1d27-1e8b-4a8c-b917-fe54b3f6820c#l=10\"]"));
        item.click();

        Thread.sleep(2000);

        WebElement favButton = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div/div/div[3]/div/div/div[2]/div/div/div[1]/div/div[2]/div[2]/div[2]/button"));
        favButton.click();

        Thread.sleep(2000);

        driver.navigate().back();

        Thread.sleep(5000);

    }


    @Test
    public void CPF4() throws Exception{

        CPF1();

        WebElement samsung = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div/div/div/div/section/div[2]/div[1]/div/ul/li[2]/div/div[3]/ul/li[3]/div/label"));
        WebElement muyBueno = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div/div/div/div/section/div[2]/div[1]/div/ul/li[4]/div/div[2]/ul/li[3]/div/label"));
        WebElement precioMin = driver.findElement(By.id("min"));

        samsung.click();

        Thread.sleep(3000);

        muyBueno.click();

        Thread.sleep(3000);

    }
    
    
    
    @Test
    public void dropdownCheck() throws Exception{

        WebElement select = driver.findElement(By.name("my-select"));
        Select comboSelect = new Select(select);
        comboSelect.selectByIndex(2);

    }


    @Test
    public void elementDataForms() throws Exception{
        
        WebElement calendar = driver.findElement(By.name("my-date"));
        calendar.sendKeys("01/30/2024");

    }


    @AfterAll
    public static void end(){
        try {
            Thread.sleep(4000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        driver.quit();
    }


    
    @Test
    public void basicOptions() throws InterruptedException{

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
        
        // System.out.println(driver.getTitle())

        WebElement textInput =  driver.findElement(By.id("my-text-id"));
        textInput.sendKeys("Pop");
        Thread.sleep(5000);

        WebElement buttonInput = driver.findElement(By.className("btn"));
        buttonInput.click();

        WebElement submit = driver.findElement(By.className("display-6"));
        System.out.println(submit.getText());
        assertEquals("Form submitted", submit.getText());
        Thread.sleep(5000);
        driver.quit();
       
    
    }

    @Test
    public void elementForms() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        // Comprobar si el 'input' 'check' está marcado

        WebElement checkButton = driver.findElement(By.id("my-check-1"));
        assertEquals(true, checkButton.isSelected());
        assertTrue(checkButton.isSelected());


        /* Comprobando si sirve de condición para un 'if'
        
        if(checkButton.isSelected() == true){

            System.out.println("está seleccionado");

        } */


        // Comprobar si se puede escribir en el 'input diseabled'


        WebElement disabledInput = driver.findElement(By.name("my-disabled"));
        disabledInput.sendKeys("Hohohoh");


        Thread.sleep(5000);
        driver.quit();

    }

    @Test
    public void uploadPic() throws InterruptedException{

        // 'ChromeOpions' no son necesarias si no se van a utilizar
        // ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");

        
        String picName = "casa.png";
        File uploadPicFile = new File("src/test/files/" + picName);
        WebElement dropPic = driver.findElement(By.id("file-upload"));
        dropPic.sendKeys(uploadPicFile.getAbsolutePath());

        Thread.sleep(2000);

        driver.findElement(By.id("file-submit")).click();

        WebElement text = driver.findElement(By.id("uploaded-files"));

        assertEquals(picName, text.getText());

        Thread.sleep(5000);
        driver.quit();

    }

}