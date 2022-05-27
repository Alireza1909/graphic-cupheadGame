package com.example.apcupheadazmayeshi.View;

import com.example.apcupheadazmayeshi.Controller.SignUpMenuController;
import com.example.apcupheadazmayeshi.Main;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class SignupController {
    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    TextField checkPassword;

    public SignUpMenuController signUpMenuController = new SignUpMenuController();

    public void typeUsername(KeyEvent keyEvent) {
        username =(TextField) keyEvent.getSource();
    }

    public void typePassword(KeyEvent keyEvent) {
        password =(TextField) keyEvent.getSource();
    }

    public void checkPassword(KeyEvent keyEvent) {
        checkPassword =(TextField) keyEvent.getSource();
    }

    public void signup(MouseEvent mouseEvent) throws IOException {
//        if (password.getText().equals(checkPassword.getText())) {
//            boolean result = signUpMenuController.isUsernameRepeated(username.getText());
//            if (result){
//                SignupMenu.setErrorMessage("there is already a User with this username");
//            }
//            else{
//                signUpMenuController.createUser(username.toString(),password.toString());
//            }
//        }
//        else {
//            SignupMenu.setErrorMessage("passwords are not equal");
//        }
        Game game = new Game(1, Main.stage);
    }

    public void BackToLoginMenu(MouseEvent mouseEvent) {
        LoginMenu.showLoginMenu();
    }

    public void backToSignupMenu(MouseEvent mouseEvent) {
        SignupMenu.showSignUp();
    }
}
