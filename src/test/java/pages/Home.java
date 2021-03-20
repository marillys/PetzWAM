package pages;

import general.Base;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends Base {

    //1 MapeandoElementos
    @FindBy(id = "search")
    private WebElement txtInputSearch;

    @FindBy(css =  "button.button-search")
    private WebElement btnSearch;

    //2 Construtor
    public Home(WebDriver driver) {
        super(driver);
    }

    //3 Ações do elemento

    public void search(String product)
    {
        //clicar, limpar e preenche caixa de pesquisa
        txtInputSearch.click();
        txtInputSearch.clear();
        txtInputSearch.sendKeys(product);
    }

    public void searchWithMagnifierButton(String product)
    {
        search(product);
        btnSearch.click();//clicar na lupa
    }

    public void searchWithEnter(String product)
    {
        search(product);
        txtInputSearch.sendKeys(Keys.ENTER);
    }
}
