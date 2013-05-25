<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../static/header.jsp"%>
<header class="header"> <section class="container">
<h3>Mes oeuvres</h3>
</section> </header>

<section class="container">
<table class="table table-bordered table-striped">
	<thead>
		<tr>
			<th>Oeuvre</th>
			<th>Support</th>
			<th>Prix</th>
			<th>Options</th>
		</tr>
	</thead>
	<tbody class="cart">
		<c:forEach items="${ requestScope['sketchs'] }" var="skecth">
			<c:set var="idSupport" value="${ skecth.getId() }" />
			<c:set var="idTemplate" value="${ skecth.getIdTemplate() }" />
			<c:set var="numSketch" value="${ skecth.getNumero() }" />
			<tr>
				<td class="span3">
					<div class="span2">
						<h4>
							<c:out
								value="${ requestScope['templates'][idTemplate].getName() }" />
						</h4>
						<figure> <img src="${ skecth.getImage() }"
							style="width: 100%; max-height: 100px" /> </figure>
					</div>
				</td>
				<td class="span3">
					<div class="span2">
						<h4>
							<c:out value="${ requestScope['supports'][idSupport].getName() }" />
						</h4>
						<figure> <img
							src="img/products/product-${ requestScope['supports'][idSupport].getId() }.jpg"
							style="width: 100%; height: 100%" /> </figure>
					</div>
				</td>
				<td class="span2">
					<div class="span2">
						<div class="span1">Oeuvre :</div>
						<span class="badge"><c:out
								value="${ requestScope['templates'][idTemplate].getMontant() }" />€</span>
					</div>
					<div class="span2">
						<div class="span1">Support :</div>
						<span class="badge"><c:out
								value="${ requestScope['supports'][idSupport].getMontant() }" />€</span>
					</div>
					<div class="span2">
						<div class="span1">Total :</div>
						<span class="badge"><c:out
								value="${ requestScope['templates'][idTemplate].getMontant() + requestScope['supports'][idSupport].getMontant() }" />€</span>
					</div>
				</td>
				<td class="span3"><a class="button green"
					href="details?id=${ requestScope['templates'][idTemplate].getId() }">Voir</a>
					<a class="button red" href="">Supprimer</a>
					<form action="./cart" method="post">
						<input type="hidden" name="action" id="action" value="delete">
						<input type="hidden" name="numero" id="numero"
							value="${ numSketch }">
						<button id="add-oeuvre" class="button red noborder" name="Add">Delete</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<table class="table table-bordered table-striped">
	<tbody>
		<tr>
			<td class="span3"></td>
			<td class="span3"></td>
			<td class="span2">
				<div class="span2">
					<div class="span1">Total :</div>
					<span class="badge"><c:out
							value="${ requestScope['montantTotal'] }" />€</span>
				</div>
			</td>
			<td class="span3">
				<a class="button red" onclick="$('#validformpanier').submit();" href="#">Passer au paiement</a>
			</td>
			<div style="display:none" >
			<form method="post" action="./cart" id="validformpanier" >
				<input type="hidden" name="action" id="action" value="paiement">
			</form></div>
		</tr>

	</tbody>
</table>
</section>
<!--end content-->
<%@ include file="../static/footer.jsp"%>