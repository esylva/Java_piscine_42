import java.util.UUID;

public class Transaction {

	private UUID		idTransaction;
	private User		senderUser;
	private User		recipientUser;
	private Transfer	transferCategory;
	private Integer 	transferAmount;

	enum		Transfer{

		CREDIT("OUTCOME"),
		DEBIT("INCOME");
		private String type;

		Transfer(String type) {
			this.type = type;
		}

		public String getType() {
            return type;
        }


		@Override
		public String toString() {
			return type;
		}

	}
	

	private Transaction (User sender, User recipient, Transfer transferCategory, Integer transferAmount){

		this.senderUser = sender;
		this.recipientUser = recipient;
		this.transferCategory = transferCategory;
		this.transferAmount = transferAmount;
		this.idTransaction = UUID.randomUUID();
	}

	public static Transaction createTransaction(User sender, User recipient, Transfer transferCategory, Integer amount) {
        if ((transferCategory == Transfer.CREDIT && amount < 0 && recipient.getBalance() >= -amount)
                || (transferCategory == Transfer.DEBIT && amount > 0 && sender.getBalance() >= amount)) {
			return new Transaction(sender, recipient, transferCategory, amount);
        }
		System.out.println("Transaction declined");
        return null;
    }

    public void setIdentifier(UUID idTransaction) {
        this.idTransaction = idTransaction;
    }

    public UUID getIdentifier() {
        return idTransaction;
    }

    public User getRecipient() {
        return recipientUser;
    }

    public User getSender() {
        return senderUser;
    }

    public Integer getAmount() {
        return transferAmount;
    }

    @Override
    public String toString() {
        return String.format("From %20s\tto %20s, %10s, %9s, %36s",	senderUser.getName(), recipientUser.getName(), transferAmount, transferCategory, idTransaction);
    }

}
