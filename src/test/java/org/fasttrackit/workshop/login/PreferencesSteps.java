package org.fasttrackit.workshop.login;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fasttrackit.util.TestBase;
import org.fasttrackit.workshop.Menu.MainMenuView;
import org.fasttrackit.workshop.Preferences.PreferencesView;

/**
 * Created by Alex on 04.07.2015.
 */
public class PreferencesSteps extends TestBase {

    public static final String NEW_PASSWORD = "eu.p";
    private PreferencesView preferencesView = new PreferencesView();

    @When("^I click on Preferences button$")
    public void I_click_on_Preferences_button() {
        preferencesView.open();
    }

    @And("^I input current password$")
    public void I_input_current_password() {
        preferencesView.typeCurrentPassword(LoginSteps.VALID_PASSWORD);
    }

    @And("^I input new password$")
    public void I_input_new_password(){
        preferencesView.typeNewPassword(NEW_PASSWORD);


    }

    @And("^I confirm the new password$")
    public void I_confirm_the_new_password(){
        preferencesView.typeConfirmPassword(NEW_PASSWORD);
    }

    @And("^I click on Save button$")
    public void I_click_on_Save_button(){
        preferencesView.save();
    }

    @Then("^I should see \"([^\"]*)\" message$")
    public void I_should_see_message(String statusMessageEl) {

        preferencesView.errorMessageShouldBePresent(statusMessageEl);
        LoginSteps.VALID_PASSWORD = NEW_PASSWORD;
    }

    @And("^I close Preferences window$")
    public void I_close_Preferences_window() {
        preferencesView.close();

    }

    @And("^I logout$")
    public void I_logout() throws Throwable {
        preferencesView.logout();
    }
}
