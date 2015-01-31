package modelo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.XYItemLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
/**
 * @web http://www.jc-mouse.net
 * @author Mouse
 */
public class XYLineChart extends ImageIcon{

    /** Constructor de clase 
 * @param d Dimension
 */
    public XYLineChart( Dimension d ){

        //se declara el grafico XY Lineal
        XYDataset xydataset = xyDataset();
        JFreeChart jfreechart = ChartFactory.createXYLineChart(
        "Ingresos semanales" , "1ra semana del mes de Junio", "Ingresos en euros",  
        xydataset, PlotOrientation.VERTICAL,  true, true, false);               

        //personalización del grafico
        XYPlot xyplot = (XYPlot) jfreechart.getPlot();
        xyplot.setBackgroundPaint( Color.white );
        xyplot.setDomainGridlinePaint( Color.BLACK );
        xyplot.setRangeGridlinePaint( Color.BLACK );        
        // -> Pinta Shapes en los puntos dados por el XYDataset
        XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer) xyplot.getRenderer();
        xylineandshaperenderer.setBaseShapesVisible(true);
        //--> muestra los valores de cada punto XY
        XYItemLabelGenerator xy = new StandardXYItemLabelGenerator();
        xylineandshaperenderer.setBaseItemLabelGenerator( xy );
        xylineandshaperenderer.setBaseItemLabelsVisible(true);
 xylineandshaperenderer.setBaseLinesVisible(true);
 xylineandshaperenderer.setBaseItemLabelsVisible(true);                
        //fin de personalización

        //se crea la imagen y se asigna a la clase ImageIcon
        BufferedImage bufferedImage  = jfreechart.createBufferedImage( d.width, d.height);
        this.setImage(bufferedImage);
    }

    /**
 * Datos
 */
    private XYDataset xyDataset()
    {
        //se declaran las series y se llenan los datos
        XYSeries sIngresos = new XYSeries("Ingresos");
        XYSeries sEgresos = new XYSeries("Egresos");        
        //serie #1
        sIngresos.add( 1, 340);
        sIngresos.add( 2, 210);
        sIngresos.add( 3, 410);
        sIngresos.add( 4, 200);
        sIngresos.add( 5, 525);
        sIngresos.add( 6, 492);
        sIngresos.add( 7, 390);
        //serie #2
        sEgresos.add( 1, 90);
        sEgresos.add( 2, 434);
        sEgresos.add( 3, 741);
        sEgresos.add( 4, 91);
        sEgresos.add( 5, 412);
        sEgresos.add( 6, 361);
        sEgresos.add( 7, 271);

        XYSeriesCollection xyseriescollection =  new XYSeriesCollection();
        xyseriescollection.addSeries( sIngresos );        
        xyseriescollection.addSeries( sEgresos );        

        return xyseriescollection;
    }

}//-->fin clase