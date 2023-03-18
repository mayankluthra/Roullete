//SQL
require('dotenv').config();
const http= require('http');
const app = require('./index');
const server = http.createServer(app);
PORT=process.env.PORT;
PORT2=process.env.PORT2;
server.listen(PORT);



//Firebase
const express = require("express");
const app2 = express();
//const cron =require('node-cron');
//const shell = require ('shelljs');

const admin = require("firebase-admin");
const credentials = require("./key.json");

admin.initializeApp({
    credential: admin.credential.cert(credentials)
});

app2.use(express.json());

app2.use(express.urlencoded({extended: true}));

//Api to create new user space
app2.post('/create', async (req, res ) => {
    try{
        const usersCount = db.collection("users").doc("AllIDs");
        let response = await usersCount.get(); 
        
        let Count=response.data().Count;
        
        const id = req.body.id;
        const userJson = {
            Email:id,
            Name: req.body.name,
            SessionKey: "xxxxxxxxxxxxxxxxxxxxx",
            Points: 0,
            RoulleteTake: 0,
            GhaziabadTake: 0,
            GaliTake: 0,
            FaridabadTake: 0,
            WazirabadTake: 0
        };
        let Ename="Email"+(Count+1)
        const AllIDs = {
            [Ename]:id,
            Count: Count+1
        };
        const RoulleteBetsSetJson = {
            Roullete0: 300,
            Roullete00: 300,
            Roullete1: 300,
            Roullete2: 300,
            Roullete3: 300,
            Roullete4: 300,
            Roullete5: 300,
            Roullete6: 300,
            Roullete7: 300,
            Roullete8: 300,
            Roullete9: 300,
            Roullete10: 300,
            Roullete11: 300,
            Roullete12: 300,
            Roullete13: 300,
            Roullete14: 300,
            Roullete15: 300,
            Roullete16: 300,
            Roullete17: 300,
            Roullete18: 300,
            Roullete19: 300,
            Roullete20: 300,
            Roullete20: 300,
            Roullete21: 300,
            Roullete22: 300,
            Roullete23: 300,
            Roullete24: 300,
            Roullete25: 300,
            Roullete26: 300,
            Roullete27: 300,
            Roullete28: 300,
            Roullete29: 300,
            Roullete30: 300,
            Roullete31: 300,
            Roullete32: 300,
            Roullete33: 300,
            Roullete34: 300,
            Roullete35: 300,
            Roullete36: 300,
            RoulleteFirstLand: 300,
            RoulleteSeondLand: 300,
            RoulleteThirdLand: 300,
            RoulleteFistTwelve: 300,
            RoulleteSecondTwelve: 300,
            RoulleteThirdTwelve: 300,
            RoulleteRed: 300,
            RoulleteRoulletelack: 300,
            RoulleteFirstHalf: 300,
            RoulleteSecondHalf: 300,
            RoulleteEven: 300,
            RoulleteOdd: 0
        };
        const DarbarBetsSetJson = {
            0: 0,
            1: 0,
            2: 0,
            3: 0,
            4: 0,
            5: 0,
            6: 0,
            7: 0,
            8: 0,
            9: 0,
            10: 0,
            11: 0,
            12: 0,
            13: 0,
            14: 0,
            15: 0,
            16: 0,
            17: 0,
            18: 0,
            19: 0,
            20: 0,
            20: 0,
            21: 0,
            22: 0,
            23: 0,
            24: 0,
            25: 0,
            26: 0,
            27: 0,
            28: 0,
            29: 0,
            30: 0,
            31: 0,
            32: 0,
            33: 0,
            34: 0,
            35: 0,
            36: 0,
            37: 0,
            38: 0,
            39: 0,
            40: 0,
            41: 0,
            42: 0,
            43: 0,
            44: 0,
            45: 0,
            46: 0,
            47: 0,
            48: 0,
            49: 0,
            50: 0,
            51: 0,
            52: 0,
            53: 0,
            54: 0,
            55: 0,
            56: 0,
            57: 0,
            58: 0,
            59: 0,
            60: 0,
            61: 0,
            62: 0,
            63: 0,
            64: 0,
            65: 0,
            66: 0,
            67: 0,
            68: 0,
            69: 0,
            70: 0,
            71: 0,
            72: 0,
            73: 0,
            74: 0,
            75: 0,
            76: 0,
            77: 0,
            78: 0,
            79: 0,
            80: 0,
            81: 0,
            82: 0,
            83: 0,
            84: 0,
            85: 0,
            86: 0,
            87: 0,
            88: 0,
            89: 0,
            90: 0,
            91: 0,
            92: 0,
            93: 0,
            94: 0,
            95: 0,
            96: 0,
            97: 0,
            98: 0,
            99: 0,
            100: 0,
            //1to10,11to20.....91to100;(Landscape)
            110: 0,
            120: 0,
            130: 0,
            140: 0,
            150: 0,
            160: 0,
            170: 0,
            180: 0,
            190: 0,
            200: 0,
            //1,11,21,..91(upside)
            //2,22,32,42,...92(upside)
            101: 0,
            102: 0,
            103: 0,
            104: 0,
            105: 0,
            106: 0,
            107: 0,
            108: 0,
            109: 0,
            111: 0,
            Red: 0,
            Black: 0,
            FirstHalf: 0,
            SecondHalf: 0,
            Even: 0,
            Odd: 0
        }
        db.collection("users").doc(id).set(userJson);
        db.collection("users").doc(id).collection("Bets").doc("Roullete").set(RoulleteBetsSetJson);
        db.collection("users").doc(id).collection("Bets").doc("Ghaziabad").set(DarbarBetsSetJson);
        db.collection("users").doc(id).collection("Bets").doc("Fridabad").set(DarbarBetsSetJson);
        db.collection("users").doc(id).collection("Bets").doc("Gali").set(DarbarBetsSetJson);
        db.collection("users").doc(id).collection("Bets").doc("Wazirabad").set(DarbarBetsSetJson);
        db.collection("users").doc("AllIDs").update(AllIDs);
        //const response = db.collection("users").doc(id).set(userJson);
        res.send(response);
    } catch(error) {
        res.send(error);
    }
});

