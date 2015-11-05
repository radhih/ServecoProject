package service;

/**
 *
 * @author Boss
 */
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
//import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import org.jfree.ui.ApplicationFrame;


import BusinessLogic.RemoteAdmin;
import BusinessLogic.RemoteService;
import entities.Admin;
import entities.Categorie;



public class BarChart3DDemo3 extends ApplicationFrame {

 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BarChart3DDemo3(final String title) throws IOException, SQLException {

        super(title);

        final CategoryDataset dataset = createDataset();
        final JFreeChart graphe = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(graphe);
        chartPanel.setPreferredSize(new java.awt.Dimension(400, 400));
        setContentPane(chartPanel);

    }
   

    private CategoryDataset createDataset() throws IOException, SQLException {

        // 0. Création d'un diagramme.
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//         Connexion et récupération de la base de données
        List<Categorie>el=new  ArrayList<Categorie>();
        RemoteService c=null;
    	
    			Context ctx;
    		try {
    			ctx = new InitialContext();
    			c =  (RemoteService) ctx.lookup("/WebServeco/ServiceCrud!BusinessLogic.RemoteService");
    		el=c.afficher();
    		
    		} catch (NamingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

      
        
        
        System.out.println(""+el.size());
        List<Admin> tl =new ArrayList<Admin>();
    	RemoteAdmin cc=null;
    	
    			Context ctx2;
    		try {
    			ctx2 = new InitialContext();
    			cc =  (RemoteAdmin) ctx2.lookup("/WebServeco/AdminCrud!BusinessLogic.RemoteAdmin");
    		tl=cc.findALl();
    		
    		} catch (NamingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		
        
        
        // List<pi.dev.entities.Task> tl=new  ArrayList<pi.dev.entities.Task>();
        
        
        
        
        
    		  System.out.println("service"+el.size());  
        System.out.println("admins"+tl.size());
       //tl=TaskDelegate.getAllTasks();
        int a=0;
     
        int oi=el.size()+tl.size();
        for( Categorie e: el)
        {
        	for(Admin t : tl)
        	{
        		if( t.getService()==e.getName())
	a++;
        		
        	System.out.println(a);
        	
        	}
        	System.out.println(a);
        	float m;
        	m=(a/oi)*100;
        	dataset.addValue(m, e.getName(), "");
        }
        //while (Connexion.rs.next()) {
          //  d = Connexion.rs.getDouble(2);
            //ch = Connexion.rs.getString(1);
            //System.out.println("" + d);
            //System.out.println("" + ch);
            //dataset.addValue(d, ch, "");
        //}
         /**/
        //*Valeurs statiques
//        dataset.addValue(10, "Taux de défaut de couverture", " ");
//        dataset.addValue(12, " Taux de couverture Outdoor", " ");
//        dataset.addValue(25, "Taux de couverture Indoor", " ");
//        dataset.addValue(19, "Taux de couverture Incar", " ");
//        dataset.addValue(180, "Taux ", " ");
        /**/
        return dataset;

    }

    private JFreeChart createChart(final CategoryDataset dataset) {

        final JFreeChart chart = ChartFactory.createBarChart3D(
                " Admins per Service ", // chart title
                " ", // domain axis label
                "  percentage ", // range axis label
                dataset, // data
                PlotOrientation.VERTICAL, // orientation
                true, // include legend
                true, // tooltips
                true // urls
                );

        final CategoryPlot plot = chart.getCategoryPlot();
        final CategoryAxis axis = plot.getDomainAxis();
        axis.setCategoryLabelPositions(
                CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 2.0));

        final CategoryItemRenderer renderer = plot.getRenderer();
        renderer.setItemLabelsVisible(true);
        

//       final BarRenderer r = (BarRenderer) renderer;
//      DecimalFormat decimalformat1 = new DecimalFormat("#.#");
        

        return chart;

    }

    //public static void main(final String[] args) throws IOException, SQLException {
      //  final BarChart3DDemo3 demo = new BarChart3DDemo3("Test de la couverture ");
        //demo.pack();
        //RefineryUtilities.centerFrameOnScreen(demo);
        //demo.setVisible(true);
    //}

     
}
