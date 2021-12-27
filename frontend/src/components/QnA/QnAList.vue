<template>
  <div align="center" class="table-responsive">
    <h2 class="underline">자유게시판 글 목록</h2>

    <div style="text-align: right">
      <b-button @click="movePage" v-if="userid">글 등록</b-button>
    </div>
    <br/>
    <div v-if="articles.length">
      <table class="table table-hover">
        <colgroup>
          <col style="width: 10%" />
          <col style="width: 55%" />
          <col style="width: 10%" />
          <col style="width: 25%" />
        </colgroup>
        <thead>
          <tr>
            <th>글번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
          </tr>
        </thead>
        <tbody>
          <qna-list-row
            v-for="(article, index) in articles"
            :key="index"
            v-bind="article"
          ></qna-list-row>
        </tbody>
      </table>
    </div>
    <div v-else class="text-center">게시글이 없습니다.</div>
  </div>
</template>

<script>
import http from "@/util/http-common.js";
import QnaListRow from "@/components/QnA/QnAListRow";

export default {
  name: "QnAList",
  components: {
    QnaListRow,
  },
  data() {
    return {
      userid: sessionStorage.getItem("userId"),
      articles: [],
    };
  },
  created() {
    http.get("vue/api/vueboard/free").then(({ data }) => {
      this.articles = data;
    });
  },
  methods: {
    movePage() {
      this.$router.push({ name: "QnAWrite" });
    },
  },
};
</script>

<style></style>
