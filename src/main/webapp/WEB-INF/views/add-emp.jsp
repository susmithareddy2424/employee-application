<html>
<head>
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<link href="css/add-emp.css" rel="stylesheet">
</head>
<body>
  
	<div class="container">
			<div class="main">
				<div class="main-center">
				<h4 align="center">Employee Registration Form</h4>
					<form class="" method="post" action="add-employee">
						
						<div class="form-group">
							<label for="ename">Enter Employee Name</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="ename" id="ename"  placeholder="Enter your Name"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="job">Enter Job</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="text" class="form-control" name="job" id="job"  placeholder="Enter your Job"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="mgr">Enter Manager Number</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="number" class="form-control" name="mgr" id="mgr"  placeholder="Enter your Manager Number"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="hiredate">Enter Hiredate</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="date" class="form-control" name="hiredate" id="hiredate"  placeholder="Enter Hiredate"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="sal">Enter Salary</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="number" class="form-control" name="sal" id="sal"  placeholder="Enter Salary"/>
							</div>
						</div>
						
						<div class="form-group">
							<label for="comm">Enter Commission</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="number" class="form-control" name="comm" id="comm"  placeholder="Enter Commission"/>
							</div>
						</div>
						
						
						<div class="form-group">
							<label for="deptno">Enter Deptno</label>
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa" aria-hidden="true"></i></span>
									<input type="number" class="form-control" name="deptno" id="deptno"  placeholder="Enter Deptno"/>
							</div>
						</div>

						

						<button type="submit">REGISTER</button>
						
					</form>
				</div><!--main-center"-->
			</div><!--main-->
		</div><!--container-->
	</body>	
</html>