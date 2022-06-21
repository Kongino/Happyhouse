<template>
  <b-container>
    <b-row>
      <b-col>
        <h1 style="font-size: 60px">내 정보</h1>
      </b-col>
    </b-row>
    <b-row style="font-size: 20px">
      <b-col
        ><b-form @submit="onSubmit" @reset="onReset">
          <b-form-group id="id-group" label="아이디:" label-for="id">
            <b-form-input
              size="lg"
              disabled
              id="id"
              v-model="userInfo.id"
              type="text"
              required
            ></b-form-input>
          </b-form-group>
          <b-form-group id="email-group" label="이메일:" label-for="email">
            <b-form-input
              size="lg"
              disabled
              id="email"
              v-model="userInfo.email"
              type="text"
              required
            ></b-form-input>
          </b-form-group>
          <b-form-group
            id="password-group"
            label="비밀번호:"
            label-for="password"
            description="변경하실 비밀번호를 입력하세요."
          >
            <b-form-input
              id="password"
              size="lg"
              v-model="userInfo.password"
              type="text"
              required
            ></b-form-input>
          </b-form-group>
          <b-form-group
            id="phone-group"
            label="핸드폰 번호:"
            label-for="phone"
            description="변경하실 핸드폰 번호를 입력하세요."
          >
            <b-form-input
              id="phone"
              size="lg"
              v-model="userInfo.phone"
              type="text"
              required
            ></b-form-input>
          </b-form-group>
          <b-form-group
            id="address-group"
            label="주소:"
            label-for="address"
            description="변경하실 주소를 입력하세요."
          >
            <b-form-input
              id="address"
              size="lg"
              v-model="userInfo.address"
              type="text"
              required
            ></b-form-input>
          </b-form-group>
          <b-button type="submit" variant="primary" class="m-1" size="lg"
            >회원 정보 수정</b-button
          >
          <b-button type="reset" variant="danger" class="m-1" size="lg"
            >회원 탈퇴</b-button
          >
        </b-form>
      </b-col>
    </b-row>
    <!-- </b-container>
  <b-container class="mt-4" v-if="userInfo">
    <b-row>
      <b-col>
        <b-alert variant="secondary" show><h3>내정보</h3></b-alert>
      </b-col>
    </b-row>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <b-jumbotron>
          <template #header>My Page</template>

          <template #lead> 내 정보 확인페이지입니다. </template>

          <hr class="my-4" />

          <b-container class="mt-4">
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">아이디</b-col
              ><b-col cols="4" align-self="start">{{ userInfo.id }}</b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">이름</b-col
              ><b-col cols="4" align-self="start"
                ><b-input-group size="lg" prepend="이름">
                  <b-form-input
                    v-model="userInfo.name"
                  ></b-form-input> </b-input-group
              ></b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">이메일</b-col
              ><b-col cols="4" align-self="start"
                ><b-input-group size="lg" prepend="이메일">
                  <b-form-input
                    v-model="userInfo.email"
                  ></b-form-input> </b-input-group
              ></b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">핸드폰</b-col
              ><b-col cols="4" align-self="start"
                ><b-input-group size="lg" prepend="이메일">
                  <b-form-input
                    v-model="userInfo.phone"
                  ></b-form-input> </b-input-group
              ></b-col>
              <b-col cols="2"></b-col>
            </b-row>
            <b-row>
              <b-col cols="2"></b-col>
              <b-col cols="2" align-self="end">주소</b-col
              ><b-col cols="4" align-self="start"
                ><b-input-group size="lg" prepend="이메일">
                  <b-form-input
                    v-model="userInfo.address"
                  ></b-form-input> </b-input-group
              ></b-col>
              <b-col cols="2"></b-col>
            </b-row>
          </b-container>
          <hr class="my-4" />

          <b-button variant="primary" href="#" class="mr-1" @click="modifyUser"
            >정보수정</b-button
          >
          <b-button variant="danger" href="#" @click="withdrawalUser"
            >회원탈퇴</b-button
          >
        </b-jumbotron>
      </b-col>
      <b-col></b-col>
    </b-row> -->
  </b-container>
</template>

<script>
import { mapState } from "vuex";
import { modify, withdrawal } from "@/api/member.js";

export default {
  data() {
    return {};
  },
  name: "MemberMyPage",
  components: {},
  created() {},
  computed: {
    ...mapState("memberStore", ["userInfo"]),
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();
      console.log("수정");
      modify(
        this.userInfo,
        (response) => {
          console.log(response.data.userInfo);
          this.$store.commit(
            "memberStore/SET_USER_INFO",
            response.data.userInfo
          );
          alert("수정 완료!");
          this.$router.push({ name: "boardList" });
        },
        () => {}
      );
    },
    onReset() {
      withdrawal(
        this.userInfo.id,
        (response) => {
          console.log(response.data.message);
          this.$store.commit("memberStore/SET_USER_INFO", null);

          this.$router.push({ name: "boardList" });
          setTimeout(function () {
            window.location.reload();
          }, 100);
        },
        () => {}
      );
    },
  },
};
</script>

<style></style>
