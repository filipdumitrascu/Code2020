import java.awt.Color;

import graphics.MazeCanvas;

public class ExitCell extends EdgeCell{
	
	private static final Color exitShadeColor=Color.green;
	
	public ExitCell(MazeCanvas mazeCanvas , int row, int col) {
		super(mazeCanvas, row, col);
		mazeCanvas.drawShade(row,col,exitShadeColor );
	}
}
