
import java.util.*;

public class Game {

    private int[] resultPosition;

    public Game ()
    {
        resultPosition= new int[]{1,2,3,4,5,6,7,8,0};
    }

    public int[] roads(int[] current)
    {
        int k=0,arr[];
        for(int i=0; i<current.length;i++)
        {
            if (current[i]==0)
            {
                k=i;
                break;
            }
        }

        if ((k==4))
        {
            arr=new int[4];
            arr[0]=current[1];
            arr[1]=current[3];
            arr[2]=current[5];
            arr[3]=current[7];

            //Arrays.sort(arr);
            return arr;
        }
        else if (k!=4)
        {
            if (k==0)
            {
                arr=new int[2];
                arr[0]=current[1];
                arr[1]=current[3];

                //Arrays.sort(arr);
                return arr;
            }
            if (k==2)
            {
                arr=new int[2];
                arr[0]=current[1];
                arr[1]=current[5];

                //Arrays.sort(arr);
                return arr;
            }
            if (k==6)
            {
                arr=new int[2];
                arr[0]=current[3];
                arr[1]=current[7];

                //Arrays.sort(arr);
                return arr;
            }
            if (k==8)
            {
                arr=new int[2];
                arr[0]=current[5];
                arr[1]=current[7];

                //Arrays.sort(arr);
                return arr;
            }
            if (k==1)
            {
                arr=new int[3];
                arr[0]=current[0];
                arr[1]=current[2];
                arr[2]=current[4];

                //Arrays.sort(arr);
                return arr;
            }
            if (k==3)
            {
                arr=new int[3];
                arr[0]=current[0];
                arr[1]=current[4];
                arr[2]=current[6];

                //Arrays.sort(arr);
                return arr;
            }
            if (k==5)
            {
                arr=new int[3];
                arr[0]=current[2];
                arr[1]=current[4];
                arr[2]=current[8];

                //Arrays.sort(arr);
                return arr;
            }
            if (k==7)
            {
                arr=new int[3];
                arr[0]=current[4];
                arr[1]=current[6];
                arr[2]=current[8];

                //Arrays.sort(arr);
                return arr;
            }
        }

        return new int[0];
    }

    public boolean result (int[] currentPosition)
    {
        for (int i=0; i<currentPosition.length; i++)
        {
            if (currentPosition[i]!=resultPosition[i])
                return false;
        }
        return true;
    }

    public int[] get ()
    {
         return resultPosition;
    }

    public int[] swap(int[] current, int swapNum)
    {
        int[] cur= new int[9];
        int NullCur=0;

        for(int i=0;i<current.length;i++)
        {
            cur[i]=current[i];
            if (current[i]==0)
            {
                 NullCur=i;
            }
        }

        for(int i=0; i<cur.length;i++)
        {
            if (swapNum==cur[i])
            {
                cur[NullCur]=cur[i];
                cur[i]=0;

                return cur;
            }
        }

        return cur;
    }
    public String intToString (int[]mass)
    {
        String str="";
        for (int i=0;i<mass.length;i++) {
            if (i < mass.length-1)
            {
                str = str + mass[i] + ",";
            }
            else
            {
                str = str + mass[i];
            }
        }

        return str;
    }

    public int[] stringToInt (String str)
    {
        int[] mass=new int[9];
        String[] str2= str.split(",");
        for (int i=0;i<9;i++)
            mass[i]=Integer.parseInt(str2[i]);

        return mass;
    }
}
