package GUI;

import javax.swing.*;

import GUI.Decorate.RoundedButton;
import lib.Room;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDateTime;

public class Mybooking extends JPanel {
        private Mainframe mainframe;
        private DefaultListModel<String> ModelList1;
        private File fileRoomList = null;
        private FileReader fr = null;
        private BufferedReader br = null;
        private Font FontITCKRIST;
        private Font FontTWCENMT;

        public Mybooking(Mainframe mainframe) {
                ModelList1 = new DefaultListModel<>();
                fileRoomList = new File("./file/RoomTimes.csv");
                this.mainframe = mainframe;

                setUpFont();
                setUpLookAndFeel();
                initComponents();
        }

        public void initComponents() {
                removeAll();
                jLabel1 = new JLabel();
                jLabelBookRoom = new JLabel();
                jMoney = new JLabel();
                jBookingButton = new JButton();
                jMyBooking = new JButton();
                jLabelOnlist = new JLabel();

                jScrollPane1 = new JScrollPane();
                jListRoom = new JList<>();
                jLogOut = new JButton();
                jOrderFood = new JButton();
                jTopUp = new JButton();
                jOpen = new JLabel();
                jPleaseTopUp = new JLabel();
                jPleaseTopUp = new JLabel();

                jMainPanel = new JPanel();
                jPanel2 = new JPanel();
                jPanel3 = new JPanel();
                jPanel4 = new JPanel();
                jPanelOpen = new JPanel();

                add(jMainPanel);
                jMainPanel.setBackground(new Color(235, 240, 255));
                jMainPanel.setPreferredSize(new Dimension(440, 664));

                jLabelBookRoom.setFont(FontITCKRIST.deriveFont((float) 14));
                jLabelBookRoom.setText("BOOK A ROOM");

                jPanel2.setBackground(new Color(255, 255, 204));

                jMoney.setBackground(new Color(255, 255, 255));
                jMoney.setFont(FontTWCENMT.deriveFont((float) 14).deriveFont((int) 1)); // NOI18N
                jMoney.setText("MONEY : " + mainframe.getUser().getMoney());// ไว้แก้Money

                GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jMoney, GroupLayout.DEFAULT_SIZE, 68,
                                                                                Short.MAX_VALUE)
                                                // .addGap(56, 56, 56)
                                                ));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jMoney)
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                jPanel3.setBackground(new Color(0, 0, 0));
                jPanel3.setBorder(
                                BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1), null));
                jPanel3.setPreferredSize(new Dimension(0, 5));

                GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 119, Short.MAX_VALUE));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 0, Short.MAX_VALUE));

                jBookingButton.setBackground(new Color(163, 228, 255));
                jBookingButton.setFont(FontTWCENMT.deriveFont((float) 18)); // NOI18N
                jBookingButton.setText("BOOKING");
                jBookingButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                jButtonBookingActionPerFormed(evt);
                        }
                });

                jMyBooking.setBackground(new Color(245, 147, 130));
                jMyBooking.setFont(FontTWCENMT.deriveFont((float) 18)); // NOI18N
                jMyBooking.setText("MY BOOKING");
                jMyBooking.setPreferredSize(new Dimension(125, 28));
                jMyBooking.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                jButtonMyBookingActionPerFormed(evt);
                        }
                });

                jPanel4.setBackground(new Color(255, 254, 241));

                jLabelOnlist.setFont(FontTWCENMT.deriveFont((float) 24).deriveFont((int) 1)); // NOI18N
                jLabelOnlist.setText("MY BOOKING");

                jButtonCancel = new RoundedButton(20, 20, Color.BLACK, 4);
                jButtonCancel.setBackground(new Color(255, 102, 102));
                jButtonCancel.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 16)); // NOI18N
                jButtonCancel.setForeground(new Color(255, 255, 255));
                jButtonCancel.setText("Cancel Room");
                jButtonCancel.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                jButtonRemoveRoom(e);
                        }
                });

                jListRoom.setBackground(new Color(255, 241, 234));
                jListRoom.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                jListRoom.setFont(FontITCKRIST.deriveFont(1).deriveFont((float) 14));
                loadRoom();
                jListRoom.setModel(ModelList1);
                jScrollPane1.setViewportView(jListRoom);

                GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jButtonCancel, GroupLayout.PREFERRED_SIZE,
                                                                                135, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(21, 21, 21))
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addGap(102, 102, 102)
                                                                .addComponent(jLabelOnlist)
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE))
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE,
                                                                                351, Short.MAX_VALUE)
                                                                .addContainerGap()));
                jPanel4Layout.setVerticalGroup(
                                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabelOnlist, GroupLayout.PREFERRED_SIZE,
                                                                                38, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(8, 8, 8)
                                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE,
                                                                                282, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButtonCancel)
                                                                .addContainerGap(14, Short.MAX_VALUE)));

                jLogOut.setBackground(new Color(255, 89, 100));
                jLogOut.setForeground(new Color(255, 255, 255));
                jLogOut.setText("X");
                jLogOut.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                jButtonLogoutActionPerformed(e);
                        }

                });

                jOrderFood.setBackground(new Color(250, 206, 172));
                jOrderFood.setFont(FontTWCENMT.deriveFont((float) 18));
                jOrderFood.setText("ORDER FOOD");
                jOrderFood.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent e) {
                                jButtonOrderActionPerFormed(e);
                        }

                });

                jTopUp.setBackground(new Color(204, 255, 204));
                jTopUp.setFont(FontTWCENMT.deriveFont((float) 18));
                jTopUp.setText("TOP UP");
                jTopUp.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                jButton1TopupActionPerformed(evt);
                        }
                });

                jPanelOpen.setBackground(new Color(255, 255, 255));

                jOpen.setFont(FontITCKRIST.deriveFont((float) 18));
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
                jPanelOpen.setBackground(Color.white);

                GroupLayout jPanel11Layout = new GroupLayout(jPanelOpen);
                jPanelOpen.setLayout(jPanel11Layout);
                jPanel11Layout.setHorizontalGroup(
                                jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel11Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jOpen)
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                jPanel11Layout.setVerticalGroup(
                                jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel11Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jOpen)
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                jPleaseTopUp.setFont(new Font("Segoe UI", 0, 10));
                jPleaseTopUp.setForeground(new Color(255, 0, 0));
                jPleaseTopUp.setText("* PLEASE TOP UP TO USE THE APP");

                GroupLayout jPanel1Layout = new GroupLayout(jMainPanel);
                jMainPanel.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel1)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jLogOut)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(jPanel3,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                121, Short.MAX_VALUE)
                                                                                .addComponent(jLabelBookRoom,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addGap(15, 15, 15))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jPanel4,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addContainerGap())
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(3)
                                                                                                                                .addComponent(jMyBooking,
                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                136,
                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addPreferredGap(
                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(jBookingButton,
                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                136,
                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addPreferredGap(
                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                                .addComponent(jOrderFood,
                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                136,
                                                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addGap(3)
                                                                                                                                .addComponent(jTopUp,
                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                136,
                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                                                                                .addComponent(jPleaseTopUp,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                193,
                                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(0, 8, Short.MAX_VALUE))
                                                                                .addGroup(GroupLayout.Alignment.TRAILING,
                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                // .addGap(35)
                                                                                                                .addComponent(jPanelOpen,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(65)))));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(18, 18, 18)
                                                                                                .addGroup(
                                                                                                                jPanel1Layout.createParallelGroup(
                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGap(11, 11, 11)
                                                                                                                                                .addComponent(jLabel1))
                                                                                                                                .addComponent(jLogOut))
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.UNRELATED,
                                                                                                                21,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.TRAILING)
                                                                                                                .addComponent(jPanel2,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGroup(jPanel1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jLabelBookRoom,
                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                25,
                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(3, 3, 3)
                                                                                                                                .addComponent(jPanel3,
                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                2,
                                                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                                                .addGap(18, 18, 18)))
                                                                .addComponent(jPanelOpen, GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jOrderFood,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                45,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(0, 2, Short.MAX_VALUE))
                                                                                .addComponent(jBookingButton,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                39, Short.MAX_VALUE)
                                                                                .addComponent(jMyBooking,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jTopUp, GroupLayout.PREFERRED_SIZE, 45,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(4, 4, 4)
                                                                .addComponent(jPleaseTopUp)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(37, 37, 37)));
                revalidate();
                repaint();
        }

        private void loadRoom() {
                ModelList1.clear();
                try {
                        String tempS;
                        fr = new FileReader(fileRoomList);
                        br = new BufferedReader(fr);
                        while ((tempS = br.readLine()) != null) {
                                String[] tempSplit = tempS.split("[)\\(\\;]");
                                // System.out.println(mainframe.getUser().getUserId()+" = "+tempSplit[1]);
                                if (mainframe.getUser().getUserId() == Integer.parseInt(tempSplit[1])) {
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

        private void setUpLookAndFeel() {
                try {
                        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(Mybooking.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(Mybooking.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(Mybooking.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(Mybooking.class.getName())
                                        .log(java.util.logging.Level.SEVERE, null, ex);
                }
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

        private JButton jBookingButton;
        private JButton jOrderFood;
        private JButton jTopUp;
        private JButton jMyBooking;
        private JButton jButtonCancel;
        private JButton jLogOut;
        private JLabel jLabel1;
        private JLabel jLabelBookRoom;
        private JLabel jOpen;
        private JLabel jMoney;
        private JLabel jLabelOnlist;
        private JLabel jPleaseTopUp;

        private JList<String> jListRoom;
        private JPanel jMainPanel;
        private JPanel jPanelOpen;
        private JPanel jPanel2;
        private JPanel jPanel3;
        private JPanel jPanel4;
        private JScrollPane jScrollPane1;
        // End of variables declaration//GEN-END:variables
}
