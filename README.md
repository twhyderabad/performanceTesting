# gatling-gradle-demo
contains a demo performance test on gatling using gradle

to run on OSX, type following command

$./gradlew gatlingRun

# Prerequisites - 

a. Java 8 JDK

If you have java, run java -version to check which version you are using. 

If you don't have java, [here](https://www3.ntu.edu.sg/home/ehchua/programming/howto/JDK_Howto.html) is the place to look for JDK installation.

b. gradle 3.1 or above

You may find [here](https://gradle.org/install/#manually) the steps to install gradle.

c. Scala SDK

Install Scala binaries as mentioned [here](https://www.journaldev.com/7456/download-install-scala-linux-unix-windows)

d. Intellij Scala Plugin

If you want to use Intellij as the IDE, install [Intellij](https://www.jetbrains.com/idea/download/) and [Intellij Scala Plugin](http://nanxiao.me/en/getting-started-with-scala-in-intellij-idea-14-1/)

# Steps to run the simulation

1. Clone the repository to your machine.

2. Open the project in Intellij

3. Verify the Scala SDK in Platform Settings. (File -> Project Structure -> Platform Settings -> Global Libraries)

4. Run the simulation in CLI using following command

osx/ Linux - ./gradlew gatlingRun

windows - ./gradlew.bat gatlingRun

to run a single simulation ./gradlew gatlingRun-<packagename.simulationname>
eg: ./gradlew gatlingRun-simulation.LoginSimulation

It runs the simulation(s) present in  *src/gatling/scala/simulation*. The simulation result is available in *build/reports/gatling/{simulation-number}/index.html*


**Note** - This test is written on OSX. While I have tried to make it os-agnostic, please log an issue/ raise a pull request if you find any os dependency.
