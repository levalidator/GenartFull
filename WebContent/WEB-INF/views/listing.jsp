<%@page import="com.genart.beans.Artist"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../static/header.jsp" %>
  <header class="header">
    <section class="container">
      <h1>Gallerie categorie : lorem ipsum</h1>
    </section>
  </header>

  <section class="content">

    <div class="container">
      <form class="form-inline pull-right">
        <label>Categorie : </label>
        <select>
          <option>1</option>
          <option>2</option>
        </select>
        <label for="date">Date :</label>
        <input id="date" type="text" name="date"/>
        <input class="button red noborder" type="submit" value="Filtrer">
      </form>
    </div>

    <div class="spacer"></div>
    <section class="container-fluid">
		
		<c:forEach items="${ requestScope['templates'] }" var="template">
	    	<article class="span4 article-thumb">
		    	<figure>		    	
		          <img src="${ template.getImage() }"/>
		          <section class="pict-descr">
		          	<c:set var="idArtist" value="${template.getIdArtist() }"/>
		            <h4>Auteur : <c:out value="${requestScope['artistes'][idArtist].getFullName() }"/></h4>
              	  	<p><a href="http://${requestScope['artistes'][idArtist].getWebSite() }"><c:out value="${requestScope['artistes'][idArtist].getWebSite() }"/></a></p>
		          </section>
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