package dev.selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.WebDriverListener;
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
        WebElement outClick = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[2]/div/div/div/div/section/div[2]/div[1]/div/ul/li[1]/div/span"));

        samsung.click();

        Thread.sleep(3000);

        muyBueno.click();

        Thread.sleep(3000);

        precioMin.sendKeys("1000");

        Thread.sleep(1000);

        outClick.click();

        Thread.sleep(3000);

    }


    @Test
    public void CPF5() throws Exception{

        WebElement cookies = driver.findElement(By.xpath("// button [@type = \"button\" ]"));
        cookies.click();

        Thread.sleep(2000);

        WebElement allEle = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/header/div[2]/button"));
        allEle.click();

        Thread.sleep(2000);

        Actions accion = new Actions(driver);
        WebElement ipad = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div/div/section/nav/div[1]/a[4]"));

        accion.moveToElement(ipad).perform();

        Thread.sleep(2000);

        WebElement moreIpad = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div/div/aside/div/div[1]/div/div[1]/a"));

        accion.moveToElement(moreIpad);

        Thread.sleep(2000);

        moreIpad.click();

        Thread.sleep(2000);

        WebElement allEle2 = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[1]/header/div[2]/button"));

        allEle2.click();

        Thread.sleep(2000);

        WebElement sell = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[2]/div[1]/div/div/section/div/a[1]"));

        sell.click();

        Thread.sleep(2000);

        WebElement ipadSell = driver.findElement(By.xpath("//*[@id=\"__layout\"]/div/div[3]/div/div/div[4]/div/div/div/div/nav/ul/li[3]"));

        ipadSell.click();

        Thread.sleep(2000);

        WebElement brandDrop = driver.findElement(By.xpath("//*[@id=\"buybackQuestionsForm\"]/div/div/button"));
        WebElement brandElement = driver.findElement(By.id("brand"));
        Select brand = new Select(brandElement);

        brandDrop.click();
        brand.selectByIndex(1);

        Thread.sleep(2000);
        
        WebElement modelDrop = driver.findElement(By.xpath("//*[@id=\"buybackQuestionsForm\"]/div[2]/div/button"));
        WebElement modelElement = driver.findElement(By.id("model_family"));
        Select model = new Select(modelElement);

        modelDrop.click();
        model.selectByIndex(14);

        Thread.sleep(2000);

        WebElement model2Drop = driver.findElement(By.xpath("//*[@id=\"buybackQuestionsForm\"]/div[3]/div[2]/button"));
        WebElement model2Element = driver.findElement(By.id("model"));
        Select model2 = new Select(model2Element);

        model2Drop.click();
        model2.selectByIndex(1);

        Thread.sleep(2000);

        WebElement capacityDrop = driver.findElement(By.xpath("//*[@id=\"buybackQuestionsForm\"]/div[4]/div/button"));
        WebElement capacityElement = driver.findElement(By.id("storage"));
        Select capacity = new Select(capacityElement);

        capacityDrop.click();
        capacity.selectByIndex(1);

        Thread.sleep(2000);

        WebElement next = driver.findElement(By.xpath("//*[@id=\"buybackQuestionsForm\"]/div[5]/button"));
        next.click();

        Thread.sleep(2000);

        WebElement good = driver.findElement(By.xpath("//*[@id=\"buybackQuestionsForm\"]/div[1]/div[2]/div[2]/div/label"));
        good.click();

        Thread.sleep(2000);

        WebElement next2 = driver.findElement(By.xpath("//*[@id=\"buybackQuestionsForm\"]/div[2]/button"));
        next2.click();
        Thread.sleep(2000);

        WebElement good2 = driver.findElement(By.xpath("//*[@id=\"buybackQuestionsForm\"]/div[1]/div/div[2]/div/label"));

        good2.click();

        Thread.sleep(2000);

        WebElement next3 = driver.findElement(By.xpath("//*[@id=\"buybackQuestionsForm\"]/div[2]/button"));

        next3.click();

        Thread.sleep(2000);

        WebElement yes = driver.findElement(By.xpath("//*[@id=\"buybackQuestionsForm\"]/div[1]/div/div[1]/div/label"));

        Thread.sleep(2000);

        WebElement show = driver.findElement(By.xpath("//*[@id=\"buybackQuestionsForm\"]/div[2]/button"));

        show.click();

        Thread.sleep(4000);

        WebElement acept = driver.findElement(By.xpath("//*[@id=\"buybackQuestionsForm\"]/div[2]/button"));

        acept.click();

        Thread.sleep(2000);

        driver.navigate().back();

        Thread.sleep(4000);

        driver.navigate().back();

        Thread.sleep(2000);


    }

}