
import java.util.*;
import java.sql.*;




/**
 * <b> Cette classe permet de gérer les requetes sql nécessaire pour ajouter des
 * Albums et des utilisateurs ainsi que les trier </b>
 * @author     BOUHENAF Irfan et MOLINA Romain
 */
public class GestionBDD {
        
        /**
         * Permet de réaliser la connexion et l'authentification à la base de données afin de transmettre des instructions vers la BDD        
         */
        private Connection conn;       
        
        /**
         * L'url de la base de données
         */
        private String databaseURL;
        
        /**
         * Les éventuels enregistrements sélectionnés par l'instruction SQL sont accessibles avec un élément de classe ResultSet
         */
        private ResultSet result;
       
        /**
         * Construit une nouvelle instance de "GestionBDD"
         */
 	public GestionBDD()
        {      
            databaseURL = "jdbc:sqlite:base.db";
            conn = null;
            try 
            {
              if (conn == null)
                  conn = DriverManager.getConnection(databaseURL);
            } 
            catch ( Exception e ) 
            {
              e.printStackTrace();
            }
            System.out.println("Opened database successfully");
            result = null;
            
        }
        
        /**
         * Cette fonction retourne null si un tuple dans une colonne n'existe pas, et retourne son contenu si ce dernier existe   
         *
         * @param      colonne   La colonne de la table
         * @return               Le contenu d'un tuple
         */
        
