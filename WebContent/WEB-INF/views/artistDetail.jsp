<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../static/header.jsp"%>

<header class="header">
	<section class="container">
		<h3>Fiche artiste</h3>
	</section>
</header>

<section class="content">
	<section class="container-fluid">
		<div class="spacer"></div>
		<section class="page-header">
			<h2>Les oeuvres de cet artiste</h2>
		</section>

		<c:forEach items="${ requestScope['templates'] }" var="template">
			<article class="span4 article-thumb">
				<figure>
					<img src="${template.getImage()}" />
					<section class="pict-descr">
						<h4>Titre : <c:out value="${template.getName()}"/></h4>
						<p>Auteur : <c:out value="${ requestScope['artist'].getFullName()}"/></p>
					</section>
				</figure>

				<h3>Titre de l'oeuvre</h3>
				<p><c:out value="${template.getDescription()}"/></p>
				<a href="details?id=<c:out value="${template.getId()}"/>" class="button green">En savoir plus</a>
			</article>
		</c:forEach>
	</section>

</section>
<!--end content-->

<%@ include file="../static/footer.jsp"%>