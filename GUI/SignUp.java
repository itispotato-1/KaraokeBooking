package GUI;

import javax.swing.*;

import lib.loginregister.LoginRegisterService;
import lib.loginregister.Passwordvalidation.PasswordStrength;
import lib.loginregister.Passwordvalidation.PasswordValidator;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class SignUp extends JPanel {
        private Mainframe mainframe;
        private Font FontITCKRIST;
        private Font FontTWCENMT;
        private LoginRegisterService loginService;

        public SignUp(Mainframe mainframe) {
                this.mainframe = mainframe;
                loginService = new LoginRegisterService();
                setUpFont();
                setUpLookAndFeel();
                initComponents();
        }

        private void initComponents() {

                jPanel2 = new JPanel();
                jPanel3 = new JPanel();
                jPanel4 = new JPanel();
                jPanel6 = new JPanel();
                jPanel7 = new JPanel();
                jPasswordField1 = new JPasswordField();
                jPanelMain = new JPanel();
                jLabelImg = new JLabel();
                jPanel5 = new JPanel();
                jPanel8 = new JPanel();
                jLabelSignUp = new JLabel();
                jLabel1 = new JLabel();
                jPanel10 = new JPanel();
                passwordField = new JTextField();
                usernameField = new JTextField();
                phoneNumberField = new JTextField();
                jButtonSignUp = new JButton();
                jLabelUserName = new JLabel();
                jLabelPhone = new JLabel();
                jLabelPassword = new JLabel();
                jLabelInvaild1 = new JLabel();
                jLabelInvaild2 = new JLabel();
                jLabelInvaild3 = new JLabel();
                jButton2 = new JButton();

                add(jPanelMain);

                jPanel2.setBackground(new Color(0, 57, 134));
                jPanel2.setPreferredSize(new Dimension(132, 11));

                jPanel3.setBackground(new Color(0, 57, 134));
                jPanel3.setPreferredSize(new Dimension(132, 11));

                jPanel4.setBackground(new Color(0, 57, 134));
                jPanel4.setPreferredSize(new Dimension(132, 11));

                GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 138, Short.MAX_VALUE));
                jPanel4Layout.setVerticalGroup(
                                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 11, Short.MAX_VALUE));

                GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
                jPanel3.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 138, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout
                                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(jPanel4,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                138,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 11, Short.MAX_VALUE)
                                                .addGroup(jPanel3Layout
                                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(jPanel4,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))));

                GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
                jPanel2.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 138, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout
                                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(jPanel3,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                138,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 11, Short.MAX_VALUE)
                                                .addGroup(jPanel2Layout
                                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel2Layout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(jPanel3,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))));

                jPanel6.setBackground(new Color(0, 57, 134));
                jPanel6.setPreferredSize(new Dimension(132, 11));

                jPanel7.setBackground(new Color(0, 57, 134));
                jPanel7.setPreferredSize(new Dimension(132, 11));

                GroupLayout jPanel7Layout = new GroupLayout(jPanel7);
                jPanel7.setLayout(jPanel7Layout);
                jPanel7Layout.setHorizontalGroup(
                                jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 138, Short.MAX_VALUE));
                jPanel7Layout.setVerticalGroup(
                                jPanel7Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 11, Short.MAX_VALUE));

                GroupLayout jPanel6Layout = new GroupLayout(jPanel6);
                jPanel6.setLayout(jPanel6Layout);
                jPanel6Layout.setHorizontalGroup(
                                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 138, Short.MAX_VALUE)
                                                .addGroup(jPanel6Layout
                                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel6Layout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(jPanel7,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))));
                jPanel6Layout.setVerticalGroup(
                                jPanel6Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 11, Short.MAX_VALUE)
                                                .addGroup(jPanel6Layout
                                                                .createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                .addGroup(jPanel6Layout.createSequentialGroup()
                                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                                .addComponent(jPanel7,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGap(0, 0, Short.MAX_VALUE))));

                jPasswordField1.setText("jPasswordField1");

                jPanelMain.setBackground(new Color(235, 240, 255));
                jPanelMain.setPreferredSize(new Dimension(440, 664));

                ImageIcon tempIcon = new ImageIcon("./GUI/Picture/Logo.png");
                Image tempImage = tempIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                jLabelImg.setIcon(new ImageIcon(tempImage)); // NOI18N

                jPanel5.setBackground(new Color(0, 57, 134));
                jPanel5.setPreferredSize(new Dimension(132, 11));

                GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
                jPanel5.setLayout(jPanel5Layout);
                jPanel5Layout.setHorizontalGroup(
                                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 89, Short.MAX_VALUE));
                jPanel5Layout.setVerticalGroup(
                                jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 12, Short.MAX_VALUE));

                jPanel8.setBackground(new Color(0, 57, 134));
                jPanel8.setPreferredSize(new Dimension(132, 11));

                GroupLayout jPanel8Layout = new GroupLayout(jPanel8);
                jPanel8.setLayout(jPanel8Layout);
                jPanel8Layout.setHorizontalGroup(
                                jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 80, Short.MAX_VALUE));
                jPanel8Layout.setVerticalGroup(
                                jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 11, Short.MAX_VALUE));

                jLabelSignUp.setFont(new Font("Serif", 1, 48)); // NOI18N
                jLabelSignUp.setForeground(new Color(0, 57, 134));
                jLabelSignUp.setText("SIGN UP");

                jPanel10.setBackground(new Color(255, 255, 255));

                usernameField.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                jTextField2ActionPerformed(evt);
                        }
                });

                phoneNumberField.setToolTipText("");

                jButtonSignUp.setBackground(new Color(0, 57, 134));
                jButtonSignUp.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 24)); // NOI18N
                jButtonSignUp.setForeground(new Color(255, 255, 255));
                jButtonSignUp.setText("SIGN UP");
                jButtonSignUp.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                                SignUpActionPerformed(e);
                        }

                });

                jLabelUserName.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 18)); // NOI18N
                jLabelUserName.setText("USERNAME");

                jLabelPhone.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 18)); // NOI18N
                jLabelPhone.setText("PHONE NUMBER");

                jLabelPassword.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 18)); // NOI18N
                jLabelPassword.setText("PASSWORD");

                jLabelInvaild1.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 14)); // NOI18N
                jLabelInvaild1.setForeground(new Color(255, 51, 0));
                jLabelInvaild1.setText("Invaild");

                jLabelInvaild2.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 14)); // NOI18N
                jLabelInvaild2.setForeground(new Color(255, 51, 0));
                jLabelInvaild2.setText("Invaild");

                jLabelInvaild3.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 14)); // NOI18N
                jLabelInvaild3.setForeground(new Color(255, 51, 0));
                jLabelInvaild3.setText("Invaild");

                GroupLayout jPanel10Layout = new GroupLayout(jPanel10);
                jPanel10.setLayout(jPanel10Layout);
                jPanel10Layout.setHorizontalGroup(
                                jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel10Layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel10Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jLabelInvaild1,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                67,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(jPanel10Layout
                                                                                                .createParallelGroup(
                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addComponent(jButtonSignUp,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(passwordField)
                                                                                                .addComponent(jLabelPassword)
                                                                                                .addGroup(jPanel10Layout
                                                                                                                .createSequentialGroup()
                                                                                                                .addGap(3, 3, 3)
                                                                                                                .addGroup(jPanel10Layout
                                                                                                                                .createParallelGroup(
                                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                                .addComponent(jLabelInvaild2)
                                                                                                                                .addGroup(jPanel10Layout
                                                                                                                                                .createParallelGroup(
                                                                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                                                                false)
                                                                                                                                                .addComponent(jLabelUserName)
                                                                                                                                                .addComponent(jLabelPhone)
                                                                                                                                                .addComponent(usernameField,
                                                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                314,
                                                                                                                                                                Short.MAX_VALUE)
                                                                                                                                                .addComponent(phoneNumberField))
                                                                                                                                .addGroup(jPanel10Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGap(6, 6, 6)
                                                                                                                                                .addComponent(jLabelInvaild3))))))
                                                                .addContainerGap(14, Short.MAX_VALUE)));
                jPanel10Layout.setVerticalGroup(
                                jPanel10Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel10Layout
                                                                .createSequentialGroup()
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addComponent(jLabelUserName,
                                                                                GroupLayout.PREFERRED_SIZE, 33,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(usernameField, GroupLayout.PREFERRED_SIZE,
                                                                                38, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(4, 4, 4)
                                                                .addComponent(jLabelInvaild3)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabelPhone, GroupLayout.PREFERRED_SIZE,
                                                                                23, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(phoneNumberField,
                                                                                GroupLayout.PREFERRED_SIZE, 38,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(2, 2, 2)
                                                                .addComponent(jLabelInvaild2)
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabelPassword)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(passwordField, GroupLayout.PREFERRED_SIZE,
                                                                                40, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(1, 1, 1)
                                                                .addComponent(jLabelInvaild1)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jButtonSignUp)
                                                                .addGap(18, 18, 18)));

                jButton2.setBackground(new Color(0, 57, 134));
                jButton2.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 24)); // NOI18N
                jButton2.setForeground(new Color(255, 255, 255));
                jButton2.setText("LOGIN");
                jButton2.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                LoginActionPerformed(evt);
                        }
                });

                GroupLayout jPanel1Layout = new GroupLayout(jPanelMain);
                jPanelMain.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(GroupLayout.Alignment.TRAILING,
                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                .addGap(15)
                                                                                                                .addGroup(
                                                                                                                                jPanel1Layout.createParallelGroup(
                                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                                                .addGroup(GroupLayout.Alignment.TRAILING,
                                                                                                                                                                jPanel1Layout.createSequentialGroup()
                                                                                                                                                                                .addComponent(jLabel1)
                                                                                                                                                                                .addGap(41, 41, 41))
                                                                                                                                                .addComponent(jPanel8,
                                                                                                                                                                GroupLayout.Alignment.TRAILING,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                80,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                                                .addPreferredGap(
                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jLabelSignUp)
                                                                                                                .addPreferredGap(
                                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                                .addComponent(jPanel5,
                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                89,
                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                .addGap(119, 119,
                                                                                                                                119))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(126, 126, 126)
                                                                                                .addComponent(jLabelImg,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                140,
                                                                                                                GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(40)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jButton2,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                129,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jPanel10,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(139, 139, 139)
                                                                                                .addComponent(jPanel8,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jLabel1))
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabelImg,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                101,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.LEADING)
                                                                                                                .addComponent(jLabelSignUp)
                                                                                                                .addGroup(GroupLayout.Alignment.TRAILING,
                                                                                                                                jPanel1Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addComponent(jPanel5,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                12,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addGap(18, 18, 18)))))
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jPanel10, GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                // .addGap(30, 30, 30)
                                                                .addComponent(jButton2)
                                                                .addContainerGap(73, Short.MAX_VALUE)));
        }

        private void jTextField2ActionPerformed(ActionEvent evt) {

        }

        private void LoginActionPerformed(ActionEvent evt) {
                mainframe.showPanel("login");
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
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(SignUp.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
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

        private void handleRegistration() throws Exception {
                String username = usernameField.getText().trim();
                String password = passwordField.getText().trim();
                String phoneNumber = phoneNumberField.getText().trim();

                if (username.isEmpty() || password.isEmpty() || phoneNumber.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error",
                                        JOptionPane.ERROR_MESSAGE);
                        throw new Exception("Please fill in all fields");
                }

                // ตรวจสอบความแข็งแรงของรหัสผ่าน
                PasswordStrength strength = PasswordValidator.validate(password);

                if (phoneNumber.length() != 8 || strength == PasswordStrength.INVALID) {
                        JOptionPane.showMessageDialog(this,
                                        "Invalid phone number or password didn't has atleast 8 characters",
                                        "Invalid password",
                                        JOptionPane.ERROR_MESSAGE);
                        throw new Exception("Invalid phone number or password didn't has atleast 8 characters");
                } else if (phoneNumber.length() != 8 || strength == PasswordStrength.WEAK) {
                        JOptionPane.showMessageDialog(this,
                                        "Invalid phone number or your password is too weak. Please use a number or a uppercase letter or both",
                                        "Weak password",
                                        JOptionPane.ERROR_MESSAGE);
                        throw new Exception(
                                        "Invalid phone number or your password is too weak. Please use a number or a uppercase letter or both");
                }

                // ถ้ารหัสผ่านดีพอ
                boolean success = loginService.registerAccount(username, password, phoneNumber);

                if (success) {
                        JOptionPane.showMessageDialog(this,
                                        "Register secceeded!\n\nUsername: " + username + "\nPhone: " + phoneNumber,
                                        "Success",
                                        JOptionPane.INFORMATION_MESSAGE);

                        
                        // this.dispose();
                } else {
                        JOptionPane.showMessageDialog(this,
                                        "Username has already been used, please try another one",
                                        "Register Failed",
                                        JOptionPane.ERROR_MESSAGE);
                        throw new Exception("Username has already been used, please try another one");
                }
        }

        private JButton jButtonSignUp;
        private JButton jButton2;
        private JLabel jLabel1;
        private JLabel jLabelInvaild3;
        private JLabel jLabelImg;
        private JLabel jLabelSignUp;
        private JLabel jLabelPhone;
        private JLabel jLabelUserName;
        private JLabel jLabelPassword;
        private JLabel jLabelInvaild1;
        private JLabel jLabelInvaild2;
        private JPanel jPanelMain;
        private JPanel jPanel10;
        private JPanel jPanel2;
        private JPanel jPanel3;
        private JPanel jPanel4;
        private JPanel jPanel5;
        private JPanel jPanel6;
        private JPanel jPanel7;
        private JPanel jPanel8;
        private JPasswordField jPasswordField1;
        private JTextField passwordField;
        private JTextField usernameField;
        private JTextField phoneNumberField;
        // End of variables declaration//GEN-END:variables
}
