# DataSynthesis Loading Seeded Data
The easiest thing we could have done is make this a complete SaaS based offering.
We are cognizant of the potential for partners to build out  
potential services offering down the road. We also want to ensure that organizations can have control  
of the data.

## MySQL
These can be found within MySQL/DataSeeding. The scripts for simplicity are  
quasi hard coded. We have tested them on a few OS'es. However, with OS and MySQL security  
enhancements always keep in mind there might be changes needed.
The intent of the Data Seeeding is to support both a very large data tier DataSeeding-Full: initially that can grow
(but starts in the billions). Also, a much smaller footprint for containers and very small testing DataSeeding-Small.
<br/>
As with everything we do we keep the complete history so everyone can see the work that has been done.

[Base-DataLoader-DataSynthesis-<LatestVersion>.sql](MySQL/DataSeeding/DataSynthesis-Load-Full/Base-DataLoader-DataSynthesis-v9.sql)

Steps to Run The Scripts:
1. Start MySQL Command Line Client
2. Establish a connect to mysql typically with something like mysql -u root -p
3. source <MySQLLoadScript>.sql

Happy coding!!!
