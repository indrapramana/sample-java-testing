package main;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ProgressMonitor;
import javax.swing.Timer;

public class SampleProgress {

	static ProgressMonitor monitor;
	static int progress;
	static Timer timer;
	
	static class ProgressMonitorHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent actionEvent) {
			if (monitor == null) {
				return;
			}
			
			if (monitor.isCanceled()) {
				System.out.println("Monitor canceled");
				timer.stop();
			} else {
				progress += 3;
				monitor.setProgress(progress);
				monitor.setNote("Loaded " + progress + " files");
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		Runnable runner = new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new GridLayout (0, 1));
				
				JButton startButton = new JButton("Start");
				ActionListener startAction = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent actionEvent) {
						Component parent = (Component) actionEvent.getSource();
						monitor = new ProgressMonitor(parent, "Loading Progress", "Getting Started...", 0, 200);
						progress = 0;
					}
					
				};
				startButton.addActionListener(startAction);
				
				JButton increaseButton = new JButton("Manual Increase");
				ActionListener increaseAction = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent actionEvent) {
						if (monitor == null) {
							return;
						}
						
						if (monitor.isCanceled()) {
							System.out.println("Monitor canceled");
						} else {
							progress += 5;
							monitor.setProgress(progress);
							monitor.setNote("Loaded " + progress + " files");
						}
					}
					
				};
				increaseButton.addActionListener(increaseAction);
				
				JButton autoIncreaseButton = new JButton("Automatic Increase");
				ActionListener autoAction = new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent actionEvent) {
						if (monitor != null) {
							if (timer == null) {
								timer = new Timer(250, new ProgressMonitorHandler());
							}
							timer.start();
						}
					}
					
				};
				autoIncreaseButton.addActionListener(autoAction);
				
				frame.add(startButton);
				frame.add(increaseButton);
				frame.add(autoIncreaseButton);
				
				frame.setSize(300, 200);
				frame.setVisible(true);
				
			}
			
		};
		
		EventQueue.invokeLater(runner);

	}

}
