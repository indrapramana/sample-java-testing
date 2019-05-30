package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FileSamplePanel {

	public static void main(String[] args) {
		
		Runnable runner = new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame("JFile Chooser Popup");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				final JLabel directoryLabel = new JLabel(" ");
				directoryLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 36));
				
				final JLabel filenamelabel = new JLabel(" ");
				filenamelabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 36));
			
				
				JFileChooser fileChooser = new JFileChooser(".");
				fileChooser.setControlButtonsAreShown(true);
				
				ActionListener actionListener = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent actionEvent) {
						JFileChooser fileChooser = (JFileChooser)actionEvent.getSource();
						String command = actionEvent.getActionCommand();
						
						if (command.equals(JFileChooser.APPROVE_SELECTION)) {
							File selectedFile = fileChooser.getSelectedFile();
							directoryLabel.setText(selectedFile.getParent());
							filenamelabel.setText(selectedFile.getName());
						} else if (command.equals(JFileChooser.CANCEL_SELECTION)) {
							directoryLabel.setText(" ");
							filenamelabel.setText(" ");
						}
					}
					
				};
				
				fileChooser.addActionListener(actionListener);
				
				frame.add(directoryLabel, BorderLayout.NORTH);
				frame.add(filenamelabel, BorderLayout.SOUTH);
				frame.add(fileChooser, BorderLayout.CENTER);
				
				frame.pack();
				frame.setVisible(true);
				
			}
			
		};
		
		EventQueue.invokeLater(runner);
	}

}
