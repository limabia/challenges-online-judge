/*
https://www.urionlinejudge.com.br/judge/pt/problems/view/2842
BIANCA LIMA SANTOS 
GABRIEL ESTAVARINGO FERREIRA 
MARIANA SILVA SANTANA
*/

import java.util.*;


public class Main {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        
        char[] frase1 = sc.nextLine().toCharArray();
        
        char[] frase2 = sc.nextLine().toCharArray();
            
        int total = frase1.length + frase2.length;
        
        int maiorSubsequencia = maiorSubsequenciaEmComum(frase1, frase2, frase1.length, frase2.length);
        
        System.out.println(total - maiorSubsequencia);
    }
    
    
    public static int maiorSubsequenciaEmComum(char[] frase1, char[] frase2, int m, int n ){
        int matrix[][] = new int[m+1][n+1]; 
      
        for (int i=0; i<=m; i++) 
        { 
          for (int j=0; j<=n; j++) 
          { 
            if (i == 0 || j == 0) 
                matrix[i][j] = 0; 
            else if (frase1[i-1] == frase2[j-1]) 
                matrix[i][j] = matrix[i-1][j-1] + 1; 
            else
                matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]); 
          } 
        } 
      return matrix[m][n];
    } 
}
