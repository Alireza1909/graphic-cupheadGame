package com.example.apcupheadazmayeshi;

import com.example.apcupheadazmayeshi.Controller.LoginMenuController;
import com.example.apcupheadazmayeshi.Model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class LoginController {
    @FXML
    private Label welcomeText = new Label();
    @FXML
    private TextField currentPassword = new TextField();
    @FXML
    private TextField currentUsername = new TextField();

    public static LoginMenuController loginMenuController = new LoginMenuController();

    @FXML
    public void register(MouseEvent mouseEvent) throws IOException {
        SignupMenu signupMenu = new SignupMenu();
        signupMenu.start(Main.stage);
    }

    public void typeUsername(KeyEvent keyEvent) {
        currentUsername = (TextField) keyEvent.getSource();
    }

    public void typePassword(KeyEvent keyEvent) {
        currentPassword = (TextField) keyEvent.getSource();
    }


    public void login(MouseEvent mouseEvent) throws IOException {
        User user = loginMenuController.getExistingUser(currentPassword.toString(),currentUsername.toString());
        if (user == null){
            LoginMenu.showInvalidLogin();
        }
        else{
            User.loggedInUser = user;
            ProfileMenu profileMenu = new ProfileMenu();
            profileMenu.start(Main.stage);
        }
    }

    public void backToLoginMenu(MouseEvent mouseEvent) {
        LoginMenu.showLoginMenu();
    }

    public void guestLogin(MouseEvent mouseEvent) throws IOException {
        int level = 1;
        Game game = new Game(level, Main.stage);
    }

}