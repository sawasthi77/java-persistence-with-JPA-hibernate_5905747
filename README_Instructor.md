# Codespaces template README for instructors

Template: template-codespaces-java-mariadb

This file contains instructions for instructors using repos built from this template. The template includes the MariaDB database engine, SQLTools extension, Maven, with the MySQL/J driver added as a Maven dependency. There are also SQL and Java files in the repo that are intended for testing, but you can adapt these files for your course as needed.

When you create a codespace from a repo built from this template, the first launch will take a few minutes while extensions are installed and a database connection is created in the SQLTools extension. When the sidebar displays a cylinder icon at the bottom for SQLTools, the codespace is ready to use.

The learner is responsible for creating the initial database. Here's how it's done:

* Open the file `mariadb-setup.sql`.
* Click the *Run on active connection* link that appears at the top of the file. You won't see any feedback, but if the file runs without errors you're ready for the next step.
* Open the file `mariadb-test.sql`.
* Click the *Run on active connection* link at the top of the file. You should see query results showing 3 records with the values *one*, *two* and *three*.

Next, test the Java connection.

* Open the file `Main.java` from the `src` folder.
* Click the *Run and Debug* icon in VS Code's left toolbar.
* Click the *Run and Debug* button.

The first time you run the Java code, it'll take some time to build and run, but subsequent run times should be much faster.

> Please delete this README file from the repo before publishing the course!