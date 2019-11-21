var app = new Vue({
      el: '#app',
      data: {
          block: '',
          blockhash: ''
      },
      mounted() {
          var url = new URL(location.href);
          this.block = url.searchParams.get("blockhash");
          if (!this.block) {
              return;
          }
  
          this.getInfoByHash();
      },
      methods: {
            getInfoByHash() {
              axios.get('/block/getInfoByHash', {
                  params: {
                      block: this.block
                  }
              })
                  .then(function (response) {
                      app.block = response.data;
                  })
                  .catch(function (error) {
  
                  });
          },
          
      }
  })