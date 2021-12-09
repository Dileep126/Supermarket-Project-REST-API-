var express = require('express');
var router = express.Router();
var api_helper = require('../service/api_helper');
 
/* GET home page. */
 
router.get('/', function(req, res, next) {
 // res.render('index', { title: 'Express' });
 res.render('index');
});

router.get('/main-menu', function(req, res, next){
  res.render("main-menu", {

    title:"you are in"
  });
    

});

router.get('/get-all-products', (req, res) => {
  api_helper.make_API_call('http://localhost:8081/product-management-app/rest/products')
  .then(response => {
    res.json(response)
  })
  .catch(error => {
    res.send(error)
  })
})
 
 
// router.post("/subscribe", function(req, res, next) {
//   const { name, email } = req.body;
 
//   // 1. Validate the user data
//   // 2. Subscribe the user to the mailing list
//   // 3. Send a confirmation email
 
//   res.render("subscribed", {
//     title: "You are subscribed",
//     name,
//     email
//   });
// });
 
router.post('/get-products/:id', (req, res) => {
  // res.send(req.params.id);
  let product_master_id= req.params.id;
  console.log(product_master_id);
  //api_helper.make_API_call('https://jsonplaceholder.typicode.com/todos/req.params.id')
  api_helper.make_API_call('http://localhost:8081/product-management-app/rest/products'+product_master_id)
  .then(response => {
    res.json(response)
  })
  .catch(error => {
    res.send(error)
  })
})
 
 

 
module.exports = router;
 
