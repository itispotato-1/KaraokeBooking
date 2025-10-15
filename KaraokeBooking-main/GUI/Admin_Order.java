package GUI;

import javax.swing.*;

import GUI.Decorate.*;
import lib.BookRoom.RoomSystem;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;

public class Admin_Order extends JPanel {
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
    private JPanel panelOrderinside;

    JLabel jOpen;

    public Admin_Order(Mainframe mainframe) {
        this.system = mainframe.getSystem();
        this.mainframe = mainframe;
        setUpFont();
        setVisible(true);
        initComponents();
    }

    private void initComponents() {
        removeAll();
        jLabelRoom = new JLabel[100];//
        jLabelAvalible = new JLabel[100];//
        jLabelCost = new JLabel[100];//
        jPanelBooking = new JPanel[100];//
        jButton = new JButton[100];//

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

        // panelAdmin.add(Box.createVerticalStrut(10));
        panelAdmin.add(jLabelBookRoom);
        // panelAdmin.add(Box.createVerticalStrut(5));
        panelAdmin.add(panelLine);
        // panelAdmin.add(Box.createVerticalStrut(10));

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
                jButtonBookActionPerFormed(e);
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

        // -------------------------------- Panel Order -----------------
        JPanel jPanelOrder = new JPanel();
        jPanelOrder.setLayout(new BoxLayout(jPanelOrder, BoxLayout.Y_AXIS));
        jPanelOrder.setBackground(new Color(250, 248, 227));
        jPanelOrder.setMaximumSize(new Dimension(400, 398));

        JPanel jPanelOrderTop = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        jPanelOrderTop.setBackground(Color.WHITE);
        jPanelOrderTop.setOpaque(false);
        jPanelOrderTop.setMaximumSize(new Dimension(400, 50));
        // jPanelRoomTop.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel jLabelOnlist = new JLabel();
        jLabelOnlist.setFont(FontTWCENMT.deriveFont((float) 42).deriveFont((int) 1));
        jLabelOnlist.setForeground(new Color(1, 41, 94));
        jLabelOnlist.setText("ORDER");

        jPanelOrderTop.add(jLabelOnlist);

        JPanel jPanelRoomButtom = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        jPanelRoomButtom.setBackground(Color.WHITE);
        jPanelRoomButtom.setMaximumSize(new Dimension(400, 350));

        // ----------------------------- SetupRoomSelection -----------------------
        int rows = mainframe.getProductSystem().getOrderAll().size();
        if (rows == 1) {
            rows = 2;
        }
        //System.out.println(rows);
        panelOrderinside = new JPanel();
        panelOrderinside.setLayout(new GridLayout(rows + 1, 1, 5, 5));
        panelOrderinside.setBackground(new Color(250, 248, 227));
        panelOrderinside.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        setUpOrderRemove();

        int SPEED_SCROLLBAR = 8;
        JScrollPane scroll = new JScrollPane(panelOrderinside);
        scroll.setPreferredSize(new Dimension(380, 350));
        scroll.getVerticalScrollBar().setUnitIncrement(SPEED_SCROLLBAR);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(0, 74, 173), 4, true));
        jPanelRoomButtom.add(scroll);
        // ----------------------------- SetupRoomSelection -----------------------

        jPanelOrder.add(jPanelOrderTop);
        jPanelOrder.add(jPanelRoomButtom);
        // -------------------------------- Panel ห้อง -----------------

        panelSecound.add(panelTop);
        panelSecound.add(panelButtonSwitch);
        panelSecound.add(panelText);
        panelSecound.add(jPanelOrder);

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

    private void jButtonBookActionPerFormed(ActionEvent evt) {
        mainframe.showPanel("admin_Book");
    }

    private void jButtonAddAndRemoveActionPerformed(ActionEvent evt) {
        mainframe.showPanel("admin_AddAndRemove");
    }

    private void setUpOrderRemove() {
        int SIZE_SETUP = 100;
        RoundedPanel[] panelOrder = new RoundedPanel[SIZE_SETUP];
        JPanel[] panelLeft = new JPanel[SIZE_SETUP];
        JPanel[] panelRight = new JPanel[SIZE_SETUP];
        JLabel[] labelImg = new JLabel[SIZE_SETUP];
        JPanel[] panelRightTop = new JPanel[SIZE_SETUP];
        JPanel[] panelRightCenter = new JPanel[SIZE_SETUP];
        JPanel[] panelRightBottom = new JPanel[SIZE_SETUP];
        JLabel[] labelNameOrder = new JLabel[SIZE_SETUP];
        JLabel[] labelToppingOrder = new JLabel[SIZE_SETUP];
        JLabel[] lableAmount = new JLabel[SIZE_SETUP];
        JButton[] buttonCancel1 = new JButton[SIZE_SETUP];
        JButton[] buttonCancelAll = new JButton[SIZE_SETUP];
        JTextField[] textAreaCost = new JTextField[SIZE_SETUP];

        int i = 0;
        for (String Order : mainframe.getProductSystem().getOrderAll()) {
            String[] tempSplit = Order.split("[|]");
            // [0]ID [1]PRODUCT [2]AMOUNT [3]PRICE [4]ID_PRODUCT
            int ID = Integer.parseInt(tempSplit[0]);
            String PRODUCT = tempSplit[1];
            int AMOUNT = Integer.parseInt(tempSplit[2].substring(1));
            double PRICE = Double.parseDouble(tempSplit[3]);
            String ID_PRODUCT = tempSplit[4];
            String[] tempSplitNameOrder = tempSplit[1].trim().split("[+]");
            
            panelOrder[i] = new RoundedPanel(30, 30, Color.BLACK, 4);
            panelOrder[i].setLayout(new BoxLayout(panelOrder[i], BoxLayout.X_AXIS));
            panelOrder[i].setBackground(Color.WHITE);
            panelOrder[i].setPreferredSize(new Dimension(320, 150));

            panelLeft[i] = new JPanel(new FlowLayout(FlowLayout.RIGHT, 3, 7));
            panelLeft[i].setMaximumSize(new Dimension(150, 150));
            panelLeft[i].setBackground(Color.GRAY);
            panelLeft[i].setOpaque(false);

            labelImg[i] = new JLabel("");
            ImageIcon tempImageIcon1 = null;
            if (ID_PRODUCT.charAt(0) == 'F') {
                tempImageIcon1 = new ImageIcon("./GUI/Picture/Food/" + ID_PRODUCT + ".jpg");
            } else if (ID_PRODUCT.charAt(0) == 'D') {
                tempImageIcon1 = new ImageIcon("./GUI/Picture/Drink/" + ID_PRODUCT + ".jpg");
            }
            Image tempImage1 = tempImageIcon1.getImage().getScaledInstance(130, 130, Image.SCALE_SMOOTH);
            labelImg[i].setIcon(new ImageIcon(tempImage1));
            labelImg[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
            panelLeft[i].add(labelImg[i]);

            panelRight[i] = new JPanel();
            panelRight[i].setLayout(new BoxLayout(panelRight[i], BoxLayout.Y_AXIS));
            panelRight[i].setBackground(Color.BLUE);
            panelRight[i].setOpaque(false);
            panelRight[i].setMaximumSize(new Dimension(170, 150));

            int tempwidth = 150;
            panelRightTop[i] = new JPanel(null);
            panelRightTop[i].setBackground(Color.WHITE);
            panelRightTop[i].setPreferredSize(new Dimension(tempwidth, 60));
            panelRightTop[i].setMaximumSize(new Dimension(tempwidth, 60));

            labelNameOrder[i] = new JLabel();
            labelNameOrder[i].setText("ID:"+ID+"|"+tempSplitNameOrder[0]);
            labelNameOrder[i].setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 15));
            labelNameOrder[i].setBounds(10, 5, 140, 30);

            String tempTopping = "";
            for (int j = 1; j < tempSplitNameOrder.length; j++) {
                tempTopping += "+" + tempSplitNameOrder[j] + " ";
            }
            labelToppingOrder[i] = new JLabel();
            labelToppingOrder[i].setText(tempTopping);
            labelToppingOrder[i].setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 12));
            labelToppingOrder[i].setBounds(10, 25, 140, 30);

            lableAmount[i] = new JLabel();
            lableAmount[i].setText("x" + AMOUNT);
            lableAmount[i].setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 16));
            lableAmount[i].setBounds(10, 37, 140, 30);

            panelRightTop[i].add(labelNameOrder[i]);
            panelRightTop[i].add(lableAmount[i]);
            panelRightTop[i].add(labelToppingOrder[i]);

            panelRightCenter[i] = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
            panelRightCenter[i].setBackground(Color.PINK);
            panelRightCenter[i].setOpaque(false);
            panelRightCenter[i].setPreferredSize(new Dimension(tempwidth, 35));
            panelRightCenter[i].setMaximumSize(new Dimension(tempwidth, 35));

            textAreaCost[i] = new JTextField("0");
            textAreaCost[i].setText(Double.toString(PRICE));
            textAreaCost[i].setFont(FontITCKRIST.deriveFont(1).deriveFont((float) 15));
            textAreaCost[i].setForeground(Color.WHITE);
            textAreaCost[i].setBackground(new Color(182, 77, 0));
            textAreaCost[i].setPreferredSize(new Dimension(tempwidth, 35));
            textAreaCost[i].setHorizontalAlignment(JTextField.RIGHT);
            textAreaCost[i].setEditable(false);

            panelRightCenter[i].add(textAreaCost[i]);

            panelRightBottom[i] = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
            panelRightBottom[i].setBackground(Color.GRAY);
            panelRightBottom[i].setOpaque(false);
            panelRightBottom[i].setPreferredSize(new Dimension(tempwidth, 40));
            panelRightBottom[i].setMaximumSize(new Dimension(tempwidth, 40));

            buttonCancel1[i] = new JButton("CONFIRM x1");
            buttonCancel1[i].setForeground(Color.WHITE);
            buttonCancel1[i].setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 13));
            buttonCancel1[i].setPreferredSize(new Dimension(105, 40));
            buttonCancel1[i].setBackground(new Color(0, 125, 33));
            buttonCancel1[i].putClientProperty(1, Order);
            buttonCancel1[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int confirm = JOptionPane.showConfirmDialog(Admin_Order.this,
                            "Do you want to confirm x1 " + tempSplitNameOrder[0] + "?",
                            "Confirmation", JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.YES_OPTION) {
                        mainframe.getProductSystem().removeOrder(ID, PRODUCT,
                                1);
                        reGUI();
                    }
                }
            });

            buttonCancelAll[i] = new JButton("ALL");
            buttonCancelAll[i].setForeground(Color.WHITE);
            buttonCancelAll[i].setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 11));
            buttonCancelAll[i].setPreferredSize(new Dimension(45, 40));
            buttonCancelAll[i].setBackground(new Color(0, 125, 33));
            buttonCancelAll[i].putClientProperty(1, Order);
            buttonCancelAll[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int confirm = JOptionPane.showConfirmDialog(Admin_Order.this,
                            "Do you want to confirmAll " + tempSplitNameOrder[0] + "?",
                            "Confirmation", JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.YES_OPTION) {
                        mainframe.getProductSystem().removeOrder(ID, PRODUCT,
                                AMOUNT);
                        reGUI();
                    }
                }
            });

            panelRightBottom[i].add(buttonCancel1[i]);
            panelRightBottom[i].add(buttonCancelAll[i]);

            panelRight[i].add(Box.createVerticalStrut(5));
            panelRight[i].add(panelRightTop[i]);
            panelRight[i].add(panelRightCenter[i]);
            panelRight[i].add(Box.createVerticalStrut(5));
            panelRight[i].add(panelRightBottom[i]);
            panelRight[i].add(Box.createVerticalStrut(5));

            panelOrder[i].add(panelLeft[i]);
            panelOrder[i].add(panelRight[i]);

            panelOrderinside.add(panelOrder[i]);
            i++;
        }

        JPanel emptyPanel1 = new JPanel();
        emptyPanel1.setPreferredSize(new Dimension(125, 125));
        emptyPanel1.setOpaque(false);

        if (mainframe.getSystem().getBookTimeAll().size() == 1) {
            panelOrderinside.add(emptyPanel1);
        }
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