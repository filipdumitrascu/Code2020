import graphics.Graphics;

public class Program {

	public static final int mortarSize=2;
	public static void desenlinie(int x, int y, int l, int perechi ) {
		for(int i=0;i<perechi;i++) {
			Graphics.cafeWall.drawDarkSquare(x+i*2*l,y,l);
			Graphics.cafeWall.drawBrightSquare(x+i*2*l+l,y,l);
		}
	}
	
	public static void grid (int x, int y, int l, int perechi, int r, int offset) {
		for(int i=0;i<r;i++) {
			desenlinie(x+(i%2)*offset,y+(mortarSize+l)*i,l,perechi);
		}
	}
	public static void main(String[] args){
		Graphics.cafeWall.open();

		desenlinie(0,0,20,4);
		desenlinie(50,70,30,5);
		grid(10,150,25,4,8,0);
		grid(250,200,25,3,6,10);
		grid(425,180,20,5,10,10);
		grid(400,20,35,2,4,35);
		Graphics.cafeWall.pause();
		Graphics.cafeWall.close();
		
	}
	
}
	