package GUI;

import javax.swing.*;

import GUI.Decorate.*;
import lib.loginregister.*;
import store.*;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class menudrink extends JPanel {
    private Font FontITCKRIST;
    private Font FontTWCENMT;
    private Mainframe mainframe;
    private LoginRegisterService service;

    private JPanel panelOrderIn[];
    private JButton ButtonImage[];
    private JButton ButtonOrder[];
    private JLabel jLabelNameFood[];
    private JLabel jLabelCost[];

    public menudrink(Mainframe mainframe) {
        ButtonOrder = new JButton[100];
        ButtonImage = new JButton[100];
        jLabelNameFood = new JLabel[100];
        panelOrderIn = new JPanel[100];
        jLabelCost = new JLabel[100];
        this.mainframe = mainframe;
        service = new LoginRegisterService();

        setUpFont();
        initComponents();
    }

    private void initComponents() {
        JPanel panelMain = new PanelSetImage(null, "./GUI/Picture/BGMenu.png");
        panelMain.setPreferredSize(new Dimension(440, 664));
        panelMain.setSize(new Dimension(440, 664));
        panelMain.setBackground(Color.WHITE);
        add(panelMain);

        JButton homeButton = new RoundedButton(100, 100);
        ImageIcon tempIcon2 = new ImageIcon("./GUI/Picture/IconHome.png");
        Image tempImage2 = tempIcon2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        homeButton.setIcon(new ImageIcon(tempImage2));
        homeButton.setBounds((panelMain.getWidth() / 2) - 25, 10, 45, 45);
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jButtonExitActionPerformed(e);
            }
        });

        JButton jButtonFood = new JButton();
        jButtonFood.setBackground(new Color(255, 79, 116));
        jButtonFood.setForeground(Color.WHITE);
        jButtonFood.setFont(FontTWCENMT.deriveFont((float) 28).deriveFont((int) 1)); // NOI18N
        jButtonFood.setText("FOOD");
        jButtonFood.setBounds(((panelMain.getWidth() / 2) / 2) - 87, 70, 174, 50);
        jButtonFood.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonFoodActionPerformed(evt);
            }
        });

        JButton jButtonDrink = new JButton();
        jButtonDrink.setBackground(new Color(40, 139, 201));
        jButtonDrink.setForeground(Color.WHITE);
        jButtonDrink.setFont(FontTWCENMT.deriveFont((float) 28).deriveFont((int) 1)); // NOI18N
        jButtonDrink.setText("DRINK");
        jButtonDrink.setBounds(((panelMain.getWidth() / 2) + ((panelMain.getWidth() / 2) / 2)) - 87, 70, 174, 50);
        jButtonDrink.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButtonDrinkActionPerformed(evt);
            }
        });

        JPanel panelMenuFood = new RoundedPanel(40, 40);
        panelMenuFood.setLayout(null);
        panelMenuFood.setBackground(Color.BLACK);
        panelMenuFood.setBounds(35, 130, 370, 475);

        JLabel jLabelMenuDrink = new JLabel();
        jLabelMenuDrink.setForeground(Color.WHITE);
        jLabelMenuDrink.setFont(FontTWCENMT.deriveFont((float) 35).deriveFont((int) 1)); // NOI18N
        jLabelMenuDrink.setText("MENU FOOD");
        jLabelMenuDrink.setBounds(90, 2, 300, 50);

        JPanel panelOrder = new RoundedPanel(30, 30);
        panelOrder.setLayout(null);
        panelOrder.setBackground(Color.WHITE);
        panelOrder.setBounds(10, 50, 350, 415);

        // ----------------------------- SetupRoom --------------------------------
        int x = 20, y = 20, count = 0, i = 0;
        for (Product product : mainframe.getCatalog().getAllProducts()) {
            if (product.getProductId().charAt(0) == 'D') {

                panelOrderIn[i] = new RoundedPanel(30, 30, Color.black, 6);
                panelOrderIn[i].setLayout(null);

                ButtonImage[i] = new JButton();
                ButtonImage[i].setBounds(10, 10, 125, 90);
                ImageIcon tempIcon = new ImageIcon(
                        getClass().getResource("/GUI/Picture/Drink/" + product.getProductId() + ".jpg"));
                Image img = tempIcon.getImage().getScaledInstance(ButtonImage[i].getSize().width,
                        ButtonImage[i].getSize().height,
                        Image.SCALE_SMOOTH);
                ButtonImage[i].setIcon(new ImageIcon(img));
                
                jLabelCost[i] = new JLabel("Cost : " + product.getPrice());
                jLabelCost[i].setFont(FontTWCENMT.deriveFont((float) 14).deriveFont(1));
                jLabelCost[i].setBounds(10, 100, 100, 70);
                
                jLabelNameFood[i] = new JLabel(product.getProductName());
                jLabelNameFood[i].setFont(FontTWCENMT.deriveFont((float) 14).deriveFont(1));
                jLabelNameFood[i].setBounds(10, 80, 100, 70);

                ButtonOrder[i] = new RoundedButton(30, 30, Color.BLACK, 4);
                ButtonOrder[i].setBackground(new Color(97, 255, 152));
                ImageIcon tempIcon3 = new ImageIcon("./GUI/Picture/IconOrder.png");
                Image tempImage3 = tempIcon3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
                ButtonOrder[i].setIcon(new ImageIcon(tempImage3));
                ButtonOrder[i].setFont(FontTWCENMT.deriveFont((float) 12).deriveFont(1));
                ButtonOrder[i].setBounds(100, 107, 38, 38);

                panelOrderIn[i].add(ButtonOrder[i]);
                panelOrderIn[i].add(jLabelNameFood[i]);
                panelOrderIn[i].add(jLabelCost[i]);
                panelOrderIn[i].add(ButtonImage[i]);

                if ((i + 1) % 2 == 0) {
                    x = 175;
                } else {
                    x = 15;
                }
                if (count == 2) {
                    count = 0;
                    y += 170;
                }
                panelOrderIn[i].setBounds(x, y, 145, 150);
                count++;
                panelOrder.add(panelOrderIn[i]);
                i++;
            }
        }
        int maxHeight = 0;
        for (Component comp : panelOrder.getComponents()) {
            Rectangle bounds = comp.getBounds();
            maxHeight = Math.max(maxHeight, bounds.y + bounds.height);
        }
        panelOrder.setPreferredSize(new Dimension(getSize().width, maxHeight + 50));
        JScrollPane scroll = new JScrollPane(panelOrder);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.getVerticalScrollBar().setUnitIncrement(8);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        scroll.setBounds(10, 50, 350, 415);
        scroll.setBackground(Color.BLACK);
        panelMenuFood.add(scroll);
        // ----------------------------- SetupRoom --------------------------------

        panelMenuFood.add(jLabelMenuDrink);

        panelMain.add(panelMenuFood);
        panelMain.add(jButtonDrink);
        panelMain.add(jButtonFood);
        panelMain.add(homeButton);

        revalidate();
        repaint();
    }

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
}

class PanelSetImage extends JPanel {
    private Image backgroundImage;

    public PanelSetImage(LayoutManager layout, String fileName) {
        setLayout(layout);
        backgroundImage = new ImageIcon(fileName).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }
}
