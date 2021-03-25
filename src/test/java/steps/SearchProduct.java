package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import general.Base;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.Home;
import pages.List;
import pages.Product;

public class SearchProduct extends Base {

    private Base base;
    private Home home;
    private List list;
    private Product productClass;

    public SearchProduct(WebDriver driver, Base base) {
        super(driver);
        this.base = base;
    }

    @Given("^I access Petz homepage$")
    public void iAccessPetzHomepage() {
        base.driver.get("https://www.petz.com.br/");
    }

    @When("^I search \"([^\"]*)\"$")
    public void iSearch(String product) {
        home.searchWithEnter(product);
    }

    @Then("^I see a list of product \"([^\"]*)\"$")
    public void iSeeAListOfProduct(String product){
        //Validar o nome da guia
        Assert.assertEquals(product +" - Produtos pet em promoção | Petz", list.readTitleTab());

        //Validar o text no resultado Para
        Assert.assertEquals("Resultados para \""+product +"\"", list.readResultBy());
    }

    @And("^I click in product \"([^\"]*)\"$")
    public void iClickInProduct(String product){
        list.clickAtDesiredProduct(product);
    }

    @Then("^show the title \"([^\"]*)\" and price \"([^\"]*)\"$")
    public void showTheTitleAndPrice(String product, String price){
        //Validar o nome da guia
        Assert.assertEquals(product +" - Produtos pet em promoção | Petz", productClass.readTitleTab());
        Assert.assertEquals(product,productClass.readProductTitle());

        //Validar o preço
        Assert.assertEquals(price,productClass.readPriceCurrent());
    }
}
