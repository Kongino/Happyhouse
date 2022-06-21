<template>
  <b-tr>
    <b-td>{{ no }}</b-td>
    <b-td>{{ id }}</b-td>
    <b-th class="text-left">
      <router-link
        style="text-decoration-line: none"
        :to="{ name: 'QnaDetail', query: { no: no } }"
        >{{ title }}</router-link
      >
    </b-th>
    <b-td>{{ question_date | dateFormat }}</b-td>

    <b-td v-if="answer_date == '-'">-</b-td>
    <b-td v-else>{{ answer_date | dateFormat }}</b-td>
  </b-tr>
</template>

<script>
import moment from "moment";

export default {
  name: "QnaListItem",
  props: {
    no: Number,
    id: String,
    title: String,
    question_date: String,
    answer_date: String,
  },
  filters: {
    dateFormat(regtime) {
      return moment(new Date(regtime)).format("YY.MM.DD");
    },
  },
};
</script>

<style></style>
