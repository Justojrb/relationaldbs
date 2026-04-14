package relationaldbs.test;

import relationaldbs.dao.UserDao;
import relationaldbs.dao.UserDaoImpl;
import relationaldbs.model.User;

public class UserDaoTest {

	public static void main(String[] args) {
		UserDao userDao = new UserDaoImpl();
		userDao.insert(new User(0, "Justo", null, 0, null, null, null, null, null));
	}
}
