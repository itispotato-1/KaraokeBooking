package GUI;

import javax.swing.*;
import javax.swing.JSpinner.*;
import javax.swing.border.*;

import GUI.Decorate.*;
import lib.BookRoom.Room;
import lib.BookRoom.RoomSystem;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Mybooking extends JPanel {
        private Font FontITCKRIST;
        private Font FontTWCENMT;
        private Mainframe mainframe;
        private DefaultListModel<String> ModelList1;
        private File fileRoomList = null;
        private FileReader fr = null;
        private BufferedReader br = null;

        private JList<String> jListRoom;

        JLabel jOpen;

        public Mybooking(Mainframe mainframe) {
                ModelList1 = new DefaultListModel<>();
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

                panelButtonSwitch.add(jMyBooking);
                panelButtonSwitch.add(jBookingButton);
                panelButtonSwitch.add(jOrderFood);
                panelButtonSwitch.add(jTopUp);
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
                
                jListRoom = new JList<>();
                jListRoom.setBackground(Color.WHITE);
                //jListRoom.setOpaque(false);
                jListRoom.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                jListRoom.setFont(FontITCKRIST.deriveFont(1).deriveFont((float) 14));
                loadRoom();
                jListRoom.setModel(ModelList1);
                JScrollPane jScrollPane1 = new JScrollPane();
                jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                jScrollPane1.getVerticalScrollBar().setUnitIncrement(8);
                jScrollPane1.setBackground(Color.WHITE);
                jScrollPane1.setViewportView(jListRoom);
                jScrollPane1.setPreferredSize(new Dimension(380, 280));
                jScrollPane1.setBorder(BorderFactory.createLineBorder(new Color(0, 74, 173), 3));

                jPanelRoomCenter.add(jScrollPane1);

                JPanel jPanelRoomButtom = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
                jPanelRoomButtom.setBackground(Color.WHITE);
                jPanelRoomButtom.setOpaque(false);
                jPanelRoomButtom.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 0));
                jPanelRoomButtom.setMaximumSize(new Dimension(380, 50));

                JButton jButtonCancel = new JButton();
                jButtonCancel.setBackground(new Color(255, 25, 25));
                jButtonCancel.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 18)); // NOI18N
                jButtonCancel.setForeground(new Color(255, 255, 255));
                jButtonCancel.setPreferredSize(new Dimension(130, 40));
                jButtonCancel.setText("Cancel Room");
                jButtonCancel.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                jButtonRemoveRoom(e);
                        }
                });

                jPanelRoomButtom.add(jButtonCancel);

                jPanelRoom.add(jPanelRoomTop);
                jPanelRoom.add(jPanelRoomCenter);
                jPanelRoom.add(jPanelRoomButtom);

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

        private void loadRoom() {
                ModelList1.clear();
                try {
                        String tempS;
                        fr = new FileReader(fileRoomList);
                        br = new BufferedReader(fr);
                        while ((tempS = br.readLine()) != null) {
                                String[] tempSplit = tempS.split("[)\\(\\;]");
                                if (mainframe.getUser().getUserId() == Integer.parseInt(tempSplit[1])) {
                                        // System.out.println(mainframe.getUser().getUserId()+" = "+tempSplit[1]);
                                        ModelList1.addElement(tempSplit[0] + " Date ; " + tempSplit[2] + " - "
                                                        + tempSplit[3]);
                                }
                        }
                } catch (Exception e) {
                        System.out.println(e);
                } finally {
                        try {
                                br.close();
                                fr.close();
                        } catch (Exception e) {
                                System.out.println(e);
                        }
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