<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../static/header.jsp" %>
    <header class="header visible-desktop">
      <section class="slice">
        <section class="container">
          <div id="carousel" class="carousel slide">
              <!-- Carousel items -->
              <div class="carousel-inner">

                <div class="active item">
                  <img src="img/schema.png" class="auto"/>
                </div>

                <div class="item">
                  <img src="img/schema.png" class="auto"/>
                </div>
                
              </div>
              <!-- Carousel nav -->
              <a class="control" href="#carousel" data-slide="prev">&lsaquo;</a>
              <a class="control" href="#carousel" data-slide="next">&rsaquo;</a>
            </div>
       
        </section>
      </section><!--end slice desktop-->
  </header>


  <section class="content">
    <section class="container">
      <section class="page-header">
        <h1>Les oeuvres les plus populaires</h1>
      </section>
    </section>
    <section class="container-fluid">
      <c:forEach items="${topTemplates}" var="template" varStatus="item">
      <c:set var="idArtist" value="${template.getIdArtist()}" />
      <c:set var="artist" value="${mapArtists[idArtist]}" />
	      <article class="span4 article-thumb">
	        <figure>
	          <img src="${template.getImage()}"/>
	          <section class="pict-descr">
	            <h4>Titre : ${template.getName()}</h4>
	            <p>Auteur : ${artist.getFirstName()}</p>
          	  </section>
	        </figure>
	        <h3>${template.getName()}</h3>
	        <p>
	          ${template.getDescription()}
	        </p>
	        <a href="details?id=<c:out value="${template.getId()}" />" class="button green">en savoir plus</a>
	      </article>
      </c:forEach>
    </section>
    
    <div class="spacer"></div>

    <section class="container">
      <h2>Gen<strong>art</strong> c'est quoi ?</h2>
      <section class="span5">
        <p>
          Processing is an open source programming language and environment for people who want to create images, animations, and interactions. Initially developed to serve as a software sketchbook and to teach fundamentals of computer programming within a visual context, Processing also has evolved into a tool for generating finished professional work. Today.
          Processing is an open source programming language and environment for people who want to create images, animations, and interactions. Initially developed to serve as a software sketchbook and to teach fundamentals of computer programming within.
        </p>
      </section>
       <section class="span5">
        <p>
          Processing is an open source programming language and environment for people who want to create images, animations, and interactions. Initially developed to serve as a software sketchbook and to teach fundamentals of computer programming within a visual context, Processing also has evolved into a tool for generating finished professional work. Today, there are tens of thousands of students, artists, designers, researchers, and hobbyists who use Processing for learning, prototypingn.
        </p>
      </section>
    </section>

    <div class="spacer"></div>

    <section class="container">
      <h2>Nos artistes</h2>
      <ul class="artist-list">
        <c:forEach items="${listArtists}" var="artist" varStatus="item">
	      	<li>
		      	<a href="artist.jsp?id=${artist.getId()}">
		        	<img src="${artist.getPathAvatar()}" width="88" height="93" class="img-circle img-polaroid"/>
		        </a>
	        </li>
      	</c:forEach>	
  
      </ul>
    </section>
  </section><!--end content-->
<%@ include file="../static/footer.jsp" %>