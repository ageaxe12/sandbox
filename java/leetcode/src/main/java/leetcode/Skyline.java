package leetcode;

import java.util.Arrays;

/**
 * In a 2 dimensional array grid, each value grid[i][j] represents the height of
 * a building located there. We are allowed to increase the height of any number
 * of buildings, by any amount (the amounts can be different for different
 * buildings). Height 0 is considered to be a building as well.
 * 
 * At the end, the "skyline" when viewed from all four directions of the grid,
 * i.e. top, bottom, left, and right, must be the same as the skyline of the
 * original grid. A city's skyline is the outer contour of the rectangles formed
 * by all the buildings when viewed from a distance. See the following example.
 * 
 * What is the maximum total sum that the height of the buildings can be
 * increased?
 * 
 * https://leetcode.com/problems/max-increase-to-keep-city-skyline/
 * 
 * @author apal2
 *
 */

public class Skyline {
	public int maxIncreaseKeepingSkyline(int[][] grid) {

		return this.twoLoops(grid);
	}

	public int twoLoops(int[][] grid) {
		int[] leftMax = new int[grid.length];
		int[] bottomMax = new int[grid.length];

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (j == 0) {
					leftMax[i] = grid[i][j];
				} else if (grid[i][j] > leftMax[i]) {
					leftMax[i] = grid[i][j];
				}

				if (i == 0) {
					bottomMax[j] = grid[i][j];
				} else if (grid[i][j] > bottomMax[j]) {
					bottomMax[j] = grid[i][j];
				}

			}
		}

		int incrementCount = 0 ;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] < leftMax[i] &&  grid[i][j] < bottomMax[j] && leftMax[i] < bottomMax[j]) {
					//increment = leftMax[i] - grid[i][j];
					//grid[i][j] += increment;
					incrementCount += (leftMax[i] - grid[i][j]);	
				}else if (grid[i][j] < leftMax[i] &&  grid[i][j] < bottomMax[j] ){
					//increment = bottomMax[j] - grid[i][j];
					//grid[i][j] += increment;
					incrementCount += (bottomMax[j] - grid[i][j]);	
				}
				
			}
		}

		return incrementCount;
	}
}
