<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../static/header.jsp"%>

<header class="header">
	<section class="container">
		<h3>Fiche artiste</h3>
	</section>
</header>

<section class="content">
	<div class="container">
		<c:set var="artist" value="${artist}" />
		<div class="pull-left span2">
			<img src="${ artist.getPathAvatar() }"
				class="img-circle img-polaroid img-detail-artist">
		</div>
		<div class="pull-left span8" style="margin-left: 60px;">
			<div class="page-header">
				<h2>
					<c:out value="${ artist.getFullName()}" />
				</h2>
			</div>
			<div class="description-artist">
				<p>
					<c:out value="${ artist.getDescription()}" />
				</p>
				<p>
					<c:out value="${ artist.getWebSite()}" />
				</p>
			</div>
			<a href="artistDetails?id=<c:out value="${artist.getId()}"/>" class="button green pull-right" >En savoir plus</a>
		</div>
	</div>

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