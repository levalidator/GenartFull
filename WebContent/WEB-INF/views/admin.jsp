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
            <li class="active"><a href="#users" data-toggle="tab">Users</a></li>
            <li class=""><a href="#products" data-toggle="tab">Products</a></li>
            <li class=""><a href="#projects" data-toggle="tab">Process-projects</a></li>
        </ul>
        <div class="tab-content">
            <div class="tab-pane fade active in" id="users">
                <div class="span9">
                    <h3>Users List</h3>
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
                        <th>Is Artist</th>
                        <th>Is Admin</th>
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
	                            <div id="div-password-${ artist.getId() }">${ artist.getPassword() }</div>
	                        </td>
	                        <td>
	                            <div id="div-phone-${ artist.getId() }">${ artist.getPhone() }</div>
	                        </td>
	                        <td>
	                            <div id="div-web-${ artist.getId() }">${ artist.getPhone() }</div>
	                        </td>
	                        <td>
	                            <div id="div-isartist-${ artist.getId() }">Oui</div>
	                        </td>
	                        <td>
	                            <div id="div-isadmin-${ artist.getId() }">Oui</div>
	                        </td>
	                        <td>
	                            <a data-id="1" href="#modal-user" role="button" class="button green edit-user" data-toggle="modal">Edit</a>
	                            <a data-id="1" href="#modal-confirm" role="button" class="button red delete-user" data-toggle="modal">Supprimer</a>
	                        </td>
	                    </tr>
                    </c:forEach>
                    
                </table>
                
                <div data-new-id=${ requestScope['maxId'] } href="#modal-user" role="button" class="button green add-user" data-toggle="modal">Add User</div>
            
            </div>



            <div class="tab-pane fade active" id="products">
                <div class="span9">
                    <h3>Products List</h3>
                </div>
                <table  class="table table-striped">
                    <tr>
                        <th>Id</th>
                        <th>Nom</th>
                        <th>Prix</th>
                        <th>Description</th>
                        <th>Dimension X</th>
                        <th>Dimension Y</th>
                        <th>Dimension Z</th>
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
                        <th>Artiste_id</th>
                        <th>Prix</th>
                        <th>Image</th>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</section>

<%@ include file="../static/modal-confirm.jsp" %>
<%@ include file="../static/modal-user.jsp" %>
<%@ include file="../static/modal-product.jsp" %>
<%@ include file="../static/modal-project.jsp" %>

<%@ include file="../static/footer.jsp" %>
