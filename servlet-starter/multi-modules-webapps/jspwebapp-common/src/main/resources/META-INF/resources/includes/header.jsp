<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">HelloApp</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li id="system-info"><a href="${pageContext.request.contextPath}/secured/system-info.jsp">SystemInfo</a></li>
                <li id="about"><a href="${pageContext.request.contextPath}/about.jsp">About</a></li>
                <% if (request.getUserPrincipal() != null) { %>
                <li id="logout"><a href="${pageContext.request.contextPath}/secured/logout.jsp">
                    Logout (<%= request.getUserPrincipal().getName() %>)</a></li>
                <% } %>
            </ul>
        </div><!--/.nav-collapse -->
    </div>
</nav>