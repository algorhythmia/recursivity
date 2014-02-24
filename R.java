import java.util.Random;

public class R {

    private static int N = 10;

    public static void main(String[] args) {
        int[][] m = new int[N][N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                m[i][j] = random.nextInt(2);
            }
        }

        p(m);
        System.out.println(f(m));
        p(m);
    }

    private static void p(int[][] m) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(m[i][j] + "  ");
            }
            System.out.println();
        }
    }

    private static int f(int[][] m) {
        int t = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (m[i][j] == 0) {
                    rec(t++, m, i, j);
                }
            }
        }
        return t - 2;
    }

    private static void rec(int t, int[][] m, int i, int j) {
        m[i][j] = t;
        if (i > 0 && m[i - 1][j] == 0) {
            rec(t, m, i - 1, j);
        }
        if (i + 1 < m.length && m[i + 1][j] == 0) {
            rec(t, m, i + 1, j);
        }
        if (j > 0 && m[i][j - 1] == 0) {
            rec(t, m, i, j - 1);
        }
        if (j + 1 < m[i].length && m[i][j + 1] == 0) {
            rec(t, m, i, j + 1);
        }
    }

}
