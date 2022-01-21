package steps;

import Utils.CommonMethods;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EmployeeSearchSteps extends CommonMethods {
//we don't need login steps if we have already a login steps in a different .feature file

    @When("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {
        // DahsboardPage dash = new DahsboardPage();

        //WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        dash.PimOption.click();

        //   WebElement employeeListOption = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        dash.employeeListButton.click();
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        //  EmployeeListPage employeeListPage = new EmployeeListPage();
        // WebElement searchByID = driver.findElement(By.id("empsearch_id"));
        employeeListPage.idEmployeeSearch.sendKeys("23638000");
    }

    @When("user clicks on search button")
    public void user_clicks_on_search_button() {
        //   EmployeeListPage employeeListPage = new EmployeeListPage();
        //   WebElement searchButton = driver.findElement(By.id("searchBtn"));
        employeeListPage.searchButton.click();
    }

    @Then("user see employee information is displayed")
    public void user_see_employee_information_is_displayed() {
        System.out.println("Information is displayed on page");
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() {
        //   EmployeeListPage employeeListPage = new EmployeeListPage();
        //WebElement name = driver.findElement(By.id("empsearch_employee_name_empName"));
        employeeListPage.empSearchStepByName.sendKeys("XYZT");
    }
}
