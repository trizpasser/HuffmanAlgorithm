
import java.util.Deque;

/* Nessa implementação, os conceitos de "nó" e "árvore" se misturam. */
public class Arvbin
{
	private char simbolo; /* Símbolo armazenado no nó. */
	private int frequencia; /* Frequência do símbolo armazenado no nó. */
	private Arvbin esq, dir; /* Referências para subárvores esquerda e direita. */
	
	/* Construtor de árvore sem subárvores (dir = esq = null). São fornecidos
	 * apenas o símbolo e a frequência do nó. */
	public Arvbin(char simbolo, int frequencia)
	{
		this.simbolo = simbolo;
		this.frequencia = frequencia;

		//isso é um nó folha
	}
	
	/* Construtor de árvore com subárvores. Além de símbolo e frequência do nó,
	 * são fornecidas as subárvores, que devem ter sido construídas previamente. */
	public Arvbin(char simbolo, int frequencia, Arvbin esq, Arvbin dir)
	{
		this.simbolo = simbolo;
		this.frequencia = frequencia;
		this.esq = esq;
		this.dir = dir;

		//isso é uma árvore
	}
	
	/* Imprime o conteúdo da árvore em pré-ordem. */
	public void mostra()
	{
		System.out.print("(" + this.frequencia + this.simbolo);

		if (this.esq != null)
			this.esq.mostra();
		if (this.dir != null)
			this.dir.mostra();

		System.out.print(")");

		/* O grupo deve preencher a implementação. */
	}
	
	/* Novo método para imprimir os códigos de Huffman de cada símbolo na árvore. */
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

		/* O grupo deve preencher a implementação. */
	}

	/*O(n)*/
	private void imprimeCod(Deque<Character> cod){
		System.out.printf("Simbolo: %c\t\tCodificação: ",this.simbolo);

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

	/* Caso necessário, o grupo pode definir novos métodos. */
}