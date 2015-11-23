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

    public String ready (){
	String response = Keyboard.readString();
	if (response.equals("Y")){
	    return ("Then let's begin.\n");}
	else{
	    System.out.println ("Take your time...");
		return ready ();}}
	
	

    public void play(){
	int score = 0;
	int number = 0;
	System.out.println ("Welcome to Concetration!");
	System.out.println ("Please observe the letters below.");
	for(int r = 0; r < 4; r++) {
	    for(int c = 0; c < 4; c++) {
		this._board[r][c].flip();}}
	System.out.print (this);
	System.out.println ("Got it memorized?(Y/N)");
	System.out.print (ready ());
        for(int r = 0; r < 4; r++) {
	   for(int c = 0; c < 4; c++) {
	       this._board[r][c].flip();}}
	System.out.print (this);
	while (score < 8){

	     System.out.println ("\nPlease indicate the row of the first element.");
	    int rowA = Keyboard.readInt();
	    while (rowA > ( _board.length) || rowA <= 0){
	          System.out.println ("That row does not exist. Try again.");
	          rowA = Keyboard.readInt();}
	          
	    System.out.println ("\nPlease indicate the column of the first element.");
	    int columnA = Keyboard.readInt();
	    while (columnA > ( _board[0].length) || columnA <=0 ){
	          System.out.println ("That column does not exist. Try again.");
	          columnA = Keyboard.readInt();}
	    _board[rowA-1][columnA-1].flip();
	    System.out.print(this);
	          
	    System.out.println ("\nPlease indicate the row of the second element.");
	    int rowB = Keyboard.readInt();
	    while (rowB > ( _board.length) || rowB <= 0){
	          System.out.println ("That row does not exist. Try again.");
	          rowB = Keyboard.readInt();}
	
	    System.out.println ("\nPlease indicate the column of the second element.");
	    int columnB = Keyboard.readInt();
	    while (columnB > ( _board[0].length) || columnB <= 0){
	          System.out.println ("That column does not exist. Try again.");
	         columnB = Keyboard.readInt();}
	    _board[rowB-1][columnB-1].flip();
	    System.out.print(this);

	    if ((rowA == rowB) && (columnA == columnB)){
		    System.out.println ("You chose the same element twice. Try again.");}

	    else if (_board[rowA-1][columnA-1].equals (_board[rowB-1][columnB-1])){
		score += 1;
		System.out.println ("Correct!");}
	    else {
		 _board[rowA-1][columnA-1].flip();
		 _board[rowB-1][columnB-1].flip(); 
		 System.out.println ("Wrong.");}
	    System.out.println (this);}
	System.out.println ("Game Over.");
		
	    

    }
	
	
	

    //DO NOT MODIFY main()
    public static void main(String[] args){
	Concentration game = new Concentration();
	//System.out.print(game);
	game.play();
    }

}//end class Concentration