//Api to Get all Members Details
app2.get('/read_all',async (req, res) => {
    try{
        const usersRef = db.collection("users");
        const response = await usersRef.get();
        let responseArr = [];
        response.forEach(doc => {
            responseArr.push(doc.data().Email);
        });
        res.send(responseArr);
    } catch(error){
        res.send(error);
    }
});

//Api to Get single Member Details
app2.get('/read', async (req, res) => {
    try{
        const id= req.body.id;
        const usersRef = db.collection("users").doc(id);
        const response = await usersRef.get();
        const UserSessionKey=req.body.sessionKey;
        if(UserSessionKey.search("P2I2H2T3G")===28){
            res.send(response.data());
        }
    } catch(error){
        res.send(error);
    }
})

//Reset Bets
app2.post('/update_reset_all', async(req, res) => {
    try{
        const id=req.body.id;
        const Game=req.body.game;
        const usersRef = db.collection("users").doc(id).collection("Bets").doc(Game);
        const usersRef1 = db.collection("users").doc(id);
        let response = await usersRef1.get();                
        const UserSessionKey=req.body.sessionKey;       
        let ServerSessionKey=response.data().SessionKey;
        if(ServerSessionKey===UserSessionKey){
            if(Game!="Roullete"){
                usersRef.update({
                    0: 0,
                    00: 0,
                    1: 0,
                    2: 0,
                    3: 0,
                    4: 0,
                    5: 0,
                    6: 0,
                    7: 0,
                    8: 0,
                    9: 0,
                    10: 0,
                    11: 0,
                    12: 0,
                    13: 0,
                    14: 0,
                    15: 0,
                    16: 0,
                    17: 0,
                    18: 0,
                    19: 0,
                    20: 0,
                    20: 0,
                    21: 0,
                    22: 0,
                    23: 0,
                    24: 0,
                    25: 0,
                    26: 0,
                    27: 0,
                    28: 0,
                    29: 0,
                    30: 0,
                    31: 0,
                    32: 0,
                    33: 0,
                    34: 0,
                    35: 0,
                    36: 0,
                    37: 0,
                    38: 0,
                    39: 0,
                    40: 0,
                    41: 0,
                    42: 0,
                    43: 0,
                    44: 0,
                    45: 0,
                    46: 0,
                    47: 0,
                    48: 0,
                    49: 0,
                    50: 0,
                    51: 0,
                    52: 0,
                    53: 0,
                    54: 0,
                    55: 0,
                    56: 0,
                    57: 0,
                    58: 0,
                    59: 0,
                    60: 0,
                    61: 0,
                    62: 0,
                    63: 0,
                    64: 0,
                    65: 0,
                    66: 0,
                    67: 0,
                    68: 0,
                    69: 0,
                    70: 0,
                    71: 0,
                    72: 0,
                    73: 0,
                    74: 0,
                    75: 0,
                    76: 0,
                    77: 0,
                    78: 0,
                    79: 0,
                    80: 0,
                    81: 0,
                    82: 0,
                    83: 0,
                    84: 0,
                    85: 0,
                    86: 0,
                    87: 0,
                    88: 0,
                    89: 0,
                    90: 0,
                    91: 0,
                    92: 0,
                    93: 0,
                    94: 0,
                    95: 0,
                    96: 0,
                    97: 0,
                    98: 0,
                    99: 0,
                    100: 0,
                    101: 0,
                    102: 0,
                    103: 0,
                    104: 0,
                    105: 0,
                    106: 0,
                    107: 0,
                    108: 0,
                    109: 0,
                    110: 0,
                    120: 0,
                    130: 0,
                    140: 0,
                    150: 0,
                    160: 0,
                    170: 0,
                    180: 0,
                    190: 0,
                    200: 0,
                    Black: 0,
                    Red: 0,
                    Even: 0,
                    Odd: 0,
                    FirstHalf: 0,
                    SecondHalf: 0,            
                })
            }
            if(Game==="Roullete"){
                usersRef.update({
                    0: 0,
                    00: 0,
                    1: 0,
                    2: 0,
                    3: 0,
                    4: 0,
                    5: 0,
                    6: 0,
                    7: 0,
                    8: 0,
                    9: 0,
                    10: 0,
                    11: 0,
                    12: 0,
                    13: 0,
                    14: 0,
                    15: 0,
                    16: 0,
                    17: 0,
                    18: 0,
                    19: 0,
                    20: 0,
                    20: 0,
                    21: 0,
                    22: 0,
                    23: 0,
                    24: 0,
                    25: 0,
                    26: 0,
                    27: 0,
                    28: 0,
                    29: 0,
                    30: 0,
                    31: 0,
                    32: 0,
                    33: 0,
                    34: 0,
                    35: 0,
                    36: 0,
                    Black: 0,
                    Red: 0,
                    Even: 0,
                    Odd: 0,
                    FirstHalf: 0,
                    SecondHalf: 0, 
                    FirstLand: 0,
                    SecondLand: 0,
                    ThirdLand: 0,
                    FirstTwelve: 0,
                    SecondTwelve: 0,
                    ThirdTwelve: 0          
                })
            }
            res.send();
        }else{
            res.send("logout");
        }
    } catch(error){
        res.send(error);
    }
});

