import java.util.*;
import java.io.*;
public class SingSrcShtPth{
    public static void main(String args[])
    {
        System.out.println("enter the number of vertices");
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int arr[][]=new int[v][v];
        for(int i=0;i<v;i++)
        for(int j=0;j<v;j++)
        arr[i][j]=0;
        System.out.println("enter the number of edges");
        int e=sc.nextInt();
        System.out.println("enter the vertex numbers, along with the edge weights");
        for(int i=0;i<e;i++){
        int a=sc.nextInt();
        int b=sc.nextInt();
        int c=sc.nextInt();
        arr[a][b]=c;
        }
        //for(int i=0;i<v;i++){for(int j=0;j<v;j++)System.out.print(arr[i][j]);System.out.println();}
        System.out.println("Enter source");
        int src=sc.nextInt();
        System.out.println("enter destination");
        int dest=sc.nextInt();
        System.out.println(findcost(arr,src,dest));
    }
    static int findcost(int arr[][],int src,int dest)
    {
        int dist[]=new int[arr.length];
        Boolean vis[]=new Boolean[arr.length];
        for(int i=0;i<arr.length;i++){
        dist[i]=Integer.MAX_VALUE;
        vis[i]=false;}
        dist[src]=0;
        for(int c=0;c<arr.length-1;c++)
        {
            int x=findmin(vis,dist);
            vis[x]=true;
            for(int v=0;v<arr.length;v++)
            {
                if(vis[v]==false && arr[x][v]!=0 && dist[x]+arr[x][v]<dist[v])
                dist[v] = dist[x] + arr[x][v];
            }
        }
        //for(int i=0;i<arr.length;i++) System.out.println(dist[i]);
        //select minimum among dist(!=-1)
        //relax min, if possible. dist
        //return dist[dest];
        return dist[dest];
    }
    static int findmin(Boolean vis[],int dist[])
    {
        int min=Integer.MAX_VALUE,mind=-1;
        for(int i=0;i<dist.length;i++)
        {
            if(vis[i]==false && dist[i]<=min)
            {min=dist[i];
            mind=i;}
        }
        return mind;
    }
}
