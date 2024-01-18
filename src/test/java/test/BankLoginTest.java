package test;

import data.DataHelper;
import data.SQLHelper;
import org.junit.jupiter.api.*;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static data.SQLHelper.cleanDatabase;

public class BankLoginTest {
    LoginPage loginPage;

    @AfterEach
    void tearDown() {
        cleanAuthCodes();
    }

    private void cleanAuthCodes() {
    }

    @AfterAll
    static void tearDownAll() {
        cleanDatabase();
    }

    @BeforeEach
    void setUp() {
        loginPage = open("http://Localhost:9999", LoginPage.class);
    }

    @Test
    @DisplayName("Should successfully login to dashboard with exist login and password from sut test data")
    void shouldSuccessfulLogin() {
        var authInfo = DataHelper.getAuthInfowithTestData();
        var verificationPage = loginPage.validLogin(authInfo);
        verificationPage.verifycationPageVisiblity();
        var verificationCode = SQLHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());
    }

    @Test
    @DisplayName("Should get error notification if user is not exits in base")
    void shouldGetErrorNotificationIfLoginWithRandomUser() {
        var authInfo = DataHelper.generateRandonUser();
        loginPage.validLogin(authInfo);
        loginPage.verifyErrorNotificationVisiblity("Ошибка! \nНеверно указан логин или пароль");
    }
}


