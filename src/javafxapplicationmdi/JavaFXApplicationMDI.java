package javafxapplicationmdi;

import br.com.supremeforever.suprememdiwindow.MDICanvas;
import br.com.supremeforever.suprememdiwindow.MDIWindow;
import controlador.variableGlobal;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javax.swing.JOptionPane;


public class JavaFXApplicationMDI extends Application {
    int i=1;
    String url="http://laweb.com/imagen1.jpg";
    MDIWindow mDIWindow;
    AnchorPane root;
    MDICanvas canvas;
    
    @Override
    public void start(Stage stage) throws Exception {
        canvas=new MDICanvas();
        canvas.setPrefSize(1000, 650);
          
        MenuBar menuBar = new MenuBar();
        
        //CLIENTES
        Menu menu1 = new Menu("Clientes");
        MenuItem menuItem10 = new MenuItem("Ver datos...");
        menu1.getItems().add(menuItem10);
        MenuItem menuItem11 = new MenuItem("Imprimir Informe...");
        menu1.getItems().add(menuItem11);
        menuBar.getMenus().add(menu1);
        
        //PROVEEDORES
        Menu menu2 = new Menu("Proveedores");
        MenuItem menuItem20 = new MenuItem("Ver datos...");
        menu2.getItems().add(menuItem20);
        MenuItem menuItem21 = new MenuItem("Imprimir Informe...");
        menu2.getItems().add(menuItem21);
        menuBar.getMenus().add(menu2);
        
        //EVENTOS EN LAS OPCIONES DE MENÚ.
        //Opción 1 de Clientes
        menuItem10.setOnAction(e -> { formularioFXML("FXMLDocument001MDI.fxml","CLIENTES"); });
           
        //Opción 1 de Proveedores
         menuItem20.setOnAction(e -> { formularioFXML("FXMLDocument002MDI.fxml","PROVEEDORES"); });
        
        //Idem para el resto de opciones de los menús.
        
        
        
        
        
        
        ////***********************************////////
        canvas.centerMdiWindow(mDIWindow);
        VBox box=new VBox(menuBar, canvas);
        AnchorPane.setBottomAnchor(box, 0d);
        AnchorPane.setTopAnchor(box, 0d);
        AnchorPane.setLeftAnchor(box, 0d);
        AnchorPane.setRightAnchor(box, 0d);

        AnchorPane pane=new AnchorPane(box);
        Scene scene = new Scene(pane);
                
        stage.setScene(scene);
        stage.show();
    }
        
    public void formularioFXML(String formulariofxml, String nombre)
    {
        try {
            
            new variableGlobal(3);
            
            root = FXMLLoader.load(getClass().getResource("/vista/"+formulariofxml));
            mDIWindow=new MDIWindow("myId"+i,new ImageView(url),nombre,root);
            canvas.addMDIWindow(mDIWindow);
            i++;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex,"Error.",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
