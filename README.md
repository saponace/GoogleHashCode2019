# GoogleHashCode2019 [![Build Status](https://travis-ci.org/saponace/GoogleHashCode2019.svg?branch=master)](https://travis-ci.org/saponace/GoogleHashCode2019)
![google hash code logo](./documentation/logo.png)


## Practice problem for the Google HashCode 2019.


* original assignment - [Task.pdf](./documentation/TaskDescription.pdf)
* [input data sets](./inputDataSets)

## Prerequisites

* Java 1.8
* maven 3

## Run
To build and run the application execute:

       mvn clean install
       mvn exec:java -Dexec.mainClass="com.poireau.hashcode.App"

## Submit task automation
Google provides an online mechanism to check the task results. It requires:
* archived source code
* at least one output file

To zip the source code execute :

    ./zipSourceCode.sh

