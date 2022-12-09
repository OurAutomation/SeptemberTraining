package org.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.SeleniumUtils;

public class SortPage extends SeleniumUtils {
    public SortPage(WebDriver driver) {
        super(driver);
    }

    public void selectSort(String sortName) {
        select(ObjectRepositoryUtils.getLocator("dashboardPage.sortDropdown"), sortName);
    }

    public String getSelectedSortOption() {
        return getSelectedOption(ObjectRepositoryUtils.getLocator("dashboardPage.sortDropdown"));
    }
}
