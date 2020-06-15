# Hello Spring

This is basically your typical "Hello World" for Spring Boot.

This is designed with the following considerations:
1. You are using Java 14.
2. You are using Gradle
3. You are using Spring Web and Spring Boot DevTools as dependencies.

---
## Spring Project setup steps

1. Go to to [start.spring.io](start.spring.io)
2. **Project:** Gradle Project
3. **Language:** Java
4. **Spring Boot:** 2.2.x== 
    * most recent 2.2 (2.2.8), non-SNAPSHOT release
5. **Project Metadata/Group:** `org.launchcode`
    * or whatever package name you want. The convention is `topleveldomain.domainname`
6. **Project Metadata/Artifact:** `hello-spring`
    * This is the title of the project
7. **Project Metadata/Options/Java:** 14
8. **Dependencies**
    * Spring Web
    * Spring Boot DevTools
9. **Click Generate** to create a `.zip` file. Put it in your LC101 folder.
10. **Extract the `.zip` file.** This should have the extracted folder.
    > You'll want to open the `.zip` file THEN drag the folder in it out of it, otherwise you'll have that folder inside of another folder.
11. Start IntelliJ IDEA.
12. Select *Import Project* and go to the extracted folder.
13. ~~Select Import Project from external model and pick Gradle. Select all other defaults as you create the project.~~ (This step isn't available anymore.)
    * Even though this option might not be available anymore, there should be a Gradle tab on the right side of the IDE.
14. If you encounter "Invalid Gradle settings" open the settings. Change the `Gradle JVM` to `14 java version "14.0.1"`
15. You might see a little elephant icon with a refresh symbol asking if you want to update your settings. Do that.
    * It should download Gradle (possibly https://services.gradle.org/distributions/gradle-6.4.1-bin.zip) and start the Gradle Daemon.
    * It might also run the task `:prepareKotlinBuildScriptModel` even though this is a Java Project.
    Once it is done, they build sync should be successful.
 16. Go to `src > main > java > org.launchcode.hellospring > HelloSpringApplication.java`
 