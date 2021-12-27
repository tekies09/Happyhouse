<template>
  <tr>
    <td>{{ no }}</td>
    <td>
      <router-link :to="{ name: 'QnAView', params: { no: no } }">{{
        title
      }}</router-link>
    </td>
    <td>{{ writer }}</td>
    <td>{{ regtime }}</td>
  </tr>
</template>

<script>
export default {
  name: "QnAListRow",
  props: {
    no: Number,
    title: String,
    writer: String,
    regtime: String,
  },
};
</script>

<style></style>
