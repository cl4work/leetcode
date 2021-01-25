//在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。 
//
// （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。 
//
// 返回区域的数目。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：
//[
//  " /",
//  "/ "
//]
//输出：2
//解释：2x2 网格如下：
// 
//
// 示例 2： 
//
// 输入：
//[
//  " /",
//  "  "
//]
//输出：1
//解释：2x2 网格如下：
// 
//
// 示例 3： 
//
// 输入：
//[
//  "\\/",
//  "/\\"
//]
//输出：4
//解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
//2x2 网格如下：
// 
//
// 示例 4： 
//
// 输入：
//[
//  "/\\",
//  "\\/"
//]
//输出：5
//解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
//2x2 网格如下：
// 
//
// 示例 5： 
//
// 输入：
//[
//  "//",
//  "/ "
//]
//输出：3
//解释：2x2 网格如下：
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length == grid[0].length <= 30 
// grid[i][j] 是 '/'、'\'、或 ' '。 
// 
// Related Topics 深度优先搜索 并查集 图 
// 👍 203 👎 0

// 1 <= grid.length == grid[0].length <= 30
// grid[i][j] 是 '/'、'\'、或 ' '。
//leetcode submit region begin(Prohibit modification and deletion)
//wait
class Solution {
    private int count = 0;
    private int[][] grid;
    private int n;

    public int regionsBySlashes(String[] grid) {

        n = grid.length;
        castGrid(grid);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                checkGrid(i, j);
            }
        }
        return count;
    }

    private void checkGrid(int i, int j) {


    }

    private void castGrid(String[] grid) {

        this.grid = new int[n][n];
        int ansyNum = 0;
        for (int i = 0; i < n; ++i) {
            char[] row = grid[i].toCharArray();
            for (int j = 0; j < row.length; ++j) {
                char element = row[j];
                if (element == '\\') {
                    this.grid[i][j - ansyNum] = -1;
                    ++j;
                    ++ansyNum;
                    continue;
                }
                this.grid[i][j - ansyNum] = element == ' ' ? 0 : 1;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
