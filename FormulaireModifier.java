
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *  <b> Cette classe permet de modifier une album à l'aide d'un formulaire </b>
 *  @author     BOUHENAF Irfan et MOLINA Romain
 */
public class FormulaireModifier extends Formulaire{

    /**
     * L'album à modifier
     */
    private final LigneAlbum panelparent;
    
    /**
     * La fenêtre principale
     */
    private final Fenetre parent;
    
    /**
     * Construit une nouvelle instance de la classe FormulaireModifier
     *
     * @param      parent_       La fenêtre principale
     * @param      modal         Permet de savoir si le formulaire est modale ou non
     * @param      panelparent_  L'album à modifier
     */
    public FormulaireModifier(final Fenetre parent_, boolean modal,final LigneAlbum panelparent_) {
        super(parent_, modal);
        parent = parent_;
        panelparent = panelparent_;
        initComponents();
        panel_principal.setLayout(null);
        
        Insets position = panel_principal.getInsets();
        panel_principal.add(t_titre);
        t_titre.setBounds(200,position.top + 20,t_titre.getPreferredSize().width,t_titre.getPreferredSize().height );
        panel_principal.add(t_auteur);
        t_auteur.setBounds(200,position.top + 65,t_auteur.getPreferredSize().width,t_auteur.getPreferredSize().height );
        panel_principal.add(t_date);
        t_date.setBounds(200,105,t_date.getPreferredSize().width,t_date.getPreferredSize().height );
        panel_principal.add(b_genre);
        b_genre.setBounds(200,150,b_genre.getPreferredSize().width,b_genre.getPreferredSize().height );
        panel_principal.add(t_lien);
        t_lien.setBounds(200,195,t_lien.getPreferredSize().width,t_lien.getPreferredSize().height );
        panel_principal.add(t_lien_image);
        t_lien_image.setBounds(200,240,t_lien_image.getPreferredSize().width,t_lien_image.getPreferredSize().height );
        t_auteur.setEnabled(false);
        t_titre.setEnabled(false);
        t_date.setEnabled(false);
        b_genre.setEnabled(false);
        t_lien.setEnabled(false);
        t_lien_image.setEnabled(false);       
        setLocationRelativeTo(parent);
        setVisible(true);
        pack();
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
        c_titre = new javax.swing.JCheckBox();
        c_auteur = new javax.swing.JCheckBox();
        c_date = new javax.swing.JCheckBox();
        c_genre = new javax.swing.JCheckBox();
        b_valider = new javax.swing.JButton();
        c_lien = new javax.swing.JCheckBox();
        c_lien_image = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modifier");
        setResizable(false);

        panel_principal.setBackground(new java.awt.Color(103, 103, 103));
        panel_principal.setPreferredSize(new java.awt.Dimension(385, 300));

        c_titre.setText("Titre");
        c_titre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_titreActionPerformed(evt);
            }
        });

        c_auteur.setText("Auteur");
        c_auteur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_auteurActionPerformed(evt);
            }
        });

        c_date.setText("Année");
        c_date.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_dateActionPerformed(evt);
            }
        });

        c_genre.setText("Genre");
        c_genre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_genreActionPerformed(evt);
            }
        });

        b_valider.setBackground(new java.awt.Color(255, 255, 255));
        b_valider.setText("Valider");
        b_valider.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b_valider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_validerActionPerformed(evt);
            }
        });

        c_lien.setText("Lien YouTube");
        c_lien.setToolTipText("");
        c_lien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_lienActionPerformed(evt);
            }
        });

        c_lien_image.setText("Lien Image");
        c_lien_image.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c_lien_imageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel_principalLayout = new javax.swing.GroupLayout(panel_principal);
        panel_principal.setLayout(panel_principalLayout);
        panel_principalLayout.setHorizontalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(c_titre, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(c_auteur, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(c_date, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(c_genre, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(b_valider, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel_principalLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(c_lien_image, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c_lien, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(135, 135, 135))
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(c_titre)
                .addGap(19, 19, 19)
                .addComponent(c_auteur)
                .addGap(19, 19, 19)
                .addComponent(c_date)
                .addGap(19, 19, 19)
                .addComponent(c_genre)
                .addGap(19, 19, 19)
                .addComponent(c_lien)
                .addGap(19, 19, 19)
                .addComponent(c_lien_image)
                .addGap(13, 13, 13)
                .addComponent(b_valider, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     *  Cette fonction décrit le fait de cocher une case faisant écrire dans la zone de texte
     *
     * @param      texte  La zone de texte
     * @param      evt    L'évenement utilisateur
     */
    public void ActionCocherTexte(JTextField texte, ActionEvent evt)
    {
        AbstractButton abstractButton = (AbstractButton) evt.getSource();
        texte.setEnabled(abstractButton.getModel().isSelected());
        texte.setBackground(Color.white);
        if(!texte.isEnabled())
            texte.setText("");
    }
    
    /**
     * Cette fonction décrit le fait de cocher une case permettant de modifier une ComboBox     
     *
     * @param      box   La ComboBox
     * @param      evt   L'évènement utilisateur
     */
    public void ActionCocherComboBox(JComboBox box, ActionEvent evt)
    {
        AbstractButton abstractButton = (AbstractButton) evt.getSource();
        box.setEnabled(abstractButton.getModel().isSelected());
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
        if (c_titre.isSelected())
        {
            if (t_titre.getText().isEmpty())
            {
                valide = false;
                t_titre.setBackground(Color.red);
            }
        }
        if (c_auteur.isSelected())
        {
            if (t_auteur.getText().isEmpty())
            {
                valide = false;
                t_auteur.setBackground(Color.red);
            }
        }
        if (c_date.isSelected())
        {
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
        }
        if (c_lien.isSelected())
        {
            if ((!t_lien.getText().isEmpty()) && (!t_lien.getText().contains("https://www.youtube.com")))
            {
                valide = false;
                t_lien.setBackground(Color.red);
            }
        }
        if (c_lien_image.isSelected())
        {
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
        }
        return valide;
    }
    
    /**
     * Cette fonction est exécuter quand on appuie sur le bouton "Valider" du formulaire
     * <p> Elle modifie les données d'un album dans la base de données mais aussi dans l'application 
     * </p>
     *
     * @param      evt   L'évenement utilisateur
     */
    private void b_validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_validerActionPerformed
        if(!champsvalides())
        {
            JOptionPane.showMessageDialog(this,"Des champs sont incorrects","Erreur",JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            if (parent.getBDD().verifAuteurTitre(t_titre.getText(),t_auteur.getText(),parent.getDonnees().getPseudo()))
            {
                JOptionPane.showMessageDialog(this,"L'album existe déjà dans la base de données !","Erreur",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                if(c_titre.isSelected())
                {                    
                    parent.modifier("titre",t_titre.getText(), panelparent.getDonnees().getTitre(), panelparent.getDonnees().getAuteur());
                    panelparent.getDonnees().setTitre(t_titre.getText());
                    panelparent.setTitre(panelparent.getDonnees().getTitre());
                }
                if(c_auteur.isSelected())
                {
                    parent.modifier("auteur",t_auteur.getText(), panelparent.getDonnees().getTitre(), panelparent.getDonnees().getAuteur());
                    panelparent.getDonnees().setAuteur(t_auteur.getText());
                    panelparent.setAuteur(panelparent.getDonnees().getAuteur());
                }
            }

            if(c_date.isSelected())
            {   
                parent.modifier("date",t_date.getText(), panelparent.getDonnees().getTitre(), panelparent.getDonnees().getAuteur());
                panelparent.getDonnees().setDate(Integer.parseInt(t_date.getText()));
                panelparent.setDate(panelparent.getDonnees().getDate());
            }

            if(c_genre.isSelected())
            {   
                parent.modifier("genre",b_genre.getSelectedItem().toString(), panelparent.getDonnees().getTitre(), panelparent.getDonnees().getAuteur());
                panelparent.getDonnees().setGenre(b_genre.getSelectedItem().toString());
                panelparent.setGenre(panelparent.getDonnees().getGenre());
            }            
            if(c_lien.isSelected())
            {   
                parent.modifier("lien",t_lien.getText(), panelparent.getDonnees().getTitre(), panelparent.getDonnees().getAuteur());
                panelparent.getDonnees().setLien(t_lien.getText());
                panelparent.setLien(panelparent.getDonnees().getLien());
            } 
            if(c_lien_image.isSelected())
            {   
                parent.modifier("lien_image",t_lien_image.getText(), panelparent.getDonnees().getTitre(), panelparent.getDonnees().getAuteur());
                panelparent.getDonnees().setLienImage(t_lien_image.getText());
                panelparent.setLienImage(panelparent.getDonnees().getLienImage());
            } 
            parent.consulter();   
            dispose();     
        }
        
    }//GEN-LAST:event_b_validerActionPerformed

    /**
     * Cette fonction s'exécute quand on coche/décoche la case pour le titre
     *
     * @param      evt   L'évènement utilisateur
     */
    private void c_titreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_titreActionPerformed
        ActionCocherTexte(t_titre, evt);
    }//GEN-LAST:event_c_titreActionPerformed

    /**
     * Cette fonction s'exécute quand on coche/décoche la case pour l'auteur
     *
     * @param      evt   L'évènement utilisateur
     */
    private void c_auteurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_auteurActionPerformed
        ActionCocherTexte(t_auteur, evt);
    }//GEN-LAST:event_c_auteurActionPerformed

    /**
     * Cette fonction s'exécute quand on coche/décoche la case pour la date
     *
     * @param      evt   L'évènement utilisateur
     */
    private void c_dateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_dateActionPerformed
        ActionCocherTexte(t_date, evt);
    }//GEN-LAST:event_c_dateActionPerformed

    /**
     * Cette fonction s'exécute quand on coche/décoche la case pour le genre
     *
     * @param      evt   l'évènement utilisateur
     */
    private void c_genreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_genreActionPerformed
        ActionCocherComboBox(b_genre,evt);
    }//GEN-LAST:event_c_genreActionPerformed

    /**
     * Cette fonction s'exécute quand on coche/décoche la case pour le lien youtube
     *
     * @param      evt   L'évènement utilisateur
     */
    private void c_lienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_lienActionPerformed
        ActionCocherTexte(t_lien, evt);
    }//GEN-LAST:event_c_lienActionPerformed

    private void c_lien_imageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c_lien_imageActionPerformed
        ActionCocherTexte(t_lien_image,evt);
    }//GEN-LAST:event_c_lien_imageActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_valider;
    private javax.swing.JCheckBox c_auteur;
    private javax.swing.JCheckBox c_date;
    private javax.swing.JCheckBox c_genre;
    private javax.swing.JCheckBox c_lien;
    private javax.swing.JCheckBox c_lien_image;
    private javax.swing.JCheckBox c_titre;
    private javax.swing.JPanel panel_principal;
    // End of variables declaration//GEN-END:variables
}
