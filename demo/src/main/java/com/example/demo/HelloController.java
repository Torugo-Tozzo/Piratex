package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

import javafx.scene.media.MediaView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

public class HelloController {
    @FXML
    private Label welcomeText;
    private MediaPlayer mediaPlayer;

    private MediaView mediaView;


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to Piratex,\nmy JavaFX Application!");
    }

    @FXML
    protected void sairApp() {
        System.exit(0);
    }

    public void buscarPasta() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select a folder");
        File selectedFolder = directoryChooser.showDialog(new Stage());
        if (selectedFolder != null) {
            System.out.println(selectedFolder.getAbsolutePath()); // mostra o caminho da pasta selecionada
        }
    }


    @FXML
    protected void selectFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Selecione um arquivo de áudio");
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            System.out.println("Arquivo selecionado: " + selectedFile.getName());
            Media media = new Media(selectedFile.toURI().toString());
            mediaPlayer = new MediaPlayer(media);
        }
    }

    public void playAudio() {
        if (mediaPlayer != null) {
            mediaPlayer.play();
        }
    }

    public void pauseAudio() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    public void skipAudio() {
        if (mediaPlayer != null) {
            mediaPlayer.seek(mediaPlayer.getCurrentTime().add(Duration.seconds(10)));
        }
    }

    public void setMediaView(MediaView mediaView) {
        this.mediaView = mediaView;
    }

}