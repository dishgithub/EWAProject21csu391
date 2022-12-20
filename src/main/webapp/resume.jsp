<!DOCTYPE html>
<html>
<head>
  <meta http-equiv='Content-Type' content='text/html; charset=UTF-8'>
  <title>User Input Form</title>
</head>
 
<body>
<h2>RESUME BUILDER FORM</h2>
<form method="post" action="ResumeBuild">
  <fieldset>
    <legend><h3>Personal Information</h3> </legend>
    
    Name: <input type="text" name="Name" /><br /><br />
   
    Gender: <input type="radio" name="gender" value="m" checked />Male
    <input type="radio" name="gender" value="f" />Female<br /><br />
    E-mail: <input type="text" name="email" /><br /><br />
   
    Address: 
    <textarea rows="5" cols="30" name="address">Enter your address here....</textarea>
   <br /><br />
    Date Of Birth: <input type="text" name="dob" /><br /><br />
   
  </fieldset>
 
  <fieldset>
    <legend><h3> Educational Information</h3></legend>
    
    Qualification:
    <input type="checkbox" name="qualification" value="Post Graduate" checked />Post Graduate
    <input type="checkbox" name="Qualification" value="Graduate" />Graduate
    <input type="checkbox" name="qualification" value="Secondary School" />Secondary School
   
   <br />
   <h4>Secondary School Information:</h4>
    <br />
   Name of School: <input type="text" name="schoolname" /><br /><br />
   Percentage: <input type="text" name="percentage" /><br /><br />
   Year Of Passing: <input type="text" name="yearofpassing" /><br /><br />
  
  
   <h4>Graduation Information:</h4>
    <br />
   Name of University/college: <input type="text" name="collegename" /><br /><br />
   Percentage: <input type="text" name="percent" /><br /><br />
 
   Grade: <select name = "grade">
      <option value="A"> A</option>
      <option value="B"> B </option>
      <option value="C">  C </option>
    </select>
    
    <br />   <br />
   Year Of Passing: <input type="text" name="yearpassing" /><br /><br />
   
   
   <h4>Post Graduation Information:</h4>
    <br />
   Name of College/University: <input type="text" name="universityname" /><br /><br />
   Percentage: <input type="text" name="percentages" /><br /><br />
   Grade: <select name = "grades">
      <option value="A">A</option>
      <option value="B">B </option>
      <option value="C">C </option>
    </select>
    <br />    <br />
   Year Of Passing: <input type="text" name="passingyear" /><br /><br />
  
  </fieldset>
 
 <fieldset>
    <legend><h3>Projects Made</h3></legend>
    Name of Project: <input type="text" name="NameOfProject" /><br /><br />
    Programming Language: <input type="text" name="ProgrammingLanguage" /><br /><br />
   
   </fieldset>
  
  <fieldset>
    <legend><h3>Other Information</h3></legend>
    Technical Skills: <input type="text" name="skill" /><br /><br />
   Languages known:
    <input type="checkbox" name="language" value="java" checked />Java
    <input type="checkbox" name="language" value="c" />C/C++
    <input type="checkbox" name="language" value="cs" />C#
    
        <br />    <br />
    Hobbies:  <textarea rows="5" cols="30" name="hobby">Enter your hobbies here....</textarea>
   <br /><br />
    </fieldset>
    
    
 
  <input type="submit" value="SEND" />
  <input type="reset" value="CLEAR" />
</form>
</body>
</html>