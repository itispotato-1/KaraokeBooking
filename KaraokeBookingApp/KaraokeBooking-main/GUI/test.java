package GUI;

import javax.swing.*;

import GUI.Decorate.*;
import lib.BookRoom.*;
import lib.loginregister.*;
import store.Product;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class test extends JFrame {
    private Font FontITCKRIST;
    private Font FontTWCENMT;

    public test() {
        setUpLookAndFeel();
        setUpFont();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//
        setSize(new Dimension(440, 664));
        setLocationRelativeTo(null);//
        setVisible(true);
        initComponents();
    }

    private void initComponents() {

        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.setBackground(Color.white);
        add(panelMain);

        JPanel panelImg = new JPanel();
        panelImg.setLayout(null);
        panelImg.setPreferredSize(new Dimension(100, 100));
        panelImg.setMaximumSize(new Dimension(100, 100));
        panelImg.setBackground(Color.GRAY);

        JLabel jLabelImg = new JLabel();
        ImageIcon tempIcon = new ImageIcon("./GUI/Picture/Logo.png");
        System.out.println(tempIcon);
        Image tempImage = tempIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        jLabelImg.setIcon(new ImageIcon(tempImage));
        jLabelImg.setBounds(0, 0, 100, 100);
        jLabelImg.repaint();

        panelImg.add(jLabelImg);



        JPanel panelSign = new JPanel();
        panelSign.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelSign.setPreferredSize(new Dimension(100, 60));
        panelSign.setBackground(Color.WHITE);

        JPanel panelLine = new JPanel();
        panelLine.setAlignmentY(CENTER_ALIGNMENT);
        panelLine.setPreferredSize(new Dimension(125,10));
        //panelLine.setMaximumSize(new Dimension(50,30));
        panelLine.setBackground(Color.GRAY);

        JPanel panelLinetwo = new JPanel();
        panelLinetwo.setAlignmentY(CENTER_ALIGNMENT);
        panelLinetwo.setPreferredSize(new Dimension(125,10));
        //panelLine.setMaximumSize(new Dimension(50,30));
        panelLinetwo.setBackground(Color.GRAY);

        JLabel labelSingup = new JLabel();
        labelSingup.setText("SignUp");
        labelSingup.setFont(new Font("Serif",1,48));
    
        panelSign.add(panelLine);
        panelSign.add(labelSingup);
        panelSign.add(panelLinetwo);




        JPanel panelMix = new JPanel();
        panelMix.setLayout(new BoxLayout(panelMix, BoxLayout.Y_AXIS));
        panelMix.setPreferredSize(new Dimension(100, 300));
        panelMix.setMaximumSize(new Dimension(390, 300));
        panelMix.setBackground(Color.WHITE);

        JPanel panelUser = new JPanel(null);
        //panelMix.setLayout(new BoxLayout(panelMix, BoxLayout.Y_AXIS));
        panelUser.setPreferredSize(new Dimension(250, 80));
        panelUser.setMaximumSize(new Dimension(350, 80));
        panelUser.setBackground(Color.WHITE);

        
        JLabel jLabelUserName = new JLabel();
        jLabelUserName.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 18));
        jLabelUserName.setText("USERNAME");
        jLabelUserName.setBounds(4, -4, 100, 30);

        JTextField user = new JTextField();
        user.setBounds(0, 20, 349, 35);
       
        JLabel jLabelInvalid  = new JLabel();
        jLabelInvalid.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 15));
        jLabelInvalid.setText("Invalid");
        jLabelInvalid.setBounds(4,45, 100, 30);
        jLabelInvalid.setForeground(Color.RED);

        panelUser.add(jLabelUserName);
        panelUser.add(user);
        panelUser.add(jLabelInvalid);


        JPanel panelPhone = new JPanel(null);
        // panelMix.setLayout(new BoxLayout(panelMix, BoxLayout.Y_AXIS));
        panelPhone.setPreferredSize(new Dimension(250, 80));
        panelPhone.setMaximumSize(new Dimension(350, 80));
        panelPhone.setBackground(Color.WHITE);

        JLabel jLabelPhone = new JLabel();
        jLabelPhone.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 18));
        jLabelPhone.setText("PASSWORD");
        jLabelPhone.setBounds(4, -4, 100, 30);

        JTextField user1 = new JTextField();
        user1.setBounds(0, 20, 349, 35);

        JLabel jLabelInvalid1  = new JLabel();
        jLabelInvalid1.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 15));
        jLabelInvalid1.setText("Invalid");
        jLabelInvalid1.setBounds(4,45, 100, 30);
        jLabelInvalid1.setForeground(Color.RED);

        panelPhone.add(jLabelPhone);
        panelPhone.add(user1);
        panelPhone.add(jLabelInvalid1);



        JPanel panelPassword = new JPanel(null);
        // panelMix.setLayout(new BoxLayout(panelMix, BoxLayout.Y_AXIS));
        panelPassword.setPreferredSize(new Dimension(250, 80));
        panelPassword.setMaximumSize(new Dimension(350, 80));
        panelPassword.setBackground(Color.WHITE);


        JLabel jLabelPass = new JLabel();
        jLabelPass.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 18));
        jLabelPass.setText("PASSWORD");
        jLabelPass.setBounds(4, -4, 100, 30);

        JTextField user2 = new JTextField();
        user2.setBounds(0, 20, 349, 35);

        JLabel jLabelInvalid2  = new JLabel();
        jLabelInvalid2.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 15));
        jLabelInvalid2.setText("Invalid");
        jLabelInvalid2.setBounds(4,45, 100, 30);
        jLabelInvalid2.setForeground(Color.RED);

        panelPassword.add(jLabelPass);
        panelPassword.add(user2);
        panelPassword.add(jLabelInvalid2);




        JPanel panelConfirm = new JPanel();
        // panelMix.setLayout(new BoxLayout(panelMix, BoxLayout.Y_AXIS));
        panelConfirm.setPreferredSize(new Dimension(200, 80));
        panelConfirm.setMaximumSize(new Dimension(350, 80));
        panelConfirm.setBackground(Color.ORANGE);


        panelMix.add(Box.createVerticalStrut(10));
        panelMix.add(panelUser);
        panelMix.add(panelPhone);
        panelMix.add(panelPassword);
        panelMix.add(panelConfirm);
        panelMix.add(Box.createVerticalStrut(10));
      


        JPanel panelCsignup = new JPanel(new FlowLayout(FlowLayout.CENTER,0,0));
        // panelCsignup.setLayout(new BoxLayout(panelCsignup, BoxLayout.Y_AXIS));
        panelCsignup.setPreferredSize(new Dimension(80, 30));
        panelCsignup.setBackground(Color.WHITE);


        JButton ButtonCsing2 = new JButton();
        ButtonCsing2.setBackground(new Color(0, 57, 134));
        ButtonCsing2.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 24));
        ButtonCsing2.setForeground(new Color(255, 255, 255));
        ButtonCsing2.setPreferredSize(new Dimension(350, 45));
        ButtonCsing2.setText("SIGN UP");

        panelCsignup.add(ButtonCsing2);




        JPanel panelLogin = new JPanel(new FlowLayout(FlowLayout.RIGHT,0,0));
        // panelLogin.setLayout(new BoxLayout(panelLogin, BoxLayout.Y_AXIS));
        panelLogin.setPreferredSize(new Dimension(100, 60));
        panelLogin.setMaximumSize(new Dimension(345, 100));
        panelLogin.setBackground(Color.WHITE);

        JButton ButtonLogin2 = new JButton();
        ButtonLogin2.setBackground(new Color(0, 57, 134));
        ButtonLogin2.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 24));
        ButtonLogin2.setForeground(new Color(255, 255, 255));
        ButtonLogin2.setPreferredSize(new Dimension(150, 45));
        ButtonLogin2.setText("SIGN UP");

        panelLogin.add(ButtonLogin2);









        panelMain.add(Box.createVerticalStrut(13));
        panelMain.add(panelImg);
        panelMain.add(Box.createVerticalStrut(13));
        panelMain.add(panelSign);
        panelMain.add(panelMix);
        panelMain.add(panelCsignup);
        panelMain.add(panelLogin);
    

        revalidate();
        repaint();
    }

    private void setUpFont() {
        File fileTwCenMT = new File("./Font/TwCenMT.ttf");
        File fileITCKRIST = new File("./Font/ITCKRIST.ttf");
        try {
            FontITCKRIST = Font.createFont(Font.TRUETYPE_FONT, fileITCKRIST).deriveFont((int) 1);
            FontTWCENMT = Font.createFont(Font.TRUETYPE_FONT, fileTwCenMT).deriveFont((int) 0);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private void setUpLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
    }

    public static void main(String[] args) {
        new test();
    }
}