/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Frames;


import com.mycompany.OOP.UserManagement.EmployeeLogInFrame;
import com.mycompany.OOP.EmployeeVerification.Employees;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;


/**
 *
 * @author Yennie
 */
public class EmployeeMainFrame extends javax.swing.JDialog {

    /**
     * Creates new form MainFrame
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     * @throws com.opencsv.exceptions.CsvValidationException
     */
    
   public EmployeeMainFrame() throws IOException, FileNotFoundException, CsvValidationException {
        initComponents();
        setLocationRelativeTo(null);
    }
   
   
   private String authenticatedUsername;
   
   public EmployeeMainFrame(String username) {
        this.authenticatedUsername = username;
    initComponents();
    setLocationRelativeTo(null);
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        TimeInBt = new javax.swing.JButton();
        TimeOutBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));
        setResizable(false);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TimeInBt.setText("Time In");
        TimeInBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeInBtActionPerformed(evt);
            }
        });

        TimeOutBt.setText("Time Out");
        TimeOutBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimeOutBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(TimeInBt)
                        .addGap(50, 50, 50)
                        .addComponent(TimeOutBt)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 215, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TimeInBt)
                    .addComponent(TimeOutBt))
                .addGap(168, 168, 168))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TimeInBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeInBtActionPerformed
        // TODO add your handling code here:
        timeIn();
    }//GEN-LAST:event_TimeInBtActionPerformed

    private void TimeOutBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimeOutBtActionPerformed
        // TODO add your handling code here:
        timeOut();
    }//GEN-LAST:event_TimeOutBtActionPerformed
    private void timeIn() {
        String formattedTime = LocalDateTime.now().toString();
        try {
            writeToCSV("username", formattedTime, "IN"); // Replace "username" with actual username
            JOptionPane.showMessageDialog(this, "Clocked in at: " + formattedTime);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to CSV: " + e.getMessage());
        }
    }

    private void timeOut() {
        String formattedTime = LocalDateTime.now().toString();
        try {
            writeToCSV("username", formattedTime, "OUT"); // Replace "username" with actual username
            JOptionPane.showMessageDialog(this, "Clocked out at: " + formattedTime);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error writing to CSV: " + e.getMessage());
        }
    }

    private void writeToCSV(String username, String time, String type) throws IOException {
        try (FileWriter writer = new FileWriter("time_data.csv", true)) {
            writer.write(username + "," + time + "," + type + "\n");
            writer.flush();
        }
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EmployeeMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EmployeeMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EmployeeMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EmployeeMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new EmployeeMainFrame().setVisible(true);
                } catch (IOException | CsvValidationException ex) {
                    Logger.getLogger(EmployeeMainFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton TimeInBt;
    private javax.swing.JButton TimeOutBt;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
