import javax.swing.*;
/**
 *  <b> Cette classe permet de faire un formulaire pour trier un album </b>
 *  @author     BOUHENAF Irfan et MOLINA Romain
 */
public class FenetreTri extends JDialog {
    
    /**
     * La fenêtre principale
     */
    private final Fenetre parent;
    
    /**
     * Construit une nouvelle instance de la classe FormulaireTri
     *
     * @param      parent_  La fenêtre principale
     * @param      modal    Permet de savoir si le formulaire est modal ou non
     */
    public FenetreTri(final Fenetre parent_, boolean modal) {
        super(parent_, modal);
        parent = parent_;
        initComponents();
        setLocationRelativeTo(parent);
        setVisible(true);

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
        b_filtre = new javax.swing.JComboBox<>();
        b_valider = new javax.swing.JButton();
        c_croissant = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Recherche");
        setMinimumSize(new java.awt.Dimension(400, 200));
        setResizable(false);
        setSize(new java.awt.Dimension(400, 200));

        panel_principal.setBackground(new java.awt.Color(103, 103, 103));
        panel_principal.setToolTipText("Trier par");
        panel_principal.setPreferredSize(new java.awt.Dimension(400, 200));

        b_filtre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Titre", "Auteur", "Date", "Genre"}));
        b_filtre.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        b_valider.setBackground(new java.awt.Color(255, 255, 255));
        b_valider.setText("Valider");
        b_valider.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        b_valider.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        b_valider.setFocusPainted(false);
        b_valider.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_validerActionPerformed(evt);
            }
        });

        c_croissant.setText("Ordre Croissant");
        c_croissant.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout panel_principalLayout = new javax.swing.GroupLayout(panel_principal);
        panel_principal.setLayout(panel_principalLayout);
        panel_principalLayout.setHorizontalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addGap(0, 123, Short.MAX_VALUE)
                .addGroup(panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(b_filtre, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(b_valider, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(c_croissant, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        panel_principalLayout.setVerticalGroup(
            panel_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principalLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(b_filtre, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(c_croissant)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(b_valider, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Cette fonction s'éxécute quand on appuie sur le bouton valider et permet de trier les albums grace aux filtres
     *
     * @param      evt   L'évènement utilisateur
     */
    private void b_validerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_validerActionPerformed
            parent.trier(b_filtre.getSelectedItem().toString(), c_croissant.isSelected());
            dispose();
    }//GEN-LAST:event_b_validerActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> b_filtre;
    private javax.swing.JButton b_valider;
    private javax.swing.JCheckBox c_croissant;
    private javax.swing.JPanel panel_principal;
    // End of variables declaration//GEN-END:variables
}
