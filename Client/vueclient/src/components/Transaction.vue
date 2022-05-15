<template>
  <div>
    <div>TRANSACTION</div>
    <div>
      <label for="emettId">Le numero du compte emétteur</label>
      <input id="emettId">
    </div>
    <div>
      <label for="benefId">Le numero du compte bénéficiaire</label>
      <input id="benefId">
    </div>
    <div>
      <label for="montant">Le montant de la transaction</label>
      <input id="montant">
    </div>
  </div>
</template>

<script>
export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Transaction",
  props:{

  },
  data () {
    return{
      transaction:{
        emettId:0,
        benefId:0,
        date:'',
        montant:0
      }
    }
  },
}
</script>

<style scoped>

</style>
