import java.util.ArrayDeque;
import java.util.Random;


public class MinBinaryHeap
{
	private int n;               /* Numero de elementos no heap. */   
	private int tam;             /* Tamanho máximo do heap. */
	private Arvbin[] vetor;          /* Vetor com elementos. */

	/* Constrói heap vazio. */
	public MinBinaryHeap(int tamanho)
	{
		n = 0;
		tam = tamanho;
		vetor = new Arvbin[tamanho + 1];
	}

	/* Constrói heap a partir de vetor v. */
	public MinBinaryHeap(int tamanho, Arvbin[] v)
	{
		tam = tamanho;
		vetor = new Arvbin[tamanho+1];
		n = tamanho;

		for( int i = 0; i < tamanho; i++ )
			vetor[ i + 1 ] = v[ i ];

		constroiHeap();
	}

	/* Testa se a fila de prioridade está logicamente vazia.
	   Retorna true se vazia, false, caso contrário. */
	public boolean vazia()
	{
		return n == 0;
	}

	/* Faz a lista de prioridades logicamente vazia. */
	public void fazVazia()
	{
		n = 0;
	}

	/* Imprime os elementos da heap. */
	public void imprime()
	{
		System.out.print("\nConteúdo da heap:\n");

		for(int i = 1; i <= n; i++)
			System.out.printf("v[%d]= %c\t\t%d\n", i,vetor[i].getSimbolo() ,vetor[i].getFrequencia());

		System.out.println();
	}

	/* Busca o menor item na fila de prioridades.
	   Retorna o menor item em itemMin e true, ou falso se a heap estiver vazia. */
	public Arvbin min()
	{
		if (this.vazia())
		{
			System.out.println("Fila de prioridades vazia!");
			return null;
		}

		return vetor[1];
	}

	/* Remove o menor item da lista de prioridades e coloca ele em itemMin. */
	public Arvbin removeMin()
	{
		Arvbin itemMin;
		
		if(this.vazia())
		{
			System.out.println("Fila de prioridades vazia!");
			return null;
		}

		itemMin = vetor[1];
		vetor[1] = vetor[n];
		n--;
		refaz(1);
		
		return itemMin;
	}

	/* Método auxiliar que estabelece a propriedade de ordem do heap a 
	 * partir de um vetor arbitrário dos itens. */
	private void constroiHeap()
	{
		for( int i = n / 2; i > 0; i-- )
			refaz(i);
	}

	/* Método auxiliar para restaurar a propriedade de heap que
	 * não está sendo respeitada pelo nó i. */
	private void refaz(int i)
	{
		Arvbin x = vetor[ i ];

		while(2*i <= n)
		{
			int filhoEsq, filhoDir, menorFilho;
			
			filhoEsq = 2*i;
			filhoDir = 2*i + 1;
			
			/* Por enquanto, o menor filho é o da esquerda. */
			menorFilho = filhoEsq;
			
			/* Verifica se o filho direito existe. */
			if(filhoDir <= n)
			{
				 /* Em caso positivo, verifica se é menor que o filho esquerdo. */
				if(vetor[ filhoDir ].getFrequencia() < vetor[ filhoEsq ].getFrequencia())
					menorFilho = filhoDir;
			}

			/* Compara o valor do menor dos filhos com x. */
			if(vetor[ menorFilho ].getFrequencia() < x.getFrequencia())
				vetor [ i ] = vetor[ menorFilho ];
			else
				break;
			
			/* Como o elemento x que estava na posição "i" desceu para o nível de baixo, a próxima
			 * iteração vai verificar a possibilidade de trocar esse elemento x (agora na 
			 * posição "menorFilho") com um de seus novos filhos. */
			i = menorFilho;
		}
		
		vetor[ i ] = x;
	}

	/* Insere item x na fila de prioridade, mantendo a propriedade do heap.
	 * São permitidas duplicatas. */
	public void insere(Arvbin x)
	{
		if (tam == n)
		{
			System.out.println("Fila de prioridades cheia!");
			return;
		}

		/* O elemento é inicialmente inserido na primeira posição disponível
		 * na árvore, considerando de cima para baixo, da esquerda para a direita. */
		n++;
		int pos = n;
		
		/* Sentinela utilizada para tratar o caso do pai do nó raiz (de índice 1). */
		vetor[0] = x;

		/* Refaz heap (sobe elemento). */
		while(x.getFrequencia() < vetor[pos/2].getFrequencia())
		{
			vetor[pos] = vetor[ pos/2 ];
			pos /= 2;
		}
		
		vetor[pos] = x;
	}

	public void carregaDados() {

		char simbolo;
		int q = 0 , frequencia = 0;

		Random random = new Random();
		String setOfCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%¨&*()_-+=/|;:?";

		System.out.println(setOfCharacters.length());

		while (q < tam) {

			int randomInt = random.nextInt(setOfCharacters.length());
			simbolo = setOfCharacters.charAt(randomInt) ;
			frequencia += random.nextInt(1,200);

			/*simbolo = scan.next().charAt(0);
			frequencia = scan.nextInt();*/


			Arvbin no = new Arvbin(simbolo, frequencia);
			insere(no);

			q++;
		}
	}


	/* cada execução de Insere e RemoveMin consumirá O(lg n) unidades de tempo.
 	Com isso, o custo total será de O(n lg n)*/
	public void aplicaHuffman() {

		while (n > 1) {
			Arvbin esq = removeMin(), dir = removeMin(), noSoma;

			noSoma = new Arvbin(' ', esq.getFrequencia() + dir.getFrequencia(), esq, dir);

			insere(noSoma);
		}
	}


	public void mostraCodigos(){
		if(!vazia())
			vetor[1].mostraCodigo(new ArrayDeque<Character>());
		else
			System.out.println("fila de prioridades vazia!");
	}


}