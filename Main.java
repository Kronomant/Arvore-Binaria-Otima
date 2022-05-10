import java.io.BufferedReader;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader buffRead = new BufferedReader(new FileReader("file.txt"));
		String linha = "";
		String[] values;
		while (true) {
			if (linha != null) {
				values = linha.split("-");
				System.out.println(values[0]);
				

			} else
				break;
			linha = buffRead.readLine();
		}
		buffRead.close();
    }
}
