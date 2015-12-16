package ca.uqam.inf2120.tp3.test;

import ca.uqam.inf2120.tp3.interfacegraphiques.*;
import ca.uqam.inf2120.tp3.modele.*;
import javax.swing.SwingUtilities;

public class MainApplication {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				
				InterfacePrincipale frame = new InterfacePrincipale();
				frame.setVisible(true);
//				Model model = new Model(0);
//				View view = new View("-");
//				Controller controller = new Controller(model, view);
//				controller.contol();
				
			}
		});
	}

}
