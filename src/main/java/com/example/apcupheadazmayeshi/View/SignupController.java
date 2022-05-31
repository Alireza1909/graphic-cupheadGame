package com.example.apcupheadazmayeshi.View;

import com.example.apcupheadazmayeshi.Controller.SignUpMenuController;
import com.example.apcupheadazmayeshi.Main;
import com.example.apcupheadazmayeshi.Model.User;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class SignupController {
    @FXML
    TextField username = new TextField();
    @FXML
    TextField password = new TextField();
    @FXML
    TextField checkPassword = new TextField();

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
        if (password.getText().equals(checkPassword.getText())) {
            System.out.println(username.getText());
            boolean result = signUpMenuController.isUsernameRepeated(username.getText());
            System.out.println(result);
            if (result){
                SignupMenu.setErrorMessage("there is already a User with this username");
                SignupMenu.showError();
            }
            else{
                System.out.println("yep");
                signUpMenuController.createUser(username.getText(),password.getText());
                System.out.println(User.users.size());
                LoginMenu.showLoginMenu();
            }
        }
        else {
            SignupMenu.setErrorMessage("passwords are not identical");
            SignupMenu.showError();
        }
//        Game game = new Game(1, Main.stage);
    }

    public void BackToLoginMenu(MouseEvent mouseEvent) {
        LoginMenu.showLoginMenu();
    }

    public void backToSignupMenu(MouseEvent mouseEvent) {
        SignupMenu.showSignUp();
    }
}
