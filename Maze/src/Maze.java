import java.awt.Color;

import graphics.MazeCanvas;
import graphics.MazeCanvas.Side;

public class Maze {
	
	private Cell[][] gridOfCells;
    private MazeCanvas canvas;
    private EntryCell entryCell;
    private ExitCell exitCell;
    
    public Maze(MazeCanvas m) {
        canvas = m;
        gridOfCells= new Cell[m.getRows()][m.getCols()];
    }
    
    
    public Cell getEntryCell() {
    	return entryCell;
    }
    
    public Cell getExitCell() {
    	return exitCell;
    }
    public void genSnake() {
       for(int row=0; row< canvas.getRows(); row++) {
    	   for(int col=0; col< canvas.getCols();col++) {
    		   boolean top=row==0;
    		   boolean bottom =row ==canvas.getRows()-1;
    		   
    		   canvas.drawCell(row, col);
    		   if(top) {
    			   canvas.drawCenter(row, col, new Color(200, 0, 0));
    			   
    			   canvas.eraseWall(row,col, Side.Bottom);
    			   canvas.drawPath(row,col, Side.Bottom, Color.red);
    			   
    			   if(col%2==0) {
    				   canvas.eraseWall(row,col, Side.Left);
        			   canvas.drawPath(row,col, Side.Left, Color.red);
    			   }else {
    				   canvas.eraseWall(row,col, Side.Right);
        			   canvas.drawPath(row,col, Side.Right, Color.red);
    			   }
    		   }else if (bottom) {
    			   canvas.drawCenter(row, col, new Color(200, 0, 0));
    			   
    			   canvas.eraseWall(row,col, Side.Top);
    			   canvas.drawPath(row,col, Side.Top, Color.red);
    		   
    		   if(col%2 ==1) {
    			   canvas.eraseWall(row,col, Side.Left);
    			   canvas.drawPath(row,col, Side.Left, Color.red);
    		   }else {
    			   	canvas.eraseWall(row,col, Side.Right);
    		   		canvas.drawPath(row,col, Side.Right, Color.red);
    		   	}
    		   }else {
    			   canvas.drawCenter(row, col, Color.red);
    		   
    			   canvas.drawPath(row,col, Side.Top, Color.red);
    			   canvas.eraseWall(row,col, Side.Top);
    		   
    			   canvas.drawPath(row,col, Side.Bottom, Color.red);
    			   canvas.eraseWall(row,col, Side.Bottom);
    	   		}
    	   }
   		}
    }
    
    
    public void initialize() {
    	
    	int nPerim=2*canvas.getRows()+2*canvas.getCols()-4;
    	int iEntry=(int)(Math.random()*nPerim);
    	int iExit=(int)((Math.random()*(nPerim-1)+iEntry+1)%nPerim);
    	int edgeCount=0;
    	int count=(canvas.getRows()-2)*(canvas.getCols()-2);
    	count=(int)(count*0.05);
    	for(int i=0; i<=canvas.getRows()-1;i++) {
    		for(int j=0;j<=canvas.getCols()-1;j++) {
    			if(i==0||i==canvas.getRows()-1||j==canvas.getCols()-1||j==0) {
    				if(edgeCount==iEntry) {
    					gridOfCells[i][j]=new EntryCell(canvas,i,j);
    					entryCell=(EntryCell) (gridOfCells[i][j]);
    				}else if (edgeCount==iExit) {
    					gridOfCells[i][j]=new ExitCell(canvas,i,j);
    					exitCell=(ExitCell) (gridOfCells[i][j]);
    				}else {
    					gridOfCells[i][j]=new EdgeCell(canvas,i,j);
    				}
    				edgeCount++;
    			}
    			else if(Math.random()<0.05 && count>0) {
    				gridOfCells[i][j]=new BlockCell(canvas, i, j);
    			}
    			else {
    				gridOfCells[i][j]=new Cell(canvas,i,j);
    			}
    		}
    	}
    }
    public Cell getCell(int row, int col) {
    	return gridOfCells[row][col];
    }
}