package br.edu.fateczl.ordenacao;

public class QuickSort {

	public QuickSort() {
		super();
	}

	public String [] quickSort(String[] vetor, int inicio, int fim) {
		if (fim > inicio) {
			int posicaoPivoFixo = dividir(vetor, inicio, fim);
			quickSort(vetor, inicio, posicaoPivoFixo - 1);
			quickSort(vetor, posicaoPivoFixo + 1, fim);
		}
		return vetor;
	}

	private int dividir(String[] vetor, int inicio, int fim) {
		int ponteiroEsquerda = inicio + 1;
		int ponteiroDireita = fim;
		String pivo = vetor [inicio];
		
		while (ponteiroEsquerda <= ponteiroDireita) {
			while (ponteiroEsquerda <= ponteiroDireita && (vetor[ponteiroEsquerda].compareTo(pivo)<=0)) {
				ponteiroEsquerda++;
			}
			while (ponteiroDireita >= ponteiroEsquerda && (vetor [ponteiroDireita].compareTo(pivo)> 0)) {
				ponteiroDireita--;
			}
			if (ponteiroEsquerda < ponteiroDireita) {
				trocar(vetor, ponteiroEsquerda, ponteiroDireita);
				ponteiroEsquerda++;
				ponteiroDireita--;
			}
		}
		trocar(vetor, inicio, ponteiroDireita);
		return ponteiroDireita;
	}
	
	private void trocar(String[] vetor, int i, int j) {
		String auxiliar = vetor[j];
		vetor[j] = vetor[i];
		vetor[i] = auxiliar;
	}
}
