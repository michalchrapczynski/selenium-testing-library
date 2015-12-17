package com.library;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class AbstractPageObject {
	protected WebDriver driver;

	public AbstractPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public boolean hasBook() {
		try {
			driver.findElement(By.className("ng-binding"));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean hasBookValid() {
		try {
			driver.findElement(By.className("ng-invalid"));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean hasRemoveBook() {
		try {
			driver.findElement(By.className("alert"));
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean hasFindAddedBook() {
		try {
			driver.getPageSource().contains("OnlyInThisTestThisText5");
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

}
