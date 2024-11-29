package Snorlax054;
public class Main9 {
	public static Node rand(int x, int y)
	{
		Node a = new Node((int)(Math.random()*(y - x + 1) + x));
		Node b = a;
		for(int i = 0;i < 19; i++)
		{
			Node c = new Node((int)(Math.random()*(y - x + 1) + x));
			b.isNext(c);
			b = c;
		}
		return a;
	}
	public static int inNode(Node a, int x)
	{
		int count = 0;
		Node index = a;
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
		Node a = rand(1, 50);
		System.out.println(a);
		System.out.println(inNode(a, 20));
	}

}
