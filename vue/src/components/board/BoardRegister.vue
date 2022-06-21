<template>
  <b-container class="bv-example-row mt-3">
    <b-row>
      <b-col>
        <h1 style="font-size: 60px">공지 작성</h1>
      </b-col>
    </b-row>
    <board-input-item type="register" />
  </b-container>
</template>

<script>
import BoardInputItem from "@/components/board/item/BoardInputItem.vue";

export default {
  name: "BoardWrite",
  components: {
    BoardInputItem,
  },
};
</script>

<style></style>
