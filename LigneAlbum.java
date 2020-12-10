
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import java.net.*;
import java.io.*;
import javax.imageio.*;
/**
 * <b> Cette classe  représente un album de musique </b>
 * @author     BOUHENAF Irfan et MOLINA Romain
 *
 */
public class LigneAlbum extends JPanel {

    /**
     * La fenêtre principale
     */
    private final Fenetre fenetreparente;
    
    /**
     * Un formulaire qui modifie l'album
     */ 
    private FormulaireModifier modif;
    
    /**
     * Les données de l'album
     */
    private DonneeAlbum donnees;
    
    /**
     * Image de l'album
     */
    private BufferedImage image;
    
    /**
     * Construit une nouvelle instance de "LigneAlbum"
     *
     * @param      fenetreparente_  La fenetre principale
     */
    public LigneAlbum(final Fenetre fenetreparente_) 
    {
        initComponents();
        fenetreparente = fenetreparente_;   
        donnees = new DonneeAlbum();
    }

    public DonneeAlbum getDonnees()
    {
        return donnees;
    }
        
    /**
     * Change le JLabel contant le titre
     *
     * @param      titre  Le titre à changer
     */
    public void setTitre(String titre) 
    { 
        l_titre.setText(titre);
    }
    
    /**
     * Change le JLabel contant l'auteur
     *
     * @param      auteur  L'auteur à changer
     */
    public void setAuteur(String auteur) 
    { 
        l_auteur.setText(auteur);
    }
    
    /**
     * Change le JLabel contant la date
     *
     * @param      date  La date à changer
     */
    public void setDate(int date) 
    { 
        l_date.setText(String.valueOf(date));
    }
    
    /**
     * Change le JLabel contenant le genre
     *
     * @param      genre  Le genre à changer
     */
    public void setGenre (String genre) 
    { 
        l_genre.setText(genre);
    }
    
    /**
     * Change le lien de l'album et vérifie si ce lien est vide
     *
     * @param     lien Le lien à changer
     */
    public void setLien (String lien) 
    { 
        if (lien.isEmpty())
            b_ouvrir.setEnabled(false);   
    }
    
    /**
     * Change le lien de l'image et vérifie si ce lien est vide
     *
     * @param     lien_image Le lien à changer
     */
    public void setLienImage (String lien_image) 
    { 
        if (!lien_image.isEmpty())
        {  
            try 
            {
                image = ImageIO.read(new URL(lien_image));
                l_lien_image.setIcon(new ImageIcon(image.getScaledInstance(l_lien_image.getPreferredSize().width, l_lien_image.getPreferredSize().height, Image.SCALE_SMOOTH)));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        else
        {
            try 
            {
                image = ImageIO.read(new File("images/pasdispo.png"));
                l_lien_image.setIcon(new ImageIcon(image.getScaledInstance(l_lien_image.getPreferredSize().width, l_lien_image.getPreferredSize().height, Image.SCALE_SMOOTH)));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println(donnees.getLienImage());
        this.revalidate();
        this.repaint();
    }
  
    /**
     * Cette fonction est génrée par NetBeans et permet d'instancer les composants crée par l'IDE
     *
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l_titre = new javax.swing.JLabel();
        l_date = new javax.swing.JLabel();
        l_genre = new javax.swing.JLabel();
        l_auteur = new javax.swing.JLabel();
        b_ouvrir = new javax.swing.JButton();
        l_lien_image = new javax.swing.JLabel();

        setBackground(new java.awt.Color(103, 103, 103));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(863, 230));
        setMinimumSize(new java.awt.Dimension(863, 230));
        setPreferredSize(new java.awt.Dimension(863, 230));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        l_titre.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        l_titre.setForeground(new java.awt.Color(255, 255, 255));
        l_titre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        l_date.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        l_date.setForeground(new java.awt.Color(255, 255, 255));
        l_date.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        l_genre.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        l_genre.setForeground(new java.awt.Color(255, 255, 255));
        l_genre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        l_auteur.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        l_auteur.setForeground(new java.awt.Color(255, 255, 255));
        l_auteur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        b_ouvrir.setBackground(new java.awt.Color(255, 255, 255));
        b_ouvrir.setText("Ouvrir");
        b_ouvrir.setActionCommand("Ajouter");
        b_ouvrir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        b_ouvrir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_ouvrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_ouvrirActionPerformed(evt);
            }
        });

        l_lien_image.setPreferredSize(new java.awt.Dimension(160, 160));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(l_lien_image, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_ouvrir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(l_date, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                    .addComponent(l_auteur, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(l_titre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(l_genre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(59, 59, 59))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(l_titre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_auteur, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_date, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(l_genre, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(b_ouvrir, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(l_lien_image, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cette fonction est exécuté quand la souris entre dans le panel
     *
     * @param      evt   L'évènement utilisateur
     */
    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        setBackground(new Color(180,180,180));
    }//GEN-LAST:event_formMouseEntered

    /**
     * Cette fonction est éxécuté quand la souris sors du panel
     *
     * @param      evt   L'évènement utilisateur
     */
    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        setBackground(new Color(103,103,103));
    }//GEN-LAST:event_formMouseExited

    /**
     * Cette fonction est éxécuté quand on clique sur un bouton
     *
     * @param      evt   L'évènement utilisateur
     */
    private void b_ouvrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_ouvrirActionPerformed
        try
        {
            Desktop.getDesktop().browse(new URL(donnees.getLien()).toURI());  
        }       
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_b_ouvrirActionPerformed

    /**
     * Cette fonction est éxécuté quand la souris clique dans le panel
     *
     * @param      evt   L'évènement utilisateur
     */
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (evt.getButton() == evt.BUTTON1)
        {
            modif = new FormulaireModifier(fenetreparente,true,this);
        }
        if (evt.getButton() == evt.BUTTON3)
        {
            int choix = JOptionPane.showConfirmDialog(this,"Voulez-vous supprimer cet album ?","Question",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if( choix == JOptionPane.YES_OPTION )
                fenetreparente.supprimer(this);           
        }
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_ouvrir;
    private javax.swing.JLabel l_auteur;
    private javax.swing.JLabel l_date;
    private javax.swing.JLabel l_genre;
    private javax.swing.JLabel l_lien_image;
    private javax.swing.JLabel l_titre;
    // End of variables declaration//GEN-END:variables
}
