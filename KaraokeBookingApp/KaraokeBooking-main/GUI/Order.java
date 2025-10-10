package GUI;

import javax.swing.*;
import javax.swing.JSpinner.*;
import javax.swing.border.*;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import GUI.Decorate.*;
import store.Product;
import store.ProductCatalog;
import store.toppings;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Order extends JDialog {
    private Font FontITCKRIST;
    private Font FontTWCENMT;
    private Product product;
    private Mainframe mainFrame;
    private File fileOrder = null;
    private FileWriter fw = null;
    private BufferedWriter bw = null;
    private ProductCatalog productCatalog;

    private JPanel panelCheck[];
    private JCheckBox checkBox[];
    private JRadioButton radioButton[];
    private JTextField textAreaCost;
    private JSpinner spinnerAmount;

    public Order(Product product, Mainframe mainframe, JPanel panel) {
        fileOrder = new File("./file/Order.csv");
        this.product = product;
        this.mainFrame = mainframe;
        setUpLookAndFeel();
        setUpFont();
        setModal(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//
        setSize(new Dimension(465, 355));
        setLocationRelativeTo(panel);
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
        ImageIcon tempImageIcon1 = null;
        if (product.getProductId().charAt(0) == 'F') {
            tempImageIcon1 = new ImageIcon("./GUI/Picture/Food/" + product.getProductId() + ".jpg");
        } else if (product.getProductId().charAt(0) == 'D') {
            tempImageIcon1 = new ImageIcon("./GUI/Picture/Drink/" + product.getProductId() + ".jpg");
        }
        Image tempImage1 = tempImageIcon1.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        labelImg.setIcon(new ImageIcon(tempImage1));
        labelImg.setBounds(10, 12, this.getWidth() / 2 - 40, (int) panelImg.getPreferredSize().getHeight() - 5);

        panelImgIn.add(labelImg);

        panelImg.add(panelImgIn);

        JPanel panelCost = new JPanel(null);
        panelCost.setBackground(new Color(209, 207, 207));
        panelCost.setPreferredSize(new Dimension(panelLeft.getWidth(), 50));

        textAreaCost = new JTextField("0");
        textAreaCost.setText(Double.toString(product.getPrice()));
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
        ArrayList<toppings> toppinglist = new ArrayList<>();
        if (product.getProductId().charAt(0) == 'F') {
            for (toppings toppings : mainFrame.getCatalog().getAllTopFood()) {
                toppinglist.add(toppings);
            }
        } else if (product.getProductId().charAt(0) == 'D') {
            for (toppings toppings : mainFrame.getCatalog().getAllTopDrink()) {
                toppinglist.add(toppings);

            }
        }
        panelCheck = new JPanel[toppinglist.size()];
        checkBox = new JCheckBox[toppinglist.size()];
        radioButton = new JRadioButton[toppinglist.size()];

        int i = 0;
        int y = 0;
        ButtonGroup radioButtonGroup = new ButtonGroup();

        for (toppings toppings : toppinglist) {
            panelCheck[i] = new RoundedPanel(10, 10);
            panelCheck[i].setLayout(new BoxLayout(panelCheck[i], BoxLayout.Y_AXIS));
            panelCheck[i].setBackground(new Color(255, 186, 125));
            panelCheck[i].setBounds(0, y, 200, 40);
            if (product.getProductId().charAt(0) == 'F') {
                checkBox[i] = new JCheckBox("Add " + toppings.getTop() + " + " + toppings.getCost());
                checkBox[i].setBorder(new EmptyBorder(0, 10, 0, 0));
                checkBox[i].setAlignmentY(SwingConstants.CENTER);
                checkBox[i].setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 20));
                checkBox[i].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateMoney();
                    }

                });
                checkBox[i].setBounds(5, 5, 300, 50);

                panelCheck[i].add(Box.createVerticalGlue());
                panelCheck[i].add(checkBox[i]);
                panelCheck[i].add(Box.createVerticalGlue());
            } else if (product.getProductId().charAt(0) == 'D') {
                radioButton[i] = new JRadioButton(toppings.getTop() + " + " + toppings.getCost());
                radioButton[i].setBorder(new EmptyBorder(0, 10, 0, 0));
                radioButton[i].setAlignmentY(SwingConstants.CENTER);
                radioButton[i].setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 24));
                radioButton[i].addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateMoney();
                    }

                });
                radioButton[0].setSelected(true);
                radioButton[i].setBounds(5, 5, 300, 50);

                panelCheck[i].add(Box.createVerticalGlue());
                panelCheck[i].add(radioButton[i]);
                panelCheck[i].add(Box.createVerticalGlue());

                radioButtonGroup.add(radioButton[i]);

            }

            y += 50;
            panelCheckMain.add(panelCheck[i]);
            i++;
        }

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

        spinnerAmount = new JSpinner(new SpinnerNumberModel(1, 1, 10, 1));
        spinnerAmount.setPreferredSize(new Dimension((int) panelRight2.getPreferredSize().getWidth() - 20,
                (int) panelRight2.getPreferredSize().getHeight() - 10));
        spinnerAmount.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 30));
        spinnerAmount.setForeground(Color.WHITE);
        spinnerAmount.setBackground(new Color(14, 81, 171));
        ((DefaultEditor) spinnerAmount.getEditor()).getTextField().setEditable(false);// ไปเข้าดึงTextFieldมันแทนเพื่อไม่ให้แก้
        spinnerAmount.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                updateMoney();
            }
        });

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
                try {
                    jButtonConfirmActionPerformed(e);
                    JOptionPane.showMessageDialog(panelMain, "Successful purchase", "Successful",
                            JOptionPane.PLAIN_MESSAGE);
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Order.this,
                            "Not enough money, missing another "
                                    + (-1 * (mainFrame.getUser().getMoney()
                                            - Double.parseDouble(textAreaCost.getText()))),
                            "Error",
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

        updateMoney();

        revalidate();
        repaint();
    }

    private void updateMoney() {
        double sumCost = 0;
        if (product.getProductId().charAt(0) == 'F') {
            for (int i = 0; i < checkBox.length; i++) {
                if (checkBox[i].isSelected()) {
                    for (toppings topping : mainFrame.getCatalog().getAllTopFood()) {
                        String[] tempCheckboxText = checkBox[i].getText().split("[ ]");
                        if (tempCheckboxText[1].equals(topping.getTop())) {
                            sumCost += topping.getCost();
                        }
                    }
                }
            }
        } else if (product.getProductId().charAt(0) == 'D') {
            for (int i = 0; i < radioButton.length; i++) {
                if (radioButton[i].isSelected()) {
                    for (toppings topping : mainFrame.getCatalog().getAllTopDrink()) {
                        String[] tempCheckboxText = radioButton[i].getText().split("[ ]");
                        if (tempCheckboxText[0].equals(topping.getTop())) {
                            sumCost += topping.getCost();
                        }
                    }
                }
            }
        }
        textAreaCost.setText(Double.toString((product.getPrice() + sumCost) * (int) spinnerAmount.getValue()));
    }

    protected void jButtonConfirmActionPerformed(ActionEvent e) throws Exception {
        updateMoney();
        if (mainFrame.getUser().getMoney() - Double.parseDouble(textAreaCost.getText()) < 0) {
            throw new Exception("");
        } else {
            mainFrame.getUser().setMoney(mainFrame.getUser().getMoney() - Double.parseDouble(textAreaCost.getText()));
            mainFrame.getService().setMoneyUserInUserList(mainFrame.getUser());
            String stringTopping = "";
            if (product.getProductId().charAt(0) == 'F') {
                for (int i = 0; i < checkBox.length; i++) {
                    if (checkBox[i].isSelected()) {
                        for (toppings topping : mainFrame.getCatalog().getAllTopFood()) {
                            String[] tempCheckboxText = checkBox[i].getText().split("[ ]");
                            if (tempCheckboxText[1].equals(topping.getTop())) {
                                stringTopping += " +" + tempCheckboxText[1];
                            }
                        }
                    }
                }
            } else if (product.getProductId().charAt(0) == 'D') {
                for (int i = 0; i < radioButton.length; i++) {
                    if (radioButton[i].isSelected()) {
                        for (toppings topping : mainFrame.getCatalog().getAllTopDrink()) {
                            String[] tempCheckboxText = radioButton[i].getText().split("[ ]");
                            if (tempCheckboxText[0].equals(topping.getTop())) {
                                stringTopping += " +" + tempCheckboxText[0];
                            }
                        }
                    }
                }
            }

            double sumCost = (Double.parseDouble(textAreaCost.getText()));
            int USER_ID = mainFrame.getUserId();
            mainFrame.getCatalog().addOrder(USER_ID, product, stringTopping, sumCost, (int) spinnerAmount.getValue());// เพิ่มOrder
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