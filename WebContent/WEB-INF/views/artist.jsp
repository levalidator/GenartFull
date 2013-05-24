<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../static/header.jsp" %>

<header class="header">
    <section class="container">
      <h3>Artistes</h3>
    </section>
  </header>

  <section class="content">
  	<c:forEach items="${ requestScope['artists'] }" var="artist">
  		<div class="container">
	   		<div class="pull-left span2">
				<img src="${ artist.getPathAvatar() }" class="img-circle img-polaroid img-detail-artist">
			</div>
			<div class="pull-left span8" style="margin-left:60px;">
				<div class="page-header">
					<h2><c:out value="${ artist.getFullName()}"/></h2>
				</div>
				<div class="description-artist">
					<p>
						<c:out value="${ artist.getDescription()}"/>
					</p>
				</div>
			</div>
	   </div>
  	</c:forEach>   
  </section><!--end content-->

<%@ include file="../static/footer.jsp" %>