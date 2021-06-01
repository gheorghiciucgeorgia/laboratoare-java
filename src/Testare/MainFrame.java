package Testare;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainFrame {
	 
	static MainFrame mfr;
	JPanel mainPanel;
    private JFrame frmSelectAreaIn;
    private JPanel selectedAreaPanel;
    private JTextField textField;
    public String[] imagePath={"images\\car1.jpg","images\\car2.jpg","images\\car3.jpg","images\\car4.jpg","images\\car5.jpg","images\\car6.jpg","images\\car7.jpg"};
    int contor=0;
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame window = new MainFrame();
                    mfr=window;
                    window.frmSelectAreaIn.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     * @throws IOException 
     */
    public MainFrame() throws IOException {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     * @throws IOException 
     */
    private void initialize() throws IOException {
        frmSelectAreaIn = new JFrame();
        frmSelectAreaIn.setTitle("Select Area In Image");
        frmSelectAreaIn.setBounds(100, 100, 708, 370);
        frmSelectAreaIn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmSelectAreaIn.getContentPane().setLayout(null);
        
        textField = new JTextField();
		textField.setBounds(30, 339, 900, 32);
		frmSelectAreaIn.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton Okbtn = new JButton("Ok");
		Okbtn.setForeground(new Color(240, 255, 255));
		Okbtn.setBackground(new Color(65, 105, 225));
		
		Okbtn.addActionListener(new ActionListener() {
			private PrintStream gout;
		public void actionPerformed(ActionEvent arg0) {
			
			
			String msg=textField.getText();
			
			try {
				FileOutputStream g = new FileOutputStream("output.txt");
				gout = new PrintStream(g);
				gout.println(" "+msg);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		});
	Okbtn.setBounds(200, 391, 97, 25);
	frmSelectAreaIn.getContentPane().add(Okbtn);
	
	JButton Nextbtn = new JButton("Next");
	Nextbtn.setForeground(new Color(240, 255, 255));
	Nextbtn.setBackground(new Color(65, 105, 225));

        
        // Image Panel display selected area of the image
        selectedAreaPanel = new JPanel();
        selectedAreaPanel.setBounds(469, 36, 221, 289);
        frmSelectAreaIn.getContentPane().add(selectedAreaPanel);
   
        
        // Image Panel display image with graphics
        mainPanel = new ImagePanel(imagePath[0], mfr);
        
        mainPanel.setBounds(10, 11, 449, 314);
        frmSelectAreaIn.getContentPane().add(mainPanel);
        
        JLabel lblSelectedArea = new JLabel("Selected Area");
        lblSelectedArea.setBounds(469, 11, 221, 14);
        frmSelectAreaIn.getContentPane().add(lblSelectedArea);
        
        Nextbtn.addActionListener(new ActionListener() {
    		
    		public void actionPerformed(ActionEvent arg0) {	
    			System.out.println("Next"+contor);
    			if(contor<6)
    				contor++;
    			else 
    				contor=0;
    			frmSelectAreaIn.getContentPane().remove(mainPanel);
    			
    			try {
					mainPanel = new ImagePanel(imagePath[contor],mfr);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    	        mainPanel.setBounds(10, 11, 449, 314);
    	        frmSelectAreaIn.getContentPane().add(mainPanel);
    			frmSelectAreaIn.repaint();
    			frmSelectAreaIn.validate();
    		}
    		});
    	Nextbtn.setBounds(400, 391, 97, 25);
    	frmSelectAreaIn.getContentPane().add(Nextbtn);
    }


    // function to update selected region of the image
    public void updateSelectedRegion(BufferedImage bufferedImage) {
        Graphics g = selectedAreaPanel.getGraphics();
        g.clearRect(0, 0, 221, 289);
        g.drawImage(bufferedImage, 0, 0, null);
    }
}