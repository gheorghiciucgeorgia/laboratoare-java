package Test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Testare.MainFrame;

public class ImagePanelTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("incepere testare");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("sfarsit testare");
	}

	@Test
	public void testImagePanel() throws IOException {
		//fail("Not yet implemented");
		MainFrame mf=new MainFrame();
		assertNotNull(mf);
		System.out.println("Verificare ImagePanel");
	}

	@Test
	public void testPaintComponentGraphics() {
		//fail("Not yet implemented");
		System.out.println("Verificare TestPaintComponent");
	}
	
	/*@Test
	 * 
	public Rectangle2D.Float testmakeRectangle(int x1,int y1,int x2,int y2){
	Rectangle2D.Float rf= new Rectangle2D.Float(4,5,1,1);
	Rectangle2D.Float rff = testmakeRectangle(4,5,5,6);
	assertNotEquals(rf,rff);
		
	}*/
}
