package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class Controller {
    @FXML
    PieChart pieChart;
    @FXML
    Label status;

    public void btn1(ActionEvent event) {
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList(
                new PieChart.Data("Java", 50),
                new PieChart.Data("c++", 20),
                new PieChart.Data("python", 30),
                new PieChart.Data("c#", 10),
                new PieChart.Data("c", 15)
        );
        pieChart.setData(list);

        for (final PieChart.Data data : pieChart.getData()) {
            data.getNode().addEventHandler(javafx.scene.input.MouseEvent.MOUSE_CLICKED, (EventHandler<MouseEvent>) mouseEvent -> status.setText(String.valueOf(data.getPieValue()) + "%"));
        }
    }
}