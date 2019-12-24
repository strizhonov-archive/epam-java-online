package simpleclass.eight;

import java.util.Arrays;

/**
 * Testing class
 */
public class Main {

    public static void main(String[] args) {
        Customer[] customers = new Customer[]{
                new Customer(1, "Oleg", "Gorodkov", "Ivanovich",
                        "Esenina str.", 3223_7899_0338_9993L, 5542),
                new Customer(2, "Kirill", "Masukevich", "Andreevich",
                        "Orlova str.", 4523_0444_0313_9231L, 1243),
                new Customer(3, "Max", "Pilipenko", "Denisovich",
                        "Chaletskaya str.", 7623_0444_0353_1333L, 5466),
                new Customer(4, "Evgenij", "Gameza", "Leonidovich",
                        "Dzerzhinskogo str.", 1625_0400_0033_9511L, 8976),
        };
        CustomerList cList = new CustomerList(customers);

        System.out.println(Arrays.deepToString(cList.sortByLastName()));

        cList.printCustomersByCard(2000_0000_0000_0000L, 7000_0000_0000_0000L);

    }
}
