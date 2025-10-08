import javax.swing.*;
import java.awt.event.*;



public class Foodmenu extends JDialog {
    
    public String type;
    public int quantity;

    public Foodmenu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
                          
    private void initComponents() {

        jButton1 = new JButton();
        jCheckBox1 = new JCheckBox();
        jCheckBox2 = new JCheckBox();
        jSpinner1 = new JSpinner(new SpinnerNumberModel(1,1, 10, 1));

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jButton1.setText("Add");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jCheckBox1.setText("Add rice");
        jCheckBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Add side dish");
        jCheckBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jSpinner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox2)
                            .addComponent(jCheckBox1))))
                .addContainerGap(138, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(182, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addGap(40, 40, 40)
                .addComponent(jCheckBox2)
                .addGap(121, 121, 121)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jSpinner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(362, 362, 362))
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
        quantity = (int) jSpinner1.getValue();
        if(jCheckBox1.isSelected()&&!jCheckBox2.isSelected())
            type = "Riceup";
        else if(!jCheckBox1.isSelected()&&jCheckBox2.isSelected())
            type = "Sidedishup";
        else if(jCheckBox1.isSelected()&&jCheckBox2.isSelected())
            type = "Special";
        else type = "Default";
        System.out.println(type+" "+quantity);
    }                                        

    private void jCheckBox1ActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:

    }
    private void jCheckBox2ActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                           



    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Foodmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Foodmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Foodmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Foodmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Foodmenu dialog = new Foodmenu(new JFrame(), true);
                dialog.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
                  
    private JButton jButton1;
    private JCheckBox jCheckBox1;
    private JCheckBox jCheckBox2;
    private JSpinner jSpinner1;                 
}

