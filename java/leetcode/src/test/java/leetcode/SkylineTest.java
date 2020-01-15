package leetcode;

import static org.junit.Assert.*;

import org.junit.Test;

public class SkylineTest {

	Skyline skyline = new Skyline();
	
	@Test
	public void oneSizeTest() {
		int [][] grid = {{5},{5}};
		int output = skyline.maxIncreaseKeepingSkyline(grid);
		assertEquals("One Size Test",0, output);
	} 

	
	@Test
	public void twoSizeTest() {
		int [][] grid = {{2,5},{4,6}};
		int output = skyline.maxIncreaseKeepingSkyline(grid);
		assertEquals("Two Size Test",0, output);
	} 

	
	@Test
	public void threeSizeTest() {
		int [][] grid = {{2,5,9},{12,4,6},{5,6,10}};
		int output = skyline.maxIncreaseKeepingSkyline(grid);
		assertEquals("Three Size Test",0, output);
	} 

	
	@Test
	public void fourSizeTest() {
		int [][] grid = {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
		int output = skyline.maxIncreaseKeepingSkyline(grid);
		assertEquals("Three Size Test",35, output);
	} 

}
