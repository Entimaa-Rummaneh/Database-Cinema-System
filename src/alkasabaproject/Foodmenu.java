/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alkasabaproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Foodmenu extends javax.swing.JFrame {

    //private ArrayList<Food> data;
    //private ObservableList<Food> dataList;
    private String dbURL;
    private String dbUsername = "root";
    private String dbPassword = "1180070";
    private String URL = "127.0.0.1";
    private String port = "3306";
    private String dbName = "Alkasaba_cinema";
    private Connection con;
    PreparedStatement ps = null;
    ResultSet srt = null;
    int index;

    public Foodmenu() {
        initComponents();
        connection();
        displayData();
    }
    
    private Connection connection()  {  //throws ClassNotFoundException, SQLException
		
	dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
	Properties p = new Properties();
	p.setProperty("user", dbUsername);
	p.setProperty("password", dbPassword);
	p.setProperty("useSSL", "false");
	p.setProperty("autoReconnect", "true");
	
	try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection (dbURL, p);
            //JOptionPane.showMessageDialog(null,"conncted");
            return con;
        }
		
        catch (SQLException ex){
            Logger.getLogger(Foodmenu.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"not conncted1");
            return null;
        }
        catch (ClassNotFoundException ex1){
            Logger.getLogger(Foodmenu.class.getName()).log(Level.SEVERE, null, ex1);
            JOptionPane.showMessageDialog(null,"not conncted2");
            return null;
        }
    }
    
    public boolean checkinputs(){
        if (txt_id.getText() == null || txt_name.getText() == null || txt_price.getText() == null || txt_cost.getText() == null){
            return false;
        }
        else{
            try{
                Float.parseFloat(txt_price.getText());
                Float.parseFloat(txt_cost.getText());
                return true;
            }
            catch (Exception ex){
                return false;
            }
        }
    }
    
    private void displayData(){
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        model.setRowCount(0);
        con = connection();
        try{
            String sql = "select * from Food";
            ps = con.prepareStatement(sql);
            srt = ps.executeQuery();
            while (srt.next()){
                model.addRow(new Object[]{srt.getString(1),srt.getString(2),srt.getString(3),srt.getString(4)});
            }
        }
        catch(Exception ex){
            
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        txt_name = new javax.swing.JTextField();
        txt_cost = new javax.swing.JTextField();
        insert_btn = new javax.swing.JButton();
        deleteall_btn = new javax.swing.JButton();
        update_btn = new javax.swing.JButton();
        delete_btn1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Food Menu");

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("meal_id");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("price");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("meal_name");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("cost");

        txt_id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_idActionPerformed(evt);
            }
        });

        txt_cost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_costActionPerformed(evt);
            }
        });

        insert_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alkasabaproject/icons8-add-new-48.png"))); // NOI18N
        insert_btn.setText("insert");
        insert_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insert_btnActionPerformed(evt);
            }
        });

        deleteall_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alkasabaproject/icons8-multiply-48.png"))); // NOI18N
        deleteall_btn.setText("delete all");
        deleteall_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteall_btnActionPerformed(evt);
            }
        });

        update_btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alkasabaproject/icons8-available-updates-64.png"))); // NOI18N
        update_btn.setText("update");
        update_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_btnActionPerformed(evt);
            }
        });

        delete_btn1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/alkasabaproject/icons8-multiply-48.png"))); // NOI18N
        delete_btn1.setText("delete");
        delete_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delete_btn1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "meal id", "meal name", "price", "cost"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_id, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(txt_name)
                            .addComponent(txt_price)
                            .addComponent(txt_cost))
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(279, 279, 279)
                        .addComponent(insert_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(update_btn)
                        .addGap(18, 18, 18)
                        .addComponent(delete_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(deleteall_btn)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_name, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_price, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_cost, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(insert_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(update_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(delete_btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteall_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_idActionPerformed

    private void txt_costActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_costActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_costActionPerformed

    private void insert_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insert_btnActionPerformed
        if (checkinputs()){
            try{
            String sql = "insert into Food values ('"+Integer.parseInt(txt_id.getText())+"','"+txt_name.getText()+"','"+Float.parseFloat(txt_price.getText())+"','"+Float.parseFloat(txt_cost.getText())+"')";
            ps = con.prepareStatement(sql);
            ps.execute();
            JOptionPane.showMessageDialog(null,"Done insert");
            displayData();
            
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        }
        else {
            JOptionPane.showMessageDialog(null,"one or more feilds are empty");
        }
        System.out.println("id=> "+txt_id.getText());
        System.out.println("Name=> "+txt_name.getText());
        System.out.println("price=> "+txt_price.getText());
        System.out.println("cost=> "+txt_cost.getText());
    }//GEN-LAST:event_insert_btnActionPerformed

    private void deleteall_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteall_btnActionPerformed
        try{
            ps = con.prepareStatement("delete from Food");
            ps.execute();
            JOptionPane.showMessageDialog(null,"Done Delete all data");
            displayData();
        }catch(Exception ex){
        }finally{
        }try{
            con.close();
        }catch(Exception ex){
           
        }
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Foodmenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteall_btnActionPerformed

    private void update_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_btnActionPerformed
     
        int Id = Integer.parseInt(txt_id.getText()); 
        try{
            String sql = "select meal_id from Food where meal_id = '"+Id+"'";
            ps = con.prepareStatement(sql);
            srt = ps.executeQuery();
            if(srt.next()){
                ps = con.prepareStatement("update Food set meal_name =' "+txt_name.getText() +"' where meal_id = '"+Id+"'");
                ps.execute();
                    
                ps = con.prepareStatement("update Food set price =' "+Float.parseFloat(txt_price.getText()) +"' where meal_id = '"+Id+"'");
                ps.execute();
                    
                ps = con.prepareStatement("update Food set cost =' "+Float.parseFloat(txt_cost.getText()) +"' where meal_id = '"+Id+"'");
                ps.execute();
                    
                JOptionPane.showMessageDialog(null,"Update Done");
                displayData();
            }else{
                JOptionPane.showMessageDialog(null,"ID = "+Id+" does not found");
            }
        }catch(Exception ex){
        }finally{
        }
    }//GEN-LAST:event_update_btnActionPerformed

    private void delete_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delete_btn1ActionPerformed
        
        String id = JOptionPane.showInputDialog(null,"Enter id");
        int Id = Integer.parseInt(id);    
        try{
            String sql = "select meal_id from Food where meal_id = '"+Id+"'";
            ps = con.prepareStatement(sql);
            srt = ps.executeQuery();
            if(srt.next()){
                ps = con.prepareStatement("delete from Food where meal_id = '"+Id+"'");
                ps.execute();
                JOptionPane.showMessageDialog(null,"Delete Done");
                displayData();
            }else{
                JOptionPane.showMessageDialog(null,"ID = "+Id+" does not found");
            }
        }catch(Exception ex){
        }finally{
        }
    }//GEN-LAST:event_delete_btn1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        index = jTable1.getSelectedRow();
        txt_id.setText(model.getValueAt(index,0).toString());
        txt_name.setText(model.getValueAt(index,1).toString());
        txt_price.setText(model.getValueAt(index,2).toString());
        txt_cost.setText(model.getValueAt(index,3).toString());
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(Foodmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Foodmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Foodmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Foodmenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Foodmenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton delete_btn1;
    private javax.swing.JButton deleteall_btn;
    private javax.swing.JButton insert_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txt_cost;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_name;
    private javax.swing.JTextField txt_price;
    private javax.swing.JButton update_btn;
    // End of variables declaration//GEN-END:variables
}
