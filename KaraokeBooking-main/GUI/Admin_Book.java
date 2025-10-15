package GUI;

import javax.swing.*;

import GUI.Decorate.*;
import lib.BookRoom.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;

public class Admin_Book extends JPanel {
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
    private JPanel panelRoominside;

    private JLabel jLabelTimeOpen;

    public Admin_Book(Mainframe mainframe) {
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
                jButtonMyBookActionPerFormed(e);
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

        // -------------------------------- Panel ห้อง -----------------
        JPanel jPanelRoom = new JPanel();
        jPanelRoom.setLayout(new BoxLayout(jPanelRoom, BoxLayout.Y_AXIS));
        jPanelRoom.setBackground(new Color(250, 248, 227));
        jPanelRoom.setMaximumSize(new Dimension(400, 398));

        JPanel jPanelRoomTop = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        jPanelRoomTop.setBackground(Color.WHITE);
        jPanelRoomTop.setOpaque(false);
        jPanelRoomTop.setMaximumSize(new Dimension(400, 50));

        JLabel jLabelOnlist = new JLabel();
        jLabelOnlist.setFont(FontTWCENMT.deriveFont((float) 42).deriveFont((int) 1));
        jLabelOnlist.setForeground(new Color(1, 41, 94));
        jLabelOnlist.setText("BOOK");

        jPanelRoomTop.add(jLabelOnlist);

        JPanel jPanelRoomButtom = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        jPanelRoomButtom.setBackground(Color.WHITE);
        jPanelRoomButtom.setMaximumSize(new Dimension(400, 350));

        // ----------------------------- SetupRoomSelection -----------------------
        int rows;
        if (mainframe.getSystem().getBookTimeAll().size() % 2 == 0) {
            rows = mainframe.getSystem().getBookTimeAll().size() / 2;
        } else {
            rows = (mainframe.getSystem().getBookTimeAll().size() / 2) + 1;
        }
        if (rows == 1) {
            rows = 2;
        }
        panelRoominside = new JPanel();
        panelRoominside.setLayout(new GridLayout(rows, 2, 5, 5));
        panelRoominside.setBackground(new Color(250, 248, 227));
        panelRoominside.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        setUpRoomRemove();

        int SPEED_SCROLLBAR = 8;
        JScrollPane scroll = new JScrollPane(panelRoominside);
        scroll.setPreferredSize(new Dimension(380, 350));
        scroll.getVerticalScrollBar().setUnitIncrement(SPEED_SCROLLBAR);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(BorderFactory.createLineBorder(new Color(0, 74, 173), 4, true));
        jPanelRoomButtom.add(scroll);
        // ----------------------------- SetupRoomSelection -----------------------

        jPanelRoom.add(jPanelRoomTop);
        jPanelRoom.add(jPanelRoomButtom);
        // -------------------------------- Panel ห้อง -----------------

        panelSecound.add(panelTop);
        panelSecound.add(panelButtonSwitch);
        panelSecound.add(panelText);
        panelSecound.add(jPanelRoom);

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

    private void jButtonMyBookActionPerFormed(ActionEvent evt) {
        mainframe.showPanel("admin_Book");
    }

    private void jButtonAddAndRemoveActionPerformed(ActionEvent evt) {
        mainframe.showPanel("admin_AddAndRemove");
    }

    private void setUpRoomRemove() {
        RoundedPanel[] panelRoom = new RoundedPanel[100];
        JLabel[] labelRoomInPanel = new JLabel[100];
        //JLabel[] labelForInPanel = new JLabel[100];
        JLabel[] labelCostInPanel = new JLabel[100];
        JLabel[] labelTimeInPanel = new JLabel[100];
        JLabel[] labelDateInPanel = new JLabel[100];
        JButton[] buttonRemoveRoom = new JButton[100];

        int i = 0;
        for (RoomTime roomTime : mainframe.getSystem().getBookTimeAll()) {
            panelRoom[i] = new RoundedPanel(30, 30, Color.BLACK, 4);
            panelRoom[i].setLayout(new BoxLayout(panelRoom[i], BoxLayout.Y_AXIS));
            panelRoom[i].setBackground(Color.WHITE);
            panelRoom[i].setPreferredSize(new Dimension(155, 150));

            labelRoomInPanel[i] = new JLabel();
            labelRoomInPanel[i].setFont(FontTWCENMT.deriveFont((float) 20).deriveFont((int) 1));
            labelRoomInPanel[i].setText("ID "+roomTime.getUser().getUserId()+"|Room " + roomTime.getRoom().getIdRoom());
            labelRoomInPanel[i].setMaximumSize(new Dimension(175, 25));
            labelRoomInPanel[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            labelRoomInPanel[i].setHorizontalAlignment(SwingConstants.CENTER);

            labelCostInPanel[i] = new JLabel();
            labelCostInPanel[i].setFont(FontTWCENMT.deriveFont((float) 20).deriveFont((int) 1));
            labelCostInPanel[i].setText("Cost : " + roomTime.getRoom().getPrice());
            labelCostInPanel[i].setMaximumSize(new Dimension(175, 25));
            labelCostInPanel[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            labelCostInPanel[i].setHorizontalAlignment(SwingConstants.CENTER);

            labelTimeInPanel[i] = new JLabel();
            labelTimeInPanel[i].setFont(FontTWCENMT.deriveFont((float) 15).deriveFont((int) 1));
            String time = "Time : " + roomTime.getTimeStart().getHour() + ":" + roomTime.getTimeStart().getMinute()
                    + ":" + roomTime.getTimeStart().getSecond() + " - " + roomTime.getTimeEnd().getHour() + ":"
                    + roomTime.getTimeEnd().getMinute()
                    + ":" + roomTime.getTimeEnd().getSecond();
            labelTimeInPanel[i].setText(time);
            labelTimeInPanel[i].setMaximumSize(new Dimension(275, 25));
            labelTimeInPanel[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            labelTimeInPanel[i].setHorizontalAlignment(SwingConstants.CENTER);

            labelDateInPanel[i] = new JLabel();
            labelDateInPanel[i].setFont(FontTWCENMT.deriveFont((float) 15).deriveFont((int) 1));
            String date = "Date : " + roomTime.getTimeStart().getDayOfMonth() + ":"
                    + roomTime.getTimeStart().getMonthValue()
                    + ":" + roomTime.getTimeStart().getYear();
            labelDateInPanel[i].setText(date);
            labelDateInPanel[i].setMaximumSize(new Dimension(275, 25));
            labelDateInPanel[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            labelDateInPanel[i].setHorizontalAlignment(SwingConstants.CENTER);

            buttonRemoveRoom[i] = new JButton();
            buttonRemoveRoom[i].setFont(FontTWCENMT.deriveFont((float) 20).deriveFont((int) 1));
            buttonRemoveRoom[i].setText("Remove");
            buttonRemoveRoom[i].setBackground(Color.red);
            buttonRemoveRoom[i].setForeground(Color.WHITE);
            buttonRemoveRoom[i].setMaximumSize(new Dimension(135, 40));
            buttonRemoveRoom[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonRemoveRoom[i].putClientProperty(1, roomTime);
            buttonRemoveRoom[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tempButton = (JButton) e.getSource();//
                    RoomTime tempRoom = (RoomTime) tempButton.getClientProperty(1);
                    int confirm = JOptionPane.showConfirmDialog(Admin_Book.this, "Do you want to remove?",
                            "Confirmation", JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.YES_OPTION) {
                        mainframe.getSystem().removeBookRoom(tempRoom.getRoom(), tempRoom.getUser(),
                                tempRoom.getTimeStart(), tempRoom.getTimeEnd());
                        String[] tempStr = mainframe.getService().getValueUserList(tempRoom.getUser().getUsername(),
                                tempRoom.getUser().getPassword());
                        tempRoom.getUser().setMoney(Double.parseDouble(tempStr[4]));// ตั้งค่าเงินของผู้ใช้
                        tempRoom.getUser().setMoney(tempRoom.getUser().getMoney() + (tempRoom.getRoom().getPrice()));// คืนเงินเต็มจำนวน
                        mainframe.getService().setMoneyUserInUserList(tempRoom.getUser());
                        mainframe.getSystemMoney().setProfit(-tempRoom.getRoom().getPrice());
                        reGUI();
                    }
                }
            });

            panelRoom[i].add(Box.createVerticalStrut(5));
            panelRoom[i].add(labelRoomInPanel[i]);
            panelRoom[i].add(labelCostInPanel[i]);
            panelRoom[i].add(labelDateInPanel[i]);
            panelRoom[i].add(labelTimeInPanel[i]);
            panelRoom[i].add(buttonRemoveRoom[i]);
            panelRoom[i].add(Box.createVerticalStrut(5));

            panelRoominside.add(panelRoom[i]);
            i++;
        }

        JPanel emptyPanel1 = new JPanel();
        emptyPanel1.setPreferredSize(new Dimension(125, 125));
        emptyPanel1.setOpaque(false);

        JPanel emptyPanel2 = new JPanel();
        emptyPanel2.setPreferredSize(new Dimension(125, 125));
        emptyPanel2.setOpaque(false);
        if (mainframe.getSystem().getBookTimeAll().size() == 1 || mainframe.getSystem().getBookTimeAll().size() == 2) {
            panelRoominside.add(emptyPanel1);
            panelRoominside.add(emptyPanel2);
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