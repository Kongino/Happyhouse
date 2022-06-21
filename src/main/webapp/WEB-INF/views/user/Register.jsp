<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />

    <title>Register</title>

    <link
      href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
      rel="stylesheet"
    />

    <!-- Custom styles for this template-->
    <link href="${root}/css/sb-admin-2.min.css" rel="stylesheet" />
  </head>

  <body class="bg-gradient-primary">
    <div class="container">
      <div class="card o-hidden border-0 shadow-lg my-5">
        <div class="card-body p-0">
          <!-- Nested Row within Card Body -->
          <div class="row">
            <div class="col-lg-5 d-none d-lg-block bg-register-image"></div>
            <div class="col-lg-7">
              <div class="p-5">
                <div class="text-center">
                  <h1 class="h4 text-gray-900 mb-4">Create an Account!</h1>
                </div>
                <form id="registerform" class="user" method="post" action="">
                  <input name="act" value="register" hidden/>
                  <div class="form-group row">
                    <div class="col-sm-12 mb-3 mb-sm-0">
                      <input
                        type="text"
                        class="form-control form-control-user"
                        name="name"
                        id="name"
                        placeholder="Name"
                      />
                    </div>
                  </div>
                  <div class="form-group">
                    <input
                      type="text"
                      class="form-control form-control-user"
                      name="id"
                      id="id"
                      placeholder="ID"
                    />
                  </div>
                  <div class="form-group row">
                    <div class="col-sm-12 mb-3 mb-sm-0">
                      <input
                        type="password"
                        class="form-control form-control-user"
                        name="password"
                        id="password"
                        placeholder="Password"
                      />
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-sm-12 mb-3 mb-sm-0">
                      <input
                        type="email"
                        class="form-control form-control-user"
                        name="email"
                        id="email"
                        placeholder="Email"
                      />
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-sm-12 mb-3 mb-sm-0">
                      <input
                        type="text"
                        class="form-control form-control-user"
                        name="address"
                        id="address"
                        placeholder="Address"
                      />
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="col-sm-12 mb-3 mb-sm-0">
                      <input
                        type="number"
                        class="form-control form-control-user"
                        name="phone"
                        id="phone"
                        placeholder="Phone Number"
                      />
                    </div>
                  </div>
                  <button
                    id="register-btn"
                    type="submit"
                    class="btn btn-primary btn-user btn-block"
                  >
                    Register Account
                  </button>
                </form>
                <hr />
                <div class="text-center">
                  <a class="small" href="${root}/member/forgot"
                    >Forgot Password?</a
                  >
                </div>
                <div class="text-center">
                  <a class="small" href="${root}/member/login"
                    >Already have an account? Login!</a
                  >
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
    $(document).ready(function () {
        $("#register-btn").click(function () {
        	if(!$("#name").val()) {
        		alert("이름을 입력하세요.")
        	} else if (!$("#id").val()) {
                alert("아이디를 입력하세요.");
                return;
            } else if (!$("#password").val()) {
                alert("비밀번호를 입력하세요.");
                return;
            } else if (!$("#email").val()) {
                alert("이메일을 입력하세요.");
                return;
            } else if (!$("#address").val()) {
                alert("주소를 입력하세요.");
                return;
            } else if (!$("#phone").val()) {
                alert("전화번호를 입력하세요.");
                return;
            }
            else {
                $("#registerform").attr("action", "${root}/member/register").submit();
            }
        });
    });
    </script>
  </body>
</html>
