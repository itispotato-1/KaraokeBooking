package GUI;

import javax.swing.*;

import GUI.Decorate.RoundedButton;
import GUI.Decorate.RoundedPanel;
import lib.Room;
import lib.loginregister.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.time.LocalDate;

public class menudrink extends JPanel {
    private Mainframe mainframe;
    private Font FontITCKRIST;
    private Font FontTWCENMT;

    public menudrink(Mainframe mainframe) {
        this.mainframe = mainframe;
        setUpFont();
        setLookAndFeel();
        initComponents();
    }

    private void initComponents() {

        jPanelMain = new JPanel();

        jLabelMenuDrink = new JLabel();
        jScrollPane1 = new JScrollPane();
        jPanelOrderMain = new JPanel();

        add(jPanelMain);

        jPanelMain.setBackground(new Color(235, 240, 255));
        jPanelMain.setPreferredSize(new Dimension(440, 664));

        jButtonFood = new RoundedButton(30, 30, new Color(165, 71, 156), 6);
        jButtonFood.setBackground(new Color(255, 183, 198));
        jButtonFood.setFont(FontTWCENMT.deriveFont((float) 18).deriveFont((int) 1)); // NOI18N
        jButtonFood.setText("FOOD");
        // jButtonFood.setBorder(BorderFactory.createEtchedBorder());
        jButtonFood.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonFoodActionPerformed(evt);
            }
        });

        jButtonDrink = new RoundedButton(30, 30, new Color(0, 74, 173), 6);
        jButtonDrink.setBackground(new Color(154, 229, 227));
        jButtonDrink.setFont(FontTWCENMT.deriveFont((float) 18).deriveFont((int) 1)); // NOI18N
        jButtonDrink.setText("DRINK");
        // jButtonDrink.setBorder(BorderFactory.createEtchedBorder());
        jButtonDrink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonDrinkActionPerformed(evt);
            }
        });

        jPanelInMyDrink = new RoundedPanel(0, 0, Color.BLACK, 6);
        jPanelInMyDrink.setBackground(new Color(255, 254, 241));
        // jPanelInMyDrink.setBorder(BorderFactory.createEtchedBorder());

        jLabelMenuDrink.setFont(FontTWCENMT.deriveFont((float) 24).deriveFont((int) 1)); // NOI18N
        jLabelMenuDrink.setText("MENU DRINK");

        jScrollPane1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

       
        // ----------------------------- SetupRoom --------------------------------
        int x = 20, y = 20, count = 0;
        jPanelOrderMain.setLayout(null);
        jPanelOrderMain.setBackground(new Color(255, 254, 241));
        JPanel panelOrder1 = new RoundedPanel(30, 30, Color.black, 6);
        panelOrder1.setBounds(x, y, 175, 150);
        panelOrder1.setLayout(null);

        JButton ButtonImage = new JButton();
        ButtonImage.setBounds(10, 10, 155, 90);
        ImageIcon tempIcon = new ImageIcon(getClass().getResource("/GUI/Picture/Water.jpg"));
        Image img = tempIcon.getImage().getScaledInstance(ButtonImage.getSize().width, ButtonImage.getSize().height,
                Image.SCALE_SMOOTH);
        ButtonImage.setIcon(new ImageIcon(img));
        JLabel jLabelNameFood = new JLabel("NameDrink");
        JLabel jLabelCost = new JLabel("Cost : 10");
        jLabelCost.setFont(FontTWCENMT.deriveFont((float) 14).deriveFont(1));
        jLabelNameFood.setFont(FontTWCENMT.deriveFont((float) 14).deriveFont(1));

        jLabelCost.setBounds(100, 90, 100, 70);
        jLabelNameFood.setBounds(10,90, 100, 70);
        panelOrder1.add(jLabelNameFood);
        panelOrder1.add(jLabelCost);
        panelOrder1.add(ButtonImage);

        jPanelOrderMain.add(panelOrder1);
        // ----------------------------- SetupRoom --------------------------------

        jScrollPane1.setViewportView(jPanelOrderMain);
        jScrollPane1.setBorder(BorderFactory.createEmptyBorder());

        GroupLayout jPanel2Layout = new GroupLayout(jPanelInMyDrink);
        jPanelInMyDrink.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelMenuDrink, GroupLayout.PREFERRED_SIZE, 158,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(110, 110, 110))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelMenuDrink, GroupLayout.PREFERRED_SIZE, 32,
                                        GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
                                .addContainerGap()));
        jButtonBack = new RoundedButton(20, 20, Color.black, 4);
        jButtonBack.setBackground(new Color(255, 89, 100));
        jButtonBack.setForeground(new Color(255, 255, 255));
        jButtonBack.setText("BACK");
        jButtonBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               jButtonExitActionPerformed(e);
            }
            
        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanelMain);
        jPanelMain.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(jButtonFood, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addComponent(jButtonDrink, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jButtonBack)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanelInMyDrink, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE,
                                        Short.MAX_VALUE)
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(jButtonBack)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButtonFood, GroupLayout.PREFERRED_SIZE, 50,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonDrink, GroupLayout.PREFERRED_SIZE, 50,
                                                GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addComponent(jPanelInMyDrink, GroupLayout.PREFERRED_SIZE, 525,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)));

    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFoodActionPerformed(ActionEvent evt) {
        mainframe.showPanel("menufood");
    }

    private void jButtonDrinkActionPerformed(ActionEvent evt) {
         mainframe.showPanel("menudrink");
    }
    private void jButtonExitActionPerformed(ActionEvent evt) {
         mainframe.showPanel("book");
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

    private void setLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(menudrink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(menudrink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(menudrink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(menudrink.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton jButtonBack;

    private JButton jButtonDrink;
    private JButton jButtonFood;
    private JLabel jLabelMenuDrink;
    private JPanel jPanelMain;
    private JPanel jPanelInMyDrink;
    private JPanel jPanelOrderMain;
    private JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
