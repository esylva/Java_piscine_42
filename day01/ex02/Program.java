public class Program {
    public static void main(String[] args) {
        
        User user1 = new User("Вован Сидорович", 10000);
        User user2 = new User("Сергей Петрович", 2000);
        User user3 = new User("Алексей Навальнович", -1000);

        UsersList list = new UsersArrayList();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        System.out.println(list.getByIndex(0) + " == " + user1);
        System.out.println(list.getByIndex(user2.getidentifier()) + " == " + user2);

        System.out.println("Число пользователей = " + list.getNumberOfUsers());

        System.out.println("Создание нового пользователя без внесения его в список");
        User user4 = new User("Сидор Михайлович", 0);
        System.out.println(user4);

        try{
			System.out.println("Поиск в списке по ID \'3\'");
        	System.out.println(list.getById(3));
        }
        catch (UserNotFoundException e) {
            e.printStackTrace();
        }

        try{
		System.out.println("Поиск в списке по индексу");
        System.out.println(list.getByIndex(user4.getidentifier()));
        }
        catch (UserNotFoundException e) {
            e.printStackTrace();
        }
		
		User user5 = new User("Михаил Мяустович", 1000);
		list.add(user5);		
		System.out.println("\nПоиск в списке по индексу");
        System.out.println(list.getByIndex(3));
		System.out.println("Поиск в списке по ID");
        System.out.println(list.getById(4));
    }
}