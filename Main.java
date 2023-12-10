import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] grid;

    //bfs
    static void findTarget(int targetX, int targetY, int drone){
        // directions
        int []dx= {1,-1,0,0};
        int []dy= {0,0,1,-1};



        boolean[][] visited= new boolean[grid.length][grid[0].length];
        Queue<int[]> queue= new LinkedList<>();


        //add drone in queue
        for(int i=0; i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==drone){
                    queue.offer(new int[]{i,j});
                    visited[i][j]= true;
                }
            }
        }
        int steps=0;

        while(!queue.isEmpty()){
            int size= queue.size();
                for(int i=0;i<size;i++) {
                    int[] curr = queue.poll();
                    int x = curr[0];
                    int y = curr[1];

                    if (x == targetX && y == targetY) {

                        System.out.println("Drone " + drone + "  Takes Steps : " + steps + " to reach target");
                        return;
                    }

                    //check neighbours

                    for (int dir = 0; dir < 4; dir++) {
                        int newX = x + dx[dir];
                        int newY = y + dy[dir];
                        if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length
                                && !visited[newX][newY] && grid[newX][newY] == 0) {
                            queue.offer(new int[]{newX, newY});
                            visited[newX][newY] = true;

                        }
                    }
                }
            steps++;
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x= sc.nextInt();
        int y= sc.nextInt();

        grid= new int[x][y];
        for(int i=0;i<x;i++){
            for(int j=0;j<y;j++){
                grid[i][j]=0;
            }
        }

        int D1X = sc.nextInt();
        int D1Y = sc.nextInt();
        int D2X = sc.nextInt();
        int D2Y = sc.nextInt();
        int D3X = sc.nextInt();
        int D3Y = sc.nextInt();
        int D4X = sc.nextInt();
        int D4Y = sc.nextInt();



        grid[D1X][D1Y]= 1;
        grid[D2X][D2Y]= 2;
        grid[D3X][D3Y]= 3;
        grid[D4X][D4Y]= 4;


        int targetX= sc.nextInt();
        int targetY= sc.nextInt();
        for(int i=1;i<=4;i++){
            findTarget(targetX,targetY,i);
        }
    }
    //output
//            11
//            14
//            1
//            1
//            7
//            3
//            7
//            9
//            10
//            4
//            4
//            11
}