public class Solution {
    public int findCenter(int[][] edges) {
        // Check the common node in the first two edges
        if (edges[0][0] == edges[1][0] || edges[0][0] == edges[1][1]) {
            return edges[0][0];
        } else {
            return edges[0][1];
        }
    }
}
