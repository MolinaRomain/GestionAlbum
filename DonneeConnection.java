
/**
 * <b> Classe servant à stocker les données de connexion </b>
 * @author     BOUHENAF Irfan et MOLINA Romain
 */
public class DonneeConnection {
    /**
     * Le pseudo de l'utilisateur
     */
    private String pseudo;
    
    /**
     * Construit une nouvelle instance de la classe DonneeConnection
     */
    public DonneeConnection()
    {}
    
    /**
     * Récupère le pseudo de l'utilisateur
     *
     * @return     Le pseudo de l'utilisateur.
     */
    public String getPseudo() { return pseudo; }
    
    /**
     * Change le pseudo de l'utlisateur
     *
     * @param      pseudo_  Le pseudo de l'utilisateur
     */
    public void setPseudo(String pseudo_) { pseudo = pseudo_; }
    
}
