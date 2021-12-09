const request = require('request')

module.exports = {
	make_API_call : function(url){
		return new Promise((resolve, reject) => {
			request.get(url, { json: true }, (err, res, body) => {
			  if (err) reject(err)
			  resolve(body)
			});
		})
	},

	add_API_call : function(url,data){
		return new Promise((resolve, reject) => {
			request.post( 
				{
				url: url, 
				body: data,
				json: true }, (err, res, body) => {
			  if (err) reject(err)
			  resolve(body)
			});
		})
	},
	delete_API_call : function(url,data){
		return new Promise((resolve, reject) => {
			request.delete( 
				{
				url: url, 
				body: data,
				json: true }, (err, res, body) => {
			  if (err) reject(err)
			  resolve(body)
			});
		})
	},
	update_API_call : function(url,data){
		return new Promise((resolve, reject) => {
			request.put( 
				{
				url: url, 
				body: data,
				json: true }, (err, res, body) => {
			  if (err) reject(err)
			  resolve(body)
			});
		})
	}
}