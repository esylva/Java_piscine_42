public class UserIdsGenerator{

	private static volatile UserIdsGenerator instance;

	private static Integer identifier = -1;

	private UserIdsGenerator(){
	}

	public static UserIdsGenerator getInstance() {
		if (instance == null)
			synchronized (UserIdsGenerator.class){
				if (instance == null){
					instance = new UserIdsGenerator();
				}
			}
		return instance;
	}

	public int generateId(){
		return identifier+=1;
	}
}
