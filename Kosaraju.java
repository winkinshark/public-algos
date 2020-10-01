import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Stack;
public class Kosaraju
{
	public static LinkedList<Integer>[] change(LinkedList<Integer> graph[],ArrayList<Boolean> vis)
	{
		int n=graph.length;
		LinkedList<Integer> graph2[];
		graph2=new LinkedList[n];
		for(int i=0;i<n;i++)
		{
			graph2[i]=new LinkedList();
			vis.set(i,false);
		}
		for(int i=0;i<n;i++)
			for(int j:graph[i])
				graph2[j].add(i);
		return graph2;

	}
	public static Stack<Integer> nodes=new Stack<>();
	public static void dfs1(int src,LinkedList<Integer> graph[],ArrayList<Boolean> vis,Boolean flag)
	{
		vis.set(src,true);
		for(int i:graph[src])
		{
			if(!vis.get(i))
				dfs1(i,graph,vis,flag);
		}
		if(flag){

			nodes.push(src);
		}
		else 
		System.out.print(src+" ");	


	}
	public static void comps(int src,LinkedList<Integer> graph[], ArrayList<Boolean> vis)
	{


		while(!nodes.empty())
		{
			//System.out.print( nodes.pop()+" ");
			int t=nodes.pop();		
			if(!vis.get(t)){
				//System.out.println("t is " + t);
				dfs1(t,graph,vis,false);
				System.out.println();
			}
		}
	}

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		LinkedList<Integer> graph[];
		graph=new LinkedList[n];
		for(int i=0;i<n;i++)
			graph[i]=new LinkedList();
		int e=sc.nextInt();
		int a,b;
		for(int i=0;i<e;i++)
		{
			a=sc.nextInt();
			b=sc.nextInt();
			graph[a].add(b);
		}
		ArrayList<Boolean> vis=new ArrayList<>();
		for(int i=0;i<n;i++)vis.add(false);
		for(int i=0;i<n;i++){
			if(!vis.get(i))
				dfs1(i,graph,vis,true);									
		}
		graph=change(graph,vis);				
		comps(0,graph,vis);
	}
}
// 5
// 4
// 1 2
// 2 3
// 3 1
// 1 4
