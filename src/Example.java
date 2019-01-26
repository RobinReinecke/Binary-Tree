/**
 * Example
 */
public class Example {

    public static void main(String[] args) {
        Tree tree = new Tree(7);
        int [] numbers = {4 ,6 ,5 ,2 ,1 ,3 ,15 ,19 ,11 ,9 ,13 ,8};
        for ( int number : numbers ) {
            tree.insert ( number ) ;
        }

        System.out.println(tree.toString());
        System.out.println("Height: " + tree.getHeight());
        System.out.println("Exists 8? " + tree.getValueExists(8));
        System.out.println("Exists 10? " + tree.getValueExists(10));
        System.out.println("Minimum: " + tree.getMinValue());
        System.out.println("Maximum: " + tree.getMaxValue());
        System.out.println("Degenerate: " + tree.getIsDegenerate());

        Tree tree2 = new Tree(2);
        tree2.insert(1);
        tree2.insert(3);

        System.out.println("\n" + tree2.toString());
        System.out.println("Degenerate: " + tree2.getIsDegenerate());
    }
}