public interface UsersList {

    User getById(Integer id);

    User getByIndex(Integer id);
	
    Integer getNumberOfUsers();

    void add(User user);
}