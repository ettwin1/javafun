import javax.swing.JFrame;

public class Swing1/*extended class*/ extends JFrame/*base class*/{
	public Swing1() {
		//call the base constructor
		super("My Window Title"); //this constructor sets the window title
		//Notice that "this" means the extended class, not the base
		this.setSize(800, 600);//Sets the size of window
		super.setSize(800, 600);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);//Closes when exited
		super.setVisible(true);//makes sure it's set to visible
	}
	
	public void setSize(int w, int h) {
		 System.out.println("hyooo");
	}
}
