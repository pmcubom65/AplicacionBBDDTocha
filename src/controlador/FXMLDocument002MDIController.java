package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FXMLDocument002MDIController implements Initializable {
    
   
    
    @FXML
    private Button button;
    
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        System.out.println("test test");
        
        
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/vista/FXMLPantallaFavoritos.fxml"));
            Parent nuevoparent = loader.load();
    /*        try {
                nuevoparent = loader.load();
            } catch (Exception e) {

            }*/
    
           
            Scene nuevaescena = new Scene(nuevoparent, 600, 800);

            FXMLPantallaFavoritosController micontrolador = loader.getController();

          

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setScene(nuevaescena);

            window.show();
        
        
        
        
                
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

 
    
}
