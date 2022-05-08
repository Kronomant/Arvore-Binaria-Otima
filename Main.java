import java.io.BufferedReader;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader buffRead = new BufferedReader(new FileReader("file.txt"));
		String linha = "";
		while (true) {
			if (linha != null) {
				System.out.println(linha);

			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
    }
}
