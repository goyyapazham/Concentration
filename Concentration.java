/*Team Obliviate: Nalanda Sharadjaya and James Cao
  APCS1 pd9
  HW36: Some Folks Call It A Memory
  2015-11-23
*/

import cs1.Keyboard;  //if comfortable with Scanner, you may comment this out
		
public class Concentration {

//instance variables

    private Tile[][] _board = new Tile[4][4];     //storage for 4x4 grid of Tiles.
    private int _numberFaceUp;   //count of Tiles with faces visible
    private String[] _words;     //list of unique Strings used for Tile vals
    private static int _numRows = 4;

    public Concentration() {
	
	_numberFaceUp = 0;
	_words = new String[] { "cow", "dog", "cat", "bug", "pig", "ant", "fox", "rat" };
	_board = setBoard();
	
    }

    public Tile[][] setBoard() {
	//populates _board array
	for(int r = 0; r < 4; r++) {
	    for(int c = 0; c < 4; c++) {
		Tile t = new Tile (_words[(4 * r + c) % 8]);
		_board[r][c] = t ;
	    }
	}

	//randomizes _board array
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
	Object o1 = a[r1][c1];
	Object o2 = a[r2][c2];
	a[r1][c1] = o2;
	a[r2][c2] = o1;
    }

    //gets input
    public static int getSomething(String query) {
	String error = "That wasn't a digit between 1-4. Please try again.";
	System.out.println(query);
	int i = Keyboard.readInt() - 1;
	if (i < 0 || i > 3) {
	    System.out.println(error);
	    return getSomething(query);
	}
	return i;
    }

    //sees if game is over
    public boolean allUp() {
	for(int r = 0; r < 4; r++) {
	    for(int c = 0; c < 4; c++) {
		if (!_board[r][c].isFaceUp()) return false;
	    }
	}
	return true;
    }

    public String play() {
	//update
	System.out.println("Here is the board:");
	System.out.println(toString());

	//gets values
	int r1 = getSomething("First row (digit between 1-4):");
	int c1 = getSomething("First column (digit between 1-4):");
	int r2 = getSomething("Second row (digit between 1-4):");
	int c2 = getSomething("Second column (digit between 1-4):");

	//tests to see if the same card was flipped up twice
	if ( r1 == r2 && c1 == c2 ) {
	    System.out.println("You flipped the same cards! Try again:");
	    play();
	}

	//if not, initialize tiles to flip
        Tile t1 = _board[r1][c1];
	Tile t2 = _board[r2][c2];

	//if one is already flipped, start over
	if ( t1.isFaceUp() || t2.isFaceUp() ) {
	    System.out.println("One or more of those cards was already flipped up! Try again:");
	    play();
	}

	//if not, flip
	t1.flip();
	t2.flip();

	//while the game isn't over
        while (!allUp()) {
	    
	    //if they're equal, it's a match
	    if (t1.equals(t2)) {
		System.out.print(toString());
		System.out.println("That's a match! Try again:");
		play();
	    }

	    //if not, flip them back down and try again
	    else {
		System.out.print(toString());
		System.out.println("That wasn't a match! Try again:");
		t1.flip();
		t2.flip();
		play();
	    }
	}
	return "";
    }

    //outputs board
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
	game.play();
    }

}//end class Concentration
