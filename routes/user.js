const express = require('express');
const connection = require('../connection');
var router = express.Router();
const jwt = require('jsonwebtoken');
let bcrypt = require('bcrypt')

require('dotenv').config();

var auth = require('../services/authentication');

router.post('/signup', (req, res) => {
    let user = req.body;
    query = "select Username from Login where Username=?"
    connection.query(query, [user.username], (err, results, fields) => {
        if (err) {
            return console.log(err);
        }
        if (!err) {
            if (results.length <= 0) {
                bcrypt.genSalt(10, (err, salt)=>{
                    //hashing password
                    bcrypt.hash(user.password, salt, (err, hash) =>{
                        query = "insert into Login(Username, Password, MasterUserID, UserDeletedStatus, Points) values (?,?,?,?,?)";
                        connection.query(query, [user.username, hash, user.username, "No", 0 ], (err, results, fields) => {
                            if (!err) {
                                return res.status(200).json({ message: "Successfully Registered" });
                            }
        
                            else {
                                return res.status(500).json(err);
                            }
        
                        })
                        
                    })
                })
                
            }
            else {
                return res.status(400).json({ message: "Email Already Exists." })
            }
        }
        else {
            return res.status(500).json(err);
        }
    })

})

router.get('/login', (req, res) => {
    const user = req.body;
    query = "select * from Login where Username=?";
    connection.query(query, [user.username], (err, results) => {
        if (!err) {
            if (results.length <= 0) {
                return res.status(401).json({ message: "Incorrect Username" });
            }
            else {
                    //comparing password
                    bcrypt.compare(user.password, results[0].Password, (err, LoginStatusResponse)=>{
                        if(LoginStatusResponse===true){
                            //Creating result JSon
                            const response = { points: results[0].Points, username: results[0].Username }
                            //Creating Token for Result json
                            const accessToken = jwt.sign(response, process.env.ACCESS_TOKEN, { expiresIn: '3h' })
                            //Token sended
                            res.status(200).json({ token: accessToken });
                        }
                        else if(LoginStatusResponse===false){
                            res.send("Incorrect Password")
                        }
                    })               
            }

        }
        else {
            return res.status(500).json(err);
        }
    })
})

router.get('/get_bet_details', /*auth.authenticateToken,*/ (req, res) => {
    var query = "Select * from Betting_Table";
    connection.query(query, (err, results) => {
        if (!err) {
            return res.status(200).json(results);
        }
        else {
            return res.status(500).json(err);
        }
    })
})

router.post('/update_password', auth.authenticateToken, (req, res) => {
    let user = req.body;
    bcrypt.genSalt(10, (err, salt)=>{
        //hashing password
        bcrypt.hash(user.password, salt, (err, hash) =>{
            console.log(hash)
            var query = "Update Login SET Password=? where Username=?";
            connection.query(query, [hash, user.username], (err, results) => {
                if (!err) {
                    if (results.affectedRows == 0) {
                        return res.status(404).json({ message: "User does not exist" });
                    }
                    return res.status(200).json({ message: "User Updated Successfully" });
                }
                else {
                    return res.status(500).json(err);
                }
            })
            
        })
    })
})

router.get('/checkToken', auth.authenticateToken, (req, res) => {
    return res.status(200).json({ message: "true" });
})



module.exports = router;