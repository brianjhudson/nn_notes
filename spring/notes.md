# Backend REST server with Spring Boot Web

I'm going to summarize the parts of our application, along with references to each project we used to work through it.

## Setup
Through IntelliJ, you can set up your Spring Boot REST app by installing the necessary packages. To get going, we only need one:
* Spring Boot Web Starter

However, eventually, we will need more than that. Here is our complete list:
* Spring Boot Web Server
* Spring Boot Dev Tools
* Spring Boot JDBC Data
* PostgreSQL Driver

We could also add security if we wanted to lock down our application. For now, we will avoid that for the sake of simplicity. 

These packages will end up in the `pom.xml` file, and Maven, our package manager will use the xml to install them and run them alonside our code.

## Project Structure
Spring Boot creates the following structure for our project:

```
src
|-- main
|   |-- java
|       |-- com.example.backend_app
|           |-- BackendApp.java
|       |-- resources
|           |-- application.properties
pom.xml
```

I've left out a few of the details, but thes are the main files. 

### The POM file
`pom.xml` is the xml file that defines our project and its dependencies. Maven will use this file to install the libraries we need to run our code. 

### Properties
`application.properties` is where we store environment-like variables that will allow us to connect to our database.

### Entry Point
`BackendApp.java` is the entry point for our application. Here Spring Boot auto-generates the code that runs our application and sets up a listener at port 8080, using the Apached Tomcat web server. Alternatively, you can select a different port by setting that property in `application.properties`.

Here is a simple entry point file:

```
package com.example.restanddb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestanddbApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestanddbApplication.class, args);
    }

}
```

## Controller
Our backend is not very useful without a controller. The controller will define our REST endpoints and provide handlers to serve data to the clients of these endpoints.

Here is a simple, sample controller file:

```
package com.example.restanddb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DemoController {
    @GetMapping("/")
    public String getMessage() {
        return "Hello";
    }
}
```


Here is an example of a project with a simple Hello World controller:

[https://github.com/brianjhudson/spring_rest_controller_demo](Spring Rest Controller Demo)

And here is another example of a Spring app with only a simple controller. The only difference is that this app also contains the JDBC data library and connects to a database. 

[https://github.com/brianjhudson/spring_jdbc_data_demo](Spring Rest Controller with JDBC Demo)

## Model
To serve the right kind of data to our endpoint, though, we need to define a model. This model will define how other developers and our end users will see the entities they are requesting. 

We will import this model in the following places:
* Controllers -- to define the return value of our endpoints
* Interfaces -- to define the return value of DAO classes
* JDBC DAO Classes -- to take the database data and create new instances of our model so that the data conforms to our app's expectations.

Here is a sample model file:

```
package com.example.backenddemo.model;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    User () {
    }
    User (int i, String fn, String ln) {
        id = i;
        firstName = fn;
        lastName = ln;
    }

    public int getId() {
        return id;
    }

    public void setId(int i) {
        id = i;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String fn) {
        firstName = fn;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String ln) {
        lastName = ln;
    }

}
```

And here is the app that contains it. This app only has a model (no controller):

[https://github.com/brianjhudson/spring_model_demo](Spring Sample Model File)

## DAO
*Note: We are following the same pattern you learned at boot camp here (as best as I can tell from your projects). There are other methods, notably the repository method for using DAO.*

### The Interface
We first create an interface for the Data Access Object. Here we define what methods we call to get or update data from the database. We import the model so that we can specify the return types that conform to our data model.

Here is our recipe DAO interface:

```
package com.example.backend_database_connector.dao;

import com.example.backend_database_connector.model.Recipe;
import java.util.List;

public interface RecipeDao {
    public List<Recipe> getAllRecipes();
}
```

So we haven't written any logic here. We're only using this interface to tell consumers (the controller, primarily) how to access the data it wants.

Next we have to implement this interface in a concrete class. 

This is what you guys were calling the JdbcEntityDao. I'll stick to that naming convention. I think, though, that in Java, it would make more sense to call the interface IEntityDao and the concrete class EntityDao. But that's just me.

### The Concrete Implementation
In this file, we'll implement the interface by actually defining the methods we'll use to access data. 

Furthermore, we'll use Spring's @Component annotation to allow Spring to instantiate this class at startup and inject the data source. 

Here's what we have so far:

```
package com.example.backend_database_connector.dao;
/*
* This will be the class that connects to our database
* For now, we are just using it as a utility to shift the logic from the controller
* There is one other wrinkle--in Spring, we don't need to instantiate it
* First, we'll do it the plain Java way
* */

import com.example.backend_database_connector.dao.RecipeDao;
import com.example.backend_database_connector.model.Recipe;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.ArrayList;

@Component
public class JdbcRecipeDao implements RecipeDao {

    private final JdbcTemplate db;

    public JdbcRecipeDao(JdbcTemplate jTemplate) {
        db = jTemplate;
    }

    public List<Recipe> getAllRecipes() {
        // Dummy logic to replace database logic
//        Recipe recipe = new Recipe();
//        Recipe recipe2 = new Recipe();
//        Recipe recipe3 = new Recipe();
//        ArrayList<Recipe> recipes = new ArrayList<Recipe>();
//        recipes.add(recipe);
//        recipes.add(recipe2);
//        recipes.add(recipe3);
        // When I connect to the database, I will convert SQL rows into Recipes
        // and put them in the list
        ArrayList<Recipe> recipes = new ArrayList<Recipe>();
        String sqlStatement = "SELECT * FROM recipes;";
        SqlRowSet results = db.queryForRowSet(sqlStatement);

        // Loop through each row using .next()
        while(results.next()) {
            // For each row, create a new Recipe, using our model
            // Translate the SQL result into properties in our model
            Recipe recipe = new Recipe();
            int id = results.getInt("id");
            recipe.setRecipeId(id);
            String recipeName = results.getString("recipe_name");
            recipe.setRecipeName(recipeName);

            recipes.add(recipe);
        }

        return recipes;
    }
}
```

So far we are doing a few things:

#### Defining the class as an implementation of the interface
This forces us to include all the methods we promised to our consumers.

#### Annotating it with @Component 
We use the Spring annotation so the class can be instantiated on startup with the data source.

#### Setting up a property to capture the data source
We create an instance property called `db`, which is of type JDBCTemplate. This property will allow us capture the data source and allow us to run our query, insert, update, and delete methods in SQL.

#### Capturing the data source in the constructor
In the constructor, we accept the data source, of type JDBC template, and set it on our class property.

#### Using our data source to getAllRecipes
* In our method, we create an ArrayList to hold our database results.
* Then we write our SQL statement as a string.
* Then we call the `.queryForRowSet()` method on our `db` and pass it our string SQL statement.
* Then we iterate through the results using the `.next()` method.
* Finally, we convert each row of data to our model by creating a new instance of the model class, retrieving the column data on the row, and setting that data on the model instance's properties.

Here's our running demo app:

[https://github.com/brianjhudson/spring_backend_demo](Spring Boot REST server)

