import http from "@/api/qna";

const qnaStore = {
  namespaced: true,
  state: {
    qnas: [], //전체 도서 정보
    qna: {}, //isbn에 해당하는 도서 정보,
    searchs: [],
  },
  getters: {
    qnas(state) {
      return state.qnas;
    },
    qna(state) {
      return state.qna;
    },
    searchs(state) {
      return state.searchs;
    },
  },
  mutations: {
    setQnas(state, payload) {
      console.log("[mutations].................qnas");
      state.qnas = payload;
      console.log("[mutations].................setQnas", state.qnas);
    },
    setQna(state, payload) {
      console.log("[mutations].................setQna");
      state.qna = payload;
      console.log("[mutations].................qna");
    },
    setSearchs(state, payload) {
      console.log("[mutations].................setSearchs");
      state.searchs = payload;
      console.log("[mutations].................setSearchs  ", state.searchs);
    },
  },
  actions: {
    getSearchs({ commit, state }, payload) {
      console.log("[action] getSearchs........", payload);
      let newQnas = [];
      if (payload.key == "no") {
        for (let i = 0; i < state.qnas.length; i++) {
          if (state.qnas[i].no == payload.word) {
            newQnas.push(state.qnas[i]);
          }
        }
      } else if (payload.key == "id") {
        for (let i = 0; i < state.qnas.length; i++) {
          if (state.qnas[i].id == payload.word) {
            newQnas.push(state.qnas[i]);
          }
        }
      } else if (payload.key == "title") {
        for (let i = 0; i < state.qnas.length; i++) {
          if (state.qnas[i].title.indexOf(payload.word) >= 0) {
            newQnas.push(state.qnas[i]);
          }
        }
      } else if (payload.key == "all") {
        newQnas = state.qnas;
      }
      console.log("searchqnas........", newQnas);
      commit("setSearchs", newQnas);
    },
    getQnas(context) {
      console.log("[action] getQnas........");
      http
        .get("qna")
        .then(({ data }) => {
          console.log("qnas.......", data);
          context.commit("setQnas", data);
          context.commit("setSearchs", data);
        })
        .catch(({ response }) => {
          alert(response.data);
        });
    },
  },
};

export default qnaStore;
