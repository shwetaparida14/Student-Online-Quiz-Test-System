/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiztest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author KIIT
 */
public class Exam extends javax.swing.JFrame 
{
    int count=-1;
    String answer;
    int total=0;
    int correct=0;
    /**
     * Creates new form Exam
     */
    public Exam() {
        initComponents();
       
       showquestion();
    }
    void showquestion()
    {
      count++;  
          try
        {
             Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","") ;
                Statement st=con.createStatement();
                String sql="select * from questions limit "+count+",1 ";
                ResultSet rs=st.executeQuery(sql);
                if (rs.next())
                {
                       total++;
                String qno=rs.getString("qno");   
                String question=rs.getString("question");
                 String option1=rs.getString("option1");   
                String option2=rs.getString("option2");
                 String option3=rs.getString("option3");   
                String option4=rs.getString("option4");
                answer=rs.getString("answer");
                lquestion.setText(qno+"." +question);
                 rb1.setText(option1);
                  rb2.setText(option2);
                   rb3.setText(option3);
                    rb4.setText(option4);
                }
                else
                {
                            JOptionPane.showMessageDialog(this, "Result= "+correct+"/"+total);
                 }
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(this, "Error: "+e);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lquestion = new javax.swing.JLabel();
        rb1 = new javax.swing.JRadioButton();
        rb2 = new javax.swing.JRadioButton();
        rb3 = new javax.swing.JRadioButton();
        rb4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        lquestion.setText("jLabel1");

        buttonGroup1.add(rb1);
        rb1.setText("jRadioButton1");

        buttonGroup1.add(rb2);
        rb2.setText("jRadioButton2");
        rb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb3);
        rb3.setText("jRadioButton3");

        buttonGroup1.add(rb4);
        rb4.setText("jRadioButton4");

        jButton1.setText("Next");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(rb4, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                        .addComponent(rb3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rb2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rb1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lquestion, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(90, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lquestion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(rb1)
                .addGap(18, 18, 18)
                .addComponent(rb2)
                .addGap(18, 18, 18)
                .addComponent(rb3)
                .addGap(18, 18, 18)
                .addComponent(rb4)
                .addGap(27, 27, 27)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(rb1.isSelected())
        {
            if(answer.equals("option1"))
            {
                correct++;
            }
        }
        else if(rb2.isSelected())
        {
            if(answer.equals("option2"))
            {
                correct++;
            }
        }
        else if(rb3.isSelected())
        {
            if(answer.equals("option3"))
            {
                correct++;
            }
        }
        else if(rb4.isSelected())
        {
            if(answer.equals("option4"))
            {
                correct++;
            }
        }
         buttonGroup1.clearSelection();
         
        showquestion();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void rb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb2ActionPerformed

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Exam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lquestion;
    private javax.swing.JRadioButton rb1;
    private javax.swing.JRadioButton rb2;
    private javax.swing.JRadioButton rb3;
    private javax.swing.JRadioButton rb4;
    // End of variables declaration//GEN-END:variables
}
