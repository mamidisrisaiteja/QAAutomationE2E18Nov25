Feature: Login Page

  Scenario: Login Page - Positive Flow
    Given I am in Login Page
    When I login with username "standard_user" and password "secret_sauce"
    Then I Verify the title "Swag Labs"

  Scenario: Login Page - Negative Flow
    Given I am in Login Page
    When I login with username "standard_user" and password "secret_sauc"
    Then I Verify the title "Swag Lab"