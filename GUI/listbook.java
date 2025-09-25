package GUI;

import javax.swing.*;

import lib.*;
import lib.loginregister.*;

import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.util.*;

//ค่อนข้างเสร็จ
public class listbook extends JDialog {
        private DefaultListModel<RoomTime> ModelList1;
        private DefaultListModel<RoomTime> ModelList2;
        private int year, month, day;
        private int hourStart;
        private int hourEnd;
        private int minuteStartEnd;
        private User user;
        private Room room;
        private RoomSystem system;
        private LocalDate date;
        private Mainframe main;

        private static class roomTimeListRenderer extends DefaultListCellRenderer {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                                boolean isSelected, boolean cellHasFocus) {

                        super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                        if (value instanceof RoomTime) {
                                RoomTime roomTime = (RoomTime) value;

                                if (roomTime.getTimeStart().getMinute() == 0) {
                                        setText(roomTime.getTimeStart().getHour() + ":"
                                                        + roomTime.getTimeStart().getMinute() + "0 - "
                                                        + roomTime.getTimeEnd().getHour() + ":"
                                                        + roomTime.getTimeEnd().getMinute() + "0");
                                } else {
                                        setText(roomTime.getTimeStart().getHour() + ":"
                                                        + roomTime.getTimeStart().getMinute() + " - "
                                                        + roomTime.getTimeEnd().getHour() + ":"
                                                        + roomTime.getTimeEnd().getMinute());
                                }
                        }
                        return this;
                }
        }

        public listbook(User user, Room room, JPanel j, LocalDate date, Mainframe mainFrame) {
                this.user = user;
                System.out.println(user.getUserId());
                this.room = room;
                this.date = date;
                this.main = mainFrame;
                hourStart = mainFrame.getHourStart();
                hourEnd = mainFrame.getHourEnd();
                minuteStartEnd = mainFrame.getMinuteStartEnd();

                setUpTime(hourStart, hourEnd);
                setModal(true);
                setResizable(false);
                setDefaultCloseOperation(DISPOSE_ON_CLOSE);//
                setSize(new Dimension(250, 350));
                setLocationRelativeTo(j);//
                initComponents();
        }

        // ----------------------------- test -------------------------------------
        // public listbook(User user, Room room) {
        // this.user = user;
        // this.room = room;

        // user = new User(1,150);
        // room = new Room("1-5", 101, 150);

        // system = new RoomSystem();
        // year = LocalDate.now().getYear();
        // month = LocalDate.now().getMonthValue();
        // day = LocalDate.now().getDayOfMonth();
        // // System.out.println(day + " " + month + " " + year);
        // ModelList1 = new DefaultListModel<>();
        // ModelList2 = new DefaultListModel<>();
        // setUpTime(hourStart, hourEnd);

        // setModal(true);
        // setResizable(false);
        // setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // setSize(new Dimension(250, 350));
        // setLocationRelativeTo(null);
        // initComponents();
        // }
        // ----------------------------- test -------------------------------------

        private void initComponents() {
                jPanel1 = new JPanel();
                jPanel2 = new JPanel();
                jBookTime = new JLabel();
                jScrollPane1 = new JScrollPane();
                jListLeft = new JList<>();
                jScrollPane2 = new JScrollPane();
                jListRight = new JList<>();
                jButton1 = new JButton();
                jButton2 = new JButton();
                jButton3 = new JButton();

                jPanel1.setBackground(new Color(235, 240, 255));

                jPanel2.setBackground(new Color(255, 255, 255));

                jBookTime.setFont(new Font("Tw Cen MT", 1, 22)); // NOI18N
                jBookTime.setText("BOOK A TIME");

                GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(19, 19, 19)
                                                                .addComponent(jBookTime)
                                                                .addContainerGap(19, Short.MAX_VALUE)));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jBookTime, GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addContainerGap()));

                jScrollPane1.setBackground(new Color(255, 241, 234));

                jListLeft.setBackground(new Color(255, 241, 234));
                jListLeft.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                jListLeft.setModel(ModelList1);
                jListLeft.setCellRenderer(new roomTimeListRenderer());//
                jScrollPane1.setViewportView(jListLeft);

                jListRight.setBackground(new Color(255, 241, 234));
                jListRight.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                jListRight.setModel(ModelList2);
                jListRight.setCellRenderer(new roomTimeListRenderer());//
                jScrollPane2.setViewportView(jListRight);

                jButton1.setBackground(new Color(183, 255, 207));
                jButton1.setFont(new Font("MS Gothic", 0, 18)); // NOI18N
                jButton1.setText("Add Room");
                jButton1.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                jButton1.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                jButtonAddRoom(evt);
                        }
                });

                jButton2.setBackground(new Color(255, 107, 131));
                jButton2.setFont(new Font("MS Gothic", 0, 18)); // NOI18N
                jButton2.setForeground(new Color(255, 255, 255));
                jButton2.setText("Remove Room");
                jButton2.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                jButtonRemoveRoom(evt);
                        }
                });
                jButton3.setBackground(new Color(205, 255, 255));
                jButton3.setFont(new Font("MS Gothic", 0, 18)); // NOI18N
                jButton3.setText("Confirm");
                jButton3.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
                jButton3.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                jButtonConfirmRoom(evt);
                        }
                });

                GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jButton1,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                120,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jButton2,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                134,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(30, 30, 30)
                                                                                                .addComponent(jButton3,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                96,
                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(GroupLayout.Alignment.LEADING,
                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                .addComponent(jScrollPane1,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                191,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addPreferredGap(
                                                                                                                                LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                                31,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(jScrollPane2,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                192,
                                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(19, 19, 19))
                                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(130, 130, 130)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jScrollPane2,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                155,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addContainerGap(
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jScrollPane1,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                155,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                34,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(jButton1,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                39,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jButton2,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                39,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(jButton3,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                39,
                                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(32, 32, 32)))));

                GroupLayout layout = new GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void jButtonRemoveRoom(ActionEvent evt) {
                if (jListRight.getSelectedValue() != null) {
                        // System.out.println(jList2.getSelectedValue());
                        ModelList1.addElement(jListRight.getSelectedValue());
                        ArrayList<RoomTime> listSort = Collections.list(ModelList1.elements());
                        Collections.sort(listSort, (r1, r2) -> Integer.compare(r1.getTimeStart().getHour(),
                                        r2.getTimeStart().getHour()));
                        ModelList1.clear();
                        for (int i = 0; i < listSort.size(); i++) {
                                ModelList1.addElement(listSort.get(i));
                        }
                        ModelList2.removeElementAt(jListRight.getSelectedIndex());
                        jListRight.setModel(ModelList2);
                        jListLeft.setModel(ModelList1);
                }
        }

        private void jButtonAddRoom(ActionEvent evt) {
                if (jListLeft.getSelectedValue() != null) {
                        ModelList2.addElement(jListLeft.getSelectedValue());
                        ArrayList<RoomTime> listSort = Collections.list(ModelList2.elements());
                        Collections.sort(listSort, (r1, r2) -> Integer.compare(r1.getTimeStart().getHour(),
                                        r2.getTimeStart().getHour()));
                        ModelList2.clear();
                        for (int i = 0; i < listSort.size(); i++) {
                                ModelList2.addElement(listSort.get(i));
                        }
                        ModelList1.removeElementAt(jListLeft.getSelectedIndex());
                        jListRight.setModel(ModelList2);
                        jListLeft.setModel(ModelList1);
                }
        }

        private void jButtonConfirmRoom(ActionEvent evt) {
                ArrayList<RoomTime> tempRoomTime = new ArrayList<>();
                boolean check = false;
                for (int i = 0; i < ModelList2.size(); i++) {
                        RoomTime tempModel = ModelList2.get(i);
                        if (!(system.checkLocalDateTimeIsSame(tempModel.getRoom(), tempModel.getTimeStart(),
                                        tempModel.getTimeEnd()))
                                        && !(LocalDateTime.now().isAfter(tempModel.getTimeStart()))) {
                                tempRoomTime.add(tempModel);

                        } else {
                                if (check == false) {
                                        JOptionPane.showMessageDialog(this, "The time matches what others have booked.",
                                                        "",
                                                        JOptionPane.ERROR_MESSAGE);
                                }
                                check = true;
                        }
                }
                ModelList2.clear();

                if (check == false) {
                        for (int i = 0; i < tempRoomTime.size(); i++) {
                                try {
                                        system.addBookRoom(tempRoomTime.get(i).getRoom(), tempRoomTime.get(i).getUser(),
                                                        tempRoomTime.get(i).getTimeStart(),
                                                        tempRoomTime.get(i).getTimeEnd());
                                } catch (Exception e) {
                                        System.out.println(e);
                                }
                        }
                } else {
                        Collections.sort(tempRoomTime, (r1, r2) -> Integer.compare(r1.getTimeStart().getHour(),
                                        r2.getTimeStart().getHour()));
                        for (int i = 0; i < tempRoomTime.size(); i++) {
                                ModelList2.addElement(tempRoomTime.get(i));

                        }
                }
                jListRight.setModel(ModelList2);
        }

        public void setUpTime(int TimeStart, int TimeEnd) {
                if (TimeStart == TimeEnd) {
                        throw new RuntimeException("TimeStart and TimeEnd is same");
                }
                system = new RoomSystem();
                year = date.getYear();
                month = date.getMonthValue();
                day = date.getDayOfMonth();
                ModelList1 = new DefaultListModel<>();
                ModelList2 = new DefaultListModel<>();
                int loopHour1;
                int loopHour2;
                if (hourEnd - hourStart >= 0) {
                        loopHour1 = 0;
                        loopHour2 = hourEnd - hourStart;
                } else {
                        loopHour1 = hourEnd;
                        loopHour2 = 24 - hourStart;
                }
                for (int i = 0; i < loopHour1; i++) {
                        hourStart = hourStart % 24;
                        if (!(system.checkLocalDateTimeIsSame(room,
                                        LocalDateTime.of(year, month, day, loopHour1 + i,
                                                        minuteStartEnd),
                                        LocalDateTime.of(year, month, day, loopHour1 + i + 1, minuteStartEnd)))
                                        && LocalDateTime.now().isBefore(
                                                        LocalDateTime.of(year, month, day, 0 + i, minuteStartEnd))) {
                                ModelList1.addElement(new RoomTime(room, user,
                                                LocalDateTime.of(year, month, day, 0 + i, minuteStartEnd),
                                                LocalDateTime.of(year, month, day, 0 + i + 1, minuteStartEnd)));
                        }
                }
                for (int i = 0; i < loopHour2; i++) {// ปรับการจัดเวลา24:00
                        int temphourStart = hourStart + i;
                        int temphourStartNext = hourStart + i + 1;
                        if (temphourStart + 1 == 24) {
                                temphourStartNext = 0;
                        }
                        if (!(system.checkLocalDateTimeIsSame(room,
                                        LocalDateTime.of(year, month, day, temphourStart,
                                                        minuteStartEnd),
                                        LocalDateTime.of(year, month, day, temphourStartNext, minuteStartEnd)))
                                        && LocalDateTime.now().isBefore(LocalDateTime.of(year, month, day,
                                                        temphourStart, minuteStartEnd))) {
                                ModelList1.addElement(new RoomTime(room, user,
                                                LocalDateTime.of(year, month, day, temphourStart, minuteStartEnd),
                                                LocalDateTime.of(year, month, day, temphourStartNext, minuteStartEnd)));
                        }
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
                        java.util.logging.Logger.getLogger(listbook.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(listbook.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(listbook.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(listbook.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                }
        }


        private JButton jButton1;
        private JButton jButton2;
        private JButton jButton3;
        private JLabel jBookTime;
        private JList<RoomTime> jListLeft;
        private JList<RoomTime> jListRight;
        private JPanel jPanel1;
        private JPanel jPanel2;
        private JScrollPane jScrollPane1;
        private JScrollPane jScrollPane2;

}
