public class Program {
	
	public static void main(String[] args) {
		
		System.out.println("Try to create user John with -10000 amount");
		User user1 = new User("John", -10000);
        user1.setidentifier(1);
        User user2 = new User("Mike", 10000);
        user2.setidentifier(2);
		System.out.println(user1.getName() + "\'s balance is " + user1.getBalance().toString());
		System.out.println(user2.getName() + "\'s balance is " + user2.getBalance().toString());

		System.out.println("John wins 10000 in lottery\n");
		user1.setBalance(10000);

        Transaction transaction1 = Transaction.createTransaction(user1, user2, Transaction.Transfer.CREDIT, -500);
        if (transaction1 != null) {
			user1.setBalance(user1.getBalance() - transaction1.getAmount());
			user2.setBalance(user2.getBalance() + transaction1.getAmount());
			System.out.println(transaction1);
		}
		System.out.println(user1.getName() + "\'s balance is " + user1.getBalance().toString());
		System.out.println(user2.getName() + "\'s balance is " + user2.getBalance().toString());


		Transaction transaction2 = Transaction.createTransaction(user1, user2, Transaction.Transfer.DEBIT, 1500);
		if (transaction2 != null) {
			user1.setBalance(user1.getBalance() - transaction2.getAmount());
			user2.setBalance(user2.getBalance() + transaction2.getAmount());
    	    System.out.println(transaction2);
		}
		System.out.println(user1.getName() + "\'s balance is " + user1.getBalance().toString());
		System.out.println(user2.getName() + "\'s balance is " + user2.getBalance().toString());

		System.out.println("\nError amounts:\n");

        transaction1 = Transaction.createTransaction(user1, user2, Transaction.Transfer.DEBIT, -5000);
		if (transaction1 != null) {
			user1.setBalance(user1.getBalance() - transaction1.getAmount());
			user2.setBalance(user2.getBalance() + transaction1.getAmount());
			System.out.println(transaction1);
		}
		System.out.println(user1.getName() + "\'s balance is " + user1.getBalance().toString());
		System.out.println(user2.getName() + "\'s balance is " + user2.getBalance().toString());

        transaction1 = Transaction.createTransaction(user1, user2, Transaction.Transfer.DEBIT, 500000);
		if (transaction1 != null) {
			user1.setBalance(user1.getBalance() - transaction1.getAmount());
			user2.setBalance(user2.getBalance() + transaction1.getAmount());
			System.out.println(transaction1);
		}
		System.out.println(user1.getName() + "\'s balance is " + user1.getBalance().toString());
		System.out.println(user2.getName() + "\'s balance is " + user2.getBalance().toString());
	}
}
