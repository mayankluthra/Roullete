var express = require('express');
var cors = require('cors');
const userRoute =require('./routes/user');
const homeRoute =require('./routes/home');
const GameCommonsRoute =require('./routes/GameCommons');
const RoulleteRoute=require('./routes/roullete');
const app = express();

app.use(cors());
app.use(express.urlencoded({extended: true}));
app.use(express.json());
app.use('/user',userRoute);
app.use('/home',homeRoute);
app.use('/gamecommons',GameCommonsRoute);
app.use('/roullete',RoulleteRoute);


module.exports = app;
