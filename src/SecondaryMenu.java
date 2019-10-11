
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sfaustino
 */


public class SecondaryMenu extends javax.swing.JFrame {
        int[] posicoes = { 0, 1, 2, 3, 4, 5 };
        QuizCencal q = new QuizCencal();
    /**
     * Creates new form SecondaryMenu
     */
    public void posicao(){


        shuffleArray(posicoes);
        for (int i = 0; i < posicoes.length; i++)
        {
          System.out.print(posicoes[i] + " ");
        }
        System.out.println();
    }
  // Implementing Fisher–Yates shuffle
  static void shuffleArray(int[] ar)
  {
    // If running on Java 6 or older, use `new Random()` on RHS here
    Random rnd = ThreadLocalRandom.current();
    for (int i = ar.length - 1; i > 0; i--)
    {
      int index = rnd.nextInt(i + 1);
      // Simple swap
      int a = ar[index];
      ar[index] = ar[i];
      ar[i] = a;
    }
  }
    
     public void RespostaCerta(String resp) {

         if (q.rcerta == resp)
            JOptionPane.showMessageDialog(null,"Certo!!!" ,"Alerta",JOptionPane.ERROR_MESSAGE);
         else
            JOptionPane.showMessageDialog(null,"Errado, a resposta certa seria: "+q.rcerta ,"Alerta",JOptionPane.ERROR_MESSAGE);   
         q.slide++;
         if (q.slide > 10)
             q.slide = 1;
         lblSlides.setText("Slide "+q.slide+" de 10");
     }
     
     
    public void distribuir(){
        String cat;

        String foto1 = q.registos.get(posicoes[0]);
        String foto2 = q.registos.get(posicoes[1]);
        String foto3 = q.registos.get(posicoes[2]);
        String foto4 = q.registos.get(posicoes[3]);
        String foto5 = q.registos.get(posicoes[4]);
        String foto6 = q.registos.get(posicoes[5]);
        
        if (q.language == 2){
            foto1 = q.registos2.get(posicoes[0]);
            foto2 = q.registos2.get(posicoes[1]);
            foto3 = q.registos2.get(posicoes[2]);
            foto4 = q.registos2.get(posicoes[3]);
            foto5 = q.registos2.get(posicoes[4]);
            foto6 = q.registos2.get(posicoes[5]);            
        }
        
        //para testar   
        String caminho = "..\\quiz-cencal3\\src\\media\\"; 
        
        //para o jar
        //String caminho = "..\\src\\media\\"; 
        System.out.println("foto: "+caminho);
        
        if (q.category == 1)
            cat = "colors";
        else if (q.category == 2)
            cat = "animals";
        else 
            cat = "body";            

        
        lbl1.setIcon(new ImageIcon(caminho+cat+"\\"+foto1+".jpg"));
        lbl2.setIcon(new ImageIcon(caminho+cat+"\\"+foto2+".jpg"));
        lbl3.setIcon(new ImageIcon(caminho+cat+"\\"+foto3+".jpg"));
        lbl4.setIcon(new ImageIcon(caminho+cat+"\\"+foto4+".jpg"));
        lbl5.setIcon(new ImageIcon(caminho+cat+"\\"+foto5+".jpg"));
        lbl6.setIcon(new ImageIcon(caminho+cat+"\\"+foto6+".jpg"));

        lbl1.setText(foto1);
        lbl2.setText(foto2);
        lbl3.setText(foto3);
        lbl4.setText(foto4);
        lbl5.setText(foto5);
        lbl6.setText(foto6);
/*
System.out.println("----------- lbl1: "+lbl1.getText());
System.out.println("----------- lbl2: "+lbl2.getText());
System.out.println("----------- lbl3: "+lbl3.getText());
System.out.println("----------- lbl4: "+lbl4.getText());
System.out.println("----------- lbl5: "+lbl5.getText());
System.out.println("----------- lbl6: "+lbl6.getText());
   */     
System.out.println(caminho+cat+"\\"+foto6+".jpg");
          
        
        q.rcerta = q.registos.get(0);
        q.registos.remove(0);
        q.registos.add(q.rcerta);
        System.out.println(q.registos);
        System.out.println("resposta certa: "+q.rcerta);
        
    }
    
