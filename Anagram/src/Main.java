import java.util.*;

public class Main {
    public static void main(String[] args) {


        Set<Point2D> set = new TreeSet<Point2D>(new Comparator<Point2D>() {
            @Override
            public int compare(Point2D o1, Point2D o2) {
                return o1.getX()-o2.getX();
            }
        });
        set.add(new Point2D(10,20));
        set.add(new Point2D(10,20));
        set.add(new Point2D(20,30));
        System.out.println(set);

        Set<Point2D> set1 = new TreeSet<Point2D>();
        set1.add(new Point2D(10,20));
        set1.add(new Point2D(10,20));
        set1.add(new Point2D(20,30));
        System.out.println(set1);


//        AnagramString str1= new AnagramString("ABCA");
//        AnagramString str2 =new AnagramString("BACA");
//        System.out.println(str1.equals(str2));
//        Map<AnagramString,Integer> map = new HashMap<>();
//        map.put(str1, 2);
//        map.put(str2, 3);
//        Map<AnagramString,Set<String>> map = new HashMap<>();
//
//        if (map.get("ABC") == null) {
//            map.put(new AnagramString("ABC"), new HashSet<String>());
//            map.get(new AnagramString("ABC")).add("ABC");
//        }else {
//            map.get(new AnagramString("ABC")).add("ABC");
//        }
//        System.out.println(map.get("BCA"));
//        if ((map.get("BCA") == null)) {
//            map.put(new AnagramString("BCA"), new HashSet<String>());
//            map.get(new AnagramString("BCA")).add("BCA");
//        }else {
//            map.get(new AnagramString("BCA")).add("BCA");
//        }
//        if ((map.get("CAB") == null)) {
//            map.put(new AnagramString("CAB"), new HashSet<String>());
//            map.get(new AnagramString("CAB")).add("CAB");
//        }else {
//            map.get(new AnagramString("CAB")).add("CAB");
//        }
//        map.
////        map.put(new AnagramString("CBASD"),new HashSet<String>());
////        map.get("CBASD").add("CBASD");
////        map.put(new AnagramString("BCA"),new HashSet<String>());
////        map.get("BCA").add("BCA");
////        map.put(new AnagramString("CBASD"),new HashSet<String>());
////        map.put(new AnagramString("BCA"),new HashSet<String>());
////        map.put(new AnagramString("ABSDC"),new HashSet<String>());
////        map.put(new AnagramString("AAA"),new HashSet<String>());
//
//        System.out.println(map);
//

    }
}
class AnagramString{
    String str;

    public AnagramString(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return this.str;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass()!=obj.getClass()) {
            return false;
        }else {
            AnagramString that = (AnagramString) obj;
            char[] thisObj = this.str.toCharArray();
            char[] thatObg = that.str.toCharArray();
            Arrays.sort(thisObj);
            Arrays.sort(thatObg);
            return Arrays.equals(thisObj, thatObg);
        }
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
class Point2D implements Comparable{
    private int x;
    private int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point2D{" +
                "x=" + x +
                ", y=" + y +
                '}';

    }

    @Override
    public int compareTo(Object obj) {
        Point2D that = (Point2D)obj;
        return this.getX() - that.getX();
    }
}