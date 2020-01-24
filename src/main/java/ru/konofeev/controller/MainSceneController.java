package ru.konofeev.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * Контроллер
 */
public class MainSceneController
{
    @FXML
    private Button mainButton;

    /**
     * Событие нажатия кнопки
     */
    @FXML
    private void buttonClicked()
    {
        mainButton.setText("Кнопка нажата");
    }

}
