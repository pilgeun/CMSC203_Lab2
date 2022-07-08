


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	//  declare two HBoxes
	
	//student Task #4:
	//  declare an instance of DataManager
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		//  instantiate the HBoxes
		
		Button btn1 = new Button("Hello"),
				btn2 = new Button("Howdy"),
				btn3 = new Button("Chinese"),
				btn4 = new Button("Clear"),
				btn5 = new Button("Exit");
		Button b6 = new Button("Korean");	//Task #4 JUST FOR FUN
		 
		Label feedbackLabel = new Label("Feedback");
		TextField textField = new TextField();
		 
		HBox hBox1 = new HBox(),
			 hBox2 = new HBox();
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		//  add the buttons to the other HBox
		//  add the HBoxes to this FXMainPanel (a VBox)
		
		hBox1.getChildren().addAll(btn1, btn2, btn3, btn4, btn5, b6);
		hBox2.getChildren().addAll(feedbackLabel, textField);
		
				getChildren().addAll(hBox1, hBox2);
		
		//student Task #4:
		//  instantiate the DataManager instance
		//  set margins and set alignment of the components
		
		DataManager dataManager = new DataManager();
		Insets inset = new Insets(10);
		
		HBox.setMargin(btn1, inset);
		HBox.setMargin(btn2, inset);
		HBox.setMargin(btn3, inset);
		HBox.setMargin(btn4, inset);
		HBox.setMargin(btn5, inset);
		HBox.setMargin(feedbackLabel, inset);
		HBox.setMargin(textField, inset);
		
		hBox1.setAlignment(Pos.CENTER);
		hBox2.setAlignment(Pos.CENTER);
		
		class ButtonHandler implements EventHandler<ActionEvent>
		{
			@Override
			public void handle(ActionEvent event) {
				if (event.getTarget()==btn1) 
					textField.setText(dataManager.getHello());
				
				else if (event.getTarget()==btn2)
					textField.setText(dataManager.getHowdy());
				
				else if (event.getTarget()==btn3)
					textField.setText(dataManager.getChinese());
				
				else if (event.getTarget()==btn4)
					textField.setText("");
				
				else if (event.getTarget()==btn5) 
				{
					Platform.exit();
					System.exit(0);
				}
				//Task #4 JUST FOR FUN
				else if (event.getTarget()==b6)
					textField.setText(dataManager.getKorean());
	        }
		}
		
		btn1.setOnAction(new ButtonHandler());
		btn2.setOnAction(new ButtonHandler());
		btn3.setOnAction(new ButtonHandler());
		btn4.setOnAction(new ButtonHandler());
		btn5.setOnAction(new ButtonHandler());
		//Task #4 JUST FOR FUN
		b6.setOnAction(new ButtonHandler());

	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	
	
}
	
