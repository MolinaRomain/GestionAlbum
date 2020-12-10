
import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.net.URL; 


/**
 * <b> Cette classe décrit la fenêtre principale </b>
 * @author     BOUHENAF Irfan et MOLINA Romain
 */
public class Fenetre extends JFrame
{
    /**
     * Les données de connexion
     */
    private DonneeConnection donnees;
    
    /**
     * Le Vecteur où sont stocké les albums
     */
    private Vector<LigneAlbum> tabalbums;
    
    /**
     * Permet de trier les albums à l'aide d'une fenêtre
     */
    private FenetreTri tri;
    
    /**
     * Permet d'ajouter un album à l'aide d'un formulaire
     */
    private FormulaireAjout ajout;
    
    /**
     * Classe qui gère la BDD
     */
    private GestionBDD gestionnaire;
    
    /**
     * Formulaire de connexion à l'application
     */
    private Connexion connexion;
    
    /**
     * Créer une nouvelle instance de la classe Fenetre
     */
    public Fenetre() {
        gestionnaire = new GestionBDD();
        tabalbums = new Vector<LigneAlbum>(); 
        donnees = new DonneeConnection();
        initComponents();
        setLocationRelativeTo(null);
        b_filtre_date.setVisible(false);
        setVisible(true);
        connexion = new Connexion(this,true);
        
        
    }
   
    /**
     * Récupère les données de la BDD
     *
     * @return     Le gestionnaire de la base de données
     */
    public GestionBDD getBDD()
    {
        return gestionnaire;      
    }
    
    /**
     * Récupère les données de connexion
     *
     * @return     Les données de connexion
     */
    public DonneeConnection getDonnees()
    {
        return donnees;
    }
 
    /**
     * Permet de changer le JLabel contenant le pseudo
     *
     * @param      pseudo  Le pseudo à changer
     */
    public void setPseudo(String pseudo)
    {
        l_pseudo.setText(pseudo);
    }
 
    /**
     * Permet de modifier les données d'un album
     *
     * @param      colonne    La colonne où une valeur doit changer
     * @param      newValeur  La valeur qui doit changer
     * @param      titre      Le titre de l'album
     * @param      auteur     L'auteur de l'album
     */
    public void modifier(String colonne, String newValeur, String titre, String auteur )
    {
        gestionnaire.modifierAlbum(colonne, newValeur , titre, auteur,donnees.getPseudo());
    }
    
    /**
     * Permet d'ajouter un album dans la base de données
     *
     * @param      titre   Le titre de l'album
     * @param      auteur  L'auteur de l'album
     * @param      date    La date de sortie de l'album
     * @param      genre   Le genre de l'album
     * @param      lien    Le lien redirigeant vers l'album (optionnel)
     * @param      lien_image    Le lien de l'image de l'album (optionnel)
     */
    public void ajouterdansBDD(String titre, String auteur, int date, String genre, String lien, String lien_image)
    { 
        gestionnaire.ajouterAlbum(genre, titre, auteur,date,donnees.getPseudo(),lien,lien_image);
        JOptionPane.showMessageDialog(this,"L'album " + titre + " de " + auteur + " a été ajouté à la base de données !");
    }
 
    /**
     * Cette fonction permet de créer des panels en fonction du nombre de lignes retournées par la requête SQL
     */
    public void rempliralbum()
    {
        if (gestionnaire.nbLigneAlbum(donnees.getPseudo()) == 0)
        {
            JOptionPane.showMessageDialog(this,"La recherche n'a pas aboutie");
        }
        else
        {
            tabalbums.clear();
            panel_tableau.removeAll();
            for (int i=0; i < gestionnaire.nbLigneAlbum(donnees.getPseudo()); i++)
            {
                tabalbums.addElement(new LigneAlbum(this));
                panel_tableau.add(tabalbums.lastElement());
            }
        }
    }
    
