import graphics.MazeCanvas;


public class Program {

	public static void main(String[] args) {
		MazeCanvas mc= new MazeCanvas(10,24,26);
		mc.open();
		
		Maze maze= new Maze(mc);
		// maze.genSnake();
		maze.initialize();
	
		System.out.printf("Rows: %d ,columns: %d\n", mc.getRows() ,mc.getCols());
		mc.pause();
		mc.close();

	}

}
