package simpleclass.eight;

public class CustomerList {

    private Customer[] customers;

    public CustomerList(Customer[] customers) {
        this.customers = customers;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public Customer[] sortByLastName() {

        Customer[] sortedCustomers = customers.clone();

        for (int i = 0; i < sortedCustomers.length; i++) {

            int minIndex = i;
            for (int j = i + 1; j < sortedCustomers.length; j++) {
                if (sortedCustomers[j].getLastName().compareTo(sortedCustomers[minIndex].getLastName()) < 0
                        || (sortedCustomers[j].getLastName().compareTo(sortedCustomers[minIndex].getLastName()) == 0
                        && sortedCustomers[j].getFirstName().compareTo(sortedCustomers[minIndex].getFirstName()) < 0)
                        || (sortedCustomers[j].getFirstName().compareTo(sortedCustomers[minIndex].getFirstName()) == 0)
                        && sortedCustomers[j].getSecondName().compareTo(sortedCustomers[minIndex].getSecondName()) < 0) {
                    minIndex = j;
                }

            }

            Customer buf = sortedCustomers[i];
            sortedCustomers[i] = sortedCustomers[minIndex];
            sortedCustomers[minIndex] = buf;
        }

        return sortedCustomers;

    }

    public void printCustomersByCard(long minCardNum, long maxCardNum) {
        Customer[] customers = sortByCardNumber();
        for (Customer customer : customers) {
            if (customer.getCreditCardNumber() >= minCardNum
                    && customer.getCreditCardNumber() <= maxCardNum) {
                System.out.println(customer);
            }
        }
    }

    private Customer[] sortByCardNumber() {

        Customer[] sortedCustomers = customers.clone();
        for (int i = 0; i < sortedCustomers.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < sortedCustomers.length; j++) {
                if (sortedCustomers[j].getCreditCardNumber() < sortedCustomers[minIndex].getCreditCardNumber()) {
                    minIndex = j;
                }

            }

            Customer buf = sortedCustomers[i];
            sortedCustomers[i] = sortedCustomers[minIndex];
            sortedCustomers[minIndex] = buf;
        }

        return sortedCustomers;

    }

}
