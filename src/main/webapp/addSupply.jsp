
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
}

/* The Close Button */
.close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}
</style>
</head>
<body>

<h2>Supply</h2>
<jsp:useBean id = "supplier" class = "by.epam.training.javaWEB.finalTask.dao.impl.SQLSupplierDAO" scope = "page"/>
<jsp:useBean id = "product" class = "by.epam.training.javaWEB.finalTask.dao.impl.SQLProductDAO" scope = "page"/>


<!-- Trigger/Open The Modal -->
<form action = ? method = "post">
	<p>Supplier
	<input type="text" name="supplier" list="suppliername">
<datalist id="suppliername">
  <c:forEach var = "supplieritem" items = "${supplier.items}">
		<option>${item}</option>
		</c:forEach>
</datalist>
Requisites 
<input type = "text">

	
	</p>
	<p>
	Product
	<select size = "?" name = "product">
		<option disable>Select product</option>
		<c:forEach var = "productitem" items = "${product.items}">
		<option>${item}</option>
		</c:forEach>
		<option id = "openProductModal" value = "add">add product</option>
	</select>
	</p>
	<p>
	Document
	<input type = "text">
	</p>
	<p>
	Date
	<input type = "date">
	</p>
	<p>
	Price
	<input type = "text">
	</p>
	<p>
	Наценка, %
	<input type = "text">
	</p>
	<p>
	Quantity
	<input type = "text">
	</p>
	<p>
	<input type = "submit" value = "OK">
	</p>
</form>

<!-- The Modal -->
<div id="addSupplier" class="modal" >

  <!-- Modal content -->
  <div class="modal-content" title = "Add Supplier">
    <span class="close">×</span>
	<p>Supplier</p>
	<p><form>
	<input type = "text" value = "Name" id = "supplierName">
	<input type = "text" value = "Requisites" id = "requisites">
	<input type = "submit" value = "OK">
	</form>
    </p>
  </div>

</div>

<!-- The Modal -->
<div id="addProduct" class="modal" >

  <!-- Modal content -->
  <div class="modal-content" title = "Add Supplier">
    <span class="close">×</span>
	<p>Supplier</p>
	<p><form>
	<input type = "text" value = "Name" id = "supplierName">
	<input type = "text" value = "Requisites" id = "requisites">
	<input type = "submit" value = "OK">
	</form>
    </p>
  </div>

</div>


<script>
// Get the modal
var modal = document.getElementById('addSupplier');

// Get the button that opens the modal
var btn = document.getElementById("openSupplierModal");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
<script>
// Get the modal
var modal = document.getElementById('addProduct');

// Get the button that opens the modal
var btn = document.getElementById("openProductModal");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks the button, open the modal 
btn.onclick = function() {
    modal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span.onclick = function() {
    modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>
</body>
</html>



