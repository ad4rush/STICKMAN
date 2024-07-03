package com.example.finale;

import javafx.animation.*;
import javafx.event.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class HelloController {

    static Scene home_page() {
        Pane vp = new Pane();
        VBox vb = new VBox();
        Scene scene = new Scene(vp, 350, 400);
        Button btn = new Button("Play");
        Button nw = new Button("Exit");
        nw.setAlignment(Pos.CENTER);
        // main scene background
        Image img = new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\backgoung_stick_hero.jpg");
        BackgroundImage bk = new BackgroundImage(img, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);


        // button background
        Image bu_bk = new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\HD_transparent_picture.png");
        BackgroundImage but_bk = new BackgroundImage(bu_bk, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        vp.setBackground(new Background(bk));


        // setting background and configuring the buttons
        Button_Good.get_Button(btn, nw, but_bk);
        btn.setOnMouseClicked(new startMainGame(vp));
        Font ft_b = new Font("Times new Roman", 18);
        btn.setFont(ft_b);
        nw.setFont(ft_b);
        btn.setOnMouseEntered(new hover_the_button(btn));
        btn.setOnMouseExited(new hover_the_button_ex(btn));
        nw.setOnMouseEntered(new hover_the_button(nw));
        nw.setOnMouseExited(new hover_the_button_ex(nw));

        //DropShadow dps =new DropShadow(0,5,5,Color.GRAY);
        //btn.setEffect(dps);
        //nw.setEffect(dps);

        //Main label
        Label main_head = new Label("Stick\nHero");
        Font ft = new Font("Times new Roman", 80);
        main_head.setFont(ft);


        // center button hbox
        HBox hb = new HBox(50, btn, nw);
        hb.setAlignment(Pos.CENTER);

        // vbox
        VBox pageia = new VBox(80, main_head, hb);
        pageia.setAlignment(Pos.CENTER);

        // mixing in the main page
        vb.getChildren().addAll(pageia);
        vb.setBackground(new Background(bk));
        vb.setAlignment(Pos.CENTER);
        vb.setLayoutX(100);
        vb.setLayoutY(50);
        vp.getChildren().add(vb);

        return scene;
    }

    static int score=0;

}

class exit_the_application implements EventHandler<MouseEvent>   {
    public exit_the_application(){}

    @Override
    public void handle(MouseEvent mouseEvent) {
        System.exit(0);
    }
}

class hover_the_button implements EventHandler<MouseEvent>{

    Button but;
    hover_the_button(Button button){
        this.but=button;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        but.setEffect(new Bloom(10));
        but.setCursor(Cursor.HAND);
    }
}

class hover_the_button_ex implements EventHandler<MouseEvent>{

    Button but;
    hover_the_button_ex(Button button){
        this.but=button;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        but.setEffect(null);
        but.setCursor(Cursor.DEFAULT);
    }
}


// Singleton Design Pattern is used
class path_stick extends HelloController{
    private static Rectangle main_path=null;

    private path_stick(){
        main_path=new Rectangle(2, 1);
    }

    public static Rectangle getPathRectangle(){
        if (main_path==null){
            main_path=new Rectangle(2, 1);
        }
        return main_path;
    }

}

interface Basic_functions {
    int get_Cherry_count();
    void updateCherry(int a);
    void updateScore(int a) throws FileNotFoundException;

    static int get_high_score(){
        Scanner sc = null;
        try {
            sc = new Scanner(new File("src/main/java/com/example/finale/score_sheet.txt"));
        } catch (FileNotFoundException e) {
            // nothing
        }
        int current=0;
        if (sc.hasNext()){
            current = sc.nextInt();


        }
        return current;
    }

    static void update_current_score(int a){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\hp\\IdeaProjects\\finale\\src\\main\\java\\com\\example\\finale\\current_score.txt"))) {
        // Write content to the file
        System.out.println(a);
        bufferedWriter.write(Integer.toString(a));
        bufferedWriter.newLine();
        bufferedWriter.close();
        } catch (IOException e) {
            // nothing
        }
    }

}

