package org.openjfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {

    ObservableList<String> geschäftList = FXCollections.observableArrayList("Bäckerei", "Metzger", "Elektromarkt", "Kleidungeschäft");
    ObservableList<Artikel> artikelList = FXCollections.observableArrayList();
    @FXML
    TextField idField;
    @FXML
    TextField artikelField;
    @FXML
    ComboBox<String> GeschäftComboBox;
    @FXML
    TableView tableArtikel;
    @FXML
    TableColumn columnID;
    @FXML
    TableColumn columnArtikel;
    @FXML
    TableColumn columnGeschäft;



    @FXML
    private void addArtikel()
    {
        int id = Integer.parseInt(this.idField.getText());
        String name = this.artikelField.getText();
        String geschäft = this.GeschäftComboBox.getValue();
        if (!name.isBlank())
        {
            artikelList.add(new Artikel(id, name, geschäft));
            artikelField.setText("");
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setContentText("Bitte wählen sie einen Artikel Namen!");
            alert.showAndWait();
        }


    }

    @FXML
    private void deleteSelectedArtikel()
    {
        int i = 0;
        Artikel artikelToDelete = (Artikel) tableArtikel.getSelectionModel().getSelectedItem();
        if(artikelToDelete != null)
        {
            for(Artikel artikel : artikelList)
            {
                if (artikelToDelete.getName().equals(artikel.getName()))
                {
                    artikelList.remove(i);
                    GeschäftComboBox.setValue("Kein Geschäft");
                    GeschäftComboBox.setItems(geschäftList);
                    columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
                    columnArtikel.setCellValueFactory(new PropertyValueFactory<>("name"));
                    columnGeschäft.setCellValueFactory(new PropertyValueFactory<>("geschäft"));
                    tableArtikel.setItems(artikelList);
                }
                i++;
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Information Dialog");
            alert.setContentText("Artikel nicht Gefunden!");
            alert.showAndWait();
        }
    }

    @FXML
    private void initialize()
    {
        GeschäftComboBox.setValue("Kein Geschäft");
        GeschäftComboBox.setItems(geschäftList);
        columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnArtikel.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnGeschäft.setCellValueFactory(new PropertyValueFactory<>("geschäft"));

        artikelList.add(new Artikel(1,"Brot", "Bäckerei"));
        artikelList.add(new Artikel(2,"Fleisch", "Metzger"));
        artikelList.add(new Artikel(3,"Handy", "Elektromarkt"));
        artikelList.add(new Artikel(4,"Schuhe", "Kleidungeschäft"));

        tableArtikel.setItems(artikelList);
    }

}
