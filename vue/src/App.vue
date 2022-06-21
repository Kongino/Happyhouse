<template>
  <div id="app">
    <b-container
      id="background"
      class="bv-example-row"
      :style="{
        backgroundImage: 'url(' + require('@/assets/banner3.png') + ')',
      }"
    >
      <!-- margin: 10px;  -->
      <b-row align-h="center"
        ><h1
          style="
            width: 500px;
            height: 200px;
            padding-top: 50px;
            padding-bottom: 50px;
            font-size: 80px;
            color: white;
            text-shadow: -2px 0 #000, 0 2px #000, 2px 0 #000, 0 -2px #000;
          "
        >
          COMMUNITY
        </h1></b-row
      >
      <div style="margin: 20px">
        <template v-if="userInfo">
          <div style="position: fixed; top: 5em; right: 1em">
            <b-button pill size="lg"
              ><router-link
                style="text-decoration-line: none; color: white"
                :to="{ name: 'mypage' }"
                class="link align-self-end"
                ><b-icon icon="book"></b-icon> 내 정보</router-link
              ></b-button
            >
            <b-button
              size="lg"
              style="color: white; margin-left: 10px"
              pill
              @click.prevent="onClickLogout"
              ><b-icon icon="arrow-up-right"></b-icon> 로그아웃</b-button
            >
          </div>
        </template>
        <template v-else>
          <div style="position: fixed; top: 5em; right: 1em">
            <b-button pill size="lg"
              ><router-link
                style="text-decoration-line: none; color: white"
                :to="{ name: 'signup' }"
                ><b-icon icon="person-circle"></b-icon> 회원가입</router-link
              ></b-button
            >
            <b-button pill size="lg" style="margin-left: 10px"
              ><router-link
                style="text-decoration-line: none; color: white"
                :to="{ name: 'signIn' }"
                class="link"
                ><b-icon icon="key"></b-icon> 로그인</router-link
              ></b-button
            >
          </div>
        </template>
      </div>
      <b-row align-h="center"
        ><b-col cols="2"
          ><router-link
            :to="{ name: 'boardList' }"
            style="
              font-size: x-large;
              color: white;
              text-shadow: -1px 0 #000, 0 1px #000, 1px 0 #000, 0 -1px #000;
              text-decoration-line: none;
            "
            >공지사항</router-link
          >
        </b-col>
        <b-col cols="2"
          ><router-link
            :to="{ name: 'QnaList' }"
            style="
              font-size: x-large;
              color: white;
              text-shadow: -1px 0 #000, 0 1px #000, 1px 0 #000, 0 -1px #000;
              text-decoration-line: none;
            "
            >Q&A</router-link
          ></b-col
        ></b-row
      >
    </b-container>
    <router-view style="margin-top: 3rem" />
  </div>
</template>

<script>
import { mapState, mapMutations } from "vuex";
import axios from "axios";

const memberStore = "memberStore";

export default {
  computed: {
    ...mapState(memberStore, ["isLogin", "userInfo"]),
  },
  methods: {
    ...mapMutations(memberStore, ["SET_IS_LOGIN", "SET_USER_INFO"]),
    onClickLogout() {
      // console.log("memberStore : ", ms);
      this.SET_IS_LOGIN(false);
      this.$store.commit("memberStore/SET_USER_INFO", null);
      sessionStorage.removeItem("access-token");
      axios({
        url: "http://localhost:8080/happyhouse/member/logout",
        method: "get",
      })
        .then(() => {
          alert("로그 아웃 완료!");

          this.$router.push({ name: "boardList" });
          setTimeout(function () {
            window.location.reload();
          }, 100);
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
};
</script>

<style>
@import url("https://fonts.googleapis.com/css2?family=Jua&display=swap");
#app {
  font-family: "Jua", sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#background {
  background-repeat: no-repeat;
  background-position: center;
  background-size: 700px;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
