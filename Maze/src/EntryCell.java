import java.awt.Color;

import graphics.MazeCanvas;

public class EntryCell extends EdgeCell{
	
	private static final Color entryShadeColor=Color.cyan;
	
	public EntryCell(MazeCanvas mazeCanvas, int row, int col) {
		super(mazeCanvas, row, col);
		mazeCanvas.drawShade(row,col,entryShadeColor);
	}
}
