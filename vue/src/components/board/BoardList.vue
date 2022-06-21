<template>
  <b-container class="bv-example-row mt-3">
    <b-row align-h="between" style="margin-bottom: 1rem">
      <b-col cols="2" style="font-size: xx-large">공지사항</b-col>
      <b-col cols="6">
        <b-row align-h="end">
          <b-col cols="5"
            ><b-form-input
              v-model="word"
              size="lg"
              class="mr-sm-2"
              placeholder="Search"
            ></b-form-input
          ></b-col>
          <b-col cols="2"
            ><b-button @click="searchArticles" size="lg"
              >Search</b-button
            ></b-col
          >
        </b-row></b-col
      >
    </b-row>
    <b-row>
      <b-col v-if="articles.length">
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
              <b-th>제목</b-th>
              <b-th>작성자</b-th>
              <b-th>작성일</b-th>
            </b-tr>
          </b-thead>
          <tbody style="font-size: 25px">
            <!-- 하위 component인 ListRow에 데이터 전달(props) -->
            <board-list-item
              v-for="article in articles"
              :key="article.articleno"
              v-bind="article"
            />
          </tbody>
        </b-table-simple>
      </b-col>
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
import { listArticle } from "@/api/board.js";
import BoardListItem from "@/components/board/item/BoardListItem";
import store from "@/store/index.js";

export default {
  name: "BoardList",
  components: {
    BoardListItem,
  },
  data() {
    return {
      articles: [],
      word: "",
    };
  },
  created() {
    let param = {
      pg: 1,
      spp: 20,
      key: null,
      word: null,
    };
    listArticle(
      param,
      (response) => {
        this.articles = response.data;
      },
      (error) => {
        console.log(error);
      }
    );
  },
  methods: {
    moveWrite() {
      this.$router.push({ name: "boardRegister" });
    },
    searchArticles() {
      console.log("searchArticles....", this.articles);
      let newArticles = [];
      for (let i = 0; i < this.articles.length; i++) {
        if (this.articles[i].subject.indexOf(this.word) >= 0) {
          newArticles.push(this.articles[i]);
        }
      }
      console.log("searchArticles....", newArticles);
      this.articles = newArticles;
    },
  },
  computed: {
    isAdmin() {
      const u = store.getters["memberStore/checkUserInfo"];
      console.log(u);
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
};
</script>

<style scope>
.tdClass {
  width: 50px;
  text-align: center;
}
.tdSubject {
  width: 300px;
  text-align: left;
}
</style>
