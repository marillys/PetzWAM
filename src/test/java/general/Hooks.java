package general;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks extends Base{
    private Base base;//objeto local que comunica com a classe estendida

    //construtor para a classe Java
    public Hooks(WebDriver driver,Base base) {
        super(base.driver);
        this.base = base;
    }

    //Before
    @Before
    public void setup()
    {
        //Onde está o driver
        System.setProperty("webdriver.chrome.driver","drivers/chrome/89/chromedriver.exe");

        //instanciar o driver
        base.driver = new ChromeDriver();

        //Maximizar a tela e definir uma espera dos elementos
        base.driver.manage().window().maximize();
        base.driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
    }

    @After
    public void tearDown()
    {
        //destruiu o selenium
        base.driver.quit();
    }
}
