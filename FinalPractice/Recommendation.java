import java.util.*;



public class Recommendation
{
	private final Map<String, Node> sets = new HashMap<>();

	public void add(String value)
	{
		if (sets.containsKey(value))
			return;
		sets.put(value, new Node(value));
	}

	public Node find(String value)
	{
		Node node = sets.get(value);
		if (node == null)
			return null;
		
		if (node != node.parent)
		{
			node.parent = find(node.parent.value);
			return node.parent;
		}
		return node;
	}

	public Node union(String val1, String val2)
	{
		Node node1 = find(val1);
		Node node2 = find(val2);
		
		if (node1 == null || node2 == null)
			return null;

		Node result = null;
		if (node1.rank > node2.rank)
		{
			node2.parent = node1;
			node1.rank++;
			result = node1;
		}
		else
		{
			node1.parent = node2;
			node2.rank++;
			result = node2;;
		}
		
		return result;
	}
	
	public Set<String> getSets()
	{
	    int maxSize = Integer.MIN_VALUE;
	    String parentNode = "";
		Map<String, Set<String>> map = new HashMap<>();
		for (Map.Entry<String, Node> entry : sets.entrySet())
		{
			Node n = find(entry.getValue().value);
			Set<String> set = map.get(n.value);
			if (set == null)
			{
				set = new TreeSet<String>();
				map.put(n.value, set);
			}
			set.add(entry.getValue().value);
			int currentSize = set.size();
			if(maxSize < currentSize){
                maxSize = currentSize;
                parentNode = n.value;
			}
			else if(maxSize == currentSize){
			    String currentItem = (String)((TreeSet)set).first();
			    String maxItem = (String)((TreeSet)(map.get(parentNode))).first();
			    if(currentItem.compareTo(maxItem)<0){
			        parentNode = n.value;
			    }
			}
		}
		
		return map.get(parentNode);
	}

	private class Node
	{
		private final String value;
		private Node parent;
		private int rank;

		public Node(String value)
		{
			this.value = value;
			parent = this;
		}
	}
	
	public static void main(String[] args)
	{
		Recommendation disjointSets = new Recommendation();
		String[][] input = new String[10][2];
		input[0][0] = "item201";
		input[0][1] = "item21";
		input[1][0] = "item31";
		input[1][1] = "item14";
		input[2][0] = "item2";
		input[2][1] = "item3";
		input[3][0] = "item5";
		input[3][1] = "item6";
		input[4][0] = "item7";
		input[4][1] = "item8";
		input[5][0] = "item9";
		input[5][1] = "item10";
		input[6][0] = "item6";
		input[6][1] = "item7";
		input[7][0] = "item81";
		input[7][1] = "item91";
		input[8][0] = "item31";
		input[8][1] = "item11";
		input[9][0] = "item15";
		input[9][1] = "item16";
		
		for(int i=0; i<input.length; i++){
		    if(input[i].length>0)
		    disjointSets.add(input[i][0]);
		    if(input[i].length>1)
		    disjointSets.add(input[i][1]);
		    if(input[i].length==2)
		    disjointSets.union(input[i][0],input[i][1]);
		}
	
		System.out.println(disjointSets.getSets());
	}

}