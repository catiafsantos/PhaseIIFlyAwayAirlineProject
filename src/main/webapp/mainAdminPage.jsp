<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous">
    <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>
<body>
<div class='container'>
    <h1>Welcome <%=session.getAttribute("email")%></h1>
    <h2>FlyAwayAirLine Maintenance Page</h2>
    <h3>Hereby the list of actions available</h3>
    <p>Maintain Flight Information:</p>
    <ul>
        <li><button>List Flights</button></li>
        <li><button>Add Flights</button></li>
        <li><button>Remove Flights</button></li>
        <li><button>Update Flights</button></li>
    </ul>
    <br>
    <p>Maintain Airline Information:</p>
    <ul>
        <li><button>List Airlines</button></li>
        <li><button>Add Airlines</button></li>
        <li><button>Remove Airlines</button></li>
        <li><button>Update Airlines</button></li>
    </ul>
    <br>
    <p>Maintain Source/Destination Information:</p>
    <ul>
        <li><button>List Source/Destination</button></li>
        <li><button>Add Source/Destination</button></li>
        <li><button>Remove Source/Destination</button></li>
        <li><button>Update Source/Destination</button></li>
    </ul>


    <p>Account Actions</p>
    <button>Change Password</button>
    <button>Logout</button>
</div>
</body>
</html>
