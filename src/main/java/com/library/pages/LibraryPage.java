package com.library.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.library.AbstractPageObject;

public class LibraryPage extends AbstractPageObject {

	AddBookModal data = new AddBookModal(driver);

	@FindBy(id = "findBookByTitleInput")
	private WebElement findBookByTitleInput;

	@FindBy(id = "findBooksInLibraryButton")
	private WebElement findBooksInLibraryButton;

	@FindBy(id = "addNewBookButton")
	private WebElement addNewBookButton;

	@FindBy(id = "deleteBookButton")
	private WebElement deleteBookButton;

	public LibraryPage(WebDriver driver) {
		super(driver);
	}

	public LibraryPage setFindBookByTitleInput(String prefix) {
		this.findBookByTitleInput.sendKeys(prefix);
		return this;
	}

	public AddBookModal clickAddNewBookButton() {
		addNewBookButton.click();
		return PageFactory.initElements(driver, AddBookModal.class);
	}

	public LibraryPage clickFindBooksInLibraryButton() {
		findBooksInLibraryButton.click();

		return this;
	}

	public LibraryPage clickDeleteBookButton() {
		deleteBookButton.click();
		return this;
	}

	public List<WebElement> getSizeListBook() {
		return driver.findElements(By.id("deleteBookButton"));
	}

	public List<WebElement> getSizeListAuthors() {
		return data.getSizeListAuthors();
	}

}
