Feature: Patch Opeartion - update User Details

Scenario: Verify that the patch API to update user details
Given user hit the url of patch user API endpoint
When user pass the url and new values for FirstName with UserId in the request
Then user recive the response code as 200 for patch operation