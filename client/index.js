var app = new Vue({
    el:"#app",
    vuetify: new Vuetify(),
    data: {
        response:{},
        datosUsu:{
         usuari: "",
        contrasenya: "",
        }
    },
    methods:{
        getData: function(){
            console.log("Get Data Binded")
            const myHeaders = new Headers()
            fetch("http://127.0.0.1:3000/login",{
                method: 'POST',
                mode: 'cors',
                headers: {
                  'Accept': 'application/json',
                  'Content-Type': 'application/json'
                },
                body: JSON.stringify(this.datosUsu)
            }).then(
                (response)=>{
                    console.log(response)
                    return response.json()
                }
            ).then(
                (data)=>{
                    console.log(data)
                    this.response = data
                }
            ).catch(
                (error)=>{
                    console.log("ERROR!!")
                    console.log(error)
                }
            )
        }
    }
})