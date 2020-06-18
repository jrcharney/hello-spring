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
    * Thymeleaf (in Chapter 11, so don't add it yet)
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
 
 == Self reminders ==
 * Use ArrayLists not Arrays
 * JavaScript and CSS stuff can go in `src/main/resources/static`. You won't need it here, but it would be nice to use CSS anyway.
 
 == Hello (Again) Spring ==
 In chapter 11, we add the template engine [**Thymeleaf**](https://www.thymeleaf.org/) (pronounced "TIME LEAF").
 
 In the `src/build.gradle` go to the `dependencies` section. Below the line that says `implementation 'org.springframework.boot:spring-boot-starter-web'
`, copy and paste it on the next line but change the copy to `implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'` such that the secition look as follows.
 
 ```
dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-web'
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	testImplementation('org.springframework.boot:spring-boot-starter-test') {
		exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
	}
}
```

Save it and if the elephant-sync icon shows up, click on it. The video says Gradle should fetch packages automatically, but I've never experienced it.

We can now add templates to our `src/main/java/resources/templates` folder.

I may have jumped the gun. In my `HelloSpringController.java` file, I created a static function called `htmlDocument`, since Java doesn't have [HEREDOC](https://en.wikipedia.org/wiki/Here_document) features. So I used concatenated strings.

The tutors like the idea of using the `+` operator for concatenation, but I like using `String.join()` since I can set the delimiter to new line for block elements and use the `+` operator for inline stuff.

```java
public static String htmlDocument(String head, String body){
    // There's no HEREDOC in Java, so strings need to be used to concatenate stuff.
    // Using String.join makes things more flexible and tidy. The delimiter can be changed later
    // and things look neat and aligned.
    String html = String.join("\n",
            "<!doctype html>",
            "<html>",
            "<head>", head, "</head>",
            "<body>", body, "</body>",
            "</html>"
    );
    return html;
}
```

In the `resources/templates` folder, let's create a file called ~~`form.html`~~ `backbone.html` with `right-click > New > HTML file`.

Just about EVERY HTML file you will make will be HTML5. So ~~`form.html`~~ `backbone.html` will look like this.

> NOTE: I renamed my `backbone.html` because is more of the backbone. The actual form components will be in another file called `form.html`.

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

</body>
</html>
```

To use Thymeleaf with this template, we need to add an [**XML Namespace**](https://en.wikipedia.org/wiki/XML_namespace) to the opening HTML tag. An XML namespace is used to define a set of custom markup rules called a **schema** which is a lot like creating a custom version of HTML but with features that are not part of the W3C standard. These are primarily used in [Extensible Markup Language](https://en.wikipedia.org/wiki/XML) (XML) but can be added to W3C standard markup languages like SVG or HTML5. There's a couple of things called [Extensible Stylesheet Language](https://en.wikipedia.org/wiki/XSL) (XSL) and [XSL Transformation](https://en.wikipedia.org/wiki/XSLT) (XSLT) which allow XML files to look more like webpages rather than a skeleton of tags, but it's beyond the scope of this course.

All you need to know is you need to add that XML namespace to the HTML tag like so to use Thymeleaf in a template.

```html
<html lang="en" xmlns:th="https://www.thymeleaf.org/">
```

> Note: If IntelliJ asks you to remove it because it wasn't used (which we HAVEN'T used it yet) or asks you if you want to add some other XML stuff to it, don't. We're getting to the using part!

Because we are using an XML namespace, XML tagging rules apply. Thus, single tags like `meta`, `link`, `input`, `br`, and `hr` need to close with a forward slash before the closing angle brace (a.k.a. "greater than"). Do not do this with the `doctype` tag on line 1 though.

```html
<meta charset="UTF-8" />
```