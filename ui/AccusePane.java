package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;

import model.Card;

/**
 * Altered and updated code from the SuggestionPane class.
 * 
 * Added functionality to so that user can only enter valid choices.
 * 
 * Prevents typos from getting people kicked from the game.
 * 
 * @author Noah Poczciwinski
 * @author Joseph Soares
 *
 */

public class AccusePane extends JTextField {
	UI _ui;
	int _state = 0;
	ArrayList<String> _inputs = new ArrayList<String>();
	
	
	/**
	 * Necessary because inside an anon. inner class, 'this' will not refer to the SuggestionPane.
	 */
	AccusePane _self = this;
	
	public AccusePane(UI ui) {
		
		_ui = ui;
		this.setEnabled(false);
		
		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String input = e.getActionCommand();
				
				switch (_state) {
				
					case 0:
						
						_self.setText("");
						if(ui._game.getPossibleWeapons().toString().contains(input)){
							_state++;
							System.out.println("Valid Entry");
							_inputs.add(input);
							_ui.displayInstruction("Please enter the room.");
							
						}
						else{
							System.out.println("Invalid Weapon");
							ui.displayMessage("Invalid Weapon!");
							_state = 0;
						}
						
						break;
						
					case 1:
						
						_self.setText("");
						if(ui._game.getPossibleRoom().toString().contains(input)){
							_state++;
							System.out.println("Valid Entry");
							_inputs.add(input);
							_ui.displayInstruction("Please enter the Player name.");
							
						}
						else{
							System.out.println("Invalid Room!");
							ui.displayMessage("Invalid Room!");
							_state = 1;
						}
						break;
						
					case 2:
						
						_self.setText("");
						if(ui._game.getPossiblePlayers().toString().contains(input)){
							_state++;
						//	_state = 0;
							System.out.println("Valid Entry");
						_inputs.add(input);
//						_self.setEnabled(false);
//						_ui.passAccusation(_inputs);
						System.out.println(_inputs);
						ui.displayMessage("Your accusation is " +_inputs +"." + "Y/N?");
						}
						else{
							System.out.println("Invalid Player");
							ui.displayMessage("Invalid Player!");
							_state = 2;
						}
						
					
						break;
						
					case 3:
					//	_state = 0;
						_self.setText("");
						if(input.equals("Yes") || input.equals("Y")){
							_self.setEnabled(false);
							_ui.passAccusation(_inputs);
							_state=0;
						}
						else{
							_state=0;
							ui.displayMessage("Resetting Accusation");
							_inputs.clear();
							_ui.displayInstruction("Please enter the weapon.");
							
						}
				
				}
				
			}
		});
	}
	
	public void grabAccusationInput() {
		_state = 0;
		_inputs = new ArrayList<String>();
		this.setEnabled(true);
		_ui.displayInstruction("Please enter the weapon.");
	}
}


