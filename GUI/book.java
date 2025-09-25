package GUI;

import javax.swing.*;

import GUI.Decorate.*;
import lib.*;
import lib.loginregister.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.*;

public class book extends JPanel {
        private JLabel[] jLabelRoom;
        private JLabel[] jLabelAvalible;
        private JLabel[] jLabelCost;
        private JPanel[] jPanelBooking;
        private JButton[] jButton;
        private LocalDate date;
        private RoomSystem system;
        private User user;
        private Mainframe mainframe;

        private Font FontITCKRIST;
        private Font FontTWCENMT;

        public book(Mainframe mainFrame) {
                this.system = mainFrame.getSystem();
                this.user = mainFrame.getUser();
                //System.out.println(user.getUserId());
                this.mainframe = mainFrame;

                jLabelRoom = new JLabel[100];//
                jLabelAvalible = new JLabel[100];//
                jLabelCost = new JLabel[100];//
                jPanelBooking = new JPanel[100];//
                jButton = new JButton[100];//

                setUpFont();
                setUpLookAndFeel();

                initComponents();
        }

        private void initComponents() {

                jLabel1 = new JLabel();
                jLabelBookRoom = new JLabel();
                jMoney = new JLabel();
                jBookingButton = new JButton();
                jMyBooking = new JButton();
                jLabelOnlist = new JLabel();
                jComboBoxDate = new JComboBox<>();
                jScrollPane1 = new JScrollPane();


                jLogOut = new JButton();
                jOrderFood = new JButton();
                jTopUp = new JButton();
                jOpen = new JLabel();
                jPleaseTopUp = new JLabel();

                jMainPanel = new JPanel();
                jPanel2 = new JPanel();
                jPanel3 = new JPanel();
                jPanel4 = new JPanel();
                jPanelRoom = new JPanel();
                jPanelOpen = new JPanel();

                this.add(jMainPanel);

                jMainPanel.setBackground(new Color(235, 240, 255));
                //jMainPanel.setBackground(Color.BLUE);

                jMainPanel.setPreferredSize(new Dimension(440, 664));

                jLabelBookRoom.setFont(FontITCKRIST.deriveFont((float) 14)); 
                jLabelBookRoom.setText("BOOK A ROOM");

                jPanel2.setBackground(new Color(255, 255, 204));

                jMoney.setBackground(new Color(255, 255, 255));
                jMoney.setFont(FontTWCENMT.deriveFont((float) 14).deriveFont((int) 1)); // NOI18N
                jMoney.setText("MONEY : " + user.getMoney());// ไว้แก้Money

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
                                                .addGap(0, 0, Short.MAX_VALUE));
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
                jMyBooking.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                jButtonMyBookingActionPerFormed(evt);
                        }
                });
                //
                jPanel4.setBackground(new Color(255, 254, 241));

                jLabelOnlist.setFont(FontTWCENMT.deriveFont((float) 14).deriveFont((int) 1)); // NOI18N
                jLabelOnlist.setText("WHAT KIND OF ROOM WOLD YOU LIKE ?");

                jComboBoxDate.setModel(
                                new DefaultComboBoxModel<>(
                                                new String[] { "Today", LocalDate.now().plusDays(1).toString(),
                                                                LocalDate.now().plusDays(2).toString() }));
                jComboBoxDate.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                String tempS = (String) jComboBoxDate.getSelectedItem();
                                if (tempS.equals("Today")) {
                                        date = LocalDate.now();
                                } else {
                                        String[] tempSplit = tempS.split("[-]");
                                        date = LocalDate.of(Integer.parseInt(tempSplit[0]),
                                                        Integer.parseInt(tempSplit[1]), Integer.parseInt(tempSplit[2]));
                                }
                        }

                });
                jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                jScrollPane1.getVerticalScrollBar().setUnitIncrement(8);

                // ----------------------------- SetupRoom --------------------------------
                int x = 20, y = 20, count = 0;
                jPanelRoom.setLayout(null);
                jPanelRoom.setBackground(new Color(255, 254, 241));
                int i = 0;
                for (Room room : system.getRooms()) {
                        jLabelRoom[i] = new JLabel();
                        jLabelRoom[i].setFont(FontTWCENMT.deriveFont((float) 18).deriveFont(1));
                        jLabelRoom[i].setText("Room" + room.getIdRoom());
                        jLabelRoom[i].setAlignmentX(Component.CENTER_ALIGNMENT);

                        jLabelAvalible[i] = new JLabel();
                        jLabelAvalible[i].setFont(FontTWCENMT.deriveFont((float) 18).deriveFont(1));
                        jLabelAvalible[i].setText("For : " + room.getNameRoom());
                        jLabelAvalible[i].setHorizontalAlignment(SwingConstants.CENTER);
                        jLabelAvalible[i].setAlignmentX(Component.CENTER_ALIGNMENT);

                        jLabelCost[i] = new JLabel();
                        jLabelCost[i].setFont(FontTWCENMT.deriveFont((float) 18).deriveFont(1));
                        jLabelCost[i].setText("Cost : " + room.getPrice());
                        jLabelCost[i].setHorizontalAlignment(SwingConstants.CENTER);
                        jLabelCost[i].setAlignmentX(Component.CENTER_ALIGNMENT);

                        jButton[i] = new RoundedButton(30, 30, Color.BLACK,4);
                        jButton[i].setBackground(new Color(252, 136, 161));
                        jButton[i].setPreferredSize(new Dimension(100, 50));
                        jButton[i].setFont(FontTWCENMT.deriveFont((float) 18).deriveFont(1));
                        jButton[i].setText("  BOOK  ");
                        jButton[i].setForeground(Color.WHITE);
                        jButton[i].setAlignmentX(Component.CENTER_ALIGNMENT);
                        jButton[i].putClientProperty(1,
                                        new Room(room.getNameRoom(), room.getIdRoom(), room.getPrice()));
                        jButton[i].addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                        JButton tempButton = (JButton) e.getSource();//
                                        Room tempRoom = (Room) tempButton.getClientProperty(1);
                                        System.out.println(tempRoom);
                                        if (date == null) {
                                                date = LocalDate.now();
                                        }
                                        system.ClearRoomTimeBeforeDate(LocalDate.now());
                                        listbook list = new listbook(mainframe.getUser(), tempRoom, book.this, date,mainframe);
                                        list.setVisible(true);
                                }
                        });
                        jPanelBooking[i] = new RoundedPanel(30, 30, Color.black,4);

                        jPanelBooking[i].setBackground(Color.white);
                        jPanelBooking[i].setLayout(new BoxLayout(jPanelBooking[i], BoxLayout.Y_AXIS));

                        int tempInt = 10;
                        jPanelBooking[i].setBorder(BorderFactory.createEmptyBorder(tempInt, tempInt, tempInt, tempInt));

                        jPanelBooking[i].add(jLabelRoom[i]);
                        jPanelBooking[i].add(jLabelAvalible[i]);
                        jPanelBooking[i].add(jLabelCost[i]);

                        jPanelBooking[i].add(Box.createVerticalStrut(10));
                        jPanelBooking[i].add(jButton[i]);

                        if ((i + 1) % 2 == 0) {
                                x = 205;
                        } else {
                                x = 15;
                        }
                        if (count == 2) {
                                count = 0;
                                y += 140;
                        }
                        jPanelBooking[i].setBounds(x, y, 175, 125);
                        count++;
                        jPanelRoom.add(jPanelBooking[i]);
                        i++;
                }
                int maxHeight = 0;
                for (Component comp : jPanelRoom.getComponents()) {
                        Rectangle bounds = comp.getBounds();
                        maxHeight = Math.max(maxHeight, bounds.y + bounds.height);
                }
                jPanelRoom.setPreferredSize(new Dimension(getSize().width, maxHeight + 50));
                JScrollPane scroll = new JScrollPane(jPanelRoom);
                add(scroll);
                // ----------------------------- SetupRoom --------------------------------
                jScrollPane1.setViewportView(jPanelRoom);
                jScrollPane1.setBorder(BorderFactory.createEmptyBorder());
                // jScrollPane1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

                GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel4Layout
                                                                .createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addComponent(jLabelOnlist, GroupLayout.PREFERRED_SIZE, 265,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jComboBoxDate, GroupLayout.PREFERRED_SIZE,
                                                                                82, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(14, 14, 14))
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE,
                                                                                0, Short.MAX_VALUE)
                                                                .addContainerGap()));
                jPanel4Layout.setVerticalGroup(
                                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel4Layout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addGroup(jPanel4Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabelOnlist,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                38,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jComboBoxDate,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                23,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE,
                                                                                320, Short.MAX_VALUE)
                                                                .addContainerGap()));

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

                jOpen.setFont(FontITCKRIST.deriveFont((float) 18));
                String tempPMAM1;
                String tempPMAM2;
                if (mainframe.getHourStart() <= 12) {
                        tempPMAM1 = "A.M.";
                }else{
                        tempPMAM1 = "P.M.";
                }
                if (mainframe.getHourEnd() <= 12) {
                        tempPMAM2 = "A.M.";
                }else{
                        tempPMAM2 = "P.M.";
                }

                if(mainframe.getMinuteStartEnd() == 0){
                        jOpen.setText("OPEN "+mainframe.getHourStart()+" : 00 "+tempPMAM1+" - "+mainframe.getHourEnd()+" : 00 "+tempPMAM2);
                }else{

                        jOpen.setText("OPEN "+mainframe.getHourStart()+" : "+mainframe.getMinuteStartEnd()+" "+tempPMAM1+" - "+mainframe.getHourEnd()+" : "+mainframe.getMinuteStartEnd()+" "+tempPMAM2);
                }
                jPanelOpen.setBackground(Color.white);
                
                GroupLayout jPanel11SetJOpen = new GroupLayout(jPanelOpen);
                jPanelOpen.setLayout(jPanel11SetJOpen);
                jPanel11SetJOpen.setHorizontalGroup(
                                jPanel11SetJOpen.createParallelGroup(GroupLayout.Alignment.CENTER)
                                                .addGroup(jPanel11SetJOpen.createSequentialGroup()
                                                                .addContainerGap(0, Short.MAX_VALUE)
                                                                .addComponent(jOpen)
                                                                .addContainerGap(0, Short.MAX_VALUE)));
                jPanel11SetJOpen.setVerticalGroup(
                                jPanel11SetJOpen.createParallelGroup(GroupLayout.Alignment.CENTER)
                                                .addGroup(jPanel11SetJOpen.createSequentialGroup()
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
                                                                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                                                                )
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
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(book.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(book.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(book.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(book.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                }
        }

        public static void main(String args[]) {
                RoomSystem system = new RoomSystem();
                for (int i = 0; i < 10; i++) {
                        Room a = new Room("1-5", 301 + i, 150);
                        system.addRoom(a);
                }
                system.addRoom(new Room("5+", 201, 200));
                // new book(new User(1, 1500), system).setVisible(true);
        }

        private JButton jBookingButton;
        private JButton jOrderFood;
        private JButton jTopUp;
        private JButton jMyBooking;
        private JButton jLogOut;
        private JComboBox<String> jComboBoxDate;
        private JLabel jLabel1;
        private JLabel jLabelBookRoom;
        private JLabel jOpen;
        private JLabel jMoney;
        private JLabel jLabelOnlist;
        private JLabel jPleaseTopUp;

        private JPanel jMainPanel;
        private JPanel jPanel2;
        private JPanel jPanel3;
        private JPanel jPanel4;
        private JPanel jPanelRoom;
        private JPanel jPanelOpen;
        private JScrollPane jScrollPane1;
}

// class RoundedPanel extends JPanel {
        
// }

// class RoundedButton extends JButton {
        
// }
