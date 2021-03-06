/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

/**
 *
 * @author radhi
 */
public class BillsPdf {

    public BillsPdf() {
     // - Paramètres de connexion à la base de données
        String url = "jdbc:mysql://localhost:3306/serveco";     
        String login = "root"; 
        String  password = "root";
        Connection connection;
        try {
            // - Connexion à la base
            connection=DriverManager.getConnection(url,login,password);
            // - Chargement et compilation du rapport
            JasperDesign jasperDesign = JRXmlLoader.load("D:\\report1.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
            // - Paramètres à envoyer au rapport
            Map  parameters = new HashMap();
            parameters.put("Titre", "Titre");
            // - Execution du rapport
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
            // - Création du rapport au format PDF
            JasperExportManager.exportReportToPdfFile(jasperPrint, "D:\\bills.pdf");
        }
        catch (JRException e) {
            System.out.println("erreur de compilation"+ e.getMessage());
         } catch (SQLException e) {
            System.out.println("erreur SQL"+e.getMessage());
        }

    }
  
     
    
}
