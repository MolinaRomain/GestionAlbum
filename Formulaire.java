
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
/**
 *  <b> Cette classe représente un formulaire qui sera complété par les classes filles</b>
 *  @author     BOUHENAF Irfan et MOLINA Romain
 */
abstract class Formulaire extends JDialog
{
    
    /**
     * Champ de texte contenant le titre
     */
    protected JTextField t_titre;
    
    /**
     * Champ de texte contenant l'auteur
     */
    protected JTextField t_auteur;
    
    /**
     * Champ de texte contenant l'année de sortie
     */
    protected JTextField t_date;
    
    /**
     * Champ de texte contenant le lien youtube de l'album
     */
    protected JTextField t_lien;
    
    /**
     * ComboBox contenant les possinles genres d'un album
     */
    protected JComboBox<String> b_genre;
    
    /**
     * Champ de texte contenant le lien de l'image
     */
    protected JTextField t_lien_image;
    
    /**
     * L'année actuelle
     */
    protected String dateactuelle;
    
    /**
     * Méthode abstraite permettant de savoir si des champs du formulaire seront valides ou non et qui sera implémenté par les classes filles
     * @return un bolléen permettant de savoir si des champs du formulaires sont valides ou non
     */
    abstract boolean champsvalides();
    
    /**
     * Constructeurs qui sera implémenté par les classes filles
     * @param parent La fenetre principale
     * @param modal booléen permettant de savoir si une fenetre est modale ou non
     */
    public Formulaire(final Fenetre parent, boolean modal)
    {
        super(parent,modal);
        t_titre = new JTextField();
        t_titre.setPreferredSize(new Dimension(150,20));
        t_auteur = new JTextField();
        t_auteur.setPreferredSize(new Dimension(150,20));
        t_date = new JTextField();
        t_date.setPreferredSize(new Dimension(150,20));
        t_lien = new JTextField();
        t_lien.setPreferredSize(new Dimension(150,20));
        t_lien_image = new JTextField();
        t_lien_image.setPreferredSize(new Dimension(150,20));
        b_genre = new JComboBox<String>(new String [] {"Rap", "Jazz", "Rock","Blues", "Classique", "Pop","Funk", "Metal", "Jazz","Reggae","RnB", "Autre"});
        b_genre.setPreferredSize(new Dimension(150,20));
        dateactuelle = String.valueOf(Calendar.getInstance().get(Calendar.YEAR)); 
        b_genre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ChangeCouleurChamp(t_titre);
        ChangeCouleurChamp(t_auteur);
        ChangeCouleurChamp(t_date);
        ChangeCouleurChamp(t_lien);
        ChangeCouleurChamp(t_lien_image);
               
    }
    
    /**
     * Fonction permettant de changer la couleur de fond d'un champ de texte en blanc
     * @param field le champ de texte
     */
    private void ChangeCouleurChamp(JTextField field)
    {
        if (field.getBackground() != Color.white)
        {
            field.addKeyListener(new KeyAdapter()
            {
                @Override
                public void keyTyped(KeyEvent e)
                {
                    field.setBackground(Color.white);
                }
            });
        }
        
    }
    
}
    
