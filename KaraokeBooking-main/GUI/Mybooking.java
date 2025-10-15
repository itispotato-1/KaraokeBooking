package GUI;

import javax.swing.*;

import GUI.Decorate.RoundedPanel;
import lib.BookRoom.Room;
import lib.BookRoom.RoomTime;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;

public class Mybooking extends JPanel {
        private Font FontITCKRIST;
        private Font FontTWCENMT;
        private Mainframe mainframe;
        private File fileRoomList = null;
        private FileReader fr = null;
        private BufferedReader br = null;

        private JList<String> jListRoom;
        private JPanel panelRoominside;

        private JLabel jLabelTimeOpen;

        public Mybooking(Mainframe mainframe) {
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

                jLabelTimeOpen = new JLabel("NULL");
                jLabelTimeOpen.setFont(FontITCKRIST.deriveFont((float) 18));
                setUpTime();

                panelTime.add(Box.createHorizontalGlue());
                panelTime.add(jLabelTimeOpen);
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

                // -------------------------------- Panel ห้อง -----------------
                JPanel jPanelRoom = new JPanel();
                jPanelRoom.setLayout(new BoxLayout(jPanelRoom, BoxLayout.Y_AXIS));
                jPanelRoom.setBackground(new Color(250, 248, 227));
                jPanelRoom.setMaximumSize(new Dimension(400, 390));

                JPanel jPanelRoomTop = new JPanel(new FlowLayout(FlowLayout.CENTER));
                jPanelRoomTop.setBackground(Color.WHITE);
                jPanelRoomTop.setOpaque(false);
                jPanelRoomTop.setMaximumSize(new Dimension(350, 50));
                jPanelRoomTop.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

                JLabel jLabelOnlist = new JLabel();
                jLabelOnlist.setFont(FontTWCENMT.deriveFont((float) 35).deriveFont((int) 1));
                jLabelOnlist.setForeground(new Color(1, 41, 94));
                jLabelOnlist.setText("MY BOOKING");

                jPanelRoomTop.add(jLabelOnlist, BorderLayout.CENTER);

                JPanel jPanelRoomCenter = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
                jPanelRoomCenter.setBackground(Color.WHITE);
                jPanelRoomCenter.setOpaque(false);
                jPanelRoomCenter.setMaximumSize(new Dimension(380, 300));

                // ----------------------------- SetupRoomSelection -----------------------
                int rows;
                if (mainframe.getSystem().getBookTime(mainframe.getUser()).size() % 2 == 0) {
                        rows = mainframe.getSystem().getBookTime(mainframe.getUser()).size() / 2;
                } else {
                        rows = (mainframe.getSystem().getBookTime(mainframe.getUser()).size() / 2) + 1;
                }
                if (rows == 1) {
                        rows = 2;
                }
                panelRoominside = new JPanel();
                panelRoominside = new JPanel();
                panelRoominside.setLayout(new GridLayout(rows, 2, 5, 5));
                panelRoominside.setBackground(new Color(250, 248, 227));
                panelRoominside.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

                setUpRoomRemove();

                JScrollPane jScrollPane1 = new JScrollPane();
                jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                jScrollPane1.getVerticalScrollBar().setUnitIncrement(8);
                jScrollPane1.setBackground(Color.WHITE);
                jScrollPane1.setViewportView(panelRoominside);
                jScrollPane1.setPreferredSize(new Dimension(380, 330));
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

        private void jButtonRemoveRoom(ActionEvent e) {
                if (jListRoom.getSelectedValue() != null) {
                        System.out.println("tst");
                        String tempS = jListRoom.getSelectedValue();
                        String[] tempSplit = tempS.split("[:\\s\\-]");
                        Room tempRoom = null;
                        for (Room room : mainframe.getSystem().getRooms()) {

                                if (Integer.parseInt(tempSplit[0]) == room.getIdRoom()) {
                                        tempRoom = room;
                                        break;
                                }
                        }

                        int[] tempInt = new int[tempSplit.length];
                        for (int i = 0; i < tempInt.length; i++) {
                                try {
                                        tempInt[i] = Integer.parseInt(tempSplit[i]);
                                } catch (Exception ea) {
                                        tempInt[i] = 0;
                                }
                        }
                        LocalDateTime timeStart = LocalDateTime.of(tempInt[5], tempInt[4], tempInt[3], tempInt[6],
                                        tempInt[7], tempInt[8]);
                        LocalDateTime timeEnd = LocalDateTime.of(tempInt[5], tempInt[4], tempInt[3], tempInt[14],
                                        tempInt[15], tempInt[16]);
                        mainframe.getSystem().removeBookRoom(tempRoom, mainframe.getUser(), timeStart, timeEnd);
                        initComponents();
                }
        }

        private void setUpRoomRemove() {
                RoundedPanel[] panelRoom = new RoundedPanel[100];
                JLabel[] labelRoomInPanel = new JLabel[100];
                JLabel[] labelForInPanel = new JLabel[100];
                JLabel[] labelCostInPanel = new JLabel[100];
                JLabel[] labelTimeInPanel = new JLabel[100];
                JLabel[] labelDateInPanel = new JLabel[100];
                JButton[] buttonRemoveRoom = new JButton[100];

                int i = 0;
                for (RoomTime roomTime : mainframe.getSystem().getBookTime(mainframe.getUser())) {
                        panelRoom[i] = new RoundedPanel(30, 30, Color.BLACK, 4);
                        panelRoom[i].setLayout(new BoxLayout(panelRoom[i], BoxLayout.Y_AXIS));
                        panelRoom[i].setBackground(Color.WHITE);
                        panelRoom[i].setPreferredSize(new Dimension(155, 150));

                        labelRoomInPanel[i] = new JLabel();
                        labelRoomInPanel[i].setFont(FontTWCENMT.deriveFont((float) 20).deriveFont((int) 1));
                        labelRoomInPanel[i].setText("Room " + roomTime.getRoom().getIdRoom());
                        labelRoomInPanel[i].setMaximumSize(new Dimension(175, 25));
                        labelRoomInPanel[i].setAlignmentX(Component.CENTER_ALIGNMENT);
                        labelRoomInPanel[i].setHorizontalAlignment(SwingConstants.CENTER);

                        labelForInPanel[i] = new JLabel();
                        labelForInPanel[i].setFont(FontTWCENMT.deriveFont((float) 20).deriveFont((int) 1));
                        labelForInPanel[i].setText("For : " + roomTime.getRoom().getFor());
                        labelForInPanel[i].setMaximumSize(new Dimension(175, 25));
                        labelForInPanel[i].setAlignmentX(Component.CENTER_ALIGNMENT);
                        labelForInPanel[i].setHorizontalAlignment(SwingConstants.CENTER);

                        labelCostInPanel[i] = new JLabel();
                        labelCostInPanel[i].setFont(FontTWCENMT.deriveFont((float) 20).deriveFont((int) 1));
                        labelCostInPanel[i].setText("Cost : " + roomTime.getRoom().getPrice());
                        labelCostInPanel[i].setMaximumSize(new Dimension(175, 25));
                        labelCostInPanel[i].setAlignmentX(Component.CENTER_ALIGNMENT);
                        labelCostInPanel[i].setHorizontalAlignment(SwingConstants.CENTER);

                        labelTimeInPanel[i] = new JLabel();
                        labelTimeInPanel[i].setFont(FontTWCENMT.deriveFont((float) 15).deriveFont((int) 1));
                        String time = "Time : " + roomTime.getTimeStart().getHour() + ":"
                                        + roomTime.getTimeStart().getMinute()
                                        + ":" + roomTime.getTimeStart().getSecond() + " - "
                                        + roomTime.getTimeEnd().getHour() + ":"
                                        + roomTime.getTimeEnd().getMinute()
                                        + ":" + roomTime.getTimeEnd().getSecond();
                        labelTimeInPanel[i].setText(time);
                        labelTimeInPanel[i].setMaximumSize(new Dimension(275, 25));
                        labelTimeInPanel[i].setAlignmentX(Component.CENTER_ALIGNMENT);
                        labelTimeInPanel[i].setHorizontalAlignment(SwingConstants.CENTER);

                        labelDateInPanel[i] = new JLabel();
                        labelDateInPanel[i].setFont(FontTWCENMT.deriveFont((float) 15).deriveFont((int) 1));
                        String date = "Date : " + roomTime.getTimeStart().getDayOfMonth() + ":"
                                        + roomTime.getTimeStart().getMonthValue()
                                        + ":" + roomTime.getTimeStart().getYear();
                        labelDateInPanel[i].setText(date);
                        labelDateInPanel[i].setMaximumSize(new Dimension(275, 25));
                        labelDateInPanel[i].setAlignmentX(Component.CENTER_ALIGNMENT);
                        labelDateInPanel[i].setHorizontalAlignment(SwingConstants.CENTER);

                        buttonRemoveRoom[i] = new JButton();
                        buttonRemoveRoom[i].setFont(FontTWCENMT.deriveFont((float) 20).deriveFont((int) 1));
                        buttonRemoveRoom[i].setText("Remove");
                        buttonRemoveRoom[i].setBackground(Color.red);
                        buttonRemoveRoom[i].setForeground(Color.WHITE);
                        buttonRemoveRoom[i].setMaximumSize(new Dimension(135, 40));
                        buttonRemoveRoom[i].setAlignmentX(Component.CENTER_ALIGNMENT);
                        buttonRemoveRoom[i].putClientProperty(1, roomTime);
                        buttonRemoveRoom[i].addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                        JButton tempButton = (JButton) e.getSource();//
                                        RoomTime tempRoom = (RoomTime) tempButton.getClientProperty(1);
                                        int confirm = JOptionPane.showConfirmDialog(Mybooking.this,
                                                        "Do you want to remove?",
                                                        "Confirmation", JOptionPane.YES_NO_OPTION);

                                        if (confirm == JOptionPane.YES_OPTION) {
                                                mainframe.getSystem().removeBookRoom(tempRoom.getRoom(),
                                                                tempRoom.getUser(),
                                                                tempRoom.getTimeStart(), tempRoom.getTimeEnd());
                                                String[] tempStr = mainframe.getService().getValueUserList(
                                                                tempRoom.getUser().getUsername(),
                                                                tempRoom.getUser().getPassword());
                                                tempRoom.getUser().setMoney(Double.parseDouble(tempStr[4]));// ตั้งค่าเงินของผู้ใช้
                                                
                                                tempRoom.getUser().setMoney(tempRoom.getUser().getMoney()
                                                                + (tempRoom.getRoom().getPrice() * 0.70));// คืนเงิน
                                                                                                          // 70%จำนวน
                                                mainframe.getService().setMoneyUserInUserList(tempRoom.getUser());
                                                mainframe.getSystemMoney().setProfit((-(tempRoom.getRoom().getPrice() * 0.70)));
                                                reGUI();
                                        }
                                }
                        });

