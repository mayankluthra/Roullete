const cron = require('node-cron')
const express = require('express');
const connection = require('../connection');
var router = express.Router();
const jwt = require('jsonwebtoken');
let i=process.env.Time;

var auth = require('../services/authentication');

const shell = require('shelljs')

cron.schedule("* * * * * *",function(){
    //Timer for 60 seconds
    if(i==0){
        i=process.env.Time;
        var query = "Update Login SET Button_Lock='NO'";
        connection.query(query, (err, results) => {            
        })
    }
    i--;
    //updating Timer
    var query = "Update Timer SET Timer=?";
    connection.query(query,[i], (err, results) => {
        if (!err) {
            if (results.affectedRows == 0) {
            }
        }
        else {
        }
    });

    //Locking on time 10
    if(i===10){
        var query = "Update Login SET Button_Lock='YES'";
        connection.query(query, (err, results) => {            
        })
    }

    //Calculate Winning Amount
    if(i===2){
        let TotalBet;
        let MAXWin;
        //Getting the Max Win
        query="SELECT RoulleteMaxWinning from Timer"
        connection.query(query, (err, results) => {
            if(!err){
                MAXWin=results[0].RoulleteMaxWinning;
            }
        })
        //Getting TotalAmount of Bet Placed
        query="SELECT SUM(Amount) as TotalBet from Betting_Table where Game_ID=(Select MAX(Game_ID) from Betting_Table) and Game_Name='Roullete'"
        
        connection.query(query, (err, results) => {
            if(!err){
                TotalBet=results[0].TotalBet;
                //console.log(TotalBet);
            }
        })
        //Loyal Array
        let LoyalMode=['W','L','SL','SW'];
        let LossMode=['L','SL','SL']
        //Generating random no.
        function getRandomNumber(min,max){
            let step1= max-0+1;
            let step2 = Math.random() * step1;
            let result = Math.floor(step2) + min;
            return result;
        }
        
        //console.log(LoyalMode[getRandomNumber(0,LoyalMode.length-1)]);
        let Result=LoyalMode[getRandomNumber(0,LoyalMode.length-1)];
        let ShareforBetOpen;
        if(Result==='W'){
            //? TotalBet & ? MaxWin
            query="SELECT Betting_No,SUM(Amount), SUM(Amount*36) as WinningAmount FROM `Betting_Table` where Game_ID=(Select MAX(Game_ID) from Betting_Table) and Game_Name='Roullete' GROUP BY Betting_No HAVING WinningAmount > ? and WinningAmount<? ORDER BY WinningAmount"
        
        }if(Result==='SW'){
            query="SELECT Betting_No,SUM(Amount), SUM(Amount*36) as WinningAmount FROM `Betting_Table` where Game_ID=(Select MAX(Game_ID) from Betting_Table) and Game_Name='Roullete' GROUP BY Betting_No HAVING WinningAmount > ? and WinningAmount<? ORDER BY WinningAmount limit 1"
        
        }if(Result==='L'){
            query="SELECT Betting_No,SUM(Amount), SUM(Amount*36) as WinningAmount FROM `Betting_Table` where Game_ID=(Select MAX(Game_ID) from Betting_Table) and Game_Name='Roullete' GROUP BY Betting_No HAVING WinningAmount < ? ORDER BY WinningAmount"
        
        }if(Result==='SL'){
            query="SELECT Betting_No,SUM(Amount), SUM(Amount*36) as WinningAmount FROM `Betting_Table` where Game_ID=(Select MAX(Game_ID) from Betting_Table) and Game_Name='Roullete' GROUP BY Betting_No HAVING WinningAmount < ? ORDER BY WinningAmount DESC limit 5"
        
        }
        if(Result==='W' || Result==='SW'){
            connection.query(query,[TotalBet, MAXWin], (err, results) => {
                if(!err){
                    //console.log("W"+TotalBet);
                }
            })
        }
        if(Result==='L' || Result==='SL'){
            connection.query(query,[TotalBet], (err, results) => {
                if(!err){
                    //console.log("L"+TotalBet);
                }
            })
        }
    }

    //Update betID
    if(i===3){
        var query = "Update On_Going_Bet_ID SET Bet_No=Bet_No+1 where Game_Name='Roullete'";
        connection.query(query, (err, results) => {            
        })
    }
});

//Time fetch
router.post('/get_Time', auth.authenticateToken, (req, res) => {
    var query = "Select Timer from Timer";
    connection.query(query, (err, results) => {
        if (!err) {
            return res.send(results)
        }
        else {
            return res.status(500).json(err);
        }
    })
});

module.exports = router;