#Bank GUI 


This banking GUI was created using Netbeans and Gluon scene builder. The GUI allows the users to create an employee that then has the ability to create new customers and accounts (checking, saving, and loan). The employee can then make direct transactions (withdraw, deposit, transfer) to those accounts.

#Requirements 

Java FX  8

Java JDK 11

#Installation

To ensure that this GUI can be run properly Java FX must be activated in the primary IDE.Activate Java FX using the following instructions based on primary IDE:

https://openjfx.io/openjfx-docs/

#Download

To download Java FX go to:

https://gluonhq.com/products/javafx/

#Instructions

1. The application requires the users to create an employee account before accessing the applications full functionality. 

$Employee Name:
$Employee ID:
$Pin:

2. Once the Employee has been successfully created the users will be prompted to enter the employee ID and pin.

$Employee ID:
$Pin:

3. Once logged in the users can use the tabs at the top of the interface to make transactions, make payments, create or delete accounts, and view bank information. The options require the following input to execute the functions.

*Transactions 
	- Deposit
		- Account Number
		- Amount
	- Withdraw
		- Account Number
		- Amount
	- Transfer
		- 1st Account Number
		- 2nd Account Number
		- Amount

*Payment
	- payment
		- Account Number
		- Amount

*Accounts
	- Create Account
		- Create Checking Account
			- Customer Name
			- Customer ID
			- OverDraft Fee
			- Account Number
			- Starting Balance
		- Create Savings Account
			- Customer Name
			- Customer ID
			- Interest
			- Account Number
			- Starting Balance
		- Create Loan Account
			- Customer Name
			- Customer ID
			- Interest
			- Minimum Payment
			- Late fee
			- Account Number
			- Starting Balance	
	- Delete Account
		- Account Number
	- View Account  Details
		- Account Number
	- View All Accounts


* Bank
	- Employees
		- Add Employee
			- Employee Name
			- Employee ID
			- Pin
		- Remove Employee
			- Employee ID
		- View Employees
	- View Bank Details

*Logout

4. The GUI will run even after the user has logged out. To terminate the GUI simply close the application by closing the window. The GUI writes the data into a dat file that will retain user login information for the applications reinitialization. 

#Resetting Log in  
If the user forgets the employee ID and or pin, delete the “employee.dat” file found in the src folder to force the app to hard restart. 


#Contributers 
Matt Johnson  BankGUI.java / UI Design  
William Smith Account.java, Checking.java, Employee.java, Savings.java, Customer.java / UI Design 
Albert Park   loan.java, Customer.java
Kevin Garcia  Transactions.java, Customer.java readme.md