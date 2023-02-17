import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import net.bytebuddy.asm.Advice.Enter;

public class App{
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        
        try {
            driver.get("https://es.wikipedia.org/");
            WebElement cajaBusqueda = driver.findElement(By.id("searchInput"));
            WebElement botonBusqueda = driver.findElement(By.id("searchButton"));

            cajaBusqueda.sendKeys("Boiro");
            botonBusqueda.sendKeys(Keys.ENTER);

            assertEquals("Boiro - Wikipedia, la enciclopedia libre", driver.getTitle());

            Thread.sleep(3000);

            WebElement footer = driver.findElement(By.id("footer"));
            System.out.println(footer.getAttribute("role"));

            List<WebElement> elementosDiv = driver.findElements(By.tagName("div"));
            for (WebElement webElement : elementosDiv) {
                System.out.println(webElement.getText());
            }

            for (int i = 0; i < elementosDiv.size(); i++) {
                WebElement webElement = elementosDiv.get(i);
                System.out.println(webElement.getText());
            }
            
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
        driver.quit();
    }

    @Test
    public void test_checkbox(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("src/index.html");
    }
}