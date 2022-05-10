import java.io.BufferedReader;

import java.io.FileReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception {
		ArvoreBinaria arvore = new ArvoreBinaria();
		BufferedReader buffRead = new BufferedReader(new FileReader("file.txt"));
		String linha = "";
		String[] values;
		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				values = linha.split("-");
				String valor = values[0];
				String frequencia = values[1];

				Element element = new Element(Integer.parseInt(valor), Integer.parseInt(frequencia));
				arvore.inserir(element);

			} else
				break;
		}
		arvore.caminharPre();
		arvore.caminharPos();
		arvore.caminharCentral();
		buffRead.close();
	}
}
