var express = require('express');
var router = express.Router();
var api_helper = require('../service/api_helper');

router.get('/main-menu', function(req, res, next){
    res.render("main-menu", {
  
      title:"you are in"
    });
      
  
  });

 
router.get('/add-product', function(req, res, next) {
    // res.render('index', { title: 'Express' });
    res.render('add-products');
   });

router.get('/delete-product', function(req, res, next) {
    // res.render('index', { title: 'Express' });
    res.render('delete-products');
   });   

router.get('/get-product', function(req, res, next) {
    // res.render('index', { title: 'Express' });
    res.render('get-products');
   });   

router.get('/update-product', function(req, res, next) {
    // res.render('index', { title: 'Express' });
    res.render('update-product-by-id');
   });   
   

router.post('/get-product-by-id', (req, res) => {
  // res.send(req.params.id);
  let productMasterId= req.body.id;
  //console.log(taxcode);

  api_helper.make_API_call('http://localhost:8081/product-management-app/rest/products/'+productMasterId)
  .then(response => {
		// res.json(response)
        res.render('show-product', {product : response});
	})
	.catch(error => {
		res.send(error)
	})
})


router.get('/get-all-products', (req, res) => {
	api_helper.make_API_call('http://localhost:8081/product-management-app/rest/products') 
  .then(response => {
		//res.json(response)
        // let taxes= response;
        //console.log(taxes);
       // res.json(taxes);
       res.render('show-products', {products : response});

	})
	.catch(error => {
		res.send(error)
	})
})


router.post('/add-product', (req, res) => {

var jsonData= {
    "productMasterId": req.body.product_master_id,
    "productName": req.body.category,
    "category": req.body.type,
    "brand": req.body.brand,
    "type": req.body.product_name,
    "productDetails": {
        "size": req.body.size,
        "color": req.body.color,
        "weight": req.body.weight,
        "specific_details": req.body.specific_details
        
       
    }
    };
  console.log(jsonData);
  api_helper.add_API_call('http://localhost:8081/product-management-app/rest/products',jsonData) 
    .then(response => {
		res.json(response)
	})
	.catch(error => {
		res.send(error)
	})
})


router.post('/delete-product', (req, res) => {   
    
    var jsonData= {
        "productMasterId": req.body.product_master_id,
        "productName": null,
        "category": null,
        "brand": null,
        "type": null,
        "image": null,
        "productDetails": null  
        };
     
      api_helper.delete_API_call('http://localhost:8081/product-management-app/rest/products',jsonData) 
        .then(response => {
            res.json(response)
        })
        .catch(error => {
            res.send(error)
        })
    })

    router.post('/update-product', (req, res) => {
        // res.send(req.params.id);
        let product_master_id= req.body.id
        //console.log(taxcode);
          
        api_helper.make_API_call('http://localhost:8081/product-management-app/rest/products/'+product_master_id)
        .then(response => {
              // res.json(response)
              res.render('update-products', {products : response});
          })
          .catch(error => {
              res.send(error)
          })
      })

      /*
        The following method is called when the user clicks on update
        button of the update-tax.hbs 
      */
router.post('/post-update-products', (req, res) => {      
        
        var jsonData= {
            "productMasterId": req.body.product_master_id,
            "productName": req.body.category,
            "category": req.body.type,
            "brand": req.body.brand,
            "type": req.body.product_name,
            "productDetails": {
                "size": req.body.size,
                "color": req.body.color,
                "weight": req.body.weight,
                "specific_details": req.body.specific_details
                
               
            }
            };
          console.log(jsonData);
          api_helper.update_API_call('http://localhost:8081/product-management-app/rest/products',jsonData) 
            .then(response => {
                res.json(response)
            })
            .catch(error => {
                res.send(error)
            })
        })  

module.exports = router;
