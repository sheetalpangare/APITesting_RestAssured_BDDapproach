Feature: Post Operation - Add new user

Scenario: Verify that Add a New User with all mandatory and non mandatory fields
Given POST request with BaseURL and valid EndPoint
When User creates POST request with valid details
Then User recives the response code as 201