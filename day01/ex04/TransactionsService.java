import java.util.UUID;

public class TransactionsService extends RuntimeException {

	private UsersList list;

	public TransactionsService() {
		list = new UsersArrayList();
	}

	public void add(User user){
		list.add(user);
	}

	public Transaction[] getTransactions(User user) {
		return user.transactionsList.toArray();
	}

	public void deleteTransaction(Integer userId, UUID idTransaction){
		User user = list.getById(userId);
		user.transactionsList.deleteTransaction(idTransaction);
	}

	public void transfer(Integer senderId, Integer recipientId, Integer transferAmount) throws IllegalTransactionException{
		
		User sender = list.getById(senderId);
		User recipient = list.getById(recipientId);
		Transaction.Transfer transferCategory;
		
		if (transferAmount > 0) {
			transferCategory = Transaction.Transfer.DEBIT;
			Transaction transfer1 = Transaction.createTransaction(sender, recipient, 
				transferCategory, transferAmount);
			if (transfer1 == null) {
				throw new IllegalTransactionException("Insufficient funds in the account");
			}
			transferCategory = Transaction.Transfer.CREDIT;
			Transaction transfer2 = Transaction.createTransaction(recipient, sender,
				transferCategory, -transferAmount);
			if (transfer2 == null) {
				throw new IllegalTransactionException();
			}
			transfer2.setIdentifier(transfer1.getIdentifier());
			sender.transactionsList.addTransaction(transfer1);
			recipient.transactionsList.addTransaction(transfer2);	
		}
		else if (transferAmount < 0) {
			transferCategory = Transaction.Transfer.CREDIT;
			Transaction transfer1 = Transaction.createTransaction(sender, recipient, 
			transferCategory, transferAmount);
			if (transfer1 == null) {
				throw new IllegalTransactionException("Insufficient funds in the account");
			}
			transferCategory = Transaction.Transfer.DEBIT;
			Transaction transfer2 = Transaction.createTransaction(recipient, sender,
				transferCategory, -transferAmount);
			if (transfer2 == null) {
				throw new IllegalTransactionException();
			}
			transfer2.setIdentifier(transfer1.getIdentifier());
			sender.transactionsList.addTransaction(transfer1);
			recipient.transactionsList.addTransaction(transfer2);
		}
		else {
			throw new IllegalTransactionException("Transfer amount is 0");
		}
	}

	public Transaction[] retrieveTransfers() {
		TransactionsList notPairTransactions =  new TransactionsLinkedList();
	
		for (int i = 0; i < list.getNumberOfUsers(); i++){
			for (Transaction tmp : getTransactions(this.list.getByIndex(i))){
				boolean pair = false;
				for (Transaction tmp2 : getTransactions(tmp.getRecipient())) {
					if (tmp.getIdentifier() == tmp2.getIdentifier()){
						pair = true;
						break;
					}
				}
				if (!pair) {
					notPairTransactions.addTransaction(tmp);
				}
			}
		}
		return notPairTransactions.toArray();
	}

	void retrieveBalance(User user){
		Transaction [] t = getTransactions(user);
		Integer balance = user.getBalance();
		for (Transaction tmp : t){
			balance -= tmp.getAmount();
		}
		user.setBalance(user.getBalance() - balance);
	}
}
