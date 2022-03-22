Feature: Negative Cases for Reqres API's

  @Smoke @Negative
  Scenario: Check CreateUserAPI add task empty name lastname
    Given a invalid CreateUserAPI payload with data "" ""
    When CreateUserAPI request is sent as Post HTTP request with invalid data
    Then fail api response is sent back with status code 422
    And response message value in response is "The given data was invalid."

  @Smoke @Negative
  Scenario: Check CreateUserAPI add task null name lastname
    Given a invalid CreateUserAPI payload with data null null
    When AddTaskAPI request is sent as Post HTTP request with invalid data
    Then fail api response is sent back with status code 422
    And response message value in response is "The given data was invalid."

  @Smoke @Negative
  Scenario: Check CreateUserAPI add user name with long characters
    Given a invalid CreateUserAPI payload with data "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s"
    When CreateUserAPI request is sent as Post HTTP request with invalid data
    Then fail api response is sent back with status code 422
    And response message value in response is "The given data was invalid."
    And errors.title value in response body is "The title may not be greater than 255 characters."

  @Smoke @Negative
  Scenario: Check get single user with invalid id
    Given a invalid SingleUserAPI request
    When SingleUserAPI request is sent as Get HTTP request with invalid data
    Then fail api response is sent back with status code 404

  @Smoke @Negative
  Scenario: Check put user with invalid id
    Given a invalid PutUserAPI payload with data "Update Task"
    When PutUserAPI request is sent as Put HTTP request with invalid data
    Then fail api response is sent back with status code 404

  @Smoke @Negative
  Scenario: Check put user with empty name lastname
    Given a invalid PutUserAPI payload with data "" ""
    When PutUserAPI request is sent as Put HTTP request with invalid data
    Then fail api response is sent back with status code 422
    And response message value in response is "The given data was invalid."

  @Smoke @Negative
  Scenario: Check put user with null name lastname
    Given a invalid PutUserAPI payload with data null
    When PutUserAPI request is sent as Put HTTP request with invalid data
    Then fail api response is sent back with status code 422 
    And response message value in response is "The given data was invalid."

  @Smoke @Negative
  Scenario: Check patch task with null name lastname
    Given a invalid PatchUserAPI payload with data null
    When PatchUserAPI request is sent as Put HTTP request with invalid data
    Then fail api response is sent back with status code 422
    And response message value in response is "The given data was invalid."

  @Smoke @Negative
  Scenario: Validate delete user with invalid id
    Given a invalid DeleteUserAPI request
    When DeleteUserAPI request is sent as Delete HTTP request with invalid data
    Then fail api response is sent back with status code 404