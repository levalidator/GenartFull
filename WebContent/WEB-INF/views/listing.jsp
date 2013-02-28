<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../static/header.jsp" %>
  <header class="header">
    <section class="container">
      <h3>Gallerie categorie : lorem ipsum</h3>

    </section>
    <button class="btn btn-primary visible-phone">sdqdqsd</button>
  </header>

  <section class="content">
    <section class="container-fluid">  
    	<c:forEach items="${ requestScope['templates'] }" var="template">
	    	<article class="span4 article-thumb">
		    	<figure>		    	
		          <img src="${ template.getImage() }"/>
		        </figure>
		        <h3><c:out value="${ template.getName() }" /></h3>
		        <p>
		          <c:out value="${ template.getDescription() }" />
		        </p>
		    	<a href="details?id=${ template.getId() }" class="button green">en savoir plus</a>
			</article>
		</c:forEach>
    </section>
    <div class="spacer"></div>
  </section><!--end content-->
<%@ include file="../static/footer.jsp" %>
