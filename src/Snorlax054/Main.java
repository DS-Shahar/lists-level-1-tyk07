package Snorlax054;
public class Main {
	public static Node<Integer> rand(int x, int y, int n)
	{
		Node<Integer> a = new Node<Integer>((int)(Math.random()*(y - x + 1) + x));
		Node<Integer> b = a;
		for(int i = 0;i < n-1; i++)
		{
			Node<Integer> c = new Node<Integer>((int)(Math.random()*(y - x + 1) + x));
			b.setNext(c);
			b = c;
		}
		return a;
	}
	public static int inNode(Node<Integer> a, int x)
	{
		int count = 0;
		Node<Integer> index = a;
		while(index != null)
		{
			if(index.data == x)
			{
				count++;
			}
			index = index.next;
		}
		return count;
	}
	public static void main(String[] args) {
		Node<Integer> a = rand(1, 50, 20);
		System.out.println(a);
		System.out.println(inNode(a, 20));
	}

}