<template>
  <div>
    <b-container style="background-color: #fdf5d2; border-radius: 40px 80px">
      <b-row>
        <b-col>
          <h1 style="font-size: 60px">{{ qna.title }}</h1>
        </b-col>
      </b-row>
      <div class="hr-sect">질문</div>
      <b-row align-h="start">
        <b-col>
          <pre style="font-size: 30px; text-align: left">{{
            qna.question
          }}</pre>
        </b-col>
      </b-row>

      <div class="hr-sect">답변</div>
      <div v-if="qna.answer">
        <pre style="font-size: 30px; text-align: left">
          {{ qna.answer }}
        </pre>
      </div>
      <div v-else>
        <p>현재 답변이 등록되어 있지 않습니다.</p>
      </div>
      <!-- <b-jumbotron
            bg-variant="white"
            text-variant="dark"
            border-variant="dark"
          >
            <template #header>{{ qna.title }}</template>

            <template #lead>
              {{ qna.question }}
            </template>

            <hr class="my-4" />

            <div v-if="qna.answer">
              <p>
                {{ qna.answer }}
              </p>
            </div>
            <div v-else>
              <p>현재 답변이 등록되어 있지 않습니다.</p>
            </div>
          </b-jumbotron> -->

      <b-row align-h="end">
        <b-col cols="3">
          <b-button
            size="lg"
            variant="info"
            style="margin-right: 5px"
            @click="movePage"
            >목록</b-button
          >
          <template v-if="userInfo && userInfo.id == 'admin'">
            <router-link :to="{ name: 'QnaModify', query: { no: qna.no } }">
              <b-button size="lg" style="margin-right: 5px" variant="primary"
                >답변</b-button
              >
            </router-link>
            <b-button
              size="lg"
              style="margin-right: 5px"
              variant="danger"
              @click="removeHandler"
            >
              삭제
            </b-button>
          </template>
        </b-col>
      </b-row>
    </b-container>
    <!-- <h2 class="text-center">Q&A</h2>
    <div>
      <table class="table table-boardered">
        <thead></thead>
        <tbody>
          <tr>
            <td>제목</td>
            <td v-text="qna.title"></td>
          </tr>
          <tr>
            <td>질문자</td>
            <td v-text="qna.id"></td>
          </tr>
          <tr>
            <td>등록일</td>
            <td v-text="qna.question_date"></td>
          </tr>
          <tr>
            <td>질문</td>
            <td v-text="qna.question"></td>
          </tr>
          <tr>
            <td>답변일</td>
            <td v-text="qna.answer_date"></td>
          </tr>
          <tr>
            <td>답변</td>
            <td v-text="qna.answer"></td>
          </tr>
          <tr>
            <td colspan="2">
              <div class="text-center">
                <button class="btn btn-primary" @click="movePage">목록</button>
                <template v-if="userInfo && userInfo.id == 'admin'">
                  <div>
                    <router-link
                      :to="{ name: 'QnaModify', query: { no: qna.no } }"
                    >
                      <button class="btn btn-primary">답변</button>
                    </router-link>
                    <button class="btn btn-primary" @click="removeHandler">
                      삭제
                    </button>
                  </div>
                </template>
              </div>
            </td>
          </tr>
        </tbody>
      </table>
    </div> -->
  </div>
</template>

<script>
import http from "@/api/qna";
import { mapGetters } from "vuex";

export default {
  data() {
    return {
      no: "",
      qna: "",
    };
  },
  created() {
    this.no = this.$route.query.no;
    http
      .get(`qna/${this.no}`)
      .then(({ data }) => {
        this.qna = data;
      })
      .catch(({ response }) => {
        alert(response);
      });
  },
  computed: {
    ...mapGetters("memberStore", { userInfo: "checkUserInfo" }),
  },
  methods: {
    movePage() {
      this.$router.push({ name: "QnaList" });
    },
    removeHandler() {
      http
        .delete(`qna/${this.no}`)
        .then(({ data }) => {
          if (data == "success") {
            alert("삭제 성공");
            this.movePage();
          }
        })
        .catch(({ response }) => {
          alert(response);
        });
    },
  },
};
</script>

<style>
.hr-sect {
  display: flex;
  flex-basis: 100%;
  align-items: center;
  color: rgba(0, 0, 0, 0.35);
  font-size: 30px;
  margin: 8px 0px;
}
.hr-sect::before,
.hr-sect::after {
  content: "";
  flex-grow: 1;
  background: rgba(0, 0, 0, 0.35);
  height: 1px;
  font-size: 0px;
  line-height: 0px;
  margin: 0px 16px;
}
</style>
