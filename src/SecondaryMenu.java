
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aduarte
 */
public class SecondaryMenu extends javax.swing.JFrame {

    /**
     * Creates new form SecondaryMenu
     */
    
    public void distribuir(){
        String cat;
        QuizCencal q = new QuizCencal();
        String foto1 = q.registos.get(0);
        String foto2 = q.registos.get(1);
        String foto3 = q.registos.get(2);
        String foto4 = q.registos.get(3);
        String foto5 = q.registos.get(4);
        String foto6 = q.registos.get(5);
        
        if (q.language == 2){
            foto1 = q.registos2.get(0);
            foto2 = q.registos2.get(1);
            foto3 = q.registos2.get(2);
            foto4 = q.registos2.get(3);
            foto5 = q.registos2.get(4);
            foto6 = q.registos2.get(5);            
        }
        
        
        
        String caminho = "C:\\Users\\aduarte\\Documents\\NetBeansProjects\\quiz-cencal\\src\\media\\"; 
        System.out.println("foto: "+caminho);
        
        if (q.category == 1)
            cat = "colors";
        else if (q.category == 2)
            cat = "animals";
        else 
            cat = "body";            

        
        lblposicao1.setIcon(new ImageIcon(caminho+cat+"\\"+foto1+".jpg"));
        lblposicao2.setIcon(new ImageIcon(caminho+cat+"\\"+foto2+".jpg"));
        jLabel10.setIcon(new ImageIcon(caminho+cat+"\\"+foto3+".jpg"));
        jLabel8.setIcon(new ImageIcon(caminho+cat+"\\"+foto4+".jpg"));
        jLabel11.setIcon(new ImageIcon(caminho+cat+"\\"+foto5+".jpg"));
        jLabel7.setIcon(new ImageIcon(caminho+cat+"\\"+foto6+".jpg"));

System.out.println(caminho+cat+"\\"+foto6+".jpg");
          
        
        q.rcerta = q.registos.get(0);
        q.registos.remove(0);
        q.registos.add(q.rcerta);
        System.out.println(q.registos);
        
    }
    
    public SecondaryMenu() {
        initComponents();
        this.setSize(700,540);
        this.setLocationRelativeTo(null);
        
        LigaBD liga = new LigaBD();
        QuizCencal q = new QuizCencal();
        //System.out.println("iniciou o segundo form\nCategory: "+q.category+"\nLanguage: "+q.language);
        
        boolean retorno = liga.pesquisa();
        System.out.println("retorno -"+retorno);
        

        
        System.out.println(q.registos);
        System.out.println("numero de registos: "+q.registos.size());  
        distribuir();

        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblRonda = new javax.swing.JLabel();
        lblRonda1 = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        lblposicao1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblposicao2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblRonda.setText("Ronda 1");

        lblRonda1.setText("Slide 1 de 10");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRonda1)
                    .addComponent(lblRonda))
                .addGap(101, 101, 101))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblRonda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblRonda1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        lblposicao1.setIcon(new javax.swing.ImageIcon("C:\\Users\\sfaustino\\Downloads\\ball-red.png")); // NOI18N
        lblposicao1.setText("jLabel1");
        getContentPane().add(lblposicao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 30, 150, 133));

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\sfaustino\\Downloads\\ball-orange.png")); // NOI18N
        jLabel7.setText("jLabel1");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 150, 141));

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\sfaustino\\Downloads\\ball-green.png")); // NOI18N
        jLabel8.setText("jLabel1");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 150, 141));

        lblposicao2.setIcon(new javax.swing.ImageIcon("C:\\Users\\sfaustino\\Downloads\\ball-blue.png")); // NOI18N
        lblposicao2.setText("jLabel1");
        getContentPane().add(lblposicao2, new org.netbeans.lib.awtextra.AbsoluteConstraints(214, 30, 150, 133));

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\sfaustino\\Downloads\\ball-brown.png")); // NOI18N
        jLabel10.setText("jLabel1");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 150, 141));

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\sfaustino\\Downloads\\ball-yellow.png")); // NOI18N
        jLabel11.setText("jLabel1");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 150, 141));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        MainMenu m = new MainMenu();
        m.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed

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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblRonda;
    private javax.swing.JLabel lblRonda1;
    private javax.swing.JLabel lblposicao1;
    private javax.swing.JLabel lblposicao2;
    // End of variables declaration//GEN-END:variables
}
