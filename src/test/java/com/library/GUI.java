package com.library;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import com.Test_cases.TestNG_Suite;





import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JLabel gui_title;
	private JLabel Gui_browserlabel;
	private JLabel gui_excellabel;
	
	private JCheckBox Gui_Checkbox;
	
	private JTextField Gui_TextField_Tcs;
	private static boolean bGUI_checkbox;
	private static String sGUI_testcases;
	private static String sGUI_Browser="fireFox";
	private JCheckBox Gui_Checkbox_excel;
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
	private JComboBox<String> gui_DropDown_Browser;
	private JButton okButton;
	private JButton cancelButton;

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
			 gui_title = new JLabel("Jeeves Automation Framework");
			gui_title.setBounds(120, 11, 148, 14);
			contentPanel.add(gui_title);
		}
		{
			 gui_excellabel = new JLabel("Use Excel to select Test Cases");
			gui_excellabel.setBounds(30, 60, 183, 14);
			contentPanel.add(gui_excellabel);
		}
		{
			Gui_Checkbox_excel = new JCheckBox("Yes/No");
			Gui_Checkbox_excel.setBounds(219, 56, 59, 23);
			Gui_Checkbox_excel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(Gui_Checkbox_excel.isSelected()==true){
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
			contentPanel.add(Gui_Checkbox_excel);
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
				public void keyReleased(KeyEvent e) {
					sGUI_testcases=Gui_TextField_Tcs.getText();
				}
			});

			Gui_TextField_Tcs.setBounds(219, 110, 210, 20);
			contentPanel.add(Gui_TextField_Tcs);
			Gui_TextField_Tcs.setColumns(10);
		}
		{
			JLabel Gui_browserlabel = new JLabel("Browser");
			Gui_browserlabel.setBounds(86, 164, 102, 14);
			contentPanel.add(Gui_browserlabel);
		}
		{
			gui_DropDown_Browser = new JComboBox<String>();
			gui_DropDown_Browser.setBounds(219, 161, 90, 20);
			gui_DropDown_Browser.addItem("firefox");
			gui_DropDown_Browser.addItem("ie");
			gui_DropDown_Browser.addItem("chrome");
			
			gui_DropDown_Browser.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sGUI_Browser=gui_DropDown_Browser.getSelectedItem().toString();
				}
			});
			contentPanel.add(gui_DropDown_Browser);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 229, 434, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
//						if(bGUI_checkbox==false)
//							//sGUI_Browser=Gui_DropDown_Browser.getSelectedItem().toString();
//							gradletest.bGUI_checkbox=Gui_Checkbox.isSelected();
//						if(Gui_Checkbox.isSelected()==false)
//							gradletest.sGUI_Browser=gui_DropDown_Browser.getSelectedItem().toString();
//						else
//							gradletest.sGUI_Browser="";
//							gradletest.sGUI_testcases=Gui_TextField_Tcs.getText();
//						
						TestNG_Suite.bGUI_checkbox=bGUI_checkbox;
						TestNG_Suite.sGUI_Browser=sGUI_Browser;
						TestNG_Suite.sGUI_testcases=sGUI_testcases;
						setVisible(false);
						dispose();
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
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
