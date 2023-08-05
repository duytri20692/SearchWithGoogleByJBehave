Narrative:
As a user
I want to search for a specific keyword on the Google home page
So that I can find relevant results

Scenario: Search for "JBehave" on Google
Given I am on the Google home page
When I enter "JBehave" in the search bar
And I press the Enter key
Then I should see results including the text "What is JBehave?"