class Basic_function_class implements Basic_functions{

    @Override
    public int get_Cherry_count() {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("src/main/java/com/example/finale/Cherry_sheet.txt"));
        } catch (FileNotFoundException e) {
            // nothing
        }
        int current=0;
        if (sc.hasNext()){
            current = sc.nextInt();
        }
        sc.close();
        return current;
    }

    @Override
    public void updateCherry(int a) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\hp\\IdeaProjects\\finale\\src\\main\\java\\com\\example\\finale\\Cherry_sheet.txt"))) {
            // Write content to the file
            System.out.println(a);
            bufferedWriter.write(Integer.toString(a));
            bufferedWriter.newLine();
            bufferedWriter.close();
        } catch (IOException e) {
            // nothing
        }
    }

    @Override
    public void updateScore(int a) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/java/com/example/finale/score_sheet.txt"));
        int current=0;
        if (sc.hasNext()){
            current = sc.nextInt();
        }
        if (a>current){
            //FileWriter file_w = new FileWriter(new File("score_sheet.txt"));
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:\\Users\\hp\\IdeaProjects\\finale\\src\\main\\java\\com\\example\\finale\\score_sheet.txt"))) {
                // Write content to the file
                System.out.println(a);
                bufferedWriter.write(Integer.toString(a));
                bufferedWriter.newLine();
                bufferedWriter.close();
            } catch (IOException e) {
                // nothing
            }

        }
        sc.close();

    }
}

class startMainGame implements EventHandler<MouseEvent>{

    Pane main_pane;
    Basic_functions base;

    public startMainGame(Pane s){
        this.main_pane=s;
        this.base=new Basic_function_class();
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        // removing home screen contents
        main_pane.getChildren().clear();
        //main_pane.setAlignment(Pos.BOTTOM_CENTER);
        create_first_box();
        startingTheGame();
    }
    static ImageView cherrywer=null;

