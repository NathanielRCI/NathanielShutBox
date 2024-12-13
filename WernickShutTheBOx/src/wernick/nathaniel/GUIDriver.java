package wernick.nathaniel;

import wernick.nathaniel.Tile;

import com.sun.javafx.geom.Shape;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GUIDriver extends Application {

	Die d1 = new Die();
	Die d2 = new Die();
	
	@Override
	public void start(Stage stage) throws Exception {
		VBox vbox = new VBox(10);
		Button [] selection = new Button[2];
		// Create and display the title
		Label title = new Label("Shut The Box");
		vbox.getChildren().add(title);
		
		HBox tileBox = new HBox(10);
		
		Button[] tileBtns = new Button[9];
		Tile[] tiles = new Tile[9];
		
		for (int i=0; i<tileBtns.length; i++) {
			tileBtns[i] = new Button(String.valueOf(i+1));
			tileBtns[i].setStyle("-fx-background-color: lightgrey;");
			tiles[i] = new Tile(i+1);
			tileBox.getChildren().add(tileBtns[i]);
		}
		tileBox.setAlignment(Pos.CENTER);
		vbox.getChildren().add(tileBox);
		Button lockIn = new Button("LOCK IN");
		Button btnRoll = new Button("ROLL DICE");
		Button btnRollOne = new Button("ROLL DIE");
		Label result = new Label("Result");
		Label rollDice = new Label("roll die please");
		Label lblValue = new Label(""); // output of results
		Label lblOneValue = new Label(""); // output of results
		vbox.getChildren().addAll(btnRollOne, btnRoll,result,lblValue, lblOneValue, lockIn, rollDice);
		vbox.setAlignment(Pos.CENTER);
		btnRollOne.setDisable(true);
		
		btnRoll.setOnAction(e -> {
			if (lblValue.getText().equals("")) {
				lblValue.setText(String.valueOf(d1.roll()+d2.roll()));
				rollDice.setVisible(false);
			}
			else {
				rollDice.setVisible(true);
			}
			
		});
		
		btnRollOne.setOnAction(e ->{

			lblValue.setText(String.valueOf(d1.roll()));
			}
		);
		
		for(Button b: tileBtns) {
			b.setOnMouseClicked(e ->{
			if(b.getStyle().equals("-fx-background-color: lightgrey;")) {
				b.setStyle("-fx-background-color: seagreen;");
				
				
			}
			else {
				b.setStyle("-fx-background-color: lightgrey;");
			}
				

		});
		}
		lockIn.setOnMouseClicked(e ->{
			if(! lblValue.getText().equals("")) {	
				if (stringToInt(lblValue.getText()) == findSum(tileBtns)){
					disableButtons(tileBtns, tiles);
					lblValue.setText("");
					if (tileBtns[6].isDisabled() && tileBtns[7].isDisabled() && tileBtns[8].isDisabled()) {
						btnRollOne.setDisable(false);
						
					}
				}
				else {
					deselectAll(tileBtns);
					
				}
		}
			else {
				deselectAll(tileBtns);
			}
		}
			);
		
		
		Scene scene = new Scene(vbox,500,400);
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
		
	}
	
	public static int findSum(Button [] b) {
		int sum = 0; 
		for (Button button: b) {
			if (button.getStyle().equals("-fx-background-color: seagreen;") && ! button.isDisable()){
				sum += stringToInt(button.getText());
			
			}
			
			
		}
		System.out.println(sum);
		return sum;
		
	}
	
	public static void deselectAll(Button [] b) {
		for (Button button: b) {
			button.setStyle("-fx-background-color: lightgrey");
		}
	}
	
	public static int stringToInt(String str) {
		int result  = 0;
		
		for(int i = 0; i <  str.length(); i++) {
			result = result *10 + (str.charAt(i) - '0');
		}
		return result;
 		

	}
	
	public static void disableButtons(Button [] b, Tile [] tiles) {
		for (Button button: b) {
			if (button.getStyle().equals("-fx-background-color: seagreen;")){
				button.setDisable(true);
				button.setStyle("-fx-background-color: lightgrey;");
				tiles[stringToInt(button.getText())-1].putDown();
			}
				
		}
	}
	
}
