import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class GUIClass extends GridPane
{
	 String username = null;
	 String password = null;
	 Person person = null;
	
	 BorderPane pane = null;
	 HBox button_box = null;
	 HBox field_box = null;
	 
	 Button login_btn;
	 Button register_btn = null;
	
	 TextField username_field = null;
	 TextField password_field = null;
	
	public GUIClass()
	{
		person = new Person(); 
		
		pane = new BorderPane();
		
		login_btn = new Button("Login");
		register_btn = new Button("Register");
		
		
		username_field = new TextField("Username");
		password_field = new TextField("Password");
		
		
		button_box = new HBox();
		field_box = new HBox();
		
		
		login_btn.setOnAction(e->{
		
		setLoginOnAction();
		
		});
		
		
		register_btn.setOnAction(e->{
			setRegisterOnAction();
		});
		
		
		button_box.getChildren().addAll(login_btn,register_btn);
		field_box.getChildren().addAll(username_field,password_field);
		pane.setCenter(field_box);
		pane.setBottom(button_box);
		this.getChildren().add(pane);
	}
	
	
	public boolean setLoginOnAction()
	{
			
			username = this.username_field.getText();
			password = this.password_field.getText();
			
			person.setUsername(username);
			person.setPassword(password);
	
		
		if(person.Login() == true)
		{
			System.out.println("Access Granted");
			return true;
		}else
		{
			System.out.println("Access Denied");
			return false;
		}
		
	}
	
	
	
	public boolean setRegisterOnAction()
	{			
			username = this.username_field.getText();
			password = this.password_field.getText();
			
			person.setUsername(username);
			person.setPassword(password);
		
		if(person.Register() == true)
		{
			System.out.println("User is Succesfuly registered");
			return true;
		}else
		{
			System.out.println("User already exists");
			return false;
		}
		
	}
	
	
}
