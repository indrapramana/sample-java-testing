package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.TransferHandler;

public class DragImage {

	public static void main(String[] args) {
		
		Runnable runner = new Runnable() {

			@Override
			public void run() {
				JFrame frame = new JFrame("Drag Image");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				Icon icon = new ImageIcon("pas-photo.jpg");
				JLabel label = new JLabel(icon);
				label.setTransferHandler(new ImageSelection());
				
				MouseListener listener = new MouseAdapter() {

					@Override
					public void mousePressed(MouseEvent me) {
						JComponent comp = (JComponent)me.getSource();
						TransferHandler handler = comp.getTransferHandler();
						handler.exportAsDrag(comp, me, TransferHandler.COPY);
					}
					
				};
				
				label.addMouseListener(listener);
				frame.add(new JScrollPane(label), BorderLayout.CENTER);
				
				frame.setSize(300, 150);
				frame.setVisible(true);
				
			}
			
		};
		
		EventQueue.invokeLater(runner);
	}

}
