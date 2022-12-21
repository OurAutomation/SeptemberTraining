package org.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.SeleniumUtils;

import java.util.List;

public class SortPage extends SeleniumUtils {

    public void selectSort(String sortName) {
        select(ObjectRepositoryUtils.getLocator("dashboardPage.sortDropdown"), sortName);
    }

    public String getSelectedSortOption() {
        return getSelectedOption(ObjectRepositoryUtils.getLocator("dashboardPage.sortDropdown"));
    }

    public List<String> getNumberOfSortsAvailable() {
        Select sortDropdown = new Select(findElement(ObjectRepositoryUtils.getLocator("dashboardPage.sortDropdown")));
        return getText(sortDropdown.getOptions());
    }

    public void selectTheGivenSortByVisibleText(String sortType) {
        select(ObjectRepositoryUtils.getLocator("dashboardPage.sortDropdown"), sortType);
        hardWait(2);
    }
}
