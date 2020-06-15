package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class HelloSpringController {
    /*
    // Though about using this to make as JSON-like setup.
    // Too much work. Overengineering. Also something about how using this hack is bad.
    public HashMap<String,HashMap<String,String>> greetings = new HashMap<>(){
        {
            put("en", new HashMap<>() {
                {
                    put("language", "English");
                    put("greeting", "Hello");
                }
            });
            put("es", new HashMap<>() {
                {
                    put("language", "Español");
                    put("greeting", "Hola");
                }
            });
            put("fr", new HashMap<>() {
                {
                    put("language", "Français");
                    put("greeting", "Bonjour");
                }
            });
        }
    };
    */

    // Do it DOM style.
    /*
    public static String inlineTag(String element,String content){
        return "<"+element+">"+content+"</"+content+">";
    }
    public static String blockTag(String element, String content){
        return String.join("\n","<"+element+">",content,"</"+content+">");
    }
     */

    public static String htmlDocument(String head, String body){
        // There's no HEREDOC in Java, so strings need to be used to concatenate stuff.
        // Using String.join makes things more flexible and tidy. The delimiter can be changed later
        // and things look neat and aligned.
        String html = String.join("\n",
                "<html>",
                "<head>", head, "</head>",
                "<body>", body, "</body>",
                "</html>"
        );
        return html;
    }

    public static String greetingForm(String method) {
        // There's no HEREDOC in Java, so strings need to be used to concatenate stuff.
        // Using String.join makes things more flexible and tidy. The delimiter can be changed later
        // and things look neat and aligned.
        // TODO: Align labels and input/select elements.
        // TODO: Replace Select menu with radio buttons for ARIA.
        String form = String.join("\n",
                "<form method=\"" + method + "\" action=\"/hello\">",
                    "<label>Name: </label>",
                    "<input type=\"text\" name=\"coder\" value=\"\">",
                    "<br>",
                    // TODO: See if I can hashmap select menu options later.
                    // TODO: Use Javascript later to change the label and submit value to the same language,
                    //          like how when you fiddle around with a TV menu that has different languages!
                    "<label>Language: </label>",
                    "<select name=\"language\">",
                        "<option value=\"en\">English</option>",
                        "<option value=\"es\">Español</option>",
                        "<option value=\"fr\">Français</option>",
                    "</select>",
                    "<br>",
                    "<input type=\"submit\" value=\"Greet Me!\">",
                "</form>"
        );
        return form;
    }

    // If you use GetMapping like this, you can simply access it on the root address, like an index.html page!
    // Only one *Mapping per route apparently. (I had to make another function.)
    @GetMapping
    @ResponseBody
    public String home(){
        //return "Hello, Spring!";

        // Though about using a variable here to change the form method.
        String form_method = "get"; // "post"
        // If we change the form method to "POST", the query string "?coder=string" part won't show.
        // Don't forget to use + to concatenate rather than comma in String.join!

        //return greetingForm("get");
        // There's no HEREDOC in Java, so strings need to be used to concatenate stuff.
        // Using String.join makes things more flexible and tidy. The delimiter can be changed later
        // and things look neat and aligned.
        String content = String.join("\n",
                "<h1>Hello, Spring!</h1>",
                "<hr>",
                greetingForm(form_method)
        );
        return htmlDocument("",content);
    }

    public static String createMessage(String name, String lang){
        String greeting;
        // TODO: HashMap
        if(lang.equals("en")){
            greeting = "Hello";
        }
        else if(lang.equals("es")){
            greeting = "Hola";
        }
        else if(lang.equals("fr")){
            greeting = "Bonjour";
        }
        else {
            greeting ="Hi";
        }
        return greeting + ", " + name + ".";
    }

    // If we are going to use GET or POST, we may as well use request mapping
    @RequestMapping(value="hello", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@RequestParam String coder, @RequestParam String language) {
        //return "Hello, " + coder + "!";
        return htmlDocument("","<h1>" + createMessage(coder,language) + "</h1>");
    }


    /*
    // If you use GetMapping like this, you will need to add "/hello"
    @GetMapping("hello")
    @ResponseBody
    public String hello(){
        return "Hello from GetMapping!";
    }
     */

    /*
    // Responds to get requests at /hello?coder=LaunchCoder
    @GetMapping("hello")
    @ResponseBody
    public String hello(@RequestParam String coder) {
        return "Hello, " + coder + "!";
    }

     */

    /*
    // Responds to get requests at /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name) {
        // This method used to be called "helloAgain" but I renamed it to "hello" to show we can OVERLOAD!
        return "Hello, " + name + "!";
    }

     */


    /*
    // Respond to a POST request
    @PostMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye from PostMapping!";
    }

     */

    /*
    // Respond to multiple request methods
    @RequestMapping(value="hellogoodbye", method = {RequestMethod.GET, RequestMethod.POST})
    public String hellogoodbye() {
        return "Hello and Goodbye from RequestMapping";
    }

     */
}
