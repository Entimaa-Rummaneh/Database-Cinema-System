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



public class AlkasabaProject extends javax.swing.JFrame{
    
    private static String dbURL;
    private static String dbUsername = "root";
    private static String dbPassword = "1180070";
    private static String URL = "127.0.0.1";
    private static String port = "3306";
    private static String dbName = "Alkasaba_cinema";
    private static Connection con;
    PreparedStatement ps = null;
    ResultSet srt = null;
    int index;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //connection();
        
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
        }	
        catch (SQLException ex){
            
            JOptionPane.showMessageDialog(null,"not conncted1");  
        }
        catch (ClassNotFoundException ex1){
            
            JOptionPane.showMessageDialog(null,"not conncted2");   
        }
        WelcomeWindow welcome = new WelcomeWindow();
        welcome.setVisible(true);
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
}
