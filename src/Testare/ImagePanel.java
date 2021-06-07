package Testare;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
/**
 * 
 * @author Echipa Vesela
 *
 */

public class ImagePanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private BufferedImage image;
    private Shape shape = null;
    Point startDrag, endDrag;
    /**
     * Image Panel contribuie la adaugarea zonei selectate in campul AreaZone
     * @param inputImage Parametrul prin care functia primeste path-ul imaginii ce va fi vizualizata.
     * @param mainFrame  Parametru prin care functia primeste Frame-ul principal.
     * @throws IOException Se va apela o exceptie atunci cand incepe selectarea zonei de interes
     */
    public ImagePanel( String inputImage, MainFrame mainFrame) throws IOException {
        final MainFrame mf = mainFrame;
        image = ImageIO.read(new File(inputImage));
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                startDrag = new Point(e.getX(), e.getY());
                endDrag = startDrag;
                repaint();
            }
            /**
             * Funcția mouseReleased () este apelată de fiecare dată când este eliberat un buton al mouse-ului,
             * verificand daca au fost selectate cele 2 puncte
             */
            public void mouseReleased(MouseEvent e) {
                if(endDrag!=null && startDrag!=null) {
                    try {
                        shape = makeRectangle(startDrag.x, startDrag.y, e.getX(),
                                e.getY());
                        mf.updateSelectedRegion(image.getSubimage(startDrag.x, startDrag.y, e.getX()-startDrag.x, e.getY()-startDrag.y));   
                        System.out.println("Punct de start: "+startDrag.x+","+startDrag.y+"."+ "Punct de sfarsit: "+endDrag.x+","+endDrag.y+" .");
                        startDrag = null;
                        endDrag = null;
                        repaint();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }   
                }
            }
        });
        /**
         * Funcția mouseDragged () este apelată de fiecare dată când mouse-ul se mișcă în timp ce este apăsat 
         * un buton al mouse-ului
         */
        this.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseDragged(MouseEvent e) {
                endDrag = new Point(e.getX(), e.getY());
                repaint();
            }   
        });
    }
    /**
     * Se marcheaza zona selectata intr-un dreptunghi cu margine neagra si interior de cuoare galbena.
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(image, 0, 0, null);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setStroke(new BasicStroke(2));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                0.50f));

        if (shape != null) {
            g2.setPaint(Color.BLACK);
            g2.draw(shape);
            g2.setPaint(Color.YELLOW);
            g2.fill(shape);
        }
        
        if (startDrag != null && endDrag != null) {
            g2.setPaint(Color.LIGHT_GRAY);
            Shape r = makeRectangle(startDrag.x, startDrag.y, endDrag.x,
                    endDrag.y);
            g2.draw(r);
           
        }
        
    }
    /**
     * Crearea dreptunghiului
     * 
     * @param x1	-	coordonata x a punctului de inceput
     * @param y1	-	coordonata y a punctului de inceput
     * @param x2	-	coordonata x a punctului de sfarsit
     * @param y2	-	coordonata y a punctului de sfarsit
     * @return
     */
    private Rectangle2D.Float makeRectangle(int x1, int y1, int x2, int y2) {
    	return new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2),
                Math.abs(x1 - x2), Math.abs(y1 - y2));
        
    }
    
}
