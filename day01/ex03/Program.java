public class Program {

    private static void printTransaction(Transaction transaction) {
        System.out.println("Transaction id: " + transaction.getIdentifier());
        System.out.println("Transaction category: " + transaction.transferCategory.getType());
        System.out.println("Transaction amount: " + transaction.getAmount());
        System.out.println("Transaction sender: " + transaction.getSender());
        System.out.println("Transaction recipient: " + transaction.getRecipient());
    }

    private static void printTransactionsLinkedList(TransactionsLinkedList tranList) {
        Transaction tmp = tranList.getBegin();
        while (tmp != null) {
            printTransaction(tmp);
            System.out.println(tmp);
            tmp = tmp.nextTransaction;
        }
    }


    public static void main(String[] args) {
        User userOne = new User("Сергей Леонидович", 1000);
        User userTwo = new User("Алексей Семенович", 2000);

        Transaction transOne = new Transaction(userOne, userTwo, Transaction.Transfer.DEBIT, 200);
		if (transOne != null) {
			userOne.setBalance(userOne.getBalance() - transOne.getAmount());
			userTwo.setBalance(userTwo.getBalance() + transOne.getAmount());
			System.out.println(transOne);
		}

		Transaction transTwo = new Transaction(userOne, userTwo, Transaction.Transfer.CREDIT, -300);
		if (transTwo != null) {
			userOne.setBalance(userOne.getBalance() - transTwo.getAmount());
			userTwo.setBalance(userTwo.getBalance() + transTwo.getAmount());
			System.out.println(transTwo);
		}

		Transaction transThree = new Transaction(userOne, userTwo, Transaction.Transfer.CREDIT, -100);
		if (transTwo != null) {
			userOne.setBalance(userOne.getBalance() - transThree.getAmount());
			userTwo.setBalance(userTwo.getBalance() + transThree.getAmount());
			System.out.println(transThree);
		}
        TransactionsLinkedList tranList = new TransactionsLinkedList();
        Transaction transArr[];
        tranList.addTransaction(transOne);
        tranList.addTransaction(transTwo);
		tranList.addTransaction(transThree);
        printTransactionsLinkedList(tranList);

        transArr = tranList.toArray();
        System.out.println("\nTransactionsLinkedList as array");
        for (int i = 0; i < transArr.length; i++) {
            printTransaction(transArr[i]);
        }

        tranList.deleteTransaction(transTwo.getIdentifier());
        System.out.println("\nTransactionsLinkedList after removing one transaction\n");
        printTransactionsLinkedList(tranList);
        tranList.deleteTransaction(transOne.getIdentifier());
        System.out.println("\nTransactionsLinkedList after removing one more transaction");
        printTransactionsLinkedList(tranList);
		tranList.deleteTransaction(transThree.getIdentifier());
        System.out.println("\nTransactionsLinkedList after removing one more transaction");
        printTransactionsLinkedList(tranList);
        System.out.println("\nTrying to remove transaction from empty TransactionsLinkedList\n");
        try {
            tranList.deleteTransaction(transOne.getIdentifier());
        } catch (TransactionNotFoundException e) {
			System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}