package library;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;

import com.library.AbstractSelenium;
import com.library.pages.LibraryPage;

public class NewBookFormValidationSeleniumTest extends AbstractSelenium {

	private LibraryPage openLibrary;

	@Override
	@Before
	public void setUp() {
		super.setUp();
		openLibrary = openLibrary().clickFindLibrary();
	}

	@Test
	public void shouldCheckAddBookToList() {
		openLibrary.clickFindBooksInLibraryButton();

		List<WebElement> listElementBeforeAction = openLibrary.getSizeListBook();
		int sizeListElementBeforeAction = listElementBeforeAction.size();

		openLibrary.clickAddNewBookButton().clickAddNewAuthorButton().setFirstName("XXXXX").setLastName("YYYYY")
				.clickSaveNewAuthorButton().setTitle("ZZZZZ").clickSaveNewBookButton().clickFindBooksInLibraryButton();

		List<WebElement> listElementAfterAction = openLibrary.getSizeListBook();
		int sizeListElementAfterAction = listElementAfterAction.size();

		Assert.assertEquals(sizeListElementBeforeAction + 1, sizeListElementAfterAction);
	}

	// Aplikacja startuje z bazą zawiarającą ksiąki
	@Test
	public void shouldCheckbookInLibrary() {
		openLibrary.clickFindBooksInLibraryButton();
		assertTrue(openLibrary.hasBook());
	}

	@Test
	public void shouldCheckIfAuthorFirstNameIsRequired() {
		openLibrary.clickAddNewBookButton().clickAddNewAuthorButton().setLastName("YYYYY").clickSaveNewAuthorButton()
				.setTitle("ZZZZZ").clickSaveNewBookButton().clickFindBooksInLibraryButton();

		assertTrue(openLibrary.hasBookValid());
	}

	@Test
	public void shouldCheckIfAuthorLastNameIsRequired() {
		openLibrary.clickAddNewBookButton().clickAddNewAuthorButton().setFirstName("XXXXX").clickSaveNewAuthorButton()
				.setTitle("ZZZZZ").clickSaveNewBookButton().clickFindBooksInLibraryButton();

		assertTrue(openLibrary.hasBookValid());
	}

	@Test
	public void shouldCheckIfTitleIsRequired() {
		openLibrary.clickAddNewBookButton().clickAddNewAuthorButton().setFirstName("XXXXX").setLastName("YYYYY")
				.clickSaveNewAuthorButton().clickSaveNewBookButton().clickFindBooksInLibraryButton();

		assertTrue(openLibrary.hasBookValid());
	}

	@Test
	public void shouldCheckIfAuthorIsRequired() {
		openLibrary.clickAddNewBookButton().setTitle("ZZZZZ").clickSaveNewBookButton();
		List<WebElement> listElementAfterAction = openLibrary.getSizeListAuthors();
		int sizeListElementAfterAction = listElementAfterAction.size();

		Assert.assertEquals(0, sizeListElementAfterAction);

	}

	@Test
	public void shouldCheckAddAuthor() {
		openLibrary.clickAddNewBookButton().clickAddNewAuthorButton().setFirstName("XXXXX").setLastName("YYYYY")
				.clickSaveNewAuthorButton().setTitle("ZZZZZ");
		List<WebElement> listElementAfterAction = openLibrary.getSizeListAuthors();
		int sizeListElementAfterAction = listElementAfterAction.size();

		Assert.assertEquals(1, sizeListElementAfterAction);
	}

	@Test
	public void shouldCheckDeleteAddedAuthor() {
		openLibrary.clickAddNewBookButton().clickAddNewAuthorButton().setFirstName("XXXXX").setLastName("YYYYY")
				.clickSaveNewAuthorButton().clickAddNewAuthorButton().setFirstName("AAAAA").setLastName("BBBBB")
				.clickSaveNewAuthorButton().clickDeleteAuthorButton();

		List<WebElement> listElementAfterAction = openLibrary.getSizeListAuthors();
		int sizeListElementAfterAction = listElementAfterAction.size();

		Assert.assertEquals(1, sizeListElementAfterAction);

	}

	@Test
	public void shouldCheckDeleteBook() {
		openLibrary.clickFindBooksInLibraryButton();

		List<WebElement> listElementBeforeAction = openLibrary.getSizeListBook();
		int sizeListElementBeforeAction = listElementBeforeAction.size();

		openLibrary.clickDeleteBookButton();

		openLibrary.clickFindBooksInLibraryButton();

		List<WebElement> listElementAfterAction = openLibrary.getSizeListBook();
		int sizeListElementAfterAction = listElementAfterAction.size();

		assertTrue(openLibrary.hasRemoveBook());
		Assert.assertEquals(sizeListElementBeforeAction, sizeListElementAfterAction + 1);

	}

	@Test
	public void shouldFindAddedBookInLibrary() {

		openLibrary.clickAddNewBookButton().clickAddNewAuthorButton().setFirstName("OnlyInThisTestThisText1")
				.setLastName("OnlyInThisTestThisText2").clickSaveNewAuthorButton().setTitle("OnlyInThisTestThisText5")
				.clickSaveNewBookButton().clickFindBooksInLibraryButton();

		openLibrary.setFindBookByTitleInput("OnlyInThisTestThisText5");

		openLibrary.clickFindBooksInLibraryButton();

		List<WebElement> listElementAfterAction = openLibrary.getSizeListBook();
		int sizeListElementAfterAction = listElementAfterAction.size();

		openLibrary.clickDeleteBookButton();

		assertTrue(openLibrary.hasFindAddedBook());
		Assert.assertEquals(1, sizeListElementAfterAction);
	}

}
