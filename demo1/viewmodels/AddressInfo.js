var app = new Vue({
    el: '#app',
    data: {
        address: '',
        addressInfo: '',
        page: 1,
        txPageinfo: ''
    },
    mounted() {
        var url = new URL(location.href);
        this.address = url.searchParams.get("address");
        if (!this.address) {
            return;
        }

        this.getAddressInfoByAddress();
        this.getTransactionsByAddress();
    },
    methods: {
        getAddressInfoByAddress() {
            axios.get('/address/getInfoByAddress', {
                params: {
                    address: this.address
                }
            })
                .then(function (response) {
                    app.addressInfo = response.data;
                })
                .catch(function (error) {

                });
        },
        getTransactionsByAddress() {
            axios.get('/transaction/getByAddressPage', {
                params: {
                    address: this.address,
                    page: this.page
                }
            })
                .then(function (response) {
                    app.txPageinfo = response.data;
                })
                .catch(function (error) {
                });
        }
    }
})