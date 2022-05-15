<template>
  <div>
    <div>TRANSACTION</div>
    <div>
      <label for="emettId">Le numero du compte emétteur</label>
      <input id="emettId" v-model="transaction.emettId">
    </div>
    <div>
      <label for="benefId">Le numero du compte bénéficiaire</label>
      <input id="benefId" v-model="transaction.benefId">
    </div>
    <div>
      <label for="montant">Le montant de la transaction</label>
      <input id="montant" v-model="transaction.montant">
    </div>
    <div>
      <button :disabled="!valid" @click="create">ENVOYER</button>
    </div>
  </div>
</template>

<script>
import TransactionApi from "@/api/transaction";

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
  methods:{
    async create()
    {
      this.transaction.date = new Date().toJSON().slice(0, 10).replace(/-/g, '-')
      try {
        const response = await TransactionApi.postTransaction({...this.transaction})
        console.log(response.body)
      }catch (error)
      {
        console.error(error)
      }
    }
  },
  computed:{
    valid(){
      return this.transaction.emettId !==0 && this.transaction.benefId !== 0  && this.transaction.montant !== 0 && this.transaction.benefId !== this.transaction.emettId
    }
  }
}
</script>

<style scoped>

</style>