    void startingTheGame() {

        ImageView gif_viewer = new ImageView("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\tenor.png");
        gif_viewer.setFitHeight(100);
        gif_viewer.setPreserveRatio(true);
        gif_viewer.setLayoutX(50);
        gif_viewer.setLayoutY(150);
        System.out.println("\t lev leve");
        Label lb = new Label("Score : "+HelloController.score);
        int fg = base.get_Cherry_count();
        Label kl = new Label("Gem : "+fg);
        Font ftr = new Font("DM Sans", 15);
        kl.setFont(ftr);
        Font ft = new Font("DM Sans", 25);
        CornerRadii cnr = new CornerRadii(25);
        BorderStroke bsd = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, cnr, BorderWidths.DEFAULT);
        lb.setPadding(new Insets(5,15,5,15));
        lb.setFont(ft);
        lb.setLayoutX(125);
        lb.setLayoutY(50);
        kl.setLayoutY(60);
        kl.setLayoutX(260);
        kl.setPadding(new Insets(2,5,2,5));
        lb.setBorder(new Border(bsd));
        kl.setBorder(new Border(bsd));
        Button pause = getPause(main_pane);
        main_pane.getChildren().add(gif_viewer);
        //final Rectangle[] new_dist = {Random_box_generator()};
        final Rectangle[] new_dist = {(Rectangle)new Factory().get_shape("Rectangle",main_pane)};
        final Rectangle[] rapta = {path_stick.getPathRectangle()}; //new Rectangle(2, 1);
        rapta[0].setRotate(180);
        rapta[0].setLayoutX(87);
        rapta[0].setLayoutY(250);
        main_pane.getChildren().add(rapta[0]);
        main_pane.getChildren().add(pause);
        main_pane.getChildren().add(lb);
        main_pane.getChildren().add(kl);
        final boolean[] key_pressed = {false};
        final boolean[] first_time = {true};
        final boolean[] stick_to_fall = {false};
        final boolean[] done = {false};
        final boolean[] rotable = {false};
        main_pane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (first_time[0]) {
                    System.out.println("Entered");
                    key_pressed[0] = true;
                    first_time[0] = false;
                }
            }
        });
        main_pane.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                key_pressed[0] = false;
                stick_to_fall[0] = true;
                System.out.println("Entered_exit");
            }
        });

        //creating  new thread for rotating the stick

        main_pane.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if ("S".equals(event.getText()) || "s".equals(event.getText())) {
                if (rotable[0]){
                if (gif_viewer.getScaleY()==1){
                    gif_viewer.setLayoutY(270);
                    System.out.println("this dgf fkhdfkhvg h 2");
                }
                else {
                    gif_viewer.setLayoutY(150);
                }
                gif_viewer.setScaleY(-1*gif_viewer.getScaleY());
                    System.out.println("\t Now changing the state");
                }
                System.out.println("Entered the eventfillxvbhdfb");

            }
        });

        final Thread[] rotator = {new Thread(() -> {
            Rotate rotate = new Rotate();
            //Pivot points at the upper left corner of the rectangle
            rotate.setPivotX(rapta[0].getX());
            rotate.setPivotY(rapta[0].getY());
            rapta[0].getTransforms().add(rotate);

            while (true) {
                //System.out.println(stick_to_fall[0]);
                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    // dfkjndfsng
                }
                if (stick_to_fall[0]) {
                    rotate.setAngle(rotate.getAngle() + 1);
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                        // dfkjndfsng
                    }
                }
                if (rotate.getAngle() >= 90) {
                    stick_to_fall[0] = false;
                    rotable[0]=true;
                    gif_viewer.setImage(new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\teno3.gif"));
                    TranslateTransition translateTransition = new TranslateTransition();
                    translateTransition.setDuration(Duration.seconds(1));
                    translateTransition.setNode(gif_viewer);
                    final boolean[] is_safe = {checking_length(rapta[0], new_dist[0], 0)};
                    new AnimationTimer() {
                        @Override
                        public void handle(long now) {
                                if (gif_viewer.getBoundsInParent().intersects(cherrywer.getBoundsInParent())){
                                    main_pane.getChildren().remove(cherrywer);
                                    String[] temper = kl.getText().split(" ");
                                    int d_Counter = Integer.parseInt(temper[2]);
                                    d_Counter++;
                                    kl.setText(temper[0]+" "+temper[1]+" "+d_Counter);
                                    stop();
                                }
                            }
                    }.start();
                    if (is_safe[0]) {
                        translateTransition.setByX(new_dist[0].getLayoutX() - 58);
                    } else {
                        translateTransition.setByX(rapta[0].getHeight() + rapta[0].getLayoutX() - 58);
                    }
                    translateTransition.play();
                    translateTransition.setOnFinished(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent actionEvent) {
                            rotable[0]=false;
                            cherrywer.setImage(new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\HD_transparent_picture.png"));
                            if (gif_viewer.getScaleY()==-1){
                                is_safe[0] =false;
                            }
                            gif_viewer.setImage(new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\tenor.png"));
                            if (!is_safe[0]) {
                                gif_viewer.setImage(new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\cry.png"));
                                TranslateTransition translateTransition_down = new TranslateTransition();
                                translateTransition_down.setDuration(Duration.seconds(1));
                                translateTransition_down.setNode(gif_viewer);
                                translateTransition_down.setByY(155);
                                translateTransition_down.play();
                                translateTransition_down.setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override
                                    public void handle(ActionEvent actionEvent) {
                                        gif_viewer.setImage(new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\cry.png"));
                                        done[0] = true;
                                    }
                                });
                            } else {
                                done[0] = true;
                            }
                        }
                    });
                    break;

                }
            }
        })};
            rotator[0].start();


        // extending length of path
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (key_pressed[0]) {
                    double height = rapta[0].getHeight();
                    rapta[0].setHeight(height + 1);
                    rapta[0].setLayoutY(rapta[0].getLayoutY() - 1);
                    boolean check = checking_length(rapta[0], new_dist[0],1);
                }
            }
        }.start();

        class replaying_class {
            private replaying_class(){
                Rectangle temp = (Rectangle) main_pane.getChildren().get(0);
                main_pane.getChildren().remove(0);
                //main_pane.getChildren().remove(rapta);
                TranslateTransition translateTransition = new TranslateTransition();
                TranslateTransition translateTransition_r = new TranslateTransition();
                translateTransition_r.setDuration(Duration.seconds(0.5));
                translateTransition_r.setNode(new_dist[0]);
                Rectangle remp = new_dist[0];
                translateTransition.setDuration(Duration.seconds(0.5));
                translateTransition.setNode(gif_viewer);
                translateTransition.setByX(-(new_dist[0].getLayoutX() - 55));
                translateTransition_r.setByX(-(new_dist[0].getLayoutX()-50));
                ParallelTransition ptl = new ParallelTransition(
                        translateTransition,
                        translateTransition_r
                );
                ptl.play();
                translateTransition_r.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        rapta[0].setHeight(0);
                        rapta[0].getTransforms().remove(0);
                        rapta[0].setLayoutX(50+remp.getWidth()-2);
                        rapta[0].setLayoutY(250);
                    }
                });

            }
        }




        AnimationTimer monitoring_Timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (done[0]) {
                    new replaying_class();
                    rapta[0].getTransforms().removeAll();
                    done[0]=false;
                    boolean is_safeset=checking_length(rapta[0], new_dist[0],0);
                    if (gif_viewer.getScaleY()==-1){
                        is_safeset=false;
                    }
                    System.out.println(is_safeset);
                    String[] temp = lb.getText().split(" ");
                    int sc = Integer.parseInt(temp[2]);
                    if (is_safeset){
                        sc++;
                        HelloController.score=sc;
                        lb.setText(temp[0]+" "+temp[1]+" "+sc);
                        first_time[0]=true;
                        new_dist[0] = (Rectangle)new Factory().get_shape("Rectangle",main_pane);
                        rotator[0] = new Thread(() -> {
                            Rotate rotate = new Rotate();
                            //Pivot points at the upper left corner of the rectangle
                            rotate.setPivotX(rapta[0].getX());
                            rotate.setPivotY(rapta[0].getY());
                            rapta[0].getTransforms().add(rotate);

                            while (true) {
                                //System.out.println(stick_to_fall[0]);
                                try {
                                    sleep(10);
                                } catch (InterruptedException e) {
                                    // dfkjndfsng
                                }
                                if (stick_to_fall[0]) {
                                    rotate.setAngle(rotate.getAngle() + 1);
                                    try {
                                        sleep(10);
                                    } catch (InterruptedException e) {
                                        // dfkjndfsng
                                    }
                                }
                                if (rotate.getAngle() >= 90) {
                                    rotable[0]=true;
                                    stick_to_fall[0] = false;
                                    gif_viewer.setImage(new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\teno3.gif"));
                                    TranslateTransition translateTransition = new TranslateTransition();
                                    translateTransition.setDuration(Duration.seconds(1));
                                    translateTransition.setNode(gif_viewer);
                                    final boolean[] is_safe = {checking_length(rapta[0], new_dist[0], 0)};

                                    new AnimationTimer() {
                                        @Override
                                        public void handle(long now) {
                                            if (gif_viewer.getBoundsInParent().intersects(cherrywer.getBoundsInParent())){
                                                main_pane.getChildren().remove(cherrywer);
                                                String[] temper = kl.getText().split(" ");
                                                int d_Counter = Integer.parseInt(temper[2]);
                                                d_Counter++;
                                                kl.setText(temper[0]+" "+temper[1]+" "+d_Counter);
                                                stop();
                                            }
                                        }
                                    }.start();

                                    if (is_safe[0]){
                                        translateTransition.setByX(new_dist[0].getLayoutX() - 58);
                                    }
                                    else {
                                        translateTransition.setByX(rapta[0].getHeight()+ rapta[0].getLayoutX() - 58);
                                    }
                                    translateTransition.play();
                                    translateTransition.setOnFinished(new EventHandler<ActionEvent>() {
                                        @Override
                                        public void handle(ActionEvent actionEvent) {
                                            rotable[0]=false;
                                            cherrywer.setImage(new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\HD_transparent_picture.png"));
                                            if (gif_viewer.getScaleY()==-1){
                                                is_safe[0] =false;
                                            }
                                            gif_viewer.setImage(new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\tenor.png"));
                                            if (!is_safe[0]){
                                                gif_viewer.setImage(new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\cry.png"));
                                                TranslateTransition translateTransition_down = new TranslateTransition();
                                                translateTransition_down.setDuration(Duration.seconds(1));
                                                translateTransition_down.setNode(gif_viewer);
                                                translateTransition_down.setByY(155);
                                                translateTransition_down.play();
                                                translateTransition_down.setOnFinished(new EventHandler<ActionEvent>() {
                                                    @Override
                                                    public void handle(ActionEvent actionEvent) {
                                                        gif_viewer.setImage(new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\cry.png"));
                                                        done[0]=true;
                                                    }
                                                });
                                            }
                                            else {
                                                done[0]=true;
                                            }
                                        }
                                    });
                                    break;

                                }
                            }
                        });
                        rotator[0].start();
                    }
                    else {
                        System.out.println("End of Game");
                        String[] temper = kl.getText().split(" ");
                        int d_Counter = Integer.parseInt(temper[2]);
                        base.updateCherry(d_Counter);
                        try {
                            base.updateScore(sc);
                        } catch (FileNotFoundException e) {
                            //nothing
                        }
                        getEndPage(main_pane);
                        //System.exit(69);
                    }
                }
            }
        };
        monitoring_Timer.start();


    }

    private static Button getPause(Pane main_pane) {
        Button pause = new Button();
        ImageView pause_btn = new ImageView(new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\pause.png"));
        pause_btn.setPreserveRatio(true);
        pause_btn.setFitWidth(30);
        CornerRadii cnr = new CornerRadii(50);
        BorderStroke bsd = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, cnr, BorderWidths.DEFAULT);
        //pause.setBorder(new Border(bsd));
        pause.setBackground(new Background(new BackgroundImage(new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\HD_transparent_picture.png"), BackgroundRepeat.SPACE, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));

        pause.setLayoutX(10);
        pause.setLayoutY(10);
        pause.setGraphic(pause_btn);
        final EventHandler[] ms = new EventHandler[2];
        pause.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                main_pane.getChildren().remove(pause);
                ms[0] = main_pane.getOnMousePressed();
                ms[1] = main_pane.getOnMouseReleased();
                main_pane.setOnMousePressed(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        //nothing
                    }
                });
                main_pane.setOnMouseReleased(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        //nothing
                    }
                });
                VBox vb = new VBox(50);

                vb.setLayoutX(55);
                vb.setLayoutY(100);
                vb.setAlignment(Pos.BASELINE_CENTER);
                Label label = new Label("Paused");
                Font ft = new Font("DM Sans", 40);
                label.setFont(ft);
                HBox hb = new HBox(50);
                Button home = new Button("Home");
                Button play = new Button("Play");
                Pane pn = stopped_Popup(main_pane, vb, label, hb, home, play);
                HBox scoreboard = new HBox(20);
                scoreboard.setPadding(new Insets(5,10,5,10));
                Label y_sc = new Label("Your score: "+HelloController.score);
                Label h_sc = new Label("Previous score: "+ Basic_functions.get_high_score());
                scoreboard.getChildren().add(h_sc);
                scoreboard.getChildren().add(y_sc);
                vb.getChildren().add(scoreboard);
                Basic_functions.update_current_score(HelloController.score);
                play.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        main_pane.getChildren().remove(vb);
                        main_pane.getChildren().add(pause);
                        main_pane.setOnMousePressed(ms[0]);
                        main_pane.setOnMouseReleased(ms[1]);
                        main_pane.getChildren().remove(pn);
                    }
                });
                main_pane.getChildren().add(vb);

            }
        });
        return pause;
    }

    private void getEndPage(Pane main_pane) {
        final EventHandler[] ms = new EventHandler[2];
        ms[0] = main_pane.getOnMousePressed();
        ms[1] = main_pane.getOnMouseReleased();
        main_pane.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //nothing
            }
        });
        main_pane.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                //nothing
            }
        });
        VBox vb = new VBox(20);
        vb.setLayoutX(55);
        vb.setLayoutY(100);
        vb.setAlignment(Pos.BASELINE_CENTER);
        Label label = new Label("You Died!!");
        Font ft = new Font("DM Sans", 40);
        label.setFont(ft);
        HBox hb = new HBox(50);
        Button home = new Button("Home");
        Button play = new Button("Retry");
        Button revive = new Button("Revive");
        vb.getChildren().add(revive);
        Pane pn =  stopped_Popup(main_pane, vb, label, hb, home, play);

        play.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                HelloController.score=0;
                startMainGame st = new startMainGame(main_pane);
                st.handle(mouseEvent);
            }
        });
        main_pane.getChildren().add(vb);
        CornerRadii cnr = new CornerRadii(30);
        BorderStroke bsd = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, cnr, BorderWidths.DEFAULT);
        revive.setBorder(new Border(bsd));
        revive.setFont(new Font("Times New Roman",25));
        revive.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                int left = base.get_Cherry_count()-10;
                if (left>=0){
                    base.updateCherry(base.get_Cherry_count()-10);
                }
                else {
                    System.out.println("Not enough gems");
                    HelloController.score=0;
                }
                startMainGame st = new startMainGame(main_pane);
                st.handle(mouseEvent);
            }
        });
        revive.setPadding(new Insets(5,10,5,10));
        HBox scoreboard = new HBox(20);
        scoreboard.setPadding(new Insets(5,10,5,10));
        Label y_sc = new Label("Your score: "+HelloController.score);
        Label h_sc = new Label("Previous score: "+Basic_functions.get_high_score());
        scoreboard.getChildren().add(h_sc);
        scoreboard.getChildren().add(y_sc);
        vb.getChildren().add(scoreboard);
        revive.setBackground(new Background(new BackgroundImage(new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\HD_transparent_picture.png"), BackgroundRepeat.SPACE, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        //end
    }

    private static Pane stopped_Popup(Pane main_pane, VBox vb, Label label, HBox hb, Button home, Button play) {
        home.setBackground(new Background(new BackgroundImage(new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\HD_transparent_picture.png"), BackgroundRepeat.SPACE, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        play.setBackground(new Background(new BackgroundImage(new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\HD_transparent_picture.png"), BackgroundRepeat.SPACE, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
        ImageView hm = new ImageView(new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\Home.png"));
        hm.setPreserveRatio(true);
        hm.setFitWidth(30);
        ImageView plb = new ImageView(new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\play.png"));
        plb.setPreserveRatio(true);
        plb.setFitWidth(30);
        home.setGraphic(hm);
        play.setGraphic(plb);
        CornerRadii cnr = new CornerRadii(30);
        BorderStroke bsd = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, cnr, BorderWidths.DEFAULT);
        home.setBorder(new Border(bsd));
        play.setBorder(new Border(bsd));
        hb.getChildren().add(play);
        hb.getChildren().add(home);
        vb.getChildren().add(label);
        vb.getChildren().add(hb);
        vb.setPadding(new Insets(10,10,10,10));
        hb.setPadding(new Insets(0,5,0,5));
        CornerRadii cr = new CornerRadii(10);
        BorderStroke bsdv = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, cr, BorderWidths.DEFAULT);
        vb.setBorder(new Border(bsdv));
        Pane pn = getPane();
        main_pane.getChildren().add(pn);
        vb.setEffect(null);
        home.setOnMouseClicked(new Return_to_Home(main_pane));
        return pn;
    }

    private static Pane getPane() {
        ColorAdjust adj = new ColorAdjust(0, -0.2, -0.2, 0);
        GaussianBlur blur = new GaussianBlur(20); // 55 is just to show edge effect more clearly.
        adj.setInput(blur);
        Pane pn = new Pane();
        pn.setBackground(new Background(new BackgroundImage(new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\whitr.jpg"),BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT)));
        pn.setEffect(adj);
        pn.setPrefSize(350,420);
        return pn;
    }

    private boolean checking_length(Rectangle rapta,Rectangle dist,int q){
        double rapta_l=rapta.getHeight()+rapta.getLayoutX();
        //Light.Point pt = new Light.Point(rapta.getHeight()+rapta.getLayoutX(),250,0,Color.BLUE);
        //Point2D pte = new Point2D(dist,250);
        Circle pte = new Circle(rapta.getHeight()+rapta.getLayoutX(),250,2,Color.BLUE);
        Circle pt = new Circle(dist.getLayoutX(),250,2,Color.DARKVIOLET);
        Circle op = new Circle(dist.getLayoutX()+dist.getWidth(),250,2,Color.AQUAMARINE);
        if (q==1) {
            //main_pane.getChildren().add(pte);
            //main_pane.getChildren().add(pt);
            //main_pane.getChildren().add(op);
        }
        if (rapta_l>=dist.getLayoutX() && rapta_l<=(dist.getLayoutX()+dist.getWidth())){
            return true;
        }
        else {
            return false;
        }
    }

    private void create_first_box() {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(40);
        rectangle.setHeight(150);
        rectangle.setFill(Color.rgb(0,0,0));
        rectangle.setLayoutX(50);
        rectangle.setLayoutY(250);
        main_pane.getChildren().add(rectangle);

    }

}

class Button_Good{
    static void get_Button(Button btn, Button nw, BackgroundImage but_bk) {
        btn.setBackground(new Background(but_bk));
        nw.setBackground(new Background(but_bk));
        CornerRadii cnr = new CornerRadii(10);
        BorderStroke bsd = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, cnr, BorderWidths.DEFAULT);
        btn.setBorder(new Border(bsd));
        nw.setBorder(new Border(bsd));
        nw.setOnMouseClicked(new exit_the_application());
    }

    void get_Button_in_function(Button btn, Button nw, BackgroundImage but_bk) {
        btn.setBackground(new Background(but_bk));
        nw.setBackground(new Background(but_bk));
        CornerRadii cnr = new CornerRadii(10);
        BorderStroke bsd = new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, cnr, BorderWidths.DEFAULT);
        btn.setBorder(new Border(bsd));
        nw.setBorder(new Border(bsd));
        nw.setOnMouseClicked(new exit_the_application());
    }

}

class Return_to_Home implements EventHandler<MouseEvent>{

    private final Pane main_pane;

    public Return_to_Home(Pane po){
        this.main_pane=po;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        this.main_pane.getChildren().clear();
        VBox ter = get_Home(new Button_Good());
        this.main_pane.getChildren().add(ter);
    }

    VBox get_Home(Button_Good ghar){

        VBox vb = new VBox();
        Button btn = new Button("Play");
        Button nw = new Button("Exit");
        nw.setAlignment(Pos.CENTER);

        // button background
        Image bu_bk = new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\HD_transparent_picture.png");
        BackgroundImage but_bk = new BackgroundImage(bu_bk, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);


        // setting background and configuring the buttons
        ghar.get_Button_in_function(btn, nw, but_bk);
        Font ft_b = new Font("Times new Roman", 18);
        btn.setOnMouseClicked(new startMainGame(this.main_pane));
        btn.setFont(ft_b);
        nw.setFont(ft_b);
        btn.setOnMouseEntered(new hover_the_button(btn));
        btn.setOnMouseExited(new hover_the_button_ex(btn));
        nw.setOnMouseEntered(new hover_the_button(nw));
        nw.setOnMouseExited(new hover_the_button_ex(nw));

        //DropShadow dps =new DropShadow(0,5,5,Color.GRAY);
        //btn.setEffect(dps);
        //nw.setEffect(dps);

        //Main label
        Label main_head = new Label("Stick\nHero");
        Font ft = new Font("Times new Roman", 80);
        main_head.setFont(ft);


        // center button hbox
        HBox hb = new HBox(50, btn, nw);
        hb.setAlignment(Pos.CENTER);

        // vbox
        VBox pageia = new VBox(80, main_head, hb);
        pageia.setAlignment(Pos.CENTER);

        // mixing in the main page
        vb.getChildren().addAll(pageia);
        //vb.setBackground(new Background(bk));
        vb.setAlignment(Pos.CENTER);
        vb.setLayoutX(100);
        vb.setLayoutY(50);
        return vb;
    }


}

class Factory extends HelloController {

    public Shape get_shape(String asd,Pane ma_p){
        if (asd!=null){
            if (asd.equalsIgnoreCase("Rectangle")){
                return getRectangle(ma_p);
            }
            if (asd.equalsIgnoreCase("Square")){
                return getSquare(ma_p);
            }
        }
        return null;
    }

    private Rectangle getRectangle(Pane main_pane){
        Random ran_dist = new Random();
        double dist = ran_dist.nextDouble(100,300);
        double width = ran_dist.nextDouble(20,50);
        Rectangle new_rect= new Rectangle(width,1);
        new_rect.setLayoutX(dist);
        new_rect.setLayoutY(400);
        main_pane.getChildren().add(1,new_rect);
        Circle op = new Circle((dist+(width)/2),252,2,Color.DARKORANGE);
        //main_pane.getChildren().add(op);
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (new_rect.getHeight()<151) {
                    new_rect.setHeight(new_rect.getHeight() + 1);
                    new_rect.setLayoutY(new_rect.getLayoutY()-1);
                }
                if (new_rect.getHeight()>=151){
                    startMainGame.cherrywer = get_Cherry(new_rect,main_pane);
                    stop();
                }
            }
        }.start();
        return new_rect;
    }

    private ImageView get_Cherry(Rectangle rectangle,Pane main_pane){
        double problity = new Random().nextDouble(0,5);
        ImageView cherry = null;
        if (problity<5){
            cherry = new ImageView(new Image("C:\\Users\\hp\\OneDrive\\Desktop\\Assets\\diamond.png"));
            cherry.setFitWidth(35);
            cherry.setPreserveRatio(true);
            cherry.setLayoutY(270);
            if ((rectangle.getLayoutX()-20)>87) {
                cherry.setLayoutX(new Random().nextDouble(87, rectangle.getLayoutX() - 20));
                main_pane.getChildren().addAll(cherry);
            }
        }
        return cherry;
    }

    private Rectangle getSquare(Pane main_pane){
        Random ran_dist = new Random();
        double dist = ran_dist.nextDouble(100,300);
        double width = ran_dist.nextDouble(20,50);
        Rectangle new_rect= new Rectangle(width,1);
        new_rect.setLayoutX(dist);
        new_rect.setLayoutY(400);
        //main_pane.getChildren().add(1,new_rect);
        //Circle op = new Circle((dist+(width)/2),252,2,Color.DARKORANGE);
        //main_pane.getChildren().add(op);
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (new_rect.getHeight()<151) {
                    new_rect.setHeight(new_rect.getHeight() + 1);
                    new_rect.setLayoutY(new_rect.getLayoutY()-1);
                }
                if (new_rect.getHeight()>=151){
                    startMainGame.cherrywer = get_Cherry(new_rect,main_pane);
                    stop();
                }
            }
        };
        return new_rect;
    }

}

