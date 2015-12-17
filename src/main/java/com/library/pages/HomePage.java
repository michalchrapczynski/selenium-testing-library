package com.library.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.library.AbstractPageObject;

public class HomePage extends AbstractPageObject {
	@FindBy(linkText = "Books dialog")
	private WebElement findLibrary;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver.get("http://localhost:9000/#/main/welcome");
	}

	public LibraryPage clickFindLibrary() {
		findLibrary.click();
		return PageFactory.initElements(driver, LibraryPage.class);
	}

}
