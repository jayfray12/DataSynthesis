# DataSynthesis Loading Seeded Data
The easiest thing we could have done is make this a complete SaaS based offering.
We are hopeful that a partner could leverage this platform and it will become a services  
offering down the road. However, we believe the best value for the platform and its
growth and expansion we wanted to provide data load scripts.

## MySQL
These can be found within MySQL/MySQL-DataLoad. The scripts for simplicity are hard coded.  
You will need to change the core directory to run the script because we hard coded
it to ensure that it would work. Here is it:
[Base-DataLoader-DataSynthesis-v4.sql](MySQL/DataLoad/Base-DataLoader-DataSynthesis-v4.sql)

Steps to Run The Scripts:
1. Start MySQL Command Line Client
2. use datasynthesis
3. source <MySQLLoadScript>.sql