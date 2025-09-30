package GUI;

import javax.swing.*;
import javax.swing.border.LineBorder;

import lib.loginregister.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class TOPUP extends JPanel {
    private Font FontITCKRIST;
    private Font FontTWCENMT;
    private Mainframe mainframe;
    private LoginRegisterService service;

    private JLabel jLabel1;
    private JLabel jLabel2;
    private JTextField jTextFieldMoney;

    public TOPUP(Mainframe mainframe) {
        this.mainframe = mainframe;
        service = new LoginRegisterService();
        setUpFont();
        initComponents();
    }

    private void initComponents() {
        JPanel panelMain = new JPanel(null);
        panelMain.setPreferredSize(new Dimension(440, 664));
        panelMain.setBackground(Color.WHITE);
        add(panelMain);

        JButton jButtonBack = new JButton();
        jButtonBack.setBackground(new Color(255, 89, 100));
        jButtonBack.setForeground(new Color(255, 255, 255));
        jButtonBack.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 18));
        jButtonBack.setText("BACK");
        jButtonBack.setBounds(10, 20, 75, 30);
        jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonBackActionPerformed(e);
            }
        });

        // ---------------------------------- panel1 ------------------------
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.setBackground(Color.WHITE);
        panel1.setBounds(12, 100, 400, 475);

        jLabel1 = new JLabel();
        jLabel1.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 21)); // NOI18N
        jLabel1.setText("TOP - UP SYSTEM");
        jLabel1.setAlignmentX(CENTER_ALIGNMENT);

        jLabel2 = new JLabel();
        jLabel2.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 21)); // NOI18N
        jLabel2.setText("BOOK A ROOM AND ORDER FOOD");
        jLabel2.setAlignmentX(CENTER_ALIGNMENT);

        JLabel jLabelImg = new JLabel();
        ImageIcon tempIcon = new ImageIcon("./GUI/Picture/FAKE_QR.png");
        Image tempImage = tempIcon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        jLabelImg.setIcon(new ImageIcon(tempImage));
        jLabelImg.setBorder(new LineBorder(Color.BLACK, 10));
        jLabelImg.setAlignmentX(CENTER_ALIGNMENT);

        JPanel panelMoney = new JPanel(null);
        panelMoney.setBackground(Color.WHITE);

        jTextFieldMoney = new JTextField("0");
        jTextFieldMoney.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 21));
        jTextFieldMoney.setHorizontalAlignment(JTextField.RIGHT);
        jTextFieldMoney.setBounds(38, 10, 320, 40);
        jTextFieldMoney.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });

        JButton jConfirm = new JButton();
        jConfirm.setBackground(new Color(0, 140, 0));
        jConfirm.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 24)); // NOI18N
        jConfirm.setForeground(new Color(255, 255, 255));
        jConfirm.setText("Confirm");
        jConfirm.setBounds(38, 55, 320, 40);
        jConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonConfirmActionPerformed(e);
            }

        });

        panelMoney.add(jConfirm);
        panelMoney.add(jTextFieldMoney);

        panel1.add(jLabel1);
        panel1.add(jLabel2);
        panel1.add(Box.createVerticalStrut(10));
        panel1.add(jLabelImg);
        panel1.add(panelMoney);
        // ---------------------------------- panel1 ------------------------

        panelMain.add(jButtonBack);
        panelMain.add(panel1);

        panelMain.revalidate();
        panelMain.repaint();
    }

    private void jButtonConfirmActionPerformed(ActionEvent evt) {
        if (Double.parseDouble(jTextFieldMoney.getText()) >= 0) {
            mainframe.getUser()
                    .setMoney(mainframe.getUser().getMoney() + Double.parseDouble(jTextFieldMoney.getText()));
            service.setMoneyUserInUserList(mainframe.getUser());
        } else {
            JOptionPane.showMessageDialog(this,
                    "Money must be more than 0.",
                    "",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void jButtonBackActionPerformed(ActionEvent evt) {
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
}
