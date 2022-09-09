package com.example.generalpricelist;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;


import java.net.URL;
import java.util.ResourceBundle;

public class ChargesController  implements Initializable {

    @FXML
    private TableView<Animal> animals;

    @FXML
    private TableColumn<Animal, Integer> idCol;

    @FXML
    private TableColumn<Animal, String> descriptionCol;

    @FXML
    private TableColumn<Animal, String> nameCol;

    @FXML
    private TableColumn<Animal, Integer> priceCol;

  //  @FXML
   // private TableColumn<Animal, Integer> quaCol;

    @FXML
    private TextField inputDescription;

    @FXML
    private TextField inputName;

    @FXML
    private TextField inputPrice;

    @FXML
    private Text newAnimalText;

    //Animal id is set to -1 when no animal is picked
    private int pickedAnimalId = -1;

    private boolean isNewAnimal = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idCol.setCellValueFactory(new PropertyValueFactory<Animal, Integer>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<Animal, String>("name"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<Animal, String>("description"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Animal, Integer>("price"));
        setupTable();
    }
    @FXML
    void submit(ActionEvent event) {

        ObservableList<Animal> currentTableData = animals.getItems();

        //New Animal is being created
        if(isNewAnimal){
            //find id order
            Animal newAnimal = new Animal(inputName.getText(),
                    inputDescription.getText(),
                    setAnimalPrice( inputPrice.getText()),
                    findNextId());
            //New animal process is no longer active
            isNewAnimal = false;

            currentTableData.add(newAnimal);
            animals.setItems(currentTableData);
            animals.refresh();
            newAnimalText.setText("");
            pickedAnimalId = newAnimal.getId();

            return;
        }

        //Picked animal is being changed
        int currentAnimalId = pickedAnimalId;

        for (Animal animal : currentTableData) {
            if(animal.getId() == currentAnimalId) {
                animal.setDescription(inputDescription.getText());
                animal.setName(inputName.getText());
                animal.setPrice(setAnimalPrice( inputPrice.getText()));

                animals.setItems(currentTableData);
                animals.refresh();
                break;
            }
        }
    }

    @FXML
    void rowClicked(MouseEvent event) {
        //If row is clicked new animal process is canceled
        isNewAnimal = false;
        newAnimalText.setText("");

        Animal clickedAnimal = animals.getSelectionModel().getSelectedItem();
        inputName.setText(String.valueOf(clickedAnimal.getName()));
        inputDescription.setText(String.valueOf(clickedAnimal.getDescription()));
        inputPrice.setText(clickedAnimal.getPrice().substring(1));
        pickedAnimalId = clickedAnimal.getId();
    }

    @FXML
    void createNewAnimal(ActionEvent event) {
        inputPrice.clear();
        inputName.clear();
        inputDescription.clear();
        isNewAnimal = true;
        newAnimalText.setText("New Casket is being created");
    }

    private void setupTable(){
        Animal animal0 = new Animal("WeatherWood","Solid Oak, Weather Finish, Duck Cloth","$4685", 0);
        Animal animal1 = new Animal("Langley Pine","Solid Pine, Beige Linwood Interior","$3980", 1);
        Animal animal2 = new Animal("Floral","Steel, Taupe, White Velvet Interior","$3790", 2);
        Animal animal3 = new Animal("Veteran","Midnight Blue, Blue Cotton Interior","$3475", 3);
        Animal animal4 = new Animal("Pacific Beige","18ga steel, Beige, Rosetan Bellaire Crepe Interior","$3290", 4);
        Animal animal5 = new Animal("Indigo Blue","18ga steel, Blue Indigo, Flesh Interior","$3,230", 5);
        Animal animal6 = new Animal("Ebony","18ga steel, Ebony, Silver Crepe Interior","$3,190", 6);
        Animal animal7 = new Animal("Kristen","20ga steel, Sealer, Blue Shaded Silver, Blue Interior","$2,970", 7);
        Animal animal8 = new Animal("Silver Edge","20gal steel, Gunmetal w/ Silver Shading, Tremaine Crepe Interior","$2,850", 8);
        Animal animal9 = new Animal("Morning Mist","20gal steel, White w/Pink Shading, Pink Crepe Interior ","$2,790", 9);
        Animal animal10 = new Animal("SilverLand","20gal steel, Silver, Light Blue or Flesh Interior","$2,775", 10);
        Animal animal11 = new Animal("Neoblue","20gal steel, Dark Blue, White Crepe Interior","$2,680", 11);
        Animal animal12 = new Animal("New Silver","20gal steel, Silver, Drexel Crepe Interior","$2,585", 12);
        Animal animal13 = new Animal("Variety","20gal steel, Various Colors, Crepe Interior","$2,515", 13);
        Animal animal14 = new Animal("Benjamin","20gal steel, Silver, Elco Crepe Interior","$2,190", 14);
        Animal animal15 = new Animal("Ashley","20gal steel, Gray, White Crepe Interior","$1,975", 15);
        Animal animal16 = new Animal("Buckley","Wood, Cloth Covered, Crepe Interior","$1,330", 16);
        Animal animal17 = new Animal("Cremation Rental","Solid Oak, w/insert having Beige Crepe Interior","$895", 17);
        Animal animal18 = new Animal("Alternative Container","Fiberboard, No interior","$75", 18);
        animals.getItems().addAll(animal0,animal1,animal2,animal3,animal4,animal5,animal6,animal7,animal8,animal9,animal10,animal11,animal12,animal13
                ,animal14,animal15,animal16,animal17,animal18);
    }

    //Price value interval checked
    private String setAnimalPrice( String price){
        int priceValue = Integer.parseInt(price);

        if(priceValue < 5){
            priceValue = 5;
        } else if(priceValue > 2000){
            priceValue = 2000;
        }

        return "$" + priceValue;
    }

    private int findNextId(){
        int maxId = 0;
        for (Animal animal: animals.getItems()) {
            if(animal.getId() > maxId){
                maxId = animal.getId();
            }
        }
        return ++maxId;
    }
}