//Transfer Points Api
app2.post('/update_transfer', async(req, res) => {
    try{
        const id=req.body.id;
        const SenderId=req.body.senderid;
        const TransferAmount=req.body.transferamount;
        let usersRef = db.collection("users").doc(id);

        let response = await usersRef.get();        
        const UserSessionKey=req.body.sessionKey;       
        let ServerSessionKey=response.data().SessionKey;
        if(ServerSessionKey===UserSessionKey){
            let currentPoints=parseFloat(response.data().Points);
            let date_ob = new Date();
            // current date
            // adjust 0 before single digit date
            let date = ("0" + date_ob.getDate()).slice(-2);
            // current month
            let month = ("0" + (date_ob.getMonth() + 1)).slice(-2);
            // current year
            let year = date_ob.getFullYear();
            // current hours
            let hours = date_ob.getHours();
            // current minutes
            let minutes = date_ob.getMinutes();
            // current seconds
            let seconds = date_ob.getSeconds();

            // prints date & time in YYYY-MM-DD HH:MM:SS format
            let dateTime=year + month + date + hours + minutes + seconds;

            if(currentPoints>TransferAmount && TransferAmount>0 /*&& SenderId!=id*/){
                let updatedPoints=currentPoints-TransferAmount;
                usersRef.update({
                    Points: updatedPoints
                });
                let usersRef1 = db.collection("users").doc(id).collection("Passbook").doc(dateTime);
                let SendReceiveJson = {
                    SenderID:id,
                    ReceiverID: SenderId,
                    Points: TransferAmount,
                    Time: date_ob,
                    OldBalance:currentPoints,
                    NewBalance: updatedPoints
                };            
                usersRef1.set(SendReceiveJson);

                //Receiver Update
                usersRef = db.collection("users").doc(SenderId);

                response = await usersRef.get();
                currentPoints=parseFloat(response.data().Points);

                updatedPoints=currentPoints+TransferAmount;
                usersRef1 = db.collection("users").doc(SenderId).collection("Passbook").doc(dateTime);
                SendReceiveJson = {
                    SenderID:SenderId,
                    ReceiverID: id,
                    Points: TransferAmount,
                    Time: date_ob,
                    OldBalance:currentPoints,
                    NewBalance: updatedPoints
                }; 
                usersRef1.set(SendReceiveJson);
                usersRef.update({
                    Points: updatedPoints
                });
                res.send();
            }
            else{
                res.send();
            }
        }else{
            res.send("logout")
        }
    } catch(error){
        res.send(error);
    }
});

