1. List rooms from the service: 

```
writer.write("<div>Let's list the rooms</div>");
writer.write("<ul>");
rooms.stream()
        .forEach(r->
                writer.write("<li>"+r.getName()+"</li>")
);
writer.write("</ul>");
```


2. Configure `SpringTemplateEngine` using thymeleaf resource template resolver: 

```
private SpringResourceTemplateResolver templateResolver() {
    templateResolver.setApplicationContext(applicationContext);
    templateResolver.setCacheable(false);
    templateResolver.setPrefix("classpath:/templates/");
    templateResolver.setSuffix(".html");
    templateResolver.setTemplateMode(TemplateMode.HTML);
    templateResolver.setCharacterEncoding("UTF-8");
    return templateResolver;
}
```

3. Create `ThymeleafBasicServlet.java` using WebContext


4. Create the `thymeleaf-index.html`

```
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Thymeleaf Servlet</title>
    <meta charset="utf-8" />
</head>
<body>
<h1>Hi <th:block th:text="${recipient}"></th:block></h1>
</body>
</html>
```



5. Show the rooms using thymeleaf 

```
<th:block th:each="room : ${rooms}">

<div class="col-md-6" th:text="${room.name}">

<div class="card-text" th:text="${room.description}">
```

6. Create LoginServlet and display the login.html: 
```
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org">
<head>
    <title>Login</title>
    <meta charset="utf-8"/>
</head>
<body>
<form th:action="@{/login}" method="POST">
    <div class="form-group">
        <label for="username">Username</label>:
        <input id="username"
               type="text"
               name="username"
               autofocus="autofocus"
               placeholder="Username">
    </div>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>
```

7. Enable the login action: 


```
HttpSession session = req.getSession();
String username = req.getParameter("username");
session.setAttribute("username", username);
resp.sendRedirect("/");

```

8. Create Logout servlet


```

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate(); 
        resp.sendRedirect("/login");
    }
}
```


9. Create `AuthFilter` for enforcing the login