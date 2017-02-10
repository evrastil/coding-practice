import org.junit.Test;

/**
 * Write code which will accept this 2-dim array and return the number of islands - See more at: http://www.ritambhara.in/islands-in-a-two-dimensional-array/#sthash.FQf0kYW3.dpuf
 */
public class MarkIslandTest {

    @Test
    public void testCountIslands() {
        int[][] islandMap = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 1, 1, 1, 1, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        int count = countIslands(islandMap);
        System.out.println(count);
    }

    public int countIslands(int[][] map) {
        int islandCount = 0;
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[row].length; col++) {
                int pos = map[row][col];
                if (pos == 1) {
                    searchIsland(map, row, col);
                    islandCount ++;
                }
                System.out.println(map[row][col]);
            }
        }

        return islandCount;
    }

    private void searchIsland(int[][] map, int row, int col) {
        map[row][col] = -1;
        //look top left
        if (map[row-1][col - 1] == 1) {
            searchIsland(map, row-1, col - 1);
        }
        //look top right
        if (map[row-1][col + 1] == 1) {
            searchIsland(map, row-1, col + 1);
        }
        //look top
        if (map[row-1][col] == 1) {
            searchIsland(map, row-1, col);
        }
        //look left
        if (map[row][col - 1] == 1) {
            searchIsland(map, row, col - 1);
        }
        //look right
        if (map[row][col + 1] == 1) {
            searchIsland(map, row, col + 1);
        }
        //look bottom left
        if (map[row + 1][col - 1] == 1) {
            searchIsland(map, row + 1, col - 1);
        }
        //look bottom
        if (map[row + 1][col] == 1) {
            searchIsland(map, row + 1, col);
        }
        //look bottom right
        if (map[row + 1][col + 1] == 1) {
            searchIsland(map, row + 1, col + 1);
        }
    }
}
