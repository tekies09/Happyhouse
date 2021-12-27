<template>
    <div class="regist">
    <h1 class="underline">공지사항 작성</h1>
      <b-form>

      <b-form-group
        style="text-align: left"
        id="input-group-1"
        label="Title."
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="title"
          required
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
          v-model="writer"
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
          v-model="content"
          required
        ></b-form-input>
      </b-form-group>
        <b-button type="등록" variant="primary" @click="checkValue" >등록</b-button>
        <b-button type="목록" variant="success" @click="moveList">목록</b-button>
      </b-form>
    </div>
</template>

<script>
import http from "@/util/http-common.js";

export default {
  data() {
    return {
      writer: sessionStorage.getItem("userId"),
      title: "",
      content: "",
    };
  },
  methods: {
    // 입력값 체크하기 - 체크가 성공하면 registBook 호출
    checkValue() {
      // 사용자 입력값 체크하기
      // isbn, 제목, 저자, 가격, 설명이 없을 경우 각 항목에 맞는 메세지를 출력
      let err = true;
      let msg = "";
      !this.writer &&
        ((msg = "작성자 입력해주세요"),
        (err = false),
        this.$refs.writer.focus());
      err &&
        !this.title &&
        ((msg = "제목 입력해주세요"), (err = false), this.$refs.title.focus());
      err &&
        !this.content &&
        ((msg = "내용 입력해주세요"),
        (err = false),
        this.$refs.content.focus());

      if (!err) alert(msg);
      // 만약, 내용이 다 입력되어 있다면 registBook 호출
      else this.registArticle();
    },

    async registArticle() {
      http
        .post("vue/api/vueboard/notice", {
          writer: this.writer,
          title: this.title,
          content: this.content,
        })
        .then(({ data }) => {
          // 서버에서 정상적인 값이 넘어 왔을경우 실행.
          let msg = "등록 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "등록이 완료되었습니다.";
          }
          alert(msg);
        });
        this.$router.push("/noticelist");
    },
    moveList() {
      this.$router.push({ name: "NoticeList" });
    },
  },
};
</script>

<style></style>
