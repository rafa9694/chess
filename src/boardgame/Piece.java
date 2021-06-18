package boardgame;

public class Piece {

	protected Position position;
	
	public Piece(Position position) {
		this.position = position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
	
	public boolean[][] possibleMoves() {
		boolean[][] array = new boolean[10][10];
		return array;
	}
	
	public boolean possibleMove(Position position) {
		return true;
	}
	
	public boolean isThereAnyPossibleMove() {
		return true;
	}
	
}
