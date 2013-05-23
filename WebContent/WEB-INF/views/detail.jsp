<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../static/header.jsp" %>
<header class="header">
    <section class="container">
        <h1>Information sur l'oeuvre : <c:out value="${ template.getName() }" /></h1>
    </section>
</header>

<section class="content">
    <section class="container-fluid">
        <div class="span8">
            <div id="info-oeuvre">
                <p><c:out value="${ template.getDescription() }" /></p>
            </div>
        </div>

        <div class="span8" id="app-span">
            <canvas id="${template.getNamePde() }" data-processing-sources="${ template.getPdePath() }"></canvas>
			<img src="" id="example" style="display:none;">
            <div class="span3">
                <div class="btn-group">
                    <button class="btn btn-large">Selectionner un support</button>
                    <button class="btn btn-large dropdown-toggle" data-toggle="dropdown">
                        <span class="caret"></span>
                    </button>
                    <ul id="choix-support" class="dropdown-menu">
                        <li>Aucun</li>
				    	<c:forEach items="${ requestScope['supports'] }" var="support">
				           <li class="divider"></li>
				           <li data-item-id="${ support.getId() }">
				               <figure>
				                   <img src="img/products/product-${ support.getId() }.jpg"/>
				               </figure>
				               <span data-value="${ support.getMontant() }" class="badge">
				                   <c:out value="${ support.getMontant() }" />€
				               </span>
				           </li>
						</c:forEach>
                    </ul>
                </div>
            </div>

            <div class="span1">Oeuvre : <span id="badge-price-oeuvre" data-price-oeuvre="${ template.getMontant() }" class="badge"><c:out value="${ template.getMontant() }" />€</span></div>
            <div class="span1">Support : <span id="badge-price-support" class="badge">0€</span></div>
            <div class="span1">Total : <span id="badge-price-total" class="badge"><c:out value="${ template.getMontant() }" />€</span></div>
            <form action="./cart" method="post">
				<input type="hidden" name="idTemplate" id="idTemplate" value="${ template.getId() }">
				<input type="hidden" name="idSupport" id="idSupport" value="${ support.getId() }">
				<input type="hidden" name="action" id="action" value="add">
	            <button id="add-oeuvre" class="button red noborder" name="Add">Ajouter à mes oeuvres</button> 
			</form>
        </div>
        <div class="span4">
            <div class="myform">
                <form id="form-art">
                <c:if test="${template.getId() == 1}">
                	<%@ include file="../forms/form_newyork-1.jsp" %>
                </c:if>
                <c:if test="${template.getId() == 2}">
	                <%@ include file="../forms/form_newyork-2.jsp" %>
                </c:if>
                <c:if test="${template.getId() == 3}">
	                <%@ include file="../forms/form_newyork-3.jsp" %>
                </c:if>
                <c:if test="${template.getId() == 4}">
	                <%@ include file="../forms/form_newyork-4.jsp" %>
                </c:if>
                </form>
            </div>
        </div>
    </section>

    <section class="container-fluid">
        <div class="spacer"></div>
        <section class="page-header">
            <h2>Les oeuvres du meme artiste</h2>
        </section>
    	<c:forEach items="${ requestScope['templates'] }" var="fetemplate">
	        <article class="span4 article-thumb">
	            <figure>
	                <img src="${ fetemplate.getImage() }"/>
	                <section class="pict-descr">
	                    <h4>Titre : <c:out value="${ fetemplate.getName() }" /></h4>
	                    <p>Auteur : <c:out value="${ artist.getFullName() }" /></p>
	                </section>
	            </figure>
	            
	            <h3><c:out value="${ fetemplate.getName() }" /></h3>
                <p><c:out value="${ fetemplate.getDescription() }" /></p>
	            <a href="details?id=${ fetemplate.getId() }" class="button green">en savoir plus</a>
	        </article>
		</c:forEach>
    </section>
</section>

<%@ include file="../static/footer.jsp" %>
