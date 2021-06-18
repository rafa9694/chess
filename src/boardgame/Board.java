package boardgame;

import java.util.ArrayList;
import java.util.List;


public class Board {
	private int rows;
	private int colummns;
	private List<Piece> pieces;

	public Board() {
		this.rows = 9;
		this.colummns = 9;
		this.pieces =  new ArrayList<>();
	}

	@Override
	public String toString() {
		char[][] board = new char[this.rows][this.colummns];
		Position position = new Position(0,0);
		char[] columnToAlphabetic = new char[] { ' ', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h' };
		for (int i = 0; i < this.rows; i++) {

			for (int j = 0; j < this.colummns; j++) {
				if (i != (this.rows - 1) && j == 0) {
					board[i][j] = Character.forDigit(this.rows -1 - i, 10);
				} else if (i == (this.rows - 1)) {
					board[i][j] = columnToAlphabetic[j];
				} else {
					position.setValues(i,j);
					if(thereIsAPiece(position)) {
						board[i][j] = 'P';
					} else {						
						board[i][j] = '-';
					}
				}
			}
		}
		String output = "";

		for (int i = 0; i < this.rows; i++) {

			for (int j = 0; j < this.colummns; j++) {
				output = output.concat(board[i][j] + " ");
			}
			output = output.concat("\n");
		}

		return output.toString();
	}

	public void placePiece(Piece piece, Position position) {
		removePiece(position);
		if(piece == null ) {
			Piece newPice = new Piece(position);
			this.pieces.add(newPice);
		} else {			
			this.pieces.add(piece);
		}
	}
	
	public boolean thereIsAPiece(Position position) {
		int row;
		int collumn;
		for (Piece piece : this.pieces) {
			collumn = piece.position.getColumn();
			row = piece.position.getRow();
			
			if(position.getColumn() == collumn && position.getRow() == row) {
				return  true;
			}
		}
		
		return false;
	}
	
	public Piece removePiece(Position position) {
		int row;
		int collumn;
		for (Piece piece : this.pieces) {
			collumn = piece.position.getColumn();
			row = piece.position.getRow();
			
			if(position.getColumn() == collumn && position.getRow() == row) {
				this.pieces.remove(piece);
				return piece; 
			}
		}
		
		return null;
	}
}
