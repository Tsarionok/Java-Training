<%@ page import="by.tsarionok.dao.impl.UserDaoImpl" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>Project</title>
</head>
<body>
<% UserDaoImpl userDao = new UserDaoImpl();
    userDao.readAll(1, 4);%>
</body>
</html>
