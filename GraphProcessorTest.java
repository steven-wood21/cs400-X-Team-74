/////////////////////////////////////////////////////////////////////////////
//Semester:         CS400 Spring 2018
//PROJECT:          CS400_Program2
//FILES:            Graph.java, GraphADT.java, GraphProcessor.java, 
//GraphTest.java, WordProcessor.java
//
//USER:             sdwood3, adwinter, yxu368, jwindorf, zwille
//
//Instructor:       Deb Deppeler (deppeler@cs.wisc.edu)
//Bugs:             No known bugs
//
//2018 Apr 14, 2018 GraphProcessorTest.java
////////////////////////////////////////////////////////////////////////////

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This class tests the GraphProcessor and WordProcessor classes using JUnit 4
 */
public class GraphProcessorTest {
	private static GraphProcessor grPro;
	
	/**
	 * Sets up the GraphProcessor before any tests run
	 */
	@BeforeClass
	public static void setUpBeforeClass() {
		grPro = new GraphProcessor();
	}
	
	@AfterClass
	public static void tearDownAfterClass() {}

	@Before
	public void setUp() {}
	
	@After
	public void tearDown() {}
	
	/**
	 * Tests if the populateGraph method works
	 */
	@Test
	public final void test01_populateGraph() {
		Integer actual = grPro.populateGraph("word_list.txt");
		Integer expected = 441;
		if(! actual.equals(expected)) {
			fail("Expected: " + expected + " Actual: " + actual);
		}
	}
	
	/**
	 * Tests if the getShortestPath method works when the word is one away
	 */
	@Test
	public final void test02_getShortestPath_one_away() {
		grPro.populateGraph("word_list.txt");
		ArrayList<String> actual = (ArrayList<String>) grPro.getShortestPath("BATH", "BASH");
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("BATH");
		expected.add("BASH");
		for(int i = 0; i < expected.size(); i++) {
			if(! actual.get(i).equals(expected.get(i)))
				fail("Expected: " + expected.get(i) + " Actual: " + actual.get(i));
		}
	}
	
	/**
	 * Tests if the getShortestDistance method works when the word is one away
	 */
	@Test
	public final void test03_getShortestDistance_one_away() {
		grPro.populateGraph("word_list.txt");
		Integer actual = grPro.getShortestDistance("BATH", "BASH");
		Integer expected = 1;
		if(! actual.equals(expected))
			fail("Expected: " + expected + " Actual: " + actual);
	}
	
	/**
	 * Tests if the getShortestPath method works when the words are father away
	 */
	@Test
	public final void test04_getShortestPath_three_away() {
		grPro.populateGraph("word_list.txt");
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
	
	/**
	 * Tests if the getShortestPath method works when the words are not connected
	 */
	@Test
	public final void test05_getShortestPath_unreachable() {
		grPro.populateGraph("word_list.txt");
		ArrayList<String> actual = (ArrayList<String>) grPro.getShortestPath("BATH", "HETEROGENEOUS");
		ArrayList<String> expected = null;
		if(! (actual == expected))
			fail("Expected: " + expected + " Actual: " + actual);
	}
	
	/**
	 * Tests if the getShortestDistance method works when the words are farther away
	 */
	@Test
	public final void test06_getShortestDistance_78_away() {
		grPro.populateGraph("word_list.txt");
		Integer actual = grPro.getShortestDistance("CHARGE", "GIMLETS");
		Integer expected = 78;
		if(! expected.equals(actual))
			fail("Expected: " + expected + " Actual: " + actual);
	}
	
	/**
	 * Tests if the getShortestDistance method works when the words are not connected
	 */
	@Test
	public final void test07_getShortestDistance_unreachable() {
		grPro.populateGraph("word_list.txt");
		Integer actual;
		try {
			actual = grPro.getShortestDistance("BATH", "HETEROGENOUS"); 
		}
		catch (NullPointerException e) {return;}
		fail("Expected: NullPointerException Actual: " + actual);
	}
	
	/**
	 * Tests if the getShortestPath method works when given the same word
	 */
	@Test
	public final void test08_getShortestPath_same_word() {
		grPro.populateGraph("word_list.txt");
		ArrayList<String> actual = (ArrayList<String>) grPro.getShortestPath("BATH", "BATH");
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("BATH");
		for(int i = 0; i < expected.size(); i++) {
			if(!(expected.get(i).equals(actual.get(i))))
				fail("Expected: " + expected + " Actual: " + actual);
		}
	}
	
	/**
	 * Tests if the getShortestDistance method works when given the same word
	 */
	@Test
	public final void test09_getShortestDistance_same_word() {
		grPro.populateGraph("word_list.txt");
		Integer actual = grPro.getShortestDistance("BATH", "BATH");
		Integer expected = 0;
		if(! actual.equals(expected))
			fail("Expected: " + expected + " Actual: " + actual);
		
	}
	
	/**
	 * Tests whether the isAdjacent method of WordProcessor works when the words are adjacent
	 */
	@Test
	public final void test10_isAdjacent_when_adjacent() {
		boolean actual = WordProcessor.isAdjacent("BATH", "BASH");
		if(!actual)
			fail("Expected: true Actual: " + actual);
	}
	
	/**
	 * Tests whether the isAdjacent method of WordProcessor works when the words are not adjacent
	 */
	@Test
	public final void test11_isAdjacent_when_not() {
		boolean actual = WordProcessor.isAdjacent("BATH", "CHARGE");
		if(actual)
			fail("Expected: false Actual: " + actual);
	}
	
	/**
	 * Tests whether the isAdjacent method of WordProcessor works when the words are the same
	 */
	@Test
	public final void test12_isAdjacent_when_same() {
		boolean actual = WordProcessor.isAdjacent("BATH", "BATH");
		boolean expected = false;
		if(!(actual == expected))
			fail("Expected: " + expected + " Actual: " + actual);
	}
	
	/**
	 * Tests whether the getShortestPath method works when the words are not in the graph
	 */
	@Test
	public final void test13_getShortestPath_given_nonexistant_vertices() {
		grPro.populateGraph("word_list.txt");
		ArrayList<String> actual;
		try {
			actual = (ArrayList<String>) grPro.getShortestPath("BAT", "CAT");
		}
		catch(NullPointerException e) {
			return;
		}
		fail("Expected: NullPointerException Actual: " + actual);
	}
	
	/**
	 * Tests whether the getShortestDistance method works when the words are not in the graph
	 */
	@Test
	public final void test14_getShortestDistance_given_nonexistant_vertices() {
		grPro.populateGraph("word_list.txt");
		Integer actual;
		try {
			actual = grPro.getShortestDistance("bat", "cat");
		}
		catch(NullPointerException e) {
			return;
		}
		fail("Expected: NullPointerException Actual: " + actual);
	}
}
