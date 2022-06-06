public class Board {
    Box[][] boxes;
  
    public Board() {
      this.resetBoard();
    }
  
    public Box getBox(int x, int y) {
  
      if (x < 0 || x > 7 || y < 0 || y > 7) {
        throw new Exception("Index out of bound");
      }
  
      return boxes[x][y];
    }
  
    public void resetBoard() {
      // initialize white pieces
      boxes[0][0] = new Box(new Rook(true), 0, 0);
      boxes[0][1] = new Box(new Knight(true), 0, 1);
      boxes[0][2] = new Box(new Bishop(true), 0, 2);
      //...
      boxes[1][0] = new Box(new Pawn(true), 1, 0);
      boxes[1][1] = new Box(new Pawn(true), 1, 1);
      //...
  
      // initialize black pieces
      boxes[7][0] = new Box(new Rook(false), 7, 0);
      boxes[7][1] = new Box(new Knight(false), 7, 1);
      boxes[7][2] = new Box(new Bishop(false), 7, 2);
      //...
      boxes[6][0] = new Box(new Pawn(false), 6, 0);
      boxes[6][1] = new Box(new Pawn(false), 6, 1);
      //...
  
      // initialize remaining boxes without any piece
      for (int i = 2; i < 6; i++) {
        for (int j = 0; j < 8; j++) {
          boxes[i][j] = new Box(null, i, j);
        }
      }
    }
  }