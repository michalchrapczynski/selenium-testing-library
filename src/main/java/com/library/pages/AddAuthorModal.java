package com.library.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.library.AbstractPageObject;

public class AddAuthorModal extends AbstractPageObject {
	@FindBy(id = "authorFirstName")
	public WebElement firstName;
	@FindBy(id = "authorLastName")
	public WebElement lastName;
	@FindBy(id = "saveNewAuthorButton")
	public WebElement saveNewAuthorButton;

	public AddAuthorModal setFirstName(String firstName) {
		this.firstName.sendKeys(firstName);
		return this;
	}

	public AddAuthorModal setLastName(String lastName) {
		this.lastName.sendKeys(lastName);
		return this;
	}

	public AddAuthorModal(WebDriver driver) {
		super(driver);
	}

	public AddBookModal clickSaveNewAuthorButton() {
		saveNewAuthorButton.click();
		return PageFactory.initElements(driver, AddBookModal.class);
	}

}