        public String ilExiste(String colonne)
        {
            String str;
            if (colonne.isEmpty())
                return null;
            else
                str = colonne;
            return str;
        }
        /**
         * Cette fonction permet d'ajouter un album   
         *
         * @param      genre_album   Le genre de l'album
         * @param      titre_album   Le titre de l'album
         * @param      auteur_album  l'auteur de l'album
         * @param      date_album    La date de sortie de l'album
         * @param      nom           Le nom de l'utilisateur
         * @param      lien          Le lien youtube vers l'album
         * @param      lien_image    Le lien de l'image de l'album 
         */
	public void ajouterAlbum(String genre_album, String titre_album, String auteur_album, int date_album, String nom, String lien, String lien_image)
	{

		
		try{
                        String requete = "INSERT INTO Album (genre,titre,auteur,date,lien,lien_image,id_utilisateur) VALUES (?,?,?,?,?,?,(SELECT id_utilisateur FROM utilisateur WHERE nom LIKE '" + nom + "'))";
                        PreparedStatement album_stmt = conn.prepareStatement(requete);
                        album_stmt.setString(1, genre_album);
                        album_stmt.setString(2, titre_album);
                        album_stmt.setString(3, auteur_album);
                        album_stmt.setInt(4, date_album);
                        album_stmt.setString(5, ilExiste(lien));
                        album_stmt.setString(6, ilExiste(lien_image));
                        album_stmt.executeUpdate();
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
	}
        
        /**
         * Cette fonction permet d'ajouter un utilisateur
         *
         * @param      nom   Le nom de l'utilisateur
         */
        public void ajouterUtilisateur(String nom)
	{

		
		try
                {
			String requete ="INSERT INTO Utilisateur (nom) VALUES ('" + nom +"')";
			Statement album_stmt = conn.createStatement();
			int nbMaj = album_stmt.executeUpdate(requete);
			System.out.println("nb de mises à jour = "+ nbMaj);
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
	}
        
        /**
         * Cette fonction permet de vérifier si le nom d'un utilisateur est déjà dans la base de données
         *
         * @param      nom   Le nom de l'utilisateur
         *
         * @return     Un booléen permettant de savoir si oui ou non c'est le même utilisateur
         */
        public boolean verifNomUtilisateur(String nom)
	{
            int nombre = 0;
            boolean pareil = false;
                try
                {

                    String requete ="SELECT COUNT(nom) FROM Utilisateur WHERE nom = '" + nom + "'";
                    Statement statement = conn.createStatement();
                    result = statement.executeQuery(requete);
                    result.next();
                    nombre = result.getInt(1);
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            if (nombre != 0)
                pareil = true;
            return pareil;
	}
        
       /**
        * Cette fonction permet de vérifier si l'auteur et le titre sont déjà dans la base de données 
        *
        * @param      titre   Le titre à vérifier  
        * @param      auteur  Le nom de l'auteur à vérifier
        * @param      nom     Le nom de l'utilisateur
        *
        * @return     Un booléen permettant de savoir si oui ou non l'auteur et le titre sont déjà dans la base de données
        */
        public boolean verifAuteurTitre(String titre, String auteur, String nom)
	{
            int nombre = 0;
            boolean pareil = false;
                try
                {
                    String requete ="SELECT COUNT(*) FROM Album WHERE titre LIKE '" + titre + "' AND auteur LIKE '" + auteur + "' AND id_utilisateur = (SELECT id_utilisateur FROM utilisateur WHERE nom LIKE '" + nom + "')" ;
                    Statement statement = conn.createStatement();
                    result = statement.executeQuery(requete);
                    result.next();
                    nombre = result.getInt(1);
                }
                catch (SQLException ex)
                {
                    ex.printStackTrace();
                }
            if (nombre != 0)
                pareil = true;
            return pareil;
	}
 
        /**
         * Cette fonction permet de modifier un album
         *
         * @param      nomcolonne   Le nom de la colonne à modifier
         * @param      newAttribut  Le nouvel attribut à mettre
         * @param      titre        Le titre de l'album à modifier
         * @param      auteur       L'auteur de l'album à modifier
         * @param      nom          Le nom de l'utilisateur
         */
        public void modifierAlbum(String nomcolonne, String newAttribut,String titre, String auteur, String nom)
        {
                try{
                        String requete = "UPDATE Album SET "+nomcolonne+" = ? WHERE titre LIKE ? AND auteur LIKE ? AND id_utilisateur = (SELECT id_utilisateur FROM utilisateur WHERE nom LIKE ?) "; 
                        PreparedStatement album_stmt = conn.prepareStatement(requete);	
                        if (nomcolonne.equals("date"))
                            album_stmt.setInt(1,Integer.parseInt(newAttribut));
                        else
                            album_stmt.setString(1,ilExiste(newAttribut));
                        album_stmt.setString(1,ilExiste(newAttribut));
                        album_stmt.setString(2,titre);
                        album_stmt.setString(3,auteur);
                        album_stmt.setString(4,nom);
                        album_stmt.executeUpdate();
			
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
        }
        
        /**
         * Cette fonction permet de sélectionner un album
         *
         * @param      nom   Le nom de l'utilisateur
         * @param      tab   Le tableau d'album
         */
        public void selectAlbum(String nom, Vector<LigneAlbum> tab)
        {
            try
            {

		String requete ="SELECT * FROM Album WHERE id_utilisateur = (SELECT id_utilisateur FROM utilisateur WHERE nom LIKE '" + nom + "')";
                Statement statement = conn.createStatement();
		result = statement.executeQuery(requete);
                int index = 0;
		while(result.next())
		{
                    if (result.getString("lien") == null)
                        tab.elementAt(index).getDonnees().setLien("");
                    else
                        tab.elementAt(index).getDonnees().setLien(result.getString("lien"));
                    if (result.getString("lien_image") == null)
                        tab.elementAt(index).getDonnees().setLienImage("");
                    else
                        tab.elementAt(index).getDonnees().setLienImage(result.getString("lien_image"));
                    tab.elementAt(index).getDonnees().setGenre(result.getString("genre"));
                    tab.elementAt(index).getDonnees().setTitre(result.getString("titre"));
                    tab.elementAt(index).getDonnees().setDate(result.getInt("date"));
                    tab.elementAt(index).getDonnees().setAuteur(result.getString("auteur"));
                    tab.elementAt(index).setGenre(tab.elementAt(index).getDonnees().getGenre());
                    tab.elementAt(index).setTitre(tab.elementAt(index).getDonnees().getTitre());
                    tab.elementAt(index).setAuteur(tab.elementAt(index).getDonnees().getAuteur());
                    tab.elementAt(index).setDate(tab.elementAt(index).getDonnees().getDate());
                    tab.elementAt(index).setLien(tab.elementAt(index).getDonnees().getLien());
                    tab.elementAt(index).setLienImage(tab.elementAt(index).getDonnees().getLienImage());
                    index++;
		}
                
            }
            catch (SQLException ex)
            {
		ex.printStackTrace();
            }
        }
        
        /**
         * Cette fonction donne le nombre de ligne d'un album dans la base de données
         *
         * @param      nom   Le nom de l'utilisateur
         *
         * @return     Le nombre de ligne
         */
        public int nbLigneAlbum(String nom)
        {
            int nombre = 0;
            try
            {

		String requete ="SELECT COUNT(*) FROM Album WHERE id_utilisateur = (SELECT id_utilisateur FROM utilisateur WHERE nom LIKE '" + nom + "')";
                Statement statement = conn.createStatement();
		result = statement.executeQuery(requete);
                result.next();
		nombre = result.getInt(1);
            }
            catch (SQLException ex)
            {
		ex.printStackTrace();
            }
            return nombre;
            
        }
        
        /**
         * Cette fonction permet de supprimer un album d'un utilisateur dans la base de données et dans l'application
         *
         * @param      titre   Le titre de l'album à supprimer
         * @param      auteur  Le nom de l'auteur de l'album à supprimer
         * @param      nom     Le nom de l'utilisateur
         */
        public void supprimerunalbum(String titre, String auteur, String nom)
        {
            try
            {

		String requete ="DELETE FROM Album WHERE titre LIKE '" + titre + "' AND auteur LIKE '" + auteur + "' AND id_utilisateur = (SELECT id_utilisateur FROM utilisateur WHERE nom LIKE '" + nom + "')";
                Statement statement = conn.createStatement();
		statement.executeUpdate(requete);
            }
            catch (SQLException ex)
            {
		ex.printStackTrace();
            }
        }
        
        /**
         * Cette fonction permet de supprimer tout les albums d'un utilisateur dans la base de données et dans l'application
         *
         * @param      nom   The nom
         */
        public void supprimertoutalbum(String nom)
        {
            try
            {

		String requete ="DELETE FROM Album WHERE id_utilisateur = (SELECT id_utilisateur FROM utilisateur WHERE nom LIKE '" + nom + "')";
                Statement statement = conn.createStatement();
		statement.executeUpdate(requete);
            }
            catch (SQLException ex)
            {
		ex.printStackTrace();
            }
        }

        /**
         * Cette fonction permet de trouver le nombre de ligne d'un album avec un filtre
         *
         * @param      nom      Le nom de l'utilisateur
         * @param      colonne  Une colonne de la table album
         * @param      filtre   Le filtre 
         *
         * @return     Retourne le nombre de ligne dans l'album avec le filtre
         */
        public int nbLigneAlbumFiltre(String nom, String colonne, String filtre)
        {
            int nombre = 0;
            try
            {

		String requete ="SELECT COUNT(*) FROM Album WHERE id_utilisateur = (SELECT id_utilisateur FROM utilisateur WHERE nom LIKE '" + nom + "') AND " + colonne + " LIKE '" + filtre + "%' ";
                Statement statement = conn.createStatement();
		result = statement.executeQuery(requete);
                result.next();
		nombre = result.getInt(1);
            }
            catch (SQLException ex)
            {
		ex.printStackTrace();
            }
            return nombre;
        }
        
        /**
         * Cette fonction permet de trouver le nombre de ligne d'un album avec un filtre
         *
         * @param      nom      Le nom de l'utilisateur
         * @param      filtre   Le filtre 
         * @param      symbole  L'opérateur de la requête SQL
         *
         * @return     Retourne le nombre de ligne dans l'album avec le filtre
         */
        public int nbLigneAlbumFiltreDate(String nom, String filtre, String symbole)
        {
            int nombre = 0;
            try
            {

		String requete ="SELECT COUNT(*) FROM Album WHERE id_utilisateur = (SELECT id_utilisateur FROM utilisateur WHERE nom LIKE '" + nom + "') AND date " + symbole + " '" + filtre + "' ";
                Statement statement = conn.createStatement();
		result = statement.executeQuery(requete);
                result.next();
		nombre = result.getInt(1);
            }
            catch (SQLException ex)
            {
		ex.printStackTrace();
            }
            return nombre;
        }

	/**
         * Cette fonction permet de rechercher un album
         *
         * @param      tab      Le  tableau d'album
         * @param      nom      Le nom de l'utilisateur
         * @param      colonne  Une colonne de la table album
         * @param      filtre   Le filtre
         */
        public void rechercherAlbum(Vector<LigneAlbum> tab, String nom, String colonne, String filtre)
	{
	    try{
                
			String requete ="SELECT * FROM Album WHERE " + colonne + " LIKE '" + filtre + "%' AND id_utilisateur = (SELECT id_utilisateur FROM utilisateur WHERE nom LIKE '" + nom + "')";
			Statement statement = conn.createStatement();
                        result = statement.executeQuery(requete);

                        int index = 0;
			while(result.next())
			{
                                if (result.getString("lien") == null)
                                    tab.elementAt(index).getDonnees().setLien("");
                                else
                                    tab.elementAt(index).getDonnees().setLien(result.getString("lien"));
                                if (result.getString("lien_image") == null)
                                    tab.elementAt(index).getDonnees().setLienImage("");
                                else
                                    tab.elementAt(index).getDonnees().setLienImage(result.getString("lien_image"));
                                tab.elementAt(index).getDonnees().setGenre(result.getString("genre"));
                                tab.elementAt(index).getDonnees().setTitre(result.getString("titre"));
                                tab.elementAt(index).getDonnees().setDate(result.getInt("date"));
                                tab.elementAt(index).getDonnees().setAuteur(result.getString("auteur"));
                                tab.elementAt(index).setGenre(tab.elementAt(index).getDonnees().getGenre());
                                tab.elementAt(index).setTitre(tab.elementAt(index).getDonnees().getTitre());
                                tab.elementAt(index).setAuteur(tab.elementAt(index).getDonnees().getAuteur());
                                tab.elementAt(index).setDate(tab.elementAt(index).getDonnees().getDate());
                                tab.elementAt(index).setLien(tab.elementAt(index).getDonnees().getLien());
                                tab.elementAt(index).setLienImage(tab.elementAt(index).getDonnees().getLienImage());
                                index++;
                                
			}
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
	}
        
        /**
         * Cette fonction permet de rechercher un album en fonction de la date
         *
         * @param      tab      Le  tableau d'album
         * @param      nom      Le nom de l'utilisateur
         * @param      filtre   Le filtre
         * @param      symbole  L'opérateur de la requête SQL
         */
        public void rechercherAlbumDate(Vector<LigneAlbum> tab, String nom, String filtre, String symbole)
	{
	    try{

			String requete ="SELECT * FROM Album WHERE date " + symbole + " '" + filtre + "' AND id_utilisateur = (SELECT id_utilisateur FROM utilisateur WHERE nom LIKE '" + nom + "')";
			Statement statement = conn.createStatement();
                        result = statement.executeQuery(requete);

                        int index = 0;
			while(result.next())
			{
                                if (result.getString("lien") == null)
                                    tab.elementAt(index).getDonnees().setLien("");
                                else
                                    tab.elementAt(index).getDonnees().setLien(result.getString("lien"));
                                if (result.getString("lien_image") == null)
                                    tab.elementAt(index).getDonnees().setLienImage("");
                                else
                                    tab.elementAt(index).getDonnees().setLienImage(result.getString("lien_image"));
                                tab.elementAt(index).getDonnees().setGenre(result.getString("genre"));
                                tab.elementAt(index).getDonnees().setTitre(result.getString("titre"));
                                tab.elementAt(index).getDonnees().setDate(result.getInt("date"));
                                tab.elementAt(index).getDonnees().setAuteur(result.getString("auteur"));
                                tab.elementAt(index).setGenre(tab.elementAt(index).getDonnees().getGenre());
                                tab.elementAt(index).setTitre(tab.elementAt(index).getDonnees().getTitre());
                                tab.elementAt(index).setAuteur(tab.elementAt(index).getDonnees().getAuteur());
                                tab.elementAt(index).setDate(tab.elementAt(index).getDonnees().getDate());
                                tab.elementAt(index).setLien(tab.elementAt(index).getDonnees().getLien());
                                tab.elementAt(index).setLienImage(tab.elementAt(index).getDonnees().getLienImage());
                                index++;
                                
			}
		}
		catch (SQLException ex){
			ex.printStackTrace();
		}
	}


	


}