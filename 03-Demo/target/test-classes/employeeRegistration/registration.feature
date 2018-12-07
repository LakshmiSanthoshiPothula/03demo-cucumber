#Author:Santhoshi
@RegistrationForm

Feature: Registration
Background: User is on registration page

Scenario: check the heading of the registration page
Given User is on registration page
Then check the heading of the page 

Scenario: Successful registration with valid data
Description: Successful registration, user should enter his data in mandatory fields
Given User is on registration page
When User enters all mandatory fields
Then Display successful message

Scenario: Unsuccessful registration with invalid data
Description: unsuccessful registration if the user leaves all mandatory fields and click to register
Given User is on registration page
When User left the data in all mandatory fields as blank
Then Display error message

Scenario: Prompt user to enter the name if the user leaves the name field as blank
Given User is on registration page
When User left name field as blank
Then Display error message

Scenario: Prompt user to enter the email if the user leaves the email field as blank
Given User is on registration page
When User left email field as blank
Then Display error message

Scenario: prompt user when user enters the invalid email format
Given User is on registration page
When User enters the invalid email format
|santhu@gmail |
|santhu@njicom|
| |
Then Display error message

Scenario: Prompt user to enter the mobile number if the user leaves the mobile number field as blank
Given User is on registration page
When User left mobile number field as blank
Then Display error message

Scenario: prompt User if the User enters the invalid mobile number format
Given User is on registration page
When user enters the invalid mobile number
|1258456932|
|9999658|
|998565682475|
|ttecdftt|
| |
Then Display error message

