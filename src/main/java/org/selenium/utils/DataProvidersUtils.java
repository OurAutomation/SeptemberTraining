package org.selenium.utils;

import org.testng.annotations.DataProvider;

public class DataProvidersUtils {
    @DataProvider
    public Object[][] validUsernames() {
        String[][] validUsernames = new String[3][2];
        validUsernames[0][0] = TestDataUtils.getTestData("performance.username");
        validUsernames[0][1] = TestDataUtils.getTestData("password");
        validUsernames[1][0] = TestDataUtils.getTestData("problem.username");
        validUsernames[1][1] = TestDataUtils.getTestData("password");
        validUsernames[2][0] = TestDataUtils.getTestData("valid.username");
        validUsernames[2][1] = TestDataUtils.getTestData("password");
        return validUsernames;
    }

    @DataProvider
    public Object[][] inValidUsernamesOrPasswords() {
        String[][] invalidData = new String[7][3];
        invalidData[0][0] = TestDataUtils.getTestData("performance.username");
        invalidData[0][1] = TestDataUtils.getTestData("invalid.password");
        invalidData[0][2] = TestDataUtils.getTestData("invalidCredentials.errorMessage");
        invalidData[1][0] = TestDataUtils.getTestData("problem.username");
        invalidData[1][1] = "";
        invalidData[1][2] = TestDataUtils.getTestData("passwordRequired.errorMessage");
        invalidData[2][0] = TestDataUtils.getTestData("valid.username");
        invalidData[2][1] = TestDataUtils.getTestData("invalid.password");
        invalidData[2][2] = TestDataUtils.getTestData("invalidCredentials.errorMessage");
        invalidData[3][0] = TestDataUtils.getTestData("invalid.username");
        invalidData[3][1] = TestDataUtils.getTestData("invalid.password");
        invalidData[3][2] = TestDataUtils.getTestData("invalidCredentials.errorMessage");
        invalidData[4][0] = TestDataUtils.getTestData("invalid.password");
        invalidData[4][1] = TestDataUtils.getTestData("password");
        invalidData[4][2] = TestDataUtils.getTestData("invalidCredentials.errorMessage");
        invalidData[5][0] = "";
        invalidData[5][1] = TestDataUtils.getTestData("password");
        invalidData[5][2] = TestDataUtils.getTestData("usernameRequired.errorMessage");
        invalidData[6][0] = TestDataUtils.getTestData("locked.username");
        invalidData[6][1] = TestDataUtils.getTestData("password");
        invalidData[6][2] = TestDataUtils.getTestData("userLockedOut.errorMessage");
        return invalidData;
    }
}
