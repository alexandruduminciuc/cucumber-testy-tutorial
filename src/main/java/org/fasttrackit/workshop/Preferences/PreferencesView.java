package org.fasttrackit.workshop.Preferences;

import com.sdl.selenium.web.WebLocator;
import com.sdl.selenium.web.button.Button;
import com.sdl.selenium.web.form.TextField;
import com.sdl.selenium.web.utils.Utils;
import org.fasttrackit.workshop.Menu.MainMenuView;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Alex on 04.07.2015.
 */
public class PreferencesView {

    private WebLocator window = new WebLocator().setId("preferences-win");

    private Button preferencesButton = new Button().setText("Preferences");
    private TextField currentPassword = new TextField().setLabel("Current Password");
    private TextField newPassword = new TextField().setLabel("New Password");
    private TextField confirmPassword = new TextField().setLabel("Repeat Password");
    private Button saveButton = new Button().setText("Save").setContainer(window);
    private Button closeButton = new Button().setText("Close").setContainer(window);
    private WebLocator statusMessage = new WebLocator(window).setClasses("status-msg");

//    public static void main(String[] args) {
//
//        PreferencesView preferencesView = new PreferencesView();
//        System.out.println(preferencesView.window.getPath());
//        System.out.println(preferencesView.closeButton.getPath());
//    }

//    private TextField currentPassword = new TextField().setElPath("//label[text()='Current Password']//following-sibling::*//input");
//    private TextField newPassword = new TextField().setElPath("//label[text()='New Password']//following-sibling::*//input");
//    private TextField confirmPassword = new TextField().setElPath("//label[text()='Repeat Password']//following-sibling::*//input");


    public void open() {
        MainMenuView.preferencesButton.click();
    }

    public void typeCurrentPassword(String password) {
        Utils.sleep(400);// window is coming down (fading)
        currentPassword.setValue(password);


    }

    public void typeNewPassword(String password) {
        newPassword.setValue(password);

    }
    public void typeConfirmPassword(String password) {
        confirmPassword.setValue(password);
        Utils.sleep(400);
    }

    public void save() {
        saveButton.assertClick();
    }

    public void errorMessageShouldBePresent(String expectedMessage) {
        assertThat(statusMessage.getHtmlText(), is(expectedMessage));
    }

    public void close() {

        closeButton.assertClick();
        Utils.sleep(400);// window is fading
    }

    public void logout() {
        MainMenuView.logoutLink.assertClick();

    }
}