// Dynamic Single bet update
app2.post('/update_single', async(req, res) => {
    try{
        const id=req.body.id;
        const Game=req.body.game;
        const BetToUpdate=req.body.bettoupdate;
        const BetAmount=req.body.bettingamount;

        const usersRef = db.collection("users").doc(id);
        let response = await usersRef.get();
        const UserSessionKey=req.body.sessionKey;       
        let ServerSessionKey=response.data().SessionKey;
        if(ServerSessionKey===UserSessionKey){
            let currentPoints=parseFloat(response.data().Points);

            if(currentPoints>BetAmount && BetAmount>0){
                currentPoints=currentPoints-BetAmount;
                const usersRef1 = db.collection("users").doc(id).collection("Bets").doc(Game);
                let responseCurrentBetAmount = await usersRef1.get();
                let CurrentBetAmount=responseCurrentBetAmount.data();

                CurrentBetAmount=JSON.parse(JSON.stringify(CurrentBetAmount))[BetToUpdate];
                let UpdatedBetAmount=CurrentBetAmount+BetAmount;
                usersRef1
                .update({
                    [BetToUpdate]: UpdatedBetAmount
                })
                usersRef.update({
                    Points: currentPoints
                })
                res.send();
            }
            else if(BetAmount>=currentPoints || BetAmount<0){
                res.send("Incufficient Points");
            }
        }else{
            res.send("logout")
        }
    } catch(error){
        res.send(error);
    }
});

//Credit Take to Points
//Points Update
app2.post('/update_points_take', async(req, res) => {
    try{
        const id=req.body.id;
        const Game=req.body.game+"Take"; 
        const usersRef = db.collection("users").doc(id);
        let response = await usersRef.get();        
        const UserSessionKey=req.body.sessionKey;       
        let ServerSessionKey=response.data().SessionKey;
        if(ServerSessionKey===UserSessionKey){
            let currentPoints=parseFloat(response.data().Points);
            let TakePoints=0;

            if(Game==="RoulleteTake"){            
                TakePoints=parseFloat(response.data().RoulleteTake);
            }
            if(Game==="GhaziabadTake"){            
                TakePoints=parseFloat(response.data().GhaziabadTake);
            }
            if(Game==="WazirabadTake"){            
                TakePoints=parseFloat(response.data().WazirabadTake);
            }
            if(Game==="FridabadTake"){            
                TakePoints=parseFloat(response.data().FridabadTake);
            }
            if(Game==="GaliTake"){            
                TakePoints=parseFloat(response.data().GaliTake);
            }        
            updatedPoints=currentPoints+TakePoints;
            try{
                usersRef
                .update({
                    Points: updatedPoints,
                    [Game]: 0
                })
            }catch(error){
                usersRef
                .update({
                    Points: currentPoints,
                    [Game]: TakePoints
                    
                })
                
                res.send("Please Retry");
                
            }
            response = await usersRef.get();  
            res.send("");   
        }
        else{
            res.send("logout");
        }      
    } catch(error){
        res.send(error);
    }

});

//Create Session Key
app2.post('/create_session_key', async(req, res) =>{
    const id=req.body.id;
    const usersRef = db.collection("users").doc(id);
    let sessionKey="JAK45TYSH"+Math.random(100)+"P2I2H2T3G"+Math.random(100)+"I3SIFB4GE"+Math.random(100);
    usersRef.update({
        SessionKey: sessionKey
    })
    res.send();
});

const db = admin.firestore();

app2.listen(PORT2, () => {
    console.log(`Server is running on PORT ${PORT2}.`);
});

