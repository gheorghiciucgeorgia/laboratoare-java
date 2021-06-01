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
		
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testMain() {
		//fail("Not yet implemented");
	}

	@Test
	public void testMainFrame() throws IOException {
		//fail("Not yet implemented");
		MainFrame window = new MainFrame();
		assertNotNull(window.imagePath);
	}

	@Test
	public void testUpdateSelectedRegion() {
		//fail("Not yet implemented");
		//Graphics g = selectedAreaPanel.getGraphics();
	}

}
