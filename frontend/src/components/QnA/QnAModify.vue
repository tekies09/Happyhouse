<template>
  <div class="regist">
    <h1 class="underline">자유게시판 글 수정</h1>
      <b-form>
      <b-form-group
        style="text-align: left"
        id="input-group-1"
        label="No."
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="no"
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
        label="regtime."
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="regtime"
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
        <b-button  variant="primary" @click="checkValue" >수정</b-button>
        <b-button  variant="success" @click="moveList">목록</b-button>
      </b-form>
    </div>
</template>

<script>
import http from "@/util/http-common.js";

export default {
  data() {
    return {
      no: 0,
      writer: "",
      title: "",
      content: "",
      regtime: "",
    };
  },
  created() {
    http.get(`vue/api/vueboard/free/${this.$route.params.no}`).then(({ data }) => {
      this.no = data.no;
      this.writer = data.writer;
      this.title = data.title;
      this.content = data.content;
      this.regtime = data.regtime;
    });
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
      else this.modifyArticle();
    },

    modifyArticle() {
      http
        .put(`vue/api/vueboard/free/${this.no}`, {
          no: this.no,
          writer: this.writer,
          title: this.title,
          content: this.content,
        })
        .then(({ data }) => {
          let msg = "수정 처리시 문제가 발생했습니다.";
          if (data === "success") {
            msg = "수정이 완료되었습니다.";
          }
          alert(msg);
          // 현재 route를 /list로 변경.
          this.$router.push("/qnalist");
        });
    },
    moveList() {
      // 현재 route를 /list로 변경.
      this.$router.push("/qnalist");
    },
  },
};
</script>

<style></style>
