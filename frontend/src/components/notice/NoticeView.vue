<template>
  <div class="regist">
    <h1 class="underline">공지사항 글 정보</h1>
      <b-form>
      <b-form-group
        style="text-align: left"
        id="input-group-1"
        label="No."
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="article.no"
          required
          readonly
        ></b-form-input>
      </b-form-group>

      <b-form-group
        style="text-align: left"
        id="input-group-1"
        label="Title."
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="article.title"
          required
          readonly
        ></b-form-input>
      </b-form-group>

      <b-form-group
        style="text-align: left"
        id="input-group-1"
        label="writer."
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="article.writer"
          required
          readonly
        ></b-form-input>
      </b-form-group>

      <b-form-group
        style="text-align: left"
        id="input-group-1"
        label="regtime."
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="article.regtime"
          required
          readonly
        ></b-form-input>
      </b-form-group>

      <b-form-group
        style="text-align: left"
        id="input-group-1"
        label="Content."
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="article.content"
          required
          readonly
        ></b-form-input>
      </b-form-group>
     
        <router-link :to="{ name: 'NoticeModify' }" class="btn" v-if="userid===article.writer || userid==='admin'" > <b-button type="수정" variant="primary" >수정</b-button></router-link>
        <router-link :to="{ name: 'NoticeDelete' }" class="btn" v-if="userid===article.writer || userid==='admin'" > <b-button type="삭제" variant="danger">삭제</b-button></router-link>
        <router-link to="/noticelist" class="btn"> <b-button type="목록" variant="success">목록</b-button></router-link>
      </b-form>
    </div>
</template>

<script>
import http from "@/util/http-common.js";

export default {
  data: function () {
    return {
      userid: sessionStorage.getItem("userId"),
      article: {},
    };
  },
  created() {
    http.get(`vue/api/vueboard/notice/${this.$route.params.no}`).then(({ data }) => {
      this.article = data;
      console.log("글보기 완료!!!");
    });
  },
  methods: {},
};
</script>

<style></style>
