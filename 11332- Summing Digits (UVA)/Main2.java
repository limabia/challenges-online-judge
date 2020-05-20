class Main {

  // soma dos digitos de n
  public static int f(int n) {
    int soma = 0;

    // enquanto tem digito
    while (n > 0) {
      int digito = n % 10;
      soma = soma + digito;
      n = n / 10;
    }

    return soma;
  }

  public static int g(int n) {
    // enquanto n tiver mais de um digito
    while(n > 9) {
      n = f(n);
    }

    return n;
  }

  public static void main(String[] args) {
    System.out.println(g(1234567892));
  }
}