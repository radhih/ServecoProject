# ServecoProject
The aim of the project is to develop a platform of vehicle’s services booking for people who need a conveyance to move in several circumstances such as taxis, ambulances, school bus, wedding cars...
##serveco :EJB project
##Webserveco :JSF web application project
##DesktopServceo: java application(swing)
##ServecoAndroid: android application


## How to run 
1. Create the datasource with the specific name mentioned in the persistence.xml file. please verify the server port number because i am using 8383 with an offset of 100.
2. Under the serveco directory run mvn clean install.
3. Navigate to the WebServeco directory and run mvn package. 
4. Deploy the war file to your application server WildFly 8.1.
