<template>
  <div>
    <div>SOLDE</div>
    <div>
      <label for="numero">Entrer le numéro de compte</label>
      <input id="numero" v-model="numero">
    </div>
    <button :disabled="!valid" @click="getSolde"> CONSULTER LE SOLDE</button>
    <div v-if="solde > 0">
      Le solde du compte est : {{solde}}
    </div>
  </div>
</template>

<script>
import TransactionApi from "@/api/transaction";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Solde",
  data (){
    return{
      numero:0,
      solde:-1
    }
  },
  methods: {
    async getSolde() {
      try {
        const response = await TransactionApi.getSolde(this.numero);
        this.solde = response.body
      }catch (error)
      {
        console.error(error)
      }
    }
  },
  computed: {
    valid()
    {
      return this.numero !== 0
    }
  }
}
</script>

<style scoped>

</style>
