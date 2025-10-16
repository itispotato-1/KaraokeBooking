package GUI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import GUI.Decorate.*;
import lib.Shop.*;
import lib.BookRoom.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Admin_AddAndRemove extends JPanel {
    private Font FontITCKRIST;
    private Font FontTWCENMT;
    private Mainframe mainframe;
    private LocalDate date;
    private RoomSystem system;

    private JLabel[] jLabelRoom;
    private JLabel[] jLabelAvalible;
    private JLabel[] jLabelCost;
    private JPanel[] jPanelBooking;
    private JButton[] jButton;
    private JComboBox<String> jComboBoxDate;
    private JPanel panelTableinside;
    private JPanel jPanelTableBottom;

    private JTextField textFieldRoom;
    private JTextField textFieldCost;
    private JTextField textFieldFor1;
    private JTextField textFieldFor2;
    private JLabel labelFileImg;

    private String choose = "ROOM";
    private File selectedFile;// ไว้เก็บที่อยู่ไฟล์ที่เลือกมา
    private JLabel jLabelTimeOpen;

    public Admin_AddAndRemove(Mainframe mainframe) {
        this.system = mainframe.getSystem();
        this.mainframe = mainframe;
        setUpFont();
        setVisible(true);
        initComponents();
    }

    private void initComponents() {
        removeAll();
        jLabelRoom = new JLabel[100];
        jLabelAvalible = new JLabel[100];
        jLabelCost = new JLabel[100];
        jPanelBooking = new JPanel[100];
        jButton = new JButton[100];

        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.setPreferredSize(new Dimension(440, 664));
        panelMain.setBackground(Color.WHITE);
        add(panelMain);

        JPanel panelSecound = new JPanel();
        panelSecound.setOpaque(false);
        panelSecound.setLayout(new BoxLayout(panelSecound, BoxLayout.Y_AXIS));
        panelSecound.setBackground(Color.WHITE);
        panelSecound.setMaximumSize(new Dimension(400, 600));

        // -------------------------------- Panel ข้างบนสุด ------------------------
        JPanel panelTop = new JPanel(null);
        panelTop.setOpaque(false);
        panelTop.setBackground(Color.WHITE);
        panelTop.setMaximumSize(new Dimension(400, 60));

        JButton buttonExit = new JButton("X");
        buttonExit.setForeground(Color.WHITE);
        buttonExit.setBackground(Color.RED);
        buttonExit.setMaximumSize(new Dimension(40, 40));
        buttonExit.setBounds(5, 10, 35, 35);
        buttonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonLogoutActionPerformed(e);
            }
        });
        JPanel panelAdmin = new JPanel();
        panelAdmin.setOpaque(false);
        panelAdmin.setLayout(new BoxLayout(panelAdmin, BoxLayout.Y_AXIS));
        panelAdmin.setBackground(Color.WHITE);
        panelAdmin.setPreferredSize(new Dimension(250, 50));
        panelAdmin.setMaximumSize(new Dimension(250, 50));
        panelAdmin.setBounds(90, 5, 330, 100);

        JLabel jLabelBookRoom = new JLabel();
        jLabelBookRoom.setFont(FontITCKRIST.deriveFont((float) 30));
        jLabelBookRoom.setText("System ADMIN");

        JPanel panelLine = new JPanel();
        panelLine.setBackground(Color.BLACK);
        panelLine.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        panelLine.setPreferredSize(new Dimension(500, 5));
        panelLine.setMaximumSize(new Dimension(500, 4));

        panelAdmin.add(jLabelBookRoom);
        panelAdmin.add(panelLine);

        panelTop.add(buttonExit);
        panelTop.add(panelAdmin);
        // -------------------------------- Panel ข้างบนสุด ------------------------

        // -------------------------------- Panel ปุ่มเปลี่ยนหน้า -----------------
        JPanel panelButtonSwitch = new JPanel();
        panelButtonSwitch.setOpaque(false);
        panelButtonSwitch.setLayout(new GridLayout(2, 3, 5, 5));
        panelButtonSwitch.setBackground(Color.WHITE);
        panelButtonSwitch.setMaximumSize(new Dimension(400, 100));

        int SIZE_FONTBUTTON = 16;
        int STYLE_FONTBUTTON = 1;
        Font fontButton = FontTWCENMT.deriveFont(STYLE_FONTBUTTON, SIZE_FONTBUTTON).deriveFont((float) SIZE_FONTBUTTON);

        JButton jOrder = new JButton();
        jOrder.setBackground(new Color(0, 161, 255));
        jOrder.setForeground(Color.WHITE);
        jOrder.setFont(fontButton.deriveFont((float) 25));
        jOrder.setText("ORDER");
        jOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonOrderActionPerFormed(e);
            }
        });

        JButton jBook = new JButton();
        jBook.setBackground(new Color(255, 55, 55));
        jBook.setForeground(Color.WHITE);
        jBook.setFont(fontButton.deriveFont((float) 25));
        jBook.setText("BOOK");
        jBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonBookActionPerFormed(e);
            }
        });

        JButton jProfit = new JButton();
        jProfit.setBackground(new Color(4, 153, 23));
        jProfit.setForeground(Color.WHITE);
        jProfit.setFont(fontButton.deriveFont((float) 25));
        jProfit.setText("PROFIT");
        jProfit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonProfitActionPerFormed(e);
            }
        });

        JButton jAddAndRemove = new JButton();
        jAddAndRemove.setBackground(new Color(140, 82, 255));
        jAddAndRemove.setForeground(Color.WHITE);
        jAddAndRemove.setFont(fontButton);
        jAddAndRemove.setText("ADD/REMOVE");
        jAddAndRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonAddAndRemoveActionPerformed(e);
            }
        });

        panelButtonSwitch.add(jBook);
        panelButtonSwitch.add(jOrder);
        panelButtonSwitch.add(jProfit);
        panelButtonSwitch.add(jAddAndRemove);
        panelButtonSwitch.add(Box.createRigidArea(new Dimension(50, 50)));
        panelButtonSwitch.add(Box.createRigidArea(new Dimension(50, 50)));
        // -------------------------------- Panel ปุ่มเปลี่ยนหน้า -----------------

        // -------------------------------- Panel อักษรใต้ปุ่ม -----------------
        JPanel panelText = new JPanel();
        panelText.setOpaque(false);
        panelText.setLayout(new BoxLayout(panelText, BoxLayout.X_AXIS));
        panelText.setBackground(Color.WHITE);
        panelText.setMaximumSize(new Dimension(400, 20));

        JLabel jPleaseTopUp = new JLabel();
        jPleaseTopUp.setFont(new Font("Segoe UI", 0, 10));
        jPleaseTopUp.setForeground(new Color(255, 0, 0));
        jPleaseTopUp.setText("* PLEASE TOP UP TO USE THE APP");

        panelText.add(jPleaseTopUp);
        // -------------------------------- Panel อักษรใต้ปุ่ม -----------------

        // -------------------------------- Panel ตาราง -----------------
        JPanel jPanelTable = new JPanel();
        jPanelTable.setLayout(new BoxLayout(jPanelTable, BoxLayout.Y_AXIS));
        jPanelTable.setBackground(new Color(250, 248, 227));
        jPanelTable.setMaximumSize(new Dimension(400, 398));

        JPanel jPanelTableTop = new JPanel(new BorderLayout());
        jPanelTableTop.setBackground(Color.WHITE);
        jPanelTableTop.setOpaque(false);
        jPanelTableTop.setMaximumSize(new Dimension(400, 50));
        jPanelTableTop.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel jLabelOnlist = new JLabel();
        jLabelOnlist.setFont(FontTWCENMT.deriveFont((float) 35).deriveFont((int) 1));
        jLabelOnlist.setForeground(new Color(1, 41, 94));
        jLabelOnlist.setText("Add/Remove");

        jComboBoxDate = new JComboBox<>();
        jComboBoxDate.setPreferredSize(new Dimension(90, 10));
        DefaultComboBoxModel<String> modelComboBox = new DefaultComboBoxModel<>();
        modelComboBox.addElement("ROOM");
        modelComboBox.addElement("FOOD");
        modelComboBox.addElement("DRINK");
        jComboBoxDate.setModel(modelComboBox);
        if (choose == "ROOM") {
            jComboBoxDate.setSelectedItem("ROOM");
        } else if (choose == "FOOD") {
            jComboBoxDate.setSelectedItem("FOOD");
        } else if (choose == "DRINK") {
            jComboBoxDate.setSelectedItem("DRINK");
        }
        jComboBoxDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tempS = (String) jComboBoxDate.getSelectedItem();
                choose = tempS;
                reGUI();
            }

        });

        jPanelTableTop.add(jLabelOnlist, BorderLayout.CENTER);
        jPanelTableTop.add(jComboBoxDate, BorderLayout.EAST);

        JPanel jPanelTableCenter = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        jPanelTableCenter.setBackground(new Color(250, 248, 227));
        jPanelTableCenter.setMaximumSize(new Dimension(400, 250));

        // ----------------------------- SetupRoomSelection -----------------------
        panelTableinside = new JPanel();

        int size = 0;
        if (choose == "ROOM") {
            size = mainframe.getSystem().getRooms().size();
        } else if (choose == "FOOD") {
            ArrayList<Product> tempArrayList = new ArrayList<>();
            for (Product product : mainframe.getProductSystem().getAllProducts()) {
                if (product.getProductId().charAt(0) == 'F') {
                    tempArrayList.add(product);
                }
            }
            size = tempArrayList.size();
        } else if (choose == "DRINK") {
            ArrayList<Product> tempArrayList = new ArrayList<>();
            for (Product product : mainframe.getProductSystem().getAllProducts()) {
                if (product.getProductId().charAt(0) == 'D') {
                    tempArrayList.add(product);
                }
            }
            size = tempArrayList.size();
        }

        int rows;
        if (size % 2 == 0) {
            rows = size / 2;
        } else {
            rows = (size / 2) + 1;
        }
        if (rows == 1) {
            rows = 2;
        }
        panelTableinside.setLayout(new GridLayout(rows, 2, 5, 5));
        panelTableinside.setBackground(Color.WHITE);
        panelTableinside.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        if (choose == "ROOM") {
            setUpRoomRemove();
        } else if (choose == "DRINK" || choose == "FOOD") {
            setUpFoodAndDrinkRemove();
        }

        int SPEED_SCROLLBAR = 8;

        JScrollPane scroll = new JScrollPane(panelTableinside);
        scroll.setPreferredSize(new Dimension(350, 250));
        scroll.getVerticalScrollBar().setUnitIncrement(SPEED_SCROLLBAR);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(0, 74, 173), 3));
        jPanelTableCenter.add(scroll);
        // ----------------------------------------------------------------------------
        jPanelTableBottom = new JPanel(null);
        jPanelTableBottom.setBackground(Color.ORANGE);
        jPanelTableBottom.setOpaque(false);
        jPanelTableBottom.setMaximumSize(new Dimension(400, 100));

        if (choose == "ROOM") {
            setUpRoomAdd();
        } else if (choose == "DRINK" || choose == "FOOD") {
            setUpFoodAndDrinkAdd();
        }

        // ----------------------------- SetupRoomSelection -----------------------
        jPanelTable.add(jPanelTableTop);
        jPanelTable.add(jPanelTableCenter);
        jPanelTable.add(jPanelTableBottom);
        // -------------------------------- Panel ห้อง -----------------

        panelSecound.add(panelTop);
        panelSecound.add(panelButtonSwitch);
        panelSecound.add(panelText);
        panelSecound.add(jPanelTable);

        panelMain.add(Box.createVerticalStrut(10));
        panelMain.add(panelSecound);

        revalidate();
        repaint();
    }

    private void jButtonProfitActionPerFormed(ActionEvent evt) {
        mainframe.showPanel("admin_Profit");
    }

    private void jButtonOrderActionPerFormed(ActionEvent evt) {
        mainframe.showPanel("admin_Order");
    }

    private void jButtonLogoutActionPerformed(ActionEvent evt) {
        mainframe.showPanel("login");
    }

    private void jButtonBookActionPerFormed(ActionEvent evt) {
        mainframe.showPanel("admin_Book");
    }

    private void jButtonAddAndRemoveActionPerformed(ActionEvent evt) {
        mainframe.showPanel("admin_AddAndRemove");
    }

    private void jButtonAddRoomActionPerformed() {
        try {
            if (textFieldRoom.getText().isBlank() || textFieldCost.getText().isBlank()
                    || textFieldFor1.getText().isBlank()) {
                throw new RuntimeException("Room or Cost or For1 isBlank.");
            }
            if (Integer.parseInt(textFieldFor1.getText()) == 0) {
                throw new RuntimeException("For1 must > 0 ");
            }
            if (!textFieldFor2.getText().isBlank()) {
                if (Integer.parseInt(textFieldFor1.getText()) >= Integer.parseInt(textFieldFor2.getText())) {
                    throw new RuntimeException("For1 must be greater than For2.");
                }
            }
            int idRoom = Integer.parseInt(textFieldRoom.getText());
            double price = Double.parseDouble(textFieldCost.getText());
            String For;
            if (textFieldFor2.getText().isBlank()) {
                For = textFieldFor1.getText() + "+";
            } else {
                For = textFieldFor1.getText() + "-" + textFieldFor2.getText();
            }
            Room tempRoom = new Room(For, idRoom, price);
            mainframe.getSystem().addRoom(tempRoom);
            JOptionPane.showMessageDialog(Admin_AddAndRemove.this, "SUCCESS", "SUCCESS",
                    JOptionPane.PLAIN_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(Admin_AddAndRemove.this, ex, "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        reGUI();
    }

    private void setUpRoomAdd() {
        JLabel labelRoom = new JLabel();
        labelRoom.setFont(FontTWCENMT.deriveFont((float) 24).deriveFont((int) 1));
        labelRoom.setText("Room:");
        labelRoom.setBounds(5, 5, 150, 50);

        textFieldRoom = new JTextField();
        textFieldRoom.setFont(FontTWCENMT.deriveFont((float) 20).deriveFont((int) 1));
        textFieldRoom.setBounds(65, 10, 100, 40);
        textFieldRoom.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!(e.getKeyChar() >= '0' && e.getKeyChar() <= '9'))
                    e.consume();
                else if (textFieldRoom.getText().length() >= 7) {
                    e.consume();
                }
            }
        });

        JLabel labelCost = new JLabel();
        labelCost.setFont(FontTWCENMT.deriveFont((float) 24).deriveFont((int) 1));
        labelCost.setText("Cost:");
        labelCost.setBounds(165, 5, 150, 50);

        textFieldCost = new JTextField();
        textFieldCost.setFont(FontTWCENMT.deriveFont((float) 20).deriveFont((int) 1));
        textFieldCost.setBounds(215, 10, 100, 40);
        textFieldCost.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!(e.getKeyChar() >= '0' && e.getKeyChar() <= '9'))
                    e.consume();
                else if (textFieldCost.getText().length() >= 7) {
                    e.consume();
                }
            }
        });

        JLabel labelFor = new JLabel();
        labelFor.setFont(FontTWCENMT.deriveFont((float) 24).deriveFont((int) 1));
        labelFor.setText("For:");
        labelFor.setBounds(28, 50, 150, 50);

        textFieldFor1 = new JTextField();
        textFieldFor1.setFont(FontTWCENMT.deriveFont((float) 20).deriveFont((int) 1));
        textFieldFor1.setBounds(65, 55, 50, 40);
        textFieldFor1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!(e.getKeyChar() >= '0' && e.getKeyChar() <= '9'))
                    e.consume();
                else if (textFieldFor1.getText().length() >= 3) {
                    e.consume();
                }
            }
        });

        JLabel labelLine = new JLabel();
        labelLine.setFont(FontTWCENMT.deriveFont((float) 24).deriveFont((int) 1));
        labelLine.setText("-");
        labelLine.setBounds(120, 50, 150, 50);

        textFieldFor2 = new JTextField();
        textFieldFor2.setFont(FontTWCENMT.deriveFont((float) 20).deriveFont((int) 1));
        textFieldFor2.setBounds(135, 55, 50, 40);
        textFieldFor2.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!(e.getKeyChar() >= '0' && e.getKeyChar() <= '9'))
                    e.consume();
                else if (textFieldFor2.getText().length() >= 3) {
                    e.consume();
                }
            }
        });

        JButton buttonAdd = new JButton("ADD");
        buttonAdd.setBackground(new Color(4, 153, 23));
        buttonAdd.setFont(FontTWCENMT.deriveFont((float) 16).deriveFont((int) 1));
        buttonAdd.setForeground(Color.WHITE);
        buttonAdd.setBounds(330, 10, 60, 80);
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonAddRoomActionPerformed();
            }

        });

        jPanelTableBottom.add(labelRoom);
        jPanelTableBottom.add(textFieldRoom);
        jPanelTableBottom.add(labelCost);
        jPanelTableBottom.add(textFieldCost);
        jPanelTableBottom.add(labelFor);
        jPanelTableBottom.add(textFieldFor1);
        jPanelTableBottom.add(labelLine);
        jPanelTableBottom.add(textFieldFor2);
        jPanelTableBottom.add(buttonAdd);
    }

    private void setUpFoodAndDrinkAdd() {
        JLabel labelRoom = new JLabel();
        labelRoom.setFont(FontTWCENMT.deriveFont((float) 24).deriveFont((int) 1));
        labelRoom.setText("Name:");
        labelRoom.setBounds(5, 5, 150, 50);
        labelRoom.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == ' ')
                    e.consume();
            }
        });

        textFieldRoom = new JTextField();
        textFieldRoom.setFont(FontTWCENMT.deriveFont((float) 20).deriveFont((int) 1));
        textFieldRoom.setBounds(70, 10, 100, 40);

        JLabel labelCost = new JLabel();
        labelCost.setFont(FontTWCENMT.deriveFont((float) 24).deriveFont((int) 1));
        labelCost.setText("Cost:");
        labelCost.setBounds(170, 5, 150, 50);

        textFieldCost = new JTextField();
        textFieldCost.setFont(FontTWCENMT.deriveFont((float) 20).deriveFont((int) 1));
        textFieldCost.setBounds(220, 10, 100, 40);
        textFieldCost.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (!(e.getKeyChar() >= '0' && e.getKeyChar() <= '9'))
                    e.consume();
                if (textFieldCost.getText().length() >= 7) {
                    e.consume();
                }
            }
        });

        JLabel labelImg = new JLabel();
        labelImg.setFont(FontTWCENMT.deriveFont((float) 24).deriveFont((int) 1));
        labelImg.setText("Image:");
        labelImg.setBounds(0, 50, 150, 50);

        labelFileImg = new JLabel();
        labelFileImg.setFont(FontTWCENMT.deriveFont((float) 10).deriveFont((int) 1));
        labelFileImg.setText("None");
        labelFileImg.setBounds(165, 50, 150, 50);

        JButton buttonAddImg = new JButton("Choose a File...");
        buttonAddImg.setBackground(Color.WHITE);
        buttonAddImg.setFont(FontTWCENMT.deriveFont((float) 10).deriveFont((int) 1));
        buttonAddImg.setBounds(70, 55, 90, 40);
        buttonAddImg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Choose a File...");
                FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "Images (*.jpg, *.jpeg ,*png)", "jpg", "jpeg", "png", "avif");
                chooser.setFileFilter(filter);
                int result = chooser.showOpenDialog(Admin_AddAndRemove.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = chooser.getSelectedFile();
                    System.out.println("File Choose: " + selectedFile.getAbsolutePath());
                    labelFileImg.setText(selectedFile.getAbsolutePath());
                }
            }

        });

        JButton buttonAdd = new JButton("ADD");
        buttonAdd.setBackground(new Color(4, 153, 23));
        buttonAdd.setFont(FontTWCENMT.deriveFont((float) 16).deriveFont((int) 1));
        buttonAdd.setForeground(Color.WHITE);
        buttonAdd.setBounds(330, 10, 60, 80);
        buttonAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (textFieldRoom.getText().isBlank() || textFieldCost.getText().isBlank()) {
                    JOptionPane.showMessageDialog(Admin_AddAndRemove.this, "Error : Name or Cost is Blank.", "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    jButtonAddFoodAndDrinkActionPerformed(textFieldRoom.getText(),
                            Double.parseDouble(textFieldCost.getText()));
                }
            }

        });

        jPanelTableBottom.add(labelRoom);
        jPanelTableBottom.add(textFieldRoom);
        jPanelTableBottom.add(labelCost);
        jPanelTableBottom.add(textFieldCost);
        jPanelTableBottom.add(labelImg);
        jPanelTableBottom.add(buttonAddImg);
        jPanelTableBottom.add(labelFileImg);
        jPanelTableBottom.add(buttonAdd);
    }

    private void jButtonAddFoodAndDrinkActionPerformed(String name, double cost) {
        if (selectedFile == null) {
            JOptionPane.showMessageDialog(this, "Error : File is None", "ERROR", JOptionPane.ERROR_MESSAGE);
            return;
        } else if (cost <= 0) {
            JOptionPane.showMessageDialog(this, "Error : Price cannot be negattive or Zero", "ERROR",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        // System.out.println(mainframe.getProductSystem().searchIdAvailable(ProductEnum.FOOD));
        String tempString = null;

        int choice = -2;
        if (choose == "FOOD") {
            choice = JOptionPane.showConfirmDialog(this, "Confirm FOOD :" + name + "?",
                    "Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                tempString = mainframe.getProductSystem().searchIdAvailable(ProductEnum.FOOD);
                Product product = new Product("F" + mainframe.getProductSystem().searchIdAvailable(ProductEnum.FOOD),
                        name,
                        cost);
                mainframe.getProductSystem().addCatalogProduct(product, ProductEnum.FOOD);
            }
        } else if (choose == "DRINK") {
            choice = JOptionPane.showConfirmDialog(this, "Confirm DRINK :" + name + "?",
                    "Confirmation", JOptionPane.YES_NO_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                tempString = mainframe.getProductSystem().searchIdAvailable(ProductEnum.DRINK);
                Product product = new Product("D" + mainframe.getProductSystem().searchIdAvailable(ProductEnum.DRINK),
                        name,
                        cost);
                mainframe.getProductSystem().addCatalogProduct(product, ProductEnum.DRINK);
            }
        }
        String fileString = "";
        if (choose == "FOOD") {
            fileString = "./GUI/Picture/Food/F" + tempString + ".jpg";
        } else if (choose == "DRINK") {
            fileString = "./GUI/Picture/Drink/D" + tempString + ".jpg";
        }

        if (choice == JOptionPane.YES_OPTION) {
            File destFile = new File(fileString);// ใส่ชื่อไฟล์

            try (
                    FileInputStream fis = new FileInputStream(selectedFile);
                    FileOutputStream fos = new FileOutputStream(destFile)) {
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
            } catch (IOException e) {
                System.out.println(e);
            }
            textFieldRoom.setText("");
            textFieldCost.setText("");
            labelFileImg.setText("");
            reGUI();
        }
    }

    private void setUpRoomRemove() {
        RoundedPanel[] panelRoom = new RoundedPanel[100];
        JLabel[] labelRoomInPanel = new JLabel[100];
        JLabel[] labelForInPanel = new JLabel[100];
        JLabel[] labelCostInPanel = new JLabel[100];
        JButton[] buttonRemoveRoom = new JButton[100];

        int i = 0;
        for (Room room : mainframe.getSystem().getRooms()) {
            panelRoom[i] = new RoundedPanel(30, 30, Color.BLACK, 4);
            panelRoom[i].setLayout(new BoxLayout(panelRoom[i], BoxLayout.Y_AXIS));
            panelRoom[i].setBackground(Color.WHITE);
            panelRoom[i].setPreferredSize(new Dimension(155, 125));

            labelRoomInPanel[i] = new JLabel();
            labelRoomInPanel[i].setFont(FontTWCENMT.deriveFont((float) 20).deriveFont((int) 1));
            labelRoomInPanel[i].setText("Room " + room.getIdRoom());
            labelRoomInPanel[i].setMaximumSize(new Dimension(175, 25));
            labelRoomInPanel[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            labelRoomInPanel[i].setHorizontalAlignment(SwingConstants.CENTER);

            labelForInPanel[i] = new JLabel();
            labelForInPanel[i].setFont(FontTWCENMT.deriveFont((float) 20).deriveFont((int) 1));
            labelForInPanel[i].setText("For : " + room.getFor());
            labelForInPanel[i].setMaximumSize(new Dimension(175, 25));
            labelForInPanel[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            labelForInPanel[i].setHorizontalAlignment(SwingConstants.CENTER);

            labelCostInPanel[i] = new JLabel();
            labelCostInPanel[i].setFont(FontTWCENMT.deriveFont((float) 20).deriveFont((int) 1));
            labelCostInPanel[i].setText("Cost : " + room.getPrice());
            labelCostInPanel[i].setMaximumSize(new Dimension(175, 25));
            labelCostInPanel[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            labelCostInPanel[i].setHorizontalAlignment(SwingConstants.CENTER);

            buttonRemoveRoom[i] = new JButton();
            buttonRemoveRoom[i].setFont(FontTWCENMT.deriveFont((float) 20).deriveFont((int) 1));
            buttonRemoveRoom[i].setText("Remove");
            buttonRemoveRoom[i].setBackground(Color.red);
            buttonRemoveRoom[i].setForeground(Color.WHITE);
            buttonRemoveRoom[i].setMaximumSize(new Dimension(135, 40));
            buttonRemoveRoom[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonRemoveRoom[i].putClientProperty(1, room);
            buttonRemoveRoom[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tempButton = (JButton) e.getSource();
                    Room tempRoom = (Room) tempButton.getClientProperty(1);

                    int choice = JOptionPane.showConfirmDialog(Admin_AddAndRemove.this,
                            "Confirm Remove :" + tempRoom.getIdRoom() + "?",
                            "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        mainframe.getSystem().removeRoom(tempRoom);
                        reGUI();
                    }
                }
            });

            panelRoom[i].add(Box.createVerticalStrut(5));
            panelRoom[i].add(labelRoomInPanel[i]);
            panelRoom[i].add(labelForInPanel[i]);
            panelRoom[i].add(labelCostInPanel[i]);
            panelRoom[i].add(buttonRemoveRoom[i]);
            panelRoom[i].add(Box.createVerticalStrut(5));

            panelTableinside.add(panelRoom[i]);
            i++;
        }

        JPanel emptyPanel1 = new JPanel();
        emptyPanel1.setPreferredSize(new Dimension(125, 125));
        emptyPanel1.setOpaque(false);

        JPanel emptyPanel2 = new JPanel();
        emptyPanel2.setPreferredSize(new Dimension(125, 125));
        emptyPanel2.setOpaque(false);
        if (mainframe.getSystem().getRooms().size() == 1 || mainframe.getSystem().getRooms().size() == 2) {
            panelTableinside.add(emptyPanel1);
            panelTableinside.add(emptyPanel2);
        }
    }

    private void setUpFoodAndDrinkRemove() {
        RoundedPanel[] panelRoom = new RoundedPanel[100];
        JPanel[] panelLeft = new JPanel[100];
        JPanel[] panelRight = new JPanel[100];
        JPanel[] panelRightTop = new JPanel[100];
        JLabel[] labelImg = new JLabel[100];
        JLabel[] labelNameOrder = new JLabel[100];
        JTextField[] textAreaCost = new JTextField[100];
        JButton[] buttonCancel = new JButton[100];

        ArrayList<Product> tempArrayList = new ArrayList<>();
        tempArrayList.clear();
        if (choose == "FOOD") {
            for (Product product : mainframe.getProductSystem().getAllProducts()) {
                if (product.getProductId().charAt(0) == 'F') {
                    tempArrayList.add(product);
                }
            }
        } else if (choose == "DRINK") {
            for (Product product : mainframe.getProductSystem().getAllProducts()) {
                if (product.getProductId().charAt(0) == 'D') {
                    tempArrayList.add(product);
                }
            }
        }

        int i = 0;
        for (Product product : tempArrayList) {
            panelRoom[i] = new RoundedPanel(30, 30, Color.BLACK, 4);
            panelRoom[i].setLayout(new BoxLayout(panelRoom[i], BoxLayout.X_AXIS));
            panelRoom[i].setBackground(new Color(230, 230, 230));
            panelRoom[i].setPreferredSize(new Dimension(155, 100));
            // panelRoom.setBounds(5, 5, 155, 125);
            panelLeft[i] = new JPanel();
            panelLeft[i].setLayout(new FlowLayout(FlowLayout.RIGHT, 1, 20));
            panelLeft[i].setBackground(Color.RED);
            panelLeft[i].setOpaque(false);
            panelLeft[i].setPreferredSize(new Dimension(50, 100));

            labelImg[i] = new JLabel("");
            ImageIcon tempImageIcon1 = null;
            if (choose == "FOOD") {
                tempImageIcon1 = new ImageIcon("./GUI/Picture/Food/" + product.getProductId() + ".jpg");
            } else if (choose == "DRINK") {
                tempImageIcon1 = new ImageIcon("./GUI/Picture/Drink/" + product.getProductId() + ".jpg");
            }
            Image tempImage1 = tempImageIcon1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            labelImg[i].setIcon(new ImageIcon(tempImage1));
            labelImg[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));

            panelLeft[i].add(labelImg[i]);

            panelRight[i] = new JPanel();
            panelRight[i].setLayout(null);
            panelRight[i].setBackground(Color.BLUE);
            panelRight[i].setOpaque(false);
            panelRight[i].setPreferredSize(new Dimension(90, 100));

            int tempwidth = 90;
            panelRightTop[i] = new JPanel(null);
            panelRightTop[i].setBackground(Color.WHITE);
            panelRightTop[i].setBounds(5, 10, tempwidth, 30);

            labelNameOrder[i] = new JLabel();
            labelNameOrder[i].setText(product.getProductName());
            labelNameOrder[i].setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 14));
            labelNameOrder[i].setBounds(1, 1, 140, 30);

            panelRightTop[i].add(labelNameOrder[i]);

            textAreaCost[i] = new JTextField("0");
            textAreaCost[i].setText(Double.toString(product.getPrice()));
            textAreaCost[i].setFont(FontITCKRIST.deriveFont(1).deriveFont((float) 15));
            textAreaCost[i].setForeground(Color.WHITE);
            textAreaCost[i].setBackground(new Color(182, 77, 0));
            textAreaCost[i].setBounds(1, 40, tempwidth + 6, 30);
            textAreaCost[i].setHorizontalAlignment(JTextField.RIGHT);
            textAreaCost[i].setEditable(false);

            buttonCancel[i] = new JButton("REMOVE");
            buttonCancel[i].setForeground(Color.WHITE);
            buttonCancel[i].setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 15));
            buttonCancel[i].setBounds(1, 67, tempwidth + 6, 25);
            buttonCancel[i].setBackground(Color.red);
            buttonCancel[i].putClientProperty(1, product);
            buttonCancel[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int choice = JOptionPane.showConfirmDialog(null, "Confirm Remove : " + product.getProductName(),
                            "Confirmation", JOptionPane.YES_NO_OPTION);
                    if (choice == JOptionPane.YES_OPTION) {
                        JButton tempButton = (JButton) e.getSource();
                        Product tempProduct = (Product) tempButton.getClientProperty(1);
                        mainframe.getProductSystem().removeCatalogProduct(tempProduct);
                        reGUI();
                    }
                }
            });

            panelRight[i].add(panelRightTop[i]);
            panelRight[i].add(textAreaCost[i]);
            panelRight[i].add(buttonCancel[i]);

            panelRoom[i].add(panelLeft[i]);
            panelRoom[i].add(panelRight[i]);

            panelTableinside.add(panelRoom[i]);
            i++;
        }

        JPanel emptyPanel1 = new JPanel();
        emptyPanel1.setPreferredSize(new Dimension(125, 125));
        emptyPanel1.setOpaque(false);

        JPanel emptyPanel2 = new JPanel();
        emptyPanel2.setPreferredSize(new Dimension(125, 125));
        emptyPanel2.setOpaque(false);
        if (mainframe.getSystem().getRooms().size() == 1 || mainframe.getSystem().getRooms().size() == 2) {
            panelTableinside.add(emptyPanel1);
            panelTableinside.add(emptyPanel2);
        }
    }

    public void reGUI() {
        initComponents();
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