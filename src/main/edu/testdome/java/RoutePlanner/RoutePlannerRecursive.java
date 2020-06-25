package main.edu.testdome.java.RoutePlanner;

public class RoutePlannerRecursive {
    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn, boolean[][] mapMatrix) {
        int rowCount = mapMatrix.length;
        int columnCount = mapMatrix[0].length;
        boolean visited[][] = new boolean[rowCount][columnCount];
        boolean flag = false;

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < columnCount; j++) {
                if (i==fromRow && j == fromColumn && !visited[i][j]) {
                    if (isPath(toRow, toColumn, mapMatrix, i, j, visited)) {
                        flag = true;
                        break;
                    }
                }
            }
        }
        return flag;
    }

    public static boolean isSafe(int i, int j, boolean matrix[][]) {

        if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length)
            return true;
        return false;
    }
    public static boolean isPath(int toRow, int toColumn,boolean matrix[][], int i, int j, boolean visited[][])
    {
        if (isSafe(i, j, matrix) && matrix[i][j]  && !visited[i][j]) {
            visited[i][j] = true;

            if (i==toRow && j == toColumn) return true;

            // traverse up
            boolean up = isPath(toRow, toColumn, matrix, i - 1, j, visited);
            if (up) return true;

            // traverse left
            boolean left = isPath(toRow, toColumn, matrix, i, j - 1, visited);
            if (left) return true;

            // traverse down
            boolean down = isPath(toRow, toColumn, matrix, i + 1, j, visited);
            if (down) return true;

            // traverse right
            boolean right = isPath(toRow, toColumn, matrix, i, j + 1, visited);
            if (right) return true;
        }
        // no path has been found
        return false;
    }


    public static void main(String[] args) {
        boolean[][] mapMatrix = {
                {true,  false, false},
                {true,  true,  false},
                {false, true,  true},
        };

        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }

}
