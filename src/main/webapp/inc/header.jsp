<%-- 
    Document   : header
    Created on : Jul 15, 2018, 3:21:47 PM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="ROBOTS" content="NOINDEX, NOFOLLOW">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="newbiecihuy">
        <%-- <meta http-equiv="refresh" content="0;url=index.jsp">--%>
        <title>.: PT Tanata Prima Jaya :.</title>
        <!--<link rel="Shortcut icon" href="https://www.codester.com/static/favicon.ico" />-->
        <link rel="Shortcut icon" href="https://png.icons8.com/nolan/2x/general-electrics.png"/>
        <!-- Bootstrap Core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <!-- Style CSS -->
        <link href="vendor/css/style.css" rel="stylesheet" type="text/css">
        <!-- Jquery UI css-->
        <link rel="stylesheet" href="vendor/jquery-ui-1.12.1.custom/jquery-ui.css" type="text/css" />
        <link rel="stylesheet" href="vendor/jquery-ui-1.12.1.custom/jquery-ui.theme.css" type="text/css" />
        <script src="vendor/jquery/jquery.min.js"></script>
        <!-- ### -->

        <link rel="stylesheet" href="vendor/bootstrap_v3.3.6/css/bootstrap.min.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="vendor/bootstrap_v3.3.6/css/bootstrap-theme.min.css" type="text/css" media="screen" />

        <link rel="stylesheet" href="vendor/jquery_dataTables/1.10.12/css/dataTables.bootstrap.min.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="vendor/jquery_dataTables/2.1.0/css/responsive.dataTables.min.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="vendor/jquery_dataTables/2.1.0/css/responsive.bootstrap.min.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="vendor/jquery_dataTables/css/jquery.dataTables.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="vendor/jquery_dataTables/css/jquery.dataTables.min.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="vendor/jquery_dataTables/1.2.0/css/select.dataTables.min.css" type="text/css" media="screen" />
        <link rel="stylesheet" href="vendor/jquery_dataTables/1.2.2/buttons.dataTables.min.css" type="text/css" media="screen" />
        <!-- -->
        <script type="text/javascript" src="vendor/jquery_dataTables/1.12.3/jquery-1.12.3.js"></script>
        <script type="text/javascript" src="vendor/js/jquery.json-2.6.0.min.js"></script>
        <script type="text/javascript" src="vendor/jquery_dataTables/1.10.12/jquery.dataTables.min.js"></script>
        <script type="text/javascript" src="vendor/jquery_dataTables/2.1.0/js/dataTables.responsive.min.js"></script>
        <script type="text/javascript" src="vendor/jquery_dataTables/2.1.0/js/responsive.bootstrap.min.js"></script>
        <script type="text/javascript" src="vendor/jquery_dataTables/1.2.0/js/dataTables.select.min.js"></script>
        <script type="text/javascript" src="vendor/jquery_dataTables/1.2.2/js/dataTables.buttons.min.js"></script>
        <!-- Jquery UI js-->
        <script type="text/javascript" src="vendor/jquery-ui-1.12.1.custom/jquery-ui.js"></script>

        <!--end--> 

        <script type="text/javascript" src="vendor/bootstrap/js/bootstrap.min.js"></script>

        <!-- MetisMenu CSS -->
        <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

        <!-- Custom CSS -->
        <link href="dist/css/sb-admin-2.css" rel="stylesheet">

        <!--         Morris Charts CSS 
                <link href="vendor/morrisjs/morris.css" rel="stylesheet">-->
        <!-- Custom Fonts -->
        <!-- use font-awesome-4.7.0-->
        <link href="vendor/font-awesome-4.7.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet" type="text/css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->
        <!--auto complate -->
        <!--<script type="text/javascript" src="vendor/js/jquery.autocomplete.js"></script>-->
        <link rel="stylesheet" href="vendor/css/jquery.autocomplete.css" type="text/css" media="screen"/>
        <link rel="stylesheet" href="vendor/css/jquery.steps.css" type="text/css" media="screen"/>
        <!-- -->
        <script type="text/javascript" src="vendor/js/jquery.cookie-1.3.1.js" ></script>
        <script type="text/javascript" src="vendor/js/hideshow.js" ></script>
        <script type="text/javascript" src="vendor/js/jquery.tablesorter.min.js"></script>
        <script type="text/javascript" src="vendor/js/jquery.equalHeight.js"></script>
        <script type="text/javascript" src="vendor/js/validation.js"></script>
        <script type="text/javascript" src="vendor/js/contextMenu.js"></script>
        <script type="text/javascript" src="vendor/js/jquery.steps.js"></script>
        <script type="text/javascript" src="vendor/js/clock.js"></script>
        <script type="text/javascript" src="vendor/js/sha256.js"></script>
        <script type="text/javascript" src="vendor/js/md5.js"></script>
        <!--<script type="text/javascript" src="vendor/js/crypto_js_v3.1.2/aes.js"></script>-->
        <!--        <script type="text/javascript">
                    if (!('console' in window) || !('firebug' in console)) {
                        var names = ['log', 'debug', 'info', 'warn', 'error', 'assert', 'dir', 'dirxml', 'group', 'groupEnd', 'time', 'timeEnd', 'count', 'trace', 'profile', 'profileEnd'];
                        window.console = {};
                        for (var i = 0; i < names.length; ++i)
                            window.console[names[i]] = function () {
                            };
                    }
                </script>-->
    </head>