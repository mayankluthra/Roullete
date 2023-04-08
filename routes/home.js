const express = require('express');
const connection = require('../connection');
var router = express.Router();
const jwt = require('jsonwebtoken');
//get DateTime
let dt=new Date();
let date=("0"+dt.getDate()).slice(-2);
let month = ("0"+(dt.getMonth()+1)).slice(-2);
let year=dt.getFullYear();
let hour=dt.getHours();
let Minutes=dt.getMinutes();
let seconds=dt.getSeconds();
var Time=year+"-"+month+"-"+date+" "+hour+":"+Minutes+":"+seconds;

require('dotenv').config();

var auth = require('../services/authentication');

router.post('/get_passbook', auth.authenticateToken, (req, res) => {
    let user = req.body;
    let username=res.locals.username
    console.log(req);
    var query = "Select * from Passbook where Username=? order by Time desc limit ?";
    connection.query(query, [username, Number(user.loadcount)], (err, results) => {
        if (!err) {
            return res.send(results)
        }
        else {
            return res.status(500).json(err);
        }
    })
});
//Stored procedure to Transfer Points
router.post('/transfer_points_sp', auth.authenticateToken, (req, res) => {
    let user = req.body;
    let senderUsername=user.senderUsername;
    let username=res.locals.username
    let pointstotransfer=Number(user.transferpoint);
    if(username!=senderUsername && pointstotransfer>0){
    var query = "CALL `usp_TransferPoints`(?, ?, ?, @p3);";
        connection.query(query, [senderUsername,username,pointstotransfer], (err, results) => {
            if (!err) {
                var string=JSON.stringify(results[0]);
                var json =  JSON.parse(string);
                return res.send({ message: json[0].Status});
                //return res.send(json[0].Status);
            }
            else {
                return res.status(500).json(err);
            }
        })
    }else{
        return res.send("You can't send to yourself");
    }
});

//Just for backup
router.post('/transfer_points',auth.authenticateToken, (req, res) => {
    let user = req.body;
    let senderUsername=user.senderUsername;
    let username=user.username;
    let pointstotransfer=user.transferpoint;
    //Getting points from main account
    query = "select Points from Login where Username=?"
    connection.query(query, [username], (err, results, fields) => {
        if (err) {
            return res.status(404).json({ message: "Please Retry" });
        }
        if (!err) {
            if (results.length >= 0) { 
                let oldPoints=results[0].Points; 
                //If sender has more points then the transferd try amount then proceed further
                if(oldPoints>pointstotransfer){
                    let NewPoints=results[0].Points-pointstotransfer;
                    //Updated balance after deduction
                    query= "Update Login SET Points=? where Username=?"
                    connection.query(query, [NewPoints, username], (err, results) => {
                        if (!err) {
                            if (results.affectedRows == 0) {
                                return res.status(404).json({ message: "Please Retry" });
                            }
                            //Successfully deducted
                            if(results.affectedRows > 0){
                                //Making a entry in passbook of main account
                                query= "insert into Passbook(Username, Debit, Credit, Time) values (?,?,?,?)"
                                connection.query(query, [username, pointstotransfer, 0, Time], (err, results, fields) => {
                                    if (!err) {
                                        //Making a entry in passbook of receivers account
                                        query= "insert into Passbook(Username, Debit, Credit, Time) values (?,?,?,?)"
                                        connection.query(query, [senderUsername, 0 , pointstotransfer, Time], (err, results, fields) => {
                                            if (!err) {
                                                ///////////////////////
                                                query= "select Points from Login where Username=?"
                                                connection.query(query, [senderUsername], (err, Senderresults) => {
                                                    if (err) {
                                                         //If error occued Points are getting back credieted to main account
                                                        query= "Update Login SET Points=? where Username=?"
                                                        connection.query(query, [oldPoints, username], (err, results) => {
                                                            if (!err) {
                                                                if (results.affectedRows == 0) {
                                                                    return res.status(404).json({ message: "If your points has been debited please contact Customer car imediately" });
                                                                }
                                                                if(results.affectedRows > 0){
                                                                    return res.status(404).json({ message: "Please Retry" });
                                                                
                                                                }
                                                            }

                                                        })
                                                        return console.log(err);
                                                    }
                                                    if (!err) {
                                                        let PointsAfterCredit=Senderresults[0].Points+pointstotransfer;
                                                        query= "Update Login SET Points=? where Username=?"
                                                        connection.query(query, [PointsAfterCredit, senderUsername], (err, results) => {
                                                            if (!err) {
                                                                return res.status(404).json({ message: "Points Sucessfully Transfered" });
                                                            }
                                                            if (err) {
                                                                //Updating to old points
                                                                query= "Update Login SET Points=? where Username=?"
                                                                connection.query(query, [oldPoints, username], (err, results) => {
                                                                    if (!err) {
                                                                        if (results.affectedRows == 0) {
                                                                            return res.status(404).json({ message: "If your points has been debited please contact Customer car imediately" });
                                                                        }
                                                                        if(results.affectedRows > 0){
                                                                            return res.status(404).json({ message: "Please Retry" });
                                                                        
                                                                        }
                                                                    }

                                                                })
                                                                return res.status(500).json(err);
                                                            }
                                                            
                                                        })
                                                    }      
                                                })
                                            } 
                                            if (err) {
                                                        //Updating to old points
                                                        query= "Update Login SET Points=? where Username=?"
                                                        connection.query(query, [oldPoints, username], (err, results) => {
                                                            if (!err) {
                                                                if (results.affectedRows == 0) {
                                                                    return res.status(404).json({ message: "If your points has been debited please contact Customer car imediately" });
                                                                }
                                                                if(results.affectedRows > 0){
                                                                    return res.status(404).json({ message: "Please Retry" });
                                                                
                                                                }
                                                            }

                                                        })
                                                        return res.status(500).json(err);
                                            }
                                
                                        })
                                    }if(err){
                                                //If error occued Points are getting back credieted to main account
                                                query= "Update Login SET Points=? where Username=?"
                                                connection.query(query, [oldPoints, username], (err, results) => {
                                                    if (!err) {
                                                        if (results.affectedRows == 0) {
                                                            return res.status(404).json({ message: "If your points has been debited please contact Customer car imediately" });
                                                        }
                                                        if(results.affectedRows > 0){
                                                            return res.status(404).json({ message: "Please Retry" });
                                                        
                                                        }
                                            }

                                        })
                                        return res.status(500).json(err);
                                    }
                        
                                })
                            }
                        }
                        else {
                            return res.status(404).json({ message: "Please Retry" });
                        }
                    })
                }
                //Incufficient balance
                else{
                    return res.status(400).json({ message: "Incufficient Balance" })
                }
                const response = { points: results[0].Points, userid: results[0].UserID }             
            }
            else {
                return res.status(400).json({ message: "Wrong Username" })
            }
        }
        else {
            return res.status(500).json(err);
        }
    })

})


module.exports = router;