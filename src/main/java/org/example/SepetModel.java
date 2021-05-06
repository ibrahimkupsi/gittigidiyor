package org.example;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class SepetModel {
    WebDriver driver;
    By addBasket= By.id("add-to-basket"); // ürünün sepete eklenmesi
    By clickBasket= By.xpath("//*[@class='header-cart-hidden-link']");// sepete gidiliyor
    By increase = By.xpath("//*[@value='2']");// ürün sayısı 2 ye çıkarılıyor
    By delete = By.xpath("//*[contains(@class,'btn-delete btn-update-item')]");// ürün sepetten siliniyor

    public SepetModel(WebDriver driver){

        this.driver = driver;
    }

    public void addToBasket(){
        try {
            driver.findElement(addBasket).click();
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickToBasket(){
        try {
            driver.findElement(clickBasket).click();
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    public void product(){
        try {
            driver.findElement(increase).click();
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void deleteButton(){
        try {
            driver.findElement(delete).click();
            Thread.sleep(2500);
            Assert.assertNotNull(delete);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
