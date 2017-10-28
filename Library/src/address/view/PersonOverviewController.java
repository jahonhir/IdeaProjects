package address.view;


import address.MainApp;
import address.util.DateUtil;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import address.model.Person;



public class PersonOverviewController {

    @FXML
    private TableView<Person> personTable;


    @FXML
    private TableColumn<Person, String> firstNameColumn;


    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label streetLabel;

    @FXML
    private Label postalCodeLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label birthdayLabel;


    //ссылка на главное приложение.
    private MainApp mainApp;


    public PersonOverviewController() {
    }

    /* Инициализация класса контроллера. Этот метод вызывается автоматически
    после того, как fxml - файл будет загружен.
     */

    @FXML
    private  void  initialize(){
        //Инициализация таблицы адресатов с двумя столбцами.
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

        // Очистка дополнительной информации об адресате
        showPersonDetails(null);

        // Слушаем изменение выбора, и при изменении отображаем
        // дополнительную информауию об адресате

        personTable.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) ->showPersonDetails(newValue) );
    }

    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;

        personTable.setItems(mainApp.getPersonData());
    }


   private void showPersonDetails(Person person){
       if(person != null ) {
           firstNameLabel.setText(person.getFirstName());
           lastNameLabel.setText(person.getLastName());
           streetLabel.setText(person.getStreet());
           postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
           cityLabel.setText(person.getCity());
           birthdayLabel.setText(DateUtil.format(person.getBirthday()));
       } else {
           firstNameLabel.setText("");
           lastNameLabel.setText("");
           streetLabel.setText("");
           postalCodeLabel.setText("");
           cityLabel.setText("");
           birthdayLabel.setText("");

       }

   }

   @FXML
    private void handleDeletePerson() {
       int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
       if(selectedIndex >= 0){
       personTable.getItems().remove(selectedIndex);
   }
   else {
           //Ничего не выбрано
           Alert alert = new Alert(Alert.AlertType.WARNING);
           alert.initOwner(mainApp.getPrimaryStage());
           alert.setTitle("No Selection");
           alert.setHeaderText("No Person Selected");
           alert.setContentText("Please select a person in the table.");
           alert.showAndWait();
       }
   }

   // вызывается когда пользователь кликает по кнопке New
   // открывает диалоговое окно с дополнительной информацией нового адресата
   @FXML
    private void handleNewPerson(){
       Person tempPerson = new Person();
       boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
       if(okClicked){
           mainApp.getPersonData().addAll(tempPerson);
       }
   }

   @FXML
    private void handleEditPerson(){
       Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
       if(selectedPerson != null) {
           boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);

           if (okClicked) {
               showPersonDetails(selectedPerson);
           }
       } else {
           // Ничего не выбрано.
           Alert alert = new Alert(Alert.AlertType.WARNING);
           alert.initOwner(mainApp.getPrimaryStage());
           alert.setTitle("No Selection");
           alert.setHeaderText("No Person Selected");
           alert.setContentText("Please select a person in the table.");

           alert.showAndWait();
       }
   }


}
