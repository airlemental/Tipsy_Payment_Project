package net.treXis.tipsy.security.configuration;

import net.treXis.tipsy.security.model.User;
import net.treXis.tipsy.security.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

//@ContextConfiguration(classes = {UserRepository.class, User.class, JpaConfiguration.class, UsersController.class})
//@RunWith(SpringRunner.class)

@EnableJpaRepositories
@EnableTransactionManagement
@SpringBootTest(classes = UserRepository.class)
@TestPropertySource()
//@DataJpaTest  // tries to force the usage of in memory database, not good for integration testing
//@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE) //trying to force @DataJpaTest to use MySQL datasource
public class UserPersistenceTests {

//	@Autowired
//	JpaConfiguration jpaConfiguration;

	@Autowired
	private UserRepository userRepository;

	@PersistenceContext
	private EntityManager entityManager;

	java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());

	@Test
	public void testExistsFind() {
		List<User> users = userRepository.findAll();
		assertNotNull(users);
	}

	@Test
	public void findById(Long id) {
		assertEquals(1000L, id);
	}

	@Test
	@Transactional
	public void testSaveAndGetAndDelete() {
		User user = new User();
//		user.setUser_account();
		user.setUsername("TestUser");
		user.setBcrypt_key("$2y$12$bricZ7h89pMIb/pVlORBsO2tMaD6S4n2RPlv4DHCOiUwJ00obU9o6");
		user.setFirst_name("Firstname");
		user.setLast_name("Lastname");
		user.setEmail("email@fakeemail.com");
		user.setPhone("1-555-555-5555");
		user.setCreation_date(date);
		user.setEnabled(true);
		userRepository.saveAndFlush(user);

		entityManager.clear();

		User plainUser = (User) userRepository.findAll();
		assertEquals("TestUser", plainUser.getUsername());
		assertEquals("Firstname", plainUser.getFirst_name());
		System.out.println("Create Plain User Succeeded");
		userRepository.delete(plainUser);
		System.out.println("Delete Plain User Succeeded");

	}


}


