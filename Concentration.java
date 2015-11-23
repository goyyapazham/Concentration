import cs1.Keyboard;  //if comfortable with Scanner, you may comment this out

		
public class Concentration {

//instance variables

    private Tile[][] _board;     //storage for 4x4 grid of Tiles.
    private int _numberFaceUp;   //count of Tiles with faces visible
    private String[] _words;     //list of unique Strings used for Tile vals
    private static int _numRows = 4;

    //insert constructor and methods here

    public Concentration {
        _board = setBoard();
	_numberFaceUp = 0;
	_words = { "a", "b", "c", "d", "e", "f", "g", "h" }
    }

    public Tile[][] setBoard() {

	for(int r = 0; r < 4; r++) {
	    for(int c = 0; c < 4; c++) {
		_board[r][c] = _words[4*r + c];
	    }
	}

	int rand1 = (int)(Math.random() * 4);
	int rand2 = (int)(Math.random() * 4);
	
	for(int r = 0; r < 4; r++) {
	    for(int c = 0; c < 4; c++) {
		swap(_board, r, c, rand1, rand2);
	    }
	}

	return _board;

    }

    public static void swap(Object[][] a, int r1, int r2, int c1, int c2) {
	Object o1 = a[r1][c1];
	Object o2 = a[r2][c2];
	a[r1][c1] = o2;
	a[r2][c2] = o2;
    }

    

    //DO NOT MODIFY main()
    public static void main(String[] args){
	Concentration game = new Concentration();
	game.play();
    }

}//end class Concentration

