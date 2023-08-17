package crazyFitness.services.testUser;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;


import crazyFitness.model.User;
import crazyFitness.services.UserService;
import crazyFitness.services.exceptions.ServiceException;



	
 class TestRegisterFeature {
	
//	private UserDAO userDAO;
//
//    @BeforeEach
//    void setUp() {
//    	userDAO = new UserDAO();
//    } 
//	
//     static String url = "jdbc:mysql://localhost/crazyfitness";
//     static String username = "root";
//     static String password = "123456";
    
//    @BeforeAll
//    public static void setupDatabase() throws SQLException {
//		try (Connection connection = DriverManager.getConnection(url,username,password);
//				Statement stmt = connection.createStatement()) {
//			// Create the "tasks" table if it doesn't exist
//			String createTableQuery = "CREATE TABLE IF NOT EXISTS user (" + "user_id INT PRIMARY KEY auto_increment NOT NULL, "+ "first_name VARCHAR(50)  NOT NULL, " + "last_name VARCHAR(50)  NOT NULL, " + "age VARCHAR(20) NOT NULL, "
//+ "email VARCHAR(100) unique NOT NULL, " +"password VARCHAR(50) NOT NULL, " +"phone VARCHAR(20) NOT NULL, " +
//					"address VARCHAR(225))";
//			stmt.executeUpdate(createTableQuery);
//		}
//	} 
    
//    @AfterAll
//    public static void tearDownDatabase() throws SQLException {
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             Statement stmt = connection.createStatement()) {
//            // Drop the "tasks" table after all tests are executed
//            String dropTableQuery = "DROP TABLE IF EXISTS user";
//            stmt.executeUpdate(dropTableQuery);
//        }
//    }
	
	@Test
	public void testRegistrationSuccess() {
		UserService userService = new UserService();
		User user = new User("Hari","haran",19,"hari10haran@gmail.com","Haripassword$10","9551096952","Erode");
		try {
			assertTrue(userService.registerUser(user));
		} catch ( ServiceException e) {
			e.printStackTrace();
			fail();
		}	
	}
	 
	@Test  
	 void testNullUser() {
		UserService userService = new UserService(); 
		User user = null;
		
		try { 
			assertFalse(userService.registerUser(user));
		} catch ( ServiceException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	 void testRegistrationExistsingUser() {
		UserService userService = new UserService();
		User user = new User("Hari","haran",19,"hari10haran@gmail.com","Haripassword$10","9551096952","Erode");
		try {
			assertFalse(userService.registerUser(user));
		} catch ( ServiceException e) {
			e.printStackTrace();

		}
	}

}
