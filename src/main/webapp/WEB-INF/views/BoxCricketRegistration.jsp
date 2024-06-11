<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Box Cricket Registration</h1>
	
	<form action="saveStudentReg" method="post">
		Name: <input type="text" name="stdName" value="${reg_details.stdName}">
		<span style="color:red">${stdNameError}</span>
		
		<br><br>
		
		Player Type:  
			<input type="radio" name="playerType" value="Batsman" ${reg_details.playerType != null && reg_details.playerType.equals("Batsman") ? "checked" : ""}> Batsman  
			<input type="radio" name="playerType" value="Bowler" ${reg_details.playerType != null && reg_details.playerType.equals("Bowler") ? "checked" : ""}> Bowler  
			<input type="radio" name="playerType" value="All-Rounder" ${reg_details.playerType != null && reg_details.playerType.equals("All-Rounder") ? "checked" : ""}> All-Rounder  
			<span style="color:red">${playerTypeError}</span>
			
		<br><br>
		
		Food Preference:  
			<select name="foodPreference"> 
				<option value="-1">--Select Your Food Preference--</option>
				<option value="Regular" ${reg_details.foodPreference != null && reg_details.foodPreference.equals("Regular") ? "selected" : ""}>Regular</option>
				<option value="Jain" ${reg_details.foodPreference != null && reg_detaifoodPreference.equals("Jain") ? "selected" : ""}>Jain</option>
			</select>
			<span style="color:red">${foodPreferenceError}</span>
			
		<br><br>
		
		Drinks:  
			Red Bull <input type="checkbox" name="drink" value="Red_Bull" ${reg_details.drink.contains("Red_Bull") ? "checked" : ""}>  
			Thumbs Up <input type="checkbox" name="drink" value="Thumbs_Up" ${reg_details.drink.contains("Thumbs_Up") ? "checked" : ""}>  
			Lemon Juice <input type="checkbox" name="drink" value="Lemon_Juice" ${reg_details.drink.contains("Lemon_Juice") ? "checked" : ""}>
			Mountain Dew <input type="checkbox" name="drink" value="Mountain_Dew" ${reg_details.drink.contains("Mountain_Dew") ? "checked" : ""}>
			<span style="color:red">${drinkError}</span>
			
		<br><br>
		
		<input type="submit" value="Register">
		
	</form>
</body>
</html>