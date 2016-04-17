
public class Node
{
    private int depth;
    private Node parent;
    private int[] nodeState;
    public Node(int[] m,int depth)
    {
        nodeState=new int[9];
        for(int i=0;i<m.length;i++)
            nodeState[i]=m[i];

        this.depth=depth;
    }

    public Node addParent (Node currentNode)
    {
        if (depth==0)
             parent=null;
        else{
             parent=currentNode;
         }

        return this;
    }
     public Node retuntParent ()
     {
         return parent;
     }
     public int[] returnNodeState()
     {
         return nodeState;
     }
    public int getDepth()
    {
        return depth;
    }

}
