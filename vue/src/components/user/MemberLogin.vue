<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <h1 style="font-size: 60px">로그인</h1>
      </b-col>
    </b-row>
    <b-row style="font-size: 20px">
      <b-col></b-col>
      <b-col cols="8">
        <b-card class="text-center mt-3" style="max-width: 40rem" align="left">
          <b-form class="text-left">
            <b-alert show variant="danger" v-if="isLoginError"
              >아이디 또는 비밀번호를 확인하세요.</b-alert
            >
            <b-form-group label="아이디:" label-for="id">
              <b-form-input
                size="lg"
                id="id"
                v-model="user.id"
                required
                placeholder="아이디 입력...."
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-form-group label="비밀번호:" label-for="userpwd">
              <b-form-input
                size="lg"
                type="password"
                id="userpwd"
                v-model="user.password"
                required
                placeholder="비밀번호 입력...."
                @keyup.enter="confirm"
              ></b-form-input>
            </b-form-group>
            <b-row align-h="end">
              <b-button
                size="lg"
                type="button"
                variant="primary"
                class="m-1"
                @click="confirm"
                >로그인</b-button
              >
              <b-button
                size="lg"
                type="button"
                variant="success"
                class="m-1"
                @click="movePage"
                >회원가입</b-button
              >
              <b-button
                size="lg"
                type="button"
                variant="info"
                class="m-1"
                @click="movePage2"
                >비밀번호 찾기</b-button
              >
            </b-row>
          </b-form>
        </b-card>
      </b-col>
      <b-col></b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapState, mapActions } from "vuex";

const memberStore = "memberStore";

export default {
  name: "MemberLogin",
  data() {
    return {
      user: {
        id: null,
        password: null,
      },
    };
  },
  computed: {
    ...mapState(memberStore, ["isLogin", "isLoginError"]),
  },
  methods: {
    ...mapActions(memberStore, ["userConfirm", "getUserInfo"]),
    async confirm() {
      await this.userConfirm(this.user);
      let token = sessionStorage.getItem("access-token");
      if (this.isLogin) {
        await this.getUserInfo(token);

        this.$router.push({ name: "home" });
        setTimeout(function () {
          window.location.reload();
        }, 100);
      }
    },
    movePage() {
      this.$router.push({ name: "signup" });
    },
    movePage2() {
      this.$router.push({ name: "find_pw" });
    },
  },
};
</script>

<style></style>
