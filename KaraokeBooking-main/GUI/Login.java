package GUI;

import javax.swing.*;
import lib.loginregister.LoginRegisterService;
import lib.loginregister.User;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Login extends JPanel{
    private Mainframe mainframe;

    private Font FontITCKRIST;
    private Font FontTWCENMT;
    private LoginRegisterService loginService;

    private JPanel panelMain;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;

    private JPanel panelLineLeft;
    private JPanel panelLineRight;

    private JLabel jPassOrNameWrong;
    private JLabel jLabelUserName;
    private JLabel jLabelPassWord;
    private JLabel LabelImageK2;
    private JLabel labelLoginTop;
    private JLabel labelImg;

    JPasswordField pass;
    JTextField user;

    public Login(Mainframe mainframe) {
        loginService = new LoginRegisterService();
        this.mainframe = mainframe;
        setUpFont();
        initComponents();
    }

    private void initComponents() {
        panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));

        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();

        add(panelMain);
        panel1.setBackground(Color.WHITE);
        panel2.setBackground(Color.WHITE);
        panel3.setBackground(Color.WHITE);

        panel1.setPreferredSize(new Dimension(440, 125));
        panel2.setPreferredSize(new Dimension(440, 60));
        panel3.setPreferredSize(new Dimension(440, 440));
        panel3.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        panelMain.add(panel1);
        panelMain.add(panel2);
        panelMain.add(panel3);

        // --------------------------------- panelบน ---------------------------------
        panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        labelImg = new JLabel();
        ImageIcon tempIcon = new ImageIcon("./GUI/Picture/Logo.png");
        Image tempImage = tempIcon.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH);
        labelImg.setIcon(new ImageIcon(tempImage));

        panel1.add(labelImg);
        // --------------------------------- panelบน ---------------------------------

        // --------------------------------- panelกลาง ---------------------------------
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelLineLeft = new JPanel();
        panelLineLeft.setPreferredSize(new Dimension(113, 5));
        panelLineLeft.setBackground(new Color(0, 57, 134));

        labelLoginTop = new JLabel();
        labelLoginTop.setFont(new Font("Serif", 1, 48));
        labelLoginTop.setForeground(new Color(0, 57, 134));
        labelLoginTop.setText("LOGIN");

        panelLineRight = new JPanel();
        panelLineRight.setPreferredSize(new Dimension(113, 5));
        panelLineRight.setBackground(new Color(0, 57, 134));

        panelLineLeft.setAlignmentY(CENTER_ALIGNMENT);
        panel2.add(panelLineLeft);
        panel2.add(labelLoginTop);
        panel2.add(panelLineRight);

        // --------------------------------- panelกลาง ---------------------------------

        // --------------------------------- panelล่าง ---------------------------------
        panel3.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel panelIn3 = new JPanel();
        panelIn3.setLayout(new BoxLayout(panelIn3, BoxLayout.Y_AXIS));
        panelIn3.setBackground(Color.WHITE);
        panelIn3.setPreferredSize(new Dimension(350, 410));

        LabelImageK2 = new JLabel("");
        LabelImageK2.setSize(new Dimension(70, 70));
        ImageIcon tempIcon1 = new ImageIcon(getClass().getResource("/GUI/Picture/k2.png"));
        Image img = tempIcon1.getImage().getScaledInstance(LabelImageK2.getSize().width, LabelImageK2.getSize().height,
                Image.SCALE_SMOOTH);
        LabelImageK2.setIcon(new ImageIcon(img));
        LabelImageK2.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel panelUserName = new JPanel(null);
        panelUserName.setBackground(Color.WHITE);
        //panelUserName.setOpaque(false);
        panelUserName.setPreferredSize(new Dimension(440, 600));
        panelUserName.setAlignmentX(Component.CENTER_ALIGNMENT);

        jLabelUserName = new JLabel();
        jLabelUserName.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 18));
        jLabelUserName.setText("USERNAME");
        jLabelUserName.setBounds(0, 10, 100, 30);

        user = new JTextField();
        user.setBounds(0, 40, 350, 40);
        user.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == ' ')
                    e.consume();
                else if (user.getText().length() >= 45) {
                    e.consume();
                }
            }
        });

        panelUserName.add(jLabelUserName);
        panelUserName.add(user);

        JPanel panelPassword = new JPanel(null);
        panelPassword.setBackground(Color.WHITE);
        panelPassword.setPreferredSize(new Dimension(440, 600));
        panelPassword.setAlignmentX(Component.CENTER_ALIGNMENT);

        jLabelPassWord = new JLabel();
        jLabelPassWord.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 18));
        jLabelPassWord.setText("PASSWORD");
        jLabelPassWord.setBounds(0, 0, 100, 30);
        
        pass = new JPasswordField();
        pass.setBounds(0, 30, 350, 40);
        pass.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (String.valueOf(pass.getPassword()).length() > 60) {
                    e.consume();
                }
            }
        });

        jPassOrNameWrong = new JLabel();
        jPassOrNameWrong.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 14));
        jPassOrNameWrong.setForeground(new Color(255, 51, 0));
        jPassOrNameWrong.setText("");
        jPassOrNameWrong.setBounds(3, 55, 350, 40);

        panelPassword.add(jLabelPassWord);
        panelPassword.add(pass);
        panelPassword.add(jPassOrNameWrong);

        JPanel panelButtonLogin = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelButtonLogin.setBackground(Color.WHITE);
        panelButtonLogin.setPreferredSize(new Dimension(440, 100));
        panelButtonLogin.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton jButtonLogin = new JButton();
        jButtonLogin.setBackground(new Color(0, 57, 134));
        jButtonLogin.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 24));
        jButtonLogin.setForeground(new Color(255, 255, 255));
        jButtonLogin.setText("LOGIN");
        jButtonLogin.setPreferredSize(new Dimension(350, 45));
        jButtonLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        panelButtonLogin.add(jButtonLogin);

        JPanel panelBottomIn3 = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        panelBottomIn3.setBackground(Color.WHITE);
        panelBottomIn3.setPreferredSize(new Dimension(440, 200));
        panelBottomIn3.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton jButtonSignUp = new JButton();
        jButtonSignUp.setBackground(new Color(0, 57, 134));
        jButtonSignUp.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 22));
        jButtonSignUp.setForeground(new Color(255, 255, 255));
        jButtonSignUp.setText("SIGN UP");
        jButtonSignUp.setBorderPainted(false);
        jButtonSignUp.setPreferredSize(new Dimension(150, 45));
        jButtonSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                signUpActionPerformed(evt);
            }
        });

        panelBottomIn3.add(jButtonSignUp);

        panelIn3.add(Box.createVerticalStrut(40));
        panelIn3.add(LabelImageK2);
        panelIn3.add(Box.createVerticalStrut(10));
        panelIn3.add(panelUserName);
        panelIn3.add(panelPassword);
        panelIn3.add(Box.createVerticalStrut(10));
        panelIn3.add(panelButtonLogin);
        panelIn3.add(panelBottomIn3);

        panel3.add(panelIn3);

        panelMain.revalidate();
        panelMain.repaint();

        // --------------------------------- panelล่าง ---------------------------------
    }

    private void signUpActionPerformed(ActionEvent evt) {
        removeTextInTextField();
        mainframe.showPanel("signup");
    }

    private void loginActionPerformed(ActionEvent evt) {
        boolean check = false;
        try {
            handleLogin();
        } catch (Exception e) {
            check = true;
        }
        if (check == false) {
            String[] tempStr = loginService.getValueUserList(user.getText(), String.valueOf(pass.getPassword()));
            int idUser = Integer.parseInt(tempStr[0]);
            String username = tempStr[1];
            String password = tempStr[2];
            String phone = tempStr[3];
            double money = Double.parseDouble(tempStr[4]);

            User tempUser = new User(username, password, phone);

            tempUser.setMoney(money);// ตั้งค่าเงินของผู้ใช้
            
            mainframe.setUserId(idUser);
            tempUser.setUserId(idUser);

            mainframe.setUser(tempUser);// ตั้งว่าผู้ใช้คือใคร

            if (user.getText().equals("admin")) {
                removeTextInTextField();
                mainframe.showPanel("admin_Book");
            } else {
                removeTextInTextField();
                mainframe.showPanel("book");
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

    private void handleLogin() throws Exception {
        String username = user.getText();
        String password = String.valueOf(pass.getPassword());

        // เชื่อมกับ LoginService
        if (!(loginService.checkUseramePassword(username, password))) {

            jPassOrNameWrong.setForeground(Color.RED);
            jPassOrNameWrong.setText("X Invalid Username or Password");
            throw new Exception("Invalid password");
        }
    }

    private void removeTextInTextField() {
        user.setText("");
        pass.setText("");
        jPassOrNameWrong.setText("");
    }

}
