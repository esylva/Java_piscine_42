public class Program {

    // private static void printTransaction(Transaction transaction) {
    //     System.out.println("Transaction id: " + transaction.getIdentifier());
    //     System.out.println("Transaction category: " + transaction.transferCategory.getType());
    //     System.out.println("Transaction amount: " + transaction.getAmount());
    //     System.out.println("Transaction sender: " + transaction.getSender());
    //     System.out.println("Transaction recipient: " + transaction.getRecipient());
    // }

    private static void printTransactionsLinkedList(TransactionsList tran) {
		TransactionsLinkedList tranList = (TransactionsLinkedList)tran;
		Transaction tmp = tranList.getBegin();
        while (tmp != null) {
            // printTransaction(tmp);
            System.out.println(tmp);
            tmp = tmp.nextTransaction;
        }
    }

    public static void main(String[] args) {
        User user1 = new User("Сергей Михайлович", 10000);
        User user2 = new User("Семен Карлович", 50000);

        TransactionsService service = new TransactionsService();

        service.add(user1);
        service.add(user2);

        service.transfer(user1.getIdentifier(), user2.getIdentifier(), 1000);
        service.transfer(user1.getIdentifier(), user2.getIdentifier(), -1001);

        System.out.println("------------------------");
		printTransactionsLinkedList(user1.transactionsList);
        System.out.println("------------------------");
		printTransactionsLinkedList(user2.transactionsList);
        System.out.println("\nchoose and del transaction");
        Transaction tmp = service.getTransactions(user1)[0];
        System.out.println(tmp);
        System.out.println("------------------------");
        service.deleteTransaction(user1.getIdentifier(), service.getTransactions(user1)[0].getIdentifier());
		printTransactionsLinkedList(user1.transactionsList);
        System.out.println("------------------------");
		printTransactionsLinkedList(user2.transactionsList);
        System.out.println("\nnot valid without pair");
		Transaction []t = service.retrieveTransfers();
		for (int i = 0; i < t.length - 1; i++){
            System.out.println(t[i]);
            service.deleteTransaction(t[i].getSender().getIdentifier(), t[i].getIdentifier());
		}
		System.out.println("Error transfer:");
        service.transfer(user1.getIdentifier(), user2.getIdentifier(), 1_000_000);
    }
}