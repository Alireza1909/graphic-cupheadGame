package com.example.apcupheadazmayeshi;

import com.example.apcupheadazmayeshi.Controller.GameBoardController;
import com.example.apcupheadazmayeshi.Model.Bomb;
import com.example.apcupheadazmayeshi.Model.Bullet;
import com.example.apcupheadazmayeshi.Model.GameBoard;
import com.example.apcupheadazmayeshi.Model.MiniBoss;
import javafx.animation.AnimationTimer;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;
import java.util.ArrayList;

public class Game {

    public static Scene scene;
    public static ArrayList<String> keys;
    private GameBoard gameBoard;

//    final Rectangle rect = new Rectangle(1000,800);
//
//    final double rectangleSpeed = 100 ; // pixels per second
//    final double minX = 0 ;
//    final double maxX = 1000 ; // whatever the max value should be.. can use a property and bind to scene width if needed...
//    final DoubleProperty rectangleVelocity = new SimpleDoubleProperty();
//    final LongProperty lastUpdateTime = new SimpleLongProperty();
//    final AnimationTimer rectangleAnimation = new AnimationTimer() {
//        @Override
//        public void handle(long timestamp) {
//            if (lastUpdateTime.get() > 0) {
//                final double elapsedSeconds = (timestamp - lastUpdateTime.get()) / 1_000_000_000.0 ;
//                final double deltaX = elapsedSeconds * rectangleVelocity.get();
//                final double oldX = rect.getTranslateX();
//                final double newX = Math.max(minX, Math.min(maxX, oldX + deltaX));
//                rect.setTranslateX(newX);
//            }
//            lastUpdateTime.set(timestamp);
//        }
//    };

    public Game(int level, Stage stage1) throws IOException {
        gameBoard = new GameBoard(level);
        keys = new ArrayList<>();
        start();
    }

    public void start() throws IOException {
        run();
    }

