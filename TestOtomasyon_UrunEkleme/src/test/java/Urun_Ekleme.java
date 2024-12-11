import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import java.time.Duration;


public class Urun_Ekleme {
    @Test
    public void UrunEkle() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://qatestcase.myideasoft.com/");// anasayfa açılır
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#header > div > div > div > div.col-12.col-md.col-xl-5.order-2 > div > form > input")).click();// search input tıklanır
        Thread.sleep(2000);
        driver.findElement(By.name("q")).sendKeys("ürün");// ürün yazılır
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#header > div > div > div > div.col-12.col-md.col-xl-5.order-2 > div > form > button > svg")).click();// arama yapılır
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#results-page > div.showcase-container > div > div:nth-child(1) > div > div.showcase-image-container > div.showcase-image.showcase-image-vertical > a > img")).click();// ürün detay sayfasına gidilir
        Thread.sleep(2000);
        driver.findElement(By.id("qty-input")).click(); // ürün adet tıklanır
        Thread.sleep(2000);
        driver.findElement(By.id("qty-input")).sendKeys("5");// 5 adet ürün seçilir
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#product-detail-container > div.product-area-top > div > div:nth-child(2) > div > div.product-cart-buttons > div.product-buttons-wrapper > div > div > a > span")).click(); // sepete eklenir
        Thread.sleep(2000);
        String sepetmesaj ="SEPETİNİZE EKLENMİŞTİR";// sepetinize eklenmiştir text kontrolü
        String mesaj=driver.findElement(By.className("shopping-information-cart-inside")).getText();
        Assert.assertEquals(mesaj,sepetmesaj,"Sepetinize Eklenmemiştir");
        driver.findElement((By.cssSelector("#header > div > div > div > div.col-auto.col-xl-5.order-1.order-md-3 > div > div.cart-menu > a > span"))).click();// sepet sayfasına gidilir
        Thread.sleep(2000);
        String element ="5";// sepet içeriğinde 5 adet olduğu kontrol edilir
        String count=driver.findElement(By.className("form-control")).getAttribute("value");
        Assert.assertEquals(count,element,"Yanlış adet");
    }
}
// pom.xml sayfasına https://mvnrepository.com/ dependenciesler eklendi.