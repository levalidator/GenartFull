
<div id="modal-user" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">X</button>
        <h3 id="modal-label-user">Edition de l'utilsateur</h3>
    </div>
    <div class="divider-slice"></div>
    <div class="modal-body">
        <div id="nameArtist-control-group" class="control-group">
            <label for="nameArtist" class="control-label">Nom  * : </label>
            <div class="controls">
                <input data-error-selector="nameArtist-message" type="text" id="nameArtist"  name="nameArtist" placeholder="Pr�nom"/>
                <span class="help-inline" style="display:none;" id="nameArtist-message"> Ce champ est obligatoire. </span>
            </div>
        </div>
        <div id="firstnameArtist-control-group" class="control-group">
            <label for="firstnameArtist" class="control-label">Pr�nom  * : </label>
            <div class="controls">
                <input data-error-selector="firstnameArtist-message" type="text" id="firstnameArtist"  name="firstnameArtist" placeholder="Pr�nom"/>
                <span class="help-inline" style="display:none;" id="firstnameArtist-message"> Ce champ est obligatoire. </span>
            </div>
        </div>
        <div id="mailArtist-control-group" class="control-group">
            <label for="mailArtist" class="control-label">E-mail  * : </label>
            <div class="controls">
                <input data-error-selector="mailArtist-message" type="text" id="mailArtist"  name="mailArtist" placeholder="user-mail@mail.com"/>
                <span class="help-inline" style="display:none;" id="mailArtist-message"> Veuillez entrer un E-mail valide. </span>
            </div>
        </div>
        <div id="passwordArtist-control-group" class="control-group">
            <label for="passwordArtist" class="control-label">Mot de passe * : </label>
            <div class="controls">
                <input data-error-selector="passwordArtist-message" type="password" id="passwordArtist"  name="passwordArtist" placeholder="user-passe"/>
                <span class="help-inline" style="display:none;" id="passwordArtist-message"> Ce champ est obligatoire. </span>
            </div>
        </div>
        <div id="passwordArtistConfirm-control-group" class="control-group">
            <label for="passwordArtistConfirm" class="control-label">Confirmation  * : </label>
            <div class="controls">
                <input data-error-selector="passwordArtistConfirm-message" type="password" id="passwordArtistConfirm"  name="passwordArtistConfirm" placeholder="Confirmation"/>
                <span class="help-inline" style="display:none;" id="passwordArtistConfirm-message"> Les deux mots de passes sont diff�rents. </span>
            </div>
        </div>
        <div id="phoneArtist-control-group" class="control-group">
            <label for="phoneArtist" class="control-label">T�l�phone  * : </label>
            <div class="controls">
                <input data-error-selector="phoneArtist-message" type="text" id="phoneArtist"  name="phoneArtist" placeholder="T�l�phone"/>
                <span class="help-inline" style="display:none;" id="phoneArtist-message"> Ce champ est obligatoire. </span>
            </div>
        </div>
        <div id="websiteArtist-control-group" class="control-group">
            <label for="websiteArtist" class="control-label">Site web : </label>
            <div class="controls">
                <input data-error-selector="websiteArtist-message" type="text" id="websiteArtist"  name="websiteArtist" placeholder="www.user-site.com"/>
                <span class="help-inline" style="display:none;" id="websiteArtist-message">  </span>
            </div>
        </div>
    </div>
    <div class="modal-footer">
        <div class="button red" data-dismiss="modal" aria-hidden="true">Annuler</div>
        <div id="valid-user" data-newuser="false" data-dismiss="modal" class="button green">Valider</div>
    </div>
</div>