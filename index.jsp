<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Student Registration</title>
        <style type="text/css">
            .bg-custom{
                background-color:#0277bd;
            }
            .bg-custom1{
                 background-color:#0277bd ;
            }
            .card{
    margin-top: 20px;
}
            </style>
    </head>
    <body>
        
    
        
     <nav class="navbar navbar-expand-lg navbar-dark  bg-custom">
  <a class="navbar-brand" href="#">REGISTRATION FORM</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="index.jsp">Register</a>
      </li>
  
    </ul>
   
  </div>
</nav>
                 <!-- end of navbar -->
                 
                 
                 
    <!--form start-->
    
    
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-4 offset-md-4">
                <div class="card " >
                    <div class="card-header bg-custom1" >
                        <h4 class="text-center text-white "> Student Registration Form</h4>
                    </div>
                    
                    <div class="card-body">
                     <form action="register" method ="post">
  <div class="form-group">
      
    <label for="exampleInputEmail1">Full Name</label>
    <input type="text" class="form-control" name="userName"  required>

  </div>
                           
                           
   <div class="form-group">
    <label for="exampleInputEmail1">Email</label>
    <input type="email" class="form-control"name="userEmail" required>
    <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>
  </div>
                           
      
                                
   <div class="form-group">
    <label for="exampleInputEmail1">D.O.B</label>
    <input type="date" class="form-control" name="userDate"  >
  </div>
                               
                           
        <div class="form-group">
    <label for="exampleInputEmail1">Address</label>
    <textarea rows="5" cols="" class="form-control" name="userAddress" required></textarea>
   
  </div>
                              
         
                           
         <div class="form-group">
    <label for="exampleInputEmail1">Phone no.</label>
    <input type="number" class="form-control" name="userPhone"required>
  </div>
                             
                           
   
                              
         <div class="form-group">
    <label for="exampleInputEmail1">Gender</label>
    <input type="text" class="form-control" name="userGender"required>
  </div>
                             
    
                   
                           
                           
   
 
  <button type="submit" class="btn btn-primary" style='margin-top:7px; margin-left:130px'>Submit</button>
  <button type="reset" class="btn btn-danger"style='margin-top:7px; margin-left:10px'>Cancel</button>
  
  
</form> 
             
   <a href="showdata"><button class="btn btn-warning d-inline" style='margin-top:7px; margin-left:150px'>Show Users </button></a>                      
                        
                        
                        
                        
                </div>
            </div>
        </div>
    </div>
    </div>
    
    
    
   
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
