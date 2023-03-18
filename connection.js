const{
    createPool
}= require('mysql');

require('dotenv').config();

const connection = createPool({
    port: process.env.DB_PORT,
    host: process.env.DB_HOST,
    user: process.env.DB_USERNAME,
    password: process.env.DB_PASSWORD,
    database: process.env.DB_NAME,
    connectionLimit: 10
})
connection.getConnection((err, result, fields)=>{
    if(err){
        return console.log(err);
    }
    return console.log("connected");
});

module.exports = connection;

/*connection.query(`insert into User(Name, Email, Password, Status, role) values (?,?,'false','false','user')`, ['admin1@gmail.com','adjmin@gmail.com'], (err, result, fields)=>{
    if(err){
        return console.log(err);
    }
    return console.log(result);
});*/













/*const mysql = require('mysql');
require('dotenv').config();

var connection = mysql.createConnection({
    port: process.env.DB_PORT,
    host: process.env.DB_HOST,
    user: process.env.DB_USERNAME,
    password: process.env.DB_PASSWORD,
    database: process.env.DB_NAME
});

connection.connect((err) =>{
    if(!err){
        console.log("Connected");
    }
    else{
        console.log(err);
    }
});

module.exports = connection;*/
