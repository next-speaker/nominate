<table class="table table-striped">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">Team</th>
        <th scope="col">Members</th>
        <th scope="col">Actions</th>
    </tr>
    </thead>
    <tbody>
    <g:each status="i" in="${teams}" var="item">
        <tr>
            <th scope="row">${i}</th>
            <td>${item.description}</td>
            <td>${item.members.join(';')}</td>
            <td>
                <button type="button" class="btn btn-outline-primary openbutton"
                        data-teamid="${item.uuid}">Open</button>
                <button type="button" class="btn btn-outline-success deletebutton"
                        data-teamid="${item.uuid}">Delete</button>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>

<g:form class="form-inline" name="formAddTeam" action="save">
    <div class="container-fluid">
        <div class="row">
            <label for="description" class="form-label">Description</label>
            <input type="text" class="form-control" id="description" name="description" placeholder="Squad description">
        </div>

        <div class="row">
            <div class="col-6">
                <input type="text" class="form-control" name="members" placeholder="A name"><br/>
                <input type="text" class="form-control" name="members" placeholder="A name"><br/>
                <input type="text" class="form-control" name="members" placeholder="A name"><br/>
                <input type="text" class="form-control" name="members" placeholder="A name"><br/>
                <input type="text" class="form-control" name="members" placeholder="A name"><br/>
                <input type="text" class="form-control" name="members" placeholder="A name"><br/>
                <input type="text" class="form-control" name="members" placeholder="A name"><br/>
                <input type="text" class="form-control" name="members" placeholder="A name"><br/>
            </div>

            <div class="col-6">
                <input type="text" class="form-control" name="members" placeholder="A name"><br/>
                <input type="text" class="form-control" name="members" placeholder="A name"><br/>
                <input type="text" class="form-control" name="members" placeholder="A name"><br/>
                <input type="text" class="form-control" name="members" placeholder="A name"><br/>
                <input type="text" class="form-control" name="members" placeholder="A name"><br/>
                <input type="text" class="form-control" name="members" placeholder="A name"><br/>
                <input type="text" class="form-control" name="members" placeholder="A name"><br/>
                <input type="text" class="form-control" name="members" placeholder="A name"><br/>
            </div>
        </div>

        <div class="row">
            <div class="col-sm">
                <button type="submit" class="btn btn-primary mb-2" id="buttonAddTeam">Add</button>
            </div>
        </div>
    </div>
</g:form>
