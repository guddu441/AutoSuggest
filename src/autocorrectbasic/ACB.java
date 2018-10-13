package autocorrectbasic;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;


public class ACB extends javax.swing.JFrame {

    String str;
    ArrayList<String> arr = new ArrayList<>();
    DefaultListModel<String> model = new DefaultListModel<String>();

    public ACB() {
        initComponents();
        dict();
        myScrollPane.setVisible(false);
        myList.setModel(model);
    }

    private void dict() {
        try {
            BufferedReader br= new BufferedReader(new FileReader("dictionary.txt"));
            while(true){
                String s1=br.readLine();
                if(s1==null){
                    break;
                }
                arr.add(s1);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ACB.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ACB.class.getName()).log(Level.SEVERE, null, ex);
        }   
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtBox = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        myScrollPane = new javax.swing.JScrollPane();
        myList = new javax.swing.JList();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtBox.setFont(new java.awt.Font("Raleway", 0, 12)); // NOI18N
        txtBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBoxKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Raleway", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("NOOBLE");

        myList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        myList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                myListValueChanged(evt);
            }
        });
        myScrollPane.setViewportView(myList);

        jButton1.setBackground(new java.awt.Color(51, 255, 51));
        jButton1.setFont(new java.awt.Font("Raleway", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(207, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(198, 198, 198))
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(myScrollPane)
                    .addComponent(txtBox, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBox, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBoxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBoxKeyReleased
        str = txtBox.getText();
        model.clear();
        if (str.length() >= 1) {
            for (String s : arr) {
                if (s.toLowerCase().startsWith(str.toLowerCase())) {
                    model.addElement(s);
                }
            }
        }
        if (model.isEmpty()) {
            myScrollPane.setVisible(false);
        } else {
            myScrollPane.setVisible(true);
            pack();
        }
    }//GEN-LAST:event_txtBoxKeyReleased

    private void myListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_myListValueChanged
        if (myList.getSelectedValue()!= null) {
            String st1 = myList.getSelectedValue().toString();
            txtBox.setText(st1);
            model.clear();
            if (model.isEmpty()) {
                myScrollPane.setVisible(false);
            } else {
                myScrollPane.setVisible(true);
                pack();
            }
        }
    }//GEN-LAST:event_myListValueChanged

    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ACB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ACB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ACB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ACB.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ACB().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList myList;
    private javax.swing.JScrollPane myScrollPane;
    private javax.swing.JTextField txtBox;
    // End of variables declaration//GEN-END:variables
}
