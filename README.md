# team-formation-ht26
Built for Colorado State University Hackathon operations.
Team formation script for DevNet 2026 Spring Hackathon 

# Requirements
Java 17+ Installed
Maven wrapper is within the program, no install needed.

# How to Run

Before running, please move your input file to the database/files folder.
Alternativeley, your input could be the filepath to your desired file.

Windows:

.\mvnw.cmd exec:java "-Dexec.args=database/files/test.csv"

Linux/MacOS:

chmod +x mvnw
./mvnw exec:java "-Dexec.args=database/files/test.csv"


# Data Context

## Response Weight Values
Please note, when getting the score value from CSV entries we compare the beginning of each possible answer as these are multiple choice questions with set responses.

What is your level of familiarity with machine learning (ML)? 

Advanced : 3 
Intermediate : 2 
Beginner : 1 
Not experienced at all : 0 

What is the highest-level computer science course you have completed? 

500+ level course: 5 
400 level course: 4  
300 level course: 3 
200 level course: 2 
100 level course: 1 
None: 0 

Do you have experience working with geospatial data or GIS Applications? 
Yes: 3 No: 0 

Do you have experience working with Amazon Web Services (i.e. ECS, S3 Buckets) 
Yes : 2  No : 0 


# Future Plans
Add averages and standard deviations to truly ensure balanced teams
Add a more developed README
Add student lookup (maps)
Add UI
