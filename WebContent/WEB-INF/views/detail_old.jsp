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
                <h3><c:out value="${ template.getName() }" /></h3>
                <p><c:out value="${ template.getDescription() }" /></p>
            </div>
        </div>
        
        <div class="span8">
            <div id="appercu"><img src="<c:out value="${ template.getImage() }" />" style="height: 100%; width: 100%" alt="<c:out value="${ template.getName() }" />" /></div>
        </div>
        <div class="span4">
            <form>
                <input type="text" name="val1">
                <input type="text" name="val2">
                <input type="text" name="val3">
                <input type="text" name="val4">
                <input type="submit" value="Valider">
            </form>
        </div>
    </section>
</section>
<%@ include file="../static/footer.jsp" %>