import lib.User;
import lib.BookRoom.Room;
import lib.BookRoom.RoomSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.util.*;

public class BookRoom extends JFrame {
    DefaultListModel<String> ModelList1;
    DefaultListModel<String> ModelList2;
    int year, month, day;
    int hourStart = 13;
    int hourEnd = 23;
    int minuteStartEnd = 00;
    User user = new User(1,150);
    Room room = new Room("1-5", 101, 150);

    static RoomSystem system;

    public BookRoom() {
        year = LocalDate.now().getYear();
        month = LocalDate.now().getMonthValue();
        day = LocalDate.now().getDayOfMonth();
        System.out.println(day + " " + month + " " + year);
        ModelList1 = new DefaultListModel<>();
        ModelList2 = new DefaultListModel<>();
        for (int i = 0; i < hourEnd - hourStart; i++) {
            if (!(system.checkLocalDateTimeIsSame(room,
                    LocalDateTime.of(year, month, day, hourStart + i, minuteStartEnd),
                    LocalDateTime.of(year, month, day, hourStart + i +1, minuteStartEnd))
                    )) {
                ModelList1.addElement((hourStart + i) + ":" + minuteStartEnd + "0-" + (hourStart + i + 1) + ":"
                        + minuteStartEnd + "0"); // ยังมีบัค24:00
            }
        }
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jList1 = new JList<>();
        jPanel2 = new JPanel();
        jScrollPane2 = new JScrollPane();
        jList2 = new JList<>();
        jPanel3 = new JPanel();
        jButton1 = new JButton();
        jButton2 = new JButton();
        jButton3 = new JButton();
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jList1.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        jList1.setModel(ModelList1);
        jScrollPane1.setViewportView(jList1);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1));

        jList2.setFont(new Font("Segoe UI", 0, 18)); // NOI18N
        jList2.setModel(ModelList2);
        jScrollPane2.setViewportView(jList2);

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE));

        jPanel3.setBackground(new Color(204, 204, 204));

        jButton1.setBackground(new Color(255, 51, 102));
        jButton1.setFont(new Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new Color(255, 255, 255));
        jButton1.setText("RemoveRoom");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonRemoveRoom(evt);
            }
        });

        jButton2.setBackground(new Color(153, 255, 153));
        jButton2.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("AddRoom");
        jButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonAddRoom(e);
            }
        });

        jButton3.setBackground(new Color(0, 0, 0));
        jButton3.setFont(new Font("Segoe UI", 1, 14)); // NOI18N
        jButton3.setForeground(new Color(255, 255, 255));
        jButton3.setText("Confirm");
        jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonConfirmRoom(evt);
            }
        });

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(20, 20, 20)));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, 72,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, 72,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, 72,
                                                GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(22, Short.MAX_VALUE)));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE)
                                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRemoveRoom(ActionEvent evt) {
        if (jList2.getSelectedValue() != null) {
            // System.out.println(jList2.getSelectedValue());
            ModelList1.addElement(jList2.getSelectedValue());
            ArrayList<String> listSort = Collections.list(ModelList1.elements());
            Collections.sort(listSort);
            ModelList1.clear();
            for (int i = 0; i < listSort.size(); i++) {
                ModelList1.addElement(listSort.get(i));
            }
            ModelList2.removeElementAt(jList2.getSelectedIndex());
            jList2.setModel(ModelList2);
            jList1.setModel(ModelList1);
        }
    }

    private void jButtonAddRoom(ActionEvent evt) {
        if (jList1.getSelectedValue() != null) {
            ModelList2.addElement(jList1.getSelectedValue());
            ArrayList<String> listSort = Collections.list(ModelList2.elements());
            Collections.sort(listSort);
            ModelList2.clear();
            for (int i = 0; i < listSort.size(); i++) {
                ModelList2.addElement(listSort.get(i));
            }
            ModelList1.removeElementAt(jList1.getSelectedIndex());
            jList2.setModel(ModelList2);
            jList1.setModel(ModelList1);
        }
    }

    private void jButtonConfirmRoom(ActionEvent evt) {
        for (int i = 0; i < ModelList2.size(); i++) {
            String tempModel = ModelList2.get(i);
            String[] tempArray = tempModel.split("[:\\-]");
            try {
                system.addBookRoom(room, user,
                        LocalDateTime.of(year, month, day, Integer.parseInt(tempArray[0]),
                                Integer.parseInt(tempArray[1])),
                        LocalDateTime.of(year, month, day, Integer.parseInt(tempArray[2]),
                                Integer.parseInt(tempArray[3])));
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        ModelList2.clear();
        jList2.setModel(ModelList2);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        system = new RoomSystem();
        Room room1 = new Room("1-5", 101, 150);
        User user1 = new User(2,150);
        try {
            system.addBookRoom(room1, user1,
                    LocalDateTime.of(LocalDate.now().getYear(), LocalDate.now().getMonth(),
                            LocalDate.now().getDayOfMonth(),
                            12, 0, 0),
                    LocalDateTime.of(LocalDate.now().getYear(), LocalDate.now().getMonth(),
                            LocalDate.now().getDayOfMonth(),
                            13, 0, 0));
            system.addBookRoom(room1, user1,
                    LocalDateTime.of(LocalDate.now().getYear(), LocalDate.now().getMonth(),
                            LocalDate.now().getDayOfMonth(),
                            15, 0, 0),
                    LocalDateTime.of(LocalDate.now().getYear(), LocalDate.now().getMonth(),
                            LocalDate.now().getDayOfMonth(),
                            16, 0, 0));
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BookRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookRoom().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JList<String> jList1;
    private JList<String> jList2;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
