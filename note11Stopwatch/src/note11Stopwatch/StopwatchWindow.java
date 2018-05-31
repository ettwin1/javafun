package note11Stopwatch;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StopwatchWindow{

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		frame.setVisible(true);
		//long startTime = System.currentTimeMillis();
	}
	
}

class MainFrame extends JFrame{
	JButton start = new JButton("Start Timer");
	JLabel startLabel = new JLabel("Start Stystem Time");
	JTextField startBox = new JTextField();
	
	JButton stop = new JButton("Stop Timer");
	JLabel stopLabel = new JLabel("Stop Stystem Time");
	JTextField stopBox = new JTextField();
	
	long startTime;
	long stopTime;
	public MainFrame (){
		super("TITLE");
		super.setSize(640,480);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel North = new JPanel();
		super.add(North, BorderLayout.NORTH);
		North.add(start);
		North.add(startLabel);
		North.add(startBox);
		start.addActionListener(new StartListener());
		startBox.setPreferredSize(new Dimension(200,20));
		
		
		JPanel Center = new JPanel();
		super.add(Center, BorderLayout.CENTER);	
		Center.add(stop);
		Center.add(stopLabel);
		Center.add(stopBox);
		stop.addActionListener(new StopListener());
		stopBox.setPreferredSize(new Dimension(200,20));
		
		
		JPanel South = new JPanel();
		super.add(South, BorderLayout.SOUTH);
		
		JLabel secondLabel = new JLabel("Elapsed Time in Seconds: ");
		JTextField secondBox = new JTextField();
		South.add(secondLabel);
		South.add(secondBox);
		secondBox.setPreferredSize(new Dimension(200,20));
	}
	
	private class StartListener implements ActionListener{
		public void actionPerformed(ActionEvent evt) {
			Date startTimeStamp = new Date();
			startBox.setText(startTimeStamp.toString());
			startTime = System.currentTimeMillis();
		}
	}
	private class StopListener implements ActionListener{
		public void actionPerformed(ActionEvent evt) {
			Date stopTimeStamp = new Date();
			stopBox.setText(stopTimeStamp.toString());
			stopTime = System.currentTimeMillis();
			long finalTime = (stopTime - startTime);
			System.out.println(finalTime);
		}
	}
}
