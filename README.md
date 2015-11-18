# duplicatefinder
Java command line program to find duplicate siren numbers in a text file.

## How to run the program
Prerequisite: Having java jre (version 1.8 or higher) installed

Open a shell in the folder containing duplicates.jar and type the following :

```
java -jar duplicates.jar "path/to/file.txt"

```

The program can be called with a parameter: The path to a file containing siren numbers.
For example:
java -jar duplicates.jar /usr/sirens.txt

## Compilation on GNU/Linux
Compiling the sources requires having java jdk 1.8 and maven 3.3

### Java
install java jdk version 1.8:

```
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt-get update 
sudo apt-get install openjdk-8-jdk
```

Check that the installation was correct by typing "java -version" or alternatively "java --version"

You should get something similar to this

```
openjdk version "1.8.0_45-internal"
OpenJDK Runtime Environment (build 1.8.0_45-internal-b14)
OpenJDK Server VM (build 25.45-b02, mixed mode)
```

### JAVA_HOME
Define the JAVA_HOME environment variable and make it point to the jdk installation folder.
Check that the value was correctly set
```
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-i386/
echo $JAVA_HOME
/usr/lib/jvm/java-8-openjdk-i386
```

### Maven
-install Apache Maven 3.3:
Download maven 3.3 from the following page https://maven.apache.org/download.cgi
Extract it in the directory of your choice
Add the bin directory of the created directory apache-maven-3.3.3 to the PATH environment variable
```
export PATH=/home/juancho/Desktop/apache-maven-3.3.3/bin:$PATH
```

Confirm with "mvn -v" in a new shell. The result should look similar to this:

Apache Maven 3.3.3 (7994120775791599e205a5524ec3e0dfe41d4a06; 2015-04-22T13:57:37+02:00)
Java version: 1.8.0_45-internal, vendor: Oracle Corporation
Java home: /usr/lib/jvm/java-8-openjdk-i386/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "linux", version: "3.19.0-25-generic", arch: "i386", family: "unix"


### Building the project
Open a shell in the root of the project (duplicatefinder-master)
```
mvn package
```
this will compile the sources and generate a .jar file under /target that can be executed as described before.




