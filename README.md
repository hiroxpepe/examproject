# examproject (c) by examproject

***
### What's this?
This project shows how to work with  
  * [Spring MVC](http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/mvc.html)  
  * [Spring Security](http://static.springsource.org/spring-security/site/docs/3.1.x/reference/springsecurity.html)  
  * [Spring Data JPA](http://www.springsource.org/spring-data/jpa)  
  * [Apache Tiles](http://tiles.apache.org/) and [JSTL](http://docs.oracle.com/javaee/5/tutorial/doc/bnakc.html)  
  * JSR-303 bean validation  
  * i18n internationalized  
and how to configure.

The example is shown simple crud operations on spring mvc.

***
### How to run at the local?
You will need to get [Apache Maven](http://maven.apache.org/).

You will need to build this example at your command line.

    > cd { path to this README.md directory. }
    > mvn compile
    > mvn install

Move to launcher project directory.

    > cd exmp-webapp

To run the .war application by jetty plugin.

    > mvn jetty:run

You can access to http://localhost:8080/ on your web browser.  
To stop the application hit ctrl + c

***
### How to run on the Heroku?
You will need to get [Git](http://git-scm.com/), of course.  
You will need to create a application for [Heroku](http://www.heroku.com/), and must need to get the heroku tools, used [RubyGems](http://rubygems.org/).  

To push the application for Heroku at your command line.

    > cd { path to this README.md directory. }
    > heroku login
    > git push git@heroku.com:your-app-name.git

***
### Hosted on GitHub.
[hiroxpepe/examproject](https://github.com/hiroxpepe/examproject)

***
### Running on Heroku.
http://examproject.herokuapp.com/

***
### Author
[hiroxpepe](mailto:hiroxpepe@gmail.com)

***
### License
The examproject is released under version 2.0 of the
[Apache License](http://www.apache.org/licenses/LICENSE-2.0).
