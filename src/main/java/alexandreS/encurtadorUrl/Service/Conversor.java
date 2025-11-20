package alexandreS.encurtadorUrl.Service;

import org.springframework.stereotype.Service;

@Service
public class Conversor {
  private static final String baseLetras = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  private char[] baseCaracteres = baseLetras.toCharArray();
  private int baseNumerica = baseCaracteres.length;

  private static final int TAMANHO_MAXIMO = 5;

  public String criptografa(long input) {
    StringBuilder criptografiaString = new StringBuilder();

    if (input < 0) {
      throw new IllegalArgumentException("Erro no banco");
    }

    while (input > 0) {

      criptografiaString.append(baseCaracteres[(int) (input % baseNumerica)]);
      input = input / baseNumerica;
    }

    while (criptografiaString.length() < TAMANHO_MAXIMO) {
      criptografiaString.append('a');
    }

    return criptografiaString.reverse().toString();
  }

  public long decriptografia(String input) {

    if (input.length() < TAMANHO_MAXIMO) {
      throw new IllegalArgumentException("Tamanho Incorreto");
    }

    char[] caracteres = input.toCharArray();
    long decriptografia = 0;

    int contador = TAMANHO_MAXIMO - 1;

    for (char c : caracteres) {
      int valor = baseLetras.indexOf(c);
      if (valor == -1) {
        throw new IllegalArgumentException("Caractere inválido: " + c);
      }
      decriptografia += valor * Math.pow(baseNumerica, contador);
      contador--;
    }
    return decriptografia;
  }
}
