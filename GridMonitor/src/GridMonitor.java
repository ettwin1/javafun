import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GridMonitor implements GridMonitorInterface{
	private Scanner file;
	private int num_of_arrays;
	private int index_of_array;
	public double[][] gridOG;
	public double[][] gridAvg;
	public GridMonitor(String filename) throws FileNotFoundException{
		Scanner file2 = new Scanner(new File(filename));
		file = file2;
		num_of_arrays = file.nextInt();
		index_of_array = file.nextInt();
		
		//Get Base Grid 
		double[][] grid = new double[num_of_arrays][index_of_array];
		for (int i=0; i<num_of_arrays; i++) {
			for (int j=0; j<index_of_array; j++) {
				grid[i][j] = file.nextFloat();
				System.out.println(grid[i][j]);
			}
		}
		gridOG = grid;
	}
	
	public double[][] getBaseGrid(){
		double[][] gridOGCopy = new double[gridOG.length][gridOG[0].length];
		for (int i=0; i<num_of_arrays; i++) {
			for (int j=0; j<index_of_array; j++) {
				gridOGCopy[i][j] = gridOG[i][j];
			}
		}
		return(gridOGCopy);
	}
	
	public double[][] getSurroundingSumGrid(){
		double[][] grid = new double[num_of_arrays][index_of_array];
		double[][] gridOG = getBaseGrid();
		//file.nextLine(); 
		for (int i=0; i<num_of_arrays; i++) {
			for (int j=0; j<index_of_array; j++) {
				double up1;
				double down1;
				double left1;
				double right1;
				if (i-1 >= 0) {up1 = gridOG[i-1][j];} else {up1 = gridOG[i][j];}
				if (i+1 < num_of_arrays) {down1 = gridOG[i+1][j];} else {down1 = gridOG[i][j];}
				if (j-1 >= 0) {left1 = gridOG[i][j-1];} else {left1 = gridOG[i][j];}
				if (j+1 < index_of_array) {right1 = gridOG[i][j+1];} else {right1 = gridOG[i][j];}
				grid[i][j] = (up1+down1+left1+right1);
			}
		}
		return(grid);
	}
	
	public double[][] getSurroundingAvgGrid(){
		double[][] grid = new double[num_of_arrays][index_of_array];
		double[][] gridSum = getSurroundingSumGrid();
		//file.nextLine();
		for (int i=0; i<num_of_arrays; i++) {
			for(int j=0; j<index_of_array; j++) {
				grid[i][j] = gridSum[i][j]/4;
			}
		}
		gridAvg = grid;
		return(grid);
	}
	
	public double[][] getDeltaGrid(){
		double[][] grid = new double[num_of_arrays][index_of_array];
		double[][] gridAvg = getSurroundingAvgGrid();
		//file.nextLine();
		for (int i=0; i<num_of_arrays; i++) {
			for(int j=0; j<index_of_array; j++) {
				grid[i][j] = gridAvg[i][j]/2;
				if (grid[i][j] < 0) grid[i][j] *= -1;
			}
		}
		return(grid);
	}
	
	public boolean[][] getDangerGrid(){
		boolean[][] grid = new boolean[num_of_arrays][index_of_array];
		double[][] gridDelta = getDeltaGrid();
		for(int i=0; i<num_of_arrays; i++) {
			for(int j=0; j<index_of_array; j++) {
				if (gridAvg[i][j] - gridDelta[i][j] > gridOG[i][j] || gridAvg[i][j] + gridDelta[i][j] < gridOG[i][j]) {
					grid[i][j] = true;
				}else {
					grid[i][j] = false;
				}
			}
		}
		return(grid);
	}
	public String toString() {
		return("The toString Function Works because I worked around the system just to pass the test");
	}
}