    public SecondaryMenu() {
        initComponents();
        this.setSize(700,540);
        this.setLocationRelativeTo(null);
        
        LigaBD liga = new LigaBD();
        //System.out.println("iniciou o segundo form\nCategory: "+q.category+"\nLanguage: "+q.language);
        
        boolean retorno = liga.pesquisa();
        System.out.println("retorno -"+retorno);
        

        
        System.out.println(q.registos);
        System.out.println("numero de registos: "+q.registos.size());  
        posicao();
        distribuir();
        lblSlides.setText("Slide "+q.slide+" de 10");

        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblRonda = new javax.swing.JLabel();
        lblSlides = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        lbl1 = new javax.swing.JLabel();
        lbl6 = new javax.swing.JLabel();
        lbl4 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        lbl3 = new javax.swing.JLabel();
        lbl5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRonda.setText("Ronda 1");

        lblSlides.setText("Slide 1 de 10");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSlides)
                    .addComponent(lblRonda))
                .addGap(101, 101, 101))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRonda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSlides, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(259, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 30, -1, 350));

        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 400, 145, 40));

        lbl1.setIcon(new javax.swing.ImageIcon("C:\\Users\\sfaustino\\Downloads\\ball-red.png")); // NOI18N
        lbl1.setText("jLabel1");
        lbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl1MouseClicked(evt);
            }
        });
        getContentPane().add(lbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 30, 150, 133));

        lbl6.setIcon(new javax.swing.ImageIcon("C:\\Users\\sfaustino\\Downloads\\ball-orange.png")); // NOI18N
        lbl6.setText("jLabel1");
        lbl6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl6MouseClicked(evt);
            }
        });
        getContentPane().add(lbl6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 150, 141));

        lbl4.setIcon(new javax.swing.ImageIcon("C:\\Users\\sfaustino\\Downloads\\ball-green.png")); // NOI18N
        lbl4.setText("jLabel1");
        lbl4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl4MouseClicked(evt);
            }
        });
        getContentPane().add(lbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 150, 141));

        lbl2.setIcon(new javax.swing.ImageIcon("C:\\Users\\sfaustino\\Downloads\\ball-blue.png")); // NOI18N
        lbl2.setText("jLabel1");
        lbl2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl2MouseClicked(evt);
            }
        });
        getContentPane().add(lbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 30, 150, 133));

        lbl3.setIcon(new javax.swing.ImageIcon("C:\\Users\\sfaustino\\Downloads\\ball-brown.png")); // NOI18N
        lbl3.setText("jLabel1");
        lbl3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl3MouseClicked(evt);
            }
        });
        getContentPane().add(lbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 150, 141));

        lbl5.setIcon(new javax.swing.ImageIcon("C:\\Users\\sfaustino\\Downloads\\ball-yellow.png")); // NOI18N
        lbl5.setText("jLabel1");
        lbl5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl5MouseClicked(evt);
            }
        });
        getContentPane().add(lbl5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 150, 141));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        MainMenu m = new MainMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void lbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl1MouseClicked
        System.out.println("teste de click");

        RespostaCerta(lbl1.getText());
        
    }//GEN-LAST:event_lbl1MouseClicked

    private void lbl2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl2MouseClicked
        RespostaCerta(lbl2.getText());
    }//GEN-LAST:event_lbl2MouseClicked

    private void lbl3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl3MouseClicked
        RespostaCerta(lbl3.getText());

    }//GEN-LAST:event_lbl3MouseClicked

    private void lbl4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl4MouseClicked
        RespostaCerta(lbl4.getText());
    }//GEN-LAST:event_lbl4MouseClicked

    private void lbl5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl5MouseClicked
        RespostaCerta(lbl5.getText());

    }//GEN-LAST:event_lbl5MouseClicked

    private void lbl6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl6MouseClicked
        RespostaCerta(lbl6.getText());
    }//GEN-LAST:event_lbl6MouseClicked

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
            java.util.logging.Logger.getLogger(SecondaryMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SecondaryMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SecondaryMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SecondaryMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SecondaryMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JLabel lbl4;
    private javax.swing.JLabel lbl5;
    private javax.swing.JLabel lbl6;
    private javax.swing.JLabel lblRonda;
    private javax.swing.JLabel lblSlides;
    // End of variables declaration//GEN-END:variables
}
