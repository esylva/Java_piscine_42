public class User{
	
	private Integer	identifier;

	private String	name;

	private Integer	balance;

	public User(String name, Integer balance) {
		this.name = name;
		if (balance > 0) {
			this.balance = balance;
		} else {
			this.balance = 0;
		}
		this.identifier = UserIdsGenerator.getInstance().generateId();

	}

	public Integer getidentifier() {
		return identifier;
	}

	public void setidentifier(Integer identifier) {
		this.identifier = identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Override
    public String toString() {
        return name + " (ID = " + identifier + ") balance " + balance;
    }
}
