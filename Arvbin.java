
import java.util.Deque;

/* Nessa implementa��o, os conceitos de "n�" e "�rvore" se misturam. */
public class Arvbin
{
	private char simbolo; /* S�mbolo armazenado no n�. */
	private int frequencia; /* Frequ�ncia do s�mbolo armazenado no n�. */
	private Arvbin esq, dir; /* Refer�ncias para sub�rvores esquerda e direita. */
	
	/* Construtor de �rvore sem sub�rvores (dir = esq = null). S�o fornecidos
	 * apenas o s�mbolo e a frequ�ncia do n�. */
	public Arvbin(char simbolo, int frequencia)
	{
		this.simbolo = simbolo;
		this.frequencia = frequencia;

		//isso � um n� folha
	}
	
	/* Construtor de �rvore com sub�rvores. Al�m de s�mbolo e frequ�ncia do n�,
	 * s�o fornecidas as sub�rvores, que devem ter sido constru�das previamente. */
	public Arvbin(char simbolo, int frequencia, Arvbin esq, Arvbin dir)
	{
		this.simbolo = simbolo;
		this.frequencia = frequencia;
		this.esq = esq;
		this.dir = dir;

		//isso � uma �rvore
	}
	
	/* Imprime o conte�do da �rvore em pr�-ordem. */
	public void mostra()
	{
		System.out.print("(" + this.frequencia + this.simbolo);

		if (this.esq != null)
			this.esq.mostra();
		if (this.dir != null)
			this.dir.mostra();

		System.out.print(")");

		/* O grupo deve preencher a implementa��o. */
	}
	
	/* Novo m�todo para imprimir os c�digos de Huffman de cada s�mbolo na �rvore. */
	public void mostraCodigo(Deque<Character>cod)
	{
		if(esq == null && dir == null){
			imprimeCod(cod);
		}

		if(esq != null){
			cod.addLast('0');
			esq.mostraCodigo(cod);
			cod.removeLast();
		}

		if(dir != null){
			cod.addLast('1');
			dir.mostraCodigo(cod);
			cod.removeLast();
		}

		/* O grupo deve preencher a implementa��o. */
	}

	/*O(n)*/
	private void imprimeCod(Deque<Character> cod){
		System.out.printf("Simbolo: %c\t\tCodifica��o: ",this.simbolo);

		for(Character c : cod)
			System.out.print(c);

		System.out.println();
	}


	public char getSimbolo() {
		return simbolo;
	}

	public int getFrequencia() {
		return frequencia;
	}

	/* Caso necess�rio, o grupo pode definir novos m�todos. */
}