<template>
  <div>
    <b-container style="background-color: #fdf5d2; border-radius: 40px 80px">
      <b-row>
        <b-col>
          <h1 style="font-size: 60px">{{ article.subject }}</h1>
        </b-col>
      </b-row>
      <p style="font-size: 20px; text-align: right">
        {{ article.regtime }}
      </p>
      <div class="hr-sect">내용</div>
      <b-row align-h="start">
        <b-col>
          <pre style="font-size: 30px; text-align: left">{{
            article.content
          }}</pre>
        </b-col>
      </b-row>
      <!-- <b-jumbotron
            bg-variant="white"
            text-variant="dark"
            border-variant="dark"
          >
            <template #header>{{ article.subject }}</template>

            <template #lead>
              {{ article.regtime }}
            </template>

            <hr class="my-4" />

            <div>
              <p v-html="message"></p>
            </div>
          </b-jumbotron> -->
      <b-row align-h="end">
        <b-col cols="3">
          <b-button
            size="lg"
            variant="info"
            style="margin-right: 5px"
            @click="listArticle"
            >목록</b-button
          >
          <template v-if="isAdmin">
            <b-button
              size="lg"
              variant="primary"
              style="margin-right: 5px"
              @click="moveModifyArticle"
              >수정</b-button
            >
            <b-button
              size="lg"
              variant="danger"
              style="margin-right: 5px"
              @click="deleteArticle"
            >
              삭제
            </b-button>
          </template>
        </b-col>
      </b-row>
    </b-container>
  </div>
  <!-- <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <b-alert show><h3>글보기</h3></b-alert>
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col class="text-left">
        <b-button variant="outline-primary" @click="listArticle">목록</b-button>
      </b-col>
      <b-col class="text-right">
        <b-button
          v-if="isAdmin"
          variant="outline-info"
          size="sm"
          @click="moveModifyArticle"
          class="mr-2"
          >글수정</b-button
        >
        <b-button
          v-if="isAdmin"
          variant="outline-danger"
          size="sm"
          @click="deleteArticle"
          >글삭제</b-button
        >
      </b-col>
    </b-row>
    <b-row class="mb-1">
      <b-col>
        <b-card
          :header-html="`<h3>${article.articleno}.
          ${article.subject} [${article.hit}]</h3><div><h6>${article.id}</div><div>${article.regtime}</h6></div>`"
          class="mb-2"
          border-variant="dark"
          no-body
        >
          <b-card-body class="text-left">
            <div v-html="message"></div>
          </b-card-body>
        </b-card>
      </b-col>
    </b-row>
  </b-container> -->
</template>

<script>
// import moment from "moment";
import { getArticle, deleteArticle } from "@/api/board";
import store from "@/store/index.js";

export default {
  name: "BoardDetail",
  data() {
    return {
      article: {},
    };
  },
  computed: {
    message() {
      if (this.article.content)
        return this.article.content.split("\n").join("<br>");
      return "";
    },
    isAdmin() {
      const u = store.getters["memberStore/checkUserInfo"];
      if (u == null) {
        return false;
      } else {
        if (u.id == "admin") {
          return true;
        } else {
          return false;
        }
      }
    },
  },
  created() {
    getArticle(
      this.$route.params.articleno,
      (response) => {
        this.article = response.data;
      },
      (error) => {
        console.log("삭제시 에러발생!!", error);
      }
    );
  },
  methods: {
    listArticle() {
      this.$router.push({ name: "boardList" });
    },
    moveModifyArticle() {
      this.$router.replace({
        name: "boardModify",
        params: { articleno: this.article.articleno },
      });
      //   this.$router.push({ path: `/board/modify/${this.article.articleno}` });
    },
    deleteArticle() {
      if (confirm("정말로 삭제?")) {
        deleteArticle(this.article.articleno, () => {
          this.$router.push({ name: "boardList" });
        });
      }
    },
  },
  // filters: {
  //   dateFormat(regtime) {
  //     return moment(new Date(regtime)).format("YY.MM.DD hh:mm:ss");
  //   },
  // },
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
