<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/uselocale.jsp" %>


<html>
<head>
    <title><fmt:message key="title.result.page"/></title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form action="showTextInForm" method="post" class="form-horizontal">
                <input type="hidden" name="new_search" value="renew">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 col-md-offset-3">


                            <div class="container">
                                <div class="row">
                                    <div class="col-md-6 col-md-offset-15">
                                        <div class="form-group">

                                            <label for="text_content" class="col-sm-20 control-label"><fmt:message
                                                    key="register.form.titles"/></label>
                                            <div class="row-sm-18">
                         <textarea id="text_content" name="statistics" aria-setsize="300" class="form-control"
                                   placeholder="<fmt:message key="register.form.titles.placeholder"/>">


                             <c:out value='${statistics}'>


                             </c:out>

    <c:out value='${statistics2}'>


    </c:out>

                         </textarea>

                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button type="submit" class="btn btn-primary"><fmt:message key="search.form.go"/></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>


    <form class="form-horizontal">
        <input type="hidden" name="file_download" value="renew">
        <form  class="form-horizontal">
            <textarea id="toDownload" name="text">${statistics}</textarea>
            <input type="button" value="Download" onclick="download('toDownload', 'AllStats.csv')">
        </form>


    <form class="form-horizontal">
        <input type="hidden" name="file_download" value="renew">
        <form class="form-horizontal">
            <textarea id="toDownload2" name="text">${statistics2}</textarea>
            <input type="button" value="Download" onclick="download('toDownload2', 'SortedFirstTenDocs.csv')">
        </form>
    </form>
</form>
</nav>
<%--
<button onclick="history.go(-1)">
    Click here to go back
</button>
--%>
<%@ include file="../include/footer.jsp" %>

<script type="text/javascript" src="../js/downloader.js"></script>
</body>
</html>

