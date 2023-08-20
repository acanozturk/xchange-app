<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <title>Fx Rates for Today</title>
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            font-size: 12px;
            max-width: 500px;
            margin: auto;
        }

        table,
        th,
        td {
            text-align: center;
            border: 1px solid black;
            border-collapse: collapse;
        }

        th {
            background-color: brown;
            color: #fff;
            padding: 5px
        }

        tr {
            background-color: #f1f1f1;
        }

        tr:nth-child(even) {
            background-color: white;
        }
    </style>
</head>
<body>
<div>
    <table>
        <thead>
        <tr>
            <th>Target Currency</th>
            <th>Base Currency</th>
            <th>Rate</th>
        </tr>
        </thead>
        <tbody>
        <#list rates as key, value>
            <tr>
                <td>${key}</td>
                <td>${baseCurrency}</td>
                <td>${value}</td>
            </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>