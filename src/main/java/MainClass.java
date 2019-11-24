import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        System.setProperty(
                "webdriver.chrome.driver",
                "C:/testing/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://selenium.dev/");
        //проверим поиск
        WebElement queryInput = driver.findElement(By.name("search"));
        queryInput.sendKeys("Downloads");
        queryInput.sendKeys(Keys.RETURN);
        // получим тайтл страницы
        System.out.println("Page title is: " + driver.getTitle());
        //верненмся на предыдущую страницу
        driver.navigate().back();
        //найдем кнопку перехода на страницу загрузок и кликнем по ней
        WebElement downloadButton = driver.findElement(By.xpath("/html/body/section[2]/div/div[1]/div[2]/a/div"));
        downloadButton.click();
        // найдем URL Selenium IDE для Хрома
        WebElement downloadBlock = driver.findElement(By.linkText("for Chrome"));
        System.out.println(downloadBlock.getAttribute("href"));
        //измени размер окна и обновим страницу
        driver.manage().window().setSize(new Dimension(1024, 768));
        driver.navigate().refresh();

        /* проверим, что выдаст findElement, если ничего не найдет */
        try {
            WebElement checkMethod00 = driver.findElement(By.linkText("for Chrome1"));
            System.out.println(checkMethod00);
        }
        catch (Exception e){
            System.out.println("Метод findElement возвращает ошибку, т.к. ничего не нашел");
        }

        /* теперь проверим findElements */
        List<WebElement> checkMethod01 = driver.findElements(By.linkText("for Chrome1"));
        System.out.println(checkMethod01 + " - findElements возвращает пустой список");

        /* проверим, что будет выведено в консоли, если метод findElement найдет более одного элемента;
        * скажем ему найти все ссылки на странице*/
        WebElement multipleElements = driver.findElement(By.tagName("a"));
        System.out.println(multipleElements.getAttribute("href") + " - получаем перввый найденный элемент");

        driver.quit();
    }
}

