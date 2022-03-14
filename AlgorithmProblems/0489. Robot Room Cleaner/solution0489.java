import java.util.*;

public class solution0489 {
         static int[][] DIRS = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
         Set<String> visited;
         static Robot robot;
         static int[][] room;
         static int row, col, d;

         solution0489(int[][] room) {
             solution0489.room = room;
         }
         public static void main(String[] args) {
             int[][] room = new int[][]{{1,1,1,1,1,0,1,1},{1,1,1,1,1,0,1,1},{1,0,1,1,1,1,1,1},{0,0,0,1,0,0,0,0},{1,1,1,1,1,1,1,1}};
             solution0489 sol = new solution0489(room);
             solution0489.row = 1;
             solution0489.col = 3;
             solution0489.d = 0;
             solution0489.robot = new CleanRobot(solution0489.row, solution0489.col, solution0489.d, solution0489.DIRS, solution0489.room);
             sol.cleanRoom(solution0489.robot);
         }

         public boolean isFullClean() {
             int rows = room.length, cols = room[0].length;
             for (int i = 0; i < rows; i++) {
                 for (int j = 0; j < cols; j++) {
                     if (room[i][j] == 0) {
                         System.out.println("Robot not cleaned all rooms.");
                         return false;
                     }
                 }
             }
             System.out.println("Robot cleaned all rooms.");
             return true;
         }

         public void cleanRoom(Robot robot) {
             solution0489.robot = robot;
             this.visited = new HashSet<>();
             dfs(0,0,0);
         }
         
         public void dfs(int r, int c, int d) {
             robot.clean();
             visited.add(r + "," + c);
             // generation
             for (int i = 0; i < 4; i++) {
                 int newD = (d + i) % 4;
                 int newR = r + DIRS[newD][0];
                 int newC = c + DIRS[newD][1];
                 if (!visited.contains(newR + "," + newC) && robot.move()) {
                     dfs(newR, newC, newD);
                     goBack();
                 }
                 robot.turnRight();
             }
         }
         
         public void goBack() {
             robot.turnRight();
             robot.turnRight();
             robot.move();        
             robot.turnRight();
             robot.turnRight();        
         }   

}

class CleanRobot implements Robot {
    int[][] DIRS;
    int[][] room;
    int r, c, d;
    
    public CleanRobot(int r, int c, int d, int[][] DIRS, int[][] room) {
        this.r = r;
        this.c = c;
        this.d = d;
        this.DIRS = DIRS;
        this.room = room;
    }

    public boolean move() {
        if (room[r][c] == 1) {
            return false;
        }
        this.r = this.r + this.DIRS[d][0];
        this.c = this.c + this.DIRS[d][1];
        return true;
    };

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft() {
        int curd = this.d - 1;
        if (curd < 0) {curd += 4;}
        this.d = curd % 4;
    };

    public void turnRight() {
        int curd = this.d + 1;
        this.d = curd % 4;
    };

    // Clean the current cell.
    public void clean() {
        this.room[this.r][this.c] = 2;
    };    
}

// This is the robot's control interface.
// You should not implement it, or speculate about its implementation
interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();
    public void turnRight();

    // Clean the current cell.
    public void clean();
}


