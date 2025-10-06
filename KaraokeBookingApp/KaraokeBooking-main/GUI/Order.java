package GUI;

import javax.swing.*;
import javax.swing.JSpinner.*;
import javax.swing.border.*;

import GUI.Decorate.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Order extends JDialog {
    private Font FontITCKRIST;
    private Font FontTWCENMT;

    public Order() {
        setUpLookAndFeel();
        setUpFont();
        setModal(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//
        setSize(new Dimension(465, 355));
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {

        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.X_AXIS));
        panelMain.setBackground(new Color(250, 243, 222));
        add(panelMain);

        // ---------------------- Panelซ้าย --------------------
        JPanel panelLeft = new JPanel();
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        panelLeft.setBackground(Color.GREEN);
        panelLeft.setPreferredSize(new Dimension(this.getWidth() / 2, this.getHeight()));

        JPanel panelImg = new JPanel(null);
        panelImg.setBackground(new Color(209, 207, 207));
        panelImg.setPreferredSize(new Dimension(panelLeft.getWidth(), 200));

        JPanel panelImgIn = new RoundedPanel(30, 30);
        panelImgIn.setLayout(null);
        panelImgIn.setBackground(Color.BLACK);
        panelImgIn.setBounds(5, 5, this.getWidth() / 2 - 20, (int) panelImg.getPreferredSize().getHeight() + 20);

        JLabel labelImg = new JLabel("");
        ImageIcon tempImageIcon1 = new ImageIcon("./GUI/Picture/Food/F001.jpg");
        Image tempImage1 = tempImageIcon1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        labelImg.setIcon(new ImageIcon(tempImage1));
        labelImg.setBounds(10, 12, this.getWidth() / 2 - 40, (int) panelImg.getPreferredSize().getHeight() - 5);

        panelImgIn.add(labelImg);

        panelImg.add(panelImgIn);

        JPanel panelCost = new JPanel(null);
        panelCost.setBackground(new Color(209, 207, 207));
        panelCost.setPreferredSize(new Dimension(panelLeft.getWidth(), 50));

        JTextField textAreaCost = new JTextField("0");
        textAreaCost.setFont(FontITCKRIST.deriveFont(1).deriveFont((float) 40));
        textAreaCost.setForeground(Color.WHITE);
        textAreaCost.setBackground(new Color(182, 77, 0));
        textAreaCost.setBounds(5, 10, this.getWidth() / 2 - 20, 60);
        textAreaCost.setHorizontalAlignment(JTextField.RIGHT);
        textAreaCost.setEditable(false);

        panelCost.add(textAreaCost);

        panelLeft.add(panelImg);
        panelLeft.add(panelCost);
        // ---------------------- Panelซ้าย --------------------

        // ---------------------- Panelขวา --------------------
        JPanel panelRight = new JPanel();
        panelRight.setLayout(new BoxLayout(panelRight, BoxLayout.Y_AXIS));
        panelRight.setBackground(new Color(209, 207, 207));
        panelRight.setPreferredSize(new Dimension(this.getWidth() / 2, this.getHeight()));

        JPanel panelRight1 = new JPanel();
        panelRight1.setLayout(new FlowLayout());
        panelRight1.setBackground(Color.WHITE);
        panelRight1.setPreferredSize(new Dimension(this.getWidth() / 2, 200));
        panelRight1.setMaximumSize(new Dimension(210, 100));
        panelRight1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        JPanel panelCheckMain = new JPanel(null);
        panelCheckMain.setBackground(Color.WHITE);
        panelCheckMain.setPreferredSize(new Dimension(200, 140));

        JScrollPane scrollPane = new JScrollPane(panelCheckMain);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getVerticalScrollBar().setUnitIncrement(8);
        scrollPane.setPreferredSize(new Dimension(200, 140));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        // ------------------------------------------------------------------------------
        JPanel panelCheck1 = new RoundedPanel(10, 10);
        panelCheck1.setLayout(new BoxLayout(panelCheck1, BoxLayout.Y_AXIS));
        panelCheck1.setBackground(new Color(255, 186, 125));
        panelCheck1.setBounds(0, 0, 200, 40);

        JCheckBox checkBox1 = new JCheckBox("More RICE");
        checkBox1.setBorder(new EmptyBorder(0, 10, 0, 0));
        checkBox1.setAlignmentY(SwingConstants.CENTER);
        checkBox1.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 30));
        checkBox1.setBounds(5, 5, 300, 50);

        panelCheck1.add(Box.createVerticalGlue());
        panelCheck1.add(checkBox1);
        panelCheck1.add(Box.createVerticalGlue());

        JPanel panelCheck2 = new RoundedPanel(10, 10);
        panelCheck2.setLayout(new BoxLayout(panelCheck2, BoxLayout.Y_AXIS));
        panelCheck2.setBackground(new Color(255, 186, 125));
        panelCheck2.setBounds(0, 45, 200, 40);

        JCheckBox checkBox2 = new JCheckBox("More FOOD");
        checkBox2.setBorder(new EmptyBorder(0, 10, 0, 0));
        checkBox2.setAlignmentY(SwingConstants.CENTER);
        checkBox2.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 30));
        checkBox2.setBounds(5, 5, 300, 50);

        panelCheck2.add(Box.createVerticalGlue());
        panelCheck2.add(checkBox2);
        panelCheck2.add(Box.createVerticalGlue());

        panelCheckMain.add(panelCheck1);
        panelCheckMain.add(panelCheck2);

        int maxHeight = 0;
        for (Component comp : panelCheckMain.getComponents()) {
            Rectangle bounds = comp.getBounds();
            maxHeight = Math.max(maxHeight, bounds.y + bounds.height);
        }
        panelCheckMain.setPreferredSize(new Dimension(200, maxHeight + 0));
        // ------------------------------------------------------------------------------

        panelRight1.add(scrollPane);

        JPanel panelRight2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        panelRight2.setBackground(new Color(209, 207, 207));
        panelRight2.setPreferredSize(new Dimension(this.getWidth() / 2, 70));
        panelRight2.setMaximumSize(new Dimension(210, 100));

        JSpinner spinnerAmount = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        spinnerAmount.setPreferredSize(new Dimension((int) panelRight2.getPreferredSize().getWidth() - 20,
                (int) panelRight2.getPreferredSize().getHeight() - 10));
        spinnerAmount.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 30));
        spinnerAmount.setForeground(Color.WHITE);
        spinnerAmount.setBackground(new Color(14, 81, 171));
        ((DefaultEditor) spinnerAmount.getEditor()).getTextField().setEditable(false);// ไปเข้าดึงTextFieldมันแทนเพื่อไม่ให้แก้

        panelRight2.add(spinnerAmount);

        JPanel panelRight3 = new JPanel();
        panelRight3.setLayout(new GridLayout(1, 1));
        panelRight3.setBackground(new Color(209, 207, 207));
        panelRight3.setPreferredSize(new Dimension(this.getWidth() / 2, 70));
        panelRight3.setMaximumSize(new Dimension(210, 100));

        JButton buttonComfirm = new JButton("CONFIRM");
        buttonComfirm.setForeground(Color.white);
        buttonComfirm.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 35));
        buttonComfirm.setBackground(new Color(4, 153, 23));
        buttonComfirm.setPreferredSize(new Dimension((int) panelRight3.getPreferredSize().getWidth(),
                (int) panelRight3.getPreferredSize().getHeight()));
        buttonComfirm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonConfirmActionPerformed(e);
                Boolean success = true;
                if (success) {
                    JOptionPane.showMessageDialog(panelMain, "Successful purchase", "Successful",
                            JOptionPane.PLAIN_MESSAGE);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(panelMain, "UnSuccessful purchase", "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        panelRight3.add(buttonComfirm);

        panelRight.add(Box.createVerticalStrut(10));
        panelRight.add(panelRight1);
        panelRight.add(Box.createVerticalStrut(5));
        panelRight.add(panelRight2);
        panelRight.add(Box.createVerticalStrut(5));
        panelRight.add(panelRight3);
        panelRight.add(Box.createVerticalStrut(12));
        // ---------------------- Panelขวา --------------------

        panelMain.add(panelLeft);
        panelMain.add(panelRight);

        revalidate();
        repaint();
    }

    protected void jButtonConfirmActionPerformed(ActionEvent e) {
        System.out.println("HI");
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
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(test.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
    }
}