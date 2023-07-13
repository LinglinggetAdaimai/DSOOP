import java.util.*;

public class ConnectedCells {
//     row, column
//     arr[] uniIndex to store size of each
//     dx = list for +1 bla bla for x to loop and add these to check
//     dy = list for +1 bla bla for y
//     index in uniIndex
//
//     loop through the metrix vertically, by nested loop
//         check the current if it's 1 or not
//             yes then throw it to keepChecking
//
    /** What does keepChecking do
     *     - get the start index
     *     - check if around it has 1 or not +  hasn't been visited (== 9) then put in keep again
     *          - yes then call it again with the new index
     *          - no then do nothing
     */


//             for loop to check (dx, dy)
//                 if there is anything near it that's already visited (by anything near that thing should be valid)
//                     yes then change the number in the visited array for that index to be the same
//                     no then change add uniIndex to key and put the size as 1
//             no then skip
//
static class Pair{
    int first;
    int second;
    Pair(int fst,int scnd){
        this.first=fst;
        this.second=scnd;
    }
}
    public static int connectedCell(List<List<Integer>> matrix) {
        int row = matrix.size(), column = matrix.get(0).size(), count = 0, max = Integer.MIN_VALUE;
        int[][] visited = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Integer curInt = matrix.get(i).get(j);
                if (curInt == 1 && visited[i][j] == 0) {
                    count = BFS(matrix,visited,i,j,0, row, column);
                }
                max = Math.max(count, max);
            }
        }
        return max;
    }
    public static int BFS(List<List<Integer>> matrix,int[][] visited,int i,int j,int count, int n, int m){
        visited[i][j] = 1;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(i,j));

        count++;

        int newRow[] = {1,0,0,-1,1,1, -1, -1};
        int newCol[] = {0,-1,1,0,-1,1,-1,1};
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.poll();

            for(int k = 0; k < 6; k++){
                int nrow = row + newRow[k];
                int ncol = col + newCol[k];

                if( (nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m) && visited[nrow][ncol] == 0 && matrix.get(nrow).get(ncol) == 1){
                    count++;
                    visited[nrow][ncol] = 1;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
        return count;
    }

}

