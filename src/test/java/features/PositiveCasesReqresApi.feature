Feature: Validating Reqres User API's

  @Smoke @Users @Positive
  Scenario: Validate List Users
    Given a valid ListUsersAPI request
    When ListUsersAPI request is sent as Get HTTP request
    Then success response is sent back with status code 200
    And page value in response is "1"
    And per_page value in response is "6"
    And total value in response is "12"
    And total_pages value in response is "2"
    And data[0].email value in response is "george.bluth@reqres.in"
    And data[0].first_name value in response is "George"
    And data[0].last_name value in response is "Bluth"
    And length of data[0].avatar value in response must be greater than zero
    And response time must be less than 1000 ms

  @Smoke @Users @Positive
  Scenario: Validate Single User
    Given a valid ListUsersAPI request
    When ListUsersAPI request is sent as Get HTTP request
    Then success response is sent back with status code 200
    Given a valid SingleUserAPI request
    When SingleUserAPI request is sent as Get HTTP request
    Then success response is sent back with status code 200
    And data.email value in response is "george.bluth@reqres.in"
    And data.first_name value in response is "George"
    And data.last_name value in response is "Bluth"
    And length of support.url value in response must be greater than zero
    And length of support.text value in response must be greater than zero
    And response time must be less than 1000 ms

  @Smoke @Users @Positive
  Scenario Outline: Validate CreateUser add new user
    Given a valid CreateUserAPI payload with data "<name>" "<job>"
    When CreateUserAPI request is sent as Post HTTP request
    Then success response is sent back with status code 201
    And name value in response is "Marc"
    And job value in response is "Software Developer"
    Examples:
      | name | job                |
      | Marc | Software Developer |

  @Smoke @Users @Positive
  Scenario Outline: Validate PutUser add new user
    Given a valid CreateUserAPI payload with data "Ali" "QA"
    When CreateUserAPI request is sent as Post HTTP request
    Then success response is sent back with status code 201
    Given a valid PutUserAPI payload with data "<name>" "<job>"
    When PutUserAPI request is sent as Put HTTP request
    Then success response is sent back with status code 200
    And name value in response is "Steve"
    And job value in response is "Lawyer"
    Examples:
      | name  | job    |
      | Steve | Lawyer |

  @Smoke @Users @Positive
  Scenario Outline: Validate PatchUser add new user
    Given a valid CreateUserAPI payload with data "Ali" "QA"
    When CreateUserAPI request is sent as Post HTTP request
    Then success response is sent back with status code 201
    Given a valid PatchUserAPI payload with data "<name>" "<job>"
    When PatchUserAPI request is sent as Patch HTTP request
    Then success response is sent back with status code 200
    And name value in response is "Georgia"
    And job value in response is "Doctor"
    Examples:
      | name  | job    |
      | Georgia | Doctor |

  @Smoke @Stress
  Scenario: Validate delete user with id
    Given a valid ListUsersAPI request
    When ListUsersAPI request is sent as Get HTTP request
    Then success response is sent back with status code 200
    Given a valid DeleteUserAPI request
    When DeleteUserAPI request is sent as Delete HTTP request
    Then success response is sent back with status code 204