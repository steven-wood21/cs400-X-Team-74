/**
 * STILL NEED TO COMMENT
 */

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

//
public class GraphProcessorTest {
	private static GraphProcessor grPro;
	
	//
	@BeforeClass
	public static void setUpBeforeClass() {
		grPro = new GraphProcessor();
	}
	
	//
	@AfterClass
	public static void tearDownAfterClass() {
		
	}
	
	//
	@Before
	public void setUp() {
		
	}
	
	//
	@After
	public void tearDown() {
		
	}
	
	//
	@Test
	public final void test01_populateGraph() {
		Integer actual = grPro.populateGraph("word_list.txt");
		//grPro.shortestPathPrecomputation();
		Integer expected = 441;
		if(! actual.equals(expected)) {
			fail("Expected: " + expected + " Actual: " + actual);
		}
	}
	
	//
	@Test
	public final void test02_getShortestPath_one_away() {
		grPro.populateGraph("word_list.txt");
		//grPro.shortestPathPrecomputation();
		ArrayList<String> actual = (ArrayList<String>) grPro.getShortestPath("BATH", "BASH");
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("BATH");
		expected.add("BASH");
		for(int i = 0; i < expected.size(); i++) {
			if(! actual.get(i).equals(expected.get(i)))
				fail("Expected: " + expected.get(i) + " Actual: " + actual.get(i));
		}
	}
	
	//
	@Test
	public final void test03_getShortestDistance_one_away() {
		grPro.populateGraph("word_list.txt");
		//grPro.shortestPathPrecomputation();
		Integer actual = grPro.getShortestDistance("BATH", "BASH");
		Integer expected = 1;
		if(! actual.equals(expected))
			fail("Expected: " + expected + " Actual: " + actual);
	}
	
	//
	@Test
	public final void test04_getShortestPath_three_away() {
		grPro.populateGraph("word_list.txt");
		//grPro.shortestPathPrecomputation();
		ArrayList<String> actual = (ArrayList<String>) grPro.getShortestPath("BATH", "BEST");
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("BATH");
		expected.add("BASH");
		expected.add("BAST");
		expected.add("BEST");
		for(int i = 0; i < expected.size(); i++) {
			if(! expected.get(i).equals(actual.get(i)))
				fail("Expected: " + expected.get(i) + " Actual: " + actual.get(i));
		}
	}
	
	//
	@Test
	public final void test05_getShortestPath_unreachable() {
		grPro.populateGraph("word_list.txt");
		//grPro.shortestPathPrecomputation();
		ArrayList<String> actual = (ArrayList<String>) grPro.getShortestPath("BATH", "HETEROGENEOUS"); //I think these don't touch
		ArrayList<String> expected = null;
		if(! (actual == expected))
			fail("Expected: " + expected + " Actual: " + actual);
	}
	
	//
	@Test
	public final void test06_getShortestDistance_78_away() {
		grPro.populateGraph("word_list.txt");
		//grPro.shortestPathPrecomputation();
		Integer actual = grPro.getShortestDistance("CHARGE", "GIMLETS");
		Integer expected = 78;
		if(! expected.equals(actual))
			fail("Expected: " + expected + " Actual: " + actual);
	}
	
	//
	@Test
	public final void test07_getShortestDistance_unreachable() {
		grPro.populateGraph("word_list.txt");
		//grPro.shortestPathPrecomputation();
		Integer actual;
		try {
			actual = grPro.getShortestDistance("BATH", "HETEROGENOUS"); //I think these don't touch
		}
		catch (NullPointerException e) {return;}
		fail("Expected: NullPointerException Actual: " + actual);
	}
	
	//
	@Test
	public final void test08_getShortestPath_same_word() {
		grPro.populateGraph("word_list.txt");
		//grPro.shortestPathPrecomputation();
		ArrayList<String> actual = (ArrayList<String>) grPro.getShortestPath("BATH", "BATH");
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("BATH");
		for(int i = 0; i < expected.size(); i++) {
			if(!(expected.get(i).equals(actual.get(i))))
				fail("Expected: " + expected + " Actual: " + actual);
		}
	}
	
	//
	@Test
	public final void test09_getShortestDistance_same_word() {
		grPro.populateGraph("word_list.txt");
		//grPro.shortestPathPrecomputation();
		Integer actual = grPro.getShortestDistance("BATH", "BATH");
		Integer expected = 0;
		if(! actual.equals(expected))
			fail("Expected: " + expected + " Actual: " + actual);
		
	}
	
	//
	@Test
	public final void test10_isAdjacent_when_adjacent() {
		boolean actual = WordProcessor.isAdjacent("BATH", "BASH");
		if(!actual)
			fail("Expected: true Actual: " + actual);
	}
	
	//
	@Test
	public final void test11_isAdjacent_when_not() {
		boolean actual = WordProcessor.isAdjacent("BATH", "CHARGE");
		if(actual)
			fail("Expected: false Actual: " + actual);
	}
	
	//
	@Test
	public final void test12_isAdjacent_when_same() {
		boolean actual = WordProcessor.isAdjacent("BATH", "BATH");
		boolean expected = false;
		if(!(actual == expected))
			fail("Expected: " + expected + " Actual: " + actual);
	}
	
	//
	@Test
	public final void test13_getShortestPath_given_nonexistant_vertices() {
		grPro.populateGraph("word_list.txt");
		//grPro.shortestPathPrecomputation();
		ArrayList<String> actual;
		try {
			actual = (ArrayList<String>) grPro.getShortestPath("BAT", "CAT");
		}
		catch(NullPointerException e) {
			return;
		}
		fail("Expected: NullPointerException Actual: " + actual);
	}
	
	//
	@Test
	public final void test14_getShortestDistance_given_nonexistant_vertices() {
		grPro.populateGraph("word_list.txt");
		//grPro.shortestPathPrecomputation();
		Integer actual;
		try {
			actual = grPro.getShortestDistance("bat", "cat");
		}
		catch(NullPointerException e) {
			return;
		}
		fail("Expected: NullPointerException Actual: " + actual);
	}
	
	//Test WordProcessor.getWordStream
	
	
	//Test graphProcessor.shortestPathPrecomputation

}
