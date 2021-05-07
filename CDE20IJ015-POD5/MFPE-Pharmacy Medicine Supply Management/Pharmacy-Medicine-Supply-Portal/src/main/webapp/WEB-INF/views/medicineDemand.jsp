

<%@ include file="common/header.jspf"%>

<article>
	<div class="container">
		<h1 class="text-center m-4" style="
box-shadow: 0 2px 2px 0 rgba(1, 1, 1, 1);
background-color:#00bfff;
color: #ffffff;
font-size: 45px;
font-family: italics;">Place Order</h1>

		<div class="w-50 p-3 mx-auto border bg-light rounded text-center">
			<div>
				<img class="card-img-top"
					src="https://moodle.org/pluginfile.php/50/local_plugins/plugin_screenshots/557/SharingCart-greycartplus.png"
					alt="img place order" style="width: 250px; height: 200px;">
			</div>
			<div class="card-body">
				<h3 class="card-title">Enter details</h3>
				<p class="card-text">Fill in the required details below.</p>

			</div>
			<div>
				<form action="/user/getMedicineSupply" method="post"
					onsubmit="return validate();">
					<div class="form-group row">
						<label for="medicineName" class="col-sm-3 col-form-label">Medicine</label>
						<div class="col-sm-9">



							<select id="medicineName" name="medicineName" style="float: left">
								<option value="Crocin">Crocin</option>
								<option value="Digoxin">Digoxin</option>
								<option value="Misoprostol">Misoprostol</option>
								<option value="Percocet">Percocet</option>
								<option value="Oxycodone">Oxycodone</option>
								<option value="Orthoherb">Orthoherb</option>
								<option value="Cholecalciferol">Cholecalciferol</option>
								<option value="Gaviscon">Gaviscon</option>
								<option value="Dolo-650">Dolo-650</option>
								<option value="Hilact">Hilact</option>
								<option value="Cyclopam">Cyclopam</option>
							</select>




							<!-- 	<input type="text" class="form-control" id="medicine"
								name="medicine" placeholder="Type here" required="required">  -->
						</div>
					</div>
					<div class="form-group row">
						<label for="demandCount" class="col-sm-3 col-form-label">Demand
							Count</label>
						<div class="col-sm-9">
							<input type="number" class="form-control" id="demandCount"
								name="demandCount" placeholder="Enter value" min="1"
								required="required">
						</div>
					</div>

					<input type="submit" class="btn btn-primary" name="submit"
						value="Submit">
				</form>
			</div>
		</div>

	</div>
</article>

<%@ include file="common/footer.jspf"%>