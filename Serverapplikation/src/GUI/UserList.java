package GUI;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import model.QueryBuild.QueryBuilder;
 
public class UserList extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnLogout;
	private JButton btnMainMenu;
	private ResultSet rs;
	private JPanel deleteuserpanel;
	private JLabel lblEnterTheCalendar;
	private JTextField textField;
	private JButton btnCancel;
	private JButton btnFinalDeleteUser;
	
    @SuppressWarnings("null")
	public UserList() {
    	setSize(new Dimension(1024, 768));
 
        String[] columnNames = {"UserID",
                                "Email",
                                "Active",
                                "Created",
                                "Password"};
 


        	Object[][] data = new Object[getUserCount()][5];
        
	
    
        try {
			QueryBuilder qb = new QueryBuilder();
			rs = qb.selectFrom("users").all().ExecuteQuery();
			
	        int count = 0;
	        while (rs.next()) {

	        	data[count][0] = rs.getString("userid");
	        	data[count][1] = rs.getString("email");
	        	data[count][2] = rs.getString("active");
	        	data[count][3] = rs.getString("created");
	        	data[count][4] = rs.getString("password");

	        	
	        	count++;
	        }
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

 
        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.setRowSelectionAllowed(true);
        

        setLayout(null);
 
        //Create the scroll pane and add the table to it.
        final JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255, 255), new Color(0, 0, 205), new Color(255, 255, 255)), new MatteBorder(1, 1, 1, 1, (Color) new Color(255, 255, 255))));
        scrollPane.setViewportBorder(new CompoundBorder(new BevelBorder(BevelBorder.LOWERED, new Color(0, 0, 205), new Color(255, 255, 255), new Color(0, 0, 205), new Color(255, 255, 255)), null));

        scrollPane.setBounds(96, 240, 693, 370);


 
        //Add the scroll pane to this panel.
        add(scrollPane);
        
        btnAdd = new JButton("Add");
        btnAdd.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
        btnAdd.setForeground(new Color(0, 0, 205));
        btnAdd.setOpaque(true);
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
        
        btnDelete = new JButton("Delete");
        btnDelete.setOpaque(true);
        btnDelete.setForeground(new Color(0, 0, 205));
        btnDelete.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 255)));
		btnDelete.setBounds(856, 377, 118, 29);
        add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				deleteuserpanel.setVisible(true);
				scrollPane.setVisible(false);
				
				
			}
		});
        
        JLabel lblUserlist = new JLabel("Userlist");
        lblUserlist.setForeground(Color.WHITE);
        lblUserlist.setFont(new Font("Arial", Font.BOLD, 78));
        lblUserlist.setBounds(365, 138, 368, 90);
        add(lblUserlist);
        
        deleteuserpanel = new JPanel();
        deleteuserpanel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
        deleteuserpanel.setBounds(365, 250, 369, 359);
        add(deleteuserpanel);
        deleteuserpanel.setLayout(null);
        
        
        // Hiding the delete calendar panel unless btn delete is clicked
        deleteuserpanel.setVisible(false);
        
        lblEnterTheCalendar = new JLabel("Enter the ID of the user you want to delete.");
        lblEnterTheCalendar.setBounds(47, 52, 281, 44);
        deleteuserpanel.add(lblEnterTheCalendar);
        
        textField = new JTextField();
        textField.setBounds(110, 122, 140, 29);
        deleteuserpanel.add(textField);
        textField.setColumns(10);
        
        JButton btnFinalDeleteUser_1 = new JButton("Delete!");
        btnFinalDeleteUser_1.setBounds(212, 227, 89, 23);
        deleteuserpanel.add(btnFinalDeleteUser_1);
        
        btnCancel = new JButton("Cancel");
        
        			btnCancel.setBounds(66, 227, 89, 23);
        			deleteuserpanel.add(btnCancel);
        			
        					
        					
        					btnCancel.addActionListener(new ActionListener() {
        						public void actionPerformed(ActionEvent arg0) {
        							
        							deleteuserpanel.setVisible(false);
        							scrollPane.setVisible(true);
        						}
        					});
    
        JLabel lblBackground = new JLabel("Background");
        lblBackground.setIcon(new ImageIcon(UserList.class.getResource("/Images/MetalBackground.jpg")));
        lblBackground.setBackground(new Color(245, 245, 245));
        lblBackground.setForeground(new Color(245, 255, 250));
        lblBackground.setOpaque(true);
        lblBackground.setBounds(0, 0, 1024, 768);
        add(lblBackground);
  
    }
 
 

    
    public void addActionListener(ActionListener l) {
		btnAdd.addActionListener(l);
		btnLogout.addActionListener(l);
		btnMainMenu.addActionListener(l);
		
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnMainMenu() {
		return btnMainMenu;
	}

	public JButton getBtnLogout() {
		return btnLogout;
	}
	
	
	
	public JTextField getTextField() {
		return textField;
	}




	public void setTextField(JTextField textField) {
		this.textField = textField;
	}




	public JButton getBtnFinalDeleteUser() {
		return btnFinalDeleteUser;
	}




	public void setBtnFinalDeleteUser(JButton btnFinalDeleteUser) {
		this.btnFinalDeleteUser = btnFinalDeleteUser;
	}




	public int getUserCount(){
		
		int count = 0;
		
		QueryBuilder qb2 = new QueryBuilder();
		try {
			rs = qb2.selectFrom("users").all().ExecuteQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(rs.next()){
				
				count++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count; 
	}
	
}