    /**
     * Cette fonction permet de créer des panels en fonction du nombre de lignes retournées par la requête SQL (avec le filtre)
     *
     * @param      colonne  La colonne où une valeur doit changer
     * @param      filtre   Le filtre utilisé
     */
    public void rempliralbumfiltre(String colonne, String filtre)
    {
        if (gestionnaire.nbLigneAlbumFiltre(donnees.getPseudo(),colonne,filtre) == 0)
        {
            JOptionPane.showMessageDialog(this,"La recherche n'a pas aboutie");
            b_reinitialiser.setEnabled(false);
        }
        else
        {
            tabalbums.clear();
            panel_tableau.removeAll();
            for (int i=0; i < gestionnaire.nbLigneAlbumFiltre(donnees.getPseudo(),colonne,filtre); i++)
            {
                tabalbums.addElement(new LigneAlbum(this));
                panel_tableau.add(tabalbums.lastElement());
            }
        }           
    }
    
    /**
     * Cette fonction permet de créer des panels en fonction du nombre de lignes retournées par la requête SQL (avec le filtre date)
     *
     * @param      filtre   Le filtre utilisé
     * @param      symbole l'opérateur de la requête SQL
     */
    public void rempliralbumfiltredate(String filtre, String symbole)
    {
        if (gestionnaire.nbLigneAlbumFiltreDate(donnees.getPseudo(),filtre,symbole) == 0)
        {
            JOptionPane.showMessageDialog(this,"La recherche n'a pas aboutie");
            b_reinitialiser.setEnabled(false);
        }
        else
        {
            tabalbums.clear();
            panel_tableau.removeAll();
            for (int i=0; i < gestionnaire.nbLigneAlbumFiltreDate(donnees.getPseudo(),filtre,symbole); i++)
            {
                tabalbums.addElement(new LigneAlbum(this));
                panel_tableau.add(tabalbums.lastElement());
            }
        }           
    }
    
    /**
     * Cette fonction permet de consulter les albums contenus dans la base de données
     */
    public void consulter()
    {
        rempliralbum();
        gestionnaire.selectAlbum(donnees.getPseudo(),tabalbums);
        panel_tableau.revalidate();
        panel_tableau.repaint();    
    }
    
    /**
     * Cette fonction permet de vider le panel contenant les albums
     */
    public void vider()
    {
        tabalbums.clear();
        panel_tableau.removeAll();
        panel_tableau.revalidate();
        panel_tableau.repaint();
    }
    
    /**
     * Cette fonction permet de supprimer un album
     *
     * @param      album  L'album à supprimer
     */
    public void supprimer(LigneAlbum album)
    {
        gestionnaire.supprimerunalbum(album.getDonnees().getTitre(), album.getDonnees().getAuteur(),donnees.getPseudo());
        tabalbums.remove(album);
        panel_tableau.remove(album);
        panel_tableau.revalidate();
        panel_tableau.repaint();    
    }
      
