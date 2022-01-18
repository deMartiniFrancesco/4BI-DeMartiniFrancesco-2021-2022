package demartini_F_Swing_01.bin;

import javax.swing.*;
import java.awt.*;
import java.io.File;

class Swing_01 extends JFrame {

	public Swing_01() {
		super("Titolo del frame"); // richiama il costruttore della superclasse Jframe passando come parametro la
		// stringa da visualizzare sulla barra del titolo

		setSize(500, 300); // impostiamo le dimensioni del frame LARGHEZZA , ALTEZZA in pixel

		setLayout(new GridLayout(0, 3));

		Container green = new Container();
		green.setBackground(Color.red);

		Container white = new Container();
		white.setBackground(Color.red);

		Container red = new Container();
		red.setBackground(Color.red);

		add(green, 0);
		add(white, 1);
		add(red, 2);




		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // associamo l'evento di chiusura al solito bottone di chiusura

		setVisible(true); // rendiamo il frame visibile dato che per default non lo è!



	}



}

class Swing_01Test {
	public static void main(String[] args) {

		System.out.println("Start");

		//		CALCOLO PATH RELATIVO UNIVERSALE
		//----------------------------------------------------------------------
		String tempPath = new File(
				String.valueOf(Swing_01.class.getPackage()).replace("package ", "").replace(".", "/")
		).getParent();
		File uesrPath = new File(System.getProperty("user.dir"));
		String projectPath = uesrPath.getName().equals(tempPath) ?
				uesrPath.getPath() :
				new File(uesrPath.getPath() + "/src").exists() ?
						uesrPath.getPath() + "/src/" + tempPath :
						uesrPath.getPath() + tempPath;
		//----------------------------------------------------------------------

		// COSTANTI
		String resursesPath = "/file/";

		Swing_01 swing01 = new Swing_01();

		System.out.println("End");

	}
}