/*
VERY IMPORTANT INFORMATION FOR GROUP
DO NOT DELETE THIS INFORMATION
*/

1: You need to create a database on your system with the name as [ytdmsdb]
2: Create a [testtable] table in the [ytdmsdb] database
2.1 :  Create [id-int(5)] and [name-varchar(20)] columns. Make id as PK, autoincrement. 
3: Navigate to tomcat server > context.xml file and write the below configuration just before the closing </context> tag.

              <Resource auth="Container"
              driverClassName="com.mysql.jdbc.Driver" maxTotal="10" maxIdle="2"
              maxWaitMillis="1000" name="jdbc/ytdmsdb" password="root"
              type="javax.sql.DataSource" url="jdbc:mysql://localhost/ytdmsdb"
              username="root" />

You may find some difficulty while setting up. 
Follow the provided information. 