    public void run() throws MalformedURLException {
        Pane root = new Pane();
        Scene scene = new Scene(root);
        //Main.stage.setScene(scene);
        Main.stage.close();
        Main.stage = new Stage();
        Main.stage.setScene(scene);
        Canvas canvas = new Canvas(1000, 800);
        GraphicsContext context = canvas.getGraphicsContext2D();
        //root.setCenter(canvas);
        root.getChildren().add(canvas);
//        handleKey(scene);
        GameBoardController gameBoardController = new GameBoardController(gameBoard);


        Sprite backGround = new Sprite("C:\\Users\\Asus\\IdeaProjects\\APCUPHEADAzmayeshi\\src\\main\\resources\\com\\example\\apcupheadazmayeshi\\Pictures\\sunset-sky-10.jpg");
        Rectangle rectangle = new Rectangle(500, 400, 1000, 800);
        backGround.setCoordinate(rectangle);

        Label timer = new Label();
        Label playersXP = new Label();
        Label playersHP = new Label();
        Label bossHP = new Label();
        URL address1 = new URL(Game.class.getResource("css/GameLabels.css").toString());
        timer.getStylesheets().add(address1.toString());
        playersHP.getStylesheets().add(address1.toString());
        playersXP.getStylesheets().add(address1.toString());
        bossHP.getStylesheets().add(address1.toString());
        timer.getStyleClass().add("timer");
        playersHP.getStyleClass().add("playerHP");
        playersXP.getStyleClass().add("playerXP");
        bossHP.getStyleClass().add("bossHP");
        root.getChildren().add(timer);
        root.getChildren().add(playersHP);
        root.getChildren().add(playersXP);
        root.getChildren().add(bossHP);
        timer.setLayoutX(500);
        timer.setLayoutY(30);
        playersHP.setLayoutY(650);
        playersHP.setLayoutX(30);
        playersXP.setLayoutY(720);
        playersXP.setLayoutX(30);
        bossHP.setLayoutX(810);
        bossHP.setLayoutY(720);


        Sprite bulletIcon = new Sprite("C:\\Users\\Asus\\IdeaProjects\\APCUPHEADAzmayeshi\\src\\main\\resources\\com\\example\\apcupheadazmayeshi\\Pictures\\shmup_icon_bullet_0001.png");
        Rectangle rectangle1 = new Rectangle(30,30 ,40,40);
        Sprite bombIcon = new Sprite("C:\\Users\\Asus\\IdeaProjects\\APCUPHEADAzmayeshi\\src\\main\\resources\\com\\example\\apcupheadazmayeshi\\Pictures\\shmup_icon_bomb_0001.png");
        bulletIcon.setCoordinate(rectangle1);
        bombIcon.setCoordinate(rectangle1);

        System.out.println("salap");
        handleKey(scene);
        URL address = new URL(Game.class.getResource("Audio/indianaJones2.mp3").toString());

        Media media = new Media(address.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);

        AnimationTimer animationTimer = new AnimationTimer() {
            int bullet_flag = 30;
            int bomb_flag = 45;
            int tab_flag = 20;
            String attackType = "bullet";
            int blink_timer = 60;
            int cycleForBoss = 0;
            boolean isMusicPaused = false;
            int musicPause = 20;
            int musicMute = 20;
            boolean isMusicMuted = false;
            int miniBossTimer = 300;
            int miniBossCycle = 0;
            int minute = 9;
            int second = 59;
            int counter = 60;
            @Override
            public void handle(long time) {
                if (keys.contains("UP")) {
                    gameBoard.getCupHead().getSprite().updateUp(1 / 60.0);
                }
                if (keys.contains("DOWN")) {
                    gameBoard.getCupHead().getSprite().updateDown(1 / 60.0);
                }
                if (keys.contains("LEFT")) {
                    gameBoard.getCupHead().getSprite().updateLeft(1 / 60.0);
                }
                if (keys.contains("RIGHT")) {
                    gameBoard.getCupHead().getSprite().updateRight(1 / 60.0);
                }
                if (keys.contains("SPACE")) {
                    if (attackType.equals("bullet") && bullet_flag < 0) {
                        gameBoardController.addBullet();
                        bullet_flag = 30;
                    } else if (attackType.equals("bomb") && bomb_flag < 0) {
                        gameBoardController.addBomb();
                        bomb_flag = 45;
                    }
                }
                if (keys.contains("TAB") && tab_flag < 0) {
                    if (attackType.equals("bullet")) attackType = "bomb";
                    else if (attackType.equals("bomb")) attackType = "bullet";
                    tab_flag = 20;
                }
                if (keys.contains("P") && musicPause < 0){
                    musicPause = 20;
                    mediaPlayer.pause();
                    isMusicPaused = !isMusicPaused;
                }
                if (keys.contains("M") && musicMute < 0){
                    mediaPlayer.setMute(!mediaPlayer.isMute());
                    isMusicMuted = !isMusicMuted;
                    musicMute = 20;
                }
                if (miniBossTimer < 0){
                    miniBossTimer = 300;
                    gameBoardController.addMiniBoss();
                }
                if (!isMusicPaused) mediaPlayer.play();
                gameBoardController.updateBullets();
                gameBoardController.updateBombs();
                gameBoardController.updateBoss();
                gameBoardController.updateMiniBoss();
                //display and update bombs and bullets
                backGround.render(context);
                for (Bullet bullet : gameBoard.getBullets()) {
                    bullet.getSprite().update(1 / 60.0);
                    bullet.getSprite().render(context);
                }
                for (Bomb bomb : gameBoard.getBombs()) {
                    bomb.getSprite().update(1/60.0);
                    bomb.getSprite().render(context);
                }
                for (MiniBoss miniBoss : gameBoard.getMiniBoss()) {
                    miniBoss.getSprites().get(miniBossCycle/5).update(1/60.0);
                    miniBoss.getSprites().get(miniBossCycle/5).render(context);
                }
                switch (attackType){
                    case "bomb":
                        bombIcon.render(context);
                        break;
                    case "bullet":
                        bulletIcon.render(context);
                        break;
                    default:
                        break;
                }
                if (counter<=0){
                    second --;
                    if (second == -1){
                        second = 59;
                        minute--;
                    }
                    counter = 60;
                }
                cycleForBoss ++;
                cycleForBoss %= (gameBoard.getBoss().getSprites().size()*5);
                miniBossCycle ++;
                miniBossCycle %= (30);
                bullet_flag--;
                tab_flag--;
                bomb_flag--;
                musicPause--;
                musicMute--;
                miniBossTimer--;
                counter--;
                Integer sec = second;
                timer.setText("0"+minute+":"+(second>9?sec.toString():"0"+sec));
                Integer HP = gameBoard.getCupHead().getHP();
                playersHP.setText("HP : "+HP.toString());
                Integer XP = gameBoard.getCupHead().getXP();
                playersXP.setText("score : "+XP.toString());
                bossHP.setText("HP : "+gameBoard.getBoss().getHP());
                gameBoard.getCupHead().getSprite().render(context);
                gameBoard.getBoss().getSprites().get(cycleForBoss/5).render(context);
            }
        };

        animationTimer.start();

        Main.stage.show();
        System.out.println("salam");
    }

    public void handleKey(Scene scene) {
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (!keys.contains(event.getCode().toString())) keys.add(event.getCode().toString());
                System.out.println(event.getCode().toString());
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (keys.contains(event.getCode().toString())) keys.remove(event.getCode().toString());
                System.out.println(event.getCode().toString());
            }
        });
    }
}