    /**
     * { function_description }
     *
     * @param      attribut   L'attribut à trier
     * @param      croissant  booléen permettant de savoir si le tri doit se faire dans l'ordre croissant ou pas
     */
    public void trier(String attribut, boolean croissant)
    {
        if (tabalbums.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Impossible de trier");
        }
        else
        {
            panel_tableau.removeAll();
            if (croissant)
            {
                if(attribut.equals("Titre"))
                    tabalbums.sort(Comparator.comparing(a -> a.getDonnees().getTitre(),String.CASE_INSENSITIVE_ORDER));
                else if(attribut.equals("Auteur"))
                    tabalbums.sort(Comparator.comparing(a -> a.getDonnees().getAuteur(),String.CASE_INSENSITIVE_ORDER));
                else if(attribut.equals("Date"))
                    tabalbums.sort(Comparator.comparing(a -> a.getDonnees().getDate()));
                else if(attribut.equals("Genre"))
                    tabalbums.sort(Comparator.comparing(a -> a.getDonnees().getGenre(),String.CASE_INSENSITIVE_ORDER));
            }
            else
            {
                if(attribut.equals("Titre"))
                {
                    tabalbums.sort(Comparator.comparing(a -> a.getDonnees().getTitre(), String.CASE_INSENSITIVE_ORDER));
                    Collections.reverse(tabalbums);
                }
                else if(attribut.equals("Auteur"))
                {
                    tabalbums.sort(Comparator.comparing(a -> a.getDonnees().getAuteur(), String.CASE_INSENSITIVE_ORDER));
                    Collections.reverse(tabalbums);
                }
                else if(attribut.equals("Date"))
                {
                    tabalbums.sort(Comparator.comparing(a -> a.getDonnees().getDate()));
                    Collections.reverse(tabalbums);
                }
                else if(attribut.equals("Genre"))
                {
                    tabalbums.sort(Comparator.comparing(a -> a.getDonnees().getGenre(), String.CASE_INSENSITIVE_ORDER));
                    Collections.reverse(tabalbums);
                }
            }
            for (int i=0; i<tabalbums.size();++i)
            {
                panel_tableau.add(tabalbums.elementAt(i));
            }
            panel_tableau.revalidate();
            panel_tableau.repaint();
        }
    }
    /**
     * Permet de rechercher un album
     *
     * @param      recherche La recherche
     */
    public void rechercher(String recherche)
    {
        if (b_filtre.getSelectedItem().toString().equals("Date"))
        {
            rempliralbumfiltredate(recherche,b_filtre_date.getSelectedItem().toString());
            gestionnaire.rechercherAlbumDate(tabalbums,donnees.getPseudo(),recherche,b_filtre_date.getSelectedItem().toString());
        }
        else
        {
            rempliralbumfiltre(b_filtre.getSelectedItem().toString(),recherche);
            gestionnaire.rechercherAlbum(tabalbums,donnees.getPseudo(),b_filtre.getSelectedItem().toString(),recherche);
        }
        if (!tabalbums.isEmpty())
            b_reinitialiser.setEnabled(true);
        panel_tableau.revalidate();
        panel_tableau.repaint();
    }
    
   
    /**
     * Cette fonction est génrée par NetBeans et permet d'instancer les composants crée par l'IDE
     *
     * 
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principal = new javax.swing.JPanel();
        scrolltab = new javax.swing.JScrollPane();
        panel_tableau = new javax.swing.JPanel();
        enTete = new javax.swing.JPanel();
        l_nomAppli = new javax.swing.JLabel();
        f_rechercher = new javax.swing.JTextField();
        l_rechercher = new javax.swing.JLabel();
        b_valider = new javax.swing.JButton();
        b_reinitialiser = new javax.swing.JButton();
        b_filtre = new javax.swing.JComboBox<>();
        l_pseudo = new javax.swing.JLabel();
        b_filtre_date = new javax.swing.JComboBox<>();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 20), new java.awt.Dimension(0, 20), new java.awt.Dimension(32767, 20));
        scrollMenu = new javax.swing.JScrollPane();
        panel_menu = new javax.swing.JPanel();
        l_ajouter = new javax.swing.JLabel();
        l_supprimer = new javax.swing.JLabel();
        l_trier = new javax.swing.JLabel();
        l_consulter = new javax.swing.JLabel();
        l_deconnexion = new javax.swing.JLabel();
        l_vider = new javax.swing.JLabel();
        l_apropos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Meedee");
        setAlwaysOnTop(true);
        setMinimumSize(new java.awt.Dimension(1020, 710));
        setResizable(false);

        principal.setBackground(new java.awt.Color(103, 103, 103));

        scrolltab.setBorder(null);
        scrolltab.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrolltab.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        panel_tableau.setBackground(new java.awt.Color(103, 103, 103));
        panel_tableau.setLayout(new javax.swing.BoxLayout(panel_tableau, javax.swing.BoxLayout.Y_AXIS));
        scrolltab.setViewportView(panel_tableau);

        enTete.setBackground(new java.awt.Color(180, 180, 180));

        l_nomAppli.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        l_nomAppli.setForeground(new java.awt.Color(255, 255, 255));
        l_nomAppli.setText("Meedee");

        l_rechercher.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        l_rechercher.setForeground(new java.awt.Color(255, 255, 255));
        l_rechercher.setText("Rechercher :");

        b_valider.setBackground(new java.awt.Color(255, 255, 255));
        b_valider.setText("Valider");
        b_valider.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b_valider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_validerActionPerformed(evt);
            }
        });

        b_reinitialiser.setBackground(new java.awt.Color(255, 255, 255));
        b_reinitialiser.setText("Réinitialiser");
        b_reinitialiser.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b_reinitialiser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_reinitialiser.setEnabled(false);
        b_reinitialiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_reinitialiserActionPerformed(evt);
            }
        });

        b_filtre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Titre", "Auteur", "Date", "Genre" }));
        b_filtre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_filtre.setRequestFocusEnabled(false);
        b_filtre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_filtreActionPerformed(evt);
            }
        });

        l_pseudo.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        l_pseudo.setForeground(new java.awt.Color(255, 255, 255));
        l_pseudo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_pseudo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/user-shape.png"))); // NOI18N

        b_filtre_date.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ">", "<", ">=", "<=", "=" }));
        b_filtre_date.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout enTeteLayout = new javax.swing.GroupLayout(enTete);
        enTete.setLayout(enTeteLayout);
        enTeteLayout.setHorizontalGroup(
            enTeteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, enTeteLayout.createSequentialGroup()
                .addGroup(enTeteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(enTeteLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(l_nomAppli)
                        .addGap(188, 188, 188)
                        .addComponent(l_rechercher)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(f_rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, enTeteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)))
                .addGroup(enTeteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(enTeteLayout.createSequentialGroup()
                        .addComponent(b_filtre, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_valider, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(b_reinitialiser, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(b_filtre_date, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(l_pseudo, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        enTeteLayout.setVerticalGroup(
            enTeteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(enTeteLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(enTeteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(enTeteLayout.createSequentialGroup()
                        .addComponent(l_pseudo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(enTeteLayout.createSequentialGroup()
                        .addGroup(enTeteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(l_nomAppli)
                            .addComponent(f_rechercher, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(l_rechercher)
                            .addComponent(b_valider, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_reinitialiser, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_filtre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(enTeteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(enTeteLayout.createSequentialGroup()
                                .addComponent(b_filtre_date, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addComponent(filler1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        l_pseudo.getAccessibleContext().setAccessibleParent(l_pseudo);

        scrollMenu.setBorder(null);
        scrollMenu.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollMenu.setToolTipText("");
        scrollMenu.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        panel_menu.setBackground(new java.awt.Color(180, 180, 180));

        l_ajouter.setBackground(new java.awt.Color(180, 180, 180));
        l_ajouter.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        l_ajouter.setForeground(new java.awt.Color(255, 255, 255));
        l_ajouter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_ajouter.setText(" Ajouter");
        l_ajouter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        l_ajouter.setOpaque(true);
        l_ajouter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_ajouterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_ajouterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l_ajouterMouseExited(evt);
            }
        });

        l_supprimer.setBackground(new java.awt.Color(180, 180, 180));
        l_supprimer.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        l_supprimer.setForeground(new java.awt.Color(255, 255, 255));
        l_supprimer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_supprimer.setText("Supprimer tout");
        l_supprimer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        l_supprimer.setOpaque(true);
        l_supprimer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_supprimerMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_supprimerMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l_supprimerMouseExited(evt);
            }
        });

        l_trier.setBackground(new java.awt.Color(180, 180, 180));
        l_trier.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        l_trier.setForeground(new java.awt.Color(255, 255, 255));
        l_trier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_trier.setText("Trier");
        l_trier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        l_trier.setOpaque(true);
        l_trier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_trierMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_trierMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l_trierMouseExited(evt);
            }
        });

        l_consulter.setBackground(new java.awt.Color(180, 180, 180));
        l_consulter.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        l_consulter.setForeground(new java.awt.Color(255, 255, 255));
        l_consulter.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_consulter.setText("Consulter");
        l_consulter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        l_consulter.setOpaque(true);
        l_consulter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_consulterMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_consulterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l_consulterMouseExited(evt);
            }
        });

        l_deconnexion.setBackground(new java.awt.Color(180, 180, 180));
        l_deconnexion.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        l_deconnexion.setForeground(new java.awt.Color(255, 255, 255));
        l_deconnexion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_deconnexion.setText("Se déconnecter");
        l_deconnexion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        l_deconnexion.setOpaque(true);
        l_deconnexion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_deconnexionMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_deconnexionMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l_deconnexionMouseExited(evt);
            }
        });

        l_vider.setBackground(new java.awt.Color(180, 180, 180));
        l_vider.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        l_vider.setForeground(new java.awt.Color(255, 255, 255));
        l_vider.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_vider.setText("Vider le panel");
        l_vider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        l_vider.setOpaque(true);
        l_vider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_viderMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_viderMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l_viderMouseExited(evt);
            }
        });

        l_apropos.setBackground(new java.awt.Color(180, 180, 180));
        l_apropos.setFont(new java.awt.Font("Bahnschrift", 0, 18)); // NOI18N
        l_apropos.setForeground(new java.awt.Color(255, 255, 255));
        l_apropos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        l_apropos.setText("A propos");
        l_apropos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        l_apropos.setOpaque(true);
        l_apropos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                l_aproposMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                l_aproposMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                l_aproposMouseExited(evt);
            }
        });

        javax.swing.GroupLayout panel_menuLayout = new javax.swing.GroupLayout(panel_menu);
        panel_menu.setLayout(panel_menuLayout);
        panel_menuLayout.setHorizontalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addGroup(panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(l_ajouter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(l_supprimer, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(l_consulter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(l_deconnexion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(l_trier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(l_vider, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                    .addComponent(l_apropos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel_menuLayout.setVerticalGroup(
            panel_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_menuLayout.createSequentialGroup()
                .addComponent(l_ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(l_consulter, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(l_supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(l_vider, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(l_trier, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(l_deconnexion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(l_apropos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(257, Short.MAX_VALUE))
        );

        scrollMenu.setViewportView(panel_menu);

        javax.swing.GroupLayout principalLayout = new javax.swing.GroupLayout(principal);
        principal.setLayout(principalLayout);
        principalLayout.setHorizontalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalLayout.createSequentialGroup()
                .addComponent(scrollMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scrolltab))
            .addComponent(enTete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        principalLayout.setVerticalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalLayout.createSequentialGroup()
                .addComponent(enTete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(principalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(scrolltab, javax.swing.GroupLayout.PREFERRED_SIZE, 648, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
     * Cette fonction est éxécuté quand la souris sors du label supprimer
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_supprimerMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_supprimerMouseExited
        l_supprimer.setBackground(new Color(180,180,180));
    }//GEN-LAST:event_l_supprimerMouseExited

    /**
     * Cette fonction est éxécuté quand la souris entre dans le label supprimer
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_supprimerMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_supprimerMouseEntered
        l_supprimer.setBackground(new Color(103,103,103));
    }//GEN-LAST:event_l_supprimerMouseEntered

    /**
     * Cette fonction est éxécuté quand la souris clique sur le label supprimer
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_supprimerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_supprimerMouseClicked
        if (!tabalbums.isEmpty())
        {
            int choix = JOptionPane.showConfirmDialog(this,"Etes-vous sûr ?","Question",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if( choix == JOptionPane.YES_OPTION )
            {
                vider();
                gestionnaire.supprimertoutalbum(donnees.getPseudo());
            }
        }
        else
            JOptionPane.showMessageDialog(this,"Impossible de supprimer");
    }//GEN-LAST:event_l_supprimerMouseClicked

    /**
     * Cette fonction est éxécuté quand la souris sors du label trier
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_trierMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_trierMouseExited
        l_trier.setBackground(new Color(180,180,180));
    }//GEN-LAST:event_l_trierMouseExited

    /**
     * Cette fonction est éxécuté quand la souris entre dans le label trier
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_trierMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_trierMouseEntered
        l_trier.setBackground(new Color(103,103,103));
    }//GEN-LAST:event_l_trierMouseEntered

    /**
     * Cette fonction est éxécuté quand la souris clique sur le label trier
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_trierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_trierMouseClicked
        if (!tabalbums.isEmpty())
            tri = new FenetreTri(this,true); 
        else
            JOptionPane.showMessageDialog(this,"Impossible de trier");
    }//GEN-LAST:event_l_trierMouseClicked

    /**
     * Cette fonction est éxécuté quand la souris clique sur le label "consulter"
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_consulterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_consulterMouseClicked
        consulter();
    }//GEN-LAST:event_l_consulterMouseClicked

    /**
     * Cette fonction est éxécuté quand la souris entre dans le label "consulter"
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_consulterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_consulterMouseEntered
        l_consulter.setBackground(new Color(103,103,103));
    }//GEN-LAST:event_l_consulterMouseEntered

    /**
     * Cette fonction est éxécuté quand la souris sors du label "consulter"
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_consulterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_consulterMouseExited
        l_consulter.setBackground(new Color(180,180,180));
    }//GEN-LAST:event_l_consulterMouseExited

    /**
     * Cette fonction est éxécuté quand la souris clique sur le bouton "deconnexion"
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_deconnexionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_deconnexionMouseClicked
        vider();
        l_pseudo.setText("");
        connexion.setVisible(true);
    }//GEN-LAST:event_l_deconnexionMouseClicked

    /**
     * Cette fonction est éxécuté quand la souris entre dans le label "deconnexion"
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_deconnexionMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_deconnexionMouseEntered
        l_deconnexion.setBackground(new Color(103,103,103));
    }//GEN-LAST:event_l_deconnexionMouseEntered

    /**
     * Cette fonction est éxécuté quand la souris sors du label "deconnexion"
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_deconnexionMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_deconnexionMouseExited
        l_deconnexion.setBackground(new Color(180,180,180));
    }//GEN-LAST:event_l_deconnexionMouseExited

    /**
     * Cette fonction est éxécuté quand la souris clique sur le label "vider"
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_viderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_viderMouseClicked
        if (!tabalbums.isEmpty())
        {
            int choix = JOptionPane.showConfirmDialog(this,"Etes-vous sûr ?","Question",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
            if( choix == JOptionPane.YES_OPTION )
            {
                vider();
            }
        }
        else
            JOptionPane.showMessageDialog(this,"Impossible de vider");
    }//GEN-LAST:event_l_viderMouseClicked

    /**
     * Cette fonction est éxécuté quand la souris entre dans le label "vider"
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_viderMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_viderMouseEntered
        l_vider.setBackground(new Color(103,103,103));
    }//GEN-LAST:event_l_viderMouseEntered

    /**
     * Cette fonction est éxécuté quand la souris sors du label "vider"
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_viderMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_viderMouseExited
        l_vider.setBackground(new Color(180,180,180));
    }//GEN-LAST:event_l_viderMouseExited

    /**
     * Cette fonction est éxécuté quand la souris clique sur le label "à propos"
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_aproposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_aproposMouseClicked
        JOptionPane.showMessageDialog(this,
        "Cette application a été crée par Irfan BOUHENAF et Romain MOLINA");
    }//GEN-LAST:event_l_aproposMouseClicked

    /**
     * Cette fonction est éxécuté quand la souris entre dans le label "à propos"
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_aproposMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_aproposMouseEntered
        l_apropos.setBackground(new Color(103,103,103));
    }//GEN-LAST:event_l_aproposMouseEntered

    /**
     * Cette fonction est éxécuté quand la souris sors du label "à propos"
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_aproposMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_aproposMouseExited
        l_apropos.setBackground(new Color(180,180,180));
    }//GEN-LAST:event_l_aproposMouseExited

    /**
     * Cette fonction est éxécuté quand la souris sors du label ajouter
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_ajouterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_ajouterMouseExited
        l_ajouter.setBackground(new Color(180,180,180));
    }//GEN-LAST:event_l_ajouterMouseExited

     /**
     * Cette fonction est éxécuté quand la souris entre dans le label ajouter
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_ajouterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_ajouterMouseEntered
        l_ajouter.setBackground(new Color(103,103,103));
    }//GEN-LAST:event_l_ajouterMouseEntered

    /**
     * Cette fonction est éxécuté quand la souris clique sur la label ajouter
     *
     * @param      evt   L'évènement utilisateur
     */
    private void l_ajouterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_l_ajouterMouseClicked
        ajout = new FormulaireAjout(this,true);
    }//GEN-LAST:event_l_ajouterMouseClicked

    /**
     * Cette fonction est éxécuté quand on clique sur le filtre "Date" de la recherche d'Albums
     *
     * @param      evt   The event
     */
    private void b_filtreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_filtreActionPerformed
        if(b_filtre.getSelectedItem().equals("Date"))
            b_filtre_date.setVisible(true);
        else
            b_filtre_date.setVisible(false);
    }//GEN-LAST:event_b_filtreActionPerformed

    /**
     * Cette fonction est éxécuté quand on clique sur le bouton "réinitialiser" de la recherche
     *
     * @param      evt   The event
     */
    private void b_reinitialiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_reinitialiserActionPerformed
        panel_tableau.removeAll();
        consulter();
        panel_tableau.revalidate();
        panel_tableau.repaint();
        f_rechercher.setText("");
        b_reinitialiser.setEnabled(false);
    }//GEN-LAST:event_b_reinitialiserActionPerformed

    /**
     * Cette fonction est éxécuté quand on clique sur le bouton "valider" de la recherche
     *
     * @param      evt   The event
     */
    private void b_validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_validerActionPerformed
        if(f_rechercher.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Zone de texte vide !","Erreur",JOptionPane.ERROR_MESSAGE);
            b_reinitialiser.setEnabled(false);
        }
        else
            rechercher(f_rechercher.getText());

    }//GEN-LAST:event_b_validerActionPerformed

   
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> b_filtre;
    private javax.swing.JComboBox<String> b_filtre_date;
    private javax.swing.JButton b_reinitialiser;
    private javax.swing.JButton b_valider;
    private javax.swing.JPanel enTete;
    private javax.swing.JTextField f_rechercher;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JLabel l_ajouter;
    private javax.swing.JLabel l_apropos;
    private javax.swing.JLabel l_consulter;
    private javax.swing.JLabel l_deconnexion;
    private javax.swing.JLabel l_nomAppli;
    private javax.swing.JLabel l_pseudo;
    private javax.swing.JLabel l_rechercher;
    private javax.swing.JLabel l_supprimer;
    private javax.swing.JLabel l_trier;
    private javax.swing.JLabel l_vider;
    private javax.swing.JPanel panel_menu;
    private javax.swing.JPanel panel_tableau;
    private javax.swing.JPanel principal;
    private javax.swing.JScrollPane scrollMenu;
    private javax.swing.JScrollPane scrolltab;
    // End of variables declaration//GEN-END:variables
}
