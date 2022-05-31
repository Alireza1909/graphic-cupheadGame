package com.example.apcupheadazmayeshi.View;

import com.example.apcupheadazmayeshi.Controller.LoginMenuController;
import com.example.apcupheadazmayeshi.Main;
import com.example.apcupheadazmayeshi.Model.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginController {
    public static int score;
    public static double progres;
    @FXML
    private Label welcomeText = new Label();
    @FXML
    private TextField currentPassword = new TextField();
    @FXML
    private TextField currentUsername = new TextField();
    @FXML
    private TextField gameLevel = new TextField();
    @FXML
    private Text progress;
    @FXML
    private Text scoreField;

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
        User user = loginMenuController.getExistingUser(currentPassword.getText(), currentUsername.getText());
        if (user == null) {
            LoginMenu.showInvalidLogin();
        } else {
            User.loggedInUser = user;
            LoginMenu.showGameLevel();
        }
    }

    public void backToLoginMenu(MouseEvent mouseEvent) {
        LoginMenu.showLoginMenu();
    }

    public void guestLogin(MouseEvent mouseEvent) throws IOException {
        int level = 2;
        Game game = new Game(level);
    }

    public void goToGame(MouseEvent mouseEvent) throws IOException {
        int level;
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(gameLevel.getText());
        if (!matcher.matches()) level = 2;
        else level = Integer.parseInt(gameLevel.getText());

        if (level > 3 || level < 1) level = 2;
        Game newGame = new Game(level);
    }


    public void updateGameLevel(KeyEvent keyEvent) {
        gameLevel = (TextField) keyEvent.getSource();
    }

    public void logout(MouseEvent mouseEvent) {
        User.loggedInUser = null;
        LoginMenu.showLoginMenu();
    }

    public void gameLevel(MouseEvent mouseEvent) {
        LoginMenu.showGameLevel();
    }

    public void setProgress(MouseEvent mouseEvent) {
        //progress = new Text();
        progress.setText("progress = " + progres*100 + "%");
    }

    public void setScore(MouseEvent mouseEvent){
        //scoreField = new Text();
        scoreField.setText("score = "+score);
    }
}