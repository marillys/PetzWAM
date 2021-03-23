package pages;

import general.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class List extends Base {
    //1- Mapeamentos

    //texto do "Resultado Para"
    @FindBy(css= "h1.h2Categoria.nomeCategoria")
    private WebElement lblResultBy;

    //2- Construtor
    public List(WebDriver driver) {
        super(driver);
    }

    //-------------- 3- Métodos e funções baseados no mapeamento

    //Lê o título da guia e devolve o texto encontrado
    public String readTitleTab()
    {
        return driver.getTitle();
    }
    //Lê a frase "Resultado para "Produto"
    public String readResultBy()
    {
        return lblResultBy.getText();
    }

    //Clique no produto desejado
    public void clickAtDesiredProduct(String product)
    {
        //Aquário Boyu Curvo 150 472 Litros Preto Champagne
        driver.findElement(By.xpath("//h3[contains(text(),'"+product+"')]")).click();
    }
}
