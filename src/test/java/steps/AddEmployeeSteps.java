package steps;

import Utils.CommonMethods;
import Utils.Constants;
import Utils.ExcelReading;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {
    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        // DahsboardPage dash = new DahsboardPage();
        // WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        dash.PimOption.click();
    }

    @When("user clicks on Add employee button")
    public void user_clicks_on_add_employee_button() {
        //  DahsboardPage dash = new DahsboardPage();
        //  WebElement addEmployeeButton = driver.findElement(By.id("menu_pim_addEmployee"));
        dash.addEmployeeButton.click();
    }
    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname() {
        // AddNewEmployeePage addNewEmployeePage = new AddNewEmployeePage();
        //WebElement firstName = driver.findElement(By.id("firstName"));
        addNewEmployeePage.firstName.sendKeys("Nammar");
        //    WebElement lastName = driver.findElement(By.id("lastName"));
        addNewEmployeePage.lastName.sendKeys("MS");
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        //  AddNewEmployeePage addNewEmployeePage = new AddNewEmployeePage();
        //  WebElement saveButton = driver.findElement(By.id("btnSave"));
        addNewEmployeePage.saveButton.click();
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added succesfully");
    }

    @When("user enters {string} {string} and {string}")
    public void user_enters_and(String firstName, String middleName, String lastName) {
        //  AddNewEmployeePage addNewEmployeePage = new AddNewEmployeePage();
        // WebElement firstNameLoc = driver.findElement(By.id("firstName"));
        addNewEmployeePage.firstName.sendKeys(firstName);
        // WebElement lastNameLoc = driver.findElement(By.id("lastName"));
        addNewEmployeePage.lastName.sendKeys(lastName);
        //WebElement middleNameLoc = driver.findElement(By.id("middleName"));
        addNewEmployeePage.middleName.sendKeys(middleName);
    }

    @When("user enters direct data {string} {string} and {string}")
    public void user_enters_direct_data_and(String firstName, String middleName, String lastName) {
        //  AddNewEmployeePage addNewEmployeePage = new AddNewEmployeePage();
        // WebElement firstNameLoc = driver.findElement(By.id("firstName"));
        addNewEmployeePage.firstName.sendKeys(firstName);
        // WebElement lastNameLoc = driver.findElement(By.id("lastName"));
        addNewEmployeePage.lastName.sendKeys(lastName);
        //  WebElement middleNameLoc = driver.findElement(By.id("middleName"));
        addNewEmployeePage.middleName.sendKeys(middleName);
    }

    @When("user add multiple employees and verify they are added")
    public void user_add_multiple_employees_and_verify_they_are_added(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> employeeNames = dataTable.asMaps();
        //AddNewEmployeePage addNewEmployeePage = new AddNewEmployeePage();

        for (Map<String, String> emp : employeeNames){
            String firstNameValue = emp.get("firstName");
            String middleNameValue = emp.get("middleName");
            String lastNameValue = emp.get("lastName");

            // WebElement firstNameLoc = driver.findElement(By.id("firstName"));
            addNewEmployeePage.firstName.sendKeys(firstNameValue);
            //    WebElement lastNameLoc = driver.findElement(By.id("lastName"));
            addNewEmployeePage.lastName.sendKeys(lastNameValue);
            //WebElement middleNameLoc = driver.findElement(By.id("middleName"));
            addNewEmployeePage.middleName.sendKeys(middleNameValue);

            //  WebElement saveButton = driver.findElement(By.id("btnSave"));
            addNewEmployeePage.saveButton.click();

            //Assertions in Homework
            Thread.sleep(5000);

            //to come back again on add employee screen because hooks and background works just one time
            //  WebElement addEmployeeButton = driver.findElement(By.id("menu_pim_addEmployee"));
            //DahsboardPage dash = new DahsboardPage();
            dash.addEmployeeButton.click();
            Thread.sleep(3000);
        }

    }

    @When("user adds multiple employees from excel file using {string} sheet and verify the added employee")
    public void user_adds_multiple_employees_from_excel_file_using_sheet_and_verify_the_added_employee(String sheetName) throws InterruptedException {
        List<Map<String, String>> newEmployees = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH,sheetName);

        //  AddNewEmployeePage addNewEmployeePage = new AddNewEmployeePage();

        Iterator<Map<String, String>> itr = newEmployees.iterator();
        // it check whether we have element or not
        while (itr.hasNext()){
            // it returns the Key and value for employees
            Map<String, String> mapNewEmp = itr.next();

            //  WebElement firstNameLoc = driver.findElement(By.id("firstName"));
            addNewEmployeePage.firstName.sendKeys(mapNewEmp.get("FirstName"));
            //  WebElement lastNameLoc = driver.findElement(By.id("lastName"));
            addNewEmployeePage.lastName.sendKeys(mapNewEmp.get("LastName"));
            addNewEmployeePage.middleName.sendKeys(mapNewEmp.get("MiddleName"));

            //WebElement empId = driver.findElement(By.id("employeeId"));
            String empIdValue = addNewEmployeePage.empIdLoc.getAttribute("value");

            // WebElement photo = driver.findElement(By.id("photofile"));
            addNewEmployeePage.photograph.sendKeys(mapNewEmp.get("Photograpgh"));

            //    WebElement checkBox = driver.findElement(By.id("chkLogin"));
            if(!addNewEmployeePage.checkbox.isSelected()){
                addNewEmployeePage.checkbox.click();
            }

            //    WebElement username = driver.findElement(By.id("user_name"));
            //    WebElement password = driver.findElement(By.id("user_password"));
            //   WebElement confirmPassword = driver.findElement(By.id("re_password"));

            addNewEmployeePage.createUsername.sendKeys(mapNewEmp.get("Username"));
            addNewEmployeePage.createPassword.sendKeys(mapNewEmp.get("Password"));
            addNewEmployeePage.rePassword.sendKeys(mapNewEmp.get("Password"));
            // WebElement saveButton = driver.findElement(By.id("btnSave"));
            addNewEmployeePage.saveButton.click();

            Thread.sleep(5000);

            //Assertions in Homework
            //grab emp id while adding the employee
            //search it in the employee list
            //use for loop to compare the values
            //    DahsboardPage dash = new DahsboardPage();

            //  WebElement empList = driver.findElement(By.id("menu_pim_viewEmployeeList"));
            dash.employeeListButton.click();

            //  EmployeeListPage employeeListPage = new EmployeeListPage();
            //  WebElement empIdSearchField = driver.findElement(By.id("empsearch_id"));
            employeeListPage.idEmployeeSearch.sendKeys(empIdValue);

            //  WebElement searchButton = driver.findElement(By.id("searchBtn"));
            employeeListPage.searchButton.click();

            List<WebElement> rowData = driver.findElements(By.xpath("//table[@id='resultTable']/tbody/tr"));

            for(int i=0; i<rowData.size(); i++){
                System.out.println("I am inside my loop");
                String rowText = rowData.get(i).getText();
                System.out.println(rowText);

                String expectedData =  empIdValue + " " + mapNewEmp.get("FirstName") + " " + mapNewEmp.get("MiddleName")
                        + " " + mapNewEmp.get("LastName");
                System.out.println(expectedData);
                Assert.assertEquals(expectedData, rowText);

            }

            //to come back again on add employee screen because hooks and background works just one time
            // WebElement addEmployeeButton = driver.findElement(By.id("menu_pim_addEmployee"));
            dash.addEmployeeButton.click();
            Thread.sleep(3000);

        }


    }
}