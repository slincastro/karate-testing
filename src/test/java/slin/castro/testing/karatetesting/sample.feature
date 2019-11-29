Feature: sample

  @Conference
  Scenario: ListSessions
    Given url 'http://localhost:5656/api/v1/sessions'
    When method get
    Then status 200
    And assert response.length > 0

  @Conference
  Scenario: when i get speakers the response not be empty
    Given url 'http://localhost:5656/api/v1/speakers'
    When method get
    Then status 200
    And assert response.length > 0

  @Conference
   Scenario: when in send a request we create a session
    Given url 'http://localhost:5656/api/v1/sessions'
    And request  { "session_id": 1000, "session_name": "Keynote - The Golden Age of Software", "session_description": "",  "session_length": 45 }
    When method post
    Then status 201


