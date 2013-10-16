jersey2-jetty-example
=====================

This is an example of a Rest embedded server in a java application using Jersey 2, Jetty, and Jackson.
The 'rest-server' directory has the source code for the server.
The 'rest-test' directory has a project to test the Rest interface.

Compiling using Maven
---------------------
To compile the server using Maven type `mvn install` in the 'rest-server' directory.

To run the server type `java -jar target/rest-server-1.0.0.jar`.

To compile and run the test project type `mvn test` in the 'rest-test' directory (for the tests to succeed the server must be running).
