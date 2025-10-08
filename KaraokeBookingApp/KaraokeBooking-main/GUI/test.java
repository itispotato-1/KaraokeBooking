package GUI;

import javax.swing.*;

import GUI.Decorate.*;
import lib.BookRoom.*;
import lib.loginregister.*;
import lib.loginregister.Passwordvalidation.PasswordStrength;
import lib.loginregister.Passwordvalidation.PasswordValidator;
import store.Product;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;

public class test extends JPanel {
    private Font FontITCKRIST;
    private Font FontTWCENMT;
    private Mainframe mainframe;
    private LoginRegisterService loginService;

    private JPasswordField passwordField;
    private JTextField usernameField;
    private JTextField phoneNumberField;
    private JPasswordField textFieldConfirm;

    private JLabel jLabelInvalidUser;
    private JLabel jLabelInvalidPhone;
    private JLabel jLabelInvalidPassword;
    private JLabel jLabelInvalidConfirm;

    public test(Mainframe mainframe) {
        this.mainframe = mainframe;
        loginService = new LoginRegisterService();
        setUpFont();
        initComponents();
    }

    private void initComponents() {

        JPanel panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.setPreferredSize(new Dimension(440, 664));
        panelMain.setSize(new Dimension(440, 664));
        panelMain.setBackground(Color.WHITE);
        add(panelMain);

        JPanel panelImg = new JPanel(new FlowLayout());
        panelImg.setPreferredSize(new Dimension(100, 100));
        panelImg.setMaximumSize(new Dimension(100, 100));
        panelImg.setBackground(Color.GRAY);
        panelImg.setOpaque(false);

        JLabel jLabelImg = new JLabel();
        ImageIcon tempIcon = new ImageIcon("./GUI/Picture/Logo.png");
        Image tempImage = tempIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        jLabelImg.setIcon(new ImageIcon(tempImage));
        // jLabelImg.setBounds(0, 0, 100, 100);

        panelImg.add(jLabelImg);

        JPanel panelSign = new JPanel();
        panelSign.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelSign.setPreferredSize(new Dimension(100, 60));
        panelSign.setMaximumSize(new Dimension(440, 80));
        panelSign.setBackground(Color.ORANGE);
        panelSign.setOpaque(false);

        JPanel panelLine = new JPanel();
        panelLine.setPreferredSize(new Dimension(125, 10));
        panelLine.setBackground(new Color(0, 57, 134));

        JPanel panelLinetwo = new JPanel();
        panelLinetwo.setPreferredSize(new Dimension(125, 10));
        panelLinetwo.setBackground(new Color(0, 57, 134));

        JLabel labelSingup = new JLabel();
        labelSingup.setText("SignUp");
        labelSingup.setFont(new Font("Serif", 1, 48));

        panelSign.add(panelLine);
        panelSign.add(labelSingup);
        panelSign.add(panelLinetwo);

        JPanel panelMix = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelMix.setPreferredSize(new Dimension(350, 300));
        panelMix.setMaximumSize(new Dimension(350, 300));
        panelMix.setBackground(Color.RED);

        JPanel panelMixIn = new JPanel();
        panelMixIn.setLayout(new BoxLayout(panelMixIn, BoxLayout.Y_AXIS));
        panelMixIn.setPreferredSize(new Dimension(350, 300));
        panelMixIn.setMaximumSize(new Dimension(350, 300));
        // panelMix.setMinimumSize(new Dimension(350, 300));
        panelMixIn.setBackground(Color.WHITE);

        panelMix.add(panelMixIn);

        JPanel panelUser = new JPanel(null);
        panelUser.setPreferredSize(new Dimension(250, 70));
        panelUser.setMinimumSize(new Dimension(350, 70));
        panelUser.setMaximumSize(new Dimension(350, 70));
        panelUser.setBackground(Color.WHITE);
        panelUser.setOpaque(false);

        JLabel jLabelUserName = new JLabel();
        jLabelUserName.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 18));
        jLabelUserName.setText("USERNAME");
        jLabelUserName.setBounds(4, -4, 100, 30);

        usernameField = new JTextField();
        usernameField.setBounds(0, 20, 349, 35);
        usernameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == ' ')
                    e.consume();
                else if (usernameField.getText().length() >= 45) {
                    e.consume();
                }
            }
        });

        jLabelInvalidUser = new JLabel();
        jLabelInvalidUser.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 15));
        jLabelInvalidUser.setText("");
        jLabelInvalidUser.setBounds(4, 45, 300, 30);
        jLabelInvalidUser.setForeground(Color.RED);

        panelUser.add(jLabelUserName);
        panelUser.add(usernameField);
        panelUser.add(jLabelInvalidUser);

        JPanel panelPhone = new JPanel(null);
        panelPhone.setPreferredSize(new Dimension(250, 70));
        panelPhone.setMinimumSize(new Dimension(350, 70));
        panelPhone.setMaximumSize(new Dimension(350, 70));
        panelPhone.setBackground(Color.WHITE);
        panelPhone.setOpaque(false);

        JLabel jLabelPhone = new JLabel();
        jLabelPhone.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 18));
        jLabelPhone.setText("PHONE NUMBER");
        jLabelPhone.setBounds(4, -4, 150, 30);

        phoneNumberField = new JTextField();
        phoneNumberField.setBounds(0, 20, 349, 35);
        phoneNumberField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (Character.isAlphabetic(e.getKeyChar()))
                    e.consume();
                else if (phoneNumberField.getText().length() >= 45) {
                    e.consume();
                }
            }
        });

        jLabelInvalidPhone = new JLabel();
        jLabelInvalidPhone.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 15));
        jLabelInvalidPhone.setText("");
        jLabelInvalidPhone.setBounds(4, 45, 300, 30);
        jLabelInvalidPhone.setForeground(Color.RED);

        panelPhone.add(jLabelPhone);
        panelPhone.add(phoneNumberField);
        panelPhone.add(jLabelInvalidPhone);

        JPanel panelPassword = new JPanel(null);
        panelPassword.setPreferredSize(new Dimension(250, 70));
        panelPassword.setMinimumSize(new Dimension(350, 70));
        panelPassword.setMaximumSize(new Dimension(350, 70));
        panelPassword.setBackground(Color.WHITE);
        panelPassword.setOpaque(false);

        JLabel jLabelPass = new JLabel();
        jLabelPass.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 18));
        jLabelPass.setText("PASSWORD");
        jLabelPass.setBounds(4, -4, 100, 30);

        passwordField = new JPasswordField();
        passwordField.setBounds(0, 20, 349, 35);
        passwordField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (String.valueOf(passwordField.getPassword()).length() > 60) {
                    e.consume();
                }
            }
        });

        jLabelInvalidPassword = new JLabel();
        jLabelInvalidPassword.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 15));
        jLabelInvalidPassword.setText("");
        jLabelInvalidPassword.setBounds(4, 45, 300, 30);
        jLabelInvalidPassword.setForeground(Color.RED);

        panelPassword.add(jLabelPass);
        panelPassword.add(passwordField);
        panelPassword.add(jLabelInvalidPassword);

        JPanel panelConfirm = new JPanel(null);
        panelConfirm.setPreferredSize(new Dimension(200, 70));
        panelConfirm.setMinimumSize(new Dimension(350, 70));
        panelConfirm.setMaximumSize(new Dimension(350, 70));
        panelConfirm.setBackground(Color.WHITE);
        panelConfirm.setOpaque(false);

        JLabel jLabelPassConfirm = new JLabel();
        jLabelPassConfirm.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 18));
        jLabelPassConfirm.setText("PASSWORD CONFIRM");
        jLabelPassConfirm.setBounds(4, -4, 300, 30);

        textFieldConfirm = new JPasswordField();
        textFieldConfirm.setBounds(0, 20, 349, 35);
        textFieldConfirm.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (String.valueOf(textFieldConfirm.getPassword()).length() > 60) {
                    e.consume();
                }
            }
        });

        jLabelInvalidConfirm = new JLabel();
        jLabelInvalidConfirm.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 15));
        jLabelInvalidConfirm.setText("");
        jLabelInvalidConfirm.setBounds(4, 45, 200, 30);
        jLabelInvalidConfirm.setForeground(Color.RED);

        panelConfirm.add(jLabelPassConfirm);
        panelConfirm.add(textFieldConfirm);
        panelConfirm.add(jLabelInvalidConfirm);

        panelMixIn.add(Box.createVerticalStrut(10));
        panelMixIn.add(panelUser);
        panelMixIn.add(panelPhone);
        panelMixIn.add(panelPassword);
        panelMixIn.add(panelConfirm);
        panelMixIn.add(Box.createVerticalStrut(10));

        JPanel panelCsignup = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        panelCsignup.setPreferredSize(new Dimension(80, 30));
        panelCsignup.setMaximumSize(new Dimension(350, 50));
        panelCsignup.setBackground(Color.MAGENTA);
        panelCsignup.setOpaque(false);

        JButton ButtonCsing2 = new JButton();
        ButtonCsing2.setBackground(new Color(0, 57, 134));
        ButtonCsing2.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 24));
        ButtonCsing2.setForeground(new Color(255, 255, 255));
        ButtonCsing2.setPreferredSize(new Dimension(350, 45));
        ButtonCsing2.setText("SIGN UP");
        ButtonCsing2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SignUpActionPerformed(e);
            }
        });

        panelCsignup.add(ButtonCsing2);

        JPanel panelLogin = new JPanel(new FlowLayout(FlowLayout.RIGHT, 0, 0));
        panelLogin.setPreferredSize(new Dimension(100, 60));
        panelLogin.setMaximumSize(new Dimension(345, 100));
        panelLogin.setBackground(Color.PINK);
        panelLogin.setOpaque(false);

        JButton ButtonLogin2 = new JButton();
        ButtonLogin2.setBackground(new Color(0, 57, 134));
        ButtonLogin2.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 24));
        ButtonLogin2.setForeground(new Color(255, 255, 255));
        ButtonLogin2.setPreferredSize(new Dimension(150, 45));
        ButtonLogin2.setText("LOGIN");
        ButtonLogin2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginActionPerformed(e);
            }

        });

        panelLogin.add(ButtonLogin2);

        panelMain.add(Box.createVerticalStrut(13));
        panelMain.add(panelImg);
        panelMain.add(Box.createVerticalStrut(13));
        panelMain.add(panelSign);
        panelMain.add(panelMix);
        panelMain.add(panelCsignup);
        panelMain.add(panelLogin);

        revalidate();
        repaint();
    }

    private void LoginActionPerformed(ActionEvent evt) {
        mainframe.showPanel("login");
        removeAllTextInTextField();
    }

    private void SignUpActionPerformed(ActionEvent evt) {
        boolean check = false;
        try {
            handleRegistration();
        } catch (Exception e) {
            check = true;
        }
        if (check == false) {
            mainframe.showPanel("login");
            removeAllTextInTextField();
        }

    }

    private void removeAllTextInTextField() {
        passwordField.setText("");
        usernameField.setText("");
        phoneNumberField.setText("");
        textFieldConfirm.setText("");
    }

    private void removeAllInvalid() {
        jLabelInvalidUser.setText("");
        jLabelInvalidPassword.setText("");
        jLabelInvalidPhone.setText("");
        jLabelInvalidConfirm.setText("");
    }

    private void handleRegistration() throws Exception {
        removeAllInvalid();
        String username = usernameField.getText().trim();
        String password = String.valueOf(passwordField.getPassword());
        String phoneNumber = phoneNumberField.getText().trim();
        String confirm = String.valueOf(textFieldConfirm.getPassword());

        if (username.isEmpty() || password.isEmpty() || phoneNumber.isEmpty() || confirm.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error",
                    JOptionPane.ERROR_MESSAGE);
            throw new Exception("Please fill in all fields");
        }

        // ตรวจสอบความแข็งแรงของรหัสผ่าน
        PasswordStrength strength = PasswordValidator.validate(password);

        if (phoneNumber.length() != 10) {
            jLabelInvalidPhone.setText("Phone numbers must contain 10 characters.");
            throw new Exception("Invalid phone number");
        }

        if (strength == PasswordStrength.INVALID) {
            jLabelInvalidPassword.setText("password didn't has atleast 8 characters");
            throw new Exception("password didn't has atleast 8 characters");
        } else if (strength == PasswordStrength.WEAK) {
            jLabelInvalidPassword
                    .setText("your password is too WEAK. Please use a number or a uppercase letter or both");
            throw new Exception(
                    " your password is too weak. Please use a number or a uppercase letter or both");
        } else if (strength == PasswordStrength.MEDIUM) {
            jLabelInvalidPassword.setText("your password is MEDIUM. Please use a number or a uppercase letter or both");
            throw new Exception(
                    " your password is MEDIUM. Please use a number or a uppercase letter or both");
        }

        boolean success = false;
        // ถ้ารหัสผ่านดีพอ
        if (password.equals(confirm)) {
            success = loginService.registerAccount(username, password, phoneNumber);
        } else {
            jLabelInvalidConfirm.setText("Invalid PasswordConfirm");
            throw new Exception("Password not equal PasswordConfirm");
        }

        if (success) {
            JOptionPane.showMessageDialog(this,
                    "Register secceeded!\n\nUsername: " + username + "\nPhone: " + phoneNumber,
                    "Success",
                    JOptionPane.INFORMATION_MESSAGE);

            // this.dispose();
        } else {
            jLabelInvalidUser.setText("Username has already been used");
            throw new Exception("Username has already been used, please try another one");
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
}