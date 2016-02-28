package com.library;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JToggleButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFileChooser;

import java.awt.Button;

import javax.swing.JButton;

import net.miginfocom.swing.MigLayout;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class GUI_Test extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JLabel lblMarlabsAutomationGui;
    private JLabel lblSetDatasheetHere;
    private JLabel lblBrowser;
    private JCheckBox firefox_checkbox;
    private JCheckBox chrome_checkbox;
    private JCheckBox ie_checkbox;
    public Boolean bRun_Firefox=false;
    public Boolean bRun_Chrome=false;
    public Boolean bRun_IE=false;
    private JLabel lblNewLabel;
    private JTextField Username_field;
    private JButton tglbtnStart;
    private JButton btnNewButton_1;
    public boolean start_execution=false;
    public boolean exit_execution=false;
    public String username="";
    /**
     * Launch the application.
     */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_Test frame = new GUI_Test();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

    /**
     * Create the frame.
     */
    public GUI_Test() {
        setTitle("Jeeves Automation FW ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 631, 313);
        String file_name="";
//		 static Boolean bRun_Firefox=false;


        contentPane = new JPanel();
        contentPane.setBackground(new Color(240, 240, 240));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new MigLayout("", "[][grow][][][][][grow][][][][][]", "[][][][][][][][][][][][][][]"));

        lblMarlabsAutomationGui = new JLabel("Jeeves Automation Framework");
        lblMarlabsAutomationGui.setBackground(UIManager.getColor("textHighlight"));
        lblMarlabsAutomationGui.setHorizontalAlignment(SwingConstants.CENTER);
        lblMarlabsAutomationGui.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
        contentPane.add(lblMarlabsAutomationGui, "cell 1 0");

        lblBrowser = new JLabel("Browser");
        lblBrowser.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblBrowser.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblBrowser, "cell 0 1 1 3,alignx center,aligny center");

        firefox_checkbox = new JCheckBox("Firefox");
        firefox_checkbox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(firefox_checkbox.isSelected()==true)
                    bRun_Firefox=true;
                else
                    bRun_Firefox=false;
            }
        });
//		if(chckbxNewCheckBox.isSelected()==true)


        contentPane.add(firefox_checkbox, "cell 1 3");

        chrome_checkbox = new JCheckBox("Chrome");
        chrome_checkbox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(chrome_checkbox.isSelected()==true)
                    bRun_Chrome=true;
                else
                    bRun_Chrome=false;

            }
        });

        contentPane.add(chrome_checkbox, "cell 1 4");

        ie_checkbox = new JCheckBox("IE");
        ie_checkbox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(ie_checkbox.isSelected()==true)
                    bRun_IE=true;
                else
                    bRun_IE=false;
            }
        });
        contentPane.add(ie_checkbox, "cell 1 5");

        lblNewLabel = new JLabel("User Name");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
        contentPane.add(lblNewLabel, "cell 0 7,alignx center");

        Username_field = new JTextField();
        contentPane.add(Username_field, "cell 1 7,alignx left");
        Username_field.setColumns(10);
        Username_field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {

                username=Username_field.getText().toString();
                System.out.println("typed"+Username_field.getText().toString());
            }

        });





        lblSetDatasheetHere = new JLabel("Set DataSheet Here");
        lblSetDatasheetHere.setFont(new Font("Tahoma", Font.BOLD, 11));
        contentPane.add(lblSetDatasheetHere, "cell 0 10,alignx center,aligny center");

        textField = new JTextField();
        textField.setEnabled(false);
        contentPane.add(textField, "flowx,cell 1 10,growx");
        textField.setColumns(10);

        file_name=textField.getSelectedText();

        tglbtnStart = new JButton("START");
        tglbtnStart.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                start_execution=true;
            }
        });
        contentPane.add(tglbtnStart, "flowx,cell 1 13,alignx left");

        btnNewButton_1 = new JButton("CANCEL");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                exit_execution=true;
            }
        });
        contentPane.add(btnNewButton_1, "cell 1 13,alignx center");

        JButton btnNewButton = new JButton("Browse");
        btnNewButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                if(fileChooser.showOpenDialog(GUI_Test.this)==fileChooser.APPROVE_OPTION)
                {
                    File file =fileChooser.getSelectedFile();
                    textField.setText(file.getPath());
//					 file_name=file.getPath();
                }
            }
        });






        contentPane.add(btnNewButton, "cell 1 10");


//		contentPane.add(fileChooser, "cell 8 3");




    }
}
