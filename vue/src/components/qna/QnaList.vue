<template>
  <b-container class="bv-example-row mt-3">
    <b-row align-h="between" style="margin-bottom: 1rem">
      <b-col cols="2" style="font-size: xx-large">Q&A</b-col>
      <b-col cols="6">
        <b-row align-h="end">
          <b-col cols="5"
            ><b-form-input
              size="lg"
              class="mr-sm-2"
              type="text"
              v-model="word"
              placeholder="Search"
            ></b-form-input
          ></b-col>
          <b-col cols="2"
            ><b-button @click="searchQna" size="lg" type="submit"
              >Search</b-button
            ></b-col
          >
        </b-row></b-col
      >
    </b-row>
    <b-row>
      <b-col v-if="searchs.length">
        <b-table-simple hover responsive>
          <b-thead
            head-variant="dark"
            style="
              font-size: 20px;
              text-shadow: -1px 0 #000, 0 1px #000, 1px 0 #000, 0 -1px #000;
            "
          >
            <b-tr>
              <b-th>글번호</b-th>
              <b-th>질문자</b-th>
              <b-th>제목</b-th>
              <b-th>질문일</b-th>
              <b-th>답변일</b-th>
            </b-tr>
          </b-thead>
          <tbody style="font-size: 25px">
            <!-- 하위 component인 ListRow에 데이터 전달(props) -->
            <qna-list-item v-for="qna in searchs" :key="qna.no" v-bind="qna" />
          </tbody>
        </b-table-simple>
      </b-col>
      <!-- <b-col>
        <table class="table table-bordered table-hover">
          <colgroup>
            <col width="10%" />
            <col width="40%" />
            <col width="10%" />
            <col width="20%" />
            <col width="20%" />
          </colgroup>
          <thead>
            <tr>
              <th>번호</th>
              <th>제목</th>
              <th>질문자</th>
              <th>등록일</th>
              <th>답변일</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="(qna, index) in searchs" :key="qna.no">
              <td>{{ index + 1 }}</td>
              <td>
                <router-link
                  :to="{ name: 'QnaDetail', query: { no: qna.no } }"
                  >{{ qna.title }}</router-link
                >
              </td>
              <td v-text="qna.id"></td>
              <td v-text="qna.question_date"></td>
              <td v-text="qna.answer_date"></td>
            </tr>
          </tbody>
        </table>
      </b-col> -->
      <!-- <b-col v-else class="text-center">도서 목록이 없습니다.</b-col> -->
    </b-row>
    <b-row align-h="end">
      <b-col cols="2">
        <div v-if="isAdmin">
          <b-button size="lg" variant="outline-primary" @click="moveWrite()"
            >글쓰기</b-button
          >
        </div>
      </b-col>
    </b-row>
  </b-container>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
import store from "@/store/index.js";
import QnaListItem from "@/components/qna/QnaListItem.vue";
export default {
  components: {
    QnaListItem,
  },
  data() {
    return {
      word: "", //검색 할 단어
      key: "title", //검색 조건
    };
  },
  computed: {
    ...mapGetters("qnaStore", { searchs: "searchs" }),
    ...mapGetters("memberStore", { userInfo: "checkUserInfo" }),
    isAdmin() {
      const u = store.getters["memberStore/checkUserInfo"];
      console.log(u);
      if (u == null) {
        return false;
      } else {
        return true;
      }
    },
  },
  created() {
    this.$store.dispatch("qnaStore/getQnas");
  },
  methods: {
    ...mapActions(["qnaStore/getQnas", "qnaStore/getSearchs"]),
    searchQna() {
      // console.log("userInfo:" + this.$session.get("userInfo"));
      this.$store.dispatch("qnaStore/getSearchs", {
        key: this.key,
        word: this.word,
      });
      // this.getSearchs({ key: this.key, word: this.word });
    },
    moveWrite() {
      this.$router.push({ name: "QnaRegist" });
    },
  },
};
</script>

<style></style>
