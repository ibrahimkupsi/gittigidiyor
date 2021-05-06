package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gittigidiyor{

    WebDriver driver;
    String url = "https://www.gittigidiyor.com/";
    UrunModel urunModel;
    SepetModel sepetModel;

    By logIn = By.xpath("//*[@title='Giriş Yap']");
    By giris = By.xpath("//*[@class='sc-12t95ss-3 fDarBX']");
    By email = By.id("L-UserNameField");
    By password =By.id("L-PasswordField");
    By submit = By.id("gg-login-enter");
    By anasayfa = By.xpath("//*[@class='logo_gg imglink logo-small']");


    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\chrome\\chromedriver.exe");
        driver = new ChromeDriver(); //chrome başlatma
        urunModel = new UrunModel(driver);
        sepetModel = new SepetModel(driver);

        driver.get(url); //gittigidiyor sitesini açıyor
        driver.manage().window().maximize(); //tam ekran  modu

    }

    public void logInPage(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.gittigidiyor.com/");//url kontrol ediliyor burada
        try {
            Thread.sleep(3000);
            driver.findElement(logIn).click(); //login yapılması için gerekli buton bulunuyor
            Thread.sleep(1000);
            driver.findElement(giris).click(); //giriş butonu bulunduktan sonra tıklanıyor
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void userInformation(){
        try {
            driver.findElement(email).sendKeys("***@***.com");//kullanıcı adı textbox bulunup dolduruluyor
            driver.findElement(password).sendKeys("*******");// şifre textbox bulunup dolduruluyor
            driver.findElement(submit).click();//  submit butonuna tıklama yapılıyor
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void search(){
        urunModel.search();
    }

    public void clickPage2(){
        urunModel.clickPage2();
    }

    public void selectRandomProduct(){
        urunModel.selectRandomProduct();
    }

    public void addToBasket(){
        sepetModel.addToBasket();
    }

    public void clickToBasket(){
        sepetModel.clickToBasket();
    }

    public void product(){
        sepetModel.product();
    }

    public void deleteButton(){
        sepetModel.deleteButton();
    }
    public void closes(){
        urunModel.closes();}
    public void MAinPage(){
        try {
            Thread.sleep(1000);
            driver.findElement(anasayfa).click(); //ana sayfaya geri dönme

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
}

}
