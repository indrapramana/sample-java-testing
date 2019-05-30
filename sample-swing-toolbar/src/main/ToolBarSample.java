package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

public class ToolBarSample {

	private static final int COLOR_POSITION = 0;
	private static final int STRING_POSITION = 1;
	
	static Object buttonColors[][] = {
		{Color.RED, "RED"},
		{Color.BLUE, "BLUE"},
		{Color.GREEN, "GREEN"},
		{Color.BLACK, "BLACK"}, 
		null,
		{Color.CYAN, "CYAN"}
	};
	
	public static class TheActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			System.out.println(actionEvent.getActionCommand());
		}
		
	};
	
	public static void main(String[] args) {
		Runnable runner = new Runnable() {

			@Override
			public void run() {
				
				JFrame frame = new JFrame("JToolBar Example");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				ActionListener actionListener = new TheActionListener();
				
				JToolBar toolbar = new JToolBar();
				toolbar.setRollover(true);
				
				for (Object[] color: buttonColors) {
					if (color == null) {
						toolbar.addSeparator();
					} else {
						//Icon icon = new DiamondIcon((Color)color[COLOR_POSITION], true, 20, 20);
						JButton button = new JButton("");
						button.setActionCommand((String)color[STRING_POSITION]);
						button.addActionListener(actionListener);
						toolbar.add(button);
					}
				}
				
				//Action action = new Action(frame);
				JButton button = new JButton();
				toolbar.add(button);
				
				Container contentPane = frame.getContentPane();
				contentPane.add(toolbar, BorderLayout.NORTH);
				
				JTextArea textArea = new JTextArea();
				JScrollPane scrollPane = new JScrollPane(textArea);
				contentPane.add(scrollPane, BorderLayout.CENTER);
				
				frame.setSize(350, 150);
				frame.setVisible(true);
				
			}
			
		};
		
		EventQueue.invokeLater(runner);

	}

}
