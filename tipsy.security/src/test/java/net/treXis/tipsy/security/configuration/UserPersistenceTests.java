package net.treXis.tipsy.security.configuration;

import net.treXis.tipsy.security.model.Users;
import net.treXis.tipsy.security.repository.UserJpaRepository;
import net.treXis.tipsy.security.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ContextConfiguration(classes = {UserRepository.class, UserJpaRepository.class})
@RunWith(SpringJUnit4ClassRunner.class)
@EnableJpaRepositories
@EnableTransactionManagement
public class UserPersistenceTests {

//	@Autowired
//	private UserRepository userRepository;

	@Autowired
	private UserJpaRepository userJpaRepository;

	@PersistenceContext
	private EntityManager entityManager;

	java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());

	@Test
	public void testFind(){
		Users users = userJpaRepository.findById(1000);
		assertEquals(1000, users.getUser_account());
	}

	@Test
	@Transactional
	public void testSaveAndGetAndDelete() {
		Users user = new Users();
//		user.setUser_account();
		user.setUsername("TestUser");
		user.setBcrypt_key("$2y$12$bricZ7h89pMIb/pVlORBsO2tMaD6S4n2RPlv4DHCOiUwJ00obU9o6");
		user.setFirst_name("Firstname");
		user.setLast_name("Lastname");
		user.setEmail("email@fakeemail.com");
		user.setPhone("1-555-555-5555");
		user.setCreation_date(date);
		user.setEnabled(true);
		user = userJpaRepository.create(user);

		entityManager.clear();

		Users plainUser = userJpaRepository.findById(user.getUser_account());
		assertEquals("TestUser", plainUser.getUsername());
		assertEquals("Firstname", plainUser.getFirst_name());
		System.out.println("Create Plain User Succeeded");
		userJpaRepository.delete(plainUser);
		System.out.println("Delete Plain User Succeeded");

	}


}


