package se.myhappyplants.client.controller;

import org.junit.jupiter.api.*;


import se.myhappyplants.client.model.BoxTitle;
import se.myhappyplants.client.model.LoggedInUser;
import se.myhappyplants.client.model.RootName;
import se.myhappyplants.shared.Message;
import se.myhappyplants.shared.MessageType;
import se.myhappyplants.shared.User;

import java.io.IOException;
import static org.mockito.Mockito.*;


import static javafx.beans.binding.Bindings.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

public class JunitTest {
    private LoginPaneController lpc;
    private MainPaneController mpc;

    private StartClient startClient;


    public static void main(String[] args) throws IOException {
        JunitTest testFile = new JunitTest();
        testFile.setup();
        testFile.testLogOutButton();
      //  testFile.testLogInButton();
    }
    public void testLogOutButton() throws IOException {
        setup();
        testWriteEmailToTextFile();
        testSetUserToNull();
      //  testSetRootToLoginPane();
       // testLogoutButtonPressed();
    }
    public void testLogInButton() throws IOException {
        setup();
     //   checkLoginResponseNotNull_LoginResponseIsNull_DisplaysFailedMessageBox();
      //  checkLoginResponseIsSuccess();
    }

    @BeforeEach
    public void setup() throws IOException {
        this.lpc = new LoginPaneController();
        this.mpc = new MainPaneController();
     //   this.startClient = new StartClient();
     //   startClient = mock(StartClient.class);
    }
    @Test
    public void testSetUserToNull() {
       String result = mpc.setUserToNull();
       assertEquals("User set to null", result);
    }
    @Test
    public void testSetRootToLoginPane() throws IOException{
        String result = mpc.setRootToLoginPane();
        assertEquals("Root set to loginPane", result);
        assertEquals(RootName.loginPane.toString(), StartClient.getRoot());    }
    @Test
    public void testWriteEmailToTextFile() throws IOException {
        String email = "test@test.com";
        LoggedInUser.getInstance().setUser(new User(email, "test", "test", true));
        String result = mpc.writeEmailToTextFile();
        assertEquals("Email written to file", result);
    }
    @Test
    public void checkLoginResponseNotNull_LoginResponseIsNull_DisplaysFailedMessageBox() {
        // Call the method with null loginResponse
        String result = lpc.checkLoginResponseNotNull(null);

        // Check that the appropriate message is returned
        assertEquals("Login response is null", result);
    }
    @Test
    public void checkLoginResponseIsSuccess() {
        Message loginResponse = new Message(MessageType.login, new User("test", "test"));
        String result = lpc.checkLoginResponseIsSuccess(loginResponse);
        assertEquals("Login response is not successful", result);
    }
}
