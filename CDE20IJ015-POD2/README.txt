--------------------------------------------------------AUTHENTICATION MICROSERVICE-------------------------------------------------------------------

1. Employee Login 
POST :

http://rbspod2authenticationms-env.eba-kwxmp33m.ca-central-1.elasticbeanstalk.com/auth-ms/login

{
    "userid": "EMPLOYEE101",
    "username": "emp",
    "password": "emp",
    "role": "EMPLOYEE"
}


Then copy the authToken value and now open a new tab -> open Authorization-> Choose Bearer Token from dropdown list and paste the Copied authToken value.
 
2.Validate Token

GET:

http://rbspod2authenticationms-env.eba-kwxmp33m.ca-central-1.elasticbeanstalk.com/auth-ms/validateToken



--------------------------------------------------------CUSTOMER MICROSERVICE-------------------------------------------------------------------------

2. Employee creates Customer 1

POST: 

http://rbspod2customerms-env.eba-726afjqj.ca-central-1.elasticbeanstalk.com/customer/createCustomer

{
    "userid" : "CUSTOMER528",
    "username" : "Jyothirlatha",
    "password" : "jyo",
    "dateOfBirth" : "1999-05-08",
    "pan" : "ABC123456",
    "address" : "Jaggayyapet",
    "accounts" : [{
        "accountId" : 9874562521,
        "customerId" : "CUSTOMER528",
        "currentBalance" : 75000,
        "accountType" : "Savings",
        "ownerName" : "Jyothirlatha",
        "transactions":null

    }]
}


3. Employee creates Customer 2

POST:
 
http://rbspod2customerms-env.eba-726afjqj.ca-central-1.elasticbeanstalk.com/customer/createCustomer

{
    "userid" : "CUSTOMER529",
    "username" : "Sriya",
    "password" : "Sriya",
    "dateOfBirth" : "1999-03-11",
    "pan" : "MJG6879",
    "address" : "Vijayawada",
    "accounts" : [{
        "accountId" : 3647891025,
        "customerId" : "CUSTOMER529",
        "currentBalance" : 90000,
        "accountType" : "Savings",
        "ownerName" : "Sriya",
        "transactions":null

    }]
}


4. Employee creates Customer 3

POST:
 
http://rbspod2customerms-env.eba-726afjqj.ca-central-1.elasticbeanstalk.com/customer/createCustomer

{
    "userid" : "CUSTOMER530",
    "username" : "Alekhya",
    "password" : "jarvis",
    "dateOfBirth" : "1999-03-11",
    "pan" : "APB3305N",
    "address" : "Hyderabad",
    "accounts" : [{
        "accountId" : 364789381,
        "customerId" : "CUSTOMER530",
        "currentBalance" : 80000,
        "accountType" : "Savings",
        "ownerName" : "Alekhya",
        "transactions":null

    }]
}

4. Save Customer Details

POST:

http://rbspod2customerms-env.eba-726afjqj.ca-central-1.elasticbeanstalk.com/customer/saveCustomer


{
    "userid" : "CUSTOMER530",
    "username" : "Alekhya",
    "password" : "jarvis",
    "dateOfBirth" : "1999-03-11",
    "pan" : "APB3305N",
    "address" : "Hyderabad",
    "accounts" : [{
        "accountId" : 364789381,
        "customerId" : "CUSTOMER530",
        "currentBalance" : 80000,
        "accountType" : "Savings",
        "ownerName" : "Alekhya",
        "transactions":null

    }]
}



5. Get Details of CUSTOMER105

GET:


http://rbspod2customerms-env.eba-726afjqj.ca-central-1.elasticbeanstalk.com/customer/getCustomerDetails/CUSTOMER528


6. Get Details of CUSTOMER106

GET:	

http://rbspod2customerms-env.eba-726afjqj.ca-central-1.elasticbeanstalk.com/customer/getCustomerDetails/CUSTOMER529

7. Update Details of Customer:

PUT

http://rbspod2customerms-env.eba-726afjqj.ca-central-1.elasticbeanstalk.com/customer/updateCustomer


