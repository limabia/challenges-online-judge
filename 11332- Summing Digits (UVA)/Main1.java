import static java.lang.Integer.parseInt;
import java.util.Scanner;

public class Main {
        private static String digitosArray;
        
	public static void main(String[] args) {
	// TODO Calcular e imprimir o valor de g(n) para todo n
            Scanner s = new Scanner(System.in);
            int n;

            while ((n = s.nextInt())>0){
            int soma = 0;
                soma = somaDigitos(getDigitos(n), soma);

                while (somaDigitos(getDigitos(soma), 0) > 9) {
                    soma = somaDigitos(getDigitos(soma), 0);
                } 
                System.out.println(somaDigitos(getDigitos(soma), 0));
            }
	}

    private static int somaDigitos(String digits, int soma) {
        for(int i = 0; i < digits.length(); i++) {
            Character b = digits.charAt(i);
            int a = parseInt(b.toString());

            soma = soma + a;

        }
        return soma;
    }
    
    private static String getDigitos(int entrada) {
        digitosArray = Integer.toString(entrada);
        return digitosArray;
    }
}