<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <title>HappyHouse</title>
    <link
      href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
      rel="stylesheet"
    />

    <link href="css/sb-admin-2.min.css" rel="stylesheet" />
  </head>
  <body id="page-top">
    <div id="wrapper">
      <ul
        class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion"
        id="accordionSidebar"
      >
        <!-- Sidebar - Brand -->
        <a
          class="sidebar-brand d-flex align-items-center justify-content-center"
          href="index.html"
        >
          <div class="sidebar-brand-icon">
            <img
              src="./img/Home_Icon.svg"
              alt="logo"
              width="50px"
              height="50px"
            />
          </div>
          <div class="sidebar-brand-text mx-3">HappyHouse</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider" />

        <!-- Heading -->
        <div class="sidebar-heading">Menu</div>

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
          <a class="nav-link collapsed" href="./notice.html">
            <img
              class="mr-3"
              src="./img/notice.svg"
              alt=""
              width="15px"
              height="15px"
            />
            <span>Notice</span>
          </a>
        </li>

        <!-- Nav Item - Utilities Collapse Menu -->
        <li class="nav-item">
          <a class="nav-link collapsed" href="./enroll-area.html">
            <img
              class="mr-3"
              src="./img/interest.svg"
              alt=""
              width="15px"
              height="15px"
            />
            <span>관심 지역 추가</span>
          </a>
        </li>
      </ul>
      <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
          <!-- Topbar -->
          <nav
            class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow"
          >
            <!-- Sidebar Toggle (Topbar) -->
            <button
              id="sidebarToggleTop"
              class="btn btn-link d-md-none rounded-circle mr-3"
            >
              <i class="fa fa-bars"></i>
            </button>

            <!-- Topbar Search -->
            <form
              class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100"
            >
              <div class="input-group">
                <input
                  name="date"
                  id="date-input"
                  type="number"
                  class="form-control bg-light border-0 small"
                  placeholder="Search by Date..."
                />
                <div class="input-group-append">
                  <button
                    id="date-search-btn"
                    class="btn btn-primary"
                    type="button"
                  >
                    <img
                      src="./img/search.svg"
                      alt=""
                      width="20px"
                      height="20px"
                    />
                  </button>
                </div>
              </div>
            </form>
            <form
              class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100"
            >
              <div class="input-group">
                <input
                  name="dong"
                  id="dong-input"
                  type="text"
                  class="form-control bg-light border-0 small"
                  placeholder="Search by Dong..."
                />
                <input
                  name="apt"
                  id="apt-input"
                  type="text"
                  class="form-control bg-light border-0 small"
                  placeholder="Search by Apt Name..."
                />
                <div class="input-group-append">
                  <button id="filter-btn" class="btn btn-warning" type="button">
                    <img
                      src="./img/search.svg"
                      alt=""
                      width="20px"
                      height="20px"
                    />
                  </button>
                </div>
              </div>
            </form>

            <!-- Topbar Navbar -->
            <ul class="navbar-nav ml-auto">
              <!-- Nav Item - User Information -->
              <li class="nav-item dropdown no-arrow">
                <a
                  class="nav-link dropdown-toggle"
                  href="#"
                  id="userDropdown"
                  role="button"
                  data-toggle="dropdown"
                  aria-haspopup="true"
                  aria-expanded="true"
                >
                  <span
                    id="user-name"
                    class="mr-2 d-none d-lg-inline text-gray-600 small"
                    >Guest</span
                  >
                  <img
                    class="img-profile rounded-circle"
                    src="img/undraw_profile.svg"
                  />
                </a>
                <!-- Dropdown - User Information -->
                <div
                  class="user-menu dropdown-menu dropdown-menu-right shadow animated--grow-in"
                  aria-labelledby="userDropdown"
                >
                  <a class="dropdown-item" href="./profile.html"> Profile </a>
                  <div class="dropdown-divider"></div>
                  <button class="dropdown-item" id="logout-btn">Logout</button>
                </div>
                <div
                  class="user-menu dropdown-menu dropdown-menu-right shadow animated--grow-in state"
                  aria-labelledby="userDropdown"
                >
                  <a class="dropdown-item" href="./login.html"> Login </a>
                </div>
              </li>
            </ul>
          </nav>
          <!-- End of Topbar -->

          <!-- Begin Page Content -->
          <div class="container-fluid">
            <div class="row">
              <div id="map-view" class="col-8">
                <div id="map" style="width: 100%; height: 100%">
                  <script
                    type="text/javascript"
                    src="//dapi.kakao.com/v2/maps/sdk.js?appkey=8b8e226a924c6a70afe72cef0da03d65&libraries=services"
                  ></script>
                </div>
              </div>
              <div class="col-4">
                <div class="card mb-4">
                  <div class="card-header">상세 정보</div>
                  <div id="detail-view" class="card-body"></div>
                </div>
                <div
                  id="color-information"
                  class="card p-1 text-center font-weight-bold text-dark"
                >
                  <div class="border-left-primary card mb-1">아파트 매매</div>
                  <div class="border-left-warning card mb-1">
                    아파트 전,월세
                  </div>
                  <div class="border-left-danger card mb-1">
                    연립다세대 매매
                  </div>
                  <div class="border-left-info card">연립다세대 전,월세</div>
                </div>
              </div>
            </div>

            <div id="data-list" class="row"></div>
          </div>
          <!-- /.container-fluid -->
        </div>
        <!-- End of Main Content -->

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
          <div class="container my-auto">
            <div class="copyright text-center my-auto">
              <span>Copyright &copy; SSAFY 16</span>
            </div>
          </div>
        </footer>
        <!-- End of Footer -->
      </div>
      <!-- End of Content Wrapper -->
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="./js/index.js"></script>
  </body>
</html>
