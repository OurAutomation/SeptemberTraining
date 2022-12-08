package WithPageObjectModel.application;

import org.openqa.selenium.By;
import org.selenium.utils.Base;
import org.selenium.utils.EnvironmentUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Application_Sanity extends Base {

    @Test(priority = 0)
    public void validateTitleOfThePage() {
        String title = driver.getTitle();
        System.out.println("The title is :: " + title);
        Assert.assertEquals(title, EnvironmentUtils.getEnvironmentData("title"), "The title is not matching");
    }

    @Test(priority = 1)
    public void validatePageURL() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println("The current URL is :: " + currentUrl);
        Assert.assertEquals(currentUrl, EnvironmentUtils.getEnvironmentData("url"), "The URL is not matching. May be it is loading a phishing page");
    }

    @Test(priority = 2)
    public void validateTheLogoOfThePage() {
        String logoURL = driver.findElement(By.className("login_logo")).getCssValue("background");
        System.out.println("Logo url is :: " + logoURL);
        Assert.assertEquals(logoURL,EnvironmentUtils.getEnvironmentData("logo.url"),"The logo url is not matching");
    }
}
