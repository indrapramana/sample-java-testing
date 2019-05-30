package main;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class PrintHelloAction extends AbstractAction {
	
	private static final Icon printIcon = new ImageIcon("Print.gif");
	
	public PrintHelloAction() {
		super("Print", printIcon);
		putValue(Action.SHORT_DESCRIPTION, "Hello, World");
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		System.out.println("Hello, World");
	}

}
