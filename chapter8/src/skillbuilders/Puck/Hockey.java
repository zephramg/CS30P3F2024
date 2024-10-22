package skillbuilders.Puck;

/* Modified version of Hockey class to account for P2 of puck. */

/**
 * Hockey application to test the Puck class with Comparable interface.
 */
public class Hockey {
    public static void main(String[] args) {
        Puck puck1 = new Puck(5.3);
        Puck puck2 = new Puck(4.2);
        Puck puck3 = new Puck(5.3);

        System.out.println("Puck 1: " + puck1);
        System.out.println("Puck 2: " + puck2);
        System.out.println("Puck 3: " + puck3);

        System.out.println("Puck 1 weight: " + puck1.getWeight());
        System.out.println("Puck 1 division: " + puck1.getDivision());

        System.out.println("Puck 2 weight: " + puck2.getWeight());
        System.out.println("Puck 2 division: " + puck2.getDivision());

        // Test equals method
        if (puck1.equals(puck2)) {
            System.out.println("Puck 1 and Puck 2 are equal.");
        } else {
            System.out.println("Puck 1 and Puck 2 are not equal.");
        }

        if (puck1.equals(puck3)) {
            System.out.println("Puck 1 and Puck 3 are equal.");
        } else {
            System.out.println("Puck 1 and Puck 3 are not equal.");
        }

        // Test compareTo method
        System.out.println("Comparing Puck 1 and Puck 2: " + puck1.compareTo(puck2));
        System.out.println("Comparing Puck 1 and Puck 3: " + puck1.compareTo(puck3)); 
        System.out.println("Comparing Puck 2 and Puck 3: " + puck2.compareTo(puck3)); 
    }
}