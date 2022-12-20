package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class ArithmeticOperationSteps {
    static int a, b, sum;

    @Given("I have two numbers {int},{int}")
    public void i_have_two_Numbers(int c, int d) {
        a = c;
        b = d;
    }

    @When("I add the numbers")
    public void i_add_The_numbers() {
        sum = a + b;
    }

    @Then("The result should be equal to {int}")
    public void assert_the_result(int result) {
        System.out.println("The sum of the two numbers is " + sum);
        Assert.assertEquals(result, sum);
    }
}
