<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <h1 style="font-size: 60px">회원 가입</h1>
        <b-form style="font-size: 20px" @submit="onSubmit" @reset="onReset">
          <b-form-group
            id="id-group"
            label="아이디:"
            label-for="id"
            description="아이디를 입력하세요."
          >
            <b-form-input
              size="lg"
              @blur="id_check"
              id="id"
              v-model="userInfo.id"
              type="text"
              required
              placeholder="아이디 입력..."
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="subject-group"
            label="비밀번호:"
            label-for="password"
            description="비밀번호 입력하세요."
          >
            <b-form-input
              size="lg"
              id="subject"
              v-model="userInfo.password"
              type="password"
              required
              placeholder="비밀번호 입력..."
            ></b-form-input>
          </b-form-group>

          <b-form-group id="content-group" label="이름:" label-for="name">
            <b-form-textarea
              size="lg"
              id="name"
              v-model="userInfo.name"
              placeholder="이름 입력..."
              type="text"
              required
            ></b-form-textarea>
          </b-form-group>

          <b-form-group id="content-group" label="이메일:" label-for="email">
            <b-form-textarea
              size="lg"
              @blur="email_check"
              id="email"
              v-model="userInfo.email"
              placeholder="이메일 입력..."
              type="email"
              required
            ></b-form-textarea>
          </b-form-group>

          <b-form-group
            id="content-group"
            label="핸드폰 번호:"
            label-for="phone"
          >
            <b-form-textarea
              size="lg"
              id="phone"
              v-model="userInfo.phone"
              placeholder="핸드폰 번호 입력..."
              type="text"
              required
            ></b-form-textarea>
          </b-form-group>

          <b-form-group id="content-group" label="주소:" label-for="address">
            <b-form-textarea
              size="lg"
              id="address"
              v-model="userInfo.address"
              placeholder="주소 입력..."
              type="text"
              required
            ></b-form-textarea>
          </b-form-group>

          <b-button size="lg" type="submit" variant="primary" class="m-1"
            >회원 가입</b-button
          >
          <b-button size="lg" type="reset" variant="danger" class="m-1"
            >초기화</b-button
          >
        </b-form>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { memberRegister } from "@/api/member.js";
import axios from "axios";

export default {
  name: "MemberRegister",
  data() {
    return {
      userInfo: {
        id: "",
        password: "",
        name: "",
        email: "",
        phone: "",
        address: "",
      },
    };
  },
  created() {},
  methods: {
    onSubmit(event) {
      event.preventDefault();

      let err = true;
      let msg = "";
      !this.userInfo.id &&
        ((msg = "아이디를 입력해주세요"), (err = false), this.$refs.id);
      err &&
        !this.userInfo.password &&
        ((msg = "비밀번호를 입력해주세요"), (err = false), this.$refs.subject);
      err &&
        !this.userInfo.name &&
        ((msg = "이름을 입력해주세요"), (err = false), this.$refs.content);
      err &&
        !this.userInfo.email &&
        ((msg = "이메일을 입력해주세요"), (err = false), this.$refs.content);
      err &&
        !this.userInfo.phone &&
        ((msg = "핸드폰 번호를 입력해주세요"),
        (err = false),
        this.$refs.content);
      err &&
        !this.userInfo.address &&
        ((msg = "주소를 입력해주세요"), (err = false), this.$refs.content);

      if (!err) alert(msg);
      else this.registMember();
    },
    onReset(event) {
      event.preventDefault();
      this.userInfo.id = "";
      this.userInfo.password = "";
      this.userInfo.name = "";
      this.userInfo.email = "";
      this.userInfo.phone = "";
      this.userInfo.address = "";
      this.$router.push({ name: "boardList" });
    },
    id_check() {
      axios
        .get(
          `http://localhost:8080/happyhouse/member/check_id/${this.userInfo.id}`
        )
        .then((response) => {
          console.log(response);
          if (response.data.result > 0) {
            alert("중복된 아이디가 있습니다.");
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
    email_check() {
      axios
        .get(
          `http://localhost:8080/happyhouse/member/check_email/${this.userInfo.email}`
        )
        .then((response) => {
          console.log(response);
          if (response.data.result > 0) {
            alert("중복된 이메일이 있습니다");
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
    registMember() {
      memberRegister(
        {
          id: this.userInfo.id,
          password: this.userInfo.password,
          name: this.userInfo.name,
          email: this.userInfo.email,
          phone: this.userInfo.phone,
          address: this.userInfo.address,
        },
        ({ data }) => {
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data.message === "success") {
            msg =
              "등록이 완료되었습니다. 입력하신 이메일로 인증 절차를 진행해주세요!";
          } else {
            msg = "등록에 실패하였습니다.(아이디 및 이메일 중복)";
          }
          alert(msg);
          this.$router.push({ name: "boardList" });
        },
        (error) => {
          console.log(error);
        }
      );
    },
  },
};
</script>

<style></style>