{
    "userid" : "CUSTOMER530",
    "username" : "Kalyan",
    "password" : "jarvis",
    "dateOfBirth" : "1999-03-11",
    "pan" : "APB3305N",
    "address" : "Hyderabad",
    "accounts" : [{
        "accountId" : 364789381,
        "customerId" : "CUSTOMER530",
        "currentBalance" : 80000,
        "accountType" : "Savings",
        "ownerName" : "Kalyan",
        "transactions":null

    }]
}


8. Delete Customer530

DELETE:	

http://rbspod2customerms-env.eba-726afjqj.ca-central-1.elasticbeanstalk.com/customer/deleteCustomer/CUSTOMER530



--------------------------------------------------------ACCOUNT  MICROSERVICE-------------------------------------------------------------------------


9. Getting Account Details

GET:	http://rbspod2accountsms-env.eba-gtempyxj.ca-central-1.elasticbeanstalk.com/account-ms/getAccount/9874562521



10. Create Account based on Customer ID

POST:	http://rbspod2accountsms-env.eba-gtempyxj.ca-central-1.elasticbeanstalk.com/account-ms/createAccount/CUSTOMER528

{
    "accountId": 98,
    "customerId": "CUSTOMER528",
    "currentBalance": 75.0,
    "accountType": "Savings",
    "ownerName": "Jyothirlatha",
    "transactions": null
}


11. Getting Account Based on Customer ID

GET:	http://rbspod2accountsms-env.eba-gtempyxj.ca-central-1.elasticbeanstalk.com/account-ms/getAccounts/CUSTOMER528




12. Make Deposit  (after making Deposit check with step 5/6 to get transactions with respective customer ID)

POST:
http://rbspod2accountsms-env.eba-gtempyxj.ca-central-1.elasticbeanstalk.com/account-ms/deposit

{
    "accountId" : 9874562521,
    "amount":2000
}


13. Make wihdraw  (after making wihdraws check with step 5/6 to get transactions with respective customer ID)

POST:

http://rbspod2accountsms-env.eba-gtempyxj.ca-central-1.elasticbeanstalk.com/account-ms/withdraw

{
    "accountId" : 9874562521,
    "amount":3000
}




15. Make transfer   (after making Transfer check with step 5&6 to get transactions with respective customer ID)
POST: 

 http://rbspod2accountsms-env.eba-gtempyxj.ca-central-1.elasticbeanstalk.com/account-ms/transfer

{
    "sourceAccount" : {
        "accountId" : 9874562521,
        "amount"    : 500
    } ,
    "targetAccount" :{
        "accountId" : 3647891025,
        "amount"    : 500
    },
    "amount" : 500,
    "reference" : "transfer"
}



16. Checking Balance of a Account:

GET:	http://rbspod2accountsms-env.eba-gtempyxj.ca-central-1.elasticbeanstalk.com/account-ms/checkBalance/9874562521



17. Find operation

GET:	http://rbspod2accountsms-env.eba-gtempyxj.ca-central-1.elasticbeanstalk.com/account-ms/find



--------------------------------------------------------TRANSACTION  MICROSERVICE-------------------------------------------------------------------------

18. Getting All Transactions List based on Account ID:


GET:	http://rbspod2transactionms-env.eba-a9y2mm3f.ca-central-1.elasticbeanstalk.com/transaction-ms/getAllTransByAccId/9874562521




--------------------------------------------------------RULES  MICROSERVICE-------------------------------------------------------------------------



19. Evaluating Minimum Balances in Customers Accounts:

POST:	http://rbspod2rulesms-env.eba-aimzukmp.ca-central-1.elasticbeanstalk.com/rules/evaluateMinBal

        {
            "accountId": 98,
            "customerId": "CUSTOMER528",
            "currentBalance": 75,
            "accountType": "Savings",
            "ownerName": "Jyothirlatha"
        }






20. Applying Service Charges on who are not maintaining Minimum Balances in their accounts.

POST:	http://rbspod2rulesms-env.eba-aimzukmp.ca-central-1.elasticbeanstalk.com/rules/serviceCharges
 

      {
            "accountId": 98,
            "customerId": "CUSTOMER528",
            "currentBalance": 75,
            "accountType": "Savings",
            "ownerName": "Jyothirlatha"
        }




