package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Mybooking extends JPanel {
    private Mainframe mainframe;
    private Font FontITCKRIST;
    private Font FontTWCENMT;

    public Mybooking(Mainframe mainframe) {
        this.mainframe = mainframe;

        setUpFont();
        setUpLookAndFeel();
        initComponents();
    }

    private void initComponents() {

        jPanelMain = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jPanel2 = new JPanel();
        jLabel3 = new JLabel();
        jPanel3 = new JPanel();
        jButtonBooking = new JButton();
        jButtonMyBook = new JButton();
        jPanel4 = new JPanel();
        jLabelMyBook = new JLabel();
        jButtonCancel = new JButton();
        jScrollPane1 = new JScrollPane();
        jList1 = new JList<>();
        jButtonLogOut = new JButton();
        jButtonOrderFood = new JButton();
        jButtonTopUp = new JButton();
        jPanel11 = new JPanel();
        jLabel24 = new JLabel();
        jLabel6 = new JLabel();

        add(jPanelMain);
        jPanelMain.setBackground(new Color(235, 240, 255));
        jPanelMain.setPreferredSize(new Dimension(440, 664));

        jLabel2.setFont(new Font("Kristen ITC", 1, 14)); // NOI18N
        jLabel2.setText("BOOK A ROOM");

        jPanel2.setBackground(new Color(255, 255, 204));

        jLabel3.setBackground(new Color(255, 255, 255));
        jLabel3.setFont(new Font("Tw Cen MT", 0, 14)); // NOI18N
        jLabel3.setText("MONEY :");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                                .addGap(56, 56, 56)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel3)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jPanel3.setBackground(new Color(0, 0, 0));
        jPanel3.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1), null));
        jPanel3.setPreferredSize(new Dimension(0, 5));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 119, Short.MAX_VALUE));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE));

        jButtonBooking.setBackground(new Color(210, 242, 255));
        jButtonBooking.setFont(new Font("Tw Cen MT", 0, 15)); // NOI18N
        jButtonBooking.setText("BOOKING");
        jButtonBooking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonBookingActionPerFormed(evt);
            }
        });

        jButtonMyBook.setBackground(new Color(210, 242, 255));
        jButtonMyBook.setFont(new Font("Tw Cen MT", 0, 15)); // NOI18N
        jButtonMyBook.setText("MY BOOKING");
        jButtonMyBook.setPreferredSize(new Dimension(125, 28));
        jButtonMyBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonMyBookingActionPerFormed(evt);
            }
        });

        jPanel4.setBackground(new Color(255, 254, 241));

        jLabelMyBook.setFont(new Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabelMyBook.setText("MY BOOKING");

        jButtonCancel.setBackground(new Color(255, 102, 102));
        jButtonCancel.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jButtonCancel.setForeground(new Color(255, 255, 255));
        jButtonCancel.setText("Cancel Room");

        jScrollPane1.setViewportView(jList1);

        GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonCancel, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(102, 102, 102)
                                .addComponent(jLabelMyBook)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel4Layout.setVerticalGroup(
                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelMyBook, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 282, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonCancel)
                                .addContainerGap(14, Short.MAX_VALUE)));

        jButtonLogOut.setBackground(new Color(255, 89, 100));
        jButtonLogOut.setForeground(new Color(255, 255, 255));
        jButtonLogOut.setText("X");
        jButtonLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonLogoutActionPerformed(e);
            }
            
        });

        jButtonOrderFood.setBackground(new Color(255, 228, 207));
        jButtonOrderFood.setFont(new Font("Tw Cen MT", 0, 15)); // NOI18N
        jButtonOrderFood.setText("ORDER FOOD");
        jButtonOrderFood.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonOrderActionPerFormed(e);
            }
            
        });

        jButtonTopUp.setBackground(new Color(204, 255, 204));
        jButtonTopUp.setFont(new Font("Tw Cen MT", 0, 16)); // NOI18N
        jButtonTopUp.setText("TOP UP");
        jButtonTopUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1TopupActionPerformed(evt);
            }
        });

        jPanel11.setBackground(new Color(255, 255, 255));

        jLabel24.setFont(new Font("Kristen ITC", 0, 14)); // NOI18N
        jLabel24.setText("OPEN 12 : 00 P.M. - 23 : 00 P.M.");

        GroupLayout jPanel11Layout = new GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
                jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel24)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel11Layout.setVerticalGroup(
                jPanel11Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel24)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jLabel6.setFont(new Font("Segoe UI", 0, 10)); // NOI18N
        jLabel6.setForeground(new Color(255, 0, 0));
        jLabel6.setText("* PLEASE TOP UP TO USE THE APP");

        GroupLayout jPanel1Layout = new GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButtonLogOut)
                                                .addGap(208, 208, 208))
                                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 121,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2))
                                .addContainerGap(20, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jButtonMyBook, GroupLayout.PREFERRED_SIZE, 121,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonBooking, GroupLayout.PREFERRED_SIZE, 118,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonOrderFood, GroupLayout.PREFERRED_SIZE, 118,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jButtonTopUp, GroupLayout.Alignment.LEADING,
                                                GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGap(72, 72, 72)
                                                .addComponent(jPanel11, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel6, GroupLayout.Alignment.LEADING,
                                                GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(
                                                        jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGap(11, 11, 11)
                                                                        .addComponent(jLabel1))
                                                                .addComponent(jButtonLogOut))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED,
                                                        GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 50, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(jPanel1Layout
                                                                .createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 2,
                                                                        GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 25,
                                                                        GroupLayout.PREFERRED_SIZE)))
                                                .addGap(14, 14, 14)
                                                .addComponent(jPanel11, GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)))
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonMyBook, GroupLayout.PREFERRED_SIZE, 42,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonBooking, GroupLayout.PREFERRED_SIZE, 42,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonOrderFood, GroupLayout.PREFERRED_SIZE, 42,
                                                GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonTopUp, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)));

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

    private void setUpLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mybooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mybooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mybooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mybooking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

    private JButton jButtonBooking;
    private JButton jButtonOrderFood;
    private JButton jButtonTopUp;
    private JButton jButtonMyBook;
    private JButton jButtonCancel;
    private JButton jButtonLogOut;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel24;
    private JLabel jLabel3;
    private JLabel jLabelMyBook;
    private JLabel jLabel6;
    private JList<String> jList1;
    private JPanel jPanelMain;
    private JPanel jPanel11;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JPanel jPanel4;
    private JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
