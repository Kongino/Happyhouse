<template>
  <b-container>
    <b-row>
      <b-col>
        <h1 style="font-size: 60px">질문글 작성</h1>
      </b-col>
    </b-row>

    <b-row class="mb-1" style="font-size: 20px">
      <b-col style="text-align: left">
        <b-form @submit="onSubmit" @reset="onReset">
          <b-form-group
            id="id-group"
            label="작성자:"
            label-for="id"
            description="작성자를 입력하세요."
          >
            <b-form-input
              size="lg"
              id="id"
              disabled
              v-model="userInfo.id"
              type="text"
              required
              placeholder="작성자 입력..."
            ></b-form-input>
          </b-form-group>

          <b-form-group
            id="subject-group"
            label="제목:"
            label-for="subject"
            description="제목을 입력하세요."
          >
            <b-form-input
              size="lg"
              id="subject"
              v-model="article.title"
              type="text"
              required
              placeholder="제목 입력..."
            ></b-form-input>
          </b-form-group>

          <b-form-group id="content-group" label="질문:" label-for="content">
            <b-form-textarea
              size="lg"
              id="content"
              v-model="article.question"
              placeholder="질문 입력..."
              rows="10"
              max-rows="15"
            ></b-form-textarea>
          </b-form-group>
          <b-row align-h="end"
            ><b-button type="submit" variant="primary" class="m-1" size="lg"
              >질문등록</b-button
            >
            <b-button size="lg" type="reset" variant="danger" class="m-1"
              >초기화</b-button
            ></b-row
          >
        </b-form>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import http from "@/api/qna";
import { mapGetters } from "vuex";
export default {
  data() {
    return {
      article: {
        id: "",
        question: "",
        //answer_date: "",
        answer: "",
        no: "",
        //question_date: "",
        title: "",
      },
    };
  },

  computed: {
    ...mapGetters("memberStore", { userInfo: "checkUserInfo" }),
  },
  methods: {
    onReset() {
      this.$router.push({ name: "QnaList" });
    },
    onSubmit(event) {
      event.preventDefault();

      let err = true;
      let msg = "";
      this.article.id = this.userInfo.id;
      !this.article.id &&
        ((msg = "작성자 입력해주세요"), (err = false), this.$refs.id);
      err &&
        !this.article.title &&
        ((msg = "제목 입력해주세요"), (err = false), this.$refs.title);
      err &&
        !this.article.question &&
        ((msg = "내용 입력해주세요"), (err = false), this.$refs.question);

      if (!err) alert(msg);
      else this.registerHandler();
    },
    registerHandler() {
      //데이타 검증
      let err = false;

      let msg = "";

      if (err) {
        alert(msg);
      } else {
        //등록 처리
        //localstorage에 이미 저장된 책 목록이 있는지 검사
        http
          .post("qna", this.article)
          .then(({ data }) => {
            if (data == "success") {
              alert("등록 성공");
              this.$router.push({ name: "QnaList" });
            }
          })
          .catch(({ response }) => {
            alert(response);
          });
      }
    },
  },
};
</script>

<style></style>
