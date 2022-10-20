public class Program {

	public static void main(String[] args) {
		
		User user1 = new User("Mike", 0);
		
		User user2 = new User("Nike", 0);
		
		System.out.println("User ID of "+ user1.getName() + " is " + user1.getidentifier());
		System.out.println("User ID of "+ user2.getName() + " is " + user2.getidentifier());
	}
	
}
