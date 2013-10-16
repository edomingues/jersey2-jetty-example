package edomingues.resttest;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.junit.Before;
import org.junit.Test;
import edomingues.restserver.model.Saying;

public class RestServiceTest {

	private static final String TARGET_URI = "http://localhost:8080/hello";
	private static final String NAME = "world";
	private static final String EXPECTED = "Hello, " + NAME + "!";
	private static final String EXPECTED_JSON = "{\"name\":\"" + EXPECTED + "\"}";
	
	private WebTarget target;
	
	@Before
	public void setUp() {
		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonFeature.class);
		Client client = ClientBuilder.newClient(clientConfig);
		
		target = client.target(TARGET_URI);
	}
	
	@Test
	public void testHelloWorldJson() {
			
		String result = (String) target.path(NAME).request(MediaType.APPLICATION_JSON_TYPE).get(String.class);
		
		assertThat(result, is(equalTo(EXPECTED_JSON)));
	}
	
	@Test
	public void testHelloWorldObject() {
		Saying result = (Saying) target.path(NAME).request(MediaType.APPLICATION_JSON_TYPE).get(Saying.class);
		
		assertThat(result.name, is(equalTo(EXPECTED)));
	}
	
}
