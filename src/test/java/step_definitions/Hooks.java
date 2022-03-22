package step_definitions;

import io.cucumber.java.Before;

public class Hooks {

	@Before("not (@Smoke and @Users)")
	public void addPlaceStub()
	{
		BlingStepDefinition stepDefs = new BlingStepDefinition();
		
		if (BlingStepDefinition.getAccessToken().isEmpty())
		{
			//stepDefs.post_a_valid_token_with_login_api_with_data("aliboztemir@gmail.com", "1234");
		}
	}
}
