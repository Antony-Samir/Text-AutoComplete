package forms;

import java.awt.List;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JOptionPane;
import strings.EditDistance;
import strings.Prefix;
import text.autocomplete.ReadFile;
import text.autocomplete.WriteFile;

public class FileForm extends javax.swing.JFrame
{
    static MainForm MF = new MainForm();
    static ReadFile RF = new ReadFile();
    static WriteFile WF = new WriteFile();

    /**
     * Creates new form InputForm
     */
    public FileForm()
    {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(720, 480));
        getContentPane().setLayout(null);

        jButton1.setText("Sample Cases");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(110, 120, 130, 32);

        jButton2.setText("Medium Cases");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(290, 120, 130, 32);

        jButton3.setText("Large Cases");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(480, 120, 130, 32);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/back.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(20, 10, 80, 40);

        jButton5.setText("Medium Cases 2");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(290, 180, 130, 32);

        jButton6.setText("Large Cases 2");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(480, 180, 130, 32);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/background.jpg"))); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(720, 480));
        jLabel2.setMinimumSize(new java.awt.Dimension(720, 480));
        jLabel2.setPreferredSize(new java.awt.Dimension(720, 480));
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 720, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton1ActionPerformed
    {//GEN-HEADEREND:event_jButton1ActionPerformed
        //TableModel tableModel = new DefaultTableModel(values.toArray(new Object[][]{}), columns.toArray());
        //jTable1.setModel(tableModel);
        try
        {
            RF.readMap();
            RF.readQueries1();
        } catch (IOException ex)
        {
            Logger.getLogger(FileForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        Prefix pre = new Prefix();
        for (int i = 0; i < RF.iterationsQuerie1; i++)
        {
            String[] outputArrayV = new String[RF.iterationsMap1];
            String[] outputArrayW = new String[RF.iterationsMap1];
            
            int outputIteration = 0;
            
            Boolean flag = false;
            int test = 0;
            for (int k = 0; k < RF.iterationsMap1; k++)
            {
                //System.out.println(pre.startsWith(RF.value1[i], QF));
                flag = pre.startsWith(RF.value1[k], RF.querieArray1[i]);
                if (flag == true)
                {
                    /*System.out.println("Prefix: ");
                    System.out.println(RF.weight1[k] + "    " + RF.value1[k]);
                    System.out.println();*/
                    //jTextArea1.setText(RF.weight1[k] + "    " + RF.value1[k]);
                    outputArrayV[outputIteration] = RF.value1[k];
                    outputArrayW[outputIteration] = RF.weight1[k].toString();
                    outputIteration++;
                    test++;
                }
            }
            if (test == 0)
            {
                //System.out.println("Edit Distance: ");
                Integer[] minSave = new Integer[RF.iterationsMap1];
                EditDistance ED = new EditDistance();
                int min;

                for (int j = 0; j < RF.iterationsMap1; j++)
                {
                    minSave[j] = ED.editDist(RF.value1[j], RF.querieArray1[i], RF.value1[j].length(), RF.querieArray1[i].length());
                }
                min = Collections.min(Arrays.asList(minSave));
                //System.out.println(min);
                for (int j = 0; j < RF.iterationsMap1; j++)
                {
                    if (minSave[j] == min)
                    {
                        //System.out.println(RF.weight1[j] + "    " + RF.value1[j]);
                        
                        outputArrayV[outputIteration] = RF.value1[j];
                        outputArrayW[outputIteration] = RF.weight1[j].toString();
                        outputIteration++;
                    }
                }

            }
            try
            {
                WF.writeOutput1(outputArrayV, outputArrayW, outputIteration);
            } catch (IOException ex)
            {
                Logger.getLogger(FileForm.class.getName()).log(Level.SEVERE, null, ex);
            }


        }


    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
    {//GEN-HEADEREND:event_jButton4ActionPerformed
        MF.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton2ActionPerformed
    {//GEN-HEADEREND:event_jButton2ActionPerformed
        
        try
        {
            RF.readMap();
            RF.readQueries2();
        } catch (IOException ex)
        {
            Logger.getLogger(FileForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        Prefix pre = new Prefix();
        for (int i = 0; i < RF.iterationsQuerie2; i++)
        {
            String[] outputArrayV = new String[RF.iterationsMap2];
            String[] outputArrayW = new String[RF.iterationsMap2];
            
            int outputIteration = 0;
            
            Boolean flag = false;
            int test = 0;
            for (int k = 0; k < RF.iterationsMap2; k++)
            {
                //System.out.println(pre.startsWith(RF.value1[i], QF));
                flag = pre.startsWith(RF.value2[k], RF.querieArray2[i]);
                if (flag == true)
                {
                    /*System.out.println("Prefix: ");
                    System.out.println(RF.weight2[k] + "    " + RF.value2[k]);
                    System.out.println();*/
                    outputArrayV[outputIteration] = RF.value2[k];
                    outputArrayW[outputIteration] = RF.weight2[k].toString();
                    outputIteration++;
                    test++;
                }
            }
            if (test == 0)
            {
                //System.out.println("Edit Distance: ");
                Integer[] minSave = new Integer[RF.iterationsMap2];
                EditDistance ED = new EditDistance();
                int min;

                for (int j = 0; j < RF.iterationsMap2; j++)
                {
                    minSave[j] = ED.editDist(RF.value2[j], RF.querieArray2[i], RF.value2[j].length(), RF.querieArray2[i].length());
                }
                min = Collections.min(Arrays.asList(minSave));
                //System.out.println(min);
                for (int j = 0; j < RF.iterationsMap2; j++)
                {
                    if (minSave[j] == min)
                    {
                        //System.out.println(RF.weight2[j] + "    " + RF.value2[j]);
                        
                        outputArrayV[outputIteration] = RF.value2[j];
                        outputArrayW[outputIteration] = RF.weight2[j].toString();
                        outputIteration++;
                    }
                }

            }
            try
            {
                WF.writeOutput2(outputArrayV, outputArrayW, outputIteration);
            } catch (IOException ex)
            {
                Logger.getLogger(FileForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
    {//GEN-HEADEREND:event_jButton3ActionPerformed
        
        try
        {
            RF.readMap();
            RF.readQueries3();
        } catch (IOException ex)
        {
            Logger.getLogger(FileForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        Prefix pre = new Prefix();
        for (int i = 0; i < RF.iterationsQuerie3; i++)
        {
            String[] outputArrayV = new String[RF.iterationsMap3];
            String[] outputArrayW = new String[RF.iterationsMap3];
            
            int outputIteration = 0;
            Boolean flag = false;
            int test = 0;
            for (int k = 0; k < RF.iterationsMap3; k++)
            {
                //System.out.println(pre.startsWith(RF.value1[i], QF));
                flag = pre.startsWith(RF.value3[k], RF.querieArray3[i]);
                if (flag == true)
                {
                    /*System.out.println("Prefix: ");
                    System.out.println(RF.weight3[k] + "    " + RF.value3[k]);
                    System.out.println();*/
                    outputArrayV[outputIteration] = RF.value3[k];
                    outputArrayW[outputIteration] = RF.weight3[k].toString();
                    outputIteration++;
                    test++;
                }
            }
            if (test == 0)
            {
                //System.out.println("Edit Distance: ");
                Integer[] minSave = new Integer[RF.iterationsMap3];
                EditDistance ED = new EditDistance();
                int min;

                for (int j = 0; j < RF.iterationsMap3; j++)
                {
                    minSave[j] = ED.editDist(RF.value3[j], RF.querieArray3[i], RF.value3[j].length(), RF.querieArray3[i].length());
                }
                min = Collections.min(Arrays.asList(minSave));
                //System.out.println(min);
                for (int j = 0; j < RF.iterationsMap3; j++)
                {
                    if (minSave[j] == min)
                    {
                        //System.out.println(RF.weight3[j] + "    " + RF.value3[j]);
                        outputArrayV[outputIteration] = RF.value3[j];
                        outputArrayW[outputIteration] = RF.weight3[j].toString();
                        outputIteration++;
                    }
                }

            }
            try
            {
                WF.writeOutput3(outputArrayV, outputArrayW, outputIteration);
            } catch (IOException ex)
            {
                Logger.getLogger(FileForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        try
        {
            RF.readMap();
            RF.readQueries4();
        } catch (IOException ex)
        {
            Logger.getLogger(FileForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        Prefix pre = new Prefix();
        for (int i = 0; i < RF.iterationsQuerie4; i++)
        {
            String[] outputArrayV = new String[RF.iterationsMap2];
            String[] outputArrayW = new String[RF.iterationsMap2];
            
            int outputIteration = 0;
            
            Boolean flag = false;
            int test = 0;
            for (int k = 0; k < RF.iterationsMap2; k++)
            {
                //System.out.println(pre.startsWith(RF.value1[i], QF));
                flag = pre.startsWith(RF.value2[k], RF.querieArray4[i]);
                if (flag == true)
                {
                    /*System.out.println("Prefix: ");
                    System.out.println(RF.weight2[k] + "    " + RF.value2[k]);
                    System.out.println();*/
                    outputArrayV[outputIteration] = RF.value2[k];
                    outputArrayW[outputIteration] = RF.weight2[k].toString();
                    outputIteration++;
                    test++;
                }
            }
            if (test == 0)
            {
                //System.out.println("Edit Distance: ");
                Integer[] minSave = new Integer[RF.iterationsMap2];
                EditDistance ED = new EditDistance();
                int min;

                for (int j = 0; j < RF.iterationsMap2; j++)
                {
                    minSave[j] = ED.editDist(RF.value2[j], RF.querieArray4[i], RF.value2[j].length(), RF.querieArray4[i].length());
                }
                min = Collections.min(Arrays.asList(minSave));
                //System.out.println(min);
                for (int j = 0; j < RF.iterationsMap2; j++)
                {
                    if (minSave[j] == min)
                    {
                        //System.out.println(RF.weight2[j] + "    " + RF.value2[j]);
                        
                        outputArrayV[outputIteration] = RF.value2[j];
                        outputArrayW[outputIteration] = RF.weight2[j].toString();
                        outputIteration++;
                    }
                }

            }
            try
            {
                WF.writeOutput4(outputArrayV, outputArrayW, outputIteration);
            } catch (IOException ex)
            {
                Logger.getLogger(FileForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
        
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
        
        try
        {
            RF.readMap();
            RF.readQueries5();
        } catch (IOException ex)
        {
            Logger.getLogger(FileForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        Prefix pre = new Prefix();
        for (int i = 0; i < RF.iterationsQuerie5; i++)
        {
            String[] outputArrayV = new String[RF.iterationsMap3];
            String[] outputArrayW = new String[RF.iterationsMap3];
            
            int outputIteration = 0;
            Boolean flag = false;
            int test = 0;
            for (int k = 0; k < RF.iterationsMap3; k++)
            {
                //System.out.println(pre.startsWith(RF.value1[i], QF));
                flag = pre.startsWith(RF.value3[k], RF.querieArray5[i]);
                if (flag == true)
                {
                    /*System.out.println("Prefix: ");
                    System.out.println(RF.weight3[k] + "    " + RF.value3[k]);
                    System.out.println();*/
                    outputArrayV[outputIteration] = RF.value3[k];
                    outputArrayW[outputIteration] = RF.weight3[k].toString();
                    outputIteration++;
                    test++;
                }
            }
            if (test == 0)
            {
                //System.out.println("Edit Distance: ");
                Integer[] minSave = new Integer[RF.iterationsMap3];
                EditDistance ED = new EditDistance();
                int min;

                for (int j = 0; j < RF.iterationsMap3; j++)
                {
                    minSave[j] = ED.editDist(RF.value3[j], RF.querieArray5[i], RF.value3[j].length(), RF.querieArray5[i].length());
                }
                min = Collections.min(Arrays.asList(minSave));
                //System.out.println(min);
                for (int j = 0; j < RF.iterationsMap3; j++)
                {
                    if (minSave[j] == min)
                    {
                        //System.out.println(RF.weight3[j] + "    " + RF.value3[j]);
                        outputArrayV[outputIteration] = RF.value3[j];
                        outputArrayW[outputIteration] = RF.weight3[j].toString();
                        outputIteration++;
                    }
                }

            }
            try
            {
                WF.writeOutput5(outputArrayV, outputArrayW, outputIteration);
            } catch (IOException ex)
            {
                Logger.getLogger(FileForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(FileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(FileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(FileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(FileForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new FileForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
