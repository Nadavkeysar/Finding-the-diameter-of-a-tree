import java.util.*;

class Diameter
{
    static Vector<Vector<Integer>> arr = new Vector<Vector<Integer>>();    
    static int diameter[] = new int[10001];
    static int n;
    public Diameter(boolean a[][])
    {
        for(int i =0;i<a.length;i++)
        {
            for(int j=0;j<a[0].length;j++)
            {
                if(a[i][j] == true)
                    arr.get(i).add(j);
            }
        }
    }
    
    
    static int bfs(int init,Vector<Vector<Integer>>arr, int n)
    {
    	Queue<Integer> q = new LinkedList<>();
    	q.add(init);
    
    	int visited[] = new int[n + 1];
    	for (int i = 0; i <= n; i++)
    	{
    		visited[i] = 0;
    		diameter[i] = 0;
    	}
    	q.add(init);
    	// Mark the traversed node visited
    	visited[init] = 1;
    	while (q.size() > 0)
    	{
    		int u = q.peek();
    		q.remove();
    		for (int i = 0;i < arr.get(u).size(); i++)
    		{
    			if (visited[arr.get(u).get(i)] == 0)
    			{
    				visited[arr.get(u).get(i)] = 1;
    				diameter[arr.get(u).get(i)] += diameter[u] + 1;
    				q.add(arr.get(u).get(i));
    			}
    		}
    	}
    	int in = 0;
    	for(int i = 0; i <= n; i++)
    	{
    		if(diameter[i] > diameter[in])
    		in = i;
    	}
    	return in;
    }
    
    public int get_diam(Vector<Vector<Integer>> arr, int n)
    {
    	int init = bfs(1, arr, n);
    	int val = bfs(init, arr, n);
    	return diameter[val];
    }

    public static void main(String args[])
    {
        //boolean[][] a = new boolean[3][3];
        
        Diameter main = new Diameter(a);
    	
    	Scanner s = new Scanner(System.in);
    	
    	System.out.println("Enter number of vertices");
    	
    	n = s.nextInt();
    	
    	for(int i = 0; i < n + 1; i++)
    	{
    		arr.add(new Vector<Integer>());
    	}
    	System.out.printf("Diameter is %d\n",main.get_diam(arr, n));
    }
}
