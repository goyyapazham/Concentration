import cs1.Keyboard;  //if comfortable with Scanner, you may comment this out

		
public class Concentration {

//instance variables

    private Tile[][] _board = new Tile[4][4];     //storage for 4x4 grid of Tiles.
    private int _numberFaceUp;   //count of Tiles with faces visible
    private String[] _words;     //list of unique Strings used for Tile vals
    private static int _numRows = 4;

    //insert constructor and methods here

    public Concentration() {
	_numberFaceUp = 0;
	_words = new String[] { "a", "b", "c", "d", "e", "f", "g", "h" };
	_board = setBoard();
    }

    public Tile[][] setBoard() {
	int index = 0;
	for(int r = 0; r < 4; r++) {
	    for(int c = 0; c < 4; c++) {
		Tile t = new Tile (_words[index]);
		_board[r][c] = t ;
		index ++;
	        if (index == 8){
		    index = 0;}
	    }
	}
	

	
	for(int r = 0; r < 4; r++) {
	    for(int c = 0; c < 4; c++) {
	    int rand1 = (int)(Math.random() * 4);
	    int rand2 = (int)(Math.random() * 4);
	    swap(_board, r, c, rand1, rand2);
	    }
	}

	return _board;

    }

    public static void swap(Object[][] a, int r1, int r2, int c1, int c2) {
	Object holder = a[r1][c1];
        a[r1][c1] = a[r2][c2];
        a[r2][c2] = holder;      
    }

    public String toString() {
	String retBoard = "";
	for(int r = 0; r < 4; r++) {
	    for(int c = 0; c < 4; c++) {
	        retBoard += _board[r][c] + "\t";
	    }
	    retBoard += "\n";
	}
	return retBoard;
    }

    //DO NOT MODIFY main()
    public static void main(String[] args){
	Concentration game = new Concentration();
	System.out.print(game);
	//game.play();
    }

}//end class Concentration

