package Lists.ArrayBasedList;

public class Main {
    public static void main(String[] args) {
        MyArrayList arrLis = new MyArrayList(5);

arrLis.append("a");

arrLis.prepend("s");

arrLis.append("d");

arrLis.prepend("f");

arrLis.append("g");

arrLis.insert(3, "h");

arrLis.insert(0, "j");

arrLis.insert(7, "k");

arrLis.append("l");

System.out.println(arrLis);

System.out.println(arrLis.remove(2));

System.out.println(arrLis);

arrLis.remove("a");

System.out.println(arrLis);

System.out.println(arrLis.get(1));

arrLis.set(4, "m");

System.out.println(arrLis);
    }
}