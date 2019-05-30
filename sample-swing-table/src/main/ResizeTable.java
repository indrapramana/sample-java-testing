package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ResizeTable {

	public static void main(String[] args) {
		
		final Object rowData[][] = {
			{"1", "one", "ichi - \u4E00", "un", "I"},
			{"2", "two", "ni - \u4E8c", "deux", "II"},
			{"3", "three", "san - \u4E09", "trois", "III"},
			{"4", "four", "shi - \u56DB", "quatre", "IV"}
		};
		
		final String columnNames[] = {"#", "English", "Japanese", "French", "Roman"};
		
		Runnable runner = new Runnable() {

			@Override
			public void run() {
				final JTable table = new JTable(rowData, columnNames);
				JScrollPane scrollPane = new JScrollPane(table);
				
				String modes[] = {"Resize all columns", "Resize last column", 
						"Resize next column", "Resize off", 
						"Resize subsequence column"};
				final int modeKey[] = {
					JTable.AUTO_RESIZE_ALL_COLUMNS, JTable.AUTO_RESIZE_LAST_COLUMN,
					JTable.AUTO_RESIZE_NEXT_COLUMN, JTable.AUTO_RESIZE_OFF,
					JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS
				};
				
				JComboBox resizeModeComboBox = new JComboBox(modes);
				int defaultMode = 4;
				table.setAutoResizeMode(modeKey[defaultMode]);
				resizeModeComboBox.setSelectedIndex(defaultMode);
				
				ItemListener itemListener = new ItemListener() {

					@Override
					public void itemStateChanged(ItemEvent e) {
						JComboBox source = (JComboBox)e.getSource();
						int index = source.getSelectedIndex();
						table.setAutoResizeMode(index);
						
					}
				};
				
				resizeModeComboBox.addItemListener(itemListener);
				
				JFrame frame = new JFrame("Resize Table");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				frame.add(resizeModeComboBox, BorderLayout.NORTH);
				frame.add(scrollPane, BorderLayout.CENTER);
				
				frame.setSize(300, 150);
				frame.setVisible(true);
				
			}
		};
		
		EventQueue.invokeLater(runner);

	}

}
