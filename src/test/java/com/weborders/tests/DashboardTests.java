package com.weborders.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.weborders.common.Driver;
import com.weborders.common.TestBase;
import com.weborders.pages.DashboardPage;
import com.weborders.pages.LoginPage;

public class DashboardTests extends TestBase {
	@Test
	public void verifyUsersNameOnDashboardMatches() {
		new LoginPage().login("Tester", "test");
		String usersNameOnDashboard = new DashboardPage().getUsersNameFromDashboard();
		Assert.assertTrue(usersNameOnDashboard.contains("Tester"));
	}
	
	@Test
	public void verifyUserCanLogout() {
		LoginPage loginPage = new LoginPage();
		loginPage.login("Tester", "test");
		new DashboardPage().logout();
		boolean isLoginButtonDisplayed = loginPage.isLoginButtonDisplayed();
		Assert.assertTrue(isLoginButtonDisplayed);
	}
}