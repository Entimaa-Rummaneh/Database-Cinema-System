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
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class CafeteriaEmployee extends javax.swing.JFrame {

    /**
     * Creates new form CafeteriaEmployee
     */
    
    private String dbURL;
    private String dbUsername = "root";
    private String dbPassword = "1180070";
    private String URL = "127.0.0.1";
    private String port = "3306";
    private String dbName = "Alkasaba_cinema";
    private Connection con;
    PreparedStatement ps = null;
    ResultSet srt = null;
    String MEALNAME;
    int mealID;
    
    public CafeteriaEmployee() {
        initComponents();
        connection();
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
        if (idC.getText() == null || nameC.getText() == null || phoneC.getText() == null ){
            return false;
        }
        else{
            try{
                Integer.parseInt(idC.getText());
                Integer.parseInt(phoneC.getText());
                return true;
            }
            catch (Exception ex){
                return false;
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Mname = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        price = new javax.swing.JTextField();
        quantity = new javax.swing.JTextField();
        date = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        idC = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nameC = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        phoneC = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        chef = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Enter meal name");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        Mname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MnameActionPerformed(evt);
            }
        });
        jPanel1.add(Mname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 130, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Items"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 150, 130));
        jPanel1.add(price, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 40, 30));
        jPanel1.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 60, 30));
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 80, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Price");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Quantity");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 200, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Date");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Customer Info");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, -1, -1));
        jPanel1.add(idC, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 300, 40, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ID");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, -1, -1));
        jPanel1.add(nameC, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 300, 90, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Name");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 60, -1));
        jPanel1.add(phoneC, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 100, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Phone");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, -1, -1));

        jButton1.setText("Make Order");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 330, -1, -1));

        jButton2.setText("Edit menu");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 410, -1, -1));

        chef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chefActionPerformed(evt);
            }
        });
        jPanel1.add(chef, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 410, 90, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Enter chef name");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 390, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\1202\\Database\\AlkasabaProject\\src\\popcorn.PNG")); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void MnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MnameActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        String mealM = Mname.getText();
        con = connection();
        try {
            String sql = "select meal_name from Food where meal_name like '%"+mealM+"%'";
            ps = con.prepareStatement(sql);
            srt = ps.executeQuery();
            while (srt.next()) {
                model.addRow(new Object[]{srt.getString(1)});
            }
        } catch (Exception ex) {
        } finally {
        }
        
    }//GEN-LAST:event_MnameActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int index = jTable1.getSelectedRow();
        MEALNAME = model.getValueAt(index,0).toString();
        con = connection();
        try {
            String sql = "select f.price from Food f where f.meal_name = '"+MEALNAME+"'";
            ps = con.prepareStatement(sql);
            srt = ps.executeQuery();
            while (srt.next()) {
                float num = srt.getFloat("price");
                price.setText(Float.toString(num));
               
            }
        } catch (Exception ex) {
        } finally {
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String Mprice = price.getText();
        float meal_price = Float.parseFloat(Mprice);
        
        String Mquantity = quantity.getText();
        int meal_quantity = Integer.parseInt(Mquantity);
        String Mdate = date.getText();
        String idcustomer = idC.getText();
        int CID = Integer.parseInt(idcustomer);
        String name = nameC.getText();
        String phone = phoneC.getText();
        int NUM = Integer.parseInt(phone);
        
        con = connection(); 
        try {
            String sql = "select meal_id from Food where meal_name = '"+MEALNAME+"'"; 
            ps = con.prepareStatement(sql);
            srt = ps.executeQuery();
            while (srt.next()) {
            mealID = srt.getInt("meal_id");                
            }
            } catch (Exception ex) {
            } finally {  
            }
        
            try {
            String sql = "insert into cust2food values ('"+CID+"','"+mealID+"','"+Mdate+"','"+meal_quantity+"')";
            ps = con.prepareStatement(sql);
           // srt = ps.executeQuery();
           ps.execute();
            JOptionPane.showMessageDialog(null,"Done 1");
            } catch (Exception ex) {
            } finally {  
            }
            
            if (checkinputs()){
            try{
            String sql = "insert into Customers values ('"+CID+"','"+name+"','"+NUM+"')";
            ps = con.prepareStatement(sql);
            ps.execute();
           //JOptionPane.showMessageDialog(null,"Done 2");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        }
        else {
            JOptionPane.showMessageDialog(null,"one or more feilds are empty");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Foodmenu employee = new Foodmenu();
        employee.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void chefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chefActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_chefActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        con = connection();
        String chefname = chef.getText();
        try {
            String sql = "select F.meal_id , F.meal_name\n" +
                            "from Food F, chefs c0, chef2food c1, Cafeteria_Employees_manges c2\n" +
                            "where \n" +
                            "       F.meal_id = c1.meal_id and\n" +
                            "       c1.chef_id = c0.SSN and \n" +
                            "       c0.SSN = c2.SSN  and\n" +
                            "       c2.EMP_name ='"+chefname+"'";
            ps = con.prepareStatement(sql);
            srt = ps.executeQuery();
            while (srt.next()) {
                int IDmeal = srt.getInt("F.meal_id");
                String mealName = srt.getNString("F.meal_name");
                JOptionPane.showMessageDialog(null,"meal id:"+ IDmeal +", meal name: "+mealName);
            }/*else {
                JOptionPane.showMessageDialog(null,"not found");
            }*/

        } catch (Exception ex) {
        } finally {
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(CafeteriaEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CafeteriaEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CafeteriaEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CafeteriaEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CafeteriaEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Mname;
    private javax.swing.JTextField chef;
    private javax.swing.JTextField date;
    private javax.swing.JTextField idC;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField nameC;
    private javax.swing.JTextField phoneC;
    private javax.swing.JTextField price;
    private javax.swing.JTextField quantity;
    // End of variables declaration//GEN-END:variables
}