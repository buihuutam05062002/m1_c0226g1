<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Simple Calculator</h1>

<form style="display: flex; flex-direction: column" action="index" method="post">
    <label>First operand: </label>
    <input type="text" name="num1">

    <label>Operator: </label>
    <select name="operator">
        <option value="+">Addition</option>
        <option value="-">Subtraction</option>
        <option value="*">multiplication</option>
        <option value="/">division</option>

    </select>
    <label>Second operand: </label>
    <input type="text" name="num2">


    <button type="submit">Calculate</button>
</form>
</body>
</html>