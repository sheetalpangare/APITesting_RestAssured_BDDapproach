Feature: Put Opeartion - update User 

Scenario: Verify that the put API to update user details
Given user hit the url of put user API endpoint
When user pass the url with new values for all fiels of users with UserId in the request
Then user recive the response code as 200 for put operation
