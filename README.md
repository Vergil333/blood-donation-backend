# blood-donation-backend

Backend of Blood Donation Android App.<br>
Rest API<br>
Database of donors

## Create database
`docker run --name blood_donation -e POSTGRES_USER=demoUSER -e POSTGRES_DB=blood_donation -e POSTGRES_PASSWORD=demoPASSWORD -p 5432:5432 -d postgres`

## Create connection to local DB
In your IDE (or system) add these environment variables:<br>
- JDBC_DATABASE_USERNAME admin<br>
- JDBC_DATABASE_PASSWORD admin<br>
- JDBC_DATABASE_URL jdbc:postgresql://localhost:5432/blood_donation
