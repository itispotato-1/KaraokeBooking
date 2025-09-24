package GUI;

import javax.swing.*;

import lib.loginregister.LoginRegisterService;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class Login extends JPanel {
        private Mainframe mainframe;
        private Font FontITCKRIST;
        private Font FontTWCENMT;
        private LoginRegisterService loginService;

        public Login(Mainframe mainframe) {
                loginService = new LoginRegisterService();
                this.mainframe = mainframe;
                setUpFont();
                setUpLookAndFeel();
                initComponents();

        }

        private void initComponents() {

                jPanel4 = new JPanel();
                jMainPanel = new JPanel();
                jLabelImageK2 = new JLabel();
                jLabelImageLogo = new JLabel();
                jPanel1 = new JPanel();
                pass = new JTextField();
                user = new JTextField();
                jLabelLogin = new JButton();
                jLabelPassWord = new JLabel();
                jLabelUserName = new JLabel();
                jPassOrNameWrong = new JLabel();
                jPanelLineRight = new JPanel();
                jPanelLineLeft = new JPanel();
                jLabelLogIn = new JLabel();
                jButtonLogin = new JButton();

                add(jMainPanel);
                GroupLayout jPanel4Layout = new GroupLayout(jPanel4);
                jPanel4.setLayout(jPanel4Layout);
                jPanel4Layout.setHorizontalGroup(
                                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 100, Short.MAX_VALUE));
                jPanel4Layout.setVerticalGroup(
                                jPanel4Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 100, Short.MAX_VALUE));

                jMainPanel.setBackground(new Color(235, 240, 255));
                jMainPanel.setPreferredSize(new Dimension(440, 664));
                jMainPanel.setVerifyInputWhenFocusTarget(false);

                jLabelImageK2.setIcon(new ImageIcon(getClass().getResource("/GUI/Picture/k2.png")));
                jLabelImageK2.setText("jLabel1");
                ImageIcon tempIcon = new ImageIcon("./GUI/Picture/Logo.png");
                Image tempImage = tempIcon.getImage().getScaledInstance(125, 125, Image.SCALE_SMOOTH);
                jLabelImageLogo.setIcon(new ImageIcon(tempImage));

                jPanel1.setBackground(new Color(255, 255, 255));

                pass.setToolTipText("");
                pass.setOpaque(true);
                pass.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                passActionPerformed(evt);
                        }
                });

                user.setToolTipText("");
                user.setOpaque(true);
                user.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                userActionPerformed(evt);
                        }
                });

                jLabelLogin.setBackground(new Color(0, 57, 134));
                jLabelLogin.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 18));
                jLabelLogin.setForeground(new Color(255, 255, 255));
                jLabelLogin.setText("LOGIN");
                jLabelLogin.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                loginActionPerformed(evt);
                        }
                });

                jLabelPassWord.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 18));
                jLabelPassWord.setText("PASSWORD");

                jLabelUserName.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 18));
                jLabelUserName.setText("USERNAME");

                jPassOrNameWrong.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 14));
                jPassOrNameWrong.setForeground(new Color(255, 51, 0));
                jPassOrNameWrong.setText("username or password wrong");

                GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(14, 14, 14)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jPassOrNameWrong,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                189,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addGroup(
                                                                                                jPanel1Layout.createParallelGroup(
                                                                                                                GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                                .addComponent(jLabelPassWord)
                                                                                                                .addComponent(jLabelUserName)
                                                                                                                .addComponent(pass)
                                                                                                                .addComponent(jLabelLogin,
                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                322,
                                                                                                                                Short.MAX_VALUE)
                                                                                                                .addComponent(user)))
                                                                .addContainerGap(20, Short.MAX_VALUE)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout
                                                                .createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addComponent(jLabelUserName, GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(user, GroupLayout.PREFERRED_SIZE, 36,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(jLabelPassWord)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(pass, GroupLayout.PREFERRED_SIZE, 37,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPassOrNameWrong)
                                                                .addGap(14, 14, 14)
                                                                .addComponent(jLabelLogin, GroupLayout.PREFERRED_SIZE,
                                                                                42, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(14, 14, 14)));

                user.getAccessibleContext().setAccessibleParent(pass);

                jPanelLineRight.setBackground(new Color(0, 57, 134));
                jPanelLineRight.setPreferredSize(new Dimension(113, 13));

                GroupLayout jPanel2Layout = new GroupLayout(jPanelLineRight);
                jPanelLineRight.setLayout(jPanel2Layout);
                jPanel2Layout.setHorizontalGroup(
                                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 99, Short.MAX_VALUE));
                jPanel2Layout.setVerticalGroup(
                                jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 12, Short.MAX_VALUE));

                jPanelLineLeft.setBackground(new Color(0, 57, 134));

                GroupLayout jPanel3Layout = new GroupLayout(jPanelLineLeft);
                jPanelLineLeft.setLayout(jPanel3Layout);
                jPanel3Layout.setHorizontalGroup(
                                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 113, Short.MAX_VALUE));
                jPanel3Layout.setVerticalGroup(
                                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGap(0, 13, Short.MAX_VALUE));

                jLabelLogIn.setFont(new Font("Serif", 1, 48));
                jLabelLogIn.setForeground(new Color(0, 57, 134));
                jLabelLogIn.setText("LOGIN");

                jButtonLogin.setBackground(new Color(0, 57, 134));
                jButtonLogin.setFont(FontTWCENMT.deriveFont(1).deriveFont((float) 18));
                jButtonLogin.setForeground(new Color(255, 255, 255));
                jButtonLogin.setText("SIGN UP");
                jButtonLogin.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                                signUpActionPerformed(evt);
                        }
                });

                GroupLayout P1Layout = new GroupLayout(jMainPanel);
                jMainPanel.setLayout(P1Layout);
                P1Layout.setHorizontalGroup(
                                P1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(P1Layout.createSequentialGroup()
                                                                .addGap(45)// Password
                                                                .addGroup(P1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(jPanel1,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(jButtonLogin))

                                                                .addContainerGap(29, Short.MAX_VALUE))

                                                .addGroup(P1Layout.createSequentialGroup()
                                                                .addGap(30)
                                                                .addComponent(jPanelLineLeft,
                                                                                GroupLayout.PREFERRED_SIZE, 99,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(P1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)

                                                                                .addComponent(jLabelImageLogo,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                135,
                                                                                                GroupLayout.PREFERRED_SIZE)

                                                                                .addGroup(P1Layout
                                                                                                .createSequentialGroup()

                                                                                                .addComponent(jLabelLogIn)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(jPanelLineRight,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                99,
                                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                                .addComponent(jLabelImageK2,
                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                111,
                                                                                                GroupLayout.PREFERRED_SIZE))
                                                                .addGap(0, 0, Short.MAX_VALUE)));
                P1Layout.setVerticalGroup(
                                P1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                .addGroup(P1Layout.createSequentialGroup()
                                                                .addGroup(P1Layout.createParallelGroup(
                                                                                GroupLayout.Alignment.LEADING)
                                                                                .addGroup(P1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(20)
                                                                                                .addComponent(jLabelImageLogo,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                98,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addGroup(P1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                GroupLayout.Alignment.TRAILING)
                                                                                                                .addGroup(P1Layout
                                                                                                                                .createSequentialGroup()
                                                                                                                                .addComponent(jLabelLogIn)
                                                                                                                                .addGap(24, 24, 24))
                                                                                                                .addGroup(GroupLayout.Alignment.LEADING,
                                                                                                                                P1Layout
                                                                                                                                                .createSequentialGroup()
                                                                                                                                                .addGap(30, 30, 30)
                                                                                                                                                .addComponent(jPanelLineLeft,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                                                                .addPreferredGap(
                                                                                                                                                                LayoutStyle.ComponentPlacement.RELATED))))
                                                                                .addGroup(P1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGap(148)
                                                                                                .addComponent(jPanelLineRight,
                                                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                                                12,
                                                                                                                GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)))
                                                                .addComponent(jLabelImageK2, GroupLayout.PREFERRED_SIZE,
                                                                                81, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0)
                                                                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE,
                                                                                GroupLayout.DEFAULT_SIZE,
                                                                                GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0)
                                                                .addComponent(jButtonLogin, GroupLayout.PREFERRED_SIZE,
                                                                                42, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(90)));

        }

        private void passActionPerformed(ActionEvent evt) {

        }

        private void userActionPerformed(ActionEvent evt) {

        }

        private void loginActionPerformed(ActionEvent evt) {
              boolean check=false;
                try {
                handleLogin();
              } catch (Exception e) {
                check=true;
              }
              if(check==false){
                      mainframe.showPanel("book");
              }

        }

        private void signUpActionPerformed(ActionEvent evt) {
                mainframe.showPanel("signup");
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
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                }
        }

        private void handleLogin() throws Exception {
                String username = user.getText();
                String password = pass.getText();

                // เชื่อมกับ LoginService
                if (!(loginService.checkCredentials(username, password))) {

                        jPassOrNameWrong.setForeground(Color.RED);
                        jPassOrNameWrong.setText("❌ Invalid Username or Password");
                        throw new Exception("Invalid password"); 
                }
        }

        private JPanel jMainPanel;
        private JLabel jLabelImageK2;
        private JLabel jLabelImageLogo;
        private JLabel jLabelLogIn;
        private JLabel jLabelPassWord;
        private JLabel jLabelUserName;
        private JLabel jPassOrNameWrong;
        private JPanel jPanel1;
        private JPanel jPanelLineRight;
        private JPanel jPanelLineLeft;
        private JPanel jPanel4;
        private JButton jLabelLogin;
        private JButton jButtonLogin;
        private JTextField pass;
        private JTextField user;
        // End of variables declaration//GEN-END:variables
}
