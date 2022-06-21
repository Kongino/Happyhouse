<template>
  <div>
    <b-container>
      <b-row>
        <b-col>
          <h1 style="font-size: 60px">비밀번호 찾기</h1>
        </b-col>
      </b-row>
      <b-row style="font-size: 20px">
        <b-col>
          <b-form @submit="onSubmit" @reset="onReset">
            <b-form-group
              id="id-group"
              label="아이디:"
              label-for="id"
              description="아이디를 입력하세요."
            >
              <b-form-input
                size="lg"
                id="id"
                v-model="id"
                type="text"
                required
                placeholder="아이디 입력..."
              ></b-form-input>
            </b-form-group>
            <b-form-group
              id="email-group"
              label="이메일:"
              label-for="email"
              description="이메일을 입력하세요."
            >
              <b-form-input
                size="lg"
                id="email"
                type="text"
                v-model="email"
                required
                placeholder="이메일 입력..."
              ></b-form-input>
            </b-form-group>
            <b-button size="lg" type="submit" variant="primary" class="m-1"
              >임시 비밀번호 발급</b-button
            >
            <b-button size="lg" type="reset" variant="danger" class="m-1"
              >로그인</b-button
            >
          </b-form>
        </b-col>
      </b-row>
    </b-container>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      id: "",
      email: "",
    };
  },
  methods: {
    onSubmit(event) {
      event.preventDefault();

      axios
        .post("http://localhost:8080/happyhouse/member/find_pw", {
          id: this.id,
          email: this.email,
        })
        .then((response) => {
          console.log(response.data.result);
          let msg = "";
          if (response.data.result == 1) {
            msg = "아이디 체크 불가";
          } else if (response.data.result == 2) {
            msg = "이메일 체크 불가";
          } else if (response.data.result == 3) {
            msg = "임시 비밀번호를 발송하였습니다.";
          }
          alert(msg);
          this.$router.push({ name: "signIn" });
        })
        .catch((error) => {
          console.log(error);
        });
    },
    onReset() {
      this.$router.push({ name: "signIn" });
    },
  },
};
</script>

<style></style>
