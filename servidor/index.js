const express = require ("express")
const cors = require ("cors")
const mysql = require('mysql2');
const bodyParser = require("body-parser");

const app = express()
const PORT = 3000

var con = mysql.createConnection({
    host: "labs.inspedralbes.cat",
    user: "a19angavimar_User",
    password: "Projecto_grupo5",
    database: "a19angavimar_Usuarios"
})

app.use (cors({
    origin:function(origin,callback){
        return callback(null,true)
    }
}))

app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

app.post("/login", (req, res) => {
    var user_name = req.body.usuari;
    var password = req.body.contrasenya;
    
    con.query('insert into Users values (null,"'+user_name+'","'+password+'");',(err,result) =>{
        if (err) throw err;
    })
    
})

app.listen(PORT, ()=>{
    console.log("SERVER RUNNING ["+PORT+"]")
})