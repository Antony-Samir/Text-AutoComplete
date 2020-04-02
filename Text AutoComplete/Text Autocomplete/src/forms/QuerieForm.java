package forms;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import strings.EditDistance;
import strings.Prefix;
import text.autocomplete.ReadFile;
import text.autocomplete.WriteFile;

public class QuerieForm extends javax.swing.JFrame
{

    static MainForm MF = new MainForm();
    ReadFile RF = new ReadFile();
    WriteFile WF = new WriteFile();

    public QuerieForm()
    {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox2 = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(720, 480));
        getContentPane().setLayout(null);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(180, 190, 158, 32);

        jButton1.setText("Search File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(410, 190, 110, 32);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(20, 20, 80, 40);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Edit Distance", "Prefix" }));
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(200, 70, 110, 26);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Simple", "Medium", "Large" }));
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(420, 70, 80, 26);

        jLabel2.setText("Searching Methood");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(170, 40, 120, 16);

        jLabel3.setText("Test Cases File");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(390, 40, 90, 16);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/smoke.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(720, 480));
        jLabel1.setMinimumSize(new java.awt.Dimension(720, 480));
        jLabel1.setPreferredSize(new java.awt.Dimension(720, 480));
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 720, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        MF.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jTextField1ActionPerformed
    {//GEN-HEADEREND:event_jTextField1ActionPerformed

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        String QF = jTextField1.getText();
        String choice = jComboBox1.getSelectedItem().toString();
        String file = jComboBox2.getSelectedItem().toString();

        if (QF.isEmpty())
        {
            JOptionPane.showMessageDialog(this, "Enter The Word To Be Searched", "Field Not Entered!!", JOptionPane.ERROR_MESSAGE);
        } else
        {
            String[] outputArrayV1 = new String[RF.iterationsMap1];
            String[] outputArrayW1 = new String[RF.iterationsMap1];
            String[] outputArrayV2 = new String[RF.iterationsMap2];
            String[] outputArrayW2 = new String[RF.iterationsMap2];
            String[] outputArrayV3 = new String[RF.iterationsMap3];
            String[] outputArrayW3 = new String[RF.iterationsMap3];

            int outputIteration1 = 0;
            int outputIteration2 = 0;
            int outputIteration3 = 0;

            if (file.equals("Simple") && (choice.equals("Edit Distance")))
            {//case1
                Integer[] minSave = new Integer[RF.iterationsMap1];
                EditDistance ED = new EditDistance();
                int min;
                for (int i = 0; i < RF.iterationsMap1; i++)
                {
                    minSave[i] = ED.editDist(RF.value1[i], QF, RF.value1[i].length(), QF.length());
                }
                min = Collections.min(Arrays.asList(minSave));
                //System.out.println(min);
                for (int j = 0; j < RF.iterationsMap1; j++)
                {
                    if (minSave[j] == min)
                    {
                            //System.out.println(RF.weight1[j] + "    " + RF.value1[j]);

                        outputArrayV1[outputIteration1] = RF.value1[j];
                        outputArrayW1[outputIteration1] = RF.weight1[j].toString();
                        outputIteration1++;
                    }
                }

                try
                {
                    WF.queryOutput(outputArrayV1, outputArrayW1, outputIteration1);
                } catch (IOException ex)
                {
                    Logger.getLogger(FileForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (file.equals("Simple") && (choice.equals("Prefix")))
            {//case2
                Prefix pre = new Prefix();
                Boolean flag = false;
                int test = 0;
                for (int i = 0; i < RF.iterationsMap1; i++)
                {
                    //System.out.println(pre.startsWith(RF.value1[i], QF));
                    flag = pre.startsWith(RF.value1[i], QF);
                    if (flag == true)
                    {
                        //System.out.println(RF.weight1[i] + "    " + RF.value1[i]);

                        outputArrayV1[outputIteration1] = RF.value1[i];
                        outputArrayW1[outputIteration1] = RF.weight1[i].toString();
                        outputIteration1++;
                        test++;
                    }
                }
                if (test == 0)
                {
                    System.out.println("Not Found!!");
                }
                try
                {
                    WF.queryOutput(outputArrayV1, outputArrayW1, outputIteration1);
                } catch (IOException ex)
                {
                    Logger.getLogger(FileForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (file.equals("Medium") && (choice.equals("Edit Distance")))
            {//case3
                Integer[] minSave = new Integer[RF.iterationsMap2];
                EditDistance ED = new EditDistance();
                int min;
                for (int i = 0; i < RF.iterationsMap2; i++)
                {
                    minSave[i] = ED.editDist(RF.value2[i], QF, RF.value2[i].length(), QF.length());
                }
                min = Collections.min(Arrays.asList(minSave));
                //System.out.println(min);
                for (int j = 0; j < RF.iterationsMap2; j++)
                {
                    if (minSave[j] == min)
                    {
                        //System.out.println(RF.weight2[j] + "    " + RF.value2[j]);

                        outputArrayV2[outputIteration2] = RF.value2[j];
                        outputArrayW2[outputIteration2] = RF.weight2[j].toString();
                        outputIteration2++;
                    }
                }

                try
                {
                    WF.queryOutput(outputArrayV2, outputArrayW2, outputIteration2);
                } catch (IOException ex)
                {
                    Logger.getLogger(FileForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (file.equals("Medium") && (choice.equals("Prefix")))
            {//case4
                Prefix pre = new Prefix();
                Boolean flag = false;
                int test = 0;
                for (int i = 0; i < RF.iterationsMap2; i++)
                {
                    //System.out.println(pre.startsWith(RF.value2[i], QF));
                    flag = pre.startsWith(RF.value2[i], QF);
                    if (flag == true)
                    {
                        //System.out.println(RF.weight2[i] + "    " + RF.value2[i]);

                        outputArrayV2[outputIteration2] = RF.value2[i];
                        outputArrayW2[outputIteration2] = RF.weight2[i].toString();
                        outputIteration2++;
                        test++;
                    }
                }
                if (test == 0)
                {
                    System.out.println("Not Found!!");
                }
                try
                {
                    WF.queryOutput(outputArrayV2, outputArrayW2, outputIteration2);
                } catch (IOException ex)
                {
                    Logger.getLogger(FileForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (file.equals("Large") && (choice.equals("Edit Distance")))
            {//case5
                Integer[] minSave = new Integer[RF.iterationsMap3];
                EditDistance ED = new EditDistance();
                int min;
                for (int i = 0; i < RF.iterationsMap3; i++)
                {
                    minSave[i] = ED.editDist(RF.value3[i], QF, RF.value3[i].length(), QF.length());
                }
                min = Collections.min(Arrays.asList(minSave));
                //System.out.println(min);
                for (int j = 0; j < RF.iterationsMap3; j++)
                {
                    if (minSave[j] == min)
                    {
                        //System.out.println(RF.weight3[j] + "    " + RF.value3[j]);

                        outputArrayV3[outputIteration3] = RF.value3[j];
                        outputArrayW3[outputIteration3] = RF.weight3[j].toString();
                        outputIteration3++;
                    }
                }

                try
                {
                    WF.queryOutput(outputArrayV3, outputArrayW3, outputIteration3);
                } catch (IOException ex)
                {
                    Logger.getLogger(FileForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (file.equals("Large") && (choice.equals("Prefix")))
            {//case6
                Prefix pre = new Prefix();
                Boolean flag = false;
                int test = 0;
                for (int i = 0; i < RF.iterationsMap3; i++)
                {
                    //System.out.println(pre.startsWith(RF.value3[i], QF));
                    flag = pre.startsWith(RF.value3[i], QF);
                    if (flag == true)
                    {
                        //System.out.println(RF.weight3[i] + "    " + RF.value3[i]);

                        outputArrayV3[outputIteration3] = RF.value3[i];
                        outputArrayW3[outputIteration3] = RF.weight3[i].toString();
                        outputIteration3++;
                        test++;
                    }
                }
                if (test == 0)
                {
                    System.out.println("Not Found!!");
                }
                try
                {
                    WF.queryOutput(outputArrayV3, outputArrayW3, outputIteration3);
                } catch (IOException ex)
                {
                    Logger.getLogger(FileForm.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(QuerieForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(QuerieForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(QuerieForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(QuerieForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new QuerieForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
