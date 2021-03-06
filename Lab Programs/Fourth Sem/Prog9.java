import java.io.*;
import java.util.*;

class Node
{
	public int vertex;
	public float distance;
	public char parent;
}
class Prog9
{
	public static void Insertion(Node arr[], int i, int j)
	{

		Node key = new Node();
		key.vertex = arr[i].vertex;
		key.distance = arr[i].distance;
		key.parent = arr[i].parent;
		i = i - 1;
		while(i >= j+1)
		{
			if(key.distance >= arr[i].distance)
			{
				break;
			}
			arr[i+1].distance = arr[i].distance;
			arr[i+1].vertex = arr[i].vertex;
			arr[i+1].parent = arr[i].parent;
			i--;
		}
		arr[i+1].distance = key.distance;
		arr[i+1].vertex = key.vertex;
		arr[i+1].parent = key.parent;
	}

	public static void Prim(float matrix[][], Node arr[], int vertices,int startVertex)
	{
		Scanner in = new Scanner(System.in);
		for(int i = 1; i < vertices - 1; i++)
		{
			for(int j = i + 1; j < vertices; j++)
			{
				if(arr[j].distance > matrix[arr[i].vertex][arr[j].vertex])
				{
					arr[j].distance = matrix[arr[i].vertex][arr[j].vertex];
					arr[j].parent = (char)(65 + arr[i].vertex);
					Insertion(arr, j, i);
				}
			}
			/*
			System.out.println("PARENT = " + (char)(65 + arr[i].vertex) + "    " + i);
			Display(arr, vertices);
			in.nextLine();
			*/
		}
		System.out.println();
	}
	public static void Display(Node arr[], int vertices)
	{
        System.out.print("Vertices : \t\t");
		for(int i = 0; i < vertices; i++)
		{
			System.out.print((char)(65 + arr[i].vertex) + "\t");
		}
		System.out.println();
        System.out.print("Distance : \t\t");
		for(int i = 0; i < vertices; i++)
		{
			if(arr[i].distance != 1.0/0)
			{
				System.out.print(arr[i].distance + "\t");
			}
			else
			{
				System.out.print( "INF\t");
			}
		}
		System.out.println();
		System.out.print("Parent : \t\t");
		for(int i = 0; i < vertices; i++)
		{
			System.out.print(arr[i].parent + "\t");
		}
		System.out.println();
	}
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int vertices;
		System.out.print("Enter number of vertices : ");
		vertices = in.nextInt();
		float matrix[][] = new float[vertices][vertices];
		System.out.println("Enter adjacency matrix for weighted digraph of n * n dimensions.");
		for(int i = 0; i < vertices; i++)
		{
			for(int j = 0; j < vertices; j++)
			{
				matrix[i][j] = in.nextFloat();
				if(matrix[i][j] == -1)
				{
					matrix[i][j] = 1.0f/0;
				}
			}
		}
		System.out.println("Enter starting vertex : ");
		int startVertex = in.nextInt();
		Node arr[] = new Node[vertices];
		for(int i = 0; i < vertices; i++)
		{
			arr[i] = new Node();
			arr[i].vertex = i;
			arr[i].distance = matrix[startVertex][i];
			Insertion(arr, i, 0);
		}
		arr[0].parent='-';
		for(int i = 1; i <vertices; i++)
		{
			if(arr[i].distance == 1.0/0)
			{
				break;
			}
			arr[i].parent = (char)(65 + arr[0].vertex);
		}

		Display(arr,vertices);
		Prim(matrix, arr, vertices, startVertex);
		System.out.println("Prims : ");
		Display(arr,vertices);
	}
}
/*
0 2 -1 -1 3 -1 -1 -1
2 0 9 -1 -1 4 -1 -1
-1 9 0 3 -1 -1 2 -1
-1 -1 3 0 -1 -1 -1 2
3 -1 -1 -1 0 10 -1 -1
-1 4 -1 -1 10 0 2 -1
-1 -1 2 -1 -1 2 0 8
-1 -1 -1 2 -1 -1 8 0
*/
