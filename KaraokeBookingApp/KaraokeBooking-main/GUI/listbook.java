package GUI;

import javax.swing.*;

import lib.BookRoom.*;
import lib.loginregister.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.time.*;
import java.util.*;

public class listbook extends JDialog {
    @SuppressWarnings("unused")
    private Font FontITCKRIST;
    private Font FontTWCENMT;
    private DefaultListModel<RoomTime> ModelList1;
    private DefaultListModel<RoomTime> ModelList2;
    private int year, month, day;
    private int hourStart;
    private int hourEnd;
    private int minuteStartEnd;
    private User user;
    private Room room;
    private RoomSystem system;
    private LocalDate date;
    private Mainframe mainFrame;

    JList<RoomTime> jListLeft;
    JList<RoomTime> jListRight;

    private static class roomTimeListRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index,
                boolean isSelected, boolean cellHasFocus) {

            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (value instanceof RoomTime) {
                RoomTime roomTime = (RoomTime) value;

                if (roomTime.getTimeStart().getMinute() == 0) {
                    setText(roomTime.getTimeStart().getHour() + ":"
                            + roomTime.getTimeStart().getMinute() + "0 - "
                            + roomTime.getTimeEnd().getHour() + ":"
                            + roomTime.getTimeEnd().getMinute() + "0");
                } else {
                    setText(roomTime.getTimeStart().getHour() + ":"
                            + roomTime.getTimeStart().getMinute() + " - "
                            + roomTime.getTimeEnd().getHour() + ":"
                            + roomTime.getTimeEnd().getMinute());
                }
            }
            return this;
        }
    }

    public listbook(User user, Room room, JPanel j, LocalDate date, Mainframe mainFrame) {
        this.user = user;
        this.room = room;
        this.date = date;
        this.mainFrame = mainFrame;
        hourStart = mainFrame.getHourStart();
        hourEnd = mainFrame.getHourEnd();
        minuteStartEnd = mainFrame.getMinuteStartEnd();

        setUpLookAndFeel();
        setUpFont();
        setUpTime(hourStart, hourEnd);
        setModal(true);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);//
        setSize(new Dimension(465 ,355));
        setLocationRelativeTo(j);//
        initComponents();
    }

    private void initComponents() {

        JPanel panelMain = new JPanel(null);
        panelMain.setBackground(new Color(250, 243, 222));
        add(panelMain);

        JLabel LabelImageMicRight = new JLabel("");
        ImageIcon tempIcon1 = new ImageIcon("./GUI/Picture/MicLeft.png");
        Image tempImage1 = tempIcon1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        LabelImageMicRight.setIcon(new ImageIcon(tempImage1));
        LabelImageMicRight.setBounds(55, 2, 50, 50);

        JLabel jBookTime = new JLabel();
        jBookTime.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 45));
        jBookTime.setText("BOOK A TIME");
        jBookTime.setBounds((getWidth() / 2) - 140, 2, 300, 50);

        JLabel LabelImageMicLeft = new JLabel("");
        ImageIcon tempIcon2 = new ImageIcon("./GUI/Picture/MicRight.png");
        Image tempImage2 = tempIcon2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        LabelImageMicLeft.setIcon(new ImageIcon(tempImage2));
        LabelImageMicLeft.setBounds(365, 2, 50, 50);

        JPanel panelLine = new JPanel();
        panelLine.setBackground(Color.BLACK);
        panelLine.setBounds(95, 45, 263, 7);

        jListLeft = new JList<>();
        jListLeft.setBackground(new Color(255, 241, 234));
        jListLeft.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jListLeft.setBounds(30, 62, 175, 165);
        jListLeft.setModel(ModelList1);
        jListLeft.setCellRenderer(new roomTimeListRenderer());//
        JScrollPane jScrollPane1 = new JScrollPane();
        jScrollPane1.setViewportView(jListLeft);

        jListRight = new JList<>();
        jListRight.setBackground(new Color(255, 241, 234));
        jListRight.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jListRight.setModel(ModelList2);
        jListRight.setCellRenderer(new roomTimeListRenderer());//
        JScrollPane jScrollPane2 = new JScrollPane();
        jScrollPane2.setViewportView(jListRight);
        jListRight.setBounds(245, 62, 175, 165);

        JButton jButtonAdd = new JButton();
        jButtonAdd.setBackground(new Color(183, 255, 207));
        jButtonAdd.setFont(new Font("MS Gothic", 0, 18));
        jButtonAdd.setText("Add Room");
        jButtonAdd.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jButtonAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonAddRoom(evt);
            }
        });
        jButtonAdd.setBounds(25, 250, 130, 50);

        JButton jButtonRemove = new JButton();
        jButtonRemove.setBackground(new Color(255, 107, 131));
        jButtonRemove.setFont(new Font("MS Gothic", 0, 18));
        jButtonRemove.setForeground(new Color(255, 255, 255));
        jButtonRemove.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jButtonRemove.setText("Remove Room");
        jButtonRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonRemoveRoom(evt);
            }
        });
        jButtonRemove.setBounds(getWidth() / 2 - 70, 250, 130, 50);

        JButton jButtonConfirm = new JButton();
        jButtonConfirm.setBackground(new Color(205, 255, 255));
        jButtonConfirm.setFont(new Font("MS Gothic", 0, 18));
        jButtonConfirm.setText("Confirm");
        jButtonConfirm.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        jButtonConfirm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonConfirmRoom(evt);
            }
        });
        jButtonConfirm.setBounds(getWidth() / 2 + 70, 250, 130, 50);

        panelMain.add(jButtonConfirm);
        panelMain.add(jButtonRemove);
        panelMain.add(jButtonAdd);

        panelMain.add(LabelImageMicRight);
        panelMain.add(jBookTime);
        panelMain.add(LabelImageMicLeft);
        panelMain.add(panelLine);
        panelMain.add(jListLeft);
        panelMain.add(jListRight);

        revalidate();
        repaint();
    }

    private void jButtonRemoveRoom(ActionEvent evt) {
        if (jListRight.getSelectedValue() != null) {
            // System.out.println(jList2.getSelectedValue());
            ModelList1.addElement(jListRight.getSelectedValue());
            ArrayList<RoomTime> listSort = Collections.list(ModelList1.elements());
            Collections.sort(listSort, (r1, r2) -> Integer.compare(r1.getTimeStart().getHour(),
                    r2.getTimeStart().getHour()));
            ModelList1.clear();
            for (int i = 0; i < listSort.size(); i++) {
                ModelList1.addElement(listSort.get(i));
            }
            ModelList2.removeElementAt(jListRight.getSelectedIndex());
            jListRight.setModel(ModelList2);
            jListLeft.setModel(ModelList1);
        }
    }

    private void jButtonAddRoom(ActionEvent evt) {
        if (jListLeft.getSelectedValue() != null) {
            ModelList2.addElement(jListLeft.getSelectedValue());
            ArrayList<RoomTime> listSort = Collections.list(ModelList2.elements());
            Collections.sort(listSort, (r1, r2) -> Integer.compare(r1.getTimeStart().getHour(),
                    r2.getTimeStart().getHour()));
            ModelList2.clear();
            for (int i = 0; i < listSort.size(); i++) {
                ModelList2.addElement(listSort.get(i));
            }
            ModelList1.removeElementAt(jListLeft.getSelectedIndex());
            jListRight.setModel(ModelList2);
            jListLeft.setModel(ModelList1);
        }
    }

    private void jButtonConfirmRoom(ActionEvent evt) {
        ArrayList<RoomTime> tempRoomTime = new ArrayList<>();
        boolean check = false;
        double sum = 0;
        for (int i = 0; i < ModelList2.size(); i++) {
            sum += ModelList2.get(i).getRoom().getPrice();
        }

        if (mainFrame.getUser().getMoney() - sum < 0) {
            JOptionPane.showMessageDialog(this,
                    "Not enough money, missing another "
                            + (-1 * (mainFrame.getUser().getMoney() - sum)),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            mainFrame.getUser().setMoney(mainFrame.getUser().getMoney() - sum);
            mainFrame.getService().setMoneyUserInUserList(mainFrame.getUser());
            mainFrame.showPanel("book");
            for (int i = 0; i < ModelList2.size(); i++) {
                RoomTime tempModel = ModelList2.get(i);
                if (!(system.checkLocalDateTimeIsSame(tempModel.getRoom(), tempModel.getTimeStart(),
                        tempModel.getTimeEnd()))
                        && !(LocalDateTime.now().isAfter(tempModel.getTimeStart()))) {
                    tempRoomTime.add(tempModel);

                } else {
                    if (check == false) {
                        JOptionPane.showMessageDialog(this,
                                "The time matches what others have booked.",
                                "",
                                JOptionPane.ERROR_MESSAGE);
                    }
                    check = true;
                }
            }
            ModelList2.clear();

            if (check == false) {
                for (int i = 0; i < tempRoomTime.size(); i++) {
                    try {
                        system.addBookRoom(tempRoomTime.get(i).getRoom(),
                                tempRoomTime.get(i).getUser(),
                                tempRoomTime.get(i).getTimeStart(),
                                tempRoomTime.get(i).getTimeEnd());
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            } else {
                Collections.sort(tempRoomTime, (r1, r2) -> Integer.compare(r1.getTimeStart().getHour(),
                        r2.getTimeStart().getHour()));
                for (int i = 0; i < tempRoomTime.size(); i++) {
                    ModelList2.addElement(tempRoomTime.get(i));

                }
            }
            jListRight.setModel(ModelList2);
        }
    }

    public void setUpTime(int TimeStart, int TimeEnd) {
        if (TimeStart == TimeEnd) {
            throw new RuntimeException("TimeStart and TimeEnd is same");
        }
        system = new RoomSystem();
        year = date.getYear();
        month = date.getMonthValue();
        day = date.getDayOfMonth();
        ModelList1 = new DefaultListModel<>();
        ModelList2 = new DefaultListModel<>();
        int loopHour1;
        int loopHour2;
        if (hourEnd - hourStart >= 0) {
            loopHour1 = 0;
            loopHour2 = hourEnd - hourStart;
        } else {
            loopHour1 = hourEnd;
            loopHour2 = 24 - hourStart;
        }
        for (int i = 0; i < loopHour1; i++) {
            hourStart = hourStart % 24;
            if (!(system.checkLocalDateTimeIsSame(room,
                    LocalDateTime.of(year, month, day, loopHour1 + i,
                            minuteStartEnd),
                    LocalDateTime.of(year, month, day, loopHour1 + i + 1, minuteStartEnd)))
                    && LocalDateTime.now().isBefore(
                            LocalDateTime.of(year, month, day, 0 + i, minuteStartEnd))) {
                ModelList1.addElement(new RoomTime(room, user,
                        LocalDateTime.of(year, month, day, 0 + i, minuteStartEnd),
                        LocalDateTime.of(year, month, day, 0 + i + 1, minuteStartEnd)));
            }
        }
        for (int i = 0; i < loopHour2; i++) {// ปรับการจัดเวลา24:00
            int temphourStart = hourStart + i;
            int temphourStartNext = hourStart + i + 1;
            if (temphourStart + 1 == 24) {
                temphourStartNext = 0;
            }
            if (!(system.checkLocalDateTimeIsSame(room,
                    LocalDateTime.of(year, month, day, temphourStart,
                            minuteStartEnd),
                    LocalDateTime.of(year, month, day, temphourStartNext, minuteStartEnd)))
                    && LocalDateTime.now().isBefore(LocalDateTime.of(year, month, day,
                            temphourStart, minuteStartEnd))) {
                ModelList1.addElement(new RoomTime(room, user,
                        LocalDateTime.of(year, month, day, temphourStart, minuteStartEnd),
                        LocalDateTime.of(year, month, day, temphourStartNext, minuteStartEnd)));
            }
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
            java.util.logging.Logger.getLogger(listbook.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
    }
}