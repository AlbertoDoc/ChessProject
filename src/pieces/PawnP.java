package pieces;

import java.util.ArrayList;

import game.enums.TypePiece;

public class PawnP extends Piece {
	private boolean isWhite;
	
	public PawnP(boolean isWhite, Position position) {
		super(TypePiece.PAWN, position);
		this.isWhite = isWhite;
	}
	
	/* Coloquei no array dos movimentos possiveis as movimentaçoes em diagonais do peão pois não da pra passar aqui o tabuleiro do jogo,
	 * logo achei melhor a gente checar a presenca de uma peça em outro metodo aqui ou no BoardGame (que so será usado pro peão), e ai
	 * essa movimentação, se escolhida, so sera processada se o isPossible for true ou outro método, ou seja, quando houver uma peça na posição. 
	 */
	
	@Override
	public ArrayList<Position> possibleMoves() {
		ArrayList<Position>moves = new ArrayList<Position>();
		//Tratando os peões brancos
		if(this.isWhite()==true) {
			//Peões centrais que tem dois movimentos diagonais possiveis que poderão ou não serem processados
			if(this.getPosition().getY()+1<=7 && this.getPosition().getY()-1>=0) {
				moves.add(new Position(this.getPosition().getX()+1,this.getPosition().getY()+1));
				moves.add(new Position(this.getPosition().getX()+1,this.getPosition().getY()-1));
			}
			//Pegando as possiveis movimentaçoes na diagonal que so serão processadas se houver uma peça nessa posição
			if(this.getPosition().getY()==0) {
				moves.add(new Position(this.getPosition().getX()+1,this.getPosition().getY()+1));
			}
			else if(this.getPosition().getY()==7) {
				moves.add(new Position(this.getPosition().getX()+1,this.getPosition().getY()-1));
			}
			//Tratando os peões que não se moveram ainda
			if(this.getPosition().getX()==1) {
				moves.add(new Position(this.getPosition().getX()+1,this.getPosition().getY()));
				moves.add(new Position(this.getPosition().getX()+2,this.getPosition().getY()));
			}
			//Tratando os peões que ja se moveram
			else if(this.getPosition().getX()+1<=7) {
				moves.add(new Position(this.getPosition().getX()+1,this.getPosition().getY()));
				
			}
		}
		//Tratando os peões pretos
		else {
			//Peões centrais que tem dois movimentos diagonais possiveis que poderão ou não serem processados
			if(this.getPosition().getY()+1<=7 && this.getPosition().getY()-1>=0) {
				moves.add(new Position(this.getPosition().getX()-1,this.getPosition().getY()+1));
				moves.add(new Position(this.getPosition().getX()-1,this.getPosition().getY()-1));
			}
			//Pegando as possiveis movimentaçoes na diagonal que so serão processadas se houver uma peça nessa posição
			if(this.getPosition().getY()==0) {
				moves.add(new Position(this.getPosition().getX()-1,this.getPosition().getY()+1));
			}
			else if(this.getPosition().getY()==7) {
				moves.add(new Position(this.getPosition().getX()-1,this.getPosition().getY()-1));
			}
			//Tratando os peões que ainda não se moveram ainda
			if(this.getPosition().getX()==6) {
				moves.add(new Position(this.getPosition().getX()-1,this.getPosition().getY()));
				moves.add(new Position(this.getPosition().getX()-2,this.getPosition().getY()));
				
			}
			//Tratando os peões que ja se moveram
			else if(this.getPosition().getX()-1>=0) {
				moves.add(new Position(this.getPosition().getX()-1,this.getPosition().getY()));
			}
			
		}
		
		return moves;
	}

	@Override
	public boolean isPossible(Position position) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String[] args) {
		Position position = new Position(1,4);
		PawnP piece = new PawnP(true,position);
		piece.setMoves(piece.possibleMoves());

		for(Position aux:piece.getMoves()) {
			System.out.println("X-> "+aux.getX()+" Y-> "+aux.getY());
		}
	}
	
	
	//Getters e Setters da classe PawnP

	public boolean isWhite() {
		return isWhite;
	}

	public void setWhite(boolean isWhite) {
		this.isWhite = isWhite;
	}

	

}
