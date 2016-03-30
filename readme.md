## issues
貌似shiro在servlet 3.x环境中不能正确工作，不能正确配置。
将web.xml换为2.5的schema

```xml
<web-app xmlns="http://java.sun.com/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
	      http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd"
         version="2.5">
</web-app>
```

