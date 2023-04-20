const express = require('express');
const connection = require('../connection');
var router = express.Router();
const jwt = require('jsonwebtoken');

require('dotenv').config();

var auth = require('../services/authentication');
//SP's
//Stored procedure to Transfer Points
router.post('/bet_update_sp', auth.authenticateToken, (req, res) => {
    let user=req.body;
    gamename=user.gamename;
    username=res.locals.username;
    betamount=user.amount;
    bettingno=user.bettingno;
    if(betamount>0){
    var query = "CALL `usp_BetUpdate`(?, ?, ?,?, @p5,?);";
        connection.query(query, [gamename,username,betamount,bettingno,bettingno], (err, results) => {
            if (!err) {
                var string=JSON.stringify(results[0]);
                var json =  JSON.parse(string);
                return res.send(json[0].Status);
            }
            else {
                return res.status(500).json(err);
            }
        })
    }else{
        return res.send("Bet Not Placed");
    }
});

//Stored procedure for taking Dynamic
router.post('/take_sp', auth.authenticateToken, (req, res) => {
    let user=req.body;
    gamename=user.gamename;
    username=res.locals.username;
    var query = "CALL `usp_Take`(?, ?, @p3);";
    connection.query(query, [gamename,username], (err, results) => {
        if (!err) {
            var string=JSON.stringify(results[0]);
            var json =  JSON.parse(string);
            return res.send(json[0].Status);
        }
        else {
            return res.status(500).json(err);
        }
    })
    
});

//Stored procedure for cancel bets
router.post('/cancel_sp', auth.authenticateToken, (req, res) => {
    let user=req.body;
    gamename=user.gamename;
    username=res.locals.username;
    var query = "CALL `usp_CancelBet`(?, ?, @p3);";
    connection.query(query, [gamename,username], (err, results) => {
        if (!err) {
            var string=JSON.stringify(results[0]);
            var json =  JSON.parse(string);
            return res.send(json[0].Status);
        }
        else {
            return res.status(500).json(err);
        }
    })
    
});
//Stored procedure for cancel last bets
router.post('/cancel_last_bet_sp', auth.authenticateToken, (req, res) => {
    let user=req.body;
    gamename=user.gamename;
    bettingno=user.bettingno;
    username=res.locals.username;
    var query = "CALL `usp_CancelLastBet`(?, ?,?, @p4);";
    connection.query(query, [gamename,username,bettingno], (err, results) => {
        if (!err) {
            var string=JSON.stringify(results[0]);
            var json =  JSON.parse(string);
            return res.send(json[0].Status);
        }
        else {
            return res.status(500).json(err);
        }
    })
    
});

router.post('/user_lock_bet', auth.authenticateToken, (req, res) => {
    let user = req.body;
    let username=res.locals.username;
    var query = "Update Login SET Button_Lock='YES' where Username=?";
    connection.query(query, [username], (err, results) => {
        if (!err) {
            if (results.affectedRows == 0) {
                return res.status(404).json({ message: "Bets Didn't locked" });
            }
            return res.status(200).json({ message: "Bets Locked" });
        }
        else {
            return res.status(404).json({ message: "Please Retry"});
        }
    })
})

router.post('/lock_bets', auth.authenticateToken, (req, res) => {
    let user = req.body;
    var query = "Update Login SET Button_Lock='YES'";
    connection.query(query, (err, results) => {
        if (!err) {
            if (results.affectedRows == 0) {
                return res.status(404).json({ message: "Bets Didn't locked" });
            }
            return res.status(200).json({ message: "Bets Locked" });
        }
        else {
            return res.status(404).json({ message: "Please Retry"});
        }
    })
})

router.post('/unlock_bets', auth.authenticateToken, (req, res) => {
    let user = req.body;
    var query = "Update Login SET Button_Lock='NO'";
    connection.query(query, (err, results) => {
        if (!err) {
            if (results.affectedRows == 0) {
                return res.status(404).json({ message: "Bets Didn't locked" });
            }
            return res.status(200).json({ message: "Bets Unlocked" });
        }
        else {
            return res.status(404).json({ message: "Please Retry"});
        }
    })
})

router.post('/get_bet_details', auth.authenticateToken, (req, res) => {
    let user = req.body;
    gamename=user.gamename;
    username=res.locals.username;
    var query = "Select SUM(Amount), Betting_No_String from Betting_Table_User_Retrive where Game_Name=? and Game_ID=(Select Bet_No from On_Going_Bet_ID where Game_Name=?) and Username=? GROUP BY Betting_No_String";
    connection.query(query, [gamename,gamename,username], (err, results) => {
        if (!err) {
            return res.send(results);
        }
        else {
            return res.status(404).json({ message: "Please Retry"});
        }
    })
})

