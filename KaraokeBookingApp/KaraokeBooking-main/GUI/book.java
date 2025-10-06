package GUI;

import javax.swing.*;
import javax.swing.JSpinner.*;
import javax.swing.border.*;

import GUI.Decorate.*;
import lib.BookRoom.Room;
import lib.BookRoom.RoomSystem;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.time.LocalDate;

public class book extends JPanel {
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

    JLabel jOpen;

    public book(Mainframe mainframe) {
        this.system = mainframe.getSystem();
        this.mainframe = mainframe;
        setUpFont();
        setVisible(true);
        initComponents();
    }

    private void initComponents() {
        removeAll();
        jLabelRoom = new JLabel[100];//
        jLabelAvalible = new JLabel[100];//
        jLabelCost = new JLabel[100];//
        jPanelBooking = new JPanel[100];//
        jButton = new JButton[100];//

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

        JPanel panelMoney = new JPanel();
        panelMoney.setLayout(new BoxLayout(panelMoney, BoxLayout.X_AXIS));
        panelMoney.setBackground(new Color(255, 255, 204));
        panelMoney.setMaximumSize(new Dimension(200, 40));
        panelMoney.setBounds(150, 15, 115, 30);

        JLabel labelMoney = new JLabel();
        labelMoney.setBackground(new Color(255, 255, 255));
        labelMoney.setFont(FontTWCENMT.deriveFont((float) 14).deriveFont((int) 1)); // NOI18N
        labelMoney.setText("MONEY : " + mainframe.getUser().getMoney());// ไว้แก้Money

        panelMoney.add(Box.createHorizontalStrut(5));
        panelMoney.add(labelMoney);

        JPanel panelBookRoom = new JPanel();
        panelBookRoom.setOpaque(false);
        panelBookRoom.setLayout(new BoxLayout(panelBookRoom, BoxLayout.Y_AXIS));
        panelBookRoom.setBackground(Color.WHITE);
        panelBookRoom.setPreferredSize(new Dimension(250, 50));
        panelBookRoom.setMaximumSize(new Dimension(250, 50));
        panelBookRoom.setBounds(270, 5, 130, 50);

        JLabel jLabelBookRoom = new JLabel();
        jLabelBookRoom.setFont(FontITCKRIST.deriveFont((float) 14));
        jLabelBookRoom.setText("BOOK A ROOM");

        JPanel panelLine = new JPanel();
        panelLine.setBackground(Color.BLACK);
        panelLine.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));
        panelLine.setPreferredSize(new Dimension(250, 5));
        panelLine.setMaximumSize(new Dimension(250, 4));

        panelBookRoom.add(Box.createVerticalStrut(10));
        panelBookRoom.add(jLabelBookRoom);
        panelBookRoom.add(Box.createVerticalStrut(5));
        panelBookRoom.add(panelLine);
        panelBookRoom.add(Box.createVerticalStrut(10));

        panelTop.add(buttonExit);
        panelTop.add(panelMoney);
        panelTop.add(panelBookRoom);
        // -------------------------------- Panel ข้างบนสุด ------------------------

        // -------------------------------- Panel เวลา ------------------------
        JPanel panelTime = new JPanel(new BorderLayout());
        panelTime.setOpaque(false);
        panelTime.setLayout(new BoxLayout(panelTime, BoxLayout.X_AXIS));
        panelTime.setBackground(Color.WHITE);
        panelTime.setMaximumSize(new Dimension(300, 50));

        jOpen = new JLabel("NULL");
        jOpen.setFont(FontITCKRIST.deriveFont((float) 18));
        setUpTime();

        panelTime.add(Box.createHorizontalGlue());
        panelTime.add(jOpen);
        panelTime.add(Box.createHorizontalGlue());
        // -------------------------------- Panel เวลา ------------------------

        // -------------------------------- Panel ปุ่มเปลี่ยนหน้า -----------------
        JPanel panelButtonSwitch = new JPanel();
        panelButtonSwitch.setOpaque(false);
        panelButtonSwitch.setLayout(new GridLayout(2, 3, 5, 5));
        panelButtonSwitch.setBackground(Color.WHITE);
        panelButtonSwitch.setMaximumSize(new Dimension(400, 100));

        int SIZE_FONTBUTTON = 16;
        int STYLE_FONTBUTTON = 1;
        Font fontButton = FontTWCENMT.deriveFont(STYLE_FONTBUTTON, SIZE_FONTBUTTON).deriveFont((float) SIZE_FONTBUTTON);

        JButton jBookingButton = new JButton();
        jBookingButton.setBackground(new Color(163, 228, 255));
        jBookingButton.setFont(fontButton);
        jBookingButton.setText("BOOKING");
        jBookingButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               jButtonBookingActionPerFormed(e);
            }
        });

        JButton jMyBooking = new JButton();
        jMyBooking.setBackground(new Color(245, 147, 130));
        jMyBooking.setFont(fontButton);
        jMyBooking.setText("MY BOOKING");
        jMyBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               jButtonMyBookingActionPerFormed(e);
            }
        });

        JButton jOrderFood = new JButton();
        jOrderFood.setBackground(new Color(250, 206, 172));
        jOrderFood.setFont(fontButton);
        jOrderFood.setText("ORDER FOOD");
        jOrderFood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               jButtonOrderActionPerFormed(e);
            }
        });

        JButton jTopUp = new JButton();
        jTopUp.setBackground(new Color(204, 255, 204));
        jTopUp.setFont(fontButton);
        jTopUp.setText("TOP UP");
        jTopUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               jButton1TopupActionPerformed(e);
            }
        });

        panelButtonSwitch.add(jMyBooking);
        panelButtonSwitch.add(jBookingButton);
        panelButtonSwitch.add(jOrderFood);
        panelButtonSwitch.add(jTopUp);
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

        JPanel jPanelRoomTop = new JPanel(new BorderLayout());
        jPanelRoomTop.setBackground(Color.WHITE);
        jPanelRoomTop.setOpaque(false);
        jPanelRoomTop.setMaximumSize(new Dimension(400, 50));
        jPanelRoomTop.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JLabel jLabelOnlist = new JLabel();
        jLabelOnlist.setFont(FontTWCENMT.deriveFont((float) 14).deriveFont((int) 1)); // NOI18N
        jLabelOnlist.setText("WHAT KIND OF ROOM WOULD YOU LIKE ?");

        jComboBoxDate = new JComboBox<>();
        jComboBoxDate.setPreferredSize(new Dimension(90, 10));
        setUpComboBoxDate(30);

        jPanelRoomTop.add(jLabelOnlist, BorderLayout.WEST);
        jPanelRoomTop.add(jComboBoxDate, BorderLayout.EAST);

        JPanel jPanelRoomButtom = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        jPanelRoomButtom.setBackground(Color.WHITE);
        jPanelRoomButtom.setMaximumSize(new Dimension(400, 350));

        // ----------------------------- SetupRoomSelection -----------------------
        panelRoominside = new JPanel();
        panelRoominside.setLayout(null);
        panelRoominside.setBackground(new Color(250, 248, 227));

        setUpRoomSelection();

        int maxHeight = 0;
        for (Component comp : panelRoominside.getComponents()) {
            Rectangle bounds = comp.getBounds();
            maxHeight = Math.max(maxHeight, bounds.y + bounds.height);
        }

        int SPEED_SCROLLBAR = 8;

        panelRoominside.setPreferredSize(new Dimension(getSize().width, maxHeight + 50));
        JScrollPane scroll = new JScrollPane(panelRoominside);
        scroll.setPreferredSize(new Dimension(400, 350));
        scroll.getVerticalScrollBar().setUnitIncrement(SPEED_SCROLLBAR);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        jPanelRoomButtom.add(scroll);
        // ----------------------------- SetupRoomSelection -----------------------

        jPanelRoom.add(jPanelRoomTop);
        jPanelRoom.add(jPanelRoomButtom);
        // -------------------------------- Panel ห้อง -----------------

        panelSecound.add(panelTop);
        panelSecound.add(panelTime);
        panelSecound.add(panelButtonSwitch);
        panelSecound.add(panelText);
        panelSecound.add(jPanelRoom);

        panelMain.add(Box.createVerticalStrut(10));
        panelMain.add(panelSecound);

        revalidate();
        repaint();
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

    private void setUpComboBoxDate(int amountDate) {
        DefaultComboBoxModel<String> modelComboBox = new DefaultComboBoxModel<>();
        for (int i = 0; i < amountDate; i++) {
            String date = "";
            if (i == 0) {
                date = "Today";
            } else {
                date = LocalDate.now().plusDays(i).toString();
            }
            modelComboBox.addElement(date);
        }
        jComboBoxDate.setModel(modelComboBox);
        jComboBoxDate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tempS = (String) jComboBoxDate.getSelectedItem();
                if (tempS.equals("Today")) {
                    date = LocalDate.now();
                } else {
                    String[] tempSplit = tempS.split("[-]");
                    date = LocalDate.of(Integer.parseInt(tempSplit[0]),
                            Integer.parseInt(tempSplit[1]), Integer.parseInt(tempSplit[2]));
                }
            }

        });
    }

    private void setUpRoomSelection() {
        int x = 20, y = 20, count = 0;
        int i = 0;
        for (Room room : system.getRooms()) {
            jLabelRoom[i] = new JLabel();
            jLabelRoom[i].setFont(FontTWCENMT.deriveFont((float) 18).deriveFont(1));
            jLabelRoom[i].setText("Room" + room.getIdRoom());
            jLabelRoom[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            jLabelAvalible[i] = new JLabel();
            jLabelAvalible[i].setFont(FontTWCENMT.deriveFont((float) 18).deriveFont(1));
            jLabelAvalible[i].setText("For : " + room.getNameRoom());
            jLabelAvalible[i].setHorizontalAlignment(SwingConstants.CENTER);
            jLabelAvalible[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            jLabelCost[i] = new JLabel();
            jLabelCost[i].setFont(FontTWCENMT.deriveFont((float) 18).deriveFont(1));
            jLabelCost[i].setText("Cost : " + room.getPrice());
            jLabelCost[i].setHorizontalAlignment(SwingConstants.CENTER);
            jLabelCost[i].setAlignmentX(Component.CENTER_ALIGNMENT);

            jButton[i] = new RoundedButton(30, 30, Color.BLACK, 4);
            jButton[i].setBackground(new Color(252, 136, 161));
            jButton[i].setPreferredSize(new Dimension(100, 50));
            jButton[i].setFont(FontTWCENMT.deriveFont((float) 18).deriveFont(1));
            jButton[i].setText("  BOOK  ");
            jButton[i].setForeground(Color.WHITE);
            jButton[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            jButton[i].putClientProperty(1,
                    new Room(room.getNameRoom(), room.getIdRoom(), room.getPrice()));
            jButton[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tempButton = (JButton) e.getSource();//
                    Room tempRoom = (Room) tempButton.getClientProperty(1);
                    // System.out.println(tempRoom);
                    if (date == null) {
                        date = LocalDate.now();
                    }
                    system.ClearRoomTimeBeforeDate(LocalDate.now());
                    listbook list = new listbook(mainframe.getUser(), tempRoom, book.this, date,
                            mainframe);
                    list.setVisible(true);
                }
            });
            jPanelBooking[i] = new RoundedPanel(30, 30, Color.black, 4);

            jPanelBooking[i].setBackground(Color.white);
            jPanelBooking[i].setLayout(new BoxLayout(jPanelBooking[i], BoxLayout.Y_AXIS));

            int tempInt = 10;
            jPanelBooking[i].setBorder(BorderFactory.createEmptyBorder(tempInt, tempInt, tempInt, tempInt));

            jPanelBooking[i].add(jLabelRoom[i]);
            jPanelBooking[i].add(jLabelAvalible[i]);
            jPanelBooking[i].add(jLabelCost[i]);

            jPanelBooking[i].add(Box.createVerticalStrut(10));
            jPanelBooking[i].add(jButton[i]);

            if ((i + 1) % 2 == 0) {
                x = 198;
            } else {
                x = 8;
            }
            if (count == 2) {
                count = 0;
                y += 140;
            }
            jPanelBooking[i].setBounds(x, y, 175, 125);
            count++;
            panelRoominside.add(jPanelBooking[i]);
            i++;
        }
    }

    private void setUpTime() {
        String tempPMAM1;
        String tempPMAM2;
        if (mainframe.getHourStart() <= 12) {
            tempPMAM1 = "A.M.";
        } else {
            tempPMAM1 = "P.M.";
        }
        if (mainframe.getHourEnd() <= 12) {
            tempPMAM2 = "A.M.";
        } else {
            tempPMAM2 = "P.M.";
        }

        if (mainframe.getMinuteStartEnd() == 0) {
            jOpen.setText("OPEN " + mainframe.getHourStart() + " : 00 " + tempPMAM1 + " - "
                    + mainframe.getHourEnd() + " : 00 " + tempPMAM2);
        } else {
            jOpen.setText("OPEN " + mainframe.getHourStart() + " : " + mainframe.getMinuteStartEnd() + " "
                    + tempPMAM1 + " - " + mainframe.getHourEnd() + " : "
                    + mainframe.getMinuteStartEnd() + " " + tempPMAM2);
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