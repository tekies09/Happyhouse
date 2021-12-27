<template>
<div align="center" class="table-responsive">
<table class="table table-hover">
<thead>
		<tr>
			<th scope="col" class="text-center">아이디</th>
			<th scope="col" class="text-center">이름</th>
			<th scope="col" class="text-center">가입일</th>
      <th scope="col" class="text-center">더보기</th>
		</tr>
	</thead>
<tbody>
<member-list-row v-for="(member, index) in members"
            :key="index"
            v-bind="member">
        ></member-list-row>
</tbody>
</table>
</div>
</template>

<script>
import http from "@/util/http-common.js";
import MemberListRow from "@/components/member/MemberListRow";

export default {
name: "MemberList",
    components: {
    MemberListRow,
    },
    data() {
    return {
        members: [],
    };
    },
    created() {
    http.get("vue/api/vueadmin/userlist").then(({ data }) => {
        this.members = data;
    });
    },
    methods: {
    movePage() {
        this.$router.push({ name: "MemberWrite" });
    },
    },
};
</script>

<style></style>
