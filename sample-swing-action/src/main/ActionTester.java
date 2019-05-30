package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ActionTester {

	public static void main(String[] args) {
		Runnable runner = new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				final Action printAction = new PrintHelloAction();
				
				JMenuBar menuBar = new JMenuBar();
				JMenu menu = new JMenu("File");
				menuBar.add(menu);
				menu.add(new JMenuItem(printAction));
				
				JToolBar toolbar = new JToolBar();
				toolbar.add(new JButton(printAction));
				
				JButton enableButton = new JButton("Enable");
				ActionListener enableActionListener = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent actionEvent) {
						printAction.setEnabled(true);						
					}
					
				};
				enableButton.addActionListener(enableActionListener);
				
				JButton disableButton = new JButton("Disable");
				ActionListener disableActionListener = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent actionEvent) {
						printAction.setEnabled(false);
					}
					
				};
				disableButton.addActionListener(disableActionListener);
				
				JButton relableButton = new JButton("Relable");
				ActionListener relableActionListener = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent actionEvent) {
						printAction.putValue(Action.NAME, "Hello World");
					}
					
				};
				relableButton.addActionListener(relableActionListener);
				
				JPanel buttonPanel = new JPanel();
				buttonPanel.add(enableButton);
				buttonPanel.add(disableButton);
				buttonPanel.add(relableButton);			
				
				frame.setJMenuBar(menuBar);
				
				frame.add(toolbar, BorderLayout.SOUTH);
				frame.add(buttonPanel, BorderLayout.NORTH);
				frame.setSize(300, 200);
				frame.setVisible(true);
			
			}
			
		};
		
		EventQueue.invokeLater(runner);
	}

}
