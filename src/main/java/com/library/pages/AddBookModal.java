package com.library.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.library.AbstractPageObject;

public class AddBookModal extends AbstractPageObject {
	@FindBy(id = "tytul")
	public WebElement title;
	@FindBy(id = "saveNewBookButton")
	public WebElement saveNewBookButton;
	@FindBy(id = "addNewAuthorButton")
	public WebElement addNewAuthorButton;
	@FindBy(id = "deleteAuthorButton")
	public WebElement deleteAuthorButton;

	public AddBookModal setTitle(String title) {
		this.title.sendKeys(title);
		return this;
	}

	public AddBookModal(WebDriver driver) {
		super(driver);
	}

	public LibraryPage clickSaveNewBookButton() {
		saveNewBookButton.click();
		return PageFactory.initElements(driver, LibraryPage.class);
	}

	public AddAuthorModal clickAddNewAuthorButton() {
		addNewAuthorButton.click();
		return PageFactory.initElements(driver, AddAuthorModal.class);
	}

	public AddBookModal clickDeleteAuthorButton() {
		deleteAuthorButton.click();
		return this;
	}

	public List<WebElement> getSizeListAuthors() {
		return driver.findElements(By.id("deleteAuthorButton"));
	}

}