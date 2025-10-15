package GUI;

import javax.swing.*;

import GUI.Decorate.*;
import lib.BookRoom.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;

public class Admin_Profit extends JPanel {
    private Font FontITCKRIST;
    private Font FontTWCENMT;
    private Mainframe mainframe;
    private LocalDate date;
    private RoomSystem system;

    private JLabel[] jLabelRoom;
    private JLabel[] jLabelAvalible;
    private JLabel[] jLabelCost;
    private JPanel[] jPanelBooking;
    private JButton[] jButton;
    private JComboBox<String> jComboBoxDate;

    private JLabel jLabelTimeOpen;

    public Admin_Profit(Mainframe mainframe) {
        this.system = mainframe.getSystem();
        this.mainframe = mainframe;
        setUpFont();
        setVisible(true);
        initComponents();
    }

    private void initComponents() {
        removeAll();
        jLabelRoom = new JLabel[100];
        jLabelAvalible = new JLabel[100];
        jLabelCost = new JLabel[100];
        jPanelBooking = new JPanel[100];
        jButton = new JButton[100];

        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.setPreferredSize(new Dimension(440, 664));
        panelMain.setBackground(Color.WHITE);
        add(panelMain);

        JPanel panelSecound = new JPanel();
        panelSecound.setOpaque(false);
        panelSecound.setLayout(new BoxLayout(panelSecound, BoxLayout.Y_AXIS));
        panelSecound.setBackground(Color.WHITE);
        panelSecound.setMaximumSize(new Dimension(400, 600));

        // -------------------------------- Panel ข้างบนสุด ------------------------
        JPanel panelTop = new JPanel(null);
        panelTop.setOpaque(false);
        panelTop.setBackground(Color.WHITE);
        panelTop.setMaximumSize(new Dimension(400, 60));

        JButton buttonExit = new JButton("X");
        buttonExit.setForeground(Color.WHITE);
        buttonExit.setBackground(Color.RED);
        buttonExit.setMaximumSize(new Dimension(40, 40));
        buttonExit.setBounds(5, 10, 35, 35);
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonLogoutActionPerformed(e);
            }
        });
        JPanel panelAdmin = new JPanel();
        panelAdmin.setOpaque(false);
        panelAdmin.setLayout(new BoxLayout(panelAdmin, BoxLayout.Y_AXIS));
        panelAdmin.setBackground(Color.WHITE);
        panelAdmin.setPreferredSize(new Dimension(250, 50));
        panelAdmin.setMaximumSize(new Dimension(250, 50));
        panelAdmin.setBounds(90, 5, 330, 100);

        JLabel jLabelBookRoom = new JLabel();
        jLabelBookRoom.setFont(FontITCKRIST.deriveFont((float) 30));
        jLabelBookRoom.setText("System ADMIN");

        JPanel panelLine = new JPanel();
        panelLine.setBackground(Color.BLACK);
        panelLine.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        panelLine.setPreferredSize(new Dimension(500, 5));
        panelLine.setMaximumSize(new Dimension(500, 4));

        panelAdmin.add(jLabelBookRoom);
        panelAdmin.add(panelLine);

        panelTop.add(buttonExit);
        panelTop.add(panelAdmin);
        // -------------------------------- Panel ข้างบนสุด ------------------------

        // -------------------------------- Panel ปุ่มเปลี่ยนหน้า -----------------
        JPanel panelButtonSwitch = new JPanel();
        panelButtonSwitch.setOpaque(false);
        panelButtonSwitch.setLayout(new GridLayout(2, 3, 5, 5));
        panelButtonSwitch.setBackground(Color.WHITE);
        panelButtonSwitch.setMaximumSize(new Dimension(400, 100));

        int SIZE_FONTBUTTON = 16;
        int STYLE_FONTBUTTON = 1;
        Font fontButton = FontTWCENMT.deriveFont(STYLE_FONTBUTTON, SIZE_FONTBUTTON).deriveFont((float) SIZE_FONTBUTTON);

        JButton jOrder = new JButton();
        jOrder.setBackground(new Color(0, 161, 255));
        jOrder.setForeground(Color.WHITE);
        jOrder.setFont(fontButton.deriveFont((float) 25));
        jOrder.setText("ORDER");
        jOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonOrderActionPerFormed(e);
            }
        });

        JButton jBook = new JButton();
        jBook.setBackground(new Color(255, 55, 55));
        jBook.setForeground(Color.WHITE);
        jBook.setFont(fontButton.deriveFont((float) 25));
        jBook.setText("BOOK");
        jBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonMyBookActionPerFormed(e);
            }
        });

        JButton jProfit = new JButton();
        jProfit.setBackground(new Color(4, 153, 23));
        jProfit.setForeground(Color.WHITE);
        jProfit.setFont(fontButton.deriveFont((float) 25));
        jProfit.setText("PROFIT");
        jProfit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonProfitActionPerFormed(e);
            }
        });

        JButton jAddAndRemove = new JButton();
        jAddAndRemove.setBackground(new Color(140, 82, 255));
        jAddAndRemove.setForeground(Color.WHITE);
        jAddAndRemove.setFont(fontButton);
        jAddAndRemove.setText("ADD/REMOVE");
        jAddAndRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonAddAndRemoveActionPerformed(e);
            }
        });

        panelButtonSwitch.add(jBook);
        panelButtonSwitch.add(jOrder);
        panelButtonSwitch.add(jProfit);
        panelButtonSwitch.add(jAddAndRemove);
        panelButtonSwitch.add(Box.createRigidArea(new Dimension(50, 50)));
        panelButtonSwitch.add(Box.createRigidArea(new Dimension(50, 50)));
        // -------------------------------- Panel ปุ่มเปลี่ยนหน้า -----------------

        // -------------------------------- Panel อักษรใต้ปุ่ม -----------------
        JPanel panelText = new JPanel();
        panelText.setOpaque(false);
        panelText.setLayout(new BoxLayout(panelText, BoxLayout.X_AXIS));
        panelText.setBackground(Color.WHITE);
        panelText.setMaximumSize(new Dimension(400, 20));

        JLabel jPleaseTopUp = new JLabel();
        jPleaseTopUp.setFont(new Font("Segoe UI", 0, 10));
        jPleaseTopUp.setForeground(new Color(255, 0, 0));
        jPleaseTopUp.setText("* PLEASE TOP UP TO USE THE APP");

        panelText.add(jPleaseTopUp);
        // -------------------------------- Panel อักษรใต้ปุ่ม -----------------

        // -------------------------------- Panel PROFIT -----------------
        JPanel jPanelProfit = new JPanel();
        jPanelProfit.setLayout(new BoxLayout(jPanelProfit, BoxLayout.Y_AXIS));
        jPanelProfit.setBackground(new Color(250, 248, 227));
        jPanelProfit.setMaximumSize(new Dimension(400, 398));

        JPanel jPanelProfitTop = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        jPanelProfitTop.setBackground(Color.WHITE);
        jPanelProfitTop.setOpaque(false);
        jPanelProfitTop.setMaximumSize(new Dimension(400, 50));

        JLabel jLabelOnlist = new JLabel();
        jLabelOnlist.setFont(FontTWCENMT.deriveFont((float) 42).deriveFont((int) 1));
        jLabelOnlist.setForeground(new Color(1, 41, 94));
        jLabelOnlist.setText("PROFIT");

        jPanelProfitTop.add(jLabelOnlist);

        JPanel jPanelProfitButtom = new JPanel();
        jPanelProfitButtom.setLayout(new BoxLayout(jPanelProfitButtom, BoxLayout.Y_AXIS));
        jPanelProfitButtom.setBackground(Color.WHITE);
        jPanelProfitButtom.setOpaque(false);
        jPanelProfitButtom.setMaximumSize(new Dimension(400, 350));

        JPanel panelMoneyProfit = new RoundedPanel(30, 30, Color.BLACK, 4);
        panelMoneyProfit.setLayout(new FlowLayout(FlowLayout.CENTER,10,22));
        panelMoneyProfit.setBackground(Color.WHITE);
        panelMoneyProfit.setMaximumSize(new Dimension(300, 75));

        JLabel labelProfit = new JLabel();
        double money = mainframe.getSystemMoney().getProfit();
        double twoDecimald = Math.floor(money * 100) / 100;
        labelProfit.setText(Double.toString(twoDecimald));
        labelProfit.setFont(FontTWCENMT.deriveFont(1).deriveFont((float)30));

        panelMoneyProfit.add(labelProfit);

        jPanelProfitButtom.add(panelMoneyProfit);

        jPanelProfit.add(jPanelProfitTop);
        jPanelProfit.add(jPanelProfitButtom);
        // -------------------------------- Panel PROFIT -----------------

        panelSecound.add(panelTop);
        panelSecound.add(panelButtonSwitch);
        panelSecound.add(panelText);
        panelSecound.add(jPanelProfit);

        panelMain.add(Box.createVerticalStrut(10));
        panelMain.add(panelSecound);

        revalidate();
        repaint();
    }

    private void jButtonProfitActionPerFormed(ActionEvent evt) {
        mainframe.showPanel("admin_Profit");
    }

    private void jButtonOrderActionPerFormed(ActionEvent evt) {
        mainframe.showPanel("admin_Order");
    }

    private void jButtonLogoutActionPerformed(ActionEvent evt) {
        mainframe.showPanel("login");
    }

    private void jButtonMyBookActionPerFormed(ActionEvent evt) {
        mainframe.showPanel("admin_Book");
    }

    private void jButtonAddAndRemoveActionPerformed(ActionEvent evt) {
        mainframe.showPanel("admin_AddAndRemove");
    }

    public void reGUI() {
        initComponents();
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

}