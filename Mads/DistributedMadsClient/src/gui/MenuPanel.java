/*
 * 
 */
package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;


import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**
 * The Class MenuPanel.
 */
public class MenuPanel extends JPanel
{

	
	
	//Testing menu variables.
	
	
        /**
	 * Instantiates a new menu panel.
	 */
	public MenuPanel()
        {
        	
                JPanel jmenupanel = new JPanel();
                jmenupanel.setBounds(0, 0, 1024, 100);

                // creating button on external JPanel
                
                JButton btnHome = new JButton("..");
                btnHome.setIcon(new ImageIcon(MenuPanel.class.getResource("/shared/img/home-button.png")));
                btnHome.setBounds(10, 11, 75, 48);
                JButton btnCalendar = new JButton("Calendar");
                btnCalendar.setBounds(318, 77, 99, 23);
                JButton btnEvents = new JButton("Events");
                btnEvents.setBounds(416, 77, 99, 23);
                JButton btnProfile = new JButton("Profile");
                btnProfile.setBounds(514, 77, 99, 23);

                                
                //test purposes code
                

                jmenupanel.setLayout(null);
                jmenupanel.add(btnHome);
                jmenupanel.add(btnCalendar);
                jmenupanel.add(btnEvents);
                jmenupanel.add(btnProfile);
                
                //Hides the background color - and use the IMG.
                jmenupanel.setOpaque(true);
                jmenupanel.setBackground(new Color(0,0,0,0));
                
                final JButton btnLogout = new JButton("Logout");
                
                
                btnLogout.setBounds(10, 77, 89, 23);
                jmenupanel.add(btnLogout);
                
                
                //Sets the BG form shared package.
                JLabel lblHeaderBackground = new JLabel("");
                lblHeaderBackground.setIcon(new ImageIcon(MenuPanel.class.getResource("/shared/img/header.jpg")));
                lblHeaderBackground.setBounds(0, 0, 1024, 120);
                jmenupanel.add(lblHeaderBackground);
                

        		        		
        		        	
//			btnProfile.addActionListener(new ActionListener() {
//				public void actionPerformed(ActionEvent e) {
//
//
//					screen.changecards.show(jmenupanel, "profilePanel");						
//					
//				}
//			});


        	
        }
        
        
    }
