Feature: Delete Opeartion - delete User Details

Scenario: Verify that the delete API to update user details
Given user hit the url of delete user API endpoint
When user pass the url with UserId in the request
Then user recive the response code as 200 for delete operation