import java.awt.Color;
import java.util.ArrayList;

import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class EdgeCell extends ShadedCell{
	private ArrayList<Side> listOfEdges;
	private static final Color edgeColor = Color.red;
	
	public EdgeCell(MazeCanvas mazeCanvas, int row, int col) {
		super(mazeCanvas, row, col, edgeColor);
		listOfEdges=new ArrayList<Side>();
		if(row==0) {
			listOfEdges.add(Side.Top);
		}else if(row==mazeCanvas.getRows()-1) {
			listOfEdges.add(Side.Bottom);
		}
		
		if(col==0) {
			listOfEdges.add(Side.Left);
		}else if(col==mazeCanvas.getCols()-1) {
			listOfEdges.add(Side.Right);
		}
	}
	
	public ArrayList<Side> getWalls(){
		ArrayList<Side> walls= super.getWalls();
		walls.removeAll(listOfEdges);
		return walls;
	}
}
