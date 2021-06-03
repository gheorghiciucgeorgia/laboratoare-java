package Test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Testare.MainFrame;

public class MainFrameTest {

	@Before
	public void setUp() throws Exception {
		System.out.println("incepere testare");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("sfarsit testare");
	}

	@Test
	public void testMain() {
		//fail("Not yet implemented");
		System.out.println("Verificare Main");
	}

	@Test
	public void testMainFrame() throws IOException {
		//fail("Not yet implemented");
		MainFrame window = new MainFrame();
		assertNotNull(window.imagePath);
		System.out.println("Verificare MainFrame");
	}

	@Test
	public void testUpdateSelectedRegion() {
		//fail("Not yet implemented");
		//Graphics g = selectedAreaPanel.getGraphics();
		System.out.println("Verificare UpdateSelectedRegion");
	}

}
