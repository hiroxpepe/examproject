==============================
    
    examproject

    by hiroxpepe
       hiroxpepe@gmail.com
    
==============================

-----------------------------------------------------------
* What's this?

This project shows how to work with
  Spring MVC
  Spring Security
  Spring Data JPA
  Apache Tiles & JSTL
  JSR-303 bean validation
  i18n internationalized
and how to configure.

The example is simply CRUD operations on Spring MVC.

-----------------------------------------------------------
* How to run on the local?

You will need to get Apache Maven.
    http://maven.apache.org/

You will need to compile this example first.
  > cd {path to this README.txt directory!}
  > mvn compile
  > mvn install

Move to launcher project directory.
  > cd exmp-webapp

To run the .war application by jetty plugin.
  > mvn jetty:run

You can access to http://localhost:8080/ on your web browser.

To stop the application hit ctrl + c

-----------------------------------------------------------
* How to run on the Heroku?

You will need to get Git, of course.
    http://git-scm.com/

You will need to create a application for Heroku,
 and must need to get the heroku tools, used RubyGems.
    http://www.heroku.com/

To push the application on Heroku.
  > cd {path to this README.txt directory!}
  > heroku login
  > git push git@heroku.com:your-app-name.git

-----------------------------------------------------------

This project is hosted on GitHub.
  https://github.com/hiroxpepe/examproject

This project sample is running on Heroku.
  http://examproject.herokuapp.com/

-----------------------------------------------------------
enjoy! Spring :)
