package ge.automation.stepDefinitions;

import ge.automation.hooks.Hooks;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import io.cucumber.java.After;

import java.time.Duration;

public class SauceSteps {

    @Before
    public void setup() {
        // აქ პირდაპირ გამოვიძახებთ Hooks-ის setup() მეთოდს
        Hooks.setup();

    }

    @After
    public void tearDown() {
        // აქ გამოვიძახებთ Hooks-ის tearDown() მეთოდს
        Hooks.tearDown();

    }

    @Given("the browser is launched and {string} login page is opened")
    public void theBrowserIsLaunchedAndLoginPageIsOpened(String baseUrl) {
        Hooks.driver.get(baseUrl);
    }


    @When("the user enters {string} in the search field")
    public void theUserEntersInTheSearchField(String field) {
        Hooks.driver.findElement(By.xpath("//input[@class='form-control form-search-control']")).sendKeys(field);

    }

    @And("the user clicks the search button")
    public void theUserClicksTheSearchButton() {
        WebElement SearchButtonElement = Hooks.driver.findElement(By.id("searchButton"));
        SearchButtonElement.click();
    }

    @Then("the user should see search results containing {string}")
    public void theUserShouldSeeSearchResultsContaining(String invalidProduct) {
        boolean ifResultPresent = !Hooks.driver.findElements(By.xpath("(//img[@alt='Gant - Terry Cloth Piqué... 2'])[1]")).isEmpty();
        if (ifResultPresent) {
            System.out.println("Search results found");
        } else {
            System.out.println("No search results found");

        }
    }

    @Then("the user should see a message indicating {string}")
    public void theUserShouldSeeAMessageIndicating(String alertMessage) {
        WebElement messageElement = Hooks.driver.findElement(By.xpath("//strong[contains(text(),'პროდუქტი არ არის.')]"));

        String actualMessage = messageElement.getText();

        // Assert-ის გამოყენებით ვამოწმებ ტექსტი ემთხვევა თუ არა მოსალოდნელ მნიშვნელობას
        Assert.assertEquals(actualMessage, alertMessage, "The alert message doesn't match the expected text");

        // წარმატებული ტესტის შემთხვევაში კონსოლში ბეჭდავს
        System.out.println("Test Passed");


    }


    @Then("the user adds the {string} to the wishlist")
    public void theUserAddsTheToTheWishlist(String productName) throws InterruptedException {
        WebElement wishlistButton = Hooks.driver.findElement(By.xpath("(//a[@class='btn-iqitwishlist-add js-iqitwishlist-add'])[1]"));
        wishlistButton.click();
        Thread.sleep(10000);

    }

    @Then("the user should see a login prompt with {string} button displayed")
    public void theUserShouldSeeALoginPromptMessage(@org.jetbrains.annotations.NotNull String buttonText) {

        WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        WebElement googleAuthButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='newauth-social-button-text text-nowrap' and text()='Google ავტორიზაცია']"))
        );

        // ვამოწმებ რომ ღილაკი ხილვადია
        Assert.assertTrue(googleAuthButton.isDisplayed(), "Test Failed: Google Authorization button is not displayed.");

        // ვამოწმებ რომ ტექსტი ემთხვევა
        Assert.assertEquals(googleAuthButton.getText().trim(), buttonText.trim(), "Test Failed: Button text does not match.");


    }


    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String auto) {

        WebElement button = Hooks.driver.findElement(By.xpath("//div[@id='header-sign-in']"));

        button.click();
    }

    @And("the user enters {string} in the email field and {string} in the password field")
    public void theUserEntersInTheEmailFieldAndInThePasswordField(String userEmail, String userPassword) {

        WebElement emailField = Hooks.driver.findElement(By.xpath("(//input[@placeholder='ელ-ფოსტა'])[1]"));
        emailField.sendKeys(userEmail);

        WebElement passwordField = Hooks.driver.findElement(By.xpath("(//input[@placeholder='პაროლი'])[1]"));
        passwordField.sendKeys(userPassword);
    }


    @And("clicks the Authorization button")
    public void clicksTheAuthorizationButton() {
        WebElement button = Hooks.driver.findElement(By.cssSelector("button[data-link-action='sign-in']"));
        button.sendKeys(Keys.ENTER);
    }

    @And("user adds the {string} to the wishlist")
    public void userAddsTheToTheWishlist(String addWishlist) {
        WebElement wishlistButton = Hooks.driver.findElement(By.xpath("//*[@id=\"custuomer-auth-dropdown\"]/div/div[3]/div[4]/form/button"));
        wishlistButton.click();

    }


    @Then("Quick see the {string} product")
    public void theUserClicksOnTheProduct(String clickShirt) throws InterruptedException {

        WebElement quickSeeProduct = Hooks.driver.findElement(By.xpath("(//a[contains(@class,'js-quick-view-iqit')])[1]"));
        quickSeeProduct.click();
        Thread.sleep(10000);

    }

}