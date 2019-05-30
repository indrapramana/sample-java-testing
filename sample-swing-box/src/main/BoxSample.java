package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BoxSample {

	public static void main(String[] args) {
		
		Runnable runner = new Runnable() {

			@Override
			public void run() {
				JFrame verticalFrame = new JFrame("Vertical");
				verticalFrame.setDefaultCloseOperation(verticalFrame.EXIT_ON_CLOSE);
				
				Box verticalBox = Box.createVerticalBox();
				verticalBox.add(new JLabel("Top"));
				verticalBox.add(new JTextField("Middle"));
				verticalBox.add(new JButton("Button"));
				
				verticalFrame.add(verticalBox, BorderLayout.CENTER);
				verticalFrame.setSize(150, 150);
				verticalFrame.setVisible(true);
				
				JFrame horizontalFrame = new JFrame("Horizontal");
				horizontalFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				Box horizontalBox = Box.createHorizontalBox();
				horizontalBox.add(new JLabel("Left"));
				horizontalBox.add(new JTextField("right"));
				
				horizontalFrame.add(horizontalBox);
				horizontalFrame.setSize(150, 150);
				horizontalFrame.setVisible(true);
			}
			
		};
		
		EventQueue.invokeLater(runner);
		
	}

}
