package alexandreS.encurtadorUrl.Service;

import org.springframework.stereotype.Service;

@Service
public class Conversor {
  private static final String baseLetras = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  private char[] baseCaracteres = baseLetras.toCharArray();
  private int baseNumerica = baseCaracteres.length;

  public String criptografa(long input) {
    StringBuilder criptografiaString = new StringBuilder();
    if (input == 0) {
      return String.valueOf(baseCaracteres[0]);

    }
    while (input > 0) {

      criptografiaString.append(baseCaracteres[(int) (input % baseNumerica)]);
      input = input / baseNumerica;
    }
    return criptografiaString.reverse().toString();
  }

  public long decriptografia(String input) {
    char[] caracteres = input.toCharArray();
    int tamanho = caracteres.length;

    long decriptografia = 0;

    int contador = 1;
    for (int i = 0; i < tamanho; i++) {
      decriptografia += baseLetras.indexOf(caracteres[i]) * Math.pow(baseNumerica, tamanho - contador);

      contador++;
    }

    return decriptografia;
  }
}
