package RehabClinicIfaces;

import java.util.List;

import RehabClinicPOJOs.Role;
import RehabClinicPOJOs.User;

public interface UserManager {

	void connect();
	void disconnect();
	void newRole(Role r);
	void newUser(User u);
	Role getRole(Integer id);
	List<Role> getRoles();

}
