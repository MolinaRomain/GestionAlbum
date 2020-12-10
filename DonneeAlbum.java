
/**
 *  <b> Cette classe permet de stocker les données d'un album </b>
 * @author     BOUHENAF Irfan et MOLINA Romain
 */
public class DonneeAlbum {
    
    /**
     * Auteur de l'album
     */
    private String auteur;
    
    /**
     * Titre de l'album
     */
    private String titre;
    
    /**
     * Année de sortie de l'album
     */
    private int date;
    
    /**
     * Genre de l'album
     */
    private String genre;
    
    /**
     * Lien youtube vers l'album (pas obligatoire)
     */
    private String lien;
    /**
     * Lien internet vers l'image de l'album (pas obligatoire)
     */
    private String lien_image;
    
    /**
     * Créer une nouvelle instance de la classe DonneeAlbum
     */
    public DonneeAlbum()
    {}
    
    /**
     * Récupère le nom de l'auteur
     *
     * @return     Le nom de l'auteur
     */
    public String getAuteur()
    {
        return auteur;
    }
    
    /**
     * Récupère le titre de l'album
     *
     * @return     Le titre de l'album
     */
    public String getTitre()
    {
        return titre;
    }
    
    /**
     * Récupère la date de sortie de l'album
     *
     * @return     La date de sortie de l'album
     */
    public int getDate()
    {
        return date;
    }
    
    /**
     * Récupère le genre de l'album
     *
     * @return     Le genre de l'album
     */
    public String getGenre()
    {
        return genre;
    }
    
    /**
     * Récupère le lien youtube de l'album
     *
     * @return     Le lien youtube de l'album
     */
    public String getLien()
    {
        return lien;
    }
    
    /**
     * Récupère le lien internet de l'image de l'album
     *
     * @return     le lien internet de l'image de l'album
     */
    public String getLienImage()
    {
        return lien_image;
    }
    
    /**
     * Change le titre de l'album
     *
     * @param      titre_  Le titre de l'album
     */
    public void setTitre(String titre_)
    {
        titre = titre_;
    }

    /**
     * Change le nom de l'auteur de l'album
     *
     * @param      auteur_  Le nom de l'auteur de l'album
     */
    public void setAuteur(String auteur_)
    {
        auteur = auteur_;
    }

    /**
     * Change la date de sortie de l'album
     *
     * @param      date_  La date de sortie de l'album
     */
    public void setDate(int date_)
    {
        date = date_;
    }

    /**
     * Change le genre de l'album
     *
     * @param      genre_  Le genre de l'album
     */
    public void setGenre(String genre_)
    {
        genre = genre_;
    }
    
    /**
     * Change le lien youtube de l'album
     *
     * @param      lien_  Le lien de l'album
     */
    public void setLien(String lien_)
    {
        lien = lien_;
    }
    
    /**
     * Change le lien de l'image de l'album
     *
     * @param      lien_image_  le lien de l'image de l'album
     */
    public void setLienImage(String lien_image_)
    {
        lien_image = lien_image_;
    }
}
