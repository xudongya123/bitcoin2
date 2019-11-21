var app = new Vue({
    el: '#app',
    data: {
        blocks: []
    },
    computed: {
        newBlocks() {
            return this.blocks.map(block => {
                var newBlock = block;
                newBlock.fornow = moment.unix(block.time).fromNow();
                return newBlock;
            });
        }
    },
    mounted() {
        this.getRecentBlocks();
    },
    methods: {
        getRecentBlocks() {
            axios.get('/block/getRecent')
                .then(function (response) {
                    console.log(response);
                    app.blocks = response.data;
                })
                .catch(function (error) {
                    console.log(error);
                });
        }
    }
})