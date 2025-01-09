package StepDefinition;


import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;


import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class MyStepdefs {
    static WebDriver driver;

    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    //public void setUp() {
    // System.out.println("Opening the browser");
    //System.setProperty("webdriver.chrome.driver","C:\\Users\\Vanitha R\\IdeaProjects\\POSBDD\\src\\test\\resources\\Driver\\chromedriver.exe");
    // driver = new ChromeDriver();
    //driver.manage().window().maximize();
    //driver.get("https://stage-pos.palletnow.co/");


    // }
    //@Before
    @Given("User is on login page")
    public void userIsOnLoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vanitha R\\IdeaProjects\\POSBDD\\src\\test\\resources\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.get("https://stage-pos.palletnow.co/");
        System.out.println("User is on login page");


    }
   /*@After
   public void teardown()
   {
       driver.close();
       driver.quit();
   } */


    @When("User enter username and password")
    public void userEnterUsernameAndPassword() {


        WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='Mobile Number']"));
        usernameField.sendKeys("8531821606");
        WebElement PIN = driver.findElement(By.xpath("//input[@id='outlined-adornment-password']"));
        PIN.sendKeys("1111");


    }


    @And("Clicks on login button")
    public void clicksOnLoginButton() {
        WebElement login = driver.findElement(By.xpath("//button[@class='css-xi2z24']"));
        login.click();
    }


    @Then("Clicks on location")
    public void clicksOnLocation() throws InterruptedException {


        WebElement location = driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[2]/div[2]/div[1]/div[1]/button[1]"));
        scrollUntilElementVisible(location);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", location);
        Thread.sleep(3000);
        //location.click();
    }

    public static void scrollUntilElementVisible(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(7)) // Maximum wait time
                .pollingEvery(Duration.ofSeconds(2)) // Frequency of checking
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element)); // Wait until visible


        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element); // Scroll into view
    }


    @Given("click on start session")
    public void clickOnStartSession() throws InterruptedException {
        Thread.sleep(5000);
        WebElement ter_dropdown = driver.findElement(By.xpath("//div[@class='css-n8vkcx']"));
        //WebElement ter_dropdown = driver.findElement(By.xpath("//input[@id='react-select-2-input']"));
        ter_dropdown.click();
        Thread.sleep(5000);
        WebElement TerIndex1 = driver.findElement(By.xpath("//div[@id='react-select-2-option-0']"));
        TerIndex1.click();
        WebElement startsession = driver.findElement(By.xpath("//button[normalize-space()='Start session']"));
        startsession.click();
        WebElement cash = driver.findElement(By.xpath("//input[@placeholder='Enter the amount']"));
        cash.sendKeys("1000");
        WebElement checkbox = driver.findElement(By.xpath("//input[@id='manager-login']"));
        if (!checkbox.isSelected()) {
            checkbox.click();
        }


    }


    @When("navigate to cart page")
    public void navigateToCartPage() {
        WebElement createsession = driver.findElement(By.xpath("//button[normalize-space()='Create Session']"));
        createsession.click();
        WebElement gotocart = driver.findElement(By.xpath("//button[normalize-space()='Go to Cart']"));
        gotocart.click();
    }


    @Given("click on add customer details")
    public void clickOnAddCustomerDetails() throws InterruptedException{
        WebElement cart = driver.findElement(By.xpath("//span[normalize-space()='Cart']"));
        //cart.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", cart);
        WebElement addnumber = driver.findElement(By.xpath("//input[@placeholder='Enter Mobile Number']"));
        addnumber.sendKeys("6565656565");
        WebElement entername = driver.findElement(By.xpath("//div[@class='MuiInputBase-root MuiInputBase-colorPrimary MuiInputBase-formControl css-1034lh0-MuiInputBase-root']//input[@id='bootstrap-input']"));
        entername.sendKeys("Test");
        WebElement add = driver.findElement(By.xpath("//p[normalize-space()='Add']"));
        add.click();
        Thread.sleep(5000);


    }


    @When("click on product details")
    public void clickOnProductDetails() throws InterruptedException {


        WebElement search = driver.findElement(By.xpath("//b[normalize-space()='(Atl + 6)']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", search);
        // search.click();
        WebElement quicksearch = driver.findElement(By.xpath("//div[@class='MuiBox-root css-1bq8rkm']//input[@id='search-input']"));
        quicksearch.sendKeys("standard");


        WebElement quicksearch1 = driver.findElement(By.xpath("//button[normalize-space()='See Details']"));
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", quicksearch1);
        quicksearch1.click();
        Thread.sleep(2000);


        WebElement closePopupButton = driver.findElement(By.xpath("//div[@class='MuiBackdrop-root MuiModal-backdrop css-i9fmh8-MuiBackdrop-root-MuiModal-backdrop']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closePopupButton);
        Thread.sleep(5000);
        // closePopupButton.click();
    }


    @And("add on product")
    public void addOnProduct() {
        boolean isDisplayed = driver.findElement(By.xpath("//p[normalize-space()='Products']")).isDisplayed();
        System.out.println("Element visible: " + isDisplayed);
        //WebDriverWait wait7 = new WebDriverWait(driver, Duration.ofSeconds(10)); // Ensure wait is properly initialized
        WebElement product = driver.findElement(By.xpath("//p[normalize-space()='Products']"));
        product.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product);
        WebElement productsearch = driver.findElement(By.xpath("//div[@class='wrapper-input-box-modal']//input[@id='search-input']"));
        productsearch.sendKeys("standard");
        WebElement addproduct = driver.findElement(By.xpath("//div[@class='MuiBox-root css-0']//div[4]//div[3]//button[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addproduct);


    }


    @Then("Enter the product details")
    public void enterTheProductDetails() {
        WebDriverWait wait12 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement radioButton = wait12.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='mrp-1']")));
        radioButton.click();
        WebDriverWait wait13 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement select1 = wait13.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".mrp-btn")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", select1);


    }


    @Given("click on total")
    public void clickOnTotal() throws InterruptedException {
        // Printer Configuration
        WebDriverWait wait18 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement account = wait18.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='name-avatar-box']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", account);
        WebDriverWait wait19 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement settings = wait19.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[normalize-space()='Settings']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", settings);
        WebDriverWait wait20 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement peripherals = wait20.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[normalize-space()='PERIPHERALS']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", peripherals);
        WebDriverWait wait21 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement thermal_printer = wait21.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Thermal Printer (Posiflex)')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", thermal_printer);
        WebDriverWait wait22 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement connect_printer = wait22.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Connect']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", connect_printer);

//        WebDriverWait wait23 = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement dropdown_printer = wait23.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id, 'react-select')]")));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown_printer);
//        Thread.sleep(3000);
//        WebDriverWait wait28 = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement option = wait28.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'react-select__option') and text()='USB port']")));
//        option.click();
//        Thread.sleep(5000);

        /*

        WebDriverWait wait23 = new WebDriverWait(driver, Duration.ofSeconds(10));

// Wait until the input field is clickable and then click it
        WebElement dropdown_printer = wait23.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id, 'react-select')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown_printer);

// Wait for a moment to ensure the dropdown options are rendered (adjust timing if needed)
        Thread.sleep(3000);  // Optional: You might want to wait a little longer if needed

// Wait for the dropdown options to be visible (improved condition)
        WebDriverWait wait28 = new WebDriverWait(driver, Duration.ofSeconds(10));

// Wait for the dropdown option with the text "USB port" to be clickable
        WebElement option = wait28.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'react-select__option') and text()='USB port']")));

// Ensure the option is clickable before interacting with it
        wait28.until(ExpectedConditions.elementToBeClickable(option));

// Click the option
        option.click();

// Optional: Add a longer sleep to observe the result
        Thread.sleep(5000);
        */

        /*
        WebDriverWait wait27 = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            // Wait for the input element to be clickable and click it
            WebElement dropdown_printer = wait27.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@id, 'react-select')]")));
            dropdown_printer.click();  // Open the dropdown

            // Wait for the option to be visible and clickable
            WebElement option = wait27.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'react-select__option') and contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'usb port')]")));
            wait27.until(ExpectedConditions.elementToBeClickable(option));  // Ensure the option is clickable

            // Use JavaScriptExecutor to click the option
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", option);  // Click the option using JavaScript

            Thread.sleep(5000); // Optional: To allow time to observe the action

        } catch (TimeoutException e) {
            System.out.println("Element not clickable after waiting. Debugging...");

            // Debug: Check if the element exists
            WebElement dropdown_printer = driver.findElement(By.xpath("//input[contains(@id, 'react-select')]"));
            System.out.println("Is Displayed: " + dropdown_printer.isDisplayed());
            System.out.println("Is Enabled: " + dropdown_printer.isEnabled());

            // Scroll to the element and retry
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown_printer);

            // Wait and click the element again after scrolling
            dropdown_printer = wait27.until(ExpectedConditions.elementToBeClickable(dropdown_printer));
            dropdown_printer.click();

            // Wait for the option to appear and select it using JavaScript
            WebElement option = wait27.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'react-select__option') and contains(translate(text(), 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), 'usb port')]")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);  // Use JavaScript to click the option

            Thread.sleep(5000); // Optional: To allow time to observe the action
        }

*/

        //Select dropdown = new Select(dropdown_printer);
        //dropdown.selectByVisibleText("USB port");
        WebDriverWait wait24 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement select = wait24.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='SELECT']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", select);
        Thread.sleep(3000);
        WebDriverWait wait25 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement navigate_cart = wait24.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Cart']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", navigate_cart);
        Thread.sleep(3000);
        //WebDriverWait wait26 = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement skip_customer = wait26.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[normalize-space()='Skip']")));
        //((JavascriptExecutor) driver).executeScript("arguments[0].click();", skip_customer);

        WebDriverWait wait14 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement total = wait14.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='confirm-wrapper-btn']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", total);
        Thread.sleep(5000);

    }

    @When("enter total amount")
    public void enterTotalAmount() {
        WebElement enteramount = driver.findElement(By.xpath("//input[@class='enter-amount-input-tag-keyboard']"));
        enteramount.sendKeys("1000");

    }

    @And("click on pay")
    public void clickOnPay() {
        WebDriverWait wait15 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement pay = wait15.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[normalize-space()='(F2)']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", pay);

    }

    @Then("click on continue button")
    public void clickOnContinueButton() {
        WebDriverWait wait16 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement continue1 = wait16.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='CONTINUE']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", continue1);

    }
}






