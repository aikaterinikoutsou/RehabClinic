package RehabClinicJPA;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import RehabClinicIfaces.UserManager;
import RehabClinicPOJOs.Role;
import RehabClinicPOJOs.User;

public class JPAUserManager implements UserManager{

	
	private EntityManager em;

	public JPAUserManager() {
		super();
		this.connect();
	}
	@Override
	public void connect() {
		// TODO Auto-generated method stub
		
		em = Persistence.createEntityManagerFactory("rehabclinic-provider").createEntityManager();
	
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys = ON").executeUpdate();
		em.getTransaction().commit();
		
		if(this.getRoles().isEmpty())
		{
			Role patient = new Role("Patient");
			Role clinician = new Role("Clinician");
			this.newRole(patient);
			this.newRole(clinician);
		}
		
	}
	
	@Override
	public void disconnect() {
		em.close();
	}
	
	@Override
	public void newUser(User u)
	{
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();		
	}
	
	
	@Override
	public void newRole(Role r) {
		
		em.getTransaction().begin();
		em.persist(r);
		em.getTransaction().commit();
		
	}
	
	@Override
	public Role getRole(Integer id) {
		
		Query q = em.createNativeQuery("SELECT * FROM roles where id="+ id, Role.class);
		Role r = (Role) q.getSingleResult();
		
		return r;
	}
	
	@Override
	public List<Role> getRoles(){
		
		Query q = em.createNativeQuery("SELECT * FROM roles", Role.class);
		@SuppressWarnings("unchecked")
		List<Role> roles = (List<Role>) q.getResultList();
		
		return roles;
	};
	
	
	@Override
	public User checkPassword(String email, String pw) {
		
		User u = null;
		
		
		Query q = em.createNativeQuery("SELECT * FROM users where email= ? AND password = ?", User.class);
		q.setParameter(1, email);
		try {
			MessageDigest md= MessageDigest.getInstance("MD5");
			md.update(pw.getBytes());
			byte[] digest = md.digest();
			q.setParameter(2, digest);
						
		}catch(NoSuchAlgorithmException e) {
			e.printStackTrace();
			
		}
		
		try {
			
			u = (User) q.getSingleResult();
		}catch(NoResultException e) {}
		
		return u;
		
	}

}
