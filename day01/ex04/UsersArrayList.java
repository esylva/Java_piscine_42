class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(){
        super("User not found.");
    }
}

public class UsersArrayList implements UsersList {
    private User[] usersList;
    private Integer numberOfUsers;

    private static Integer DEFAULT_SIZE = 10;

    public UsersArrayList() {
        usersList = new User[DEFAULT_SIZE];
        numberOfUsers = 0;
    }

    @Override
    public void add(User user) {
        if (usersList.length == numberOfUsers) {
            User[] newUsersList = new User[numberOfUsers + numberOfUsers];
            for (int i = 0; i < usersList.length; i++) {
                newUsersList[i] = usersList[i];
            }
            usersList = newUsersList;
        }
        usersList[numberOfUsers] = user;
        numberOfUsers++;
    }

    @Override
    public User getById(Integer id) {
        for (int i = 0; i < numberOfUsers; i++) {
            if (id.equals(usersList[i].getIdentifier())) {
                return usersList[i];
            }
        }
        throw new UserNotFoundException();
    }

    @Override
    public User getByIndex(Integer id) {
        if (id < 0 || id >= numberOfUsers) {
            throw new UserNotFoundException();
        }
        return usersList[id];
    }

    @Override
    public Integer getNumberOfUsers() {
        return numberOfUsers;
    }
}
