import Vue from "vue";
import VueRouter from "vue-router";

import MemberView from "@/views/MemberView.vue";
import MemberLogin from "@/components/user/MemberLogin.vue";
import MemberRegister from "@/components/user/MemberRegister.vue";
import MemberMyPage from "@/components/user/MemberMyPage.vue";
import BoardList from "@/components/board/BoardList.vue";
import BoardRegister from "@/components/board/BoardRegister.vue";
import BoardDetail from "@/components/board/BoardDetail.vue";
import BoardModify from "@/components/board/BoardModify.vue";
import QnaList from "@/components/qna/QnaList.vue";
import QnaRegist from "@/components/qna/QnaRegist.vue";
import QnaDetail from "@/components/qna/QnaDetail.vue";
import QnaModify from "@/components/qna/QnaModify.vue";
import MemberFindPw from "@/components/user/MemberFindPw.vue";

// import store from "@/store/index.js";
// import memberStore from "@/store/modules/memberStore.js";

Vue.use(VueRouter);

// const onlyAuthUser = async (to, from, next) => {
//   // console.log(store);
//   const checkUserInfo = store.getters["memberStore/checkUserInfo"];
//   let token = sessionStorage.getItem("access-token");
//   if (checkUserInfo == null && token) {
//     await memberStore.actions.getUserInfo(token);
//   }
//   if (checkUserInfo === null) {
//     alert("로그인이 필요한 페이지입니다..");
//     next({ name: "signIn" });
//     // router.push({ name: "signIn" });
//   } else {
//     // console.log("로그인 했다.");
//     next();
//   }
// };

const routes = [
  // {
  //   path: "/",
  //   name: "home",
  //   redirect: "/happyhouse/member/login",
  // },
  {
    path: "/",
    name: "home",
    redirect: "/board/list",
  },
  {
    path: "/member",
    name: "user",
    component: MemberView,
    children: [
      {
        path: "login",
        name: "signIn",
        component: MemberLogin,
      },
      {
        path: "register",
        name: "signup",
        component: MemberRegister,
      },
      {
        path: "mypage",
        name: "mypage",
        // beforeEnter: onlyAuthUser,
        component: MemberMyPage,
      },
      {
        path: "find_pw",
        name: "find_pw",
        component: MemberFindPw,
      },
    ],
  },
  {
    path: "/board/list",
    name: "boardList",
    component: BoardList,
  },
  {
    path: "/board/write",
    name: "boardRegister",
    // beforeEnter: onlyAuthUser,
    component: BoardRegister,
  },
  {
    path: "/board/detail/:articleno",
    name: "boardDetail",
    // beforeEnter: onlyAuthUser,
    component: BoardDetail,
  },
  {
    path: "/board/modify/:articleno",
    name: "boardModify",
    // beforeEnter: onlyAuthUser,
    component: BoardModify,
  },
  {
    path: "/vueqna",
    redirect: "/vueqna/qna/qnalist",
  },

  {
    path: "/vueqna/qna/qnalist",
    name: "QnaList",
    component: QnaList,
  },
  {
    path: "/vueqna/qna/qnaregist",
    name: "QnaRegist",
    component: QnaRegist,
  },
  {
    path: "/vueqna/qna/qnadetail",
    name: "QnaDetail",
    component: QnaDetail,
  },
  {
    path: "/vueqna/qna/qnamodify",
    name: "QnaModify",
    component: QnaModify,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
