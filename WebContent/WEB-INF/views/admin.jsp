<%@page import="com.genart.beans.Artist"%>
<%@ include file="../static/admin-header.jsp" %>

<header class="header">
    <section class="container">
        <h3>Panel Admin</h3>
    </section>
</header>

<section class="container">
    <div class="">
        <ul id="myTab" class="nav nav-tabs">
            <li class="active"><a href="#users" data-toggle="tab">Artistes</a></li>
            <li class=""><a href="#clients" data-toggle="tab">Clients</a></li>
            <li class=""><a href="#carts" data-toggle="tab">Commandes</a></li>
            <li class=""><a href="#products" data-toggle="tab">Products</a></li>
            <li class=""><a href="#projects" data-toggle="tab">Process-projects</a></li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane fade active in" id="users">
                <div class="span9">
                    <h3>Artistes enregistrés</h3>
                </div>
                <table id="user-tab" class="table table-striped">
                    <tr>
                        <th>Id</th>
                        <th>Nom</th>
                        <th>Prenom</th>
                        <th>E-mail</th>
                        <th>Password</th>
                        <th>Telephone</th>
                        <th>Site Web</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${ requestScope['artists'] }" var="artist">
	                    <tr id="tr-user-${ artist.getId() }">
	                        <td>
	                        	<c:out value="${ artist.getId() }"/>
	                        </td>
	                        <td>
	                            <div id="div-nom-${ artist.getId() }">${ artist.getName() }</div>
	                        </td>
	                        <td>
	                            <div id="div-prenom-${ artist.getId() }">${ artist.getFirstName() }</div>
	                        </td>
	                        <td>
	                            <div id="div-mail-${ artist.getId() }">${ artist.getMail() }</div>
	                        </td>
	                        <td>
	                            <div id="div-password-${ artist.getId() }">*****</div>
	                        </td>
	                        <td>
	                            <div id="div-phone-${ artist.getId() }">${ artist.getPhone() }</div>
	                        </td>
	                        <td>
	                            <div id="div-web-${ artist.getId() }">${ artist.getWebSite() }</div>
	                        </td>
	                        <td>
	                            <a data-id="${ artist.getId() }" href="#modal-user" role="button" class="button green edit-user" data-toggle="modal">Edit</a>
	                            <a data-id="${ artist.getId() }" href="#modal-confirm" role="button" class="button red delete-user" data-toggle="modal">Supprimer</a>
	                        </td>
	                    </tr>
                    </c:forEach>
                    
                </table>
                
                <div data-new-id=${ requestScope['maxIdArtist'] } href="#modal-user" role="button" class="button green add-user" data-toggle="modal">Enregistrer un artiste</div>
            
            </div>
            <div class="tab-pane fade" id="clients">
                <div class="span9">
                    <h3>Clients enregistrés</h3>
                </div>
                <table id="customer-tab" class="table table-striped">
                    <tr>
                        <th>Id</th>
                        <th>E-mail</th>
                        <th>Password</th>
                        <th>Action</th>
                    </tr>
                    <c:forEach items="${ requestScope['customers'] }" var="customer">
	                    <tr id="tr-customer-${ customer.getIdCustomer() })">
	                        <td>
	                            <c:out value="${ customer.getIdCustomer() }"/>
	                        </td>
	                        <td>
	                            <div id="div-mailcustomer-${ customer.getIdCustomer() }">${ customer.getMailCustomer() }</div>
	                        </td>
	                        <td>
	                            <div id="div-passwordcustomer-${ customer.getIdCustomer() }">**********</div>
	                        </td>
	                        <td>
	                            <a data-id="${ customer.getIdCustomer() }" href="#modal-customer" role="button" class="button green edit-customer" data-toggle="modal">Edit</a>
	                            <a data-id="${ customer.getIdCustomer() }" href="#modal-confirm" role="button" class="button red delete-customer" data-toggle="modal">Supprimer</a>
	                        </td>
	                    </tr>
                    </c:forEach>
                </table>
                
                <div data-new-id="6" href="#modal-customer" role="button" class="button green add-customer" data-toggle="modal">Enregistrer un client</div>
            
            </div>
            
            <div class="tab-pane fade" id="carts">
                <div class="span9">
                    <h3>Cart List</h3>
                </div>
                <table id="cart-tab" class="table table-striped">
                    <tr>
                        <th>Id</th>
                        <th>Numero</th>
                        <th>Client</th>
                        <th>Action</th>
                    </tr>
                    <tr id="tr-cart-1">
                        <td>
                            1
                        </td>
                        <td>
                            <div id="div-numbercart-1">TEH582-558R</div>
                        </td>
                        <td>
                            <div id="div-clientcart-1">jeanclaude dupond</div>
                        </td>
                        <td>
                            <a data-id="1" href="#modal-cart" role="button" class="button green edit-cart" data-toggle="modal">Edit</a>
                            <a data-id="1" href="#modal-confirm" role="button" class="button red delete-cart" data-toggle="modal">Supprimer</a>
                        </td>
                    </tr>
                    
                </table>
                
                <div data-new-id="6" href="#modal-cart" role="button" class="button green add-cart" data-toggle="modal">Add cart</div>
            
            </div>


            <div class="tab-pane fade" id="products">
                <div class="span9">
                    <h3>Products List</h3>
                </div>
                <table  class="table table-striped">
                    <tr>
                        <th>Id</th>
                        <th>Nom</th>
                        <th>Prix</th>
                        <th>Description</th>
                        <th>Longueur</th>
                        <th>Largeur</th>
                        <th>Profondeur</th>
                        <th>Actions</th>
                        
                    </tr>
                    <tr id="tr-product-1">
                        <td>
                            1
                        </td>
                        <td>
                            <div id="div-productname-1">produit 1</div>
                        </td>
                        <td>
                            <div id="div-productprice-1">20</div>
                        </td>
                        <td>
                            <div id="div-productdescription-1">description 1</div>
                        </td>
                        <td>
                            <div id="div-dimx-1">20</div>
                        </td>
                        <td>
                            <div id="div-dimy-1">40</div>
                        </td>
                        <td>
                            <div id="div-dimz-1">20</div>
                        </td>
                        <td>
                            <a data-id="1" href="#modal-product" role="button" class="button green edit-product" data-toggle="modal">Edit</a>
                            <a data-id="1" href="#modal-confirm" role="button" class="button red delete-product" data-toggle="modal">Supprimer</a>
                        </td>
                    </tr>
                </table>
                <div data-new-id="6" href="#modal-product" role="button" class="button green add-product" data-toggle="modal">Add Product</div>
            </div>
            <div class="tab-pane fade" id="projects">
                <div class="span9">
                    <h3>Projects List</h3>
                </div>
                <table  class="table table-striped">
                    <tr>
                        <th>Id</th>
                        <th>Nom</th>
                        <th>Description</th>
                        <th>Artiste</th>
                        <th>Prix</th>
                        <th>Image</th>
                        <th>Actions</th>
                    </tr>
                    <tr id="tr-project-1">
                        <td>
                            1
                        </td>
                        <td>
                            <div id="div-projectname-1">projet 1</div>
                        </td>
                        <td>
                            <div id="div-projectdescription-1">description 1</div>
                        </td>
                        <td>
                            <div id="div-projectartist-1">jeanclaude dupond</div>
                        </td>
                        <td>
                            <div id="div-projectprice-1">40</div>
                        </td>
                        <td>
                            <div id="div-projectimg-1"><img src=""></div>
                        </td>
                        <td>
                            <a data-id="1" href="#modal-project" role="button" class="button green edit-project" data-toggle="modal">Edit</a>
                            <a data-id="1" href="#modal-confirm" role="button" class="button red delete-project" data-toggle="modal">Supprimer</a>
                        </td>
                    </tr>
                </table>
                <div data-new-id="6" href="#modal-project" role="button" class="button green add-project" data-toggle="modal">Add Project</div>
            </div>
        </div>
    </div>
</section><!--  end content -->

<%@ include file="../static/modal-confirm.jsp" %>
<%@ include file="../static/modal-user.jsp" %>
<%@ include file="../static/modal-customer.jsp" %>
<%@ include file="../static/modal-product.jsp" %>
<%@ include file="../static/modal-project.jsp" %>

<%@ include file="../static/footer.jsp" %>
