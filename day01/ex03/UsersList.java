public interface UsersList {

    User getById(Integer id) throws UserNotFoundException;

    User getByIndex(Integer id) throws UserNotFoundException;
	
    Integer getNumberOfUsers();

    void add(User user);

}