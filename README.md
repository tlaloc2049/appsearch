appengine-skeleton
==================

This is a generated application from the appengine-skeleton archetype.

See the [Google App Engine standard environment documentation][ae-docs] for more
detailed instructions.

[ae-docs]: https://cloud.google.com/appengine/docs/java/


* [Java 8](http://www.oracle.com/technetwork/java/javase/downloads/index.html)
* [Maven](https://maven.apache.org/download.cgi) (at least 3.5)
* [Google Cloud SDK](https://cloud.google.com/sdk/) (aka gcloud)

## Setup

    gcloud init
    gcloud auth application-default login

## Maven
### Running locally

    mvn appengine:run

### Deploying

    mvn appengine:deploy

## Testing

    mvn verify

As you add / modify the source code (`src/main/java/...`) it's very useful to add
[unit testing](https://cloud.google.com/appengine/docs/java/tools/localunittesting)
to (`src/main/test/...`).  The following resources are quite useful:

* [Junit4](http://junit.org/junit4/)
* [Mockito](http://mockito.org/)
* [Truth](http://google.github.io/truth/)

## Updating to latest Artifacts

An easy way to keep your projects up to date is to use the maven [Versions plugin][versions-plugin].

    mvn versions:display-plugin-updates
    mvn versions:display-dependency-updates
    mvn versions:use-latest-versions

Note - Be careful when changing `javax.servlet` as App Engine Standard uses 3.1 for Java 8, and 2.5
for Java 7.

Our usual process is to test, update the versions, then test again before committing back.

[plugin]: http://www.mojohaus.org/versions-maven-plugin/

==============
DEV ENV SETUP
==============

- Install Intellij Community Edition:
https://www.jetbrains.com/idea/

- Install Google Cloud SDK:
https://cloud.google.com/sdk/downloads

- Install Maven:
http://maven.apache.org/install.html

- Download and install Java 8 JDK

Open Intellij and in the 'Preferences' menu look for 'Maven' configuration and set it to use the version you just downloaded.

- Checkout project from Git
- In the root directory compile the build with: mvn clean package
- Then run the project with: mvn appengine:run
- Import project in Intellij by selecting the pom.xml descriptor in the root directory
- If you want to debug, add a new Debug Configuration (Edit Configurations) as described in the next link:
  https://cloud.google.com/tools/intellij/docs/deploy-local#community
  To run the debug, first uncomment the jvmFlag in pom.xml (under appengine-maven-plugin)
  then run: mvn appengine:run
  then Run the Debug Configuration in Intellij
  (If you try to run maveb with the jvmFlag uncommented and the debugger off your requests won't load


More info:

Using Apache Maven in your project:
https://cloud.google.com/appengine/docs/standard/java/tools/using-maven

Setup Debug with Community Edition:
https://cloud.google.com/tools/intellij/docs/deploy-local#community

(Not required) Install Google Cloud Plugin for Intellij:
https://cloud.google.com/tools/intellij/docs/quickstart-IDEA

Spring info:
 https://docs.spring.io/spring/docs/5.0.1.RELEASE/spring-framework-reference/web.html#mvc-container-config
 https://docs.spring.io/spring/docs/5.0.1.RELEASE/spring-framework-reference/web.html#mvc-ann-responsebody
 https://www.boraji.com/spring-4-mvc-hello-world-example