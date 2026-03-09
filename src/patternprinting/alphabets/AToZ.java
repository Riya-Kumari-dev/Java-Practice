package patternprinting.alphabets;

public class AToZ {
    public static void main(String[] args) {
        int n = 9;
        for (int i = 0; i < n; i++) {
            // A
            for (int j = 0; j < n; j++) {
                if ((i == 0 && j > 0 && j != n - 1) || (j == 0 && i > 0) || i == (n - 1) / 2 || (j == n - 1 && i > 0))
                    System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.print("    ");
            // B
            for (int j = 0; j < n; j++) {
                if (j == 0 || (i == 0 && j != n - 1) || (i == (n - 1) / 2 && j != n - 1) || (i == n - 1 && j != n - 1) || (j == n - 1 && i > 0 && i != (n - 1) / 2 && i != n - 1))
                    System.out.print('*'+" ");
                else System.out.print("  ");
            }
            // C
            System.out.print("    ");
            for (int j = 0; j < n; j++) {
                if ((i == 0 && j > 0) || (i == n - 1 && j > 0) || (j == 0 && i != 0 && i != n - 1))
                    System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.print("    ");
            // for D
            for (int j = 0; j < n; j++) {
                if (j == 0 || (i == 0 && j != n - 1) || (i == n - 1 && j != n - 1) || (j == n - 1 && i > 0 && i != n - 1))
                    System.out.print('*'+" ");
                else System.out.print("  ");
            }
            // E
            System.out.print("    ");
            for(int j=0; j<n; j++){
                if(i==0 || i==(n-1)/2 || i==n-1 || j==0) System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.print("    ");
            // F
            for(int j=0; j<n; j++){
                if( j==0 || i==0 || i==(n-1)/2) System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        for(int i=0; i<n; i++){
            // G
            for(int j=0; j<n; j++){
                if((i==0 && j>0) || (i==n-1 && j>0) || (j==0 && i!=0 && i!=n-1) || (j==n-1 && i>=(n-1)/2) || (i==(n-1)/2 && j!=1))
                    System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.print("    ");
            // for H
            for(int j=0; j<n; j++){
                if(j==0 || j==n-1 || i==(n-1)/2) System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.print("    ");
            // I;
            for(int j=0; j<n; j++){
                if(i==0 || j==(n-1)/2 || i==n-1) System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.print("    ");
            // J
            for(int j=0; j<n; j++){
                if(i==0 || (j==(n-1)/2 && i!=n-1) || (i==n-1 && j<=(n-1)/2 && j>0) || (j==0 && i>=(n-1)/2 && i!=n-1))
                    System.out.print('*'+" ");
                else System.out.print("  ");
            }
            // K
            System.out.print("    ");
            for(int j=0; j<n; j++){
                if(j==0 || i+j == (n-1)/2 || i-j == (n-1)/2) System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.print("    ");
            // L
            for(int j=0; j<n; j++){
                if( j==0 || i==n-1) System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        for(int i=0; i<n; i++){
            // M
            for(int j=0; j<n; j++){
                if((j==0 || j==n-1) || (i==j && i<=(n-1)/2)  || (i+j == n-1 && i<=(n-1)/2))
                    System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.print("    ");
            // for N
            for(int j=0; j<n; j++){
                if(j==0 || i==j || j==n-1) System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.print("    ");
            // O
            for(int j=0; j<n; j++){
                if((i==0 && j>0 && j!=n-1) || (i==n-1 && j>0 && j!=n-1) || (j==0 && i>0 && i!=n-1) || (j==n-1 && i>0 && i!=n-1))
                    System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.print("    ");
            // P
            for(int j=0; j<n; j++){
                if(j==0 || (i==0 && j!=n-1) || (j==n-1 && i<(n-1)/2 && i>0) || (i==(n-1)/2 && j!=n-1))
                    System.out.print('*'+" ");
                else System.out.print("  ");
            }
            // Q
            System.out.print("    ");
            for(int j=0; j<n; j++) {
                if ((i == 0 && j > 0 && j != n - 1) || (i == n - 1 && j > 0 && j != n - 1) || (j == 0 && i > 0 && i != n - 1) || (j == n - 1 && i > 0 && i != n - 1) || i == (n - 1) / 2 + 1)
                    System.out.print('*' + " ");
                else System.out.print("  ");
            }
            System.out.print("   ");

            // R
            for(int j=0; j<n; j++){
                if( j==0  || (i==0 && j!=n-1) || (j==n-1 && i<(n-1)/2 && i>0) || (i==(n-1)/2 && j!=n-1) || i-j == (n-1)/2)
                    System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        for(int i=0; i<n; i++){
            // S
            for(int j=0; j<n; j++){
                if((i==0 && j>0) || (i==(n-1)/2 && j>0 && j!=n-1) || (i==n-1 && j<n-1) ||(j==0 && i>0 && i<(n-1)/2) || (j==n-1 && i>(n-1)/2 && i<n-1))
                    System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.print("    ");
            // for T
            for(int j=0; j<n; j++){
                if(i==0 || j==(n-1)/2) System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.print("    ");
            // U
            for(int j=0; j<n; j++){
                if((j==0 && i!=n-1) || (i==n-1 && j>0 && j!=n-1) || (j==n-1 && i!=n-1))
                    System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.print("    ");
            // V
            for(int j=0; j<n; j++){
                if((i==j && i<=(n-1)/2) || (i+j == n-1 && i<=(n-1)/2))
                    System.out.print('*'+" ");
                else System.out.print("  ");
            }
            // W
            System.out.print("    ");
            for(int j=0; j<n; j++) {
                if (j==0 || j==n-1 || (i==j && i>=(n-1)/2) || (i+j == (n-1) && i>=(n-1)/2))
                    System.out.print('*' + " ");
                else System.out.print("  ");
            }
            System.out.print("    ");
            // X
            for(int j=0; j<n; j++){
                if(i==j || i+j == n-1)
                    System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.println();

        }
        System.out.println();
        System.out.println();
        for(int i=0; i<n; i++){
            //Y
            for(int j=0; j<n; j++){
                if((i==j && i<=(n-1)/2) || (i+j == n-1))
                    System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.print("    ");
            //Z
            for(int j=0; j<n; j++){
                if(i==0 || i==n-1 || i+j == n-1)
                    System.out.print('*'+" ");
                else System.out.print("  ");
            }
            System.out.println();
        }

    }
}

