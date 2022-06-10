package user;

import base.Pages;
import base.TestBase;
import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import models.SocialTitle;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.commons.TopMenuPage;

import java.io.File;
import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationTests extends Pages {

    private Faker faker;
    private FakeValuesService fakeValuesService;
    private String firstName;
    private String lastName;
    private String password;

    @BeforeMethod
    public void testSetup() {

        faker = new Faker();
        fakeValuesService = new FakeValuesService(
                new Locale("en-GB"), new RandomService());
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        password = "password123";
    }

    @Test
    public void shouldRegisterNewUser(){
        topMenuPage.goToSignIn();
        loginPage.goToCreateAccount();
        registrationPage
                .selectSocialTitle(SocialTitle.Mr)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(fakeValuesService.bothify("????##@gmail.com"))
                .setPassword(password)
                .setPrivacy()
                .setGeneralTerms()
                .clickSaveButton();

        assertThat(topMenuPage.getUserName()).isEqualTo(firstName+" "+lastName);

    }
}
