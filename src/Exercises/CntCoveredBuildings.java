package Exercises;

public class CntCoveredBuildings {
    public static void main(String[] args) {
        System.out.println(countCoveredBuildings(3, new int[][]{{1, 2}, {2, 2}, {3, 2}, {2, 1}, {2, 3}}));
    }


        public static int countCoveredBuildings(int n, int[][] buildings) {
            int[][] g = new int[n + 1][n + 1];
            for (int i = 0; i < buildings.length; i++) {
                int r = buildings[i][0], c = buildings[i][1];
                g[r][c] = 1;
            }

            int res = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (g[i][j] == 1) {
                        if (i + 1 <= n && i - 1 >= 1 && j + 1 <= n && j - 1 >= 1) {
                            if (g[i + 1][j] == 1 && g[i - 1][j] == 1 && g[i][j + 1] == 1 && g[i][j - 1] == 1) {
                                res++;
                            }
                        }
                    }
                }
            }

            return res;
        }
    }
