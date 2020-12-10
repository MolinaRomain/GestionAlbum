

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *  <b> Cette classe permet d'ajouter un album dans la base de données</b>
 *  @author     BOUHENAF Irfan et MOLINA Romain
 */
public class FormulaireAjout extends Formulaire{

    /**
     * La fenêtre principale
     */
    private final Fenetre parent;
    
    /**
     * Créer une nouvelle instance de la classe FormulaireAjout
     *
     * @param      parent_  La fenêtre principale
     * @param      modal    Permet de savoir si le formulaire est modale ou non
     */
    public FormulaireAjout(final Fenetre parent_, boolean modal) {
        super(parent_,modal);
        parent = parent_;
        initComponents();
        panel_principal.setLayout(null);
        Insets position = panel_principal.getInsets();
        panel_principal.add(t_titre);
        t_titre.setBounds(250,position.top + 25,t_titre.getPreferredSize().width,t_titre.getPreferredSize().height );
        panel_principal.add(t_auteur);
        t_auteur.setBounds(250,position.top + 55,t_auteur.getPreferredSize().width,t_auteur.getPreferredSize().height );
        panel_principal.add(t_date);
        t_date.setBounds(250,85,t_date.getPreferredSize().width,t_date.getPreferredSize().height );
        panel_principal.add(b_genre);
        b_genre.setBounds(250,125,b_genre.getPreferredSize().width,b_genre.getPreferredSize().height );
        panel_principal.add(t_lien);
        t_lien.setBounds(250,165,t_lien.getPreferredSize().width,t_lien.getPreferredSize().height );
        panel_principal.add(t_lien_image);
        t_lien_image.setBounds(250,205,t_lien_image.getPreferredSize().width,t_lien.getPreferredSize().height );
        setLocationRelativeTo(parent);
        setVisible(true);
        pack();
    }
   
    /**
     * Cette fonction surchargée permet de savoir si des champs sont valides ou non
     *
     * @return  un booléen permettant de savoir si les champs sont valides ou non
     */
    @Override
    public boolean champsvalides()
    {
        boolean valide = true;
        if (t_titre.getText().isEmpty())
        {
            valide = false;
            t_titre.setBackground(Color.red);
        }
        if (t_auteur.getText().isEmpty())
        {
            valide = false;
            t_auteur.setBackground(Color.red);
        }
        if (t_date.getText().isEmpty())
        {
            valide = false;
            t_date.setBackground(Color.red);
        }
        else
        {
            try 
            {
                if ((Integer.parseInt(t_date.getText()) > Integer.parseInt(this.dateactuelle) || (Integer.parseInt(t_date.getText()) < 0)))
                {
                     valide = false;
                     t_date.setBackground(Color.red);
                }
            }
            catch(NumberFormatException e)
            {
                valide = false;
                t_date.setBackground(Color.red);
            }
        }
        if ((!t_lien.getText().isEmpty()) && (!t_lien.getText().contains("https://www.youtube.com")))
        {
            valide = false;
            t_lien.setBackground(Color.red);
        }
        if (!t_lien_image.getText().isEmpty())
        {
            try
            {
                ImageIO.read(new URL(t_lien_image.getText()));
            }
            catch (IOException e) 
            {
                valide = false;
                t_lien_image.setBackground(Color.red);
            }
        }
        return valide;
    }
  
    /**
     * Cette fonction est génrée par NetBeans et permet d'instancer les composants crée par l'IDE
     *
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_principal = new javax.swing.JPanel();
        l_titre = new javax.swing.JLabel();
        l_auteur = new javax.swing.JLabel();
        l_date = new javax.swing.JLabel();
        l_genre = new javax.swing.JLabel();
        l_lien = new javax.swing.JLabel();
        l_champ = new javax.swing.JLabel();
        b_valider = new javax.swing.JButton();
        l_lien_image = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Saisissez les informations");
        setAlwaysOnTop(true);
        setResizable(false);

        panel_principal.setBackground(new java.awt.Color(103, 103, 103));
        panel_principal.setPreferredSize(new java.awt.Dimension(485, 320));
        panel_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        l_titre.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        l_titre.setForeground(new java.awt.Color(255, 255, 255));
        l_titre.setText("*Titre    ");
        panel_principal.add(l_titre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, 60, -1));

        l_auteur.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        l_auteur.setForeground(new java.awt.Color(255, 255, 255));
        l_auteur.setText("*Auteur ");
        panel_principal.add(l_auteur, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 60, -1));

        l_date.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        l_date.setForeground(new java.awt.Color(255, 255, 255));
        l_date.setText("*Année");
        panel_principal.add(l_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 50, -1));

        l_genre.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        l_genre.setForeground(new java.awt.Color(255, 255, 255));
        l_genre.setText("*Genre  ");
        panel_principal.add(l_genre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 60, -1));

        l_lien.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        l_lien.setForeground(new java.awt.Color(255, 255, 255));
        l_lien.setText("Lien YouTube     ");
        panel_principal.add(l_lien, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 110, -1));

        l_champ.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        l_champ.setForeground(new java.awt.Color(255, 255, 255));
        l_champ.setText("*Champs obligatoires");
        panel_principal.add(l_champ, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 150, -1));

        b_valider.setBackground(new java.awt.Color(255, 255, 255));
        b_valider.setText("Valider");
        b_valider.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b_valider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_validerActionPerformed(evt);
            }
        });
        panel_principal.add(b_valider, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 125, 25));

        l_lien_image.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        l_lien_image.setForeground(new java.awt.Color(255, 255, 255));
        l_lien_image.setText("Lien Image");
        panel_principal.add(l_lien_image, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cette fonction est exécuter quand on appuie sur le bouton "Valider" du formulaire
     * <p> Elle ajoute les données d'un album dans la base de données
     * </p>
     *
     * @param      evt   L'évenement utilisateur
     */
    private void b_validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_validerActionPerformed
        if (!champsvalides())
        {
            JOptionPane.showMessageDialog(this,"Des champs sont incorrects","Erreur",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            if (parent.getBDD().verifAuteurTitre(t_titre.getText(),t_auteur.getText(),parent.getDonnees().getPseudo()))
            {
                JOptionPane.showMessageDialog(this,"L'album " + t_titre.getText() + " de " + t_auteur.getText() + " existe déjà dans la base de données !","Erreur",JOptionPane.ERROR_MESSAGE);
            }
            else
            { 
                parent.ajouterdansBDD(t_titre.getText(),t_auteur.getText(),Integer.parseInt(t_date.getText()),b_genre.getSelectedItem().toString(),t_lien.getText(),t_lien_image.getText());
                dispose();
            }
        }
        
    }//GEN-LAST:event_b_validerActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_valider;
    private javax.swing.JLabel l_auteur;
    private javax.swing.JLabel l_champ;
    private javax.swing.JLabel l_date;
    private javax.swing.JLabel l_genre;
    private javax.swing.JLabel l_lien;
    private javax.swing.JLabel l_lien_image;
    private javax.swing.JLabel l_titre;
    private javax.swing.JPanel panel_principal;
    // End of variables declaration//GEN-END:variables
}
