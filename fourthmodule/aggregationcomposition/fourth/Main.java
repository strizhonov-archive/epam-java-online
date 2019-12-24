package aggregationcomposition.fourth;

import java.util.Arrays;

/**
 * Testing class
 */
public class Main {

    public static void main(String[] args) {

        Account acc1 = new Account(123, 156.9d, false);
        Account[] accs1 = new Account[]{acc1};
        Client client1 = new Client(1, accs1);
        acc1.setOwner(client1);

        Account acc2 = new Account(11, -7d, true);
        Account[] accs2 = new Account[]{acc2};
        Client client2 = new Client(34, accs2);
        acc2.setOwner(client2);

        Account acc3 = new Account(455, 768d, false);
        Account acc4 = new Account(1, 234d, false);
        Account[] accs3 = new Account[]{acc3, acc4};
        Client client3 = new Client(45, accs3);
        acc3.setOwner(client3);
        acc4.setOwner(client3);


        Bank bank = new Bank(new Client[]{client1, client2, client3});

        System.out.println(bank.findAccount(123));

        Account[] accounts = bank.findAccounts(45);
        System.out.println(Arrays.deepToString(accounts));

        accounts = bank.getSortedByBalance();
        System.out.println(Arrays.deepToString(accounts));

        accounts = bank.getSortedById();
        System.out.println(Arrays.deepToString(accounts));

        System.out.println(bank.getTotal());
        System.out.println(bank.getTotalPos());
        System.out.println(bank.getTotalNeg());
    }

}
