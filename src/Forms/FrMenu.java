/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Forms;

import Tools.KoneksiDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author NISSA
 */
public class FrMenu extends javax.swing.JFrame {

    KoneksiDB getCnn = new KoneksiDB();
    Connection _Cnn;
    
    String vid_user, vnama_user, vpass, vlev_user;
    String sqlselect;
    
    public FrMenu() {
        initComponents();
        
        this.setExtendedState(this.getExtendedState() | FrMenu.MAXIMIZED_BOTH);
        // untuk langsung maximize
        disabledMenu(); //untuk disable 
        txtIDUser.requestFocus(true); // untuk kursor focus ke id user
    }
    
     private void disabledMenu() { //untuk disable
        mnSistem.setEnabled(false);
        mnMasterData.setEnabled(false);
        mnTransaksiJual.setEnabled(false);
        mnPembelian.setEnabled(false);
        
    }
     
     private void enableMenu() { //untuk disable
        mnSistem.setEnabled(true);
        mnMasterData.setEnabled(true);
        mnTransaksiJual.setEnabled(true);
        mnPembelian.setEnabled(true);
        
    }
     
     private void aksiLogin() {
        if(txtIDUser.getText().equals("") || txtPassword.getText().equals("")){
            JOptionPane.showMessageDialog(this,"ID. User dan Password harus diisi!");
        }else{
            vid_user = txtIDUser.getText(); //memberikan nilai pada variabel vid_user
            vpass = txtPassword.getText();
            try{
                _Cnn = null;    //mengkosongkan koneksi
                _Cnn = getCnn.getConnection();  //membuka koneksi dg get cnn (objek koneksi db)
                sqlselect = "select * from tbuser where id_user='"+vid_user+"' "
                        + " and pass=md5('"+vpass+"') ";
                Statement stat = _Cnn.createStatement();    //membuat statement query
                ResultSet res = stat.executeQuery(sqlselect);   //menjalankan query |select pd baris 81 harus pake resulst set  |res menampung sql select
                if(res.first()) {   //jika hasilnya(query select) ditemukan
                    vlev_user = res.getString("lev_user");  //memberikan nilai pd variabel user dr hasil query select kolom lev_user
                    vnama_user = res.getString("nama_user");
                    lblKeterangan.setText("ID. User : "+vid_user+" - "+vnama_user+
                            "   | Lev. User : "+vlev_user);
                    panelLogin.setVisible(false);
                    enableMenu();
                    if(vlev_user.equals("Administrator")){
                        
                    }else if(vlev_user.equals("Kasir")){
                        
                    }
                }else{
                   JOptionPane.showMessageDialog(this,"ID. User dan Password salah!"); 
                }
            }catch (SQLException se){
                JOptionPane.showMessageDialog(this, "Error method aksiLogin() : " + se);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JDesktopPane();
        panelLogin = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        txtIDUser = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        btnLogin = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblKeterangan = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnSistem = new javax.swing.JMenu();
        mnUser = new javax.swing.JMenuItem();
        mnKeluar = new javax.swing.JMenuItem();
        mnMasterData = new javax.swing.JMenu();
        mnDataBuku = new javax.swing.JMenuItem();
        mnDataSupp = new javax.swing.JMenuItem();
        mnStokBuku = new javax.swing.JMenuItem();
        mnTransaksiJual = new javax.swing.JMenu();
        mnTransJUal = new javax.swing.JMenuItem();
        mnLapJual = new javax.swing.JMenuItem();
        mnPembelian = new javax.swing.JMenu();
        mnTransBeli = new javax.swing.JMenuItem();
        mnLapBeli = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SALENDA");

        panelMenu.setBackground(new java.awt.Color(0, 204, 204));

        txtIDUser.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "ID. User :"));
        txtIDUser.setOpaque(false);

        txtPassword.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true), "Password :"));
        txtPassword.setOpaque(false);
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });

        btnLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/login-blue.png"))); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        btnBatal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/batalsmall.png"))); // NOI18N
        btnBatal.setText("Batal");

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Silakan Login");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 41, Short.MAX_VALUE)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtIDUser, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtPassword, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtIDUser, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelLogin.addTab("Login User", new javax.swing.ImageIcon(getClass().getResource("/Icons/userrrr.png")), jPanel2); // NOI18N

        lblKeterangan.setText("ID.User : ... | Lev.User : ...");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblKeterangan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
        );

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("SELAMAT DATANG DI");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/L.png"))); // NOI18N

        panelMenu.setLayer(panelLogin, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelMenu.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelMenu.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panelMenu.setLayer(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelMenuLayout.createSequentialGroup()
                                .addGap(236, 236, 236)
                                .addComponent(jLabel3))
                            .addGroup(panelMenuLayout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(jLabel5))
                            .addGroup(panelMenuLayout.createSequentialGroup()
                                .addGap(255, 255, 255)
                                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 127, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        mnSistem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/systemd.png"))); // NOI18N
        mnSistem.setText("SISTEM");

        mnUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/userrrr.png"))); // NOI18N
        mnUser.setText("USER");
        mnUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUserActionPerformed(evt);
            }
        });
        mnSistem.add(mnUser);

        mnKeluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/logoutsmall.png"))); // NOI18N
        mnKeluar.setText("KELUAR");
        mnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnKeluarActionPerformed(evt);
            }
        });
        mnSistem.add(mnKeluar);

        jMenuBar1.add(mnSistem);

        mnMasterData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/masterdata.png"))); // NOI18N
        mnMasterData.setText("MASTER DATA");

        mnDataBuku.setText("DATA BUKU");
        mnDataBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnDataBukuActionPerformed(evt);
            }
        });
        mnMasterData.add(mnDataBuku);

        mnDataSupp.setText("DATA SUPPLIER");
        mnMasterData.add(mnDataSupp);

        mnStokBuku.setText("STOK BUKU");
        mnMasterData.add(mnStokBuku);

        jMenuBar1.add(mnMasterData);

        mnTransaksiJual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/trans.png"))); // NOI18N
        mnTransaksiJual.setText("PENJUALAN");
        mnTransaksiJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTransaksiJualActionPerformed(evt);
            }
        });

        mnTransJUal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/transsmall.png"))); // NOI18N
        mnTransJUal.setText("TRANSAKSI PENJUALAN");
        mnTransJUal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTransJUalActionPerformed(evt);
            }
        });
        mnTransaksiJual.add(mnTransJUal);

        mnLapJual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/laporsmall.png"))); // NOI18N
        mnLapJual.setText("LAPORAN PENJUALAN");
        mnLapJual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnLapJualActionPerformed(evt);
            }
        });
        mnTransaksiJual.add(mnLapJual);

        jMenuBar1.add(mnTransaksiJual);

        mnPembelian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/trans.png"))); // NOI18N
        mnPembelian.setText("PEMBELIAN");

        mnTransBeli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/transsmall.png"))); // NOI18N
        mnTransBeli.setText("TRANSAKSI PEMBELIAN");
        mnTransBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnTransBeliActionPerformed(evt);
            }
        });
        mnPembelian.add(mnTransBeli);

        mnLapBeli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/laporsmall.png"))); // NOI18N
        mnLapBeli.setText("LAPORAN PEMBELIAN");
        mnPembelian.add(mnLapBeli);

        jMenuBar1.add(mnPembelian);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelMenu)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnUserActionPerformed

    private void mnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnKeluarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnKeluarActionPerformed

    private void mnDataBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnDataBukuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnDataBukuActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        aksiLogin();
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        aksiLogin();
    }//GEN-LAST:event_btnLoginActionPerformed

    private void mnTransJUalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTransJUalActionPerformed
        IfrTransJual fr = new IfrTransJual();
        panelMenu.add(fr);
        fr.setVisible(true);
    }//GEN-LAST:event_mnTransJUalActionPerformed

    private void mnLapJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnLapJualActionPerformed
        IfrLapTransJual fr = new IfrLapTransJual();
        panelMenu.add(fr);
        fr.setVisible(true);
        
    }//GEN-LAST:event_mnLapJualActionPerformed

    private void mnTransBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTransBeliActionPerformed

    }//GEN-LAST:event_mnTransBeliActionPerformed

    private void mnTransaksiJualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnTransaksiJualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mnTransaksiJualActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblKeterangan;
    private javax.swing.JMenuItem mnDataBuku;
    private javax.swing.JMenuItem mnDataSupp;
    private javax.swing.JMenuItem mnKeluar;
    private javax.swing.JMenuItem mnLapBeli;
    private javax.swing.JMenuItem mnLapJual;
    private javax.swing.JMenu mnMasterData;
    private javax.swing.JMenu mnPembelian;
    private javax.swing.JMenu mnSistem;
    private javax.swing.JMenuItem mnStokBuku;
    private javax.swing.JMenuItem mnTransBeli;
    private javax.swing.JMenuItem mnTransJUal;
    private javax.swing.JMenu mnTransaksiJual;
    private javax.swing.JMenuItem mnUser;
    private javax.swing.JTabbedPane panelLogin;
    private javax.swing.JDesktopPane panelMenu;
    private javax.swing.JTextField txtIDUser;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}