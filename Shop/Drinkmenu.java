
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class Drinkmenu extends JDialog {

    public String type;
    public int quantity;

    public Drinkmenu(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }
                    
    private void initComponents() {

        jCheckBox1 = new JCheckBox();
        jCheckBox2 = new JCheckBox();
        jCheckBox3 = new JCheckBox();
        jSpinner1 = new JSpinner(new SpinnerNumberModel(1,1, 10, 1));
        jButton1 = new JButton();
        ButtonGroup group = new ButtonGroup();
        group.add(jCheckBox1);
        group.add(jCheckBox2);
        group.add(jCheckBox3);

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        jCheckBox1.setText("Hot");
        jCheckBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCheckBox2.setText("Cold");
        jCheckBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        jCheckBox3.setText("Mix");
        jCheckBox3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });

        jButton1.setText("Add");
        jButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jSpinner1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(88, 88, 88))
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jCheckBox1, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox2))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addComponent(jCheckBox1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox2)
                .addGap(37, 37, 37)
                .addComponent(jCheckBox3)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(360, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void jCheckBox1ActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jCheckBox2ActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jCheckBox3ActionPerformed(ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    private void jButton1ActionPerformed(ActionEvent evt) {                                         
        // TODO add your handling code here:
        quantity = (int) jSpinner1.getValue();
        if(jCheckBox1.isSelected())
            type = "Hot";
        else if(jCheckBox2.isSelected())
            type = "Cold";
        else if(jCheckBox3.isSelected())
            type = "Mix";
        else type = "Cold";
        System.out.println(type+" "+quantity);
    }                                        

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Drinkmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Drinkmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Drinkmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Drinkmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Drinkmenu dialog = new Drinkmenu(new JFrame(), true);
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
    private JCheckBox jCheckBox3;
    private JSpinner jSpinner1;
    // End of variables declaration                   
}
