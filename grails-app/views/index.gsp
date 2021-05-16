<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to Grails</title>
</head>

<body>
<content tag="nav">
    <sec:ifNotLoggedIn>
        <g:render template="/auth/loginWithGoogle"/>
    </sec:ifNotLoggedIn>
    <sec:ifLoggedIn>
        <g:form controller="logout" style="display: inline;">
            <input type="submit" value="${g.message(code: "logout", default: "Logout")}"/>
        </g:form>
    </sec:ifLoggedIn>
</content>

<div id="content" role="main">
    <sec:ifNotLoggedIn>
        <section class="row colset-2-its">
            <h1>Welcome to Nominate</h1>

            <p>
                "Nominate" is a free application where you can create teams with the members of your squads and
                generate, in a random way, the order of who will talk in the daily
            </p>
        </section>
    </sec:ifNotLoggedIn>
    <sec:ifLoggedIn>
        <section class="row colset-2-its">
            <g:include controller="team" action="list" />
        </section>
    </sec:ifLoggedIn>
</div>

</body>
</html>
