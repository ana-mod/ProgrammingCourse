public class TreeTest 
{
  public static void main(String[] args)
  {

    Tree<Double> d3 = new Tree<Double>();

    d3.insert(8.0); d3.insert(10.0); d3.insert(14.0); d3.insert(13.0); d3.insert(3.0); d3.insert(1.0); d3.insert(6.0); d3.insert(7.0); d3.insert(5.5);
    System.out.println(d3);
    d3.delete(3.0);
    System.out.println(d3);
    d3.delete(8.0);
    System.out.println(d3);
    System.out.println(d3.isElement(3.0));
    System.out.println(d3.isElement(7.0));
  }
}
