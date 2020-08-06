import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;
import java.util.ArrayList;

public class Cell {
	private int row;
	private int col;
	private MazeCanvas mazeCanvas;
	private ArrayList<Side> walls;
	
	public Cell(MazeCanvas mazeCanvas , int row, int col) {
		this.mazeCanvas=mazeCanvas;
		this.row=row;
		this.col=col;
		
		walls=new ArrayList <Side>();
		walls.add(Side.Top);
		walls.add(Side.Bottom);
		walls.add(Side.Left);
		walls.add(Side.Right);
		
		mazeCanvas.drawCell(row, col);
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public ArrayList<Side> getWalls(){
		ArrayList<Side> clone = new ArrayList<Side>();
		clone.addAll(walls);
		return clone;
	}
	
	public void removeWall(Side side) {
		mazeCanvas.eraseWall(row, col, side);
		walls.remove(side);
	}
}
