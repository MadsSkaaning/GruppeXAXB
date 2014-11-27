package GUI;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;

public class NoteList extends JPanel {
	private JTable table;
	private final JLabel lblBackground = new JLabel("");
	private JLabel lblHeader;
	private JButton btnDelete;
	private JButton btnAdd;
	private JButton btnMainMenu;
	private JButton btnLogout;
	private JLabel label;
	

	/**
	 * Create the panel.
	 */
	public NoteList() {
		setSize(new Dimension(1024, 768));
		setLayout(null);
		
		//Laver tabellen inde i Eventlisten.
		String[] columnNames = { "Note", "Event", "Date", "Numbers of Notes" };

		Object[][] data = {

				{ "D�K Julefrokost", "11.11.2022", "Game on!","3"},
				{ "D�K Julefrokost", "11.11.2022", "Game on!","3"},
				{ "D�K Julefrokost", "11.11.2022", "Game on!","3"},
				{ "D�K Julefrokost", "11.11.2022", "Game on!","3" },
				{ "D�K Julefrokost", "11.11.2022", "Game on!","3" } 
				};

		final JTable table = new JTable(data, columnNames);
		table.setSurrendersFocusOnKeystroke(true);
		table.setPreferredScrollableViewportSize(new Dimension(500, 100));
		table.setFillsViewportHeight(true);
		table.setRowSelectionAllowed(true);

		// Create the scroll pane and add the table to it.
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBorder(new CompoundBorder(new BevelBorder(
				BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
						255), new Color(0, 0, 205), new Color(255, 255, 255)),
				new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255))));
		scrollPane.setViewportBorder(new CompoundBorder(new BevelBorder(
				BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255,
						255), new Color(0, 0, 205), new Color(255, 255, 255)),
				null));
		scrollPane.setBounds(96, 240, 693, 370);

		// Add the scroll pane to this panel.
		add(scrollPane);
		
		lblHeader = new JLabel("NoteList");
		lblHeader.setForeground(Color.WHITE);
		lblHeader.setFont(new Font("Arial", Font.BOLD, 78));
		lblHeader.setBounds(365, 138, 368, 90);
		add(lblHeader);
		
		btnDelete = new JButton("Delete");
		btnDelete.setOpaque(true);
		btnDelete.setForeground(new Color(0, 0, 205));
		btnDelete.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
		btnDelete.setBounds(856, 377, 118, 29);
		add(btnDelete);
		
		btnAdd = new JButton("Add");
		btnAdd.setOpaque(true);
		btnAdd.setForeground(new Color(0, 0, 205));
		btnAdd.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
		btnAdd.setBounds(856, 343, 118, 29);
		add(btnAdd);
		
        btnLogout = new JButton("");
        btnLogout.setIcon(new ImageIcon(UserList.class.getResource("/Images/Logout.png")));

        btnLogout.setForeground(Color.WHITE);
        btnLogout.setFont(new Font("Arial", Font.BOLD, 30));
        btnLogout.setContentAreaFilled(false);
        btnLogout.setBorder(null);
        btnLogout.setBounds(18, 68, 153, 41);
        add(btnLogout);
        
        btnMainMenu = new JButton("");
        btnMainMenu.setIcon(new ImageIcon(UserList.class.getResource("/Images/homebtn.png")));
        btnMainMenu.setForeground(Color.WHITE);
        btnMainMenu.setFont(new Font("Arial", Font.BOLD, 30));
        btnMainMenu.setContentAreaFilled(false);
        btnMainMenu.setBorder(null);
        btnMainMenu.setBounds(18, 15, 153, 41);
        add(btnMainMenu);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(NoteList.class.getResource("/Images/CBSLogo3.png")));
		label.setBounds(10, 698, 250, 59);
		add(label);
		lblBackground.setIcon(new ImageIcon(NoteList.class.getResource("/Images/MetalBackground.jpg")));
		lblBackground.setBounds(0, 0, 1024, 768);
		
		add(lblBackground);
	}
	
	public void addActionListener(ActionListener l) {
		btnAdd.addActionListener(l);
		btnDelete.addActionListener(l);
		btnLogout.addActionListener(l);
		btnMainMenu.addActionListener(l);
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}
	
}
