<%-- 
    Document   : login
    Created on : Jul 15, 2018, 4:06:15 PM
    Author     : newbiecihuy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<style>
    form {
        border: 3px solid #f1f1f1;
    }

    input[type=text], input[type=password] {
        width: 40%;
        padding: 12px 20px;
        margin: 8px 0;
        display: inline-block;
        border: 1px solid #ccc;
        box-sizing: border-box;
    }

    button {
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        cursor: pointer;
        width: 15%;
    }
    .submbtn {
        width: auto;
        padding: 10px 18px;
        background-color: #4CAF50;
    }
    button:hover {
        opacity: 0.8;
    }

    .cancelbtn {
        width: auto;
        padding: 10px 18px;
        background-color: #f44336;
    }

    .imgcontainer {
        text-align: center;
        margin: 24px 0 12px 0;
    }

    img.avatar {
        width: 40%;
        border-radius: 50%;
    }

    .container {
        padding: 16px;
    }

    span.psw {
        float: right;
        padding-top: 16px;
    }

    /* Change styles for span and cancel button on extra small screens */
    @media screen and (max-width: 300px) {
        span.psw {
            display: block;
            float: none;
        }
        .cancelbtn {
            width: 100%;
        }
    }
</style>


<body>
    <!--<link rel="stylesheet" type="text/css" href="<=request.getContextPath() %>/css/auth.css" />-->  
    <!--<div class="span6  offset1 well">-->
    <!--<meta http-equiv="refresh" content="0; url=https://158.140.175.119:7090/FieldServiceSolution/home/index.jsp">-->
    <script type="text/javascript">
        function validate() {
            var nama = document.login.j_username.value;
            var paswd = document.login.j_password.value;
            if (nama === "") {
                alert("User Name Field is Empty");
                document.login.j_username.focus();
                return false;
            }
            else if (paswd === "") {
                alert("Password Field is Empty");
                document.login.j_password.focus();
                return false;
            }
        }
    </script>
    <!--<center>-->
    <!--<div class="login">-->
    <!-- did we already try to login and it failed? -->
    <!--<c:if test="false">-->
    <!--            <div class="authError">
                    Invalid User Name or Password. Please try again.
                </div>-->
    <!--</c:if>-->

    <!--        <form name="login" id="login" action="j_security_check" method="post" onSubmit="return validate()">
                <fieldset>
                    <legend>Login</legend>
    
                    <div>
                        <label for="email">User Name</label> 
                        <input type="text" id="j_username" name="j_username"/>
                    </div>
                    <div>
                        <label for="password">Password</label> 
                        <input type="password" id="j_password" name="j_password"/>
                    </div>
    
                    <div class="buttonRow">
                        <input type="submit" id="cryptstr" name="cryptstr" value="Login" />
                    </div>
    
                </fieldset>
            </form> -->



    <!--</div>-->


    <form name="login" id="login" action="j_security_check" method="post" onSubmit="return validate()">
        <!--        <div class="imgcontainer">
                    <img src="img_avatar2.png" alt="Avatar" class="avatar">
                </div>-->
        <fieldset>
            <div class="container">
                <label><b>Username</b></label>
                <input type="text" placeholder="Username" id='j_username' name='j_username' required><br/>

                <label><b>Password</b></label>
                <input type="password" placeholder="Password" id='j_password' name="j_password" required>

                <button type="submit" class="submbtn">Login</button>
                <!--<input type="checkbox" checked="checked"> Remember me-->
            </div>

            <div class="container" style="background-color:#f1f1f1">
                <button type="reset" class="cancelbtn">Cancel</button>
                <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
        </fieldset>
    </form>

    <!--</center>-->
    <script type="text/javascript" src="../js/sha256.js"></script>
    <script type="text/javascript">
        //    http://coursesweb.net/javascript/sha256-encrypt-hash_cs
        // Here add the code of SHA256 function

        // register onclick events for Encrypt button
        document.getElementById('j_password').onblur = function () {
            //                if (document.getElementById('j_password').value !== '') {
            var txt_string = document.getElementById('j_password').value;      // gets data from input text

            // encrypts data and adds it in #strcrypt element
            document.getElementById('j_password').value = SHA256(txt_string);
            //                }
            return false;
        };
    </script>
</body>