package gui;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Calender {
	
    static JLabel lblWeek, lblYear;
    static JButton btnPrev, btnNext;
    static JTable tblCalendar;
    static JComboBox cmbYear;
    static JFrame frmMain;
    static Container pane;
    static DefaultTableModel mtblCalendar; //Table model
    static JScrollPane stblCalendar; //The scrollpane
    static JPanel pnlCalendar;
    static int realYear, realWeek, realDay, currentYear, currentWeek;
    
    public static void main (String args[]){
        //Look and feel
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}
        
        //Prepare frame
        frmMain = new JFrame (); //Create frame
        frmMain.setTitle("CBS Calendar");
        frmMain.setSize(600, 450); //Set size to 400x400 pixels
        pane = frmMain.getContentPane(); //Get content pane
        pane.setLayout(null); //Apply null layout
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close when X is clicked
        
        //Create controls
        lblWeek = new JLabel ("1");
        lblYear = new JLabel ("Change year:");
        cmbYear = new JComboBox();
        btnPrev = new JButton ("&lt;&lt;");
        btnNext = new JButton ("&gt;&gt;");
        mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tblCalendar = new JTable(mtblCalendar);
        stblCalendar = new JScrollPane(tblCalendar);
        pnlCalendar = new JPanel(null);
        
        //Set border
        pnlCalendar.setBorder(BorderFactory.createTitledBorder("Calendar"));
        
        //Register action listeners
        btnPrev.addActionListener(new btnPrev_Action());
        btnNext.addActionListener(new btnNext_Action());
        cmbYear.addActionListener(new cmbYear_Action());
        
        //Add controls to pane
        pane.add(pnlCalendar);
        pnlCalendar.add(lblWeek);
        pnlCalendar.add(lblYear);
        pnlCalendar.add(cmbYear);
        pnlCalendar.add(btnPrev);
        pnlCalendar.add(btnNext);
        pnlCalendar.add(stblCalendar);
        
        //Set bounds
        pnlCalendar.setBounds(0, 0, 516, 396);
        lblWeek.setBounds(132, 25, 208, 25);
        lblYear.setBounds(10, 338, 80, 20);
        cmbYear.setBounds(236, 338, 80, 20);
        btnPrev.setBounds(42, 25, 80, 25);
        btnNext.setBounds(260, 25, 50, 25);
        stblCalendar.setBounds(10, 50, 496, 270);
        
        //Make frame visible
        frmMain.setResizable(false);
        frmMain.setVisible(true);
        
        //Get real month/year
        GregorianCalendar cal = new GregorianCalendar(); //Create calendar
        realDay = cal.get(GregorianCalendar.DAY_OF_MONTH); //Get day
        realWeek = cal.get(GregorianCalendar.WEEK_OF_YEAR); //Get week
        realYear = cal.get(GregorianCalendar.YEAR); //Get year
        currentWeek = realWeek; //Match month and year
        currentYear = realYear;
        
        //Add headers
        String[] headers = {"Clock","Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"}; //All headers
        for (int i=0; i<8; i++){
            mtblCalendar.addColumn(headers[i]);
        }
        
        tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background
        
        //No resize/reorder
        tblCalendar.getTableHeader().setResizingAllowed(false);
        tblCalendar.getTableHeader().setReorderingAllowed(false);
        
        //Single cell selection
        tblCalendar.setColumnSelectionAllowed(true);
        tblCalendar.setRowSelectionAllowed(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        //Set row/column count
        tblCalendar.setRowHeight(38);
        mtblCalendar.setColumnCount(7);
        mtblCalendar.setRowCount(12);
        
        //Populate table
        for (int i=realYear-100; i<=realYear+100; i++){
            cmbYear.addItem(String.valueOf(i));
        }
        
        //Refresh calendar
        refreshCalendar (realWeek, realYear); //Refresh calendar
    }
    
    public static void refreshCalendar(int week, int year){
        //Variables
        String[] weeks =  new String [51];
        
        for(int i = 0; i>weeks.length;i++){
        	
       	weeks[0+i] = "Week " +i;
        	
        }
        
        
        
        
        int nod, som; //Number Of Days, Start Of Month
        
        //Allow/disallow buttons
        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        if (week == 0 && year <= realYear-10){btnPrev.setEnabled(false);} //Too early
        if (week == 51 && year >= realYear+100){btnNext.setEnabled(false);} //Too late
        lblWeek.setText(weeks[week]); //Refresh the month label (at the top)
        lblWeek.setBounds(160-lblWeek.getPreferredSize().width/2, 25, 180, 25); //Re-align label with calendar
        cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box
        
        //Clear table
        for (int i=0; i<7; i++){
            for (int j=0; j<8; j++){
                mtblCalendar.setValueAt(null, i, j);
            }
        }
        
        //Get first day of month and number of days
        GregorianCalendar cal = new GregorianCalendar(year, week, 1);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);
        
        //Draw calendar
        for (int i=1; i<=8; i++){
            int row = new Integer((i+som-2)-1);
            int column  =  (i+som-2)%7;
            //mtblCalendar.setValueAt(i, row, column);
        }
        
        //Apply renderers
        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
    }
    
    static class tblCalendarRenderer extends DefaultTableCellRenderer{
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (column == 0 || column == 6){ //Week-end
                setBackground(new Color(255, 220, 220));
            }
            else{ //Week
                setBackground(new Color(255, 255, 255));
            }
            if (value != null){
                if (Integer.parseInt(value.toString()) == realDay && currentWeek == realWeek && currentYear == realYear){ //Today
                    setBackground(new Color(220, 220, 255));
                }
            }
            setBorder(null);
            setForeground(Color.black);
            return this;
        }
    }
    
    static class btnPrev_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentWeek == 0){ //Back one year
                currentWeek = 11;
                currentYear -= 1;
            }
            else{ //Back one month
                currentWeek -= 1;
            }
            refreshCalendar(currentWeek, currentYear);
        }
    }
    static class btnNext_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentWeek == 51){ //Foward one year
                currentWeek = 0;
                currentYear += 1;
            }
            else{ //Foward one month
                currentWeek += 1;
            }
            refreshCalendar(currentWeek, currentYear);
        }
    }
    static class cmbYear_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (cmbYear.getSelectedItem() != null){
                String b = cmbYear.getSelectedItem().toString();
                currentYear = Integer.parseInt(b);
                refreshCalendar(currentWeek, currentYear);
            }
        }
    }
}


