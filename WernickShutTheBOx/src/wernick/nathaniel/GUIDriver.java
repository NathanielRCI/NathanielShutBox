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
	Round round = new Round();

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
		Button doneTurn = new Button("done turn");
		Button btnRollOne = new Button("ROLL DIE");
		
		Label p1Score = new Label("p1 Score");
		Label p2Score = new Label("p2 Score");
		
		Label winner = new Label("the winner is...");


		Label result = new Label("Result");
		Label rollDice = new Label("roll die please a min and max time of 1x");
		Label lblValue = new Label(""); // output of results
		Label lblOneValue = new Label(""); // output of results
		vbox.getChildren().addAll(btnRollOne, btnRoll,result,lblValue, lblOneValue, lockIn, rollDice, doneTurn, p1Score, p2Score, winner);
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

			if (lblValue.getText().equals("")) {
				lblValue.setText(String.valueOf(d2.roll()));
				rollDice.setVisible(false);
			}
			else {
				rollDice.setVisible(true);
			}
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
		
		
		doneTurn.setOnAction(e ->{
			if(round.getP1Turn()) {
				round.addScoreP1(getScore(tileBtns));
				round.setP1Turn(false);
				p1Score.setText("p1 score : "+ round.getScore1() + "");
			}
			else {
				round.addScoreP2(getScore(tileBtns));
				round.setP1Turn(true);
				p1Score.setText("p2 score : "+round.getScore2() + "");
			}
			round.next();
			reset(tileBtns, lblValue);
			if (round.getRound() == 5) {
				if (round.getScore1() < round.getScore2()) {
					winner.setText("winner is player 2!");
				}
				if(round.getScore1() < round.getScore2()) {
					winner.setText("winner is player 1!");
				}
				else {
					winner.setText("It's a draw!");
				}
			}
			
			
		}
		);
		
		
		Scene scene = new Scene(vbox,500,600);
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
	public static int getScore(Button [] b) {
		int score = 0; 
		for (Button button: b) {
			if (! button.isDisable()){
				score += stringToInt(button.getText());
			
			}
			
			
		}
		System.out.println(score);
		return score;
		
	}
	public static void reset(Button [] b, Label value) {
		for (Button button: b) {
			button.setStyle("-fx-background-color: lightgrey");
			button.setDisable(false);
			value.setText("");
		}
	}
	
}
