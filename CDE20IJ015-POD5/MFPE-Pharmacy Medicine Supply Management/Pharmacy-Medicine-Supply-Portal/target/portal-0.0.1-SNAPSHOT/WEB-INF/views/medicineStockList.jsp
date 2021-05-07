<%@ include file="common/header.jspf"%>


<article>

	<div class="container">
		<h1 class="article-heading text-center m-4" style="
box-shadow: 0 2px 2px 0 rgba(1, 1, 1, 1);
background-color:#00bfff;
color: #ffffff;
font-size: 45px;
font-family: italics;">Medicine Stock</h1>
		<table class="table table-striped table-bordered bg-light rounded">
				<tr class="text-center bg-secondary text-white" style="font-size: 1.3em;">
				
					<th>Id</th>
					<th>Name</th>
					<th>Chemical Composition</th>
					<th>Target Ailment</th>
					<th>Pharmacy Name</th>
					<th style="width: 7em;">Date Of Expiry</th>
					<th> Stock</th>
				</tr>
			</thead>
			<c:forEach items="${medicineStockList}" var="medicineStock">
				<tr>
					<td>${medicineStock.id}</td>
					<td>${medicineStock.name}</td>
					<td>${medicineStock.chemicalComposition}</td>
					<td>${medicineStock.targetAilment}</td>
					<td>${medicineStock.pharmacyName}</td>
					<td>${medicineStock.dateOfExpiry}</td>
					<td class="text-center">${medicineStock.numberOfTabletsInStock}</td>
				</tr>

			</c:forEach>

		</table>
	</div>
</article>


<%@ include file="common/footer.jspf"%>