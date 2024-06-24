// import java.util.*;

// public class Main
// {
//     public static void main(String[] args) {
       
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int[][] mat= new int[n][n];
//         for(int i =0 ;i<n ;i++){
//            for(int j=0;j<n;j++){
//               mat[i][j] = sc.nextInt();
//             }
//         }
       
//         System.out.println(solve(mat,n));
        
         
//     }
    
//     public static int solve(int[][] M, int N) {
//         int candidate = -1;
//         for (int i = 0; i < N; i++) {
//             boolean isCandidate = true;
//             for (int j = 0; j < N; j++) {
//                 if (M[j][i] == 0) {
//                     isCandidate = false;
//                     break;
//                 }
//             }
//             if (isCandidate) {
//                 if (candidate == -1) {
//                     candidate = i;
//                 } else {
//                     return -1; // More than one column with maximum 1s
//                 }
//             }
//         }
        
//         if (candidate == -1) {
//             return 0; // No column with all 1s
//         }
        
//         for (int i = 0; i < N; i++) {
//             for (int j = 0; j < N; j++) {
//                 if (j != candidate && M[i][j] == 1) {
//                     return 0; // 1 present in other columns
//                 }
//             }
//         }
        
//         return 1;
//     }
// }



import java.util.*;

public class Main
{
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat= new int[n][n];
        for(int i =0 ;i<n ;i++){
           for(int j=0;j<n;j++){
              mat[i][j] = sc.nextInt();
            }
        }
       
        System.out.println(solve(mat,n));
        
         
    }
    


    public static int solve(int[][] M, int N) {
        int maxZeroCount = 0;
        int columnIndex = -1;

        for (int j = 0; j < N; j++) {
            int zeroCount = 0;
            for (int i = 0; i < N; i++) {
                if (M[i][j] == 0) {
                    zeroCount++;
                }
            }
            if (zeroCount > maxZeroCount) {
                maxZeroCount = zeroCount;
                columnIndex = j;
            }
        }

        // If no column has 0s
        if (maxZeroCount == 0) {
            return -1;
        }

        // Check if there are multiple columns with the same maximum number of 0s
        for (int j = columnIndex + 1; j < N; j++) {
            int zeroCount = 0;
            for (int i = 0; i < N; i++) {
                if (M[i][j] == 0) {
                    zeroCount++;
                }
            }
            if (zeroCount == maxZeroCount) {
                return columnIndex;
            }
        }

        return columnIndex;
    }
}



