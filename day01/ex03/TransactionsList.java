import java.util.UUID;

public interface TransactionsList {
	
	void addTransaction(Transaction transaction);

	void deleteTransaction(UUID idTransaction) throws TransactionNotFoundException;

	Transaction[] toArray();

}
