import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args)
	{
		launch(args);
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		GUIClass gui = new GUIClass();
		Scene scene =new Scene(gui,300,300);
		primaryStage.setScene(scene);
		primaryStage.setTitle("User Interface");
		primaryStage.show();
		
	}

}