                        panelRoom[i].add(Box.createVerticalStrut(5));
                        panelRoom[i].add(labelRoomInPanel[i]);
                        panelRoom[i].add(labelForInPanel[i]);
                        panelRoom[i].add(labelCostInPanel[i]);
                        panelRoom[i].add(labelDateInPanel[i]);
                        panelRoom[i].add(labelTimeInPanel[i]);
                        panelRoom[i].add(buttonRemoveRoom[i]);
                        panelRoom[i].add(Box.createVerticalStrut(5));

                        panelRoominside.add(panelRoom[i]);
                        i++;
                }
                JPanel emptyPanel1 = new JPanel();
                emptyPanel1.setPreferredSize(new Dimension(125, 125));
                emptyPanel1.setOpaque(false);

                JPanel emptyPanel2 = new JPanel();
                emptyPanel2.setPreferredSize(new Dimension(125, 125));
                emptyPanel2.setOpaque(false);
                if (mainframe.getSystem().getBookTime(mainframe.getUser()).size() == 1 || mainframe.getSystem().getBookTime(mainframe.getUser()).size() == 2) {
                        panelRoominside.add(emptyPanel1);
                        panelRoominside.add(emptyPanel2);
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
                        jLabelTimeOpen.setText("OPEN " + mainframe.getHourStart() + " : 00 " + tempPMAM1 + " - "
                                        + mainframe.getHourEnd() + " : 00 " + tempPMAM2);
                } else {
                        jLabelTimeOpen.setText("OPEN " + mainframe.getHourStart() + " : " + mainframe.getMinuteStartEnd() + " "
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