router.post('/get_last_five_bet_details', auth.authenticateToken, (req, res) => {
    let user = req.body;
    gamename=user.gamename;
    username=res.locals.username;
    var query = "SELECT * FROM `Bets_History` ORDER BY Time DESC limit 5";
    connection.query(query, [gamename,gamename,username], (err, results) => {
        if (!err) {
            return res.send(results);
        }
        else {
            return res.status(404).json({ message: "Please Retry"});
        }
    })
})







//We can Delete these After Above Success
//SP prepared just for backup
router.post('/bet_update',auth.authenticateToken, (req, res) => {
    let user=req.body;
    gamename=user.gamename;
    username=res.locals.username;
    betamount=user.amount;
    bettingno=user.bettingno;
    //Getting Current Points
    query = "select Points, Button_Lock from Login where Username=?"
    connection.query(query, [username], (err, results, fields) => {
        if (err) {
            return res.status(404).json({ message: "Please Retry" });
        }
        if(!err){
            if (results.length >= 0) { 
                let Points=results[0].Points;
                let Button_Status=results[0].Button_Lock;
                if(Points>betamount){
                    if(Button_Status==="NO"){
                        //Getting Max BetID
                        query = "select Max(Bet_No) as GameID from On_Going_Bet_ID where Game_Name=?"
                        connection.query(query, [gamename], (err, results, fields) => {
                            if (err) {
                                return res.status(404).json({ message: "Please Retry" });
                            }
                            if(!err){
                                if (results.length >= 0) { 
                                    gameid=results[0].GameID;
                                    let pointsAfterDeduction=Points-betamount;
                                    //Inserting into bet table
                                    query = "insert into Betting_Table(Game_Name, Game_ID, Username, Amount, Betting_No) values (?,?,?,?,?)"
                                    connection.query(query, [gamename,gameid,username,betamount,bettingno], (err, results, fields) => {
                                        if (!err) {
                                            query = "Update Login SET Points=? where Username=?"
                                            connection.query(query, [pointsAfterDeduction, username], (err, results, fields) => {
                                                if (!err) {
                                                    if (results.affectedRows == 0) {
                                                        query = "insert into Betting_Table(Game_Name, Game_ID, Username, Amount, Betting_No) values (?,?,?,?,?)"
                                                        let correctbetAmount=betamount*-1;
                                                        connection.query(query, [gamename,gameid,username,correctbetAmount,bettingno], (err, results, fields) => {
                                                            if (!err) {
                                                                return res.status(404).json({ message: "Please Retry" });
                                                            }
                                                            if (err) {
                                                                //inform admin
                                                            }
                                                        })
                                                    }
                                                    if(results.affectedRows > 0){                                                    
                                                        return res.send();                                                
                                                    }
                                                }if(err){
                                                    query = "insert into Betting_Table(Game_Name, Game_ID, Username, Amount, Betting_No) values (?,?,?,?,?)"
                                                    let correctbetAmount=betamount*-1;
                                                    connection.query(query, [gamename,gameid,username,correctbetAmount,bettingno], (err, results, fields) => {
                                                        if (!err) {
                                                            return res.status(404).json({ message: "Please Retry" });
                                                        }
                                                        if (err) {
                                                            //inform admin
                                                        }
                                                    })                                
                                                }
                                            })                                
                                        }
                                        if (err) {
                                            return res.status(404).json({ message: "Please Retry",err});
                                        }
                                    })
                                }else {
                                    return res.status(400).json({ message: "Wrong Game Name" })
                                }
                            }

                        })
                    }else{
                        return res.status(400).json({ message: "Bet Locked" })
                    }
                }else{
                    return res.status(400).json({ message: "Incufficient Balance" })
                }
            }else {
                return res.status(400).json({ message: "Wrong Username" })
            }
        }

    })
    
});
//SP prepared just for backup
router.post('/take', auth.authenticateToken, (req, res) => {
    let user=req.body;
    gamename=user.gamename;
    username=res.locals.username;

    var query = "Select * from Login where Username=?";
    connection.query(query, [username],(err, results) => {
        if (!err) {
            let pointstotake;
            var query;
            if(gamename==="Roullete"){
                pointstotake=results[0].RoulleteTake;
                query = "Update Login SET Points=?, RoulleteTake=0 where Username=?";
            }if(gamename==="Ghaziabad"){
                pointstotake=results[0].GhaziabadTake;
                query = "Update Login SET Points=?, GhaziabadTake=0 where Username=?";
            }if(gamename==="Fridabad"){
                pointstotake=results[0].FridabadTake;
                query = "Update Login SET Points=?, FridabadTake=0 where Username=?";
            }if(gamename==="Gali"){
                pointstotake=results[0].GaliTake;
                query = "Update Login SET Points=?, GaliTake=0 where Username=?";
            }if(gamename==="Wazirabad"){
                pointstotake=results[0].WazirabadTake;
                query = "Update Login SET Points=?, WazirabadTake=0 where Username=?";
            }
            let updatedPoints=results[0].Points+pointstotake;        
            connection.query(query, [updatedPoints, user.username], (err, results) => {
                if (!err) {
                    if (results.affectedRows == 0) {
                        return res.status(404).json({ message: "User does not exist" });
                    }
                    res.send();
                }
                else {
                    return res.status(500).json(err);
                }
            })
        }
        else {
            return res.status(404).json({ message: "Please Retry" });
        }
    })
})
//SP prepared just for backup
router.post('/cancel_bet', auth.authenticateToken, (req, res) => {
    let user=req.body;
    gamename=user.gamename;
    username=res.locals.username;
    var query = "select * from Login where Username=?";
    connection.query(query, [username],(err, results) => {
        let currentPoints=results[0].Points;
        let Status=results[0].Button_Lock;
        if(Status==="NO"){
            query = "select Max(Bet_No) as GameID from On_Going_Bet_ID where Game_Name=?";
            connection.query(query, [gamename],(err, results) => {
                if (!err) {
                    let gameid=results[0].GameID;
                    query = "select SUM(Amount) as TotalBetPlaced from Betting_Table where Game_ID=? and Game_Name=? and Username=?"
                    connection.query(query, [gameid, gamename, username],(err, results) => {
                        if (!err) {
                            
                            let TotalBetPlaced=results[0].TotalBetPlaced;
                            if(TotalBetPlaced===null){
                                TotalBetPlaced=0;
                            }
                            let UpdatedBalance=currentPoints+TotalBetPlaced;
                            query = "Delete from Betting_Table where Game_ID=? and Game_Name=? and Username=?"
                            connection.query(query, [gameid, gamename, username],(err, results) => {
                                if (!err) {                                    
                                    query = "Update Login SET Points=? where Username=?";                                    
                                    connection.query(query, [UpdatedBalance, username],(err, results) => {
                                        if (!err) {
                                            if (results.affectedRows === 0) {
                                                return res.status(404).json({ message: "Please Contact Customer Care" });
                                            }if (results.affectedRows > 0) {
                                               res.send();
                                            }
                                        }
                                        if (err) {
                                            return res.status(404).json({ message: "Please Contact Customer Care" });
                                        }
                                    })
                                }
                                if (err) {
                                    return res.status(404).json({ message: "Please Retry" });
                                }
                            })
                        }
                        if (err) {
                            return res.status(404).json({ message: "Please Retry" });
                        }
                    })                    
                }
                else {
                    return res.status(404).json({ message: "Please Retry" });
                }
            })
        }
        if(Status==="YES"){
            return res.status(404).json({ message: "Bets Locked" });
        }
    })
    
})
//SP prepared just for backup
router.post('/cancel_last_bet', auth.authenticateToken, (req, res) => {
    let user=req.body;
    gamename=user.gamename;
    bettingno=user.bettingno;
    username=res.locals.username;
    var query = "select * from Login where Username=?";
    connection.query(query, [username],(err, results) => {
        let currentPoints=results[0].Points;
        let Status=results[0].Button_Lock;
        if(Status==="NO"){
            query = "select Max(Bet_No) as GameID from On_Going_Bet_ID where Game_Name=?";
            connection.query(query, [gamename],(err, results) => {
                if (!err) {
                    let gameid=results[0].GameID;
                    query = "select SUM(Amount) as TotalBetPlaced from Betting_Table where Game_ID=? and Game_Name=? and Betting_No=?"
                    connection.query(query, [gameid, gamename, bettingno],(err, results) => {
                        if (!err) {
                            let TotalBetPlaced=results[0].TotalBetPlaced;
                            if(TotalBetPlaced===null){
                                TotalBetPlaced=0;
                            }
                            let UpdatedBalance=currentPoints+TotalBetPlaced;
                            query = "Delete from Betting_Table where Game_ID=? and Game_Name=? and Betting_No=?"
                            connection.query(query, [gameid, gamename, bettingno],(err, results) => {
                                if (!err) {                                    
                                    query = "Update Login SET Points=? where Username=?";                                    
                                    connection.query(query, [UpdatedBalance, username],(err, results) => {
                                        if (!err) {
                                            if (results.affectedRows === 0) {
                                                return res.status(404).json({ message: "Please Contact Customer Care" });
                                            }if (results.affectedRows > 0) {
                                               res.send();
                                            }
                                        }
                                        if (err) {
                                            return res.status(404).json({ message: "Please Contact Customer Care" });
                                        }
                                    })
                                }
                                if (err) {
                                    return res.status(404).json({ message: "Please Retry" });
                                }
                            })
                        }
                        if (err) {
                            return res.status(404).json({ message: "Please Retry" });
                        }
                    })                    
                }
                else {
                    return res.status(404).json({ message: "Please Retry" });
                }
            })
        }
        if(Status==="YES"){
            return res.status(404).json({ message: "Bets Locked" });
        }
    })
    
})



module.exports = router;