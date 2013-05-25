<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ include file="../static/header.jsp"%>

<header class="header">
    <section class="container">
        <h3>Mes commandes</h3>
    </section>
</header>

<section class="container">
	<c:if test="${orders != null}">
    	<table class="table table-bordered table-striped">    	
	        <thead>
	            <tr>
	                <th>Numéro de la commande</th>
	                <th>Date de la commande</th>
	                <th>Support</th>
	                <th>Prix</th>
	            </tr>
	        </thead>
	        <tbody class="cart">
	        	<c:if test="${not empty orders}">		
	        		<c:forEach items="${orders }" var="order">
			            <tr>
			                <td class="span3 text-center ref">
			                    <strong><c:out value="${order.getIdCommand()}"/></strong>
			                </td>
			                <td class="span3 text-center ref">
			                    <strong><c:out value="${order.getDate()}"/></strong>
			                </td>
			                <td class="span3 text-center ref">
			                    <div class="span2">
			                        Peuvre X sur tasse MUG
			                    </div>
			                </td>
			                <td class="span2">
			                    <div class="span2"><div class="span1">Oeuvre :</div> <span class="badge">15€</span></div>
			                    <div class="span2"><div class="span1">Support :</div> <span class="badge">15€</span></div>
			                    <div class="span2"><div class="span1">Total :</div> <span class="badge">30€</span></div>
			                </td>
			            </tr>    
		            </c:forEach>	        
	            </c:if>         
	        </tbody>
        </table>
   	</c:if>
    
    <!--<table class="table table-bordered table-striped">
        <tbody>
            <tr>
                <td class="span3">
                    
                </td>
                <td class="span3">
                    
                </td>
                <td class="span2">
                    <div class="span2"><div class="span1">Total :</div> <span class="badge">90€</span></div>
                </td>
                <td class="span3">
                    <a class="button red" href="">Passer au paiement</a>
                </td>
            </tr>
           
        </tbody>
    </table>-->
</section><!--end content-->

<%@ include file="../static/footer.jsp"%>