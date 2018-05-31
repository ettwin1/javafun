import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ListenToMe{

	public static void main(String[] args) {
		Frame mainFrame = new Frame();
		mainFrame.showIt();
	}

}

class Frame extends JFrame{
	public Frame(){
		//Constructor
		super("Listener Stuff");
		super.setSize(800, 600);//Sets the size of window
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);//Closes when exited	
		
		//Top Panel
		PushCounterPanel panel1 = new PushCounterPanel();
		super.add(panel1, BorderLayout.NORTH);
		panel1.setBackground(Color.PINK);
		
		//Center Panel
		Punch panel2 = new Punch();
		super.add(panel2, BorderLayout.CENTER);
		panel2.setBackground(Color.CYAN);
		
		//Bottom Panel
		Conversion panel3 = new Conversion();
		super.add(panel3, BorderLayout.SOUTH);
		panel3.setBackground(Color.GREEN);
	}
	
	public void showIt(){
		super.setVisible(true);//makes sure it's set to visible
	}
}

class PushCounterPanel extends JPanel{
	private int count = 0;
	private JButton button1;
	private JLabel label1;
	
	public PushCounterPanel() {
		 button1 = new JButton("Push Me");
		 label1 = new JLabel("Pushes: 0");
		 button1.addActionListener(new ButtonListener());
		 super.add(button1);
		 super.add(label1);
	}
	//include class to say when button pressed
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			count += 1;
			label1.setText("Pushes: "+count);
		}
	}
	
}


class Punch extends JPanel{
	private JButton button1;
	private JButton button2;
	private JLabel label1;
	public Punch() {
		button1 = new JButton("Left");
		button1.addActionListener(new ButtonListener());
		button2 = new JButton("Right");
		button2.addActionListener(new ButtonListener2());
		label1 = new JLabel("Update me");

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10,5,10,5); //top, left, bottom, right margins
		gbc.gridx = 1;
		gbc.gridy = 0;
		super.add(label1, gbc);
		gbc.gridx = 0;
		gbc.gridy = 1;
		super.add(button1, gbc);
		gbc.gridx = 2;
		super.add(button2, gbc);
		
	}
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			label1.setText("LEFT");
		}
	}
	private class ButtonListener2 implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			label1.setText("RIGHT");
		}
	}
}


class Conversion extends JPanel{
	private JTextField textbox;
	private JLabel label1;
	private JLabel label2;
	private int far;
	private int cel;
	public Conversion() {
		textbox = new JTextField();
		textbox.addActionListener(new TextEntered());
		label1 = new JLabel("Enter Temperature in Fahrenheit ");
		label2 = new JLabel("Temperature in Celsies: --");
		
		super.add(label1);
		super.add(textbox);
		super.add(label2);
		textbox.setPreferredSize(new Dimension(40,20));
	}
	private class TextEntered implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			far = Integer.parseInt(textbox.getText());
			cel = 5*(far-32)/9;
			label2.setText("Temperature in Celsies: "+cel);
		}
	}
}