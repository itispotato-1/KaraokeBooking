package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class TOPUP extends JPanel {
    private Mainframe mainframe;
    private Font FontITCKRIST;
    private Font FontTWCENMT;

    public TOPUP(Mainframe mainframe) {
        this.mainframe = mainframe;
        setUpLookAndFeel();
        setUpFont();
        initComponents();
    }

    private void initComponents() {

        jPanelMain = new JPanel();
        jButtonBack = new JButton();
        jPanel2 = new JPanel();
        jPanel3 = new JPanel();
        jConfirm = new JButton();
        jTextField1 = new JTextField();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();

        add(jPanelMain);
        jPanelMain.setPreferredSize(new Dimension(440, 664));

        jPanelMain.setBackground(new Color(235, 240, 255));

        jButtonBack.setBackground(new Color(255, 89, 100));
        jButtonBack.setForeground(new Color(255, 255, 255));
        jButtonBack.setText("BACK");
        jButtonBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonBackActionPerformed(e);
            }
            
        });

        jPanel2.setBackground(new Color(255, 255, 255));

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 351, Short.MAX_VALUE));
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 284, Short.MAX_VALUE));

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addContainerGap()));

        jConfirm.setBackground(new Color(0, 204, 0));
        jConfirm.setFont(new Font("Segoe UI", 1, 24)); // NOI18N
        jConfirm.setForeground(new Color(255, 255, 255));
        jConfirm.setText("Confirm");
        jConfirm.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonConfirmActionPerformed(e);
            }
            
        });

        jTextField1.setHorizontalAlignment(JTextField.CENTER);
        jTextField1.setText("textField");
        jTextField1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new Font("Tw Cen MT", 1, 24)); // NOI18N
        jLabel1.setText("TOP - UP SYSTEM");

        jLabel2.setFont(new Font("Tw Cen MT", 1, 20)); // NOI18N
        jLabel2.setText("BOOK A ROOM AND ORDER FOOD");

        GroupLayout jPanel1Layout = new GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout
                                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGap(37, 37, 37)
                                                                        .addComponent(jTextField1,
                                                                                GroupLayout.PREFERRED_SIZE, 307,
                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGap(67, 67, 67)
                                                                        .addComponent(jConfirm,
                                                                                GroupLayout.PREFERRED_SIZE, 247,
                                                                                GroupLayout.PREFERRED_SIZE)))
                                                        .addGap(25, 25, 25)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 311,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(20, 20, 20)
                                                .addComponent(jButtonBack))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(99, 99, 99)
                                                .addComponent(jLabel1)))
                                .addContainerGap(31, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButtonBack)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(13, 13, 13)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jConfirm, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(141, Short.MAX_VALUE)));

    }

    private void jTextField1ActionPerformed(ActionEvent evt) {

    }
    private void jButtonConfirmActionPerformed(ActionEvent evt) {
        
    }
    private void jButtonBackActionPerformed(ActionEvent evt) {
        mainframe.showPanel("book");
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
            java.util.logging.Logger.getLogger(TOPUP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TOPUP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TOPUP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TOPUP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

    private JButton jButtonBack;
    private JButton jConfirm;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JPanel jPanelMain;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
