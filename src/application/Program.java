package application;

import java.util.Scanner;

import boardgame.Board;
import boardgame.Position;

public class Program {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String action = new String("");
		Board board = new Board();
		while(!action.equals("sair")) {
			System.out.println(board);
			System.out.println("Source: ");
			action = input.next();
		    char xChar = action.charAt(0);
		    int parseYChar;
		    switch(xChar) {
		    	case 'a':
		    		parseYChar = 1;
		    		break;
		    	case 'b':
		    		parseYChar = 2;
		    		break;
		    	case 'c':
		    		parseYChar = 3;
		    		break;
		    	case 'd':
		    		parseYChar = 4;
		    		break;
		    	case 'e':
		    		parseYChar = 5;
		    		break;
		    	case 'f':
		    		parseYChar = 6;
		    		break;
		    	case 'g':
		    		parseYChar = 7;
		    		break;
		    	case 'h':
		    		parseYChar = 8;
		    		break;
		    	default:
		    		throw new IllegalArgumentException("Posição invalida " + action);
		    		
		    }
		    int parseXChar = 8 - Character.getNumericValue(action.charAt(1));
		    Position newPostion = new Position(parseXChar, parseYChar);
		    board.placePiece(null, newPostion);
		}
		System.out.println("Jogo Finalizado!");
		input.close();
		
	}

}
