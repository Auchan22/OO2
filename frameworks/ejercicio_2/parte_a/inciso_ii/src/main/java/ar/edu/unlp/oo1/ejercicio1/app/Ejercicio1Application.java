package ar.edu.unlp.oo1.ejercicio1.app;

import java.io.IOException;
import java.util.logging.*;

import javax.swing.SwingUtilities;

import ar.edu.unlp.oo1.ejercicio1.ui.WallPostUI;

public class Ejercicio1Application {

	private static Logger logger = Logger.getLogger("app");
	
	public static void main(String[] args) throws SecurityException, IOException {
		Handler fileHandler = new FileHandler("resources/logs/logs.txt");
		fileHandler.setFormatter(new SimpleFormatter());
		logger.addHandler(fileHandler);
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				logger.info("Inicio de aplicacion...");
				new WallPostUI();
			}
		});
	}

}
