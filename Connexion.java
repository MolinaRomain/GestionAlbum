
import java.awt.event.*;
import javax.swing.*;
/**
 *  <b> Cette classe permet de faire le formulaire pour se connecter </b>
 *  @author     BOUHENAF Irfan et MOLINA Romain
 */
public class Connexion extends JDialog implements WindowListener {

    /**
     * La fenetre principale
     */
    private final Fenetre parent;
    
    /**
     * Construit une nouvelle instance de la classe Connexion
     *
     * @param      parent_  La fenêtre principale
     * @param      modal    Permet de savoir si le formulaire est modale ou non
     */
    public Connexion(final Fenetre parent_, boolean modal) {
        super(parent_, modal);
        parent = parent_;
        initComponents();
        this.addWindowListener(this);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(parent);
        setVisible(true);
        
    }
   
    /**
     * Cette fonction est déclenchée quand la fenetre se ferme à l'aide de la fonction dispose
     *
     * @param      e     Evenement de la fenetre
     */
    public void windowClosing(WindowEvent e)
    {
        System.exit(0);
    }
    
    /**
     * Cette fonction est déclenchée quand la fenetre se ferme
     *
     * @param      e     Evenement de la fenetre
     */
    public void windowClosed(WindowEvent e)
    {}
    
    /**
     * Cette fonction est déclenchée quand la fenetre s'ouvre
     *
     * @param      e     Evenement de la fenetre
     */
    public void windowOpened(WindowEvent e)
    {}
    
    /**
     * Cette fonction est déclenchée quand la fenetre est réduite
     *
     * @param      e     Evenement de la fenetre
     */
    public void windowIconified(WindowEvent e)
    {}
    
    /**
     * Cette fonction est déclenchée quand la fenetre n'est plus réduite
     *
     * @param      e     Evenement de la fenetre
     */
    public void windowDeiconified(WindowEvent e)
    {}
    
    /**
     * Cette fonction est déclenchée quand la fenetre est active
     *
     * @param      e     Evenement de la fenetre
     */
    public void windowActivated(WindowEvent e)
    {}
    
    /**
     * Cette fonction est déclenchée quand la fenetre est inactive
     *
     * @param      e     Evenement de la fenetre}
     */
    public void windowDeactivated(WindowEvent e)
    {}
    
    /**
     * Cette fonction est génrée par NetBeans et permet d'instancer les composants crée par l'IDE
     *
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principal = new javax.swing.JPanel();
        l_connexion = new javax.swing.JLabel();
        t_nom = new javax.swing.JTextField();
        b_connexion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Se connecter");
        setAlwaysOnTop(true);
        setResizable(false);

        principal.setBackground(new java.awt.Color(103, 103, 103));

        l_connexion.setFont(new java.awt.Font("Bahnschrift", 0, 24)); // NOI18N
        l_connexion.setForeground(new java.awt.Color(255, 255, 255));
        l_connexion.setText("Connexion");

        t_nom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                t_nomKeyTyped(evt);
            }
        });

        b_connexion.setBackground(new java.awt.Color(255, 255, 255));
        b_connexion.setText("Se Connecter");
        b_connexion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b_connexion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_connexion.setEnabled(false);
        b_connexion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_connexionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout principalLayout = new javax.swing.GroupLayout(principal);
        principal.setLayout(principalLayout);
        principalLayout.setHorizontalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalLayout.createSequentialGroup()
                .addGroup(principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(principalLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(l_connexion))
                    .addGroup(principalLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(b_connexion, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(principalLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(t_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        principalLayout.setVerticalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(l_connexion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(t_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(b_connexion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    /**
     * Cette fonction est exécuté quand on appuie sur le bouton de connexion
     * <p> Cette fonction insère le nom dans la bdd, elle envoie le pseudo à la fenêtre. Si l'utilisateur est dans la base, on le selectionne, si non on le crée </p>
     *
     * @param      evt   L'évènement utilisateur
     */
    private void b_connexionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_connexionActionPerformed

        parent.getDonnees().setPseudo(t_nom.getText());
        
        if (parent.getBDD().verifNomUtilisateur(parent.getDonnees().getPseudo()))
        {
            int choix = JOptionPane.showConfirmDialog(this,"Le pseudo " + parent.getDonnees().getPseudo() + " existe déjà dans la base de données, voulez-vous continuer","Question",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if( choix == JOptionPane.YES_OPTION )
            {
                    parent.setPseudo(parent.getDonnees().getPseudo());
                    dispose();
            }
            
        }
        else
        {
            parent.getBDD().ajouterUtilisateur(parent.getDonnees().getPseudo());
            parent.setPseudo(parent.getDonnees().getPseudo());
            dispose();
        }
        
    }//GEN-LAST:event_b_connexionActionPerformed

    private void t_nomKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_t_nomKeyTyped
        b_connexion.setEnabled( t_nom.getText().isEmpty() ? false : true );
    }//GEN-LAST:event_t_nomKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_connexion;
    private javax.swing.JLabel l_connexion;
    private javax.swing.JPanel principal;
    private javax.swing.JTextField t_nom;
    // End of variables declaration//GEN-END:variables
}
