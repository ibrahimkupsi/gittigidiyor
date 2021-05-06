package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;


import java.util.List;
import java.util.Random;


public class UrunModel {
    WebDriver driver;
    By searchWord = By.xpath("//*[@class='sc-4995aq-0 sc-14oyvky-0 itMXHg']");// kelime arama satırı bulunması
    By down = By.linkText("2");// 2. sayfada açılması
    By products= By.xpath("//*[@class='catalog-view clearfix products-container']/li/a");
    By close = By.xpath("//*[contains(@class,'tyj39b-3')]");

    public UrunModel(WebDriver driver){

        this.driver = driver;
    }
    public void closes(){

        try{
            driver.findElement(close).click();
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

    public void search(){
        driver.findElement(searchWord).sendKeys("bilgisayar");
        driver.findElement(searchWord).sendKeys(Keys.ENTER); //enter tuşu ile arama yapma
        //driver.findElement(find).click(); //bul adlı butona basarak arama yapma
    }

    public void clickPage2(){
        try {
            driver.findElement(down).click();
            Thread.sleep(2500);
            Assert.assertEquals(driver.getCurrentUrl(),"https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2"); //ikinci sayfa kontrolü 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    List<WebElement> result;
    public void selectRandomProduct(){
        try {
            result = driver.findElements(products); //s eki kullandık tüm ürünleri kapsadı bu ürünleri result listesine attı
            Thread.sleep(1500);
            Random r = new Random();
            int linkNo= r.nextInt(result.size());
            result.get(linkNo).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
