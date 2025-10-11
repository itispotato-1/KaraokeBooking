package GUI;

import javax.swing.*;
import javax.swing.border.Border;

import GUI.Decorate.RoundedButton;
import GUI.Decorate.RoundedPanel;
import lib.BookRoom.Room;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;

public class MyOrder extends JPanel {
        private Font FontITCKRIST;
        private Font FontTWCENMT;
        private Mainframe mainframe;
        private File fileRoomList = null;
        private FileReader fr = null;
        private BufferedReader br = null;

        private JPanel panelFoodAndDrinkIn;
        private JLabel jOpen;

        public MyOrder(Mainframe mainframe) {
                fileRoomList = new File("./file/RoomTimes.csv");

                this.mainframe = mainframe;
                setUpFont();
                setVisible(true);
                initComponents();
        }

        private void initComponents() {
                removeAll();

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

                JPanel panelMoney = new JPanel();
                panelMoney.setLayout(new BoxLayout(panelMoney, BoxLayout.X_AXIS));
                panelMoney.setBackground(new Color(255, 255, 204));
                panelMoney.setMaximumSize(new Dimension(200, 40));
                panelMoney.setBounds(150, 15, 115, 30);

                JLabel labelMoney = new JLabel();
                labelMoney.setBackground(new Color(255, 255, 255));
                labelMoney.setFont(FontTWCENMT.deriveFont((float) 14).deriveFont((int) 1)); // NOI18N
                labelMoney.setText("MONEY : " + mainframe.getUser().getMoney());// ไว้แก้Money

                panelMoney.add(Box.createHorizontalStrut(5));
                panelMoney.add(labelMoney);

                JPanel panelBookRoom = new JPanel();
                panelBookRoom.setOpaque(false);
                panelBookRoom.setLayout(new BoxLayout(panelBookRoom, BoxLayout.Y_AXIS));
                panelBookRoom.setBackground(Color.WHITE);
                panelBookRoom.setPreferredSize(new Dimension(250, 50));
                panelBookRoom.setMaximumSize(new Dimension(250, 50));
                panelBookRoom.setBounds(270, 5, 130, 50);

                JLabel jLabelBookRoom = new JLabel();
                jLabelBookRoom.setFont(FontITCKRIST.deriveFont((float) 14));
                jLabelBookRoom.setText("BOOK A ROOM");

                JPanel panelLine = new JPanel();
                panelLine.setBackground(Color.BLACK);
                panelLine.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
                panelLine.setPreferredSize(new Dimension(250, 5));
                panelLine.setMaximumSize(new Dimension(250, 4));

                panelBookRoom.add(Box.createVerticalStrut(10));
                panelBookRoom.add(jLabelBookRoom);
                panelBookRoom.add(Box.createVerticalStrut(5));
                panelBookRoom.add(panelLine);
                panelBookRoom.add(Box.createVerticalStrut(10));

                panelTop.add(buttonExit);
                panelTop.add(panelMoney);
                panelTop.add(panelBookRoom);
                // -------------------------------- Panel ข้างบนสุด ------------------------

                // -------------------------------- Panel เวลา ------------------------
                JPanel panelTime = new JPanel(new BorderLayout());
                panelTime.setOpaque(false);
                panelTime.setLayout(new BoxLayout(panelTime, BoxLayout.X_AXIS));
                panelTime.setBackground(Color.WHITE);
                panelTime.setMaximumSize(new Dimension(300, 50));

                jOpen = new JLabel("NULL");
                jOpen.setFont(FontITCKRIST.deriveFont((float) 18));
                setUpTime();

                panelTime.add(Box.createHorizontalGlue());
                panelTime.add(jOpen);
                panelTime.add(Box.createHorizontalGlue());
                // -------------------------------- Panel เวลา ------------------------

                // -------------------------------- Panel ปุ่มเปลี่ยนหน้า -----------------
                JPanel panelButtonSwitch = new JPanel();
                panelButtonSwitch.setOpaque(false);
                panelButtonSwitch.setLayout(new GridLayout(2, 3, 5, 5));
                panelButtonSwitch.setBackground(Color.WHITE);
                panelButtonSwitch.setMaximumSize(new Dimension(400, 100));

                int SIZE_FONTBUTTON = 16;
                int STYLE_FONTBUTTON = 1;
                Font fontButton = FontTWCENMT.deriveFont(STYLE_FONTBUTTON, SIZE_FONTBUTTON)
                                .deriveFont((float) SIZE_FONTBUTTON);

                JButton jBookingButton = new JButton();
                jBookingButton.setBackground(new Color(163, 228, 255));
                jBookingButton.setFont(fontButton);
                jBookingButton.setText("BOOKING");
                jBookingButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                jButtonBookingActionPerFormed(e);
                        }
                });

                JButton jMyBooking = new JButton();
                jMyBooking.setBackground(new Color(245, 147, 130));
                jMyBooking.setFont(fontButton);
                jMyBooking.setText("MY BOOKING");
                jMyBooking.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                jButtonMyBookingActionPerFormed(e);
                        }
                });

                JButton jOrderFood = new JButton();
                jOrderFood.setBackground(new Color(250, 206, 172));
                jOrderFood.setFont(fontButton);
                jOrderFood.setText("ORDER FOOD");
                jOrderFood.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                jButtonOrderActionPerFormed(e);
                        }
                });

                JButton jTopUp = new JButton();
                jTopUp.setBackground(new Color(204, 255, 204));
                jTopUp.setFont(fontButton);
                jTopUp.setText("TOP UP");
                jTopUp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                jButton1TopupActionPerformed(e);
                        }
                });

                JButton jMyOrder = new JButton();
                jMyOrder.setBackground(new Color(250, 186, 255));
                jMyOrder.setFont(fontButton);
                jMyOrder.setText("MY ORDER");
                jMyOrder.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                jButton1MyOrderActionPerformed(e);
                        }
                });

                panelButtonSwitch.add(jMyBooking);
                panelButtonSwitch.add(jBookingButton);
                panelButtonSwitch.add(jOrderFood);
                panelButtonSwitch.add(jTopUp);
                panelButtonSwitch.add(jMyOrder);
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

                // -------------------------------- Panel อาหารและน้ำ -----------------
                JPanel jPanelRoom = new JPanel();
                jPanelRoom.setLayout(new BoxLayout(jPanelRoom, BoxLayout.Y_AXIS));
                jPanelRoom.setBackground(new Color(250, 248, 227));
                jPanelRoom.setMaximumSize(new Dimension(400, 403));

                JPanel jPanelRoomTop = new JPanel(new FlowLayout(FlowLayout.CENTER));
                jPanelRoomTop.setBackground(Color.WHITE);
                jPanelRoomTop.setOpaque(false);
                jPanelRoomTop.setPreferredSize(new Dimension(350, 45));
                jPanelRoomTop.setMaximumSize(new Dimension(350, 45));
                jPanelRoomTop.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

                JLabel jLabelOnlist = new JLabel();
                jLabelOnlist.setFont(FontTWCENMT.deriveFont((float) 35).deriveFont((int) 1));
                jLabelOnlist.setForeground(new Color(1, 41, 94));
                jLabelOnlist.setText("MY ORDER");

                jPanelRoomTop.add(jLabelOnlist, BorderLayout.CENTER);

                JPanel jPanelRoomCenter = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
                jPanelRoomCenter.setBackground(Color.WHITE);
                jPanelRoomCenter.setOpaque(false);
                jPanelRoomCenter.setMaximumSize(new Dimension(380, 320));

                panelFoodAndDrinkIn = new JPanel(null);
                panelFoodAndDrinkIn.setBackground(Color.WHITE);

                loadMyOrder();

                int maxHeight = 0;
                for (Component comp : panelFoodAndDrinkIn.getComponents()) {
                        Rectangle bounds = comp.getBounds();
                        maxHeight = Math.max(maxHeight, bounds.y + bounds.height);
                }
                panelFoodAndDrinkIn.setPreferredSize(new Dimension(getSize().width, maxHeight + 20));
                // -------------------------------------------------------------------------------
                JScrollPane jScrollPane1 = new JScrollPane();
                jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                jScrollPane1.getVerticalScrollBar().setUnitIncrement(8);
                jScrollPane1.setBackground(Color.WHITE);
                jScrollPane1.setViewportView(panelFoodAndDrinkIn);
                jScrollPane1.setPreferredSize(new Dimension(380, 310));
                jScrollPane1.setBorder(BorderFactory.createLineBorder(new Color(0, 74, 173), 3));

                jPanelRoomCenter.add(jScrollPane1);

                jPanelRoom.add(jPanelRoomTop);
                jPanelRoom.add(jPanelRoomCenter);

                // -------------------------------- Panel ห้อง -----------------

                panelSecound.add(panelTop);
                panelSecound.add(panelTime);
                panelSecound.add(panelButtonSwitch);
                panelSecound.add(panelText);
                panelSecound.add(jPanelRoom);

                panelMain.add(Box.createVerticalStrut(10));
                panelMain.add(panelSecound);

                revalidate();

                repaint();

        }

        private void jButtonOrderActionPerFormed(ActionEvent evt) {
                mainframe.showPanel("menufood");
        }

        private void jButtonBookingActionPerFormed(ActionEvent evt) {
                mainframe.showPanel("book");
        }

        private void jButtonLogoutActionPerformed(ActionEvent evt) {
                mainframe.showPanel("login");
        }

        private void jButtonMyBookingActionPerFormed(ActionEvent evt) {
                mainframe.showPanel("mybooking");
        }

        private void jButton1TopupActionPerformed(ActionEvent evt) {
                mainframe.showPanel("topup");
        }

        private void jButton1MyOrderActionPerformed(ActionEvent evt) {
                mainframe.showPanel("myorder");
        }

        private void loadMyOrder() {
                // ----------------------------- Setup --------------------------------
                int SIZE_SETUP = 100;
                RoundedPanel[] panelOrderIn = new RoundedPanel[SIZE_SETUP];
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

                int x = 20, y = 10, i = 0;
                for (String Order : mainframe.getCatalog().getOrder(mainframe.getUserId())) {
                        String[] tempSplit = Order.split("[|]");
                        // [0]ID [1]PRODUCT [2]AMOUNT [3]PRICE [4]ID_PRODUCT
                        int ID = Integer.parseInt(tempSplit[0]);
                        String PRODUCT = tempSplit[1];
                        int AMOUNT = Integer.parseInt(tempSplit[2].substring(1));
                        double PRICE = Double.parseDouble(tempSplit[3]);
                        String[] tempSplitNameOrder = tempSplit[1].trim().split("[+]");
                        panelOrderIn[i] = new RoundedPanel(30, 30, Color.black, 4);
                        panelOrderIn[i].setBackground(new Color(230, 230, 230));
                        panelOrderIn[i].setLayout(new BoxLayout(panelOrderIn[i], BoxLayout.X_AXIS));
                        panelOrderIn[i].setBounds(x, y, 320, 150);

                        panelLeft[i] = new JPanel(new FlowLayout(FlowLayout.RIGHT, 3, 7));
                        panelLeft[i].setMaximumSize(new Dimension(150, 150));
                        panelLeft[i].setBackground(Color.GRAY);
                        panelLeft[i].setOpaque(false);

                        labelImg[i] = new JLabel("");
                        ImageIcon tempImageIcon1 = null;
                        if (tempSplit[4].charAt(0) == 'F') {
                                tempImageIcon1 = new ImageIcon("./GUI/Picture/Food/" + tempSplit[4] + ".jpg");
                        } else if (tempSplit[4].charAt(0) == 'D') {
                                tempImageIcon1 = new ImageIcon("./GUI/Picture/Drink/" + tempSplit[4] + ".jpg");
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
                        labelNameOrder[i].setText(tempSplitNameOrder[0]);
                        labelNameOrder[i].setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 20));
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
                        lableAmount[i].setText("x"+AMOUNT);
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
                        textAreaCost[i].setText(tempSplit[3]);
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

                        buttonCancel1[i] = new JButton("CANCEL x1");
                        buttonCancel1[i].setForeground(Color.WHITE);
                        buttonCancel1[i].setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 15));
                        buttonCancel1[i].setPreferredSize(new Dimension(105, 40));
                        buttonCancel1[i].setBackground(Color.red);
                        buttonCancel1[i].putClientProperty(1, Order);
                        buttonCancel1[i].addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                        int confirm = JOptionPane.showConfirmDialog(MyOrder.this, "Do you want to remove x1 "+tempSplitNameOrder[0]+"?",
                                                        "Confirmation", JOptionPane.YES_NO_OPTION);

                                        if (confirm == JOptionPane.YES_OPTION) {
                                        mainframe.getCatalog().removeOrder(ID, PRODUCT,
                                                        1);
                                        mainframe.getUser().setMoney(
                                                        mainframe.getUser().getMoney() + ((PRICE * AMOUNT) * 0.70));
                                        reGUI();
                                        }
                                }
                        });

                        buttonCancelAll[i] = new JButton("ALL");
                        buttonCancelAll[i].setForeground(Color.WHITE);
                        buttonCancelAll[i].setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 11));
                        buttonCancelAll[i].setPreferredSize(new Dimension(45, 40));
                        buttonCancelAll[i].setBackground(Color.red);
                        buttonCancelAll[i].putClientProperty(1, Order);
                        buttonCancelAll[i].addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                        int confirm = JOptionPane.showConfirmDialog(MyOrder.this, "Do you want to removeAll "+tempSplitNameOrder[0]+"?",
                                                        "Confirmation", JOptionPane.YES_NO_OPTION);

                                        if (confirm == JOptionPane.YES_OPTION) {
                                                mainframe.getCatalog().removeOrder(ID, PRODUCT,
                                                                AMOUNT);
                                                mainframe.getUser().setMoney(mainframe.getUser().getMoney() + (PRICE * 0.70));
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

                        panelOrderIn[i].add(panelLeft[i]);
                        panelOrderIn[i].add(panelRight[i]);

                        panelFoodAndDrinkIn.add(panelOrderIn[i]);
                        y += 160;
                        i++;
                }
        }

        private void setUpTime() {
                String tempPMAM1;
                String tempPMAM2;
                if (mainframe.getHourStart() <= 12) {
                        tempPMAM1 = "A.M.";
                } else {
                        tempPMAM1 = "P.M.";
                }
                if (mainframe.getHourEnd() <= 12) {
                        tempPMAM2 = "A.M.";
                } else {
                        tempPMAM2 = "P.M.";
                }

                if (mainframe.getMinuteStartEnd() == 0) {
                        jOpen.setText("OPEN " + mainframe.getHourStart() + " : 00 " + tempPMAM1 + " - "
                                        + mainframe.getHourEnd() + " : 00 " + tempPMAM2);
                } else {
                        jOpen.setText("OPEN " + mainframe.getHourStart() + " : " + mainframe.getMinuteStartEnd() + " "
                                        + tempPMAM1 + " - " + mainframe.getHourEnd() + " : "
                                        + mainframe.getMinuteStartEnd() + " " + tempPMAM2);
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