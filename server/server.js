const express = require('express')
var mysql = require('mysql2');
var cors = require('cors');

const app = express();
const bodyParser = require('body-parser');

// const crypto = require('crypto'),
//   fs = require("fs"),
//   https = require("https");
/////
// var privateKey = fs.readFileSync('privatekey.pem').toString();
// var certificate = fs.readFileSync('certificate.pem').toString();

// var credentials = crypto.createCredentials({key: privateKey, cert: certificate});

// var handler = function (req, res) {
//   res.writeHead(200, {'Content-Type': 'text/plain'});
//   res.end('Hello World\n');
// };

// var server = https.createServer();
// server.setSecure(credentials);
// server.addListener("request", handler);
// server.listen(8000);

///////

app.use((req, res, next) => {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers",
      "Origin, X-Requeted-With, Content-Type, Accept, Authorization, RBR");
      res.header("Access-Control-Allow-Methods", "GET, POST, PUT, PATCH, DELETE");
    if (req.headers.origin) {
      res.header('Access-Control-Allow-Origin', req.headers.origin);
    }
    if (req.method === 'OPTIONS') {
      res.header("Access-Control-Allow-Methods", "GET, POST, PUT, PATCH, DELETE");
      return res.status(200).json({});
    }
    next();
   });

app.use(cors());
app.options('*', cors());

app.use(bodyParser.urlencoded({ extended: true }));
app.use(bodyParser.json());

var conexao = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "root",
    database: "UI11"
});

app.listen(8000, () => {
  console.log('Server started!')
})

app.route('/api/products').get((req, res) => {
    console.log(info()+" products request.... ");
    var sql = " SELECT P.id, P.name AS name, P.price, P.description, P.imagePath, C.name AS categoryName FROM "
        +" products AS P INNER JOIN category_list AS C ON P.categoryId=C.Id;";
    conexao.query(sql, function(err, result, fields){
        if(err){
            console.log(info()+" "+err);
            res.send(info()+": dbErr...");
        }
        else
        {
            console.log(info()+" "+result);
            res.send(result);
        }
    });
});


app.route('/api/showCart').get((req, res) => {
    console.log(info()+" products request.... ");
    // var data = req.body;
    var sql = " SELECT P.id, P.name AS name, P.price, P.imagePath, C.quantity  FROM "
        +" (products AS P INNER JOIN cart AS C ON P.id=C.productId) "
        +"  WHERE C.userId="+parseInt(req.query.params, 10)+";";
    conexao.query(sql, function(err, result, fields){
        if(err){
            console.log(info()+" "+err);
            res.send(info()+": dbErr...");
        }
        else
        {
            console.log(info()+" "+result);
            res.send(result);
        }
    });
});

app.route('/api/addCart').post((req, res) => {
    console.log(req.body);
    var data = req.body;
    console.log(data.productId);
    console.log(info()+"adding product.... ");
    var sql = "INSERT INTO cart (userId,productId, quantity) VALUES(?, ?, ?)";
    conexao.query(sql, [data.userId, data.productId, data.quantity], function(err, result){
        if(err){
            console.log(info()+":02 "+err);
            res.send(info()+": dbErr02...");
        }
        else
        {
            console.log(info()+" "+ result);
            res.send(result);
        }
    });
})

app.route('/api/updateCart').post((req, res) => {
    console.log(req.body);
    var Array = req.body;
    console.log("array length",Array.length);
    console.log(info()+"updating product.... ");
    for(var i=0; i<Array.length; i++){
    var sql = "UPDATE cart SET quantity="+ Array[i].quantity+" WHERE productID="+Array[i].productId+";";
    conexao.query(sql, function(err, result){
        
    });
}
})

app.route('/api/insertShopperOrder').post((req, res) => {
    console.log(req.body);
    var data = req.body;
    console.log();
    console.log(info()+"adding product.... ");
    var sql = "INSERT INTO shopper_orders (timeStamp,totalAmount, status, userId) VALUES(now(), ?, ?, ?)";
    conexao.query(sql, [ data.totalAmount, data.status, data.userId], function(err, result){
        if(err){
            console.log(info()+":02 "+err);
            res.send(info()+": dbErr02...");
        }
        else
        {
            console.log(info()+" "+ result);
            res.send(result);
        }
    });
})

function info()
{
    now = new Date();
    return now.getTime();
}