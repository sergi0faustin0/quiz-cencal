
import java.awt.Color;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;


/**
 *
 * @authors luna, aduarte e sfaustino
 */


public class SecondaryMenu extends javax.swing.JFrame {
        long start = System.currentTimeMillis();
       // System.out.println(System.currentTimeMillis());
        int timeElapsed;
        
        
        
        LigaBD liga = new LigaBD();
        int[] posicoes = { 0, 1, 2, 3, 4, 5 };
        QuizCencal q = new QuizCencal();
        
        //define cor das bordas
        Border borderc = BorderFactory.createLineBorder(Color.GREEN, 5);      
        Border bordere = BorderFactory.createLineBorder(Color.RED, 5);      
        Border bordereset = BorderFactory.createLineBorder(Color.GRAY, 0); 
        
        //caminho para testar   
      //  String caminho = "..\\quiz-cencal\\src\\media\\";         
        String caminho = "..\\quiz-cencal\\src\\media\\";     
        //define Categoria
        String cat; 
        
        //define idioma
        String idioma;
        
        // linha necessária para o som funcionar
        final JFXPanel fxPanel = new JFXPanel();
        
    public void ronda(){
        
        baralhaArray(posicoes);
        distribuir();
        lblSlides.setText("Slide "+q.slide+" de 10");
         
        som();              
    }
    
  // Implementing Fisher–Yates shuffle
    static void baralhaArray(int[] ar){
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.length - 1; i > 0; i--){
          int index = rnd.nextInt(i + 1);
          // Simple swap
          int a = ar[index];
          ar[index] = ar[i];
          ar[i] = a;
        }
    }

     public void ResetBorder() {
        btn1.setBorder(bordereset);
        btn2.setBorder(bordereset);
        btn3.setBorder(bordereset);
        btn4.setBorder(bordereset);
        btn5.setBorder(bordereset);
        btn6.setBorder(bordereset);
    

     }
    
     public boolean RespostaCerta(String resp) {
        System.out.println("resp: "+resp);
        System.out.println("q.rcerta: "+q.rcerta);
        System.out.println("q.rcerta2: "+q.rcerta2);

         if (q.rcerta == resp || q.rcerta2 == resp){
            q.slide++;
            if (q.errada == false)
                q.score=q.score+1;
            q.errada = false;  
            if (q.slide > 10){
                timeElapsed = (int)(System.currentTimeMillis()-start)/60;
                System.out.println(start+"\ntimeElapsed: "+timeElapsed);
                if (timeElapsed < 31)
                    q.score=q.score+30-timeElapsed;
                    
                //JOptionPane.showMessageDialog(null,"Total desta Ronda: "+q.score+" Pts","Alerta",JOptionPane.INFORMATION_MESSAGE);
                q.ronda++;                
                lblRonda.setText("Ronda: "+q.ronda);
                System.out.println("Ronda: "+q.ronda+"\nlblRonda: "+lblRonda.getText());
                q.slide = 1;  
                Register r = new Register();
                r.setVisible(true);
                this.setVisible(false);  
            } else {
                ronda();
            }
            top5();
            lblSlides.setText("Slide "+q.slide+" de 10");
  
            lblScore.setText("Score: "+q.score+" Pts");
            start = System.currentTimeMillis();
            
            return true;
         }
         else{
            q.errada = true;
            return false;
         }             
     }
     
    public void som(){
           
        if (q.language == 1)
            idioma="english";
        else
            idioma="esperanto";   

        String path = caminho+cat+idioma+"\\"+q.rcerta+".mp3";
        //System.out.println("audio path: "+path); 
        String uriString = new File(path).toURI().toString();
        Media pick = new Media(uriString);        
        MediaPlayer player = new MediaPlayer(pick); 
        
        player.play();     
        
        
    }     
    
    public void distribuir(){
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
        

        if (q.category == 1)
            cat = "colors\\";
        else if (q.category == 2)
            cat = "animals\\";
        else if (q.category == 3)
            cat = "body\\";
        else 
            cat = "fruits\\";            

        
        btn1.setIcon(new ImageIcon(caminho+cat+foto1+".jpg"));
        btn2.setIcon(new ImageIcon(caminho+cat+foto2+".jpg"));
        btn3.setIcon(new ImageIcon(caminho+cat+foto3+".jpg"));
        btn4.setIcon(new ImageIcon(caminho+cat+foto4+".jpg"));
        btn5.setIcon(new ImageIcon(caminho+cat+foto5+".jpg"));
        btn6.setIcon(new ImageIcon(caminho+cat+foto6+".jpg"));

        btn1.setText(q.registos.get(posicoes[0]));
        btn2.setText(q.registos.get(posicoes[1]));
        btn3.setText(q.registos.get(posicoes[2]));
        btn4.setText(q.registos.get(posicoes[3]));
        btn5.setText(q.registos.get(posicoes[4]));
        btn6.setText(q.registos.get(posicoes[5]));

        if (q.language == 2){
            btn1.setText(q.registos2.get(posicoes[0]));
            btn2.setText(q.registos2.get(posicoes[1]));
            btn3.setText(q.registos2.get(posicoes[2]));
            btn4.setText(q.registos2.get(posicoes[3]));
            btn5.setText(q.registos2.get(posicoes[4]));
            btn6.setText(q.registos2.get(posicoes[5]));           
        }        
        
        q.rcerta = q.registos.get(0);

        if (q.language == 2){
            q.rcerta2 = q.registos2.get(0);        
            q.registos2.remove(0);
            q.registos2.add(q.rcerta2);              
        }
        
        q.registos.remove(0);
        q.registos.add(q.rcerta);
       
    }
    
    public void top5(){
        liga.top5();
 
        if (!q.top5.get(0).isEmpty())
            lbltop1.setText(q.top5.get(0));
        if (!q.top5.get(1).isEmpty())
            lbltop2.setText(q.top5.get(1));
        if (!q.top5.get(2).isEmpty())
            lbltop3.setText(q.top5.get(2));
        if (!q.top5.get(3).isEmpty())
            lbltop4.setText(q.top5.get(3));
        if (!q.top5.get(4).isEmpty())
            lbltop5.setText(q.top5.get(4));



    }    
    
    public SecondaryMenu() {
        
        initComponents();
        this.setSize(700,540);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground( Color.white );
        btnSpeaker.setBackground( Color.white );
        btnMenu.setBackground( Color.white );
        jPanel1.setBackground( Color.white );
        lblRonda.setText("Ronda: "+q.ronda);
        //boolean retorno = liga.pesquisa();
       top5();
       
       // top5();
       try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SecondaryMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        ronda();
        //som();
     }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblRonda = new javax.swing.JLabel();
        lblSlides = new javax.swing.JLabel();
        lblScore = new javax.swing.JLabel();
        lbltop1 = new javax.swing.JLabel();
        lbltop2 = new javax.swing.JLabel();
        lbltop3 = new javax.swing.JLabel();
        lbltop4 = new javax.swing.JLabel();
        lbltop5 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btnSpeaker = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aprender a Jogar");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRonda.setFont(new java.awt.Font("Kristen ITC", 1, 14)); // NOI18N
        lblRonda.setText("teste");
        jPanel1.add(lblRonda, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 56, -1, 30));

        lblSlides.setFont(new java.awt.Font("Kristen ITC", 1, 18)); // NOI18N
        lblSlides.setText("Slide 1 de 10");
        jPanel1.add(lblSlides, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 92, -1, 30));

        lblScore.setFont(new java.awt.Font("Kristen ITC", 1, 24)); // NOI18N
        lblScore.setText("Score");
        jPanel1.add(lblScore, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, 30));

        lbltop1.setText("11 pts -> Luna");
        jPanel1.add(lbltop1, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 140, -1, 30));

        lbltop2.setText("11 pts -> Luna");
        jPanel1.add(lbltop2, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 176, -1, 30));

        lbltop3.setText("11 pts -> Luna");
        jPanel1.add(lbltop3, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 212, -1, 30));

        lbltop4.setText("11 pts -> Luna");
        jPanel1.add(lbltop4, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 248, -1, 30));

        lbltop5.setText("11 pts -> Luna");
        jPanel1.add(lbltop5, new org.netbeans.lib.awtextra.AbsoluteConstraints(94, 284, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 30, 270, -1));

        btnMenu.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 390, 110, 70));

        btn6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        getContentPane().add(btn6, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 328, 140, 140));

        btn1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });
        getContentPane().add(btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 30, 140, 140));

        btn2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });
        getContentPane().add(btn2, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 30, 140, 140));

        btn3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });
        getContentPane().add(btn3, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 176, 140, 140));

        btn4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });
        getContentPane().add(btn4, new org.netbeans.lib.awtextra.AbsoluteConstraints(202, 176, 140, 140));

        btn5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });
        getContentPane().add(btn5, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 328, 140, 140));

        btnSpeaker.setForeground(new java.awt.Color(255, 255, 255));
        btnSpeaker.setIcon(new javax.swing.ImageIcon(getClass().getResource("/speaker.jpg"))); // NOI18N
        btnSpeaker.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpeakerActionPerformed(evt);
            }
        });
        getContentPane().add(btnSpeaker, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 390, 110, 70));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        MainMenu m = new MainMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        boolean r = RespostaCerta(btn1.getText());
        if (r == true){
            ResetBorder();

        }else
        btn1.setBorder(bordere);
    }//GEN-LAST:event_btn1ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        boolean r = RespostaCerta(btn6.getText());
        if (r == true){
            ResetBorder();
        }
        else
        btn6.setBorder(bordere);
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed

        boolean r = RespostaCerta(btn3.getText());
        if (r == true){
            ResetBorder();
        }
        else
        btn3.setBorder(bordere);

    }//GEN-LAST:event_btn3ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        boolean r = RespostaCerta(btn2.getText());
        if (r == true){
            ResetBorder();
        }
        else
        btn2.setBorder(bordere);
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        boolean r = RespostaCerta(btn4.getText());
        if (r == true){
            ResetBorder();
        }
        else
        btn4.setBorder(bordere);
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        boolean r = RespostaCerta(btn5.getText());
        if (r == true){
            ResetBorder();
        }
        else
        btn5.setBorder(bordere);
    }//GEN-LAST:event_btn5ActionPerformed

    private void btnSpeakerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpeakerActionPerformed
        som();   
    }//GEN-LAST:event_btnSpeakerActionPerformed

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
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnSpeaker;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblRonda;
    private javax.swing.JLabel lblScore;
    private javax.swing.JLabel lblSlides;
    private javax.swing.JLabel lbltop1;
    private javax.swing.JLabel lbltop2;
    private javax.swing.JLabel lbltop3;
    private javax.swing.JLabel lbltop4;
    private javax.swing.JLabel lbltop5;
    // End of variables declaration//GEN-END:variables
}
