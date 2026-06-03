## 🌟 Highlights

- Parses questions via CSV file
- Takes questions and with custom weights sorts players/students into equal teams
- Outputs a csv file with the team number and player/student array


## ℹ️ Overview

Built for Colorado State University Hackathon operations.\
Team formation script for DevNet 2026 Spring Hackathon.

Parses through the csv (in our case one taken from Handshake questionare), takes in player/student information as well as answers to custom questions with custom weights and assigns each participant with a set of points. Then the participants get put into teams, prioritizing four members, based on a "team leader" system. Then the output is a list of numbered teams along with the participants in each team.


### ✍️ Authors (name - role - github)

Alan De Lira - Head developer - YL626\
Kacper Mazur - Supporting developer - kacperm37


## 🚀 Usage
Before running, please move your input file to the database/files folder.\
Alternatively, your input could be the filepath to your desired file.

Windows:\
.\mvnw.cmd exec:java "-Dexec.args=database/files/test.csv"

Linux/MacOS:\
chmod +x mvnw\
./mvnw exec:java "-Dexec.args=database/files/test.csv"


## 🏋️‍♀️ Response Weight Values
These are the answer weights to the 
Please note, when getting the score value from CSV entries we compare the beginning of each possible answer as these are multiple choice questions with set responses.

What is your level of familiarity with machine learning (ML)? 

Advanced : 3\
Intermediate : 2\
Beginner : 1\
Not experienced at all : 0

What is the highest-level computer science course you have completed? 

500+ level course: 5\
400 level course: 4\
300 level course: 3\
200 level course: 2\
100 level course: 1\
None: 0 

Do you have experience working with geospatial data or GIS Applications?\
Yes: 3 No: 0 

Do you have experience working with Amazon Web Services (i.e. ECS, S3 Buckets)\
Yes : 2  No : 0 


## ⬇️ Installation
This entire thing is built in java, and all other needed libraries and dependencies are already installed.

Java 17+ Installed


## 📡 Future Plans
Add tests (internal)\
Add averages and standard deviations to truly ensure balanced teams\
Add student lookup (maps)\
Add UI\

This README format wouldn't be possible without Bane Sullivan and Santago Soler's [README guide](https://github.com/banesullivan/README).
