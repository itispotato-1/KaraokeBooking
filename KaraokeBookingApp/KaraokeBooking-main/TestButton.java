import javax.swing.*;

import GUI.listbook;
import lib.Room;
import lib.RoomSystem;
import lib.User;

import java.util.logging.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDate;

public class TestButton extends JFrame {
    JLabel[] jLabelRoom;
    JLabel[] jLabelAvalible;
    JPanel[] jPanelBooking;
    JButton[] jButton;
    LocalDate date;
    RoomSystem system;
    //อาจจะต้องมีเก็บ User ไว้ส่งไปที่อื่น

    public TestButton(RoomSystem system) {//
        this.system = system;

        jLabelRoom = new JLabel[100];//
        jLabelAvalible = new JLabel[100];//
        jPanelBooking = new JPanel[100];//
        jButton = new JButton[100];//
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new JPanel();
        jScrollPane1 = new JScrollPane();
        jPanel2 = new JPanel();
        jComboBox1 = new JComboBox<>();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(540, 960));
        setLocationRelativeTo(null);
        setResizable(false);
        
        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);//

        // ----------------------------- SetupRoom --------------------------------
        int x = 20, y = 20, count = 0;
        jPanel2.setLayout(null);
        int i = 0;
        for (Room room : system.getRooms()) {
            jLabelRoom[i] = new JLabel();
            jLabelRoom[i].setFont(new Font("Segoe UI", 0, 18)); // NOI18N
            jLabelRoom[i].setText("Room" + room.getIdRoom());
            jLabelRoom[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            jLabelAvalible[i] = new JLabel();
            jLabelAvalible[i].setFont(new Font("Segoe UI", 0, 18)); // NOI18N
            jLabelAvalible[i].setText(room.getNameRoom());
            jLabelAvalible[i].setHorizontalAlignment(SwingConstants.CENTER);
            jLabelAvalible[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            jButton[i] = new JButton();
            jButton[i].setBackground(new Color(153, 255, 153));
            jButton[i].setFont(new Font("Segoe UI", 0, 14)); // NOI18N
            jButton[i].setText("Booking");
            jButton[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            jButton[i].putClientProperty(1, new Room(room.getNameRoom(), room.getIdRoom(), room.getPrice()));
            jButton[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tempButton = (JButton) e.getSource();//
                            Room tempRoom = (Room) tempButton.getClientProperty(1);
                            System.out.println(tempRoom);
                            if(date == null){
                                date = LocalDate.now();
                            }
                            listbook list = new listbook(new User(1,150), tempRoom,TestButton.this,date);
                            list.setVisible(true);
                }
            });
            jPanelBooking[i] = new JPanel();
            jPanelBooking[i].setBackground(new Color(255, 255, 204));
            jPanelBooking[i].setLayout(new BoxLayout(jPanelBooking[i], BoxLayout.Y_AXIS));
            jPanelBooking[i].setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            jPanelBooking[i].add(jLabelRoom[i]);
            jPanelBooking[i].add(jLabelAvalible[i]);
            jPanelBooking[i].add(jButton[i]);
            if ((i + 1) % 2 == 0) {
                x = 175;
            } else {
                x = 30;
            }
            if (count == 2) {
                count = 0;
                y += 120;
            }
            jPanelBooking[i].setBounds(x, y, 125, 100);
            count++;
            jPanel2.add(jPanelBooking[i]);
            i++;
        }
        int maxHeight = 0;
        for (Component comp : jPanel2.getComponents()) {
            Rectangle bounds = comp.getBounds();
            maxHeight = Math.max(maxHeight, bounds.y + bounds.height);
        }
        jPanel2.setPreferredSize(new Dimension(getSize().width, maxHeight + 50));

        JScrollPane scroll = new JScrollPane(jPanel2);
        add(scroll);
        // ----------------------------- SetupRoom --------------------------------

        jScrollPane1.setViewportView(jPanel2);// เซ็ตjScroll ใน panel2

        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Today", LocalDate.now().plusDays(1).toString(), LocalDate.now().plusDays(2).toString()}));
        jComboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tempS = (String)jComboBox1.getSelectedItem();
                if(tempS.equals("Today")){
                    date = LocalDate.now();
                }
                else{
                    String[] tempSplit = tempS.split("[-]");
                    date = LocalDate.of(Integer.parseInt(tempSplit[0]), Integer.parseInt(tempSplit[1]), Integer.parseInt(tempSplit[2]));
                }
            }
            
        });//

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 102,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 335,
                                                        GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(37, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(// addส่วนหน้าjPanel1 แค่แนวตั้ง
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(60, Short.MAX_VALUE)
                                .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 438, GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)));

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));

        pack();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        RoomSystem system = new RoomSystem();
        for (int i = 0; i < 10; i++) {
            Room a = new Room("1-5", 301 + i, 150);
            system.addRoom(a);
        }

        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TestButton.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(TestButton.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TestButton.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(TestButton.class.getName()).log(Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestButton(system).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox<String> jComboBox1;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
