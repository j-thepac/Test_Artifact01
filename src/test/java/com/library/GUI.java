package com.library;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import com.gradletest.gradletest;


import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField Gui_TextField_Tcs;
	private static boolean bGUI_checkbox;
	private static String sGUI_testcases;
	private static String sGUI_Browser="fireFox";
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		try {
//			GUI dialog = new GUI();
//			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//			dialog.setVisible(true);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	/**
	 * Create the dialog.
	 */
	public GUI() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 229);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel gui_title = new JLabel("Jeeves Automation Framework");
			gui_title.setBounds(120, 11, 148, 14);
			contentPanel.add(gui_title);
		}
		{
			JLabel gui_excellabel = new JLabel("Use Excel");
			gui_excellabel.setBounds(86, 60, 102, 14);
			contentPanel.add(gui_excellabel);
		}
		{
			JCheckBox Gui_Checkbox = new JCheckBox("Yes/No");
			Gui_Checkbox.setBounds(219, 56, 59, 23);
			Gui_Checkbox.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(Gui_Checkbox.isSelected()==true){
						Gui_TextField_Tcs.setEnabled(false);						
						sGUI_testcases="";
						bGUI_checkbox=true;
					}
					else
					{
						sGUI_testcases=Gui_TextField_Tcs.getText();
						bGUI_checkbox=false;
						Gui_TextField_Tcs.setEnabled(true);
					}
						
				}
			});
			contentPanel.add(Gui_Checkbox);
		}
		{
			JLabel gui_testcaseslabel = new JLabel("Test Cases (3,34,...)");
			gui_testcaseslabel.setBounds(86, 113, 102, 14);
			contentPanel.add(gui_testcaseslabel);
		}
		{
			Gui_TextField_Tcs = new JTextField();
			Gui_TextField_Tcs.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent arg0) {
					sGUI_testcases=Gui_TextField_Tcs.getText();
				}
			});
			Gui_TextField_Tcs.setBounds(219, 110, 210, 20);
			Gui_TextField_Tcs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sGUI_testcases=Gui_TextField_Tcs.getText();
					
				}
			});
			contentPanel.add(Gui_TextField_Tcs);
			Gui_TextField_Tcs.setColumns(10);
		}
		{
			JLabel Gui_browserlabel = new JLabel("Browser");
			Gui_browserlabel.setBounds(86, 164, 102, 14);
			contentPanel.add(Gui_browserlabel);
		}
		{
			JComboBox Gui_DropDown_Browser = new JComboBox();
			Gui_DropDown_Browser.setBounds(219, 161, 90, 20);
			Gui_DropDown_Browser.addItem("firefox");
			Gui_DropDown_Browser.addItem("ie");
			Gui_DropDown_Browser.addItem("chrome");
			
			Gui_DropDown_Browser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sGUI_Browser=Gui_DropDown_Browser.getSelectedItem().toString();
				}
			});
			contentPanel.add(Gui_DropDown_Browser);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 229, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						gradletest.bGUI_checkbox=bGUI_checkbox;
						gradletest.sGUI_Browser=sGUI_Browser;
						gradletest.sGUI_testcases=sGUI_testcases;
						setVisible(false);
						dispose();
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.print("Cancel button pressed, Execution teerminated");
						System.exit(0);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
