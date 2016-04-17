import java.util.*;

public class Main {
    public static void main (String[] args)
    {
        int[] current= {8,1,2,7,0,5,4,3,6};
        int[] newState;
        Game newGame= new Game();
        Set<String> passedState=new HashSet<String>();
        Set<Node> myNodes=new HashSet<Node>();
        Stack<String> stack =new Stack<String>();
        String cur,newCur;
        int depth=0, time=0, capacity=0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Введите целое число: ");
        int ii=0;   boolean depthLvl=true;
        if(sc.hasNextInt()) {
            ii = sc.nextInt();
        }
        //-----------end init---------------
        Node root= new Node(current,depth);
        cur=newGame.intToString(current);
        stack.push(cur);
        passedState.add(cur);
        myNodes.add(new Node(current, depth));
        //---------root--------------

        while (true)
        {
            if (newGame.result(current))
            {
                System.out.println("Путь найден!");
                break;
            }
            /*
            if (cur.equals("1,2,0,8,7,3,4,6,5"))
            {
                int k=12;
            } */
            if (depth<ii)
            {
                depth++;
                int[] counts = newGame.roads(current);
                capacity++;
                time++;

                for (int g = 0; g < counts.length; g++) {
                    newState = newGame.swap(current, counts[g]);
                    newCur = newGame.intToString(newState);
                    if (passedState.add(newCur)) {
                        passedState.remove(newCur);
                        time+=2;
                        //-----------------------------
                        stack.push(newCur);
                        //Node newRootState = new Node(newState, depth);
                        //newRootState.addParent(root);
                        //myNodes.add(newRootState);
                        myNodes.add(new Node(newState,depth).addParent(root));
                    }
                }
            }
            if (stack.isEmpty())
            {
                depthLvl=false;
                System.out.println("Путь НЕ найден!!!");
                break;
            }
            cur=stack.pop();
            current=newGame.stringToInt(cur);
            for (Node n: myNodes)
            {
                if (newGame.intToString(n.returnNodeState()).equals(cur))
                {
                    root=n;
                    break;
                }
            }
            time++;
            depth=root.getDepth();
            passedState.add(cur);
        }

        if (depthLvl) {
            System.out.println("<-1,2,3,4,5,6,7,8,0->");
            int finalState = 0;

            while (true) {
                if (root.retuntParent() == null)
                    break;
                Node par = root.retuntParent();
                root = par;
                String goHome = newGame.intToString(par.returnNodeState());
                System.out.print("<-" + goHome + "->");
                finalState++;
            }
            System.out.println("[" + finalState + "]");
        }
    }
}
