<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="../include/uselocale.jsp" %>


<html>
<head>
    <script type="text/javascript" src="../js/downloader.js"></script>
    <title><fmt:message key="title.register.page"/></title>
    <link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>



<div class="container">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <form action="addTextIn" method="post" class="form-horizontal">
                <input type="hidden" name="text_in" value="new">

                <div class="form-group">
                    <label for="text_inForm" class="col-sm-3 control-label"><fmt:message key="register.form.text.title"/></label>
                    <div class="col-sm-9">
                        <input type="text" id="text_inForm" name="text_title" path="text_path" class="form-control" placeholder="<fmt:message key="register.form.text.title.placeholder"/>">

</div>
                </div>
<div class="form-group">
                            <label for="text_inForm" class="col-sm-3 control-label"><fmt:message key="register.form.text.path"/></label>
                            <div class="col-sm-9">
                        <input type="text" id="text_pathForm" name="text_url"  class="form-control" placeholder="<fmt:message key="register.form.text.path.placeholder"/>">
    </div>
    </div>

                <div class="form-group">
                    <label for="text_inForm" class="col-sm-3 control-label"><fmt:message key="register.form.titles"/></label>
                    <div class="col-sm-30">
                        <div class="row-sm-50">


                    </div>
                </div>

                        <div class="container-fluid">

                                <input type="hidden" >
                                <select title="locale" name="language" class="form-control input-sm"
                                        onchange="if (this.selectedIndex) this.form.submit ()">
                                    <option><fmt:message key="footer.language"/></option>
                                    <option value="English">English</option>
                                    <option value="Russian">Russian</option>
                                </select>

                        </div>
                    </nav>
                <div class="form-group">
                    <div class="col-sm-offset-3 col-sm-9">
                        <button type="submit" class="btn btn-primary"><fmt:message key="register.form.transform"/></button>
                    </div>
        </div>
                </div>
            </form></div>
    </div>
</div>
</div>
</div>
</body>
<%@ include file="../include/footer.jsp" %>
</body>
</html>

