import java.util.*;

// "static void main" must be defined in a public class.
public class main {
    public static void main(String[] args) {
        int[] locB = new int[]{3, 2};
        int[] locK = new int[]{4, 2};
        Chess game = new Chess(locB, locK);
        String[][] moves = new String[][]{{"B", "Down", "2"}, {"B", "Up", "1"},  {"K", "Up", "1"},{"K", "Upright", "3"},{"K", "Upright", "2"}};
        //String[][] moves = new String[][]{{"K", "Upright", "3"}};
        game.chessMove(moves);
    }
}

class Chess {
    String[][] board;
    int[] curB, curK;
    static Map<String, int[]> moveDIRS = Map.of(
        "Down", new int[]{1, 0},
        "Up", new int[]{-1, 0},
        "Left", new int[]{0, -1},
        "Right", new int[]{0, 1},
        "Upright", new int[]{-1, 1},
        "Upleft", new int[]{-1, -1},
        "Downleft", new int[]{1, -1},
        "Downright", new int[]{1, 1}
    );
    
    public Chess(int[] locB, int[] locK) {
        board = new String[8][8];
        for (int i = 0; i < 8; i++) {
            Arrays.fill(board[i], " ");
        }
        board[locB[0]][locB[1]] = "B";
        this.curB = locB;
        board[locK[0]][locK[1]] = "K";
        this.curK = locK;
        print();
    }
    
    public void print() {
        for (String[] row : board) {
            System.out.println(Arrays.deepToString(row));
        }
        System.out.println();
    }
  
        public void chessMove(String[][] moves) {    
        for (String[] move : moves) {
            //System.out.println(Arrays.toString(move));
            String type = move[0];
            int distance = Integer.parseInt(move[2]);
            int[] curdir = moveDIRS.get(move[1]);
            int[] curLoc = type.equals("B") ? curB : curK;
             //System.out.println(Arrays.toString(curdir));
                boolean canMove = true;
                for (int i = 0; i < distance; i++) {
                     int tmpnextr = curLoc[0] + curdir[0] * i;
                     int tmpnextc = curLoc[1] + curdir[1] * i;
                     canMove = canMove && isValid(type, tmpnextr, tmpnextc);    
                }
                 System.out.println(Arrays.toString(move) + ":" + canMove);
                if (canMove) {
                    board[curLoc[0]][curLoc[1]] = " ";
                    curLoc[0] += curdir[0] * distance;
                    curLoc[1] += curdir[1] * distance;
                    board[curLoc[0]][curLoc[1]] = new String(type);
                }
            print();            
        }
    }
    
    private boolean isValid(String type, int tmpnextr, int tmpnextc) {
        if (tmpnextr < 0 || tmpnextr >= 8 || tmpnextc < 0 || tmpnextc >= 8) {
            return false;
        }
        int[] otherLoc = type.equals("B") ? curK : curB;
        // System.out.println(Arrays.toString(otherLoc));
        // System.out.println(tmpnextr + "," + tmpnextc);
        if (tmpnextr == otherLoc[0] && tmpnextc == otherLoc[1]) {
            return false;
        }
        return true;
    }
}

//     public void chessMove(String[][] moves) {    
//         for (String[] move : moves) {
//             //System.out.println(Arrays.toString(move));
//             String type = move[0];
//             int distance = Integer.parseInt(move[2]);
//             int[] curdir = moveDIRS.get(move[1]);
//              //System.out.println(Arrays.toString(curdir));
//             if (type.equals("B")) {
//                 boolean canMove = true;
//                 for (int i = 0; i < distance; i++) {
//                      int tmpnextr = curB[0] + curdir[0] * i;
//                      int tmpnextc = curB[1] + curdir[1] * i;
//                      canMove = canMove && isValid(type, tmpnextr, tmpnextc);    
//                      // System.out.println(canMove);
//                 }
                
//                 if (canMove) {
//                     board[curB[0]][curB[1]] = " ";
//                     curB[0] += curdir[0] * distance;
//                     curB[1] += curdir[1] * distance;
//                     board[curB[0]][curB[1]] = "B";
//                 }
//             } else {
//                 boolean canMove = true;
//                 for (int i = 0; i < distance; i++) {
//                      int tmpnextr = curK[0] + curdir[0] * i;
//                      int tmpnextc = curK[1] + curdir[1] * i;
//                      canMove = canMove && isValid(type, tmpnextr, tmpnextc);    
//                       //System.out.println(canMove);
//                 }
                
//                 if (canMove) {
//                     board[curK[0]][curK[1]] = " ";
//                     curK[0] += curdir[0] * distance;
//                     curK[1] += curdir[1] * distance;
//                     board[curK[0]][curK[1]] = "K";
//                 }                
//             }
//             print();            
//         }
//     }