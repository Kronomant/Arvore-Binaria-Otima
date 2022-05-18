/**
 * Lista 4 - Árvore de Busca Ótima
 * Alunos: Isabela Regina Aguilar
 * Lucas Milard de Souza Freitas
 */

public class Main {

	static int optimalSearchTree(int keys[], int freq[], int n) {

		int cost[][] = new int[n + 1][n + 1];

		for (int i = 0; i < n; i++)
			cost[i][i] = freq[i];

		for (int L = 2; L <= n; L++) {
			for (int i = 0; i <= n - L + 1; i++) {
				int j = i + L - 1;
				cost[i][j] = Integer.MAX_VALUE;

				for (int r = i; r <= j; r++) {
					int c = ((r > i) ? cost[i][r - 1] : 0)
							+ ((r < j) ? cost[r + 1][j] : 0) + sum(freq, i, j);
					if (c < cost[i][j])
						cost[i][j] = c;
				}
			}
		}
		return cost[0][n - 1];
	}

	static int sum(int freq[], int i, int j) {
		int s = 0;
		for (int k = i; k <= j; k++) {
			if (k >= freq.length)
				continue;
			s += freq[k];
		}
		return s;
	}

	public static void main(String[] args) {

		int keys[] = { 100, 200, 300 };
		int freq[] = { 1, 2, 4 };
		int n = keys.length;
		System.out.println("Custo para a árvore de busca ótima é: "
				+ optimalSearchTree(keys, freq, n));
	}

}
