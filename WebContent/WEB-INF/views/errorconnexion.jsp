<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../static/header.jsp" %>
<header class="header">
    <section class="container">
        <h3>Echec de la connexion</h3>
    </section>
</header>

<section class="content">
    <div class="container auto">
    <c:choose>
		<c:when test="${result == 'errorPassw'}">
		<h2>Erreur dans le couple identifiant / mot de passe</h2>
        <p>Veuillez réessayer</p>
        <p>
        	<a class="button green" href="./connexion">
                connexion
            </a>
            <a class="button green" href="./">
                mot de passe oublié?
            </a>
            <a class="button green" href="./">
                retour à l'accueil
            </a>
        </p>
		</c:when>
		<c:otherwise>
		<h2>Votre compte n'existe pas ou n'a pas encore été activé.</h2>
        <p>Si vous n'êtes pas encore inscrit, inscrivez vous.</p>
        <p>Si vous êtes artiste, il se peut que votre compte n'air pas encore été activé.</p>
        <p>
        	<a class="button green" href="./connexion">
                s'inscrire
            </a>
            <a class="button green" href="./">
                retour à l'accueil
            </a>
        </p>
		</c:otherwise>
	</c:choose>
        
    </div>

</section><!--end content-->

<%@ include file="../static/footer.jsp" %>