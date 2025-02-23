public class AndersenPageBDD {
    Feature: Open Andersen Website

    Scenario: Go to website
    Given I navigate to the Andersen website
    Then the website should be open

    Feature: Email and Password Visibility

    Scenario: Email and Password are visible
    Given I navigate to the Andersen website
    Then I should see the email field
    And I should see the password field

    Feature: SignIn

    Scenario: SignIn positive test
    Given I navigate to the Andersen website
    And I enter the email "tv_solovey@mail.com"
    And I enter the password "12345678"
    Then I should be signed in successfully