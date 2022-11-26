import java.util.Scanner;

public class Main
{
	public static void main(String args[])
	{
		Scanner scanner = new Scanner(System.in);
		int n;
		
		System.out.println("Quantos simbolos?");
		n = scanner.nextInt();
		
		MinBinaryHeap heap = new MinBinaryHeap(n);

		heap.carregaDados();
		heap.imprime();
		heap.aplicaHuffman();
		heap.mostraCodigos();
		
		scanner.close();
